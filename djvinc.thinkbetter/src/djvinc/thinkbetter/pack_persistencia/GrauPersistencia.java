package djvinc.thinkbetter.pack_persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.GrauModel;


public class GrauPersistencia{
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    ResultSet oResultSet;

    
    public void inserirGrau(GrauModel oGrauModel){

        try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_insert_grau(?,?,?,?)");
                oCall.setInt(1, oGrauModel.getA06_grauCerteza());
                oCall.setInt(2, oGrauModel.getA06_grauIncerteza());
                oCall.setInt(3, oGrauModel.getA06_idCriterio());
                oCall.setInt(4, oGrauModel.getA06_idEspecialista());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void alterarGrau(GrauModel oGrauModel){

        try{
            try {   
               oCall = oConectar.getConexao().prepareCall("CALL proc_alter_grau(?,?,?,?,?)");
                oCall.setInt(1, oGrauModel.getA06_idGrau());
                oCall.setInt(2, oGrauModel.getA06_grauCerteza());
                oCall.setInt(3, oGrauModel.getA06_grauIncerteza());
                oCall.setInt(4, oGrauModel.getA06_idCriterio());
                oCall.setInt(5, oGrauModel.getA06_idEspecialista());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void excluirGrau(GrauModel oGrauModel){

        try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_delete_grau(?)");
                oCall.setInt(1, oGrauModel.getA06_idGrau());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}