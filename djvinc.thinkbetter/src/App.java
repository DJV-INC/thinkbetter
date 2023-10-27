import djvinc.thinkbetter.pack_controle.CriterioControle;
import djvinc.thinkbetter.pack_controle.EmpresaControle;
import djvinc.thinkbetter.pack_controle.EspecialistaControle;
import djvinc.thinkbetter.pack_controle.GrauControle;
import djvinc.thinkbetter.pack_controle.GrupoControle;
import djvinc.thinkbetter.pack_controle.ProblemaControle;
import djvinc.thinkbetter.pack_controle.ResultadoControle;
import djvinc.thinkbetter.pack_model.CriterioModel;
import djvinc.thinkbetter.pack_model.EmpresaModel;
import djvinc.thinkbetter.pack_persistencia.EmpresaPersistencia;
import djvinc.thinkbetter.pack_view.MenuView;

public class App {
    public static void main(String[] args) throws Exception {
    	
    	MenuView view = new MenuView();
    	
    	EmpresaControle oEmpresaControle = new EmpresaControle();
        ProblemaControle oProblemaControle = new ProblemaControle();
        GrupoControle oGrupoControle = new GrupoControle();
        EspecialistaControle oEspecialistaControle = new EspecialistaControle();
        CriterioControle oCriterioControle = new CriterioControle();
        GrauControle oGrauControle = new GrauControle();
        ResultadoControle oResultadoControle = new ResultadoControle();

        oEmpresaControle.inserirEmpresa("VJinc");
        oEmpresaControle.atualizarEmpresa(1, "VJinc atualizado");

    

        oProblemaControle.inserirProblema(1, "Problema Java");
        oProblemaControle.alterarProblema(1, 1, "Problema Java atualizado");

        
        oGrupoControle.inserirGrupo("A", 1);
        oGrupoControle.alterarGrupo(1, "Grupo - A", 1);

        oEspecialistaControle.inserirEspecialista("sql", 1, 1);
        oEspecialistaControle.alterarEspecialista(1, "sql2", 1, 1);

        oCriterioControle.inserirCriterio("descrição", "tipo ", 1);
        oCriterioControle.alterarCriterio(1, "descrição att", "tipo att", 1);

        oGrauControle.inserirGrau(10, 8, 1, 1);
        oGrauControle.alterarGrau(1, 9, 7, 1, 1);

        oResultadoControle.inserirResultado(10, "Resultado teste");
        oResultadoControle.alterarResultado(1, 5, "Resultado att");
        
    	
    	view.iniciaTela();
    	
    	
        

        
    }
}

