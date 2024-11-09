/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.relacion_3_2_franciscorb;

import java.awt.*;
import static java.awt.Component.CENTER_ALIGNMENT;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Propietario
 */
public class Ejercicio_1 extends javax.swing.JFrame {

    JPanel panelPrincipal = new JPanel();
    
    JPanel panelColor = new JPanel();
    JLabel labelPanel = new JLabel("Este es mi primer menú");
    
    JComponent ultimoComponente = panelColor; // Para colocar un panel debajo de otro
        
    JMenuBar menuBar = new JMenuBar();
    
    JMenu menuColor = new JMenu("Colores");
    JMenu menuInsertar = new JMenu("Insertar");
    JMenu menuFormato = new JMenu("Formato");
    
    ButtonGroup grupoRadioColores = new ButtonGroup();
    JRadioButtonMenuItem itemRosa = new JRadioButtonMenuItem("Rosa");
    JRadioButtonMenuItem itemCian = new JRadioButtonMenuItem("Cian");
    JRadioButtonMenuItem itemMorado = new JRadioButtonMenuItem("Morado");
    
    JMenuItem itemPanel = new JMenuItem("Panel");
    JMenuItem itemSeparador = new JMenuItem("Separador");
    
    JCheckBoxMenuItem itemNegrita = new JCheckBoxMenuItem("Negrita");
    JCheckBoxMenuItem itemRojo = new JCheckBoxMenuItem("Rojo");
    JCheckBoxMenuItem itemVisible = new JCheckBoxMenuItem("Visible");
    
    
    /**
     * Creates new form Ejercicio_1
     */
    public Ejercicio_1() {
        initComponents();
        
        this.setLayout(null);
        this.setBounds(0, 0, 600, 400);
        this.add(panelPrincipal);
        
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 600, 400);
        
        panelPrincipal.add(menuBar);
        layout.putConstraint(SpringLayout.WEST, menuBar, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, menuBar, 0, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, menuBar, 0, SpringLayout.EAST, panelPrincipal);

        menuBar.add(menuColor);
        menuBar.add(menuInsertar);
        menuBar.add(menuFormato);
        
        
        // Menú de opciones del Color
        
        grupoRadioColores.add(itemRosa);
        grupoRadioColores.add(itemCian);
        grupoRadioColores.add(itemMorado);
        
        menuColor.add(itemRosa);
        menuColor.add(itemCian);
        menuColor.add(itemMorado);
        
        itemCian.setSelected(true);
        
        
        // Menú de opciones de Insertar
        
        menuInsertar.add(itemPanel);
        menuInsertar.add(itemSeparador);
        
        
        // Menú de opciones de Formato
        
        menuFormato.add(itemNegrita);
        menuFormato.add(itemRojo);
        menuFormato.add(itemVisible);
        
        
        // Desarrollo del Panel
        
        panelPrincipal.add(panelColor);
        panelColor.setBackground(new Color(78, 202, 238));
        panelColor.setPreferredSize(new Dimension(0, 100)); // El ancho se pone luego al colocarlo
        panelColor.add(labelPanel);
        
        layout.putConstraint(SpringLayout.WEST, panelColor, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, panelColor, 20, SpringLayout.NORTH, menuBar);
        layout.putConstraint(SpringLayout.EAST, panelColor, 0, SpringLayout.EAST, panelPrincipal);
       
        
        // Desarrollo del menú Formato
         
        itemVisible.setSelected(true);
        labelPanel.setFont(new Font("Arial", Font.PLAIN, 15));
       
        // Listeners
        
        itemRosa.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                panelColor.setBackground(new Color(255, 181, 192));
            }
        });
        
        itemCian.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                panelColor.setBackground(new Color(78, 202, 238));
            }
        });
                
        itemMorado.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                panelColor.setBackground(new Color(179, 118, 248));
            }
        });
        
        itemPanel.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                JPanel panelInsertado = new JPanel();
                
                panelInsertado.setPreferredSize(new Dimension(10, 10));
                panelInsertado.setBackground(new Color(119, 221, 119));
                
                panelPrincipal.add(panelInsertado);
                
                layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, panelInsertado, 0, SpringLayout.HORIZONTAL_CENTER, ultimoComponente);
                layout.putConstraint(SpringLayout.SOUTH, panelInsertado, 15, SpringLayout.SOUTH, ultimoComponente);
                
                ultimoComponente = panelInsertado;
             
                panelPrincipal.revalidate();
            }
        });
                
        
        itemSeparador.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                JSeparator separador = new JSeparator();
                
                separador.setPreferredSize(new Dimension(100, 2));
                
                panelPrincipal.add(separador);
                
                layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, separador, 0, SpringLayout.HORIZONTAL_CENTER, ultimoComponente);
                layout.putConstraint(SpringLayout.SOUTH, separador, 15, SpringLayout.SOUTH, ultimoComponente);
                
                ultimoComponente = separador;
             
                panelPrincipal.revalidate();
            }
        });
       
        itemNegrita.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                if (itemNegrita.isSelected()) {
                
                    labelPanel.setFont(new Font("Arial", Font.BOLD, 15));
                    
                } else {
                
                    labelPanel.setFont(new Font("Arial", Font.PLAIN, 15));
                    
                }
            }
        });
        
        itemRojo.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                if (itemRojo.isSelected()) {
                
                    labelPanel.setForeground(new Color(230, 89, 74));
                    
                } else {
                
                    labelPanel.setForeground(new Color(0,0,0));
                    
                }
            }
        });
        
        itemVisible.addActionListener(new ActionListener() {
        
            public void actionPerformed(ActionEvent e) {
                
                labelPanel.setVisible(itemVisible.isSelected());

            }
        });
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
            java.util.logging.Logger.getLogger(Ejercicio_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ejercicio_1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
