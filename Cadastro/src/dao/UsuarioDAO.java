/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modell.Usuario;


public class UsuarioDAO {
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }
    
    public void insert(Usuario usuario) throws SQLException{
        
        try (connection) { 
            String sql = "insert into usuario(email, senha, nome, sobrenome) values(?, ?, ?, ?); ";
            PreparedStatement ps = connection.prepareStatement(sql);
            
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getSenha());
            ps.setString(3, usuario.getNome());
            ps.setString(4, usuario.getSobrenome());
            ps.execute();
        }
    }

    public boolean exiteNoBancoPorEmailESenha(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        
        ps.setString(1, usuario.getEmail());
        ps.setString(2, usuario.getSenha());
        ps.execute();
        
        ResultSet resultSet = ps.getResultSet();
        
        return resultSet.next();
    }
    
    public boolean exiteNoBancoPorEmail(Usuario usuario) throws SQLException {
        String sql = "SELECT * FROM usuario WHERE email = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        
        ps.setString(1, usuario.getEmail());
        ps.execute();
        
        ResultSet resultSet = ps.getResultSet();
        
        return resultSet.next();
    }
    
   public void update(Usuario usuario) throws SQLException {
       String sql = "UPDATE usuario SET senha = ? WHERE email = ?";
       PreparedStatement  ps = connection.prepareStatement(sql);
       
       ps.setString(1, usuario.getSenha());
       ps.setString(2, usuario.getEmail());
       ps.execute();
       
   
   }

}
