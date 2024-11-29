/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import modell.Agenda;
import java.sql.Time;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;
import view.Agendamento;

/**
 *
 * @author Pc
 */
public class AgendamentoDAO {
    private final Connection connection;
    
    public AgendamentoDAO (Connection connection) {
        this.connection = connection;
    }
    
    public void insert (Agenda agendar) throws SQLException { 
        String sql = "insert into agendamentos(responsavel, motivo, inicial, final, descricao, data) values(?, ?, ?, ?, ?, ?);";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, agendar.getResponsavel());
            ps.setString(2, agendar.getMotivo());

            // Converter as horas de String para Time
            String hrInicial = agendar.getHrInicial(); // Exemplo: "14:30"
            String hrFinal = agendar.getHrFinal();     // Exemplo: "15:30"

            // Validar e converter para o tipo Time do SQL
            if (hrInicial == null || !hrInicial.matches("\\d{2}:\\d{2}(:\\d{2})?")) {
            throw new IllegalArgumentException("Hora inicial inválida: " + hrInicial);
            }

            if (hrFinal == null || !hrFinal.matches("\\d{2}:\\d{2}(:\\d{2})?")) {
                throw new IllegalArgumentException("Hora final inválida: " + hrFinal);
            }
            ps.setTime(3, Time.valueOf(hrInicial.length() == 5 ? hrInicial + ":00" : hrInicial));
            ps.setTime(4, Time.valueOf(hrFinal.length() == 5 ? hrFinal + ":00" : hrFinal));   // Adicionando segundos se necessário

            ps.setString(5, agendar.getDescricao());

            // Conversão de String para java.util.Date
            String dataString = agendar.getData(); // Exemplo: "23/11/2024"
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date utilDate = inputFormat.parse(dataString); // Converte para java.util.Date

            // Converte java.util.Date para java.sql.Date
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            ps.setDate(6, sqlDate); // Define a data no PreparedStatement

            // Executa o comando
            ps.execute();
        } catch (Exception e) { // Exibe o erro no console
            // Exibe o erro no console
        System.out.println(e);
        throw new SQLException(e);
        }

    }   
   public List<Agenda> Consultar() throws SQLException {
        String sql = "SELECT id, responsavel, motivo, inicial, final, descricao, data FROM agendamentos";
        List<Agenda> dados = new ArrayList<>(); // Inicializa a lista de objetos Agenda

    try (PreparedStatement ps = connection.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) { // Executa a consulta e obtém os resultados
                 
            SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
            

            while (rs.next()) {
                int id = rs.getInt("id");
                String responsavel = rs.getString("responsavel");
                String motivo = rs.getString("motivo");
                String hrInicial = formatoHora.format(rs.getTime("inicial"));  // Formata a hora inicial
                String hrFinal = formatoHora.format(rs.getTime("final"));      // Formata a hora final
                String descricao = rs.getString("descricao");
                String data = formatoData.format(rs.getDate("data"));         // Formata a data
                
                Agenda agenda = new Agenda(id, responsavel, motivo, hrInicial, hrFinal, data, descricao);   
                // Adicionar à lista
                dados.add(agenda); // Adiciona o objeto à lista
        }
            Agendamento view = new Agendamento();
        // Verifica se a tabela está vazia
        if (dados.isEmpty()) {
            JOptionPane.showMessageDialog(view, "A tabela está vazia", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    } catch (SQLException e) {
        System.out.println("Erro ao consultar os dados: " + e.getMessage());
    }

    return dados; // Retorna a lista de objetos Agenda
    }
   
   
   public void Update(Agenda agendar) throws SQLException {
    String sql = "UPDATE agendamentos SET responsavel = ?, motivo = ?, inicial = ?, final = ?, descricao = ?, data = ? WHERE id = ?";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        // Validar e configurar os parâmetros
        System.out.println("ID recebido para atualização: " + agendar.getId());
        
        ps.setString(1, agendar.getResponsavel());
        ps.setString(2, agendar.getMotivo());

        // Converter e configurar os horários
        String hrInicial = agendar.getHrInicial();
        String hrFinal = agendar.getHrFinal();

        if (hrInicial == null || !hrInicial.matches("\\d{2}:\\d{2}(:\\d{2})?")) {
            throw new IllegalArgumentException("Hora inicial inválida: " + hrInicial);
        }
        if (hrFinal == null || !hrFinal.matches("\\d{2}:\\d{2}(:\\d{2})?")) {
            throw new IllegalArgumentException("Hora final inválida: " + hrFinal);
        }
        ps.setTime(3, Time.valueOf(hrInicial.length() == 5 ? hrInicial + ":00" : hrInicial));
        ps.setTime(4, Time.valueOf(hrFinal.length() == 5 ? hrFinal + ":00" : hrFinal));

        // Configurar descrição
        ps.setString(5, agendar.getDescricao());

        // Converter e configurar a data
        String dataString = agendar.getData();
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date utilDate = inputFormat.parse(dataString);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        ps.setDate(6, sqlDate);

         ps.setInt(7, agendar.getId()); 

        // Executar o comando e verificar linhas afetadas
        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated == 0) {
            System.out.println("Nenhuma linha foi atualizada. Verifique o ID.");
        } else {
            System.out.println(rowsUpdated + " linha(s) atualizada(s).");
        }
    } catch (Exception e) {
        System.out.println("Erro ao atualizar: " + e.getMessage());
        throw new SQLException(e);
    }
}
  public void excluirAgendamento(int id) throws SQLException {
    String sql = "DELETE FROM agendamentos WHERE id=?;";
    try (PreparedStatement ps = connection.prepareStatement(sql)) {
        ps.setInt(1, id);
        int rowsAffected = ps.executeUpdate(); // Captura o número de linhas afetadas
        if (rowsAffected > 0) {
            System.out.println("Agendamento: " + id + " excluído com sucesso!");
        } else {
            System.out.println("Nenhum usuário encontrado com o ID: " + id);
        }
    } catch (SQLException e) {
        // Registro da exceção mais detalhado
        System.out.println("Erro ao excluir usuário: " + e.getMessage());
        throw new SQLException("Erro ao excluir usuário com ID " + id, e); // Re-lança a exceção para ser tratada no nível superior
    }
}
}