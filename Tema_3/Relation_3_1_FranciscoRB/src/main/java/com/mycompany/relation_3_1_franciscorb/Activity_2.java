/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.relation_3_1_franciscorb;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Propietario
 */
public class Activity_2 extends javax.swing.JFrame {
    
    JPanel panelMain = new JPanel();
    JPanel panelTop = new JPanel();
    JPanel panelBottom = new JPanel();
    JButton button1 = new JButton("Button 1");
    JButton button2 = new JButton("Button 2");
    JButton button3 = new JButton("Button 3");
    /**
     * Creates new form Activity_1
     */
    public Activity_2() {
        
        initComponents();
        
        this.setBounds(0, 0, 600, 600);
        
        panelMain.setBounds(0, 0, 600, 600);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        this.add(panelMain);
        
        panelTop.setPreferredSize(new Dimension(600, 200));
        panelTop.setBackground(new Color(243, 249, 175));
        panelMain.add(panelTop);
        
        button1.setPreferredSize(new Dimension(200, 50));
        button1.setBackground(new Color(175, 246, 249));
        button1.setAlignmentX(CENTER_ALIGNMENT);
        panelMain.add(button1);
        
        button2.setPreferredSize(new Dimension(200, 50));
        button2.setBackground(new Color(249, 175, 183));
        button2.setAlignmentX(CENTER_ALIGNMENT);
        panelMain.add(button2);
        
        button3.setPreferredSize(new Dimension(200, 50));
        button3.setBackground(new Color(206, 249, 175));
        button3.setAlignmentX(CENTER_ALIGNMENT);
        panelMain.add(button3);
        
        panelBottom.setPreferredSize(new Dimension(600, 200));
        panelBottom.setBackground(new Color(179, 131, 191));
        panelMain.add(panelBottom);
       
        this.setVisible(true);
 
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
            java.util.logging.Logger.getLogger(Activity_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Activity_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Activity_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Activity_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Activity_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
