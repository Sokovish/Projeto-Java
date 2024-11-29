/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.Conexao;
import dao.UsuarioDAO;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modell.Usuario;
import view.Login;
import view.Agendamento;

/**
 *
 * @author Pc
 */
public class LoginController {
    private final Login view;

    public LoginController(Login view) {
        this.view = view;
    }

    public void autenticar() throws SQLException {
        
        //Buscar um usuario da View
        String email = view.getEmailLogin().getText();
        String senha = view.getSenhaLogin().getText();
        
        Usuario usuarioAutenticar = new Usuario (email, senha);
        //Verificar se existe no DB
        Connection Conexao = (Connection) new Conexao().getConnection();
        UsuarioDAO UsuarioDao = new UsuarioDAO((java.sql.Connection) Conexao);
        
        boolean existe = UsuarioDao.exiteNoBancoPorEmailESenha(usuarioAutenticar);
        
        //Se existir direcionar para sistemaFrequencia
        if(existe){
            JOptionPane.showMessageDialog(view, "Olá, você fez o login!", "Login realizado com sucesso", JOptionPane.INFORMATION_MESSAGE);
            Agendamento a = new Agendamento();
            view.dispose();
            a.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(view, "Email ou senha inválido!");
        }
        
    }
    
}
