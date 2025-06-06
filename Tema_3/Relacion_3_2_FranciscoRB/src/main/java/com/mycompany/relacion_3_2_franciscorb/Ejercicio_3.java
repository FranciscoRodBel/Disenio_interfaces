/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.relacion_3_2_franciscorb;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author Propietario
 */
public class Ejercicio_3 extends javax.swing.JFrame {

    JPanel panelPrincipal = new JPanel();
    JLabel labelComentarios = new JLabel("Comentarios");
    JTextArea textArea = new JTextArea();
    
    JMenuBar menuBarras = new JMenuBar();

    JMenu menuTamanoFuente = new JMenu("Tamaño fuente");
    JMenu menuColorTexto = new JMenu("Color texto");
    
    JMenuItem itemIncrementar = new JMenuItem("Incrementar");
    JMenuItem itemDecrementar = new JMenuItem("Decrementar");
    
    JMenuItem itemRojo = new JMenuItem("Rojo");
    JMenuItem itemVerde = new JMenuItem("Verde");
    JMenuItem itemNegro = new JMenuItem("Negro");
    JMenuItem itemAzul = new JMenuItem("Azul");
    
    JMenuItem itemSalir = new JMenuItem("Salir");
    
    /**
     * Creates new form Ejercicio_2
     */
    public Ejercicio_3() {
        initComponents();
        
        this.setLayout(null);
        this.setBounds(0, 0, 600, 400);
        this.add(panelPrincipal);
        
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 600, 400);
        
        
        // Desarrollo del menú
        
        panelPrincipal.add(menuBarras);
        layout.putConstraint(SpringLayout.WEST, menuBarras, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, menuBarras, 0, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, menuBarras, 0, SpringLayout.EAST, panelPrincipal);
     
        menuBarras.add(menuTamanoFuente);
        menuBarras.add(menuColorTexto);
        menuBarras.add(itemSalir);
        
        menuTamanoFuente.add(itemIncrementar);
        menuTamanoFuente.add(itemDecrementar);
        
        menuColorTexto.add(itemRojo);
        menuColorTexto.add(itemVerde);
        menuColorTexto.add(itemNegro);
        menuColorTexto.add(itemAzul);
        
        
        
        // Desarrollo de los componentes en la interfaz
        
        panelPrincipal.add(labelComentarios);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, labelComentarios, 0, SpringLayout.HORIZONTAL_CENTER, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelComentarios, 50, SpringLayout.NORTH, menuBarras);
        
        textArea.setFont(new Font("Arial", Font.PLAIN, 13));
        textArea.setPreferredSize(new Dimension(350, 150));
        panelPrincipal.add(textArea);
        layout.putConstraint(SpringLayout.HORIZONTAL_CENTER, textArea, 0, SpringLayout.HORIZONTAL_CENTER, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, textArea, 25, SpringLayout.NORTH, labelComentarios); 
        
        
        // Listeners
        
        itemSalir.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                JDialog modalSalir = new JDialog(Ejercicio_3.this, true);
                SpringLayout layout = new SpringLayout();

                modalSalir.setLayout(layout);
                modalSalir.setSize(new Dimension(350, 150));
                modalSalir.setLocationRelativeTo(Ejercicio_3.this); // Para que aparezca el modal en el centro con respecto a al jframe principal

                JLabel labelSalir = new JLabel("¿Seguro que quiere salir del programa?");
                JButton botonAceptar = new JButton("Aceptar");
                JButton botonCancelar = new JButton("Cancelar");

                modalSalir.add(labelSalir);
                modalSalir.add(botonAceptar);
                modalSalir.add(botonCancelar);

                layout.putConstraint(SpringLayout.WEST, labelSalir, 50, SpringLayout.WEST, modalSalir);
                layout.putConstraint(SpringLayout.NORTH, labelSalir, 20, SpringLayout.NORTH, modalSalir);

                layout.putConstraint(SpringLayout.WEST, botonCancelar, 80, SpringLayout.WEST, modalSalir);
                layout.putConstraint(SpringLayout.NORTH, botonCancelar, 20, SpringLayout.SOUTH, labelSalir);

                layout.putConstraint(SpringLayout.WEST, botonAceptar, 20, SpringLayout.EAST, botonCancelar);
                layout.putConstraint(SpringLayout.NORTH, botonAceptar, 0, SpringLayout.NORTH, botonCancelar);

                botonAceptar.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        System.exit(0);
                    }
                });

                botonCancelar.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        modalSalir.dispose();
                    }
                });

                modalSalir.setVisible(true);
            }
        });

        itemIncrementar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                Font fuente = textArea.getFont();
                int tamnoFuente = fuente.getSize() + 1;
                
                textArea.setFont(new Font("Arial", Font.PLAIN, tamnoFuente));
                
                itemDecrementar.setEnabled(true);
                
                if (tamnoFuente == 20) {
                
                    itemIncrementar.setEnabled(false);
                    
                } else {
                
                    itemIncrementar.setEnabled(true);
                
                }
                
            }
        });
        
        itemDecrementar.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                Font fuente = textArea.getFont();
                int tamnoFuente = fuente.getSize() - 1;
                
                textArea.setFont(new Font("Arial", Font.PLAIN, tamnoFuente));
                
                itemIncrementar.setEnabled(true);

                if (tamnoFuente == 10) {
                
                    itemDecrementar.setEnabled(false);
                    
                } else {
                
                    itemDecrementar.setEnabled(true);
                
                }
            }
        });
        
        itemRojo.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                textArea.setForeground(new Color(230, 89, 74));
            }
        });
        
        itemVerde.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                textArea.setForeground(new Color(120, 222, 119));
            }
        });
        
        itemNegro.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                textArea.setForeground(new Color(0,0,0));
            }
        });
        
        itemAzul.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                textArea.setForeground(new Color(121, 191, 233));
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
            java.util.logging.Logger.getLogger(Ejercicio_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ejercicio_3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
