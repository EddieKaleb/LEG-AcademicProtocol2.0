package entidades;

public class Discente extends Usuario{
 
	private String semestre;
	public static Usuario usuario;
	public static Curso curso;
	public static Processo processo;
	public static Declaracao declaracao;
	
	 public Discente(Usuario u){
	 Discente.usuario = u;
	 }
	 public Discente(Usuario u, Curso c){
	    	Discente.usuario = u;
	    	Discente.curso = c;
	 }
	 public Discente(Usuario u, Processo p){
	    	Discente.usuario = u;
	    	Discente.processo = p;
	 }
	 public Discente(Usuario u, Declaracao d){
	    	Discente.usuario = u;
	    	Discente.declaracao = d;
	 }

	public String getSemestre() {
        return semestre;
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public static String verificarMatriculaDiscente(){
        return "Matricula OK";
    }
}
