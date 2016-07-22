package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Curso;
import excecoes.RegexException;

public class ValidacaoCurso {
	private String padraoCodigo;
    private String padraoNome;
    private String padraoEmenta;
    private String padraoCargaHoraria;
    private String padraoDescricao;
    
    public ValidacaoCurso(){
    	this.padraoCodigo = "[0-9]";
		this.padraoNome = "(?x)[a-zA-Z]";
		this.padraoEmenta = "(?x)[a-zA-Z]";
		this.padraoCargaHoraria = "^[0-9]{3}$";
		this.padraoDescricao = "(?x)[a-zA-Z]";
    }
    
    public void validaDadosDoCurso(Curso c) throws RegexException{
    	this.validadorCodigo(c.getCodigo());
    	this.validadorNome(c.getNome());
    	this.validadorEmenta(c.getEmenta());
    	this.validadorCargaHoraria(c.getCargaHoraria());
    	this.validadorDescricao(c.getDescricao());
    }
    
    public void validadorCodigo(String codigo) throws RegexException {
		Pattern regexMatricula = Pattern.compile(padraoCodigo);
		Matcher matcher = regexMatricula.matcher(codigo);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de codigo, deve conter apenas digitos!");
		}
	}

	public void validadorNome(String nome) throws RegexException {
		Pattern regex = Pattern.compile(padraoNome);
		Matcher matcher = regex.matcher(nome);
		if (!matcher.find()) {
			throw new RegexException("Não deve conter caracteres especiais(%-$_#@) no nome! ");
		}
	}
	
	public void validadorEmenta(String ementa) throws RegexException {
		Pattern regex = Pattern.compile(padraoEmenta);
		Matcher matcher = regex.matcher(ementa);
		if (!matcher.find()) {
			throw new RegexException("Não deve conter caracteres especiais(%-$_#@) na ementa! ");
		}
	}
	
	public void validadorCargaHoraria(String cargaHoraria) throws RegexException {
		Pattern regex = Pattern.compile(padraoCargaHoraria);
		Matcher matcher = regex.matcher(cargaHoraria);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de carga horaria, deve conter apenas digitos! (max:. 3 digitos)");
		}
	}
	
	public void validadorDescricao(String descricao) throws RegexException {
		Pattern regex = Pattern.compile(padraoDescricao);
		Matcher matcher = regex.matcher(descricao);
		if (!matcher.find()) {
			throw new RegexException("Não pode conter caracteres especiais(%-$_#@) na descricao!");
		}
	}
	
}
