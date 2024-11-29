/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controller.AgendamentoController;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class Agendamento extends javax.swing.JFrame {

    private final AgendamentoController controllerAgendamento;
   

    
    public Agendamento() throws SQLException {
        initComponents();
        controllerAgendamento = new AgendamentoController(this);
       
        
        
        DefaultTableModel modeloTabela = new DefaultTableModel(new Object[][] {}, new String[] {
        "ID","Responsável", "Motivo", "Hr Inicial", "Hr Final", "Data","Descrição",
        });
        
        tabela.setModel(modeloTabela);
    }

    private boolean validarCampos() {
    if (responsavel.getText().isEmpty() || motivo.getText().isEmpty() || data.getText().isEmpty() || 
        hrInicial.getText().isEmpty() || hrFinal.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Preencha todos os campos obrigatórios!", "Erro", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.aaaa
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        motivo = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        btnAgendar = new javax.swing.JButton();
        data = new javax.swing.JTextField();
        responsavel = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        btnAtualizar = new javax.swing.JButton();
        hrInicial = new javax.swing.JTextField();
        jLabel91 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        hrFinal = new javax.swing.JTextField();
        jScrollPane12 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        btnConsulta = new javax.swing.JButton();
        jLabel92 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricao = new javax.swing.JTextArea();
        buscar = new javax.swing.JTextField();
        jLabel98 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        logout = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel93.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(255, 255, 255));
        jLabel93.setText("DATA:");

        btnAgendar.setText("AGENDAR");
        btnAgendar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgendarMouseClicked(evt);
            }
        });
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        responsavel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                responsavelActionPerformed(evt);
            }
        });

        btnExcluir.setText("EXCLUIR");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        jLabel94.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("HORÁRIO INICIAL:");

        jLabel95.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText("HORÁRIO FINAL:");

        btnAtualizar.setText("ATUALIZAR");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        jLabel91.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("MOTIVO:");

        jLabel96.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("DESCRIÇÃO (opcional)");

        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Responsável", "Motivo", "Hr Inicial", "Hr Final", "Data", "Descrição"
            }
        ));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tabela);

        btnConsulta.setText("CONSULTAR");
        btnConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultaActionPerformed(evt);
            }
        });

        jLabel92.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("RESPONSÁVEL:");

        id.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idActionPerformed(evt);
            }
        });

        jLabel97.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setText("ID:");

        descricao.setColumns(20);
        descricao.setRows(5);
        jScrollPane1.setViewportView(descricao);

        jLabel98.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(255, 255, 255));
        jLabel98.setText("Buscar:");

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("BUSCAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel91)
                                    .addComponent(jLabel92)
                                    .addComponent(jLabel94)
                                    .addComponent(jLabel93)
                                    .addComponent(jLabel95))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(hrFinal, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hrInicial, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(responsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(motivo, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel97)
                                .addGap(18, 18, 18)
                                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 400, Short.MAX_VALUE)
                        .addComponent(jLabel96)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel98)
                            .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(76, 76, 76))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel97)
                            .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel96))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92)
                            .addComponent(responsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(motivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel91))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel94)
                            .addComponent(hrInicial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(hrFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel95))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel93)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jLabel98)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgendar)
                    .addComponent(btnAtualizar)
                    .addComponent(btnConsulta)
                    .addComponent(btnExcluir)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jMenuBar1.setForeground(new java.awt.Color(51, 51, 51));

        jMenu1.setText("Opções");

        logout.setText("Logout");
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        jMenu1.add(logout);

        jMenuItem1.setText("Sobre");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void responsavelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_responsavelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_responsavelActionPerformed

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed

        
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void idActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        try {
            controllerAgendamento.Excluir();
            controllerAgendamento.Consultar();
        } catch (SQLException ex) {
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
         // Verifique se o campo necessário está vazio antes de tentar realizar a atualização
    if (id.getText().isEmpty()) {
    JOptionPane.showMessageDialog(this, "O campo (ID) não pode estar vazio!", "Erro", JOptionPane.ERROR_MESSAGE);
} else {
    try {
        // Chama o método de atualização
        controllerAgendamento.update();

        // Atualiza a lista de itens (presumindo que seja necessário)
        controllerAgendamento.Consultar();

        // Exibe a mensagem de sucesso
        JOptionPane.showMessageDialog(this, "Atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);

    } catch (SQLException ex) {
        // Caso ocorra um erro de SQL, exibe a mensagem de erro
        JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);

    } catch (ParseException ex) {
        // Caso ocorra um erro de formatação (ParseException), registra o erro
        Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, "Erro ao realizar o parsing", ex);
    }
}

    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnAgendarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarMouseClicked
        if (validarCampos()) {
        try {
            controllerAgendamento.insert();
            controllerAgendamento.Consultar();
            JOptionPane.showMessageDialog(this, "Agendamento realizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao agendar: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    }//GEN-LAST:event_btnAgendarMouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
       int row = tabela.getSelectedRow();
        DefaultTableModel tbl = (DefaultTableModel) tabela.getModel();
        id.setText(tbl.getValueAt(row, 0).toString());
        responsavel.setText(tbl.getValueAt(row, 1).toString());
        motivo.setText(tbl.getValueAt(row, 2).toString());
        hrInicial.setText(tbl.getValueAt(row, 3).toString());
        hrFinal.setText(tbl.getValueAt(row, 4).toString());
        data.setText(tbl.getValueAt(row, 5).toString());
        descricao.setText(tbl.getValueAt(row, 6).toString());
    }//GEN-LAST:event_tabelaMouseClicked

    private void btnConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultaActionPerformed
        try {
        controllerAgendamento.Consultar();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Erro ao atualizar tabela: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_btnConsultaActionPerformed

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        Login l = new Login();
        this.dispose();
       l.setVisible(true);
    }//GEN-LAST:event_logoutActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Sobre s = new Sobre();
        this.dispose();
        s.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agendamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Agendamento().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Agendamento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public JTextField getId() {
        return id;
    }

    public void setId(JTextField id) {
        this.id = id;
    }
    
    public JTextField getData() {
        return data;
    }

    public void setData(JTextField data) {
        this.data = data;
    }

    public JTextArea getDescricao() {
        return descricao;
    }

    public void setDescricao(JTextArea descricao) {
        this.descricao = descricao;
    }

    public JTextField getHrFinal() {
        return hrFinal;
    }

    public void setHrFinal(JTextField hrFinal) {
        this.hrFinal = hrFinal;
    }

    public JTextField getHrInicial() {
        return hrInicial;
    }

    public void setHrInicial(JTextField hrInicial) {
        this.hrInicial = hrInicial;
    }

    public JTextField getMotivo() {
        return motivo;
    }

    public void setMotivo(JTextField motivo) {
        this.motivo = motivo;
    }

    public JTextField getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(JTextField responsavel) {
        this.responsavel = responsavel;
    }

    public JTable getTabela() {
        return tabela;
    }

    public void setTabela(JTable tabela) {
        this.tabela = tabela;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendar;
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnConsulta;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JTextField buscar;
    private javax.swing.JTextField data;
    private javax.swing.JTextArea descricao;
    private javax.swing.JTextField hrFinal;
    private javax.swing.JTextField hrInicial;
    private javax.swing.JTextField id;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JMenuItem logout;
    private javax.swing.JTextField motivo;
    private javax.swing.JTextField responsavel;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables

}


