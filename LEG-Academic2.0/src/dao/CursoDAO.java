package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Curso;
import entidades.Curso;

public class CursoDAO {
	private Connection connection;

	public CursoDAO() {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void createTable() throws SQLException {
		String sql = "CREATE TABLE curso(codCurso  VARCHAR(30) PRIMARY KEY NOT NULL,"
				+ " nome TEXT," + " ementa TEXT," + " cargaHoraria TEXT,"
				+ " descricao TEXT" + " )ENGINE=INNODB";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void dropTable() throws SQLException {
		String sql = "DROP TABLE leg.curso";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void add(Curso c, String sql) throws SQLException {

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

		stmt.setString(1, c.getCodigo());
		stmt.setString(2, c.getNome());
		stmt.setString(3, c.getEmenta());
		stmt.setString(4, c.getCargaHoraria());
		stmt.setString(5, c.getDescricao());

		stmt.execute();
		stmt.close();

	}

	public void remove(Curso c, String sql) throws SQLException {

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

		stmt.setString(1, c.getCodigo());
		stmt.execute();
		stmt.close();

	}

	public void altera(Curso c, String sql) throws SQLException {

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, c.getCodigo());
		stmt.setString(2, c.getNome());
		stmt.setString(3, c.getEmenta());
		stmt.setString(4, c.getCargaHoraria());
		stmt.setString(5, c.getDescricao());
		stmt.execute();
		stmt.close();
	}

	public List<Curso> listaTodos(String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Curso> cursos = new ArrayList<Curso>();
		Curso c = new Curso();
		while (rs.next()) {
			c.setCodigo(rs.getString("codCargo"));
			c.setNome(rs.getString("nome"));
			c.setEmenta(rs.getString("ementa"));
			c.setCargaHoraria(rs.getString("cargaHoraria"));
			c.setDescricao(rs.getString("descricao"));
			cursos.add(c);
		}
		rs.close();
		stmt.close();
		return cursos;
	}

}
