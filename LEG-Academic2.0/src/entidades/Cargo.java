package entidades;

/**
 * 
 * Classe Cargo que pode é ocupada por um Servidor específico
 *
 */
public class Cargo {
    private String codigo;
    private String nome;
    private String descricao;
    private String ramal;

    public Cargo(){
    	
    }
    public String getRamal() {
        return ramal;
    }

    public void setRamal(String ramal) {
        this.ramal = ramal;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
