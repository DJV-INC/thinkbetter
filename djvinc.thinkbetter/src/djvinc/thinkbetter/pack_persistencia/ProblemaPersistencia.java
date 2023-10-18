package djvinc.thinkbetter.pack_persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.ProblemaModel;

public class ProblemaPersistencia{
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    ResultSet oResultSet;

    public void inserirProblema(ProblemaModel oProblemaModel){

         try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_insert_problema(?,?)");
                oCall.setInt(1, oProblemaModel.getA02_idEmpresa());
                oCall.setString(2, oProblemaModel.getA02_descProblema());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    
    public void alterarProblema(ProblemaModel oProblemaModel) {
        try {
            try {
                oCall = oConectar.getConexao().prepareCall("CALL proc_alter_problema(?,?,?)");
                oCall.setInt(1, oProblemaModel.getA02_idProblema());
                oCall.setInt(2, oProblemaModel.getA02_idEmpresa());
                oCall.setString(3,oProblemaModel.getA02_descProblema());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluirProblema(ProblemaModel oProblemaModel) {
        try {
            try {
                oCall = oConectar.getConexao().prepareCall("CALL proc_delete_problema(?)");
                oCall.setInt(1, oProblemaModel.getA02_idProblema());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}