package djvinc.thinkbetter.pack_persistencia;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.CriterioModel;

public class CriterioPersistencia {
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    ResultSet oResultSet;
	Statement oStat;

    public void inserirCriterio(CriterioModel oCriterioModel) {
        try {
            try {
                oCall = oConectar.getConexao().prepareCall("CALL proc_insert_criterio(?,?,?)");
                oCall.setString(1, oCriterioModel.getA05_descricao());
                oCall.setString(2, oCriterioModel.getA05_tipo());
                oCall.setInt(3, oCriterioModel.getA05_idProblema());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void atualizarCriterio(CriterioModel oCriterioModel) {
        try {
            try {
                oCall = oConectar.getConexao().prepareCall("CALL proc_alter_criterio(?,?,?,?)");
                oCall.setInt(1, oCriterioModel.getA05_idCriterio());
                oCall.setString(2, oCriterioModel.getA05_descricao());
                oCall.setString(3, oCriterioModel.getA05_tipo());
                oCall.setInt(4, oCriterioModel.getA05_idProblema());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluirCriterio(CriterioModel oCriterioModel) {
        try {
            try {
                oCall = oConectar.getConexao().prepareCall("CALL proc_delete_criterio(?)");
                oCall.setInt(1, oCriterioModel.getA05_idCriterio());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<CriterioModel> consultarCriterio() {
    	List<CriterioModel> lista = new ArrayList<>();
    	
    	try {
            try {
               oStat = oConectar.getConexao().createStatement();
               oResultSet = oStat.executeQuery("select * from vw_criterio05 order by a05_idCriterio");
               
               while (oResultSet.next()) {
            	   CriterioModel oCriterioModel = new CriterioModel();
            	   
            	   oCriterioModel.setA05_idCriterio(oResultSet.getInt(1));
            	   oCriterioModel.setA05_descricao(oResultSet.getString(2));
            	   oCriterioModel.setA05_tipo(oResultSet.getString(3));
            	   oCriterioModel.setA05_idProblema(oResultSet.getInt(4));
            	   
            	   lista.add(oCriterioModel);
               }
               oResultSet.close();
               oStat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return lista;
    }
}
