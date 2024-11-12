/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.relacion_3_2_franciscorb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Propietario
 */
public class Ejercicio_2 extends javax.swing.JFrame {

    JPanel panelPrincipal = new JPanel();
    JPanel panelInsertado = new JPanel();
    SpringLayout layoutPanelInsertado = new SpringLayout();
    
    boolean estaNegrita = false;
    boolean estaCentrado = false;
    JLabel labelPanel = new JLabel("Label del panel");
    
    JToolBar barraHerramientas = new JToolBar();
    
    JButton botonCrearPanel = new JButton();
    JButton botonBorrarPanel = new JButton();
    JButton botonCrearLabel = new JButton();
    JButton botonNegritaLabel = new JButton();
    JButton botonCentrarLabel = new JButton();
    JButton botonSalir = new JButton();

    /**
     * Creates new form Ejercicio_2
     */
    public Ejercicio_2() {
        initComponents();
        
        this.setLayout(null);
        this.setBounds(0, 0, 600, 400);
        this.add(panelPrincipal);
        
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 600, 400);
        
        panelPrincipal.add(barraHerramientas);
        layout.putConstraint(SpringLayout.WEST, barraHerramientas, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, barraHerramientas, 0, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, barraHerramientas, 0, SpringLayout.EAST, panelPrincipal);
        
        botonCrearPanel.setIcon(new ImageIcon("./imagenes/crearPanel.png"));
        botonBorrarPanel.setIcon(new ImageIcon("./imagenes/borrarPanel.png"));
        botonCrearLabel.setIcon(new ImageIcon("./imagenes/crearLabel.png"));
        botonNegritaLabel.setIcon(new ImageIcon("./imagenes/ponerTextoNegrita.png"));
        botonCentrarLabel.setIcon(new ImageIcon("./imagenes/alinearTextoIzquierda.png"));
        botonSalir.setIcon(new ImageIcon("./imagenes/salir.png"));
        
        botonBorrarPanel.setEnabled(false);
        botonCrearLabel.setEnabled(false);
        botonNegritaLabel.setEnabled(false);
        botonCentrarLabel.setEnabled(false);
                
        barraHerramientas.add(botonCrearPanel);
        barraHerramientas.add(botonBorrarPanel);
        barraHerramientas.add(new JToolBar.Separator());
        barraHerramientas.add(botonCrearLabel);
        barraHerramientas.add(botonNegritaLabel);
        barraHerramientas.add(botonCentrarLabel);
        barraHerramientas.add(new JToolBar.Separator());
        barraHerramientas.add(botonSalir);
        
        // Listeners

        botonCrearPanel.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                panelInsertado.setLayout(layoutPanelInsertado);
                panelInsertado.setPreferredSize(new Dimension(400, 250));
                panelInsertado.setBackground(new Color(250, 250, 250));
                
                panelPrincipal.add(panelInsertado);
                
                layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, panelInsertado, 0, SpringLayout.HORIZONTAL_CENTER, panelPrincipal);
                layout.putConstraint(SpringLayout.NORTH, panelInsertado, 60, SpringLayout.NORTH, panelPrincipal);
                
                botonCrearPanel.setEnabled(false);
                botonBorrarPanel.setEnabled(true);
                botonCrearLabel.setEnabled(true);
                
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });
        
        botonBorrarPanel.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                panelPrincipal.remove(panelInsertado);
                panelInsertado.remove(labelPanel);
                
                botonCrearPanel.setEnabled(true);
                botonBorrarPanel.setEnabled(false);
                botonCrearLabel.setEnabled(false);
                botonNegritaLabel.setEnabled(false);
                botonCentrarLabel.setEnabled(false);

                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });
        
        botonSalir.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                System.exit(0);
            }
        });
        
        botonCrearLabel.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                panelInsertado.add(labelPanel);
                
                labelPanel.setFont(new Font("Arial", Font.PLAIN ,12));
                labelPanel.setPreferredSize(new Dimension(100, 30));
                
                layoutPanelInsertado.putConstraint(SpringLayout.WEST, labelPanel, 0, SpringLayout.WEST, panelInsertado);
                layoutPanelInsertado.putConstraint(SpringLayout.NORTH, labelPanel, 20, SpringLayout.NORTH, panelInsertado);
                layoutPanelInsertado.putConstraint(SpringLayout.EAST, labelPanel, 0, SpringLayout.EAST, panelInsertado);
                
                botonCrearLabel.setEnabled(false);
                botonNegritaLabel.setEnabled(true);
                botonCentrarLabel.setEnabled(true);

                panelInsertado.revalidate();
            }
        });
        
        botonNegritaLabel.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                if (estaNegrita) {
                
                    botonNegritaLabel.setIcon(new ImageIcon("./imagenes/ponerTextoNegrita.png"));
                    labelPanel.setFont(new Font("Arial", Font.PLAIN ,12));
                    
                    estaNegrita = false;
                    
                } else {
                
                    botonNegritaLabel.setIcon(new ImageIcon("./imagenes/quitarTextoNegrita.png"));
                    labelPanel.setFont(new Font("Arial", Font.BOLD ,12));
                    
                    estaNegrita = true;
                }

                panelInsertado.revalidate();
            }
        });
        
        botonCentrarLabel.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                if (estaCentrado) {
                
                    botonCentrarLabel.setIcon(new ImageIcon("./imagenes/alinearTextoIzquierda.png"));
                    labelPanel.setHorizontalAlignment(SwingConstants.LEFT);
                    estaCentrado = false;
                    
                } else {
                
                    botonCentrarLabel.setIcon(new ImageIcon("./imagenes/alinearTextoCentro.png"));
                    labelPanel.setHorizontalAlignment(SwingConstants.CENTER);
                    estaCentrado = true;
                }

                panelInsertado.revalidate();
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
            java.util.logging.Logger.getLogger(Ejercicio_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ejercicio_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
