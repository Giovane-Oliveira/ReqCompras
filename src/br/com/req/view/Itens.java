/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.req.view;

import br.com.req.dao.FuncionarioDao;
import br.com.req.dao.ReqDAO;
import br.com.req.model.Funcionario;
import br.com.req.model.Item;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Suporte
 */
public class Itens extends javax.swing.JFrame {

    /**
     * Creates new form ReqFuncionarios
     */
    public Itens() {
        initComponents();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/br/com/req/images/logo.png")));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtpesquisar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnPesquisar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaFuncionarios = new javax.swing.JTable();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        txtpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpesquisarActionPerformed(evt);
            }
        });
        txtpesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpesquisarKeyPressed(evt);
            }
        });

        jLabel1.setText("Item: ");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        TabelaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Codigo", "Grupo", "Unidade", "Descricao"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TabelaFuncionarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaFuncionariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaFuncionarios);
        if (TabelaFuncionarios.getColumnModel().getColumnCount() > 0) {
            TabelaFuncionarios.getColumnModel().getColumn(0).setResizable(false);
            TabelaFuncionarios.getColumnModel().getColumn(0).setPreferredWidth(20);
            TabelaFuncionarios.getColumnModel().getColumn(1).setResizable(false);
            TabelaFuncionarios.getColumnModel().getColumn(1).setPreferredWidth(20);
            TabelaFuncionarios.getColumnModel().getColumn(2).setResizable(false);
            TabelaFuncionarios.getColumnModel().getColumn(2).setPreferredWidth(20);
            TabelaFuncionarios.getColumnModel().getColumn(3).setResizable(false);
            TabelaFuncionarios.getColumnModel().getColumn(3).setPreferredWidth(300);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnPesquisar))
                .addGap(37, 37, 37)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpesquisarActionPerformed

    }//GEN-LAST:event_txtpesquisarActionPerformed

    private void txtpesquisarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisarKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {

            ReqDAO dao = new ReqDAO();
            List<Item> lista = dao.consultarItemReqPorDesc("%" + txtpesquisar.getText() + "%");
            DefaultTableModel dados = (DefaultTableModel) TabelaFuncionarios.getModel();
            dados.setNumRows(0);
            for (Item c : lista) {

                dados.addRow(new Object[]{
                    c.getCodigo(),
                    c.getGrupo(),
                    c.getUnidade(),
                    c.getDescricao()

                });
            }

        }


    }//GEN-LAST:event_txtpesquisarKeyPressed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

        ReqDAO dao = new ReqDAO();
        List<Item> lista = dao.consultarItemReqPorDesc("%" + txtpesquisar.getText() + "%");
        DefaultTableModel dados = (DefaultTableModel) TabelaFuncionarios.getModel();
        dados.setNumRows(0);
        for (Item c : lista) {

            dados.addRow(new Object[]{
                c.getCodigo(),
                c.getGrupo(),
                c.getUnidade(),
                c.getDescricao()

            });

        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        listar();
    }//GEN-LAST:event_formWindowActivated

    private void TabelaFuncionariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaFuncionariosMouseClicked
        // TODO add your handling code here:
        ReqCompras req = ReqCompras.x;

        req.Item.setText(TabelaFuncionarios.getValueAt(TabelaFuncionarios.getSelectedRow(), 0).toString());
        req.Unidade.setText(TabelaFuncionarios.getValueAt(TabelaFuncionarios.getSelectedRow(), 2).toString());
        req.lblItem.setText( TabelaFuncionarios.getValueAt(TabelaFuncionarios.getSelectedRow(), 3).toString());
        req.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_TabelaFuncionariosMouseClicked

    public void listar() {

        // TODO add your handling code here:
        ReqDAO dao = new ReqDAO();
        List<Item> lista = dao.ListarItens();
        DefaultTableModel dados = (DefaultTableModel) TabelaFuncionarios.getModel();
        dados.setNumRows(0);
        for (Item c : lista) {

            dados.addRow(new Object[]{
                c.getCodigo(),
                c.getGrupo(),
                c.getUnidade(),
                c.getDescricao()

            });
        }

    }

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
            java.util.logging.Logger.getLogger(Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Itens.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Itens().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelaFuncionarios;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtpesquisar;
    // End of variables declaration//GEN-END:variables
}
