package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Discente;
import excecoes.RegexException;

public class ValidacaoDiscente {
	private String padraoSemestre;
	
	public ValidacaoDiscente(){
		this.padraoSemestre = "[0-9]";
	}
	
	public void validaDadosDoDiscente(Discente d) throws RegexException{
		validadorSemestre(d.getSemestre());
	}
	
	public void validadorSemestre(String semestre) throws RegexException{
		Pattern regex = Pattern.compile(padraoSemestre);
		Matcher matcher = regex.matcher(semestre);
		if(!matcher.find())
			throw new RegexException("Formatacao incorreta de semestre, deve conter apenas dígitos!");
	}

}
