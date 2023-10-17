package djvinc.thinkbetter.pack_model;

public class GrupoModel{

    private int a03_idGrupo;
    private String a03_nomeGrupo;
    private int a03_idProblema; 

    public GrupoModel(){

    }

    public GrupoModel(int a03_idGrupo, String a03_nomeGrupo, int a03_idProblema){
        this.a03_idGrupo = a03_idGrupo;
        this.a03_nomeGrupo = a03_nomeGrupo;
        this.a03_idProblema = a03_idProblema;
    }


    public int getA03_idGrupo() {
        return this.a03_idGrupo;
    }

    public void setA03_idGrupo(int a03_idGrupo) {
        this.a03_idGrupo = a03_idGrupo;
    }

    public String getA03_nomeGrupo() {
        return this.a03_nomeGrupo;
    }

    public void setA03_nomeGrupo(String a03_nomeGrupo) {
        this.a03_nomeGrupo = a03_nomeGrupo;
    }

    public int getA03_idProblema() {
        return this.a03_idProblema;
    }

    public void setA03_idProblema(int a03_idProblema) {
        this.a03_idProblema = a03_idProblema;
    }
    
}