/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rel1t4_frb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author Propietario
 */
public class Ejercicio3 extends javax.swing.JFrame {

    private Connection conexion;
    String baseDeDatos = "relaciont5";

    JPanel panelPrincipal = new JPanel();

    JLabel labelBuscador = new JLabel("Busca un DNI de una persona");
    JTextField inputBuscador = new JTextField(15);
    
    JButton botonBuscar = new JButton("Buscar");
    
    JLabel labelNombre = new JLabel("Nombre:");
    JLabel labelApellido = new JLabel("Apellido:");
    JLabel labelTelefono = new JLabel("Teléfono:");
    JLabel labelDni = new JLabel("DNI:");
    JLabel labelGenero = new JLabel("Género:");
    JLabel labelDescripcion = new JLabel("Descripción:");
    JLabel labelMail = new JLabel("Correo:");
    
    JLabel labelMensajeError = new JLabel("El DNI buscado no ha sido encontrado");
    JLabel labelresultadoBorrar = new JLabel("");
        
    JButton botonBorrar = new JButton("Borrar persona");
    /**
     * Creates new form Ejercicio2
     */
    public Ejercicio3() throws SQLException {
        initComponents();
        
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDeDatos+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");

        this.setLayout(null);
        this.setBounds(0, 0, 600, 420);
        this.add(panelPrincipal);
        
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 600, 450);
        panelPrincipal.setBackground(new Color(216, 219, 226));
        
        panelPrincipal.add(labelBuscador);
        panelPrincipal.add(inputBuscador);
        panelPrincipal.add(botonBuscar);
        
        labelBuscador.setHorizontalAlignment(labelBuscador.CENTER);
        layout.putConstraint(SpringLayout.WEST, labelBuscador, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelBuscador, 30, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, labelBuscador, 0, SpringLayout.EAST, panelPrincipal);
        
        layout.putConstraint(SpringLayout.WEST, inputBuscador, 215, SpringLayout.WEST, labelBuscador);
        layout.putConstraint(SpringLayout.NORTH, inputBuscador, 30, SpringLayout.NORTH, labelBuscador);
        
        botonBuscar.setPreferredSize(new Dimension(150, 50));
        botonBuscar.setForeground(new Color(255,255,255));
        botonBuscar.setBackground(new Color(55, 63, 81));
        
        layout.putConstraint(SpringLayout.WEST, botonBuscar, 15, SpringLayout.WEST, inputBuscador);
        layout.putConstraint(SpringLayout.NORTH, botonBuscar, 40, SpringLayout.NORTH, inputBuscador);
        
        panelPrincipal.add(labelNombre);
        panelPrincipal.add(labelApellido);
        panelPrincipal.add(labelTelefono);
        panelPrincipal.add(labelDni);
        panelPrincipal.add(labelGenero);
        panelPrincipal.add(labelDescripcion);
        panelPrincipal.add(labelMail);
        panelPrincipal.add(labelMensajeError);
        panelPrincipal.add(labelresultadoBorrar);
        
        
        labelNombre.setVisible(false);
        labelApellido.setVisible(false);
        labelTelefono.setVisible(false);
        labelDni.setVisible(false);
        labelGenero.setVisible(false);
        labelDescripcion.setVisible(false);
        labelMail.setVisible(false);
        labelMensajeError.setVisible(false);
        botonBorrar.setVisible(false);
        labelresultadoBorrar.setVisible(false);
        
        labelMensajeError.setForeground(new Color(241, 81, 82));
        labelMensajeError.setHorizontalAlignment(labelMensajeError.CENTER);
        labelMensajeError.setFont(new Font("Arial", Font.BOLD, 15));
        
        labelresultadoBorrar.setHorizontalAlignment(labelMensajeError.CENTER);
        labelresultadoBorrar.setFont(new Font("Arial", Font.BOLD, 15));
        
        
        layout.putConstraint(SpringLayout.WEST, labelNombre, -50, SpringLayout.WEST, botonBuscar);
        layout.putConstraint(SpringLayout.NORTH, labelNombre, 70, SpringLayout.NORTH, botonBuscar);
        
        layout.putConstraint(SpringLayout.WEST, labelApellido, 0, SpringLayout.WEST, labelNombre);
        layout.putConstraint(SpringLayout.NORTH, labelApellido, 30, SpringLayout.NORTH, labelNombre);
     
        layout.putConstraint(SpringLayout.WEST, labelTelefono, 0, SpringLayout.WEST, labelApellido);
        layout.putConstraint(SpringLayout.NORTH, labelTelefono, 30, SpringLayout.NORTH, labelApellido);
        
        layout.putConstraint(SpringLayout.WEST, labelDni, 0, SpringLayout.WEST, labelTelefono);
        layout.putConstraint(SpringLayout.NORTH, labelDni, 30, SpringLayout.NORTH, labelTelefono);
        
        layout.putConstraint(SpringLayout.WEST, labelGenero, 0, SpringLayout.WEST, labelDni);
        layout.putConstraint(SpringLayout.NORTH, labelGenero, 30, SpringLayout.NORTH, labelDni);
      
        layout.putConstraint(SpringLayout.WEST, labelMail, 0, SpringLayout.WEST, labelGenero);
        layout.putConstraint(SpringLayout.NORTH, labelMail, 30, SpringLayout.NORTH, labelGenero);
        
        layout.putConstraint(SpringLayout.WEST, labelDescripcion, 0, SpringLayout.WEST, labelMail);
        layout.putConstraint(SpringLayout.NORTH, labelDescripcion, 30, SpringLayout.NORTH, labelMail);
        
