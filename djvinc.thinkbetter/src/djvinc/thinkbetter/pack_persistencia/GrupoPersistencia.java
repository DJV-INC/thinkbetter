package djvinc.thinkbetter.pack_persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.GrupoModel;

public class GrupoPersistencia{
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    ResultSet oResultSet;

    
    public void inserirGrupo(GrupoModel oGrupoModel){

         try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_insert_grupo(?,?)");
                oCall.setString(1, oGrupoModel.getA03_nomeGrupo());
                oCall.setInt(2, oGrupoModel.getA03_idProblema());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void alterarGrupo(GrupoModel oGrupoModel){

         try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_alter_grupo(?,?,?)");
                oCall.setInt(1, oGrupoModel.getA03_idGrupo());
                oCall.setString(2, oGrupoModel.getA03_nomeGrupo());
                oCall.setInt(3, oGrupoModel.getA03_idProblema());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void excluirGrupo(GrupoModel oGrupoModel){

         try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_delete_grupo(?)");
                oCall.setInt(1, oGrupoModel.getA03_idGrupo());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

}