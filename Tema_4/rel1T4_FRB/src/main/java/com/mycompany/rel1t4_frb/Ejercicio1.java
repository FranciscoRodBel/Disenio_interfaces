/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.rel1t4_frb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Propietario
 */
public class Ejercicio1 extends javax.swing.JFrame {
    
        private Connection conexion;
        String baseDeDatos = "relaciont5";
    
        JPanel panelPrincipal = new JPanel();
    
        JLabel labelNombre = new JLabel("Nombre:");
        JTextField inputNombre = new JTextField(15);

        JLabel labelApellido = new JLabel("Apellido:");
        JTextField inputApellido = new JTextField(15);

        JLabel labelTelefono = new JLabel("Teléfono:");
        JTextField inputTelefono = new JTextField(15);

        JLabel labelDni = new JLabel("DNI:");
        JTextField inputDni = new JTextField(15);

        JLabel labelGenero = new JLabel("Género:");
        JComboBox<String> inputGenero = new JComboBox<>();

        JLabel labelDescripcion = new JLabel("Descripción:");
        JTextArea inputDescripcion = new JTextArea(3, 20);

        JLabel labelMail = new JLabel("Correo:");
        JTextField inputMail = new JTextField(15);
        
        JLabel labelResultado = new JLabel("");

        JButton botonInsertar = new JButton("Insertar");
    /**
     * Creates new form Ejercicio1
     */
    public Ejercicio1() throws SQLException {
        initComponents();
        
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDeDatos+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");

        this.setLayout(null);
        this.setBounds(0, 0, 600, 400);
        this.add(panelPrincipal);
        
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 600, 400);
        
        inputGenero.addItem("Masculino");
        inputGenero.addItem("Femenino");
        inputGenero.addItem("Otro");
        
        panelPrincipal.add(labelNombre);
        panelPrincipal.add(labelApellido);
        panelPrincipal.add(labelTelefono);
        panelPrincipal.add(labelDni);
        panelPrincipal.add(labelGenero);
        panelPrincipal.add(labelDescripcion);
        panelPrincipal.add(labelMail);
        
        panelPrincipal.add(inputNombre);
        panelPrincipal.add(inputApellido);
        panelPrincipal.add(inputTelefono);
        panelPrincipal.add(inputDni);
        panelPrincipal.add(inputGenero);
        panelPrincipal.add(inputDescripcion); // Scroll para área de texto
        panelPrincipal.add(inputMail);
        
        panelPrincipal.add(botonInsertar);
        panelPrincipal.setBackground(new Color(216, 219, 226));
        
        layout.putConstraint(SpringLayout.WEST, labelNombre, 100, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelNombre, 30, SpringLayout.NORTH, panelPrincipal);
        
        layout.putConstraint(SpringLayout.WEST, labelApellido, 0, SpringLayout.WEST, labelNombre);
        layout.putConstraint(SpringLayout.NORTH, labelApellido, 40, SpringLayout.NORTH, labelNombre);
     
        layout.putConstraint(SpringLayout.WEST, labelTelefono, 0, SpringLayout.WEST, labelApellido);
        layout.putConstraint(SpringLayout.NORTH, labelTelefono, 40, SpringLayout.NORTH, labelApellido);
        
        layout.putConstraint(SpringLayout.WEST, labelDni, 0, SpringLayout.WEST, labelTelefono);
        layout.putConstraint(SpringLayout.NORTH, labelDni, 40, SpringLayout.NORTH, labelTelefono);
        
        layout.putConstraint(SpringLayout.WEST, labelGenero, 0, SpringLayout.WEST, labelDni);
        layout.putConstraint(SpringLayout.NORTH, labelGenero, 40, SpringLayout.NORTH, labelDni);
      
        layout.putConstraint(SpringLayout.WEST, labelMail, 0, SpringLayout.WEST, labelGenero);
        layout.putConstraint(SpringLayout.NORTH, labelMail, 40, SpringLayout.NORTH, labelGenero);
        
        layout.putConstraint(SpringLayout.WEST, labelDescripcion, 0, SpringLayout.WEST, labelMail);
        layout.putConstraint(SpringLayout.NORTH, labelDescripcion, 40, SpringLayout.NORTH, labelMail);
        
        
        layout.putConstraint(SpringLayout.WEST, inputNombre, 80, SpringLayout.WEST, labelNombre);
        layout.putConstraint(SpringLayout.NORTH, inputNombre, -5, SpringLayout.NORTH, labelNombre);
        