        layout.putConstraint(SpringLayout.WEST, labelMensajeError, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelMensajeError, 70, SpringLayout.NORTH, botonBuscar);
        layout.putConstraint(SpringLayout.EAST, labelMensajeError, 0, SpringLayout.EAST, panelPrincipal);
        
        layout.putConstraint(SpringLayout.WEST, labelresultadoBorrar, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelresultadoBorrar, 70, SpringLayout.NORTH, botonBuscar);
        layout.putConstraint(SpringLayout.EAST, labelresultadoBorrar, 0, SpringLayout.EAST, panelPrincipal);
        
        botonBorrar.setPreferredSize(new Dimension(120, 40));
        botonBorrar.setForeground(new Color(255,255,255));
        botonBorrar.setBackground(new Color(241, 81, 82));
        panelPrincipal.add(botonBorrar);
        
        layout.putConstraint(SpringLayout.WEST, botonBorrar, 170, SpringLayout.WEST, botonBuscar);
        layout.putConstraint(SpringLayout.NORTH, botonBorrar, 5, SpringLayout.NORTH, botonBuscar);
        
        botonBuscar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if(inputBuscador.getText().length() != 9 || contieneLetra(inputBuscador.getText().substring(0,8)) || contieneNumero(inputBuscador.getText().substring(8,9))){
                    
                    labelNombre.setVisible(false);
                    labelApellido.setVisible(false);
                    labelTelefono.setVisible(false);
                    labelDni.setVisible(false);
                    labelGenero.setVisible(false);
                    labelDescripcion.setVisible(false);
                    labelMail.setVisible(false);
                    labelMensajeError.setVisible(true);
                    botonBorrar.setVisible(false);
                    botonBorrar.setVisible(false);
                    labelresultadoBorrar.setVisible(false);
                    
                } else {
                    labelMensajeError.setVisible(false);

                    String consultaRecoger = "SELECT * FROM persona WHERE dni = '" + inputBuscador.getText() + "'";

                    try {
                        Statement consulta = conexion.createStatement();
                        ResultSet resultado = consulta.executeQuery(consultaRecoger);

                        if (resultado.next()) {
                            
                            String nombre = resultado.getString("nombre");
                            String apellido = resultado.getString("apellido");
                            String telefono = resultado.getString("telefono");
                            String genero = resultado.getString("genero");
                            String descripcion = resultado.getString("descripcion");
                            String mail = resultado.getString("mail");

                            labelNombre.setText("Nombre: " + nombre);
                            labelApellido.setText("Apellido: " + apellido);
                            labelTelefono.setText("Teléfono: " + telefono);
                            labelDni.setText("DNI: " + inputBuscador.getText());
                            labelGenero.setText("Género: " + opcionGenero(genero));
                            labelDescripcion.setText("Descripción: " + descripcion);
                            labelMail.setText("Correo: " + mail);

                            labelNombre.setVisible(true);
                            labelApellido.setVisible(true);
                            labelTelefono.setVisible(true);
                            labelDni.setVisible(true);
                            labelGenero.setVisible(true);
                            labelDescripcion.setVisible(true);
                            labelMail.setVisible(true);
                            botonBorrar.setVisible(true);
                            labelresultadoBorrar.setVisible(false);
                            
                        } else {
                            
                            labelNombre.setVisible(false);
                            labelApellido.setVisible(false);
                            labelTelefono.setVisible(false);
                            labelDni.setVisible(false);
                            labelGenero.setVisible(false);
                            labelDescripcion.setVisible(false);
                            labelMail.setVisible(false);
                            labelMensajeError.setVisible(true);
                            botonBorrar.setVisible(false);
                            botonBorrar.setVisible(false);
                            labelresultadoBorrar.setVisible(false);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }     
        });
        
        botonBorrar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                labelNombre.setVisible(false);
                labelApellido.setVisible(false);
                labelTelefono.setVisible(false);
                labelDni.setVisible(false);
                labelGenero.setVisible(false);
                labelDescripcion.setVisible(false);
                labelMail.setVisible(false);
                labelMensajeError.setVisible(false);
                botonBorrar.setVisible(false);
                            
                String consultaEliminar = "DELETE FROM persona WHERE dni = '" + inputBuscador.getText() + "'";

                try {
                    Statement consulta = conexion.createStatement();
                    int filasEliminadas = consulta.executeUpdate(consultaEliminar);

                    if (filasEliminadas > 0) {
                        
                        labelresultadoBorrar.setText("Persona eliminada correctamente");
                        labelresultadoBorrar.setForeground(new Color(82, 183, 136));
                        labelresultadoBorrar.setVisible(true);
                        
                    } else {
                        
                        labelresultadoBorrar.setText("No se encontró ninguna persona con ese DNI");
                        labelresultadoBorrar.setForeground(new Color(241, 81, 82));
                        labelresultadoBorrar.setVisible(true);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
               
        });
    }
    
    public boolean contieneNumero(String texto) {

        for (int i = 0 ; i < 10 ; i++) {
        
            if(texto.contains(String.valueOf(i))) {
                    
                return true;
            }
        }
        return false;
    }
    
    public boolean contieneLetra(String texto) {

        try {
        
            Integer.parseInt(texto);
        
            return false;
            
        } catch(Exception e) {
        
            return true;
        }
    }
    
        public String opcionGenero(String genero) {

        switch (genero) {
            case "m":
                genero = "Masculino";
                break;
            case "f":
                genero = "Femenino";
                break;
            case "nb":
                genero = "Otro";
                break;
            default:
                genero = "Masculino";
                break;
        }
        
        return genero;
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
            java.util.logging.Logger.getLogger(Ejercicio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ejercicio3().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Ejercicio3.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
