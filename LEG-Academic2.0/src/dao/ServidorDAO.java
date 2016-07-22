package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Cargo;
import entidades.Processo;
import entidades.Servidor;

public class ServidorDAO {
	private Connection connection;

	public ServidorDAO() {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void createTable() throws SQLException {
		String sql = "CREATE TABLE servidor ( codServidor  VARCHAR(30) PRIMARY KEY NOT NULL,"
				+ " codCargoServidor VARCHAR(30)," + " codProcessoServidor VARCHAR(30)," + " cargaHoraria TEXT,"
				+ " grau TEXT," + " FOREIGN KEY (codServidor) REFERENCES usuario(codUsuario) ON DELETE CASCADE,"
				+ " FOREIGN KEY (codCargoServidor) REFERENCES cargo(codCargo),"
				+ " FOREIGN KEY (codProcessoServidor) REFERENCES processo(codProcesso)" + " )ENGINE=INNODB";

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void dropTable() throws SQLException {
		String sql = "DROP TABLE leg.servidor";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void add(Servidor s, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

		stmt.setString(1, Servidor.usuario.getCodigo());
		stmt.setString(2, s.getCargaHoraria());
		stmt.setString(3, s.getGrau());
		stmt.execute();
		stmt.close();
	}

	public void remove(Servidor s, String sql) throws SQLException {

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Servidor.usuario.getCodigo());
		stmt.execute();
		stmt.close();
	}

	public void altera(Servidor s, String sql) throws SQLException {

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		if (s.getCargaHoraria() != null)
			stmt.setString(1, s.getCargaHoraria());
		if (s.getGrau() != null)
			stmt.setString(2, s.getGrau());
		if (Servidor.cargo instanceof Cargo)
			stmt.setString(1, Servidor.cargo.getCodigo());
		if (Servidor.processo instanceof Processo)
			stmt.setString(1, Servidor.processo.getCodigo());
		if (Servidor.cargo instanceof Cargo || Servidor.processo instanceof Processo)
			stmt.setString(2, Servidor.usuario.getCodigo());
		if (s.getCargaHoraria() != null)
			stmt.setString(3, Servidor.usuario.getCodigo());

		stmt.execute();
		stmt.close();

	}

	public List<Servidor> lista(Servidor s, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Servidor> servidores = new ArrayList<Servidor>();
		Servidor s2 = new Servidor();
		while (rs.next()) {
			if (s.getCodigo() != null)
				s2.setCargaHoraria(rs.getString("cargaHoraria"));
			if (s.getGrau() != null)
				s2.setGrau(rs.getString("grau"));
			servidores.add(s2);
		}
		rs.close();
		stmt.close();
		return servidores;
	}

	public List<Servidor> listaTodos(String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Servidor> servidores = new ArrayList<Servidor>();

		while (rs.next()) {
			Servidor s = new Servidor(Servidor.usuario);

			s.setCargaHoraria(rs.getString("cargaHoraria"));
			s.setGrau(rs.getString("grau"));
			servidores.add(s);
		}
		rs.close();
		stmt.close();
		return servidores;
	}
}
