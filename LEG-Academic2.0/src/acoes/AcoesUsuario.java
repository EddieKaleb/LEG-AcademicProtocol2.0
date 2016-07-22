package acoes;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dao.UsuarioDAO;
import entidades.Usuario;
import excecoes.RegexException;
import util.ValidacaoUsuario;

public class AcoesUsuario {
	private ValidacaoUsuario validacao;

	public AcoesUsuario() {
		validacao = new ValidacaoUsuario();
	}

	public void cadastro(Usuario u) {
		String sql = "INSERT INTO leg.usuario" + "(codUsuario,nome,dtNascimento,cpf,endereco,telefone,email)"
				+ "VALUES(?,?,?,?,?,?,?)";
		try {
			validacao.validaDadosDoUsuario(u);
			UsuarioDAO dao = new UsuarioDAO();
			dao.add(u, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void remove(Usuario u) {
		String sql = "DELETE FROM leg.usuario WHERE codUsuario=?";
		try {
			UsuarioDAO dao = new UsuarioDAO();
			dao.remove(u, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void altera(Usuario u) {
		String sql = "UPDATE leg.usuario" + " SET nome=?,dtNascimento=?,cpf=?,endereco=?,telefone=?,email=?"
				+ " WHERE codUsuario=?";
		try {
			validacao.validaDadosDoUsuario(u);
			UsuarioDAO dao = new UsuarioDAO();
			dao.altera(u, sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void listaTodos() {
		String sql = "SELECT * FROM leg.usuario";
		try {
			UsuarioDAO dao = new UsuarioDAO();
			List<Usuario> lista = dao.listaTodos(sql);
			System.out.println(lista);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}	

}
