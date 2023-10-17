package djvinc.thinkbetter.pack_model;

public class EmpresaModel{
    private int a01_codigo;
    private String a01_nomeEmpresa;

    public EmpresaModel(){

    }

    public EmpresaModel(int a01_codigo, String a01_nomeEmpresa){
        this.a01_codigo = a01_codigo;
        this.a01_nomeEmpresa = a01_nomeEmpresa;
    }


    public int getA01_codigo() {
        return this.a01_codigo;
    }

    public void setA01_codigo(int a01_codigo) {
        this.a01_codigo = a01_codigo;
    }

    public String getA01_nomeEmpresa() {
        return this.a01_nomeEmpresa;
    }

    public void setA01_nomeEmpresa(String a01_nomeEmpresa) {
        this.a01_nomeEmpresa = a01_nomeEmpresa;
    }
    
}