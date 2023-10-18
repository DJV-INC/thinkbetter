package djvinc.thinkbetter.pack_controle;

import djvinc.thinkbetter.pack_model.GrauModel;
import djvinc.thinkbetter.pack_persistencia.GrauPersistencia;

public class GrauControle {
    GrauModel oGrauModel = new GrauModel();
    GrauPersistencia oGrauPersistencia = new GrauPersistencia();

    public void inserirGrau(int grauCerteza, int grauIncerteza, int idCriterio, int idEspecialista) {
        oGrauModel.setA06_grauCerteza(grauCerteza);
        oGrauModel.setA06_grauIncerteza(grauIncerteza);
        oGrauModel.setA06_idCriterio(idCriterio);
        oGrauModel.setA06_idEspecialista(idEspecialista);

        oGrauPersistencia.inserirGrau(oGrauModel);
    }

    public void alterarGrau(int id, int grauCerteza, int grauIncerteza, int idCriterio, int idEspecialista) {
        oGrauModel.setA06_idGrau(id);
        oGrauModel.setA06_grauCerteza(grauCerteza);
        oGrauModel.setA06_grauIncerteza(grauIncerteza);
        oGrauModel.setA06_idCriterio(idCriterio);
        oGrauModel.setA06_idEspecialista(idEspecialista);

        oGrauPersistencia.alterarGrau(oGrauModel);
    }

    public void excluirGrau(int id) {
        oGrauModel.setA06_idGrau(id);

        oGrauPersistencia.excluirGrau(oGrauModel);
    }
}
