package djvinc.thinkbetter.pack_persistencia;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.EspecialistaModel;

public class EspecialistaPersistencia{
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    ResultSet oResultSet;
    Statement oStat;

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
                oCall.setInt(1, oEspecialistaModel.getA04_idEspecialista());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }
    
    public List<EspecialistaModel> consultarEspecialista() {
    	List<EspecialistaModel> lista = new ArrayList<>();
    	
    	try {
            try {
               oStat = oConectar.getConexao().createStatement();
               oResultSet = oStat.executeQuery("select * from vw_especialista04 order by a04_idEspecialista");
               
               while (oResultSet.next()) {
            	   EspecialistaModel oEspecialistaModel = new EspecialistaModel();
            	   
            	   oEspecialistaModel.setA04_idEspecialista(oResultSet.getInt(1));
            	   oEspecialistaModel.setA04_tipoEspecializacao(oResultSet.getString(2));
            	   oEspecialistaModel.setA04_idGrupo(oResultSet.getInt(3));
            	   oEspecialistaModel.setA04_idEmpresa(oResultSet.getInt(4));
            	   
            	   lista.add(oEspecialistaModel);
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