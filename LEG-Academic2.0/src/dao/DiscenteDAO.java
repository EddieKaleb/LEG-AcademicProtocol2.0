package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Curso;
import entidades.Declaracao;
import entidades.Discente;
import entidades.Processo;

public class DiscenteDAO {
	private Connection connection;

	public DiscenteDAO() {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void createTable() throws SQLException {
		String sql = "CREATE TABLE discente (codDiscente  VARCHAR(30) PRIMARY KEY NOT NULL,"
				+ " codCursoDiscente VARCHAR(30)," + " codDeclaracaoDiscente VARCHAR(30),"
				+ " codProcessoDiscente VARCHAR(30)," + " semestre TEXT,"
				+ " FOREIGN KEY (codDiscente) REFERENCES usuario(codUsuario) ON DELETE CASCADE,"
				+ " FOREIGN KEY (codCursoDiscente) REFERENCES curso(codCurso),"
				+ " FOREIGN KEY (codDeclaracaoDiscente) REFERENCES declaracao(codDeclaracao),"
				+ " FOREIGN KEY (codProcessoDiscente) REFERENCES processo(codProcesso)" + " )ENGINE=INNODB";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void dropTable() throws SQLException {
		String sql = "DROP TABLE leg.discente";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void add(Discente d, String sql) throws SQLException {

		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

		stmt.setString(1, Discente.usuario.getCodigo());
		stmt.setString(2, d.getSemestre());
		stmt.execute();
		stmt.close();
	}

	public void remove(Discente d, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, Discente.usuario.getCodigo());
		stmt.execute();
		stmt.close();
	}

	public void altera(Discente d, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

		stmt.setString(1, d.getSemestre());

		if (Discente.declaracao instanceof Declaracao)
			stmt.setString(1, Discente.declaracao.getCodigo());
		if (Discente.processo instanceof Processo)
			stmt.setString(1, Discente.processo.getCodigo());
		if (Discente.curso instanceof Curso)
			stmt.setString(1, Discente.curso.getCodigo());

		stmt.setString(2, Discente.usuario.getCodigo());

		stmt.execute();
		stmt.close();
	}

	public List<Discente> listaTodos(String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();

		List<Discente> discentes = new ArrayList<Discente>();

		while (rs.next()) {
			Discente d = new Discente(Discente.usuario, Discente.curso);
			d.setSemestre(rs.getString("semestre"));
			discentes.add(d);
		}

		rs.close();
		stmt.close();
		return discentes;
	}
}
