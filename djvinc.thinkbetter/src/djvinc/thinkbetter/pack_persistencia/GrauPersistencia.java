package djvinc.thinkbetter.pack_persistencia;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.GrauModel;


public class GrauPersistencia{
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    ResultSet oResultSet;
	Statement oStat;

    
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
    
    public List<GrauModel> consultarGrau() {
    	List<GrauModel> lista = new ArrayList<>();
    	
    	try {
            try {
               oStat = oConectar.getConexao().createStatement();
               oResultSet = oStat.executeQuery("select * from vw_grau06 order by a06_idGrau");
               
               while (oResultSet.next()) {
            	   GrauModel oGrauModel = new GrauModel();
            	   
            	   oGrauModel.setA06_idGrau(oResultSet.getInt(1));
            	   oGrauModel.setA06_grauCerteza(oResultSet.getInt(2));
            	   oGrauModel.setA06_grauIncerteza(oResultSet.getInt(3));
            	   oGrauModel.setA06_idCriterio(oResultSet.getInt(4));
            	   oGrauModel.setA06_idEspecialista(oResultSet.getInt(5));
            	  
            	   lista.add(oGrauModel);
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