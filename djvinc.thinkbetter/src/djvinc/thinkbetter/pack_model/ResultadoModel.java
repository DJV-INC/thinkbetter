package djvinc.thinkbetter.pack_model;

public class ResultadoModel {
    private int a07_idResultado;
    private int a07_resultado;
    private String a07_descricao;

    public ResultadoModel() {

    }

    public ResultadoModel(int a07_idResultado, int a07_resultado, String a07_descricao) {
        this.a07_idResultado = a07_idResultado;
        this.a07_resultado = a07_resultado;
        this.a07_descricao = a07_descricao;
    }


    public int getA07_idResultado() {
        return this.a07_idResultado;
    }

    public void setA07_idResultado(int a07_idResultado) {
        this.a07_idResultado = a07_idResultado;
    }

    public int getA07_resultado() {
        return this.a07_resultado;
    }

    public void setA07_resultado(int a07_resultado) {
        this.a07_resultado = a07_resultado;
    }

    public String getA07_descricao() {
        return this.a07_descricao;
    }

    public void setA07_descricao(String a07_descricao) {
        this.a07_descricao = a07_descricao;
    }


}
