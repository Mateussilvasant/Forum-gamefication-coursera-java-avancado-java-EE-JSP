package model.dao;

import java.util.List;

import dto.TopicoTO;
import model.Topico;

/**
 * @author mateussilva
 *
 */
public interface ITopicoDAO
{
    void inserirTopico(Topico topico) throws Exception;

    List<TopicoTO> getListaTopicos(String login) throws Exception;

    TopicoTO consultarTopico(int id) throws Exception;

    List<TopicoTO> getListaTopicos() throws Exception;

}
