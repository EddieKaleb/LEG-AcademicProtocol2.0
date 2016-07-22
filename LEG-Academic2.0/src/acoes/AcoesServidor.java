package acoes;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dao.ServidorDAO;
import dao.UsuarioDAO;
import entidades.Servidor;
import entidades.Usuario;
import excecoes.RegexException;
import util.ValidacaoServidor;

public class AcoesServidor {
	private ValidacaoServidor validacao;

	public AcoesServidor() {
		validacao = new ValidacaoServidor();
	}

	public void cadastro(Servidor s) {
		String sql = "INSERT INTO leg.servidor"
				+ "(codServidor,cargaHoraria,grau)"
				+ "VALUES(?,?,?)";
		try {
			validacao.validaDadosDoServidor(s);
			ServidorDAO dao = new ServidorDAO();
			dao.add(s, sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void atribuirCargo(Servidor s){
		String sql = "UPDATE leg.servidor" + " SET codCargoServidor=?"
				+ " WHERE codServidor=?";
		try {
			ServidorDAO dao = new ServidorDAO();
			dao.altera(s, sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void abrirProcesso(Servidor s){
		String sql = "UPDATE leg.servidor" + " SET codProcessoServidor=?"
				+ " WHERE codServidor=?";
		try {
			ServidorDAO dao = new ServidorDAO();
			dao.altera(s, sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void remove(Servidor s) {
		String sql = "DELETE FROM leg.usuario WHERE codUsuario=?";
		try {
			ServidorDAO dao = new ServidorDAO();
			dao.remove(s, sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void altera(Servidor s) {
		String sql = "UPDATE leg.servidor" + " SET codCargoServidor=?,cargaHoraria=?, grau=?, codProcessoServidor=?"
				+ " WHERE codServidor=?";
		try {
			validacao.validaDadosDoServidor(s);
			ServidorDAO dao = new ServidorDAO();
			dao.altera(s, sql);

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void listaTodos() {
		String sql = "SELECT * FROM leg.servidor";

		try {
			ServidorDAO dao = new ServidorDAO();
			List<Servidor> lista = dao.listaTodos(sql);
			System.out.println(lista);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "SQL", JOptionPane.ERROR_MESSAGE);
		}
	}

}
