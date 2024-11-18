/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rel1t4_frb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Propietario
 */
public class Ejercicio5 extends javax.swing.JFrame {

    JPanel panelPrincipal = new JPanel();

    JMenuBar menuBar = new JMenuBar();
    JMenuItem itemInsertar = new JMenuItem("Insertar");
    JMenuItem itemBorrar = new JMenuItem("Borrar");
    JMenuItem itemMostrar = new JMenuItem("Mostrar");
    JMenuItem itemBuscar = new JMenuItem("Buscar");
    JMenuItem itemActualizar = new JMenuItem("Actualizar");

    PanelInsertar panelInsertar = new PanelInsertar(this);
    PanelMostrar panelMostrar = new PanelMostrar();
    PanelBorrar panelBorrar = new PanelBorrar(this);
    
    /**
     * Creates new form Ejercicio5_view
     */
    public Ejercicio5() throws SQLException {
       
        this.setLayout(null);
        this.setBounds(0, 0, 600, 420);
        this.add(panelPrincipal);
        
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 600, 450);
        panelPrincipal.setBackground(new Color(216, 219, 226));
        
        menuBar.add(itemMostrar);
        menuBar.add(itemInsertar);
        menuBar.add(itemBorrar);
        menuBar.add(itemBuscar);
        menuBar.add(itemActualizar);
    
        panelPrincipal.add(menuBar);
        layout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, menuBar, 0, SpringLayout.EAST, panelPrincipal);
        
        panelPrincipal.add(panelMostrar);
        panelMostrar.setPreferredSize(new Dimension(480,300));
        layout.putConstraint(SpringLayout.WEST, panelMostrar, 50, SpringLayout.WEST, menuBar);
        layout.putConstraint(SpringLayout.NORTH, panelMostrar, 50, SpringLayout.NORTH, menuBar);
        
        panelPrincipal.add(panelInsertar);
        panelInsertar.setPreferredSize(new Dimension(480,300));
        layout.putConstraint(SpringLayout.WEST, panelInsertar, 50, SpringLayout.WEST, menuBar);
        layout.putConstraint(SpringLayout.NORTH, panelInsertar, 50, SpringLayout.NORTH, menuBar);
        
        panelPrincipal.add(panelBorrar);
        panelBorrar.setPreferredSize(new Dimension(480,300));
        layout.putConstraint(SpringLayout.WEST, panelBorrar, 50, SpringLayout.WEST, menuBar);
        layout.putConstraint(SpringLayout.NORTH, panelBorrar, 50, SpringLayout.NORTH, menuBar);        
        
        itemMostrar.setEnabled(false);
        panelInsertar.setVisible(false);
        panelBorrar.setVisible(false);
        
        
        itemMostrar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            
                panelPrincipal.remove(panelMostrar);
                
                try {
                    panelMostrar = new PanelMostrar();
                } catch (SQLException ex) {
                    Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                panelPrincipal.add(panelMostrar);
                panelMostrar.setPreferredSize(new Dimension(480,300));
                layout.putConstraint(SpringLayout.WEST, panelMostrar, 50, SpringLayout.WEST, menuBar);
                layout.putConstraint(SpringLayout.NORTH, panelMostrar, 50, SpringLayout.NORTH, menuBar);
        
                ocultarPaneles();
                
                panelMostrar.setVisible(true);
                itemMostrar.setEnabled(false);
                
            }
               
        });
        
        itemInsertar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            
                ocultarPaneles();
                
                panelInsertar.setVisible(true);
                itemInsertar.setEnabled(false);
                
            }
               
        });
        
        itemBorrar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            
                ocultarPaneles();
                
                panelBorrar.setVisible(true);
                itemBorrar.setEnabled(false);
                
            }
               
        });
        
    }
    
    public void ocultarPaneles() {
    
        panelMostrar.setVisible(false);
        panelInsertar.setVisible(false);
        panelBorrar.setVisible(false);
    
        itemMostrar.setEnabled(true);
        itemInsertar.setEnabled(true);
        itemBorrar.setEnabled(true);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Ejercicio5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ejercicio5().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Ejercicio5.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
