package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Comentario;
import model.Usuario;
import services.ComentarioService;

/**
 * Servlet implementation class CadastrarComentario
 */
@WebServlet("/CadastrarComentario")
public class CadastrarComentario extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * Recebe a requisição com dados do comentário, cadastra comentário e
     * redireciona para controller ExibirTopico
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {

	try
	{
	    String login = ((Usuario) req.getSession().getAttribute("usuarioLogado")).getLogin();
	    int idTopico = Integer.parseInt(req.getParameter("idTopico"));
	    String conteudo = req.getParameter("textoComentario");

	    ComentarioService comentarioService = new ComentarioService();

	    Comentario comentario = new Comentario();
	    comentario.setConteudo(conteudo);
	    comentario.setNumeroTopico(idTopico);

	    comentarioService.cadastrarComentario(comentario, login);

	    req.setAttribute("topicoID", idTopico);
	    req.getRequestDispatcher("/ExibirTopico").forward(req, resp);

	} catch (NumberFormatException e)
	{
	    e.printStackTrace();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

}
