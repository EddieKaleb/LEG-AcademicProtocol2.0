package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Administrador;
import excecoes.RegexException;

public class ValidacaoAdministrador {
	private String padraoLogin;
	private String padraoSenha;

	public ValidacaoAdministrador() {
		this.padraoLogin = "[a-zA-Z0-9]";
		this.padraoSenha = "[a-zA-Z0-9]";
	}
	
	public void validaDadosDoAdministrador(Administrador administrador) throws RegexException {
		this.validadorLogin(administrador.getLogin());
		this.validadorSenha(administrador.getSenha());
	}

	public void validadorLogin(String login) throws RegexException {
		Pattern regex = Pattern.compile(padraoLogin);
		Matcher matcher = regex.matcher(login);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de login, deve apenas conter letras e/ou numeros!");
		}
	}

	public void validadorSenha(String senha) throws RegexException {
		Pattern regex = Pattern.compile(padraoSenha);
		Matcher matcher = regex.matcher(senha);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de senha, deve conter apenas letras e/ou numeros!");
		}
	}
}
