/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.req.model;

import br.com.req.view.ReqCompras;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Giovane Oliveira
 */
public class Utilitarios {

    public void LimpaTela(JPanel container) {

        Component components[] = container.getComponents();
        for (Component component : components) {

            if (component instanceof JTextField) {

                ((JTextField) component).setEnabled(false);

            } else if (component instanceof JTextArea) {
                ((JTextArea) component).setText(null);
                ((JTextArea) component).setText(null);
                ((JTextArea) component).setEnabled(false);

            } else if (component instanceof JButton) {

                ((JButton) component).setEnabled(false);

            } else if (component instanceof JComboBox) {

                ((JComboBox) component).setEnabled(false);

            } else if (component instanceof JScrollPane) {

                ((JScrollPane) component).setEnabled(false);

            }

        }

    }

    public void LimpaTela2(JPanel container) {

        Component components[] = container.getComponents();
        for (Component component : components) {

            if (component instanceof JTextField) {

                ((JTextField) component).setText(null);
                ((JTextField) component).setEnabled(true);

            } else if (component instanceof JTextArea) {
                ((JTextArea) component).setText(null);
                ((JTextArea) component).setText(null);
                ((JTextArea) component).setEnabled(true);

            } else if (component instanceof JButton) {

                ((JButton) component).setEnabled(true);

            } else if (component instanceof JComboBox) {

                ((JComboBox) component).setEnabled(true);

            } else if (component instanceof JScrollPane) {

                ((JScrollPane) component).setEnabled(true);

            }

            ReqCompras req = ReqCompras.x;
            req.Lblsolicitante.setText(null);
            req.lblFornecedor.setText(null);
            req.lblAutoriazador.setText(null);
            req.jLabel9.setText(null);
            req.centroDoCusto.setEnabled(false);
            req.Ccbtn.setEnabled(false);
            req.Complemento.setEnabled(true);
            req.Complemento.setEditable(true);
            ((DefaultTableModel) req.TabelaItens.getModel()).setRowCount(0);

        }

    }

    public void limpaTabela() {

        ReqCompras req = ReqCompras.x;
        req.centroDoCusto.setEnabled(false);
        req.Ccbtn.setEnabled(false);
        ((DefaultTableModel) req.TabelaItens.getModel()).setRowCount(0);
    }

}
