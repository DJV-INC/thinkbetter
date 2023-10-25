package djvinc.thinkbetter.pack_persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.EmpresaModel;

public class EmpresaPersistencia {
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
    Statement oStat;
    ResultSet oResultSet;

    public void inserirEmpresa(EmpresaModel oEmpresaModel){

        try{
            try {   
                oCall = oConectar.getConexao().prepareCall("CALL proc_insert_empresa(?)");
                oCall.setString(1, oEmpresaModel.getA01_nomeEmpresa());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    public void alterarEmpresa(EmpresaModel oEmpresaModel) {
        try {
            try {
                oCall = oConectar.getConexao().prepareCall("CALL proc_alter_empresa(?,?)");
                oCall.setInt(1, oEmpresaModel.getA01_codigo());
                oCall.setString(2, oEmpresaModel.getA01_nomeEmpresa());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void excluirEmpresa(EmpresaModel oEmpresaModel) {
        try {
            try {
                oCall = oConectar.getConexao().prepareCall("CALL proc_delete_empresa(?)");
                oCall.setInt(1, oEmpresaModel.getA01_codigo());
                oCall.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<EmpresaModel> consultarEmpresa() {
    	List<EmpresaModel> lista = new ArrayList<>();
 
    	try {
            try {
               oStat = oConectar.getConexao().createStatement();
               oResultSet = oStat.executeQuery("select * from vw_empresa01 order by a01_idEmpresa");
               
               while (oResultSet.next()) {
            	   EmpresaModel oEmpresaModel = new EmpresaModel();
            	   
            	   oEmpresaModel.setA01_codigo(oResultSet.getInt(1));
            	   oEmpresaModel.setA01_nomeEmpresa(oResultSet.getString(2));
            	   
            	   lista.add(oEmpresaModel);
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