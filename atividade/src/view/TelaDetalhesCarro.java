package view;

import controller.VeiculoController;
import exception.BancoDadosVazioException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Carro;

/**
 *
 * @author Familia
 */
public class TelaDetalhesCarro extends javax.swing.JFrame {

    private Tela tela;
    DefaultTableModel modeloTabela;
    int linhaSelecionada = -1;
    
    public TelaDetalhesCarro() {
        initComponents();
    }
    public TelaDetalhesCarro(Tela tela) {
        initComponents();
        this.tela = tela;
        this.modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Marca");
        modeloTabela.addColumn("Modelo");
        modeloTabela.addColumn("Quantidade de portas");
        jTable1.setModel(modeloTabela);
        atualizarInformacao();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        imgHome = new javax.swing.JLabel();
        btnRemover = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Marca", "Modelo", "Quantidade de portas"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        imgHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home.png"))); // NOI18N
        imgHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                imgHomeMouseClicked(evt);
            }
        });

        btnRemover.setText("Remover");
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(imgHome)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(btnRemover)
                .addGap(121, 121, 121)
                .addComponent(btnAlterar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(imgHome)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRemover)
                    .addComponent(btnAlterar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        linhaSelecionada = jTable1.getSelectedRow();
        
        VeiculoController controller = new VeiculoController();
        
        if (linhaSelecionada == -1) {
            JOptionPane.showMessageDialog(null, "Selecione uma linha para alterar!", "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String marcaAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 0);
        String modeloAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 1);
        String numeroPortasAtual = (String) modeloTabela.getValueAt(linhaSelecionada, 2);
        
        String novoMarca = JOptionPane.showInputDialog(null, "Digite a nova marca: ", marcaAtual);
        String novoModelo = JOptionPane.showInputDialog(null, "Digite o novo modelo: ", modeloAtual);
        String novoNumeroPortas = JOptionPane.showInputDialog(null, "Digite a nova quantidade de portas: ", numeroPortasAtual);
        
        if(controller.alterarCarro(linhaSelecionada, novoMarca, novoModelo, novoNumeroPortas)){
            JOptionPane.showMessageDialog(null,"Alteração feita com sucesso", "Sucesso",
                                          JOptionPane.INFORMATION_MESSAGE);
            atualizarInformacao();
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        linhaSelecionada = jTable1.getSelectedRow();
        VeiculoController controller = new VeiculoController();
        if(controller.removerCarro(linhaSelecionada)){
            JOptionPane.showMessageDialog(null, "Remoção realizada com sucesso");
            atualizarInformacao();
        }
        
    }//GEN-LAST:event_btnRemoverActionPerformed

    private void imgHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_imgHomeMouseClicked
        tela.atualizarTabela();
        tela.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_imgHomeMouseClicked

    public void atualizarInformacao(){
        modeloTabela.setRowCount(0);
        
        VeiculoController controller = new VeiculoController();
        ArrayList<Carro> lista = controller.listarCarros();
        
        if(lista != null){
            for(Carro carro : lista){
                modeloTabela.addRow(new Object[]{carro.getMarca(), carro.getModelo(), carro.getNumeroPortas()});
            }
        }
    }
    
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
            java.util.logging.Logger.getLogger(TelaDetalhesCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDetalhesCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDetalhesCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDetalhesCarro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaDetalhesCarro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnRemover;
    private javax.swing.JLabel imgHome;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
