package djvinc.thinkbetter.pack_controle;

import djvinc.thinkbetter.pack_model.EspecialistaModel;
import djvinc.thinkbetter.pack_persistencia.EspecialistaPersistencia;

public class EspecialistaControle {
    EspecialistaModel oEspecialistaModel = new EspecialistaModel();
    EspecialistaPersistencia oEspecialistaPersistencia = new EspecialistaPersistencia();

    public void inserirEspecialista(String tipo, int idGrupo, int idEmpresa) {
        oEspecialistaModel.setA04_tipoEspecializacao(tipo);
        oEspecialistaModel.setA04_idGrupo(idGrupo);
        oEspecialistaModel.setA04_idEmpresa(idEmpresa);

        oEspecialistaPersistencia.inserirEspecialista(oEspecialistaModel);
    }

    public void alterarEspecialista(int id, String tipo, int idGrupo, int idEmpresa) {
        oEspecialistaModel.setA04_idEspecialista(id);
        oEspecialistaModel.setA04_tipoEspecializacao(tipo);
        oEspecialistaModel.setA04_idGrupo(idGrupo);
        oEspecialistaModel.setA04_idEmpresa(idEmpresa);
        
        oEspecialistaPersistencia.alterarEspecialista(oEspecialistaModel);
    }

    public void excluirEspecialista(int id) {
        oEspecialistaModel.setA04_idEspecialista(id);

        oEspecialistaPersistencia.excluirEspecialista(oEspecialistaModel);
    }

    
}
