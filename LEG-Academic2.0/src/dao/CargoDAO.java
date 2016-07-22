package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Cargo;
import entidades.Cargo;

public class CargoDAO {
	private Connection connection;

	public CargoDAO() {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void createTable() {
		String sql = "CREATE TABLE cargo(" 
				+ " codCargo  VARCHAR(30) PRIMARY KEY NOT NULL,"
				+ " nome TEXT,"
				+ " ramal TEXT,"
				+ " descricao TEXT"
				+ " )ENGINE=INNODB";

		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void dropTable() {
		String sql = "DROP TABLE leg.cargo";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void add(Cargo c, String sql) throws SQLException {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, c.getCodigo());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getRamal());
			stmt.setString(4, c.getDescricao());
							
			stmt.execute();
			stmt.close();
	}

	public void remove(Cargo c, String sql) throws SQLException {
		
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			stmt.setString(1, c.getCodigo());
			stmt.execute();
			stmt.close();
	}

	public void altera(Cargo c, String sql) throws SQLException {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, c.getCodigo());
			stmt.setString(2, c.getNome());
			stmt.setString(3, c.getRamal());
			stmt.setString(4, c.getDescricao());
			stmt.execute();
			stmt.close();

	}
	
	public List<Cargo> listaTodos(String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Cargo> cargos = new ArrayList<Cargo>();
		Cargo c = new Cargo();
		while (rs.next()) {
			c.setCodigo(rs.getString("codCargo"));
			c.setNome(rs.getString("nome"));
			c.setRamal(rs.getString("ramal"));
			c.setDescricao(rs.getString("descricao"));
			cargos.add(c);
		}
		rs.close();
		stmt.close();
		return cargos;
	}

}
