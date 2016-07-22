package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Processo;
import entidades.Servidor;

public class ProcessoDAO {
	private Connection connection;

	public ProcessoDAO() {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void createTable() throws SQLException {
		String sql = "CREATE TABLE processo( codProcesso  VARCHAR(30) PRIMARY KEY NOT NULL," 
				+ " statusProcesso  TEXT," + " dataProcesso DATE," + " tipoProcesso TEXT," + " descricaoProcesso TEXT"
				+ " )ENGINE=INNODB";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void dropTable() throws SQLException {
		String sql = "DROP TABLE leg.processo";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void addAltera(Processo p, String sql) throws SQLException {
		java.sql.Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, p.getCodigo());
		stmt.setString(2, p.getStatus());
		stmt.setDate(3, data);
		stmt.setString(4, p.getTipo());
		stmt.setString(5, p.getDescricao());
		stmt.execute();
		stmt.close();
	}

	public void remove(Processo p, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, p.getCodigo());
		stmt.execute();
		stmt.close();
	}

	public List<Processo> listaTodos(String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Processo> processos = new ArrayList<Processo>();
		Processo p = new Processo();
		while (rs.next()) {
			p.setCodigo(rs.getString("codProcesso"));
			p.setDescricao(rs.getString("descricaoProcesso"));
			p.setData(rs.getString("dataProcesso"));
			p.setTipo(rs.getString("tipoProcesso"));
			p.setStatus(rs.getString("statusProcesso"));
			processos.add(p);
		}
		rs.close();
		stmt.close();
		return processos;
	}
}
