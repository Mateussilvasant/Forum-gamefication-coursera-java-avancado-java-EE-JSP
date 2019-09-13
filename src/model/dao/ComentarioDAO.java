package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ComentarioTO;
import model.Comentario;

public class ComentarioDAO implements IComentarioDAO
{

    @Override
    public List<ComentarioTO> getListaComentarios(int numeroTopico) 
    {
	List<ComentarioTO> comentarios = new ArrayList<>();

	try (Connection c = ConnectionFactory.getConnection())
	{

	    String sql = "SELECT u.nome, c.conteudo from comentarios c inner join usuario u \r\n"
		    + "on c.login = u.login where c.topico = (?)";

	    PreparedStatement ps = c.prepareStatement(sql);
	    ps.setInt(1, numeroTopico);

	    ResultSet result = ps.executeQuery();

	    while (result.next())
	    {
		ComentarioTO comentario = new ComentarioTO();
		comentario.setConteudo(result.getString("c.conteudo"));
		comentario.setNomeCriador(result.getString("u.nome"));
		comentarios.add(comentario);
	    }

	} catch (SQLException e)
	{
	    e.printStackTrace();
	}

	return comentarios;
    }

    @Override
    public void cadastrarComentario(Comentario comentario, String login) throws Exception
    {
	try (Connection c = ConnectionFactory.getConnection())
	{

	    String sql = "INSERT INTO comentarios(conteudo,topico,login) VALUES ((?),(?),(?))";
	    PreparedStatement ps = c.prepareStatement(sql);
	    ps.setString(1, comentario.getConteudo());
	    ps.setInt(2, comentario.getNumeroTopico());
	    ps.setString(3, login);

	    if (ps.executeUpdate() == 0)
	    {
		throw new Exception("Não foi possível fazer o comentário");
	    }

	} catch (SQLException e)
	{
	    throw new Exception("Ocorreu um erro interno!", e);
	}
    }

}
