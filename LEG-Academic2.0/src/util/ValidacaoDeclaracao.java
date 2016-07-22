package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Declaracao;
import excecoes.RegexException;

public class ValidacaoDeclaracao {
	private String padraoCodigo;
	private String padraoStatus;
	private String padraoDescricao;
	
	public ValidacaoDeclaracao(){
		this.padraoCodigo = "[0-9]";
		this.padraoStatus = "(?x)[a-zA-Z]";
		this.padraoDescricao = "(?x)[a-zA-Z]";
	}
	
	public void validaDadosDaDeclaracao(Declaracao d) throws RegexException{
		this.validadorCodigo(d.getCodigo());
		this.validadorStatus(d.getStatus());
		this.validadorDescricao(d.getDescricao());
	}
	
	public void validadorCodigo(String codigo) throws RegexException {
		Pattern regexMatricula = Pattern.compile(padraoCodigo);
		Matcher matcher = regexMatricula.matcher(codigo);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de codigo, deve conter apenas digitos!");
		}
	}
	public void validadorStatus(String status) throws RegexException {
		Pattern regex = Pattern.compile(padraoStatus);
		Matcher matcher = regex.matcher(status);
		if (!matcher.find()) {
			throw new RegexException("Não deve conter caracteres especiais(%-$_#@) no status! ");
		}
	}
	
	public void validadorDescricao(String descricao) throws RegexException {
		Pattern regex = Pattern.compile(padraoDescricao);
		Matcher matcher = regex.matcher(descricao);
		if (!matcher.find()) {
			throw new RegexException("Não deveS conter caracteres especiais(%-$_#@) na descricao!");
		}
	}
	
}
