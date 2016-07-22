package entidades;

import java.util.Calendar;

/**
 * Classe Processo com seus respectivos atributos
 */
public class Processo {
    private String codigo;
    private String status;
    private String data;
	private String tipo;
    private String descricao;
    
    public Processo(){
    	
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getData() {
  		return data;
  	}

  	public void setData(String data) {
  		this.data = data;
  	}

}
