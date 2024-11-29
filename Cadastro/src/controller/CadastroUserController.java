/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modell.Usuario;
import view.CadastroUserLogin;

/**
 *
 * @author Pc
 */
public class CadastroUserController {
    private final CadastroUserLogin view;

    public CadastroUserController(CadastroUserLogin view) {
        this.view = view;
    }
    
    
    public void SalvaUser() {
        
            String email = view.getEmailUser().getText();
            String senha = view.getSenhaUser().getText();
            String nome = view.getNomeUser().getText();
            String sobrenome = view.getSobrenomeUser().getText();
            
            Usuario usuarioCad = new Usuario(email, senha, nome, sobrenome);
            
        try {
            Connection Conexao = (Connection) new Conexao().getConnection();
            UsuarioDAO UsuarioDao = new UsuarioDAO((java.sql.Connection) Conexao);
            UsuarioDao.insert(usuarioCad);
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
