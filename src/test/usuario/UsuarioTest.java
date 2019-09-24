package test.usuario;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.UsuarioTO;
import model.Usuario;
import model.dao.UsuarioDAO;

class UsuarioTest
{

    private JdbcDatabaseTester databaseTester;
    private UsuarioDAO usuarioDao;

    static
    {
	try
	{
	    Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e)
	{
	    e.printStackTrace();
	}
    }

    @BeforeEach
    void setUp()
    {
	try
	{
	    usuarioDao = new UsuarioDAO();

	    databaseTester = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
		    "jdbc:mysql://127.0.0.1:3306/forumappbd?useTimezone=true&serverTimezone=America/Sao_Paulo&useSSL=false",
		    "mateus", "fhfhhf234sant");

	    FlatXmlDataFileLoader xml = new FlatXmlDataFileLoader();
	    databaseTester.setDataSet(xml.load("/test/usuario/inicio.xml"));
	    databaseTester.onSetup();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}

    }

    /* Testa se o usuario foi inserido corretamente */
    @Test
    void cadastrarUsuario() throws SQLException, Exception
    {
	Usuario usuario = new Usuario();
	usuario.setLogin("roberto123");
	usuario.setNome("Roberto");
	usuario.setSenha("hh32h32");
	usuario.setEmail("roberto13@gmail.com");
	usuario.setPontos(4);

	usuarioDao.cadastrarUsuario(usuario);

	IDataSet datasetUsuarioInserir = databaseTester.getConnection().createDataSet();
	ITable tabelaAtual = datasetUsuarioInserir.getTable("usuario");

	FlatXmlDataFileLoader xml = new FlatXmlDataFileLoader();
	ITable tabelaEsperada = xml.load("/test/usuario/inserirUsuarioDataSet.xml").getTable("usuario");

	Assertion.assertEquals(tabelaEsperada, tabelaAtual);
    }

    /* Testa se usuario recuperado está correto */
    @Test
    void consultarUsuario() throws SQLException, Exception
    {

	Usuario usuarioEsperado = new Usuario();
	usuarioEsperado.setLogin("matsant133");
	usuarioEsperado.setNome("Mateus");
	usuarioEsperado.setSenha("fasfm32");
	usuarioEsperado.setEmail("matsan@gmail.com");
	usuarioEsperado.setPontos(100);

	Usuario usuarioRetorno = usuarioDao.consultarUsuario(usuarioEsperado.getLogin());

	assertEquals(usuarioRetorno.toString(), usuarioEsperado.toString());

    }

    /* Testa se os pontos foram calculados corretamente */
    @Test
    public void atualizarPontos() throws SQLException, Exception
    {

	Usuario usuario = new Usuario();
	usuario.setLogin("will132");
	usuario.setNome("William");
	usuario.setSenha("mn222");
	usuario.setEmail("willfasn@gmail.com");
	usuario.setPontos(29);

	usuario.adicionarPontos(3);
	usuarioDao.atualizarPontos(usuario);

	IDataSet databaseAtual = databaseTester.getConnection().createDataSet();
	ITable tabelaAtual = databaseAtual.getTable("usuario");

	FlatXmlDataFileLoader xml = new FlatXmlDataFileLoader();
	ITable tabelaEsperada = xml.load("/test/usuario/adicionarPontosDataSet.xml").getTable("usuario");

	Assertion.assertEquals(tabelaEsperada, tabelaAtual);

    }

    @Test
    public void realizarLogin() throws Exception
    {

	Usuario usuarioEsperado = new Usuario();
	usuarioEsperado.setLogin("joao32");
	usuarioEsperado.setNome("Joao");
	usuarioEsperado.setSenha("23j3n2");
	usuarioEsperado.setEmail("joan@gmail.com");
	usuarioEsperado.setPontos(59);

	String inputLogin = "joao32";
	String inputSenha = "23j3n2";

	Usuario usuarioRetorno = usuarioDao.realizarLogin(inputLogin, inputSenha);

	assertEquals(usuarioRetorno.toString(), usuarioEsperado.toString());
    }

    /* Testa se a lista esta ordenada */
    @Test
    public void listarRanking() throws Exception
    {
	List<UsuarioTO> ranking = usuarioDao.listarRanking();
	boolean ordenadoEsperado = true;
	boolean ordenadoAtual = true;

	if (!ranking.isEmpty())
	{

	    UsuarioTO anterior = ranking.get(0);

	    for (UsuarioTO u : ranking)
	    {

		if (ordenadoAtual == false)
		{
		    break;
		} else
		{

		    if (u == anterior)
		    {
			anterior = u;
		    } else
		    {

			if (anterior.getPontos() >= u.getPontos())
			{
			    ordenadoAtual = true;
			} else
			{
			    ordenadoAtual = false;
			}

		    }
		}
	    }

	}

	assertEquals("Lista não ordenada por maior ranking", ordenadoEsperado, ordenadoAtual);

    }

    @AfterEach
    public void reset() throws Exception
    {
	DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), databaseTester.getDataSet());
    }

}
