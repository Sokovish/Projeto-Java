/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import modell.Aluno;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Pc
 */
public class AlunoDao {
    private final Connection connection;
    
    public AlunoDao (Connection connection) {
        this.connection = connection;
    }
    
    public void insert (Aluno frequencia) throws SQLException { 
        String sql = "insert into frequencia(matricula, nome) values('"+frequencia.getMatricula()+"', '"+frequencia.getNome()+"'); "; 
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.execute();
            
            connection.close();
    }
}
