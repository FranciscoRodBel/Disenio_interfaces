/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.exament3_frb;

import javax.swing.*;

/**
 *
 * @author Francisco
 */
public class From_base extends javax.swing.JFrame {

    JPanel panelPrincipal = new JPanel();
    
    Personal_Info panelInfoPersonal = new Personal_Info();
    Address_info panelInfoAddress = new Address_info();
    
    JButton botonSiguiente = new JButton("Siguiente");
    JButton botonAtras = new JButton("Atrás");
    JButton botonFinalizar = new JButton("Finalizar");
    /**
     * Creates new form From_base
     */
    public From_base() {
        initComponents();
        
        //SpringLayout layout = new SpringLayout();
        
        this.setLayout(null);
        this.setBounds(0,0,600,600);
        this.add(panelPrincipal);
        
        panelPrincipal.setBounds(0,0,600,600);
        panelPrincipal.setLayout(null);
        panelPrincipal.add(panelInfoPersonal);
        panelPrincipal.add(panelInfoAddress);
        
        /*
        layout.putConstraint(SpringLayout.WEST, panelInfoPersonal, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, panelInfoPersonal, 0, SpringLayout.NORTH, panelPrincipal);
        
        layout.putConstraint(SpringLayout.WEST, panelInfoPersonal, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, panelInfoPersonal, 0, SpringLayout.NORTH, panelPrincipal);
        
        layout.putConstraint(SpringLayout.WEST, panelInfoAddress, 50, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, panelInfoAddress, 50, SpringLayout.NORTH, panelPrincipal);
        
        layout.putConstraint(SpringLayout.WEST, botonSiguiente, 0, SpringLayout.WEST, panelInfoPersonal);
        layout.putConstraint(SpringLayout.NORTH, botonSiguiente, 500, SpringLayout.NORTH, panelInfoPersonal);
        
        layout.putConstraint(SpringLayout.WEST, botonAtras, 0, SpringLayout.WEST, panelInfoPersonal);
        layout.putConstraint(SpringLayout.NORTH, botonAtras, 500, SpringLayout.NORTH, panelInfoPersonal);
        
        layout.putConstraint(SpringLayout.EAST, botonFinalizar, 0, SpringLayout.WEST, panelInfoPersonal);
        layout.putConstraint(SpringLayout.NORTH, botonFinalizar, 500, SpringLayout.NORTH, panelInfoPersonal);
        */
        
        panelPrincipal.add(botonSiguiente);
        panelPrincipal.add(botonAtras);
        panelPrincipal.add(botonFinalizar);
                
                
        panelPrincipal.setVisible(true);
        panelInfoPersonal.setVisible(true);
        panelInfoAddress.setVisible(false);
        botonSiguiente.setVisible(true);
        botonAtras.setVisible(false);
        botonFinalizar.setVisible(false);
        
        botonSiguiente.setBounds(50, 480, 100, 30);
        botonAtras.setBounds(50, 480, 100, 30);
        botonFinalizar.setBounds(400, 480, 100, 30);
        
        botonSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                if (panelInfoPersonal.inputNombre.getText().isEmpty() || panelInfoPersonal.inputApellidos.getText().isEmpty() ||panelInfoPersonal.inputTelefono.getText().isEmpty() || panelInfoPersonal.labelEmail.getText().isEmpty()) {
                
                    
                
                } else {
                
                    panelInfoPersonal.setVisible(false);
                    panelInfoAddress.setVisible(true);
                    
                    botonSiguiente.setVisible(false);
                    botonAtras.setVisible(true);
                    botonFinalizar.setVisible(true);
                }
                
            }
        });
        
        botonAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                    panelInfoPersonal.setVisible(true);
                    panelInfoAddress.setVisible(false);
                    
                    botonSiguiente.setVisible(true);
                    botonAtras.setVisible(false);
                    botonFinalizar.setVisible(false);
                
            }
        });
        
        botonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                
                if (panelInfoAddress.inputCalle.getText().isEmpty() || panelInfoAddress.inputNumero.getText().isEmpty() ||panelInfoAddress.inputCP.getText().isEmpty()) {
                
                    
                
                } else {
                
                    SpringLayout layout = new SpringLayout();
                            
                    JDialog modalConfirmacion = new JDialog(From_base.this, true);
                    modalConfirmacion.setSize(400, 300);
                    modalConfirmacion.setLocationRelativeTo(From_base.this);
                    modalConfirmacion.setLayout(layout);
                    
                    
                    JLabel mensaje = new JLabel("¿Desea enviar dicha informacion?");
                    JButton botonSi = new JButton("Si");
                    JButton botonNo = new JButton("no");
                    
                    modalConfirmacion.add(mensaje);
                    modalConfirmacion.add(botonSi);
                    modalConfirmacion.add(botonNo);
                    
                    layout.putConstraint(SpringLayout.WEST, mensaje, 100, SpringLayout.WEST, modalConfirmacion);
                    layout.putConstraint(SpringLayout.NORTH, mensaje, 100, SpringLayout.NORTH, modalConfirmacion);
                    
                    layout.putConstraint(SpringLayout.WEST, botonSi, 0, SpringLayout.WEST, mensaje);
                    layout.putConstraint(SpringLayout.NORTH, botonSi, 50, SpringLayout.NORTH, mensaje);
                    
                    layout.putConstraint(SpringLayout.WEST, botonNo, 150, SpringLayout.WEST, botonSi);
                    layout.putConstraint(SpringLayout.NORTH, botonNo, 0, SpringLayout.NORTH, botonSi);
                    
                    botonSi.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {

                            System.exit(0);

                        }
                    });

                    botonNo.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {

                            modalConfirmacion.dispose();

                        }
                    });
                    
                    modalConfirmacion.setVisible(true);
                }
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
            java.util.logging.Logger.getLogger(From_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(From_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(From_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(From_base.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new From_base().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
