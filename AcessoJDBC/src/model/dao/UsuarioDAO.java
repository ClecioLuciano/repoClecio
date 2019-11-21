package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.bean.Usuario;

public class UsuarioDAO {

	public void create(Usuario usuario) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("INSERT INTO usuario (id, nome) VALUES (?, ?)");
			stmt.setInt(1, usuario.getID());
			stmt.setString(2, usuario.getNome());

			stmt.executeUpdate();

			System.out.println("Registro  " + usuario + " salvo com sucesso!");

		} catch (SQLException ex) {
			System.out.println("Erro ao tentar salvar " + ex);
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public List<Usuario> readAll() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		List<Usuario> usuarios = new ArrayList<Usuario>();

		try {
			stmt = con.prepareStatement("SELECT * FROM usuario");

			rs = stmt.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();

				usuario.setID(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuarios.add(usuario);
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao tentar consultar os registros do(s) usuário(s). Motivo: " + ex);
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}

		return usuarios;
	}

	public String getHoraBDMySQL() {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String hora = "-------";

		try {
			stmt = con.prepareStatement("SELECT NOW()");

			rs = stmt.executeQuery();

			while (rs.next()) {
				hora = rs.getString("NOW()");
			}

		} catch (SQLException ex) {
			System.out.println("Erro ao tentar consultar os registros do(s) usuário(s). Motivo: " + ex);
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt, rs);
		}
		return hora;
	}

	public void update(Usuario usuario) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("UPDATE usuario SET  NOME =  ?  WHERE id = ?");
			stmt.setString(1, usuario.getNome());
			stmt.setInt(2, usuario.getID());

			stmt.executeUpdate();

			System.out.println("Registro alterado com sucesso!");

		} catch (SQLException ex) {
			System.out.println("Erro ao tentar salvar o registro. Motivo: " + ex);
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

	public void delete(Usuario usuario) {

		Connection con = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;

		try {
			stmt = con.prepareStatement("DELETE FROM usuario WHERE  id = ? AND NOME =  ?");
			stmt.setInt(1, usuario.getID());
			stmt.setString(2, usuario.getNome());

			stmt.executeUpdate();

			System.out.println("Registro excluído com sucesso!");

		} catch (SQLException ex) {
			System.out.println("Erro ao tentar excluir o registro. Motivo: " + ex);
			Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
		} finally {
			ConnectionFactory.closeConnection(con, stmt);
		}
	}

}
