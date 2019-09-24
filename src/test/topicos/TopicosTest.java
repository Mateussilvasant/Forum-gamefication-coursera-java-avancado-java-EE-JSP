package test.topicos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dto.TopicoTO;
import model.Topico;
import model.dao.TopicoDAO;
import test.ResetSequenceOperation;

class TopicosTest
{

    JdbcDatabaseTester databaseTester;
    TopicoDAO topicoDAO;

    @BeforeEach
    void setUp() throws Exception
    {
	try
	{
	    topicoDAO = new TopicoDAO();

	    databaseTester = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
		    "jdbc:mysql://127.0.0.1:3306/forumappbd?useTimezone=true&serverTimezone=America/Sao_Paulo&useSSL=false",
		    "mateus", "fhfhhf234sant");

	    databaseTester.setDataSet(new FlatXmlDataFileLoader().load("/test/topicos/inicio.xml"));
	    databaseTester.onSetup();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

    @Test
    void cadastrarTopico() throws Exception
    {
	Topico topico = new Topico();
	topico.setConteudo("testee 666");
	topico.setLogin("joao32");
	topico.setTitulo("Teste 6");

	topicoDAO.inserirTopico(topico);

	ITable tabelaAtual = databaseTester.getConnection().createDataSet().getTable("topicos");

	ITable tabelaEsperada = new FlatXmlDataFileLoader().load("/test/topicos/inserirTopicoDataSet.xml")
		.getTable("topicos");

	Assertion.assertEquals(tabelaEsperada, tabelaAtual);
    }

    @Test
    void consultarTopico() throws Exception
    {
	int idTopico = 1;

	TopicoTO topicoEsperado = new TopicoTO();
	topicoEsperado.setConteudo("testee 111");
	topicoEsperado.setNomeCriador("Mateus");
	topicoEsperado.setNumeroTopico(1);
	topicoEsperado.setTitulo("Teste 1");

	TopicoTO topico = topicoDAO.consultarTopico(idTopico);

	assertEquals(topicoEsperado.toString(), topico.toString());

    }

    @Test
    public void getListaTopicos() throws Exception
    {
	String login = "will132";
	List<TopicoTO> topicos = topicoDAO.getListaTopicos(login);

	int topicosSizeEsperado = 2;
	int topicosSizeAtual = topicos.size();

	assertEquals(topicosSizeEsperado, topicosSizeAtual);
    }

    @AfterEach
    void reset() throws DatabaseUnitException, SQLException, Exception
    {
	new ResetSequenceOperation(DatabaseOperation.DELETE_ALL).execute(databaseTester.getConnection(),
		databaseTester.getDataSet());
    }

}
