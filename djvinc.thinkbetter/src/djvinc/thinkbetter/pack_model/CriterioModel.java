package djvinc.thinkbetter.pack_model;

public class CriterioModel {
    private int a05_idCriterio;
    private String a05_descricao;
    private String a05_tipo;
    private int a05_idProblema;

    public CriterioModel() {

    }


    public CriterioModel(int a05_idCriterio, String a05_descricao, String a05_tipo, int a05_idProblema) {
        this.a05_idCriterio = a05_idCriterio;
        this.a05_descricao = a05_descricao;
        this.a05_tipo = a05_tipo;
        this.a05_idProblema = a05_idProblema;
    }


    public int getA05_idCriterio() {
        return this.a05_idCriterio;
    }

    public void setA05_idCriterio(int a05_idCriterio) {
        this.a05_idCriterio = a05_idCriterio;
    }

    public String getA05_descricao() {
        return this.a05_descricao;
    }

    public void setA05_descricao(String a05_descricao) {
        this.a05_descricao = a05_descricao;
    }

    public String getA05_tipo() {
        return this.a05_tipo;
    }

    public void setA05_tipo(String a05_tipo) {
        this.a05_tipo = a05_tipo;
    }

    public int getA05_idProblema() {
        return this.a05_idProblema;
    }

    public void setA05_idProblema(int a05_idProblema) {
        this.a05_idProblema = a05_idProblema;
    }


}
