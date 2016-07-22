package acoes;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import dao.DeclaracaoDAO;
import dao.ProcessoDAO;
import entidades.Declaracao;
import excecoes.RegexException;
import util.ValidacaoDeclaracao;

public class AcoesDeclaracao {
	private ValidacaoDeclaracao validacao;

	public AcoesDeclaracao() {
		validacao = new ValidacaoDeclaracao();
	}

	public void cadastroAltera(Declaracao d) {
		String sql = "INSERT INTO leg.declaracao" + "(codDeclaracao,statusDeclaracao,dataDeclaracao"
				+ ",descricaoDeclaracao)" + "VALUES(?,?,?,?)";
		try{
			DeclaracaoDAO dao = new DeclaracaoDAO();
			validacao.validaDadosDaDeclaracao(d);
			dao.addAltera(d, sql);
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void remove(Declaracao d) {
		String sql = "DELETE FROM leg.declaracao WHERE codDeclaracao=?";
		try{
			DeclaracaoDAO dao = new DeclaracaoDAO();
			dao.remove(d, sql);
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void listaTodos(Declaracao d) {
		String sql = "SELECT * FROM leg.declaracao";
		try {
			ProcessoDAO dao = new ProcessoDAO();
			dao.listaTodos(sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}
