package controller;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TopicoTO;
import model.Usuario;
import services.TopicoService;
import services.UsuarioService;
import utils.JWTUtil;

/**
 * @author mateussilva
 *
 */
@WebServlet("/FazerLogin")
public class FazerLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private TopicoService topicoService = new TopicoService();
	private UsuarioService usuarioService = new UsuarioService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String senha = request.getParameter("senha");
		String login = request.getParameter("login");

		if (!login.isEmpty() && !senha.isEmpty()) {
			try {

				Usuario usuario = usuarioService.realizarLogin(login, senha);

				if (usuario != null) {

					List<TopicoTO> topicos = topicoService.getListaTopicos();
					topicoService.addConteudoResumidoLista(topicos);

					String token = JWTUtil.criarToken(usuario.getLogin());

					Cookie cookieLogin = new Cookie("authorization", token);
					cookieLogin.setMaxAge(60 * 10);
					cookieLogin.setHttpOnly(true);
					response.addCookie(cookieLogin);


					response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/ListarTopicos"));

				} else {
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}

			} catch (Exception e) {
				request.setAttribute("erroLogin", e.getLocalizedMessage());
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		}

	}

}
