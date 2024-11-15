/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.exament3_frb;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Francisco
 */
public class Actividad_2 extends javax.swing.JFrame {

    SpringLayout layout = new SpringLayout();
    JPanel panelPrincipal = new JPanel();
    
    JMenuBar menuBarras = new JMenuBar();
    
    JMenu menuAnadir = new JMenu("Añadir");
    JMenu menuEliminar = new JMenu("Eliminar");
    JMenu menuTexto = new JMenu("Texto");
    JMenu menuPanel = new JMenu("Panel");
    
    JMenuItem itemAnadirPanel = new JMenuItem("Añadir panel");
    JMenuItem itemAnadirTexto = new JMenuItem("Añadir texto");
    
    JMenuItem itemBorrarPanel = new JMenuItem("Borrar panel");
    JMenuItem itemBorrarTexto = new JMenuItem("Borrar texto");
    
    JMenu menuTextoColores = new JMenu("Colores");
    JMenu menuTextoPosicion = new JMenu("Posicion");
    
    JMenuItem itemTextoVerde = new JMenuItem("Verde");
    JMenuItem itemTextoAzul = new JMenuItem("Azul");
    JMenuItem itemTextoNegro = new JMenuItem("Negro");
    
    JMenuItem itemTextoIzq = new JMenuItem("Izquierda");
    JMenuItem itemTextoCentro = new JMenuItem("Centro");
    JMenuItem itemTextoDer = new JMenuItem("Derecha");
    
    
    JMenu menuPanelColores = new JMenu("Colores");
    JMenu menuPanelTamano = new JMenu("Tamaño");
    
    JMenuItem itemPanelRosa = new JMenuItem("Rosa");
    JMenuItem itemPanelGris = new JMenuItem("Gris");
    JMenuItem itemPanelRojo = new JMenuItem("Rojo");
    
    JMenuItem itemPanelGrande = new JMenuItem("Grande");
    JMenuItem itemPanelPequeno = new JMenuItem("Pqueño");
    
    JPanel panelInsertado = new JPanel();
    JLabel labelInsertado = new JLabel("Texto añadido");
    
    
    /**
     * Creates new form Actividad_2
     */
    public Actividad_2() {
        initComponents();
        
        this.setLayout(null);
        this.setBounds(0,0,600,600);
        this.add(panelPrincipal);
        
        panelPrincipal.setBounds(0,0,600,600);
        panelPrincipal.setLayout(layout);
        
        panelPrincipal.add(menuBarras);
        
        menuBarras.add(menuAnadir);
        menuBarras.add(menuEliminar);
        menuBarras.add(menuTexto);
        menuBarras.add(menuPanel);
        
        menuAnadir.add(itemAnadirPanel);
        menuAnadir.add(itemAnadirTexto);
        
        menuEliminar.add(itemBorrarPanel);
        menuEliminar.add(itemBorrarTexto);
        
        menuTexto.add(menuTextoColores);
        menuTexto.add(menuTextoPosicion);
        
        menuTextoColores.add(itemTextoVerde);
        menuTextoColores.add(itemTextoAzul);
        menuTextoColores.add(itemTextoNegro);
        
        menuTextoPosicion.add(itemTextoIzq);
        menuTextoPosicion.add(itemTextoCentro);
        menuTextoPosicion.add(itemTextoDer);
        
        menuPanel.add(menuPanelColores);
        menuPanel.add(menuPanelTamano);
        
        menuPanelColores.add(itemPanelRosa);
        menuPanelColores.add(itemPanelGris);
        menuPanelColores.add(itemPanelRojo);
        
        menuPanelTamano.add(itemPanelGrande);
        menuPanelTamano.add(itemPanelPequeno);
        
        layout.putConstraint(SpringLayout.WEST, menuBarras, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, menuBarras, 0, SpringLayout.EAST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, menuBarras, 0, SpringLayout.NORTH, panelPrincipal);
        
        
        itemBorrarPanel.setEnabled(false);
        itemBorrarTexto.setEnabled(false);
        menuTexto.setEnabled(false);
        menuPanel.setEnabled(false);
        
        itemAnadirPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                panelPrincipal.add(panelInsertado);
                panelInsertado.setPreferredSize(new Dimension(100, 100));
                
                itemAnadirPanel.setEnabled(false);
                itemBorrarPanel.setEnabled(true);
                menuPanel.setEnabled(true);
                
                layout.putConstraint(SpringLayout.WEST, panelInsertado, 200, SpringLayout.WEST, menuBarras);
                layout.putConstraint(SpringLayout.NORTH, panelInsertado, 50, SpringLayout.NORTH, menuBarras);
                panelInsertado.setBackground(new Color(200, 200, 200));
                
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });
        
        itemAnadirTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                panelPrincipal.add(labelInsertado);
                labelInsertado.setForeground(new Color(0,0,0));
                
                itemAnadirTexto.setEnabled(false);
                itemBorrarTexto.setEnabled(true);
                menuTexto.setEnabled(true);
                
                layout.putConstraint(SpringLayout.WEST, labelInsertado, 0, SpringLayout.WEST, menuBarras);
                layout.putConstraint(SpringLayout.EAST, labelInsertado, 0, SpringLayout.EAST, menuBarras);
                layout.putConstraint(SpringLayout.NORTH, labelInsertado, 200, SpringLayout.NORTH, menuBarras);
                
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });
        
        itemBorrarPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                panelPrincipal.remove(panelInsertado);
                
                itemAnadirPanel.setEnabled(true);
                itemBorrarPanel.setEnabled(false);
                menuPanel.setEnabled(false);
                
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });
        
        itemBorrarTexto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                panelPrincipal.remove(labelInsertado);
                
                itemAnadirTexto.setEnabled(true);
                itemBorrarTexto.setEnabled(false);
                menuTexto.setEnabled(false);
                
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
            }
        });
        
    
        itemTextoVerde.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                labelInsertado.setForeground(new Color(0,200,0));
                
            }
        });
        
        itemTextoAzul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                labelInsertado.setForeground(new Color(0,0,200));
                
            }
        });
                
        itemTextoNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                labelInsertado.setForeground(new Color(0,0,0));
                
            }
        });
        
        itemTextoIzq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                labelInsertado.setHorizontalAlignment(labelInsertado.LEFT);
                
                
            }
        });
        
        itemTextoCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                labelInsertado.setHorizontalAlignment(labelInsertado.CENTER);
                
                
            }
        });
                
        itemTextoDer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                labelInsertado.setHorizontalAlignment(labelInsertado.RIGHT);
                
                
            }
        });
        
        itemPanelRosa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                panelInsertado.setBackground(Color.PINK);
             
            }
        });
        
        itemPanelGris.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                panelInsertado.setBackground(new Color(200, 200, 200));
             
            }
        });
        
        itemPanelRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                panelInsertado.setBackground(new Color(200, 0, 0));
             
            }
        });
        
        itemPanelGrande.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                panelInsertado.setPreferredSize(new Dimension(100,100));
                
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
                
            }
        });
        
        itemPanelPequeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
   
                panelInsertado.setPreferredSize(new Dimension(50,50));
                
                panelPrincipal.revalidate();
                panelPrincipal.repaint();
             
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
            java.util.logging.Logger.getLogger(Actividad_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actividad_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actividad_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actividad_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actividad_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
