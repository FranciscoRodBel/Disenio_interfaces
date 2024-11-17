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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

/**
 *
 * @author Propietario
 */
public class Ejercicio4 extends javax.swing.JFrame {

    private Connection conexion;
    String baseDeDatos = "relaciont5";

    JPanel panelPrincipal = new JPanel();

    JLabel labelBuscador = new JLabel("Busca un DNI de una persona");
    JTextField inputBuscador = new JTextField(15);
    
    JButton botonBuscar = new JButton("Buscar");
    
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
    
    JLabel labelMensajeError = new JLabel("El DNI buscado no ha sido encontrado");
    JButton botonModificar = new JButton("Modificar");
    
    JLabel labelResultadoModificar = new JLabel("");
        
    /**
     * Creates new form Ejercicio2
     */
    public Ejercicio4() throws SQLException {
        initComponents();
        
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDeDatos+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");

        this.setLayout(null);
        this.setBounds(0, 0, 600, 550);
        this.add(panelPrincipal);
        
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 600, 550);
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
        
        panelPrincipal.add(inputNombre);
        panelPrincipal.add(inputApellido);
        panelPrincipal.add(inputTelefono);
        panelPrincipal.add(inputDni);
        panelPrincipal.add(inputGenero);
        panelPrincipal.add(inputDescripcion);
        panelPrincipal.add(inputMail);
        
        inputGenero.addItem("Masculino");
        inputGenero.addItem("Femenino");
        inputGenero.addItem("Otro");
        
        ocultarCampos();
        
        labelMensajeError.setForeground(new Color(241, 81, 82));
        labelMensajeError.setHorizontalAlignment(labelMensajeError.CENTER);
        labelMensajeError.setFont(new Font("Arial", Font.BOLD, 15));
        
        
        layout.putConstraint(SpringLayout.WEST, labelNombre, -50, SpringLayout.WEST, botonBuscar);
        layout.putConstraint(SpringLayout.NORTH, labelNombre, 100, SpringLayout.NORTH, botonBuscar);
        
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
        
        
        layout.putConstraint(SpringLayout.WEST, labelMensajeError, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelMensajeError, 70, SpringLayout.NORTH, botonBuscar);
        layout.putConstraint(SpringLayout.EAST, labelMensajeError, 0, SpringLayout.EAST, panelPrincipal);
                
        botonModificar.setPreferredSize(new Dimension(120, 40));
        botonModificar.setBackground(new Color(82, 183, 136));
        panelPrincipal.add(botonModificar);
        botonModificar.setVisible(false);
        
        layout.putConstraint(SpringLayout.WEST, botonModificar, 170, SpringLayout.WEST, botonBuscar);
        layout.putConstraint(SpringLayout.NORTH, botonModificar, 5, SpringLayout.NORTH, botonBuscar);
        
        panelPrincipal.add(labelResultadoModificar);
        labelResultadoModificar.setHorizontalAlignment(labelMensajeError.CENTER);
        labelResultadoModificar.setFont(new Font("Arial", Font.BOLD, 15));
        
        layout.putConstraint(SpringLayout.WEST, labelResultadoModificar, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelResultadoModificar, 60, SpringLayout.NORTH, botonBuscar);
        layout.putConstraint(SpringLayout.EAST, labelResultadoModificar, 0, SpringLayout.EAST, panelPrincipal);
     
    
        botonBuscar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                labelResultadoModificar.setVisible(false);
                
