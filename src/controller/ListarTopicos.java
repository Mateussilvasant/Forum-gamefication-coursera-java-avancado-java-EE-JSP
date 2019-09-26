package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TopicoTO;
import model.Usuario;
import services.TopicoService;

@WebServlet("/ListarTopicos")
public class ListarTopicos extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
	doExecute(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
	doExecute(req, resp);
    }

    public void doExecute(HttpServletRequest request, HttpServletResponse response) throws IOException
    {
	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	try
	{

	    TopicoService topicoService = new TopicoService();

	    List<TopicoTO> topicos = topicoService.getListaTopicos();
	    topicoService.addConteudoResumidoLista(topicos);

	    request.setAttribute("listaTopicos", topicos);
	    request.getRequestDispatcher("index.jsp").forward(request, response);

	} catch (Exception e)
	{
	    response.sendRedirect(response.encodeRedirectURL(
		    request.getContextPath() + "/ListarTopicos?topicosResult=" + e.getLocalizedMessage()));
	}
    }

}
