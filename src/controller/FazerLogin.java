package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TopicoTO;
import model.Usuario;
import services.TopicoService;
import services.UsuarioService;

@WebServlet("/FazerLogin")
public class FazerLogin extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	String senha = request.getParameter("senha");
	String login = request.getParameter("login");

	if (!login.isEmpty() && !senha.isEmpty())
	{
	    Usuario usuario;
	    try
	    {
		UsuarioService usuarioService = new UsuarioService();
		TopicoService topicoService = new TopicoService();

		usuario = usuarioService.realizarLogin(login, senha);
		List<TopicoTO> topicos = topicoService.getListaTopicos(usuario.getLogin());

		request.getSession().setAttribute("usuarioLogado", usuario);
		request.setAttribute("listaTopicos", topicos);
		request.getRequestDispatcher("index.jsp").forward(request, response);

	    } catch (Exception e)
	    {
		request.setAttribute("erroLogin", e.getLocalizedMessage());
		request.getRequestDispatcher("login.jsp").forward(request, response);
	    }

	}

    }

}
