package services;

import java.util.List;

import dto.UsuarioTO;
import model.Usuario;
import model.dao.UsuarioDAO;

public class UsuarioService
{
    private UsuarioDAO dao;

    public UsuarioService()
    {
	dao = new UsuarioDAO();
    }

    public Usuario realizarLogin(String login, String senha) throws Exception
    {
	return dao.realizarLogin(login, senha);
    }

    public void cadastrarUsuario(Usuario usuario) throws Exception
    {
	dao.cadastrarUsuario(usuario);
    }

    public List<UsuarioTO> listarRanking() throws Exception
    {
	return dao.listarRanking();
    }

    public void atualizarPontos(Usuario usuario) throws Exception
    {
	dao.atualizarPontos(usuario);
    }
}
