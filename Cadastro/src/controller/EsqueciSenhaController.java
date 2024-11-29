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
import view.EsqueciSenha;

/**
 *
 * @author Pc
 */
public class EsqueciSenhaController {
    private final EsqueciSenha view;
    public EsqueciSenhaController(EsqueciSenha view){
        this.view = view;
    }
    
    public void esqueci () throws SQLException{
    String email = view.getEmail().getText();
    String senha = view.getSenha().getText();
    
    Usuario usuario = new Usuario (email, senha);
    
    Connection Conexao = (Connection) new Conexao().getConnection();
    UsuarioDAO UsuarioDao = new UsuarioDAO((java.sql.Connection) Conexao);
    
    boolean existe = UsuarioDao.exiteNoBancoPorEmail(usuario);
    
    if(existe){
         try {
            UsuarioDao.update(usuario);
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroUserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(view, "Senha atualizada com sucesso!", "Atualizado!", JOptionPane.INFORMATION_MESSAGE);
     }else {
     
        JOptionPane.showMessageDialog(view, "Email informado errado ou inexistente", "Erro", JOptionPane.ERROR_MESSAGE);
    
    }
     
     
    }
    
    
}
