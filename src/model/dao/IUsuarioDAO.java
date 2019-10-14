package model.dao;

import java.util.List;

import dto.UsuarioTO;
import model.Usuario;

/**
 * @author mateussilva
 *
 */
public interface IUsuarioDAO
{
    void cadastrarUsuario(Usuario u) throws Exception;

    Usuario consultarUsuario(String login) throws Exception;

    void atualizarPontos(Usuario usuario) throws Exception;

    Usuario realizarLogin(String login, String senha) throws Exception;

    List<UsuarioTO> listarRanking() throws Exception;
}