                if(inputBuscador.getText().length() != 9 || contieneLetra(inputBuscador.getText().substring(0,8)) || contieneNumero(inputBuscador.getText().substring(8,9))){

                    ocultarCampos();
                    labelMensajeError.setVisible(true);
                    
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

                            inputNombre.setText(nombre);
                            inputApellido.setText(apellido);
                            inputTelefono.setText(telefono);
                            inputDni.setText(inputBuscador.getText());
                            inputGenero.setSelectedItem(opcionGenero(genero));
                            inputDescripcion.setText(descripcion);
                            inputMail.setText(mail);

                            mostrarCampos();
                            
                        } else {
                            
                            ocultarCampos();
                            labelMensajeError.setVisible(true);
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }     
        });
        
        botonModificar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                if (modificarPersona()) {
                
                    ocultarCampos();
                    
                    labelResultadoModificar.setText("Persona modificada correctamente");
                    labelResultadoModificar.setForeground(new Color(82, 183, 136));
                    labelResultadoModificar.setVisible(true);
                
                } else {
                
                    labelResultadoModificar.setForeground(new Color(241, 81, 82));
                    labelResultadoModificar.setVisible(true);
                
                }
           
               
            }
               
        });

    }
    
    public boolean modificarPersona() {
    
        labelResultadoModificar.setText("");

        if (!inputNombre.getText().equals("") && !inputApellido.getText().equals("") && !inputDni.getText().equals("")) {

            if(contieneNumero(inputNombre.getText())){

                labelResultadoModificar.setText("El nombre es incorrecto");
                return false;
            }

            if(contieneNumero(inputApellido.getText())){

                labelResultadoModificar.setText("El apellido es incorrecto");
                return false;
            }

            if(inputDni.getText().length() != 9 || contieneLetra(inputDni.getText().substring(0,8)) || contieneNumero(inputDni.getText().substring(8,9))){

                labelResultadoModificar.setText("El DNI es incorrecto");
                return false;
            }

            if(inputTelefono.getText().length() != 0 && inputTelefono.getText().length() != 9){

                labelResultadoModificar.setText("El teléfono es incorrecto");
                return false;

            } else {

                if (inputTelefono.getText().length() == 9 && contieneLetra(inputTelefono.getText())) {

                    labelResultadoModificar.setText("El teléfono es incorrecto");
                    return false;

                }
            }

            if (labelResultadoModificar.getText().length() == 0) {

                String nombre = inputNombre.getText();
                String apellido = inputApellido.getText();
                String telefono = inputTelefono.getText();
                String dni = inputDni.getText();
                String descripcion = inputDescripcion.getText();
                String mail = inputMail.getText();

                String genero = inputGenero.getSelectedItem().toString();

                genero = opcionGenero2(genero);

                String consultaActualizar = "UPDATE persona SET nombre = '" + nombre + "', apellido = '" + apellido + "', telefono = '" + telefono + "', genero = '" + genero + "', descripcion = '" + descripcion + "', mail = '" + mail + "' WHERE dni = '" + dni + "'";
                
                try {

                    Statement consulta = conexion.createStatement();
                    int filasActualizadas = consulta.executeUpdate(consultaActualizar);
                    
                    if (filasActualizadas > 0) {
                        
                        return true;
                        
                    } else {
                        
                        labelResultadoModificar.setText("No se encontró ninguna persona con ese DNI");
                        return false;
                    }

                } catch (SQLException ex) {
                    
                    Logger.getLogger(Ejercicio1.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }

            }

        } else {

            labelResultadoModificar.setText("Debe rellenar todos los datos");
            return false;
        }
        
        return false;
        
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

    public String opcionGenero2(String genero) {

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
        
    public void ocultarCampos() {

        labelNombre.setVisible(false);
        labelApellido.setVisible(false);
        labelTelefono.setVisible(false);
        labelDni.setVisible(false);
        labelGenero.setVisible(false);
        labelDescripcion.setVisible(false);
        labelMail.setVisible(false);
        labelMensajeError.setVisible(false);
        inputNombre.setVisible(false);
        inputApellido.setVisible(false);
        inputTelefono.setVisible(false);
        inputDni.setVisible(false);
        inputGenero.setVisible(false);
        inputDescripcion.setVisible(false);
        inputMail.setVisible(false);
        botonModificar.setVisible(false);
        labelResultadoModificar.setVisible(false);

    }

    public void mostrarCampos() {

        labelNombre.setVisible(true);
        labelApellido.setVisible(true);
        labelTelefono.setVisible(true);
        labelDni.setVisible(true);
        labelGenero.setVisible(true);
        labelDescripcion.setVisible(true);
        labelMail.setVisible(true);
        inputNombre.setVisible(true);
        inputApellido.setVisible(true);
        inputTelefono.setVisible(true);
        inputDni.setVisible(true);
        inputGenero.setVisible(true);
        inputDescripcion.setVisible(true);
        inputMail.setVisible(true);
        botonModificar.setVisible(true);

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
            java.util.logging.Logger.getLogger(Ejercicio4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Ejercicio4().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
