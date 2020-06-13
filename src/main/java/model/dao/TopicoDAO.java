package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.TopicoTO;
import model.Topico;

/**
 * @author mateussilva
 *
 */
public class TopicoDAO implements ITopicoDAO {

	@Override
	public void inserirTopico(Topico topico) throws Exception {
		try (Connection c = ConnectionFactory.getConnection()) {

			String sql = "INSERT INTO topicos(titulo,conteudo,loginT) VALUES((?),(?),(?))";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, topico.getTitulo());
			ps.setString(2, topico.getConteudo());
			ps.setString(3, topico.getLogin());

			if (ps.executeUpdate() == 0) {
				throw new Exception("N�o foi poss�vel cadastrar o t�pico");
			}

		} catch (SQLException e) {
			throw new Exception("Ocorreu um erro interno!", e);
		}
	}

	@Override
	public TopicoTO consultarTopico(int id) throws Exception {

		try (Connection c = ConnectionFactory.getConnection()) {

			String sql = "SELECT t.titulo, t.conteudo, u.nome from\r\n" + "topicos as t inner join usuario as u\r\n"
					+ "on t.loginT = u.login where t.topico = (?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet result = ps.executeQuery();

			if (result.next()) {
				TopicoTO topico = new TopicoTO();
				topico.setNumeroTopico(id);
				topico.setTitulo(result.getString("t.titulo"));
				topico.setNomeCriador(result.getString("u.nome"));
				topico.setConteudo(result.getString("t.conteudo"));
				return topico;
			} else {
				throw new Exception("N�o foi poss�vel localizar o t�pico");
			}

		} catch (SQLException e) {
			throw new Exception("Ocorreu um erro interno!" + e, e);
		}

	}

	@Override
	public List<TopicoTO> getListaTopicos(String login) throws Exception {

		List<TopicoTO> listaTopicos = new ArrayList<>();

		try (Connection c = ConnectionFactory.getConnection()) {

			String sql = "SELECT t.topico, t.titulo, t.conteudo, u.nome from\r\n"
					+ "topicos as t inner join usuario as u\r\n" + "on t.loginT = u.login where u.login = (?)";

			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, login);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				TopicoTO topico = new TopicoTO();
				topico.setNumeroTopico(result.getInt("t.topico"));
				topico.setTitulo(result.getString("t.titulo"));
				topico.setNomeCriador(result.getString("u.nome"));
				topico.setConteudo(result.getString("t.conteudo"));
				listaTopicos.add(topico);
			}

		} catch (SQLException e) {
			throw new Exception("Ocorreu um erro interno! - " + e.toString(), e);
		}

		return listaTopicos;
	}

	@Override
	public List<TopicoTO> getListaTopicos() throws Exception {
		List<TopicoTO> listaTopicos = new ArrayList<>();

		try (Connection c = ConnectionFactory.getConnection()) {

			String sql = "SELECT t.topico, t.titulo, t.conteudo, u.nome from\r\n"
					+ "topicos as t inner join usuario as u\r\n" + "on t.loginT = u.login order by t.topico DESC";

			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet result = ps.executeQuery();

			while (result.next()) {
				TopicoTO topico = new TopicoTO();
				topico.setNumeroTopico(result.getInt("t.topico"));
				topico.setTitulo(result.getString("t.titulo"));
				topico.setNomeCriador(result.getString("u.nome"));
				topico.setConteudo(result.getString("t.conteudo"));
				listaTopicos.add(topico);
			}

		} catch (SQLException e) {
			throw new Exception("Ocorreu um erro interno! - " + e.toString(), e);
		}

		return listaTopicos;
	}

}
