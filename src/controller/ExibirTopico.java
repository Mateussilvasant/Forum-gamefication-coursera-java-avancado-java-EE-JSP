package controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.TopicoTO;
import services.ComentarioService;
import services.TopicoService;

/**
 * @author mateussilva
 *
 */
@WebServlet("/ExibirTopico")
public class ExibirTopico extends HttpServlet
{
    private static final long serialVersionUID = 1L;
    private TopicoService topicoService = new TopicoService();
    private ComentarioService comentarioService = new ComentarioService();

    private void doExecute(HttpServletRequest req, HttpServletResponse resp) throws IOException
    {

	req.setCharacterEncoding("utf-8");
	resp.setCharacterEncoding("utf-8");

	int idTopico = 0;

	try
	{

	    if (req.getMethod().equals("POST"))
	    {
		idTopico = (int) req.getAttribute("topicoID");

	    } else
	    {
		idTopico = Integer.parseInt(req.getParameter("topicoID"));

	    }

	    TopicoTO topico = topicoService.consultarTopico(idTopico);
	    topico.setListaComentarios(comentarioService.getListaComentarios(topico.getNumeroTopico()));

	    req.setAttribute("topico", topico);
	    req.getRequestDispatcher("exibirTopico.jsp").forward(req, resp);

	} catch (Exception e)
	{
	    e.printStackTrace();
	    resp.sendRedirect(resp.encodeRedirectURL(
		    req.getContextPath() + "/ListarTopicos?exibirResult=" + e.getLocalizedMessage()));
	}

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
	doExecute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
	doExecute(req, resp);
    }

}
