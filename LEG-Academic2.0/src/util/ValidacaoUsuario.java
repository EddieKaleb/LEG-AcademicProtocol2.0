package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidades.Usuario;
import excecoes.RegexException;

public class ValidacaoUsuario {

	private String padraoCodigo;
	private String padraoNome;
	private String padraoCpf;
	private String padraoDtNascimento;
	private String padraoEndereco;
	private String padraoTelefone;
	private String padraoEmail;

	public ValidacaoUsuario() {
		this.padraoCodigo = "^[0-9]{11}$";
		this.padraoNome = "(?x)^[a-zA-Z]$";
		this.padraoCpf = "^\\d{3,3}.\\d{3,3}.\\d{3,3}-\\d{2,2}$";
		this.padraoDtNascimento = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}$";
		this.padraoEndereco = "(?x)[a-zA-Z0-9.,]";
		this.padraoTelefone = "\\d{2,3}.\\d{3,5}.\\d{3,5}";
		this.padraoEmail = "^\\S+@\\S+\\.\\S+$";
	}

	public void validaDadosDoUsuario(Usuario usuario) throws RegexException {
		this.validadorCodigo(usuario.getCodigo());
		this.validadorNome(usuario.getNome());
		this.validadorCpf(usuario.getCpf());
		this.validadorDtNascimento(usuario.getDtNascimento());
		this.validadorEndereco(usuario.getEndereco());
		this.validadorTelefone(usuario.getTelefone());
		this.validadorEmail(usuario.getEmail());
	}

	public void validadorCodigo(String codigo) throws RegexException {
		Pattern regexMatricula = Pattern.compile(padraoCodigo);
		Matcher matcher = regexMatricula.matcher(codigo);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de matricula, deve conter 11 digitos! (ex:. 20141003003)");
		}
	}

	public void validadorNome(String nome) throws RegexException {
		Pattern regex = Pattern.compile(padraoNome);
		Matcher matcher = regex.matcher(nome);
		if (!matcher.find()) {
			throw new RegexException("NFormatacao incorreta de nome ou em branco! ");
		}
	}

	public void validadorCpf(String cpf) throws RegexException {
		Pattern regexMatricula = Pattern.compile(padraoCpf);
		Matcher matcher = regexMatricula.matcher(cpf);
		if (!matcher.find()) {
			throw new RegexException(
					"Formatacao incorreta do CPF, deve conter 11 digíticos e caracteres especiais(-.)! (ex:. 000.000.000-00)");
		}
	}

	public void validadorDtNascimento(String dtNascimento) throws RegexException {
		Pattern regexMatricula = Pattern.compile(padraoDtNascimento);
		Matcher matcher = regexMatricula.matcher(dtNascimento);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de data! (ex:.03/03/2003)");
		}
	}

	public void validadorEndereco(String endereco) throws RegexException {
		Pattern regexMatricula = Pattern.compile(padraoEndereco);
		Matcher matcher = regexMatricula.matcher(endereco);
		if (!matcher.find()) {
			throw new RegexException("Não pode conter caracteres especiais (%-$_#@) no endereco!");
		}
	}

	public void validadorTelefone(String telefone) throws RegexException {
		Pattern regexMatricula = Pattern.compile(padraoTelefone);
		Matcher matcher = regexMatricula.matcher(telefone);
		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de telefone! (ex:.083 33333333)");
		}
	}

	public void validadorEmail(String email) throws RegexException {
		Pattern regexEmail = Pattern.compile(padraoEmail);
		Matcher matcher = regexEmail.matcher(email);

		if (!matcher.find()) {
			throw new RegexException("Formatacao incorreta de e-mail! (ex:.fulano@exemplo.com)");
		}
	}
}
