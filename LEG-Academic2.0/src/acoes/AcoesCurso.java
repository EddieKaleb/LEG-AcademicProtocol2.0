package acoes;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CargoDAO;
import dao.CursoDAO;
import entidades.Cargo;
import entidades.Curso;
import excecoes.RegexException;
import util.ValidacaoCurso;

public class AcoesCurso {
	private ValidacaoCurso validacao;

	public AcoesCurso() {
		validacao = new ValidacaoCurso();
	}

	public void cadastro(Curso c) {
		String sql = "INSERT INTO leg.curso" + "(codCurso,nome,ementa,cargaHoraria,descricao)" + "VALUES(?,?,?,?,?)";
		try {
			CursoDAO dao = new CursoDAO();
			validacao.validaDadosDoCurso(c);
			dao.add(c, sql);
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void remove(Curso c) {
		String sql = "DELETE FROM leg.curso WHERE codCurso=?";
		try {
			CursoDAO dao = new CursoDAO();
			dao.remove(c, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void altera(Curso c) {
		String sql = "UPDATE leg.curso" + " SET codCurso=?,nome=?, ementa=?, cargaHoraria=?, descricao=?"
				+ " WHERE codCurso=?";
		try {
			CursoDAO dao = new CursoDAO();
			validacao.validaDadosDoCurso(c);
			dao.altera(c, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void listaTodos(Curso c) {
		String sql = "SELECT * FROM leg.curso";
		try {
			CursoDAO dao = new CursoDAO();
			List<Curso> lista = dao.listaTodos(sql);
			System.out.println(lista);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}
