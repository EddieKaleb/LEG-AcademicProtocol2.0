package acoes;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ProcessoDAO;
import entidades.Processo;
import excecoes.RegexException;
import util.ValidacaoProcesso;

public class AcoesProcesso {
	private ValidacaoProcesso validacao;

	public AcoesProcesso() {
		validacao = new ValidacaoProcesso();
	}

	public void cadastroAlteracao(Processo p) {
		String sql = "INSERT INTO leg.processo" + "(codProcesso,statusProcesso,dataProcesso"
				+ ",tipoProcesso,descricaoProcesso)" + "VALUES(?,?,?,?,?)";
		try {
			ProcessoDAO dao = new ProcessoDAO();
			validacao.validaDadosDoProcesso(p);
			dao.addAltera(p, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void remove(Processo p) {
		String sql = "DELETE FROM leg.processo WHERE codProcesso=?";
		try {
			ProcessoDAO dao = new ProcessoDAO();
			dao.remove(p, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void listaTodos(Processo p) {
		String sql = "SELECT * FROM leg.processo";
		try {
			ProcessoDAO dao = new ProcessoDAO();
			List<Processo> lista = dao.listaTodos(sql);
			System.out.println(lista);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}
