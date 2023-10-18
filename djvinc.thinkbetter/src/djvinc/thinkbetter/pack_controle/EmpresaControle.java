package djvinc.thinkbetter.pack_controle;

import djvinc.thinkbetter.pack_model.EmpresaModel;
import djvinc.thinkbetter.pack_persistencia.EmpresaPersistencia;

public class EmpresaControle {
    EmpresaModel oEmpresaModel = new EmpresaModel();
    EmpresaPersistencia oEmpresaPersistencia = new EmpresaPersistencia();

    public void inserirEmpresa(String nome) {
        oEmpresaModel.setA01_nomeEmpresa(nome);
        oEmpresaPersistencia.inserirEmpresa(oEmpresaModel);
    }

    public void atualizarEmpresa(int id, String nome) {
        oEmpresaModel.setA01_codigo(id);
        oEmpresaModel.setA01_nomeEmpresa(nome);
        oEmpresaPersistencia.alterarEmpresa(oEmpresaModel);
    }

    public void excluirEmpresa(int id) {
        oEmpresaModel.setA01_codigo(id);
        oEmpresaPersistencia.excluirEmpresa(oEmpresaModel);
    }
    
}
