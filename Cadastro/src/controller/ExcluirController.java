package controller;

import dao.AgendamentoDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.Agendamento;
import dao.Conexao;
import java.sql.Connection;

public class ExcluirController {
    private final Agendamento view;

    // Construtor que recebe a view Agendamento
    public ExcluirController(Agendamento view){
        this.view = view;
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
}
