package acoes;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.DiscenteDAO;
import entidades.Discente;
import excecoes.RegexException;
import util.ValidacaoDiscente;

public class AcoesDiscente {
	private ValidacaoDiscente validacao;

	public AcoesDiscente() {
		validacao = new ValidacaoDiscente();
	}

	public void cadastro(Discente d) {
		String sql = "INSERT INTO leg.discente" + "(codDiscente,semestre)" + "VALUES(?,?)";
		try {
			DiscenteDAO dao = new DiscenteDAO();
			validacao.validaDadosDoDiscente(d);
			dao.add(d, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void atribuirCurso(Discente d) {
		String sql = "UPDATE leg.discente" + " SET codCursoDiscente=?" + " WHERE codDiscente=?";
		try {
			DiscenteDAO dao = new DiscenteDAO();
			dao.altera(d, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void abrirProcesso(Discente d) {
		String sql = "UPDATE leg.discente" + " SET codProcessoDiscente=?" + " WHERE codDiscente=?";
		try {
			DiscenteDAO dao = new DiscenteDAO();
			dao.altera(d, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void solicitarDeclaracao(Discente d) {
		String sql = "UPDATE leg.discente" + " SET codDeclaracaoDiscente=?" + " WHERE codDiscente=?";
		try {
			DiscenteDAO dao = new DiscenteDAO();
			dao.altera(d, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void remove(Discente d) {
		String sql = "DELETE FROM leg.usuario WHERE codUsuario=?";
		try {
			DiscenteDAO dao = new DiscenteDAO();
			dao.remove(d, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void altera(Discente d) {
		String sql = "UPDATE leg.discente" + " SET codCursoDiscente=?,semestre=?,"
				+ "codDeclaracaoDiscente=?,codProcessoDiscente=?" + " WHERE codDiscente=?";
		try {
			DiscenteDAO dao = new DiscenteDAO();
			validacao.validaDadosDoDiscente(d);
			dao.altera(d, sql);
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void listaTodos(Discente d) {
		String sql = "SELECT * FROM leg.discente";
		try {
			DiscenteDAO dao = new DiscenteDAO();
			dao.listaTodos(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

}
