package acoes;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dao.AdministradorDAO;
import entidades.Administrador;
import excecoes.RegexException;
import util.ValidacaoAdministrador;

public class AcoesAdministrador {
	private ValidacaoAdministrador validacao;

	public AcoesAdministrador() {
		validacao = new ValidacaoAdministrador();
	}

	public void cadastro(Administrador a) {
		String sql = "INSERT INTO leg.administrador" + "(codAdministrador,login, senha)"
				+ "VALUES(?,?,?)";
		try {
			validacao.validaDadosDoAdministrador(a);
			AdministradorDAO dao = new AdministradorDAO();
			dao.add(a,sql);
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void remove(Administrador a) {
		String sql = "DELETE FROM leg.usuario WHERE codUsuario=?";
		try {
			AdministradorDAO dao = new AdministradorDAO();
			dao.remove(a,sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void altera(Administrador a) {
		String sql = "UPDATE leg.administrador" + " SET login=?,senha=?" + " WHERE codAdministrador=?";
		try {
			validacao.validaDadosDoAdministrador(a);
			AdministradorDAO dao = new AdministradorDAO();
			dao.altera(a,sql);

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void lista() {
		String sql = "SELECT * FROM leg.administrador";
		try {
			AdministradorDAO dao = new AdministradorDAO();
			List<Administrador> lista = dao.listaTodos(sql);
			System.out.println(lista);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

	
}
