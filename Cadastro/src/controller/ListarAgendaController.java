package controller;

import dao.AgendamentoDAO;
import dao.Conexao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import modell.Agenda;
import view.Agendamento;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListarAgendaController {
    private final Agendamento view;

    public ListarAgendaController(Agendamento view) {
        this.view = view;
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
            Logger.getLogger(ListarAgendaController.class.getName()).log(Level.SEVERE, "Erro ao atualizar tabela", ex);
        }
        return dados;
    }
}
