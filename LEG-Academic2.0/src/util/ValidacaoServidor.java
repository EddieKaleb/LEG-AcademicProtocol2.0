package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Servidor;
import excecoes.RegexException;

public class ValidacaoServidor{
	
	private String padraoCargaHoraria;
	private String padraoGrau;

	public ValidacaoServidor() {
		this.padraoCargaHoraria = "^[0-9]{3}$";
		this.padraoGrau = "(?x)[a-zA-Z]";
	}

	public void validaDadosDoServidor(Servidor servidor) throws RegexException {
		this.validadorCargaHoraria(servidor.getCargaHoraria());
		this.validadorGrau(servidor.getGrau());
	}

	public void validadorCargaHoraria(String cargaHoraria) throws RegexException {
		Pattern regex = Pattern.compile(padraoCargaHoraria);
		Matcher matcher = regex.matcher(cargaHoraria);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de carga horaria, deve conter apenas digitos! (max:. 3 digitos)");
		}
	}

	public void validadorGrau(String grau) throws RegexException {
		Pattern regex = Pattern.compile(padraoGrau);
		Matcher matcher = regex.matcher(grau);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de grau, deve conter apenas letras!");
		}
	}

}
