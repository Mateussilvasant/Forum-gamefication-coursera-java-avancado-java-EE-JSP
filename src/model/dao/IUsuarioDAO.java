package model.dao;

import java.util.List;

import model.Usuario;

public interface IUsuarioDAO
{
    void cadastrarUsuario(Usuario u) throws Exception;

    Usuario consultarUsuario(String login) throws Exception;

    void adicionarPontos(String login, int pontos) throws Exception;

    Usuario realizarLogin(String login, String senha) throws Exception;

    List<Usuario> getRanking() throws Exception;
}
