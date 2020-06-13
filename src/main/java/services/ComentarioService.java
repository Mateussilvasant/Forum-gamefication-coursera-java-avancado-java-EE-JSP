package services;

import java.util.List;

import dto.ComentarioTO;
import model.Comentario;
import model.dao.ComentarioDAO;

/**
 * @author mateussilva
 *
 */
public class ComentarioService
{
    private ComentarioDAO comentarioDAO;

    public ComentarioService()
    {
	comentarioDAO = new ComentarioDAO();
    }

    /**
     * Realiza o cadastro do coemntario feito pelo usuário no Banco de Dados
     * 
     * @param comentario
     * @param login
     * @throws Exception
     */
    public void cadastrarComentario(Comentario comentario, String login) throws Exception
    {
	comentarioDAO.cadastrarComentario(comentario, login);
    }

    /**
     * @param numeroTopico
     * @return retorna uma lista de coemntarios do tópico.
     * @throws Exception
     */
    public List<ComentarioTO> getListaComentarios(int numeroTopico) throws Exception
    {
	return comentarioDAO.getListaComentarios(numeroTopico);
    }
}
