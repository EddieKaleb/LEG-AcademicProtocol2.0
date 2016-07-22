package util;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Processo;
import excecoes.RegexException;

public class ValidacaoProcesso {
	private String padraoCodigo;
	private String padraoStatus;
	private String padraoTipo;
	private String padraoDescricao;

	public ValidacaoProcesso() {
		this.padraoCodigo = "[0-9]";
		this.padraoStatus = "(?x)[a-zA-Z]";
		this.padraoTipo = "(?x)[a-zA-Z]";
		this.padraoDescricao = "(?x)[a-zA-Z]";
	}

	public void validaDadosDoProcesso(Processo p) throws RegexException {
		this.validadorCodigo(p.getCodigo());
		this.validadorStatus(p.getStatus());
		this.validadorTipo(p.getTipo());
		this.validadorDescricao(p.getDescricao());
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

	public void validadorTipo(String tipo) throws RegexException {
		Pattern regex = Pattern.compile(padraoTipo);
		Matcher matcher = regex.matcher(tipo);
		if (!matcher.find()) {
			throw new RegexException("Não deve conter caracteres especiais(%-$_#@) no tipo! ");
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
