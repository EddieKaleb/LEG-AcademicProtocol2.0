package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Cargo;
import excecoes.RegexException;

public class ValidacaoCargo {
	private String padraoCodigo;
	private String padraoNome;
	private String padraoRamal;
	private String padraoDescricao;
	public ValidacaoCargo() {
		this.padraoCodigo = "[0-9]";
		this.padraoNome = "(?x)[a-zA-Z]";
		this.padraoRamal = "[0-9]";
		this.padraoDescricao = "(?x)[a-zA-Z]";
	}

	public void validaDadosDoCargo(Cargo c) throws RegexException {
		this.validadorCodigo(c.getCodigo());
		this.validadorNome(c.getNome());
		this.validadorRamal(c.getRamal());
		this.validadorDescricao(c.getDescricao());
	}
	
	public void validadorCodigo(String codigo) throws RegexException {
		Pattern regexMatricula = Pattern.compile(padraoCodigo);
		Matcher matcher = regexMatricula.matcher(codigo);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de codigo, deve conter somente digitos!");
		}
	}
	public void validadorNome(String nome) throws RegexException {
		Pattern regex = Pattern.compile(padraoNome);
		Matcher matcher = regex.matcher(nome);
		if (!matcher.find()) {
			throw new RegexException("Não deve conter caracteres especiais(%-$_#@) no nome! ");
		}
	}
	public void validadorRamal(String ramal) throws RegexException {
		Pattern regex = Pattern.compile(padraoRamal);
		Matcher matcher = regex.matcher(ramal);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de ramal, deve conter somente digitos!");
		}
	}
	public void validadorDescricao(String descricao) throws RegexException {
		Pattern regex = Pattern.compile(padraoDescricao);
		Matcher matcher = regex.matcher(descricao);
		if (!matcher.find()) {
			throw new RegexException("Não deve conter caracteres especiais(%-$_#@) na descricao!");
		}
	}
}
