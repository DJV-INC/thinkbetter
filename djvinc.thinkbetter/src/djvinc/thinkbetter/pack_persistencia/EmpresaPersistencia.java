package djvinc.thinkbetter.pack_persistencia;

import java.sql.ResultSet;
import java.sql.SQLException;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;

import djvinc.thinkbetter.pack_dao.ConexaoDao;
import djvinc.thinkbetter.pack_model.EmpresaModel;

public class EmpresaPersistencia {
    CallableStatement oCall;
    ConexaoDao oConectar = new ConexaoDao();
    PreparedStatement oPrepared;
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
}