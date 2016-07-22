package acoes;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import dao.CargoDAO;
import entidades.Administrador;
import entidades.Cargo;
import excecoes.RegexException;
import util.ValidacaoAdministrador;
import util.ValidacaoCargo;

public class AcoesCargo {
	private ValidacaoCargo validacao;

	public AcoesCargo() {
		validacao = new ValidacaoCargo();
	}

	public void cadastro(Cargo c) {
		String sql = "INSERT INTO leg.cargo" + "(codCargo,nome,ramal,descricao)" + "VALUES(?,?,?,?)";
		try {
			validacao.validaDadosDoCargo(c);
			CargoDAO dao = new CargoDAO();
			dao.add(c,sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}
	public static void remove(Cargo c) {
		String sql = "DELETE FROM leg.cargo WHERE codCargo=?";
		try {
			CargoDAO dao = new CargoDAO();
			dao.remove(c,sql);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
	public void altera(Cargo c) {
		String sql = "UPDATE leg.cargo" + " SET codCargo=?,nome=?, ramal=?, descricao=?" 
				+ " WHERE codCargo=?";
		try {
			validacao.validaDadosDoCargo(c);
			CargoDAO dao = new CargoDAO();
			dao.altera(c,sql);

		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		} catch (RegexException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),"ERRO DE ENTRADA", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void lista() {
		String sql = "SELECT * FROM leg.administrador";
		try {
			CargoDAO dao = new CargoDAO();
			List<Cargo> lista = dao.listaTodos(sql);
			System.out.println(lista);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,e.getMessage(),"SQL", JOptionPane.ERROR_MESSAGE);
		}
	}
}
