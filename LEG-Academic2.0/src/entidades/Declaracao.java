package entidades;

import java.util.Calendar;

/**
 * Classe Declaracao com os seus respectivos atributos
 */
public class Declaracao {
    private String codigo;
    private String data;
    private String status;
    private String descricao;
    
    public Declaracao(){
    	
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
    
}
