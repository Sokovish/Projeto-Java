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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Pc
 */
public class AgendamentoController {
    private final Agendamento view;
    public AgendamentoController(Agendamento view) {
        this.view = view;

     }
    
    public void insert() throws SQLException, ParseException {
        String responsavel = view.getResponsavel().getText();
        String motivo = view.getMotivo().getText();
        String hrInicial = view.getHrInicial().getText();
        String hrFinal = view.getHrFinal().getText();
        String descricao = view.getDescricao().getText();
        String data = view.getData().getText();
        
            
        Agenda agendaCad = new Agenda(responsavel, motivo, hrInicial, hrFinal, descricao, data);
            
        try{
            Connection Conexao = (Connection) new Conexao().getConnection();
            AgendamentoDAO AgendamentoDao = new AgendamentoDAO((java.sql.Connection) Conexao);
            AgendamentoDao.insert(agendaCad);
        }catch (SQLException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    // Método que será chamado para excluir um agendamento
    public void Excluir() throws SQLException {
        // Acessando o campo de texto do ID a partir da view
        String idText = view.getId().getText();
        Connection conexao = new Conexao().getConnection();
        AgendamentoDAO agendamentoDao = new AgendamentoDAO(conexao);
        if (idText.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Informe o ID do usuário para excluir.");
        } else {
            int id = Integer.parseInt(idText);
            int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir?", "AVISO",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (resposta == JOptionPane.YES_OPTION) { // Se o usuário confirmar a exclusão
                try {

                    agendamentoDao.excluirAgendamento(id); // Chamando o método de exclusão no DAO

                    // Mensagem de sucesso
                    JOptionPane.showMessageDialog(view, "Usuário excluído com sucesso");

                     
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(view, "Erro ao converter o ID para número: " + e.getMessage());
                }
            }
        }
    }
    public List<Agenda> Consultar() throws SQLException {
        List<Agenda> dados = new ArrayList<>();
        try {
            // Estabelece a conexão com o banco de dados
            Connection conexao = new Conexao().getConnection();
            AgendamentoDAO agendamentoDAO = new AgendamentoDAO(conexao);

            // Busca os agendamentos
            dados = agendamentoDAO.Consultar(); // Agora estamos usando a instância do DAO para chamar o método

            // Limpa a tabela antes de exibir os novos dados
            DefaultTableModel modeloTabela = (DefaultTableModel) view.getTabela().getModel();
            modeloTabela.setRowCount(0); // Limpa a tabela

            // Adiciona os dados à tabela
            for (Agenda agenda : dados) {
                modeloTabela.addRow(new Object[]{
                    agenda.getId(),
                    agenda.getResponsavel(),
                    agenda.getMotivo(),
                    agenda.getHrInicial(),
                    agenda.getHrFinal(),
                    agenda.getDescricao(),
                    agenda.getData()
                });
            }

        } catch (SQLException ex) {
            Logger.getLogger(AgendamentoController.class.getName()).log(Level.SEVERE, "Erro ao atualizar tabela", ex);
        }
        return dados;
    }
}


