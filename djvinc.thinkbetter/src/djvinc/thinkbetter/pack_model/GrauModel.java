package djvinc.thinkbetter.pack_model;

public class GrauModel{
    private int a06_idGrau;
    private int a06_grauCerteza;
    private int a06_grauIncerteza;
    private int a06_idCriterio;
    private int a06_idEspecialista;

    public GrauModel(){

    }

    public GrauModel(int a06_idGrau, int a06_grauCerteza, int a06_grauIncerteza, int a06_idCriterio, int a06_idEspecialista){
        
        this.a06_idGrau = a06_idGrau;
        this.a06_grauCerteza = a06_grauCerteza;
        this.a06_grauIncerteza = a06_grauIncerteza;
        this.a06_idCriterio = a06_idCriterio;
        this.a06_idEspecialista = a06_idEspecialista;
        
    }


    public int getA06_idGrau() {
        return this.a06_idGrau;
    }

    public void setA06_idGrau(int a06_idGrau) {
        this.a06_idGrau = a06_idGrau;
    }

    public int getA06_grauCerteza() {
        return this.a06_grauCerteza;
    }

    public void setA06_grauCerteza(int a06_grauCerteza) {
        this.a06_grauCerteza = a06_grauCerteza;
    }

    public int getA06_grauIncerteza() {
        return this.a06_grauIncerteza;
    }

    public void setA06_grauIncerteza(int a06_grauIncerteza) {
        this.a06_grauIncerteza = a06_grauIncerteza;
    }

    public int getA06_idCriterio() {
        return this.a06_idCriterio;
    }

    public void setA06_idCriterio(int a06_idCriterio) {
        this.a06_idCriterio = a06_idCriterio;
    }

    public int getA06_idEspecialista() {
        return this.a06_idEspecialista;
    }

    public void setA06_idEspecialista(int a06_idEspecialista) {
        this.a06_idEspecialista = a06_idEspecialista;
    }
    
}