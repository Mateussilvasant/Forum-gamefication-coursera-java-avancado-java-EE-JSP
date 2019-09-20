package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UsuarioTO;
import services.UsuarioService;

@WebServlet("/ListarRanking")
public class ListarRanking extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	UsuarioService usuarioService = new UsuarioService();

	try
	{
	    List<UsuarioTO> ranking = usuarioService.listarRanking();
	    request.setAttribute("listaRanking", ranking);
	    request.getRequestDispatcher("listaRanking.jsp").forward(request, response);

	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

}
