package djvinc.thinkbetter.pack_controle;

import java.util.List;

import djvinc.thinkbetter.pack_model.ProblemaModel;
import djvinc.thinkbetter.pack_persistencia.ProblemaPersistencia;

public class ProblemaControle {
    ProblemaModel oProblemaModel = new ProblemaModel();
    ProblemaPersistencia oProblemaPersistencia = new ProblemaPersistencia();

    public void inserirProblema(int idEmpresa, String desc) {
        oProblemaModel.setA02_idEmpresa(idEmpresa);
        oProblemaModel.setA02_descProblema(desc);

        oProblemaPersistencia.inserirProblema(oProblemaModel);
    }

    public void alterarProblema(int id, int idEmpresa, String desc) {
        oProblemaModel.setA02_idProblema(id);
        oProblemaModel.setA02_idEmpresa(idEmpresa);
        oProblemaModel.setA02_descProblema(desc);

        oProblemaPersistencia.alterarProblema(oProblemaModel);
    }

    public void excluirProblema(int id) {
        oProblemaModel.setA02_idProblema(id);

        oProblemaPersistencia.excluirProblema(oProblemaModel);
    }
    
    public List<ProblemaModel> consultarProblema() {
    	return oProblemaPersistencia.consultarProblema();
    }
    
}
