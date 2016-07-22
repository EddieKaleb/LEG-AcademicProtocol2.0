package entidades;

/**
 * Classe que herda métodos da super classe usuario.
 * @author Eddie
 *
 */
public class Servidor extends Usuario{
	/**
	 * Atributos da classe usuario.
	 */
	public String   cargaHoraria;
    public String grau;
    public static Usuario usuario;
    public static Cargo cargo;
    public static Processo processo;
    /**
     * Construtor da classe Servidor
     */
    public Servidor(){
    }
    public Servidor(Usuario u){
    	Servidor.usuario = u;
    }
    public Servidor(Usuario u, Cargo c){
    	Servidor.usuario = u;
    	Servidor.cargo = c;
    }  
    public Servidor(Usuario u, Processo p){
    	Servidor.usuario = u;
    	Servidor.processo = p;
    }  


	/**
     * Getters e Setters da classe Servidor.
     */
	public String getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	public String getGrau() {
		return grau;
	}
	public void setGrau(String grau) {
		this.grau = grau;
	}
	@Override
	public String toString() {
		return " cargaHoraria:" + getCargaHoraria() + "\n  grau:" + getGrau() + " "; 
	}

	
	
    
}
