package djvinc.thinkbetter.pack_controle;

import djvinc.thinkbetter.pack_model.GrupoModel;
import djvinc.thinkbetter.pack_persistencia.GrupoPersistencia;

public class GrupoControle {
    GrupoModel oGrupoModel = new GrupoModel();
    GrupoPersistencia oGrupoPersistencia = new GrupoPersistencia();

    public void inserirGrupo(String nome, int idProblema) {
        oGrupoModel.setA03_nomeGrupo(nome);
        oGrupoModel.setA03_idProblema(idProblema);

        oGrupoPersistencia.inserirGrupo(oGrupoModel);
    }

    public void alterarGrupo(int id, String nome, int idProblema) {
        oGrupoModel.setA03_idGrupo(id);
        oGrupoModel.setA03_nomeGrupo(nome);
        oGrupoModel.setA03_idProblema(idProblema);

        oGrupoPersistencia.alterarGrupo(oGrupoModel);
    }

    public void excluirGrupo(int id) {
        oGrupoModel.setA03_idGrupo(id);

        oGrupoPersistencia.excluirGrupo(oGrupoModel);
    }
}