        layout.putConstraint(SpringLayout.WEST, inputApellido, 80, SpringLayout.WEST, labelApellido);
        layout.putConstraint(SpringLayout.NORTH, inputApellido, -5, SpringLayout.NORTH, labelApellido);
        
        layout.putConstraint(SpringLayout.WEST, inputTelefono, 80, SpringLayout.WEST, labelTelefono);
        layout.putConstraint(SpringLayout.NORTH, inputTelefono, -5, SpringLayout.NORTH, labelTelefono);
        
        layout.putConstraint(SpringLayout.WEST, inputDni, 80, SpringLayout.WEST, labelDni);
        layout.putConstraint(SpringLayout.NORTH, inputDni, -5, SpringLayout.NORTH, labelDni);
        
        layout.putConstraint(SpringLayout.WEST, inputGenero, 80, SpringLayout.WEST, labelGenero);
        layout.putConstraint(SpringLayout.NORTH, inputGenero, -5, SpringLayout.NORTH, labelGenero);
        
        layout.putConstraint(SpringLayout.WEST, inputDescripcion, 80, SpringLayout.WEST, labelDescripcion);
        layout.putConstraint(SpringLayout.NORTH, inputDescripcion, -5, SpringLayout.NORTH, labelDescripcion);
        
        layout.putConstraint(SpringLayout.WEST, inputMail, 80, SpringLayout.WEST, labelMail);
        layout.putConstraint(SpringLayout.NORTH, inputMail, -5, SpringLayout.NORTH, labelMail);
        
        botonInsertar.setPreferredSize(new Dimension(150, 50));
        botonInsertar.setForeground(new Color(255,255,255));
        botonInsertar.setBackground(new Color(55, 63, 81));
        
        layout.putConstraint(SpringLayout.WEST, botonInsertar, 400, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, botonInsertar, 130, SpringLayout.NORTH, panelPrincipal);
    
        panelPrincipal.add(labelResultado);
        
        layout.putConstraint(SpringLayout.WEST, labelResultado, 0, SpringLayout.WEST, botonInsertar);
        layout.putConstraint(SpringLayout.NORTH, labelResultado, 60, SpringLayout.NORTH, botonInsertar);
        
       
        botonInsertar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                labelResultado.setText("");
                
                if (!inputNombre.getText().equals("") && !inputApellido.getText().equals("") && !inputDni.getText().equals("")) {
                    
                    if(contieneNumero(inputNombre.getText())){
                        
                        labelResultado.setText("El nombre es incorrecto");
                    }
                    
                    if(contieneNumero(inputApellido.getText())){
                        
                        labelResultado.setText("El apellido es incorrecto");
                    }
                    
                    if(inputDni.getText().length() != 9 || contieneLetra(inputDni.getText().substring(0,8)) || contieneNumero(inputDni.getText().substring(8,9))){
                        
                        labelResultado.setText("El DNI es incorrecto");
                    }
                    
                    if(inputTelefono.getText().length() != 0 && inputTelefono.getText().length() != 9){
                        
                        labelResultado.setText("El teléfono es incorrecto");
                    
                    } else {
                        
                        if (inputTelefono.getText().length() == 9 && contieneLetra(inputTelefono.getText())) {
                        
                            labelResultado.setText("El teléfono es incorrecto");
                            
                        }
                    }
                    
                    if (labelResultado.getText().length() == 0) {
                        
                        String nombre = inputNombre.getText();
                        String apellido = inputApellido.getText();
                        String telefono = inputTelefono.getText();
                        String dni = inputDni.getText();
                        String descripcion = inputDescripcion.getText();
                        String mail = inputMail.getText();
                        
                        String genero = inputGenero.getSelectedItem().toString();

                        genero = opcionGenero(genero);
                        
                        String consultaInsertar = "INSERT INTO persona (nombre, apellido, telefono, dni, genero, descripcion, mail) VALUES ('" + nombre + "', '" + apellido + "', '" + telefono + "', '" + dni + "', '" + genero + "', '" + descripcion + "', '" + mail + "')";
                     
                        try {
                            
                            Statement consulta = conexion.createStatement();
                            consulta.executeUpdate(consultaInsertar);
                            
                            labelResultado.setText("Persona introducida");
                            
                        } catch (SQLException ex) {
                            Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    
                } else {
                
                    labelResultado.setText("Debe rellenar todos los datos");
                    
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
            case "Masculino":
                genero = "m";
                break;
            case "Femenino":
                genero = "f";
                break;
            case "Otro":
                genero = "nb";
                break;
            default:
                genero = "m";
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
            java.util.logging.Logger.getLogger(Ejercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ejercicio1().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
