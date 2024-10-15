/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.relation_2_1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Francisco
 */
public class Activity_6 extends javax.swing.JFrame {

    private JPanel panelMain = new JPanel();
    private JPanel panelColor = new JPanel();
    private JLabel labelTitle = new JLabel();
    private JList listEvent = new JList<>();
    private JButton buttonBlue = new JButton();
    private JButton buttonGreen = new JButton();
    private JButton buttonRed = new JButton();
    private JButton buttonClean = new JButton();
    private JButton buttonExit = new JButton();
    /**
     * Creates new form Activity_1
     */
    public Activity_6() {
        initComponents();
        
        this.setBounds(0, 0, 675, 600);
        this.setLayout(null);
        
        createPanel();
        createBotones();
        
        buttonBlue.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                panelColor.setBackground(new Color(132, 214, 242));
                insertEventPanelList("Botón azul pulsado");
            }
        });
        
        buttonGreen.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                panelColor.setBackground(new Color(96, 147, 93));
            }
        });
                
        buttonRed.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                panelColor.setBackground(new Color(241, 89, 70));
            }
        });
        
        buttonClean.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                listEvent.clearSelection();
                panelColor.setBackground(new Color(255, 186, 8));
            }
        });
        
        buttonExit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });
     
    }
    
    public void insertEventPanelList(String textEvent) {
    
        DefaultListModel<String> modelEvent = new DefaultListModel<String>();
        
        modelEvent.addElement(textEvent);
        
        listEvent.setModel(modelEvent);
        /*
        for (int i = 0; i < vegetablesSorted.size(); i++ ) {

            vegetable.addElement(vegetablesSorted.get(i));

        }

        listVegetables.setModel(vegetable);
        
        
        
        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        
        */
    }
    
    public void createPanel() { 
    
        panelMain.setLayout(null);
        panelMain.setBackground(new Color(245, 245, 245));
        panelMain.setBounds(0, 0, 675, 600);
        this.add(panelMain);
        
        panelColor.setBackground(new Color(255, 186, 8));
        panelColor.setBorder(new LineBorder(Color.black, 2,true));
        panelColor.setBounds(10, 10, 640, 250);
        panelMain.add(panelColor);
        
        labelTitle.setText("Panel that captures the events");
        labelTitle.setFont(new Font("Arial", 1, 17));
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitle.setBounds(0, 200, 500, 50);
        labelTitle.setForeground(new Color(69, 83, 103));
        panelColor.add(labelTitle);
        
        listEvent.setBackground(new Color(255, 255, 255));
        listEvent.setBorder(new LineBorder(Color.black,2,true));
        listEvent.setBounds(10, 270, 640, 200);
        panelMain.add(listEvent);
    
    }
    
    public void createBotones() {
                
        buttonBlue.setText("Blue");
        buttonBlue.setBackground(new Color(132, 214, 242));
        buttonBlue.setBounds(25, 500, 100, 30);
        buttonBlue.setFont(new Font("Arial",1, 15));
        panelMain.add(buttonBlue);
        
        buttonGreen.setText("Green");
        buttonGreen.setBackground(new Color(96, 147, 93));
        buttonGreen.setBounds(150, 500, 100, 30);
        buttonGreen.setFont(new Font("Arial",1, 15));
        panelMain.add(buttonGreen);
        
        buttonRed.setText("Red");
        buttonRed.setBackground(new Color(241, 89, 70));
        buttonRed.setBounds(275, 500, 100, 30);
        buttonRed.setFont(new Font("Arial",1, 15));
        panelMain.add(buttonRed);
        
        buttonClean.setText("Clean");
        buttonClean.setBackground(new Color(255, 255, 255));
        buttonClean.setBounds(400, 500, 100, 30);
        buttonClean.setFont(new Font("Arial",1, 15));
        panelMain.add(buttonClean);
        
        buttonExit.setText("Exit");
        buttonExit.setBackground(new Color(255, 255, 255));
        buttonExit.setBounds(525, 500, 100, 30);
        buttonExit.setFont(new Font("Arial",1, 15));
        panelMain.add(buttonExit);
        
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
            java.util.logging.Logger.getLogger(Activity_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Activity_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Activity_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Activity_6.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Activity_6().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
