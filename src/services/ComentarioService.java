package services;

import java.util.List;

import dto.ComentarioTO;
import model.Comentario;
import model.dao.ComentarioDAO;

public class ComentarioService
{
    private ComentarioDAO comentarioDAO;

    public ComentarioService()
    {
	comentarioDAO = new ComentarioDAO();
    }

    public void cadastrarComentario(Comentario comentario, String login) throws Exception
    {
	comentarioDAO.cadastrarComentario(comentario, login);
    }

    public List<ComentarioTO> getListaComentarios(int numeroTopico) 
    {
	return comentarioDAO.getListaComentarios(numeroTopico);
    }
}
