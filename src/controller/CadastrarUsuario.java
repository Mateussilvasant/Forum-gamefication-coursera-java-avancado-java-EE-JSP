package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import services.UsuarioService;

@WebServlet("/CadastrarUsuario")
public class CadastrarUsuario extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	String nome = request.getParameter("nome");
	String email = request.getParameter("email");
	String senha = request.getParameter("senha");
	String login = request.getParameter("login");

	Usuario usuario = new Usuario();
	usuario.setEmail(email);
	usuario.setLogin(login);
	usuario.setSenha(senha);
	usuario.setNome(nome);

	UsuarioService service = new UsuarioService();

	try
	{
	    service.cadastrarUsuario(usuario);

	    response.sendRedirect(request.getContextPath() + "/login.jsp?cadastroUsuarioSucesso=sucesso");

	} catch (Exception e)
	{
	    request.getRequestDispatcher("cadastrarUsuario.jsp").forward(request, response);
	}
    }

}
