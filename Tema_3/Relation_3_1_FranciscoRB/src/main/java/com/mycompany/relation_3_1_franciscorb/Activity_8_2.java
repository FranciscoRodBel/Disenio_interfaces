/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.relation_3_1_franciscorb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Propietario
 */
public class Activity_8_2 extends javax.swing.JFrame {

    JPanel panelMain = new JPanel();

    JLabel labelName = new JLabel("Name: ");
    JLabel labelFax = new JLabel("Fax: ");
    JLabel labelEmail = new JLabel("Email: ");
    JLabel labelAddress = new JLabel("Address: ");
    
    JTextField inputName = new JTextField(15);
    JTextField inputFax = new JTextField(15);
    JTextField inputEmail = new JTextField(15);
    JTextField inputAddress = new JTextField(15);
    
    
    /**
     * Creates new form Activity_3
     */
    public Activity_8_2() {
        initComponents();

        this.setLayout(null);
        this.setBounds(0, 0, 500, 300);
        this.add(panelMain);

        SpringLayout layout = new SpringLayout();
        panelMain.setLayout(layout);
        panelMain.setBounds(0, 0, 500, 300);

        panelMain.add(labelName);
        panelMain.add(labelFax);
        panelMain.add(labelEmail);
        panelMain.add(labelAddress);
        
        panelMain.add(inputName);
        panelMain.add(inputFax);
        panelMain.add(inputEmail);
        panelMain.add(inputAddress);
        
        layout.putConstraint(SpringLayout.WEST, labelName, 50, SpringLayout.WEST, panelMain);
        layout.putConstraint(SpringLayout.NORTH, labelName, 50, SpringLayout.NORTH, panelMain);
        
        layout.putConstraint(SpringLayout.WEST, labelFax, 0, SpringLayout.WEST, labelName);
        layout.putConstraint(SpringLayout.NORTH, labelFax, 40, SpringLayout.NORTH, labelName);
        
        layout.putConstraint(SpringLayout.WEST, labelEmail, 0, SpringLayout.WEST, labelFax);
        layout.putConstraint(SpringLayout.NORTH, labelEmail, 40, SpringLayout.NORTH, labelFax);
        
        layout.putConstraint(SpringLayout.WEST, labelAddress, 0, SpringLayout.WEST, labelEmail);
        layout.putConstraint(SpringLayout.NORTH, labelAddress, 40, SpringLayout.NORTH, labelEmail);
        
        
        layout.putConstraint(SpringLayout.WEST, inputName, 50, SpringLayout.WEST, labelName);
        layout.putConstraint(SpringLayout.NORTH, inputName, -5, SpringLayout.NORTH, labelName);
        
        layout.putConstraint(SpringLayout.WEST, inputFax, 50, SpringLayout.WEST, labelFax);
        layout.putConstraint(SpringLayout.NORTH, inputFax, -5, SpringLayout.NORTH, labelFax);
        
        layout.putConstraint(SpringLayout.WEST, inputEmail, 50, SpringLayout.WEST, labelEmail);
        layout.putConstraint(SpringLayout.NORTH, inputEmail, -5, SpringLayout.NORTH, labelEmail);
        
        layout.putConstraint(SpringLayout.WEST, inputAddress, 50, SpringLayout.WEST, labelAddress);
        layout.putConstraint(SpringLayout.NORTH, inputAddress, -5, SpringLayout.NORTH, labelAddress);

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
            java.util.logging.Logger.getLogger(Activity_8_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Activity_8_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Activity_8_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Activity_8_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Activity_8_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
