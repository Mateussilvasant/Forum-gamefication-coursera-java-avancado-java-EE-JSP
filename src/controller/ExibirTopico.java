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

@WebServlet("/ExibirTopico")
public class ExibirTopico extends HttpServlet
{
    private static final long serialVersionUID = 1L;

    private void doExecute(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException
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

	} catch (NumberFormatException e)
	{
	    e.printStackTrace();
	}

	TopicoService topicoService = new TopicoService();
	ComentarioService comentarioService = new ComentarioService();

	try
	{
	    TopicoTO topico = topicoService.consultarTopico(idTopico);
	    topico = topicoService.adicionarConteudoResumido(topico);
	    topico.setListaComentarios(comentarioService.getListaComentarios(topico.getNumeroTopico()));

	    req.setAttribute("topico", topico);
	    req.getRequestDispatcher("exibirTopico.jsp").forward(req, resp);

	} catch (Exception e)
	{
	    e.printStackTrace();
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
