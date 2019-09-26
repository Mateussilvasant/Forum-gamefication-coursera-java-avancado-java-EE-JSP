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

    /**
     * Insere o tópico no banco de Dados
     * 
     * @param topico
     * @throws Exception
     */
    public void inserirTopico(Topico topico) throws Exception
    {
	topicoDAO.inserirTopico(topico);
    }

    /**
     * 
     * @param login
     * @return retorna uma lista de tópicos do usuário
     * @throws Exception
     */
    public List<TopicoTO> getListaTopicos(String login) throws Exception
    {
	return topicoDAO.getListaTopicos(login);
    }

    /**
     * @return retorna todos os tópicos do fórum
     * @throws Exception
     */
    public List<TopicoTO> getListaTopicos() throws Exception
    {
	return topicoDAO.getListaTopicos();
    }

    /**
     * @param idTopico
     * @return retorna o tópico dado um ID
     * @throws Exception
     */
    public TopicoTO consultarTopico(int idTopico) throws Exception
    {
	return topicoDAO.consultarTopico(idTopico);
    }

    /**
     * adiciona a lista o resumo do conteudo de cada tópico.
     * 
     * @param topicos
     */
    public void addConteudoResumidoLista(List<TopicoTO> topicos)
    {
	topicos.forEach(t -> adicionarConteudoResumido(t));
    }

    /**
     * adiciona resumo do conteudo do tópico.
     * 
     * @param topicos
     */
    public void adicionarConteudoResumido(TopicoTO topico)
    {
	String conteudo = topico.getConteudo();
	topico.setConteudoResumido(conteudo.substring(0, (int) (conteudo.length() * 0.40)) + "...");
    }
}
