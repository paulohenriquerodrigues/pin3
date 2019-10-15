package br.edu.udesc.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author paulohenrique
 */
public class Conexao {
    
    public static Connection createConnection() throws SQLException, ClassNotFoundException {
        String url = "jdbc:postgresql://localhost:5432/pin"; //Nome da base de dados
        String user = "postgres"; //nome do usuário do postgres
        String password = "postgres"; //senha do postgres
        
      
        Class.forName("org.postgresql.Driver");
        

        Connection conexao = null;
        conexao = DriverManager.getConnection(url, user, password);
        

        return conexao;
    }
}
