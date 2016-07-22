package entidades;

/**
 *  Classe abstrata. Super classe de: administrador, docente e discente. 
 * @author Eddie
 * */

public class Usuario {
	/** 
	 * Atributos da classe Usuario.
	 */
    private String codigo;
    private String nome;
    private String cpf;
    private String dtNascimento;
    private String endereco; 
    private String telefone;
    private String email;
    
	
	public Usuario() {
	}
	/**
	 * Getters e setters da classe Usuario.
	 */
    public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String matricula) {
		this.codigo = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

	@Override
	public String toString() {
		return "\n  matricula: " + codigo + "\n  nome: " + nome + " \n  cpf: " + cpf + "\n  dtNascimento: " + dtNascimento
				+ "\n  endereco: " + endereco + "\n  telefone: " + telefone + "\n  email: " + email + " \n";
	}   
	
	
}
