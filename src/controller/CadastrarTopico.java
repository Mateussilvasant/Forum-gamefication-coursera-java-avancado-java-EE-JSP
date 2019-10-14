package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Topico;
import model.Usuario;
import services.TopicoService;
import services.UsuarioService;

/**
 * @author mateussilva
 *
 */
@WebServlet("/CadastrarTopico")
public class CadastrarTopico extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private TopicoService topicoService = new TopicoService();
    private UsuarioService usuarioService = new UsuarioService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	String titulo = request.getParameter("titulo");
	String conteudo = request.getParameter("textTopico");

	Usuario usuario = ((Usuario) request.getSession().getAttribute("usuarioLogado"));

	if (!titulo.isEmpty() && !conteudo.isEmpty())
	{
	    Topico topico = new Topico();
	    topico.setTitulo(titulo);
	    topico.setConteudo(conteudo);
	    topico.setLogin(usuario.getLogin());

	    try
	    {
		topicoService.inserirTopico(topico);

		usuario.adicionarPontos(10);
		usuarioService.atualizarPontos(usuario);

		request.getSession().setAttribute("usuarioLogado", null);
		request.getSession().setAttribute("usuarioLogado", usuario);

		response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/ListarTopicos"));

	    } catch (Exception e)
	    {
		e.printStackTrace();
		response.sendRedirect(response.encodeRedirectURL(
			request.getContextPath() + "/cadastrarTopico.jsp?erroCadastro=" + e.getLocalizedMessage()));
	    }
	}
    }

}
