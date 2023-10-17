package djvinc.thinkbetter.pack_model;

public class ProblemaModel{
    private int a02_idProblema;
    private int a02_idEmpresa;
    private String a02_descProblema;

    public ProblemaModel(){

    }

    public ProblemaModel(int a02_idProblema, int a02_idEmpresa, String a02_descProblema){
        this.a02_idProblema = a02_idProblema;
        this.a02_idEmpresa = a02_idEmpresa;
        this.a02_descProblema = a02_descProblema;
    }


    public int getA02_idProblema() {
        return this.a02_idProblema;
    }

    public void setA02_idProblema(int a02_idProblema) {
        this.a02_idProblema = a02_idProblema;
    }

    public int getA02_idEmpresa() {
        return this.a02_idEmpresa;
    }

    public void setA02_idEmpresa(int a02_idEmpresa) {
        this.a02_idEmpresa = a02_idEmpresa;
    }

    public String getA02_descProblema() {
        return this.a02_descProblema;
    }

    public void setA02_descProblema(String a02_descProblema) {
        this.a02_descProblema = a02_descProblema;
    }

}