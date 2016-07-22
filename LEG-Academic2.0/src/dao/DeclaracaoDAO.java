package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Declaracao;
import entidades.Declaracao;

public class DeclaracaoDAO {
	private Connection connection;

	public DeclaracaoDAO() {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void createTable() throws SQLException {
		String sql = "CREATE TABLE declaracao(codDeclaracao  VARCHAR(30)  PRIMARY KEY NOT NULL,"
				+ " statusDeclaracao  TEXT," + " dataDeclaracao DATE,"
				+ " descricaoDeclaracao TEXT" + " )ENGINE=INNODB";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void dropTable() throws SQLException {
		String sql = "DROP TABLE leg.declaracao";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void addAltera(Declaracao d, String sql) throws SQLException {
		java.sql.Date data = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, d.getCodigo());
		stmt.setString(2, d.getStatus());
		stmt.setDate(3, data);
		stmt.setString(4, d.getDescricao());
		stmt.execute();
		stmt.close();
	}

	public void remove(Declaracao d, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, d.getCodigo());
		stmt.execute();
		stmt.close();
	}
	
	public List<Declaracao> listaTodos(String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Declaracao> declaracoes = new ArrayList<Declaracao>();
		Declaracao d = new Declaracao();
		while (rs.next()) {
			d.setCodigo(rs.getString("codDeclaracao"));
			d.setDescricao(rs.getString("descricaoDeclaracao"));
			d.setData(rs.getString("dataDeclaracao"));
			d.setStatus(rs.getString("statusDeclaracao"));
			declaracoes.add(d);
		}
		rs.close();
		stmt.close();
		return declaracoes;
	}
}
