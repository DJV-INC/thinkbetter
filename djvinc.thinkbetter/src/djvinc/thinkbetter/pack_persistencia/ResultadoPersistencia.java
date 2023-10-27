package djvinc.thinkbetter.pack_persistencia;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.ResultadoModel;

public class ResultadoPersistencia {
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    ResultSet oResultSet;
    Statement oStat;

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
    
    public List<ResultadoModel> consultarResultado () {
    	List<ResultadoModel> lista = new ArrayList<>();
    	
    	try {
            try {
               oStat = oConectar.getConexao().createStatement();
               oResultSet = oStat.executeQuery("select * from vw_resultado07 order by #");
               
               while (oResultSet.next()) {
            	   ResultadoModel oResultadoModel = new ResultadoModel();
            	   
            	   oResultadoModel.setA07_idResultado(oResultSet.getInt(1));
            	   oResultadoModel.setA07_resultado(oResultSet.getInt(2));
            	   oResultadoModel.setA07_descricao(oResultSet.getString(3));
            	   
            	  
            	   lista.add(oResultadoModel);
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
