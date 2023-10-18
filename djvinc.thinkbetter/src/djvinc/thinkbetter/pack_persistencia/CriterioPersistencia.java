package djvinc.thinkbetter.pack_persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.CriterioModel;

public class CriterioPersistencia {
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    ResultSet oResultSet;

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
}
