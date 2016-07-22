package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Administrador;
import entidades.Servidor;

public class AdministradorDAO {
	private Connection connection;

	public AdministradorDAO() {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void createTable() throws SQLException {
		String sql = "CREATE TABLE administrador (codAdministrador VARCHAR(30) PRIMARY KEY NOT NULL,"
				+ " login  VARCHAR(30) NOT NULL," + " senha VARCHAR(30) NOT NULL,"
				+ " FOREIGN KEY (codAdministrador) REFERENCES usuario(codUsuario) ON DELETE CASCADE"
				+ " )ENGINE=INNODB";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void dropTable() throws SQLException {
		String sql = "DROP TABLE leg.administrador";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void add(Administrador a, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Administrador.usuario.getCodigo());
		stmt.setString(2, a.getLogin());
		stmt.setString(3, a.getSenha());

		stmt.execute();
		stmt.close();
	}

	public void remove(Administrador a, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Administrador.usuario.getCodigo());
		stmt.execute();
		stmt.close();
	}

	public void altera(Administrador a, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

		stmt.setString(1, a.getLogin());
		stmt.setString(2, a.getSenha());
		stmt.setString(2, Administrador.usuario.getCodigo());
		stmt.execute();
		stmt.close();
	}

	public List<Administrador> listaTodos(String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		List<Administrador> administradores = new ArrayList<Administrador>();

		while (rs.next()) {
			Administrador a = new Administrador(Administrador.usuario);
			a.setLogin(rs.getString("login"));
			a.setSenha(rs.getString("senha"));
			administradores.add(a);
		}
		rs.close();
		stmt.close();
		return administradores;
	}

}
