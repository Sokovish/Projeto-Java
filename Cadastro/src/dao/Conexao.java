
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Conexao {
    public Connection getConnection () throws SQLException{
        try {
        Connection conexao = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ProjetoJava", "postgres", "admin");
        System.out.println("conectado ao banco de dados");
        return conexao;
        }catch(SQLException e){
            System.out.println("Erro ao conectar ao banco de dados " + e);
            return null;
        }
        
    }
}
