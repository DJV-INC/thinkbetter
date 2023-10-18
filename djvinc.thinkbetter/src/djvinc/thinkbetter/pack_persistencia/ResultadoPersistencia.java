package djvinc.thinkbetter.pack_persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.EspecialistaModel;
import djvinc.thinkbetter.pack_model.ProblemaModel;
import djvinc.thinkbetter.pack_model.ResultadoModel;

public class ResultadoPersistencia {
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    ResultSet oResultSet;

    public void inserirResultado(ResultadoModel oResultadoModel){

        try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_insert_resultado(?,?)");
                oCall.setInt(1, oResultadoModel.getA07_resultado());
                oCall.setString(2, oResultadoModel.getA07_descricao());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }


    public void alterarResultado(ResultadoModel oResultadoModel) {
        try{
            try {   
               oCall = oConectar.getConexao().prepareCall("CALL proc_alter_resultado(?,?,?)");
               oCall.setInt(1, oResultadoModel.getA07_idResultado());
               oCall.setInt(2, oResultadoModel.getA07_resultado());
               oCall.setString(3, oResultadoModel.getA07_descricao());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }


    public void excluirResultado(ResultadoModel oResultadoModel){

        try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_delete_resultado(?)");
                oCall.setInt(1, oResultadoModel.getA07_idResultado());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}
