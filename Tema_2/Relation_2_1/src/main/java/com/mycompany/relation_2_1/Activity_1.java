/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.relation_2_1;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author Francisco
 */
public class Activity_1 extends javax.swing.JFrame {

    private JButton button1 = new JButton();
    private JButton button2 = new JButton();
    private JButton button3 = new JButton();
    private JLabel labelMessage = new JLabel();
    /**
     * Creates new form Activity_1
     */
    public Activity_1() {
        initComponents();
        
        this.setBounds(0, 0, 500, 500);
        this.setLayout(null);
        
        createInterface();
        
        button1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                button1Pressed(evt);
            }
        });

        button2.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                button2Pressed(evt);
            }
        });

        button3.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                button3Pressed(evt);
            }
        });
    }

    public void createInterface() {
    
        button1.setText("Button 1");
        button1.setBounds(40, 20, 100, 30);
        button1.setBackground(new Color(57, 62, 65));
        button1.setForeground(new Color(211, 208, 203));
        button1.setFocusPainted(false);
        button1.setFont(new Font("Arial",1, 15));
        this.add(button1);

        button2.setText("Button 2");
        button2.setBounds(190, 20, 100, 30);
        button2.setBackground(new Color(57, 62, 65));
        button2.setForeground(new Color(211, 208, 203));
        button2.setFocusPainted(false);
        button2.setFont(new Font("Arial",1, 15));
        this.add(button2);

        button3.setText("Button 3");
        button3.setBounds(340, 20, 100, 30);
        button3.setBackground(new Color(57, 62, 65));
        button3.setForeground(new Color(211, 208, 203));
        button3.setFocusPainted(false);
        button3.setFont(new Font("Arial",1, 15));
        this.add(button3);
        
        labelMessage.setText("You don’t have press any button yet");
        labelMessage.setFont(new Font("Arial", 1, 17));
        labelMessage.setHorizontalAlignment(SwingConstants.CENTER);
        labelMessage.setBounds(0, 200, 500, 50);
        this.add(labelMessage);
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

    private void button1Pressed(java.awt.event.ActionEvent evt) {                                         

        labelMessage.setText("You have pressed the Button 1");
        
    }
    
    private void button2Pressed(java.awt.event.ActionEvent evt) {                                         
        
        labelMessage.setText("You have pressed the Button 2");
        
    }
    
    private void button3Pressed(java.awt.event.ActionEvent evt) {                                         

        labelMessage.setText("You have pressed the Button 3");        
        
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
            java.util.logging.Logger.getLogger(Activity_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Activity_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Activity_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Activity_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Activity_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
