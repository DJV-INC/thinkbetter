package djvinc.thinkbetter.pack_model;

public class EspecialistaModel {
    private int a04_idEspecialista;
    private String a04_tipoEspecializacao;
    private int a04_idGrupo;
    private int a04_idEmpresa;

    public EspecialistaModel() {

    }


    public EspecialistaModel(int a04_idEspecialista, String a04_tipoEspecializacao, int a04_idGrupo, int a04_idEmpresa) {
        this.a04_idEspecialista = a04_idEspecialista;
        this.a04_tipoEspecializacao = a04_tipoEspecializacao;
        this.a04_idGrupo = a04_idGrupo;
        this.a04_idEmpresa = a04_idEmpresa;
    }


    public int getA04_idEspecialista() {
        return this.a04_idEspecialista;
    }

    public void setA04_idEspecialista(int a04_idEspecialista) {
        this.a04_idEspecialista = a04_idEspecialista;
    }

    public String getA04_tipoEspecializacao() {
        return this.a04_tipoEspecializacao;
    }

    public void setA04_tipoEspecializacao(String a04_tipoEspecializacao) {
        this.a04_tipoEspecializacao = a04_tipoEspecializacao;
    }

    public int getA04_idGrupo() {
        return this.a04_idGrupo;
    }

    public void setA04_idGrupo(int a04_idGrupo) {
        this.a04_idGrupo = a04_idGrupo;
    }

    public int getA04_idEmpresa() {
        return this.a04_idEmpresa;
    }

    public void setA04_idEmpresa(int a04_idEmpresa) {
        this.a04_idEmpresa = a04_idEmpresa;
    }

}
