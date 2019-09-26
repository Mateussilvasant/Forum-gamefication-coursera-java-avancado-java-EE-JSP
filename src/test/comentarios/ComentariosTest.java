package test.comentarios;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.operation.DatabaseOperation;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import dto.ComentarioTO;
import model.Comentario;
import model.dao.ComentarioDAO;
import test.ResetSequenceOperation;

class ComentariosTest
{

    JdbcDatabaseTester database;
    ComentarioDAO comentarioDAO;

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
    void setUp() throws Exception
    {

	try
	{
	    comentarioDAO = new ComentarioDAO();

	    database = new JdbcDatabaseTester("com.mysql.cj.jdbc.Driver",
		    "jdbc:mysql://127.0.0.1:3306/forumappbd?useTimezone=true&serverTimezone=America/Sao_Paulo&useSSL=false",
		    "mateus", "fhfhhf234sant");

	    database.setDataSet(new FlatXmlDataFileLoader().load("/test/comentarios/inicio.xml"));
	    database.onSetup();

	} catch (Exception e)
	{
	    e.printStackTrace();
	}

    }

    @Test
    void cadastrarComentario() throws Exception
    {

	String login = "matsant133";

	Comentario comentario = new Comentario();
	comentario.setConteudo("teste comentario 6");
	comentario.setNumeroTopico(4);

	comentarioDAO.cadastrarComentario(comentario, login);

	ITable tabelaAtual = database.getConnection().createDataSet().getTable("comentarios");

	ITable tabelaEsperada = new FlatXmlDataFileLoader().load("/test/comentarios/inserirComentarioDataSet.xml")
		.getTable("comentarios");

	Assertion.assertEquals(tabelaEsperada, tabelaAtual);

    }

    @Test
    public void getListaComentarios() throws Exception
    {
	List<ComentarioTO> lista = comentarioDAO.getListaComentarios(4);

	int listaSizeEsperado = 2;
	int listaSizeAtual = lista.size();

	assertEquals(listaSizeEsperado, listaSizeAtual);
    }

    @AfterEach
    public void reset() throws Exception
    {
	new ResetSequenceOperation(DatabaseOperation.DELETE_ALL).execute(database.getConnection(),
		database.getDataSet());
    }

}
