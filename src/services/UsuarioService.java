package services;

import java.util.List;

import dto.UsuarioTO;
import model.Usuario;
import model.dao.UsuarioDAO;

/**
 * @author mateussilva
 *
 */
public class UsuarioService
{
    private UsuarioDAO dao;

    public UsuarioService()
    {
	dao = new UsuarioDAO();
    }

    /**
     * @param login
     * @param senha
     * @return retorna o usuario autenticado no banco de dados
     * @throws Exception
     */
    public Usuario realizarLogin(String login, String senha) throws Exception
    {
	return dao.realizarLogin(login, senha);
    }

    /**
     * Realiza cadastro do usuario no banco de dados
     * 
     * @param usuario
     * @throws Exception
     */
    public void cadastrarUsuario(Usuario usuario) throws Exception
    {
	dao.cadastrarUsuario(usuario);
    }

    /**
     * @return retorna a lista de ranking de usuarios.
     * @throws Exception
     */
    public List<UsuarioTO> listarRanking() throws Exception
    {
	return dao.listarRanking();
    }

    /**
     * Atualiza os pontos do usuario
     * 
     * @param usuario
     * @throws Exception
     */
    public void atualizarPontos(Usuario usuario) throws Exception
    {
	dao.atualizarPontos(usuario);
    }
}
