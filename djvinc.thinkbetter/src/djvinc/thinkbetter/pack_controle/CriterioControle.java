package djvinc.thinkbetter.pack_controle;

import java.util.List;

import djvinc.thinkbetter.pack_model.CriterioModel;
import djvinc.thinkbetter.pack_persistencia.CriterioPersistencia;

public class CriterioControle {
    CriterioModel oCriterioModel = new CriterioModel();
    CriterioPersistencia oCriterioPersistencia = new CriterioPersistencia();

    public void inserirCriterio(String descricao, String tipo, int idProblema) {
        oCriterioModel.setA05_descricao(descricao);
        oCriterioModel.setA05_tipo(tipo);
        oCriterioModel.setA05_idProblema(idProblema);
        oCriterioPersistencia.inserirCriterio(oCriterioModel);
    }

    public void alterarCriterio(int id, String descricao, String tipo, int idProblema) {
        oCriterioModel.setA05_idCriterio(id);
        oCriterioModel.setA05_descricao(descricao);
        oCriterioModel.setA05_tipo(tipo);
        oCriterioModel.setA05_idProblema(idProblema);

        oCriterioPersistencia.atualizarCriterio(oCriterioModel);
    }

    public void excluirCriterio(int id) {
        oCriterioModel.setA05_idCriterio(id); 

        oCriterioPersistencia.excluirCriterio(oCriterioModel);
    }
    
    public List<CriterioModel> consultarCriterio() {
    	return oCriterioPersistencia.consultarCriterio();
    }
}
