package djvinc.thinkbetter.pack_controle;

import java.util.List;

import djvinc.thinkbetter.pack_model.ResultadoModel;
import djvinc.thinkbetter.pack_persistencia.ResultadoPersistencia;

public class ResultadoControle {
    ResultadoModel oResultadoModel = new ResultadoModel();
    ResultadoPersistencia oResultadoPersistencia = new ResultadoPersistencia();

    public void inserirResultado(int resultado, String descricao) {
        oResultadoModel.setA07_resultado(resultado);
        oResultadoModel.setA07_descricao(descricao);

        oResultadoPersistencia.inserirResultado(oResultadoModel);
    }

    public void alterarResultado(int id, int resultado, String descricao) {
        oResultadoModel.setA07_idResultado(id);
        oResultadoModel.setA07_resultado(resultado);
        oResultadoModel.setA07_descricao(descricao);

        oResultadoPersistencia.alterarResultado(oResultadoModel);
    }

    public void excluirResultado(int id) {
        oResultadoModel.setA07_idResultado(id);

        oResultadoPersistencia.excluirResultado(oResultadoModel);
    }
    
    public List<ResultadoModel> consultarResultado() {
    	return oResultadoPersistencia.consultarResultado();
    }
}
