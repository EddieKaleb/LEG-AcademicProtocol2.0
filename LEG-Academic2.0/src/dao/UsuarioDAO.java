package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.ConnectionFactory;
import entidades.Usuario;

public class UsuarioDAO {
	private Connection connection;

	public UsuarioDAO() {
		this.connection = (Connection) new ConnectionFactory().getConnection();
	}

	public void createTable() throws SQLException {
		String sql = "CREATE TABLE usuario (codUsuario VARCHAR(30) PRIMARY KEY NOT NULL," + " nome TEXT,"
				+ " dtNascimento TEXT," + " cpf VARCHAR(14) UNIQUE," + " endereco TEXT," + " telefone TEXT," + " email VARCHAR(100) UNIQUE"
				+ " )ENGINE=INNODB";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void dropTable() throws SQLException {
		String sql = "DROP TABLE leg.usuario";
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.execute();
		stmt.close();
	}

	public void add(Usuario u, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, u.getCodigo());
		stmt.setString(2, u.getNome());
		stmt.setString(3, u.getDtNascimento());
		stmt.setString(4, u.getCpf());
		stmt.setString(5, u.getEndereco());
		stmt.setString(6, u.getTelefone());
		stmt.setString(7, u.getEmail());
		stmt.execute();
		stmt.close();
	}

	public void remove(Usuario u, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, u.getCodigo());
		stmt.execute();
		stmt.close();
	}

	public void altera(Usuario u, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
		stmt.setString(1, u.getNome());
		stmt.setString(2, u.getDtNascimento());
		stmt.setString(3, u.getCpf());
		stmt.setString(4, u.getEndereco());
		stmt.setString(5, u.getTelefone());
		stmt.setString(6, u.getEmail());
		stmt.setString(7, u.getCodigo());
		stmt.execute();
		stmt.close();
	}
	
	public List<Usuario> lista(Usuario u, String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u2 = new Usuario();
		while (rs.next()) {
			if(u.getCodigo() != null)
			u2.setCodigo(rs.getString("codUsuario"));
			if(u.getNome() != null)
			u2.setNome(rs.getString("nome"));
			if(u.getEmail() != null)
			u2.setEmail(rs.getString("email"));
			if(u.getEndereco() != null)
			u2.setEndereco(rs.getString("endereco"));
			if(u.getCpf() != null)
			u2.setCpf(rs.getString("cpf"));
			if(u.getTelefone() != null)
			u2.setTelefone(rs.getString("telefone"));
			if(u.getDtNascimento() != null)
			u2.setDtNascimento(rs.getString("dtNascimento"));
			usuarios.add(u2);
		}
		rs.close();
		stmt.close();
		return usuarios;
	}
	public List<Usuario> listaTodos(String sql) throws SQLException {
		PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement(sql);
		ResultSet rs = stmt.executeQuery();
		List<Usuario> usuarios = new ArrayList<Usuario>();
		Usuario u = new Usuario();
		while (rs.next()) {
			u.setCodigo(rs.getString("codUsuario"));
			u.setNome(rs.getString("nome"));
			u.setEmail(rs.getString("email"));
			u.setEndereco(rs.getString("endereco"));
			u.setCpf(rs.getString("cpf"));
			u.setTelefone(rs.getString("telefone"));
			u.setDtNascimento(rs.getString("dtNascimento"));
			usuarios.add(u);
		}
		rs.close();
		stmt.close();
		return usuarios;
	}

}
