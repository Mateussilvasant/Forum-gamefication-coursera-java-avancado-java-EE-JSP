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

@WebServlet("/CadastrarTopico")
public class CadastrarTopico extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	String titulo = request.getParameter("titulo");
	String conteudo = request.getParameter("textTopico");

	Usuario usuario = ((Usuario) request.getSession().getAttribute("usuarioLogado"));

	if (!titulo.isEmpty() && !conteudo.isEmpty())
	{
	    Topico topico = new Topico();
	    topico.setTitulo(titulo);
	    topico.setConteudo(conteudo);
	    topico.setLogin(usuario.getLogin());

	    TopicoService topicoService = new TopicoService();
	    UsuarioService usuarioService = new UsuarioService();

	    try
	    {
		topicoService.inserirTopico(topico);

		usuario.adicionarPontos(10);
		usuarioService.atualizarPontos(usuario);

		request.getSession().setAttribute("usuarioLogado", null);
		request.getSession().setAttribute("usuarioLogado", usuario);
		request.getRequestDispatcher("/ListarTopicos").forward(request, response);

	    } catch (Exception e)
	    {
		e.printStackTrace();
	    }
	}
    }

}
