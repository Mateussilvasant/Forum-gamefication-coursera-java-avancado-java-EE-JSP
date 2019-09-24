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
import services.UsuarioService;

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
	
	req.setCharacterEncoding("utf-8");
	resp.setCharacterEncoding("utf-8");
	
	try
	{
	    Usuario usuario = ((Usuario) req.getSession().getAttribute("usuarioLogado"));
	    int idTopico = Integer.parseInt(req.getParameter("idTopico"));
	    String conteudo = req.getParameter("textoComentario");

	    ComentarioService comentarioService = new ComentarioService();
	    UsuarioService usuarioService = new UsuarioService();

	    /* Adiciona o comentário ao banco de dados */
	    Comentario comentario = new Comentario();
	    comentario.setConteudo(conteudo);
	    comentario.setNumeroTopico(idTopico);
	    comentarioService.cadastrarComentario(comentario, usuario.getLogin());

	    /* Adiciona os pontos e atualiza */
	    usuario.adicionarPontos(3);
	    usuarioService.atualizarPontos(usuario);

	    /* Atualiza o usuário da sessão */
	    req.getSession().setAttribute("usuarioLogado", null);
	    req.getSession().setAttribute("usuarioLogado", usuario);

	    resp.sendRedirect(resp.encodeRedirectURL(req.getServletContext().getContextPath() + "/ExibirTopico?topicoID=" + idTopico));


	} catch (NumberFormatException e)
	{
	    e.printStackTrace();
	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

}
