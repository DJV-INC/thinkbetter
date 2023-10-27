package djvinc.thinkbetter.pack_persistencia;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.EmpresaModel;
import djvinc.thinkbetter.pack_model.GrupoModel;

public class GrupoPersistencia{
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    ResultSet oResultSet;
	Statement oStat;

    
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
    
    public List<GrupoModel> consultarGrupo() {
    	List<GrupoModel> lista = new ArrayList<>();
    	
    	try {
            try {
               oStat = oConectar.getConexao().createStatement();
               oResultSet = oStat.executeQuery("select * from vw_grupo03 order by a03_idGrupo");
               
               while (oResultSet.next()) {
            	   GrupoModel oGrupoModel = new GrupoModel();
            	   
            	   oGrupoModel.setA03_idGrupo(oResultSet.getInt(1));
            	   oGrupoModel.setA03_nomeGrupo(oResultSet.getString(2));
            	   oGrupoModel.setA03_idProblema(oResultSet.getInt(3));
            	   
            	   lista.add(oGrupoModel);
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