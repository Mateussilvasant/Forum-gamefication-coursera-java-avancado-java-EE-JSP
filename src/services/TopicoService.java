package services;

import java.util.List;

import dto.TopicoTO;
import model.Topico;
import model.dao.TopicoDAO;

public class TopicoService
{

    private TopicoDAO topicoDAO;

    public TopicoService()
    {
	topicoDAO = new TopicoDAO();
    }

    public void inserirTopico(Topico topico) throws Exception
    {
	topicoDAO.inserirTopico(topico);
    }

    public List<TopicoTO> getListaTopicos(String login) throws Exception
    {
	return topicoDAO.getListaTopicos(login);
    }

    public TopicoTO consultarTopico(int idTopico) throws Exception
    {
	return topicoDAO.consultarTopico(idTopico);
    }
}
