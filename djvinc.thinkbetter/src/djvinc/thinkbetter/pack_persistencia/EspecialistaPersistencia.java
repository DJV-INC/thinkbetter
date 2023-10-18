package djvinc.thinkbetter.pack_persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.EspecialistaModel;

public class EspecialistaPersistencia{
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    ResultSet oResultSet;

    public void inserirEspecialista(EspecialistaModel oEspecialistaModel){

        try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_insert_especialista(?,?,?)");
                oCall.setString(1, oEspecialistaModel.getA04_tipoEspecializacao());
                oCall.setInt(2, oEspecialistaModel.getA04_idGrupo());
                oCall.setInt(3, oEspecialistaModel.getA04_idEmpresa());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void alterarEspecialista(EspecialistaModel oEspecialistaModel){

        try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_alter_especialista(?,?,?,?)");
                oCall.setInt(1, oEspecialistaModel.getA04_idEmpresa());
                oCall.setString(2, oEspecialistaModel.getA04_tipoEspecializacao());
                oCall.setInt(3, oEspecialistaModel.getA04_idGrupo());
                oCall.setInt(4, oEspecialistaModel.getA04_idEmpresa());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void excluirEspecialista(EspecialistaModel oEspecialistaModel){

        try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_delete_especialista(?)");
                oCall.setInt(2, oEspecialistaModel.getA04_idEmpresa());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}