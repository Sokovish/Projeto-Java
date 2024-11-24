/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AgendamentoDAO;
import dao.Conexao;
import modell.Agenda;
import view.Agendamento;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc
 */
public class AtualizarController {
    private final Agendamento view;
    public AtualizarController(Agendamento view) {
        this.view = view;

    }
    
    public void update() throws SQLException, ParseException {
        int id = Integer.parseInt(view.getId().getText());
        String responsavel = view.getResponsavel().getText();
        String motivo = view.getMotivo().getText();
        String hrInicial = view.getHrInicial().getText();
        String hrFinal = view.getHrFinal().getText();
        String descricao = view.getDescricao().getText();
        String data = view.getData().getText();
        
            
        Agenda agendaCad = new Agenda(id, responsavel, motivo, hrInicial, hrFinal, descricao, data);
            
        try{
            Connection Conexao = (Connection) new Conexao().getConnection();
            AgendamentoDAO AgendamentoDao = new AgendamentoDAO((java.sql.Connection) Conexao);
            AgendamentoDao.Update(agendaCad);
            
        }catch (SQLException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


