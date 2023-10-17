package djvinc.thinkbetter.pack_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ConexaoDao {
    public Connection oConnection = null;
    private final String URL = "jdbc:mysql://localhost:3306/bd_decisao";
    public static Connection conn;
    private final String DATABASE = "bd_decisao";
    private final String USERNAME = "root";
    private final String PASSWORD = "200467lol";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public boolean testConnection() {
        try {
            Class.forName(DRIVER);
            oConnection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conexão sucedida");
            return true;
        } catch (ClassNotFoundException erro) {
            System.out.println("Driver não encontrado" + erro.toString());
            return false;
        } catch (SQLException erro) {
            System.out.println("Falha ao conectar" + erro.toString());
            return false;
        }
    }

    public Connection getConexao() throws SQLException {
        conn = null;
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Conectado");
            return conn;
        }

        catch (ClassNotFoundException e) {
            throw new SQLException("Driver não encontrado", e);
        }
        catch (SQLException e) {
            throw new SQLException("Erro ao obter a conexao", e);
        }
    }
}
