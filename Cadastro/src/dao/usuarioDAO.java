/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modell.Usuario;
import view.CadastroUserLogin;

public class usuarioDAO {
    private final Connection connection;

    public usuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario) throws SQLException{
        
            String sql = "insert into usuario(email, senha) values('"+usuario.getEmail()+"', '"+usuario.getSenha()+"'); "; 
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            
            connection.close();
    }
}
