/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.rel1t4_frb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import static javax.swing.SwingUtilities.getWindowAncestor;

/**
 *
 * @author Propietario
 */
public class PanelInsertar extends javax.swing.JPanel {
    
    Ejercicio5 ejercicio5;
    
    private Connection conexion;
    String baseDeDatos = "relaciont5";
    
    JLabel labelNombre = new JLabel("Nombre*:");
    JTextField inputNombre = new JTextField(15);

    JLabel labelTipo = new JLabel("Tipo*:");
    JComboBox<String> inputTipo = new JComboBox<>();

    JLabel labelEdad = new JLabel("Edad*:");
    JTextField inputEdad = new JTextField(15);

    JLabel labelDescripcion = new JLabel("Descripción:");
    JTextField inputDescripcion = new JTextField(15);

    JLabel labelRaza = new JLabel("Raza:");
    JTextField inputRaza = new JTextField(15);

    JButton botonInsertar = new JButton("Insertar");
    
    JLabel labelResultado = new JLabel("");
    
    /**
     * Creates new form panelInsertar
     */
    public PanelInsertar(Ejercicio5 ejercicio5) throws SQLException {
        initComponents();
        
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDeDatos+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
        
        this.ejercicio5 = ejercicio5;
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(480,300));
        
        inputTipo.addItem("perro");
        inputTipo.addItem("gato");
        inputTipo.addItem("canario");
        inputTipo.addItem("hamster");
        inputTipo.addItem("conejo");
        inputTipo.addItem("otro");
        
        this.add(labelNombre);
        this.add(labelTipo);
        this.add(labelEdad);
        this.add(labelDescripcion);
        this.add(labelRaza);
        
        this.add(inputNombre);
        this.add(inputTipo);
        this.add(inputEdad);
        this.add(inputDescripcion);
        this.add(inputRaza);
        
        layout.putConstraint(SpringLayout.WEST, labelNombre, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelNombre, 40, SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.WEST, labelTipo, 0, SpringLayout.WEST, labelNombre);
        layout.putConstraint(SpringLayout.NORTH, labelTipo, 40, SpringLayout.NORTH, labelNombre);
     
        layout.putConstraint(SpringLayout.WEST, labelEdad, 0, SpringLayout.WEST, labelTipo);
        layout.putConstraint(SpringLayout.NORTH, labelEdad, 40, SpringLayout.NORTH, labelTipo);
        
        layout.putConstraint(SpringLayout.WEST, labelDescripcion, 0, SpringLayout.WEST, labelEdad);
        layout.putConstraint(SpringLayout.NORTH, labelDescripcion, 40, SpringLayout.NORTH, labelEdad);
        
        layout.putConstraint(SpringLayout.WEST, labelRaza, 0, SpringLayout.WEST, labelDescripcion);
        layout.putConstraint(SpringLayout.NORTH, labelRaza, 40, SpringLayout.NORTH, labelDescripcion);
        
        
        layout.putConstraint(SpringLayout.WEST, inputNombre, 80, SpringLayout.WEST, labelNombre);
        layout.putConstraint(SpringLayout.NORTH, inputNombre, -5, SpringLayout.NORTH, labelNombre);
        
        layout.putConstraint(SpringLayout.WEST, inputTipo, 80, SpringLayout.WEST, labelTipo);
        layout.putConstraint(SpringLayout.NORTH, inputTipo, -5, SpringLayout.NORTH, labelTipo);
        
        layout.putConstraint(SpringLayout.WEST, inputEdad, 80, SpringLayout.WEST, labelEdad);
        layout.putConstraint(SpringLayout.NORTH, inputEdad, -5, SpringLayout.NORTH, labelEdad);
        
        layout.putConstraint(SpringLayout.WEST, inputDescripcion, 80, SpringLayout.WEST, labelDescripcion);
        layout.putConstraint(SpringLayout.NORTH, inputDescripcion, -5, SpringLayout.NORTH, labelDescripcion);
        
        layout.putConstraint(SpringLayout.WEST, inputRaza, 80, SpringLayout.WEST, labelRaza);
        layout.putConstraint(SpringLayout.NORTH, inputRaza, -5, SpringLayout.NORTH, labelRaza);
        
        this.add(botonInsertar);
        botonInsertar.setPreferredSize(new Dimension(120, 50));
        botonInsertar.setForeground(new Color(255,255,255));
        botonInsertar.setBackground(new Color(55, 63, 81));
        
        layout.putConstraint(SpringLayout.EAST, botonInsertar, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, botonInsertar, -10, SpringLayout.NORTH, inputEdad);
        
        this.add(labelResultado);
        
        labelResultado.setForeground(new Color(241, 81, 82));
        labelResultado.setHorizontalAlignment(labelResultado.CENTER);
        labelResultado.setFont(new Font("Arial", Font.BOLD, 15));
        
        layout.putConstraint(SpringLayout.WEST, labelResultado, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelResultado, 50, SpringLayout.NORTH, inputRaza);
        layout.putConstraint(SpringLayout.EAST, labelResultado, 0, SpringLayout.EAST, this);
        
        botonInsertar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                labelResultado.setText("");
                
                if (!inputNombre.getText().equals("") && !inputEdad.getText().equals("")) {
                    
                    if(contieneNumero(inputNombre.getText())){
                        
                        labelResultado.setText("El nombre es incorrecto");
                    }
                    
                    if(contieneLetra(inputEdad.getText())){
                        
                        labelResultado.setText("La edad es incorrecta");
                    }
                    
                    if(contieneNumero(inputRaza.getText())){
                        
                        labelResultado.setText("La raza es incorrecta");
                    }
        
                    if (labelResultado.getText().length() == 0) {
                        
                        String nombre = inputNombre.getText();
                        String tipo = inputTipo.getSelectedItem().toString();
                        String edad = inputEdad.getText();
                        String descripcion = inputDescripcion.getText();
                        String raza = inputRaza.getText();
                        
                        
                        String consultaInsertar = "INSERT INTO mascota (nombre, tipo,edad, descripcion, raza) VALUES ('" + nombre + "', '" + tipo + "', '" + edad + "', '" + descripcion + "', '" + raza + "')";
                     
                        try {
                            
                            Statement consulta = conexion.createStatement();
                            consulta.executeUpdate(consultaInsertar);
                            
                            mostrarModal();
                            
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
    
    public void mostrarModal() {
    
        Window parentWindow = getWindowAncestor(this);
        JDialog modalMensaje = new JDialog((Frame) parentWindow, true);
        SpringLayout layout = new SpringLayout();

        modalMensaje.setLayout(layout);
        modalMensaje.setSize(new Dimension(350, 150));
        modalMensaje.setLocationRelativeTo(PanelInsertar.this); // Para que aparezca el modal en el centro con respecto a al jframe principal

        JLabel labelMensaje = new JLabel("Mascota insertada correctamente");
        JButton botonAceptar = new JButton("Aceptar");

        labelResultado.setHorizontalAlignment(labelResultado.CENTER);
        labelResultado.setFont(new Font("Arial", Font.BOLD, 15));
        
        modalMensaje.add(labelMensaje);
        modalMensaje.add(botonAceptar);

        layout.putConstraint(SpringLayout.WEST, labelMensaje, 80, SpringLayout.WEST, modalMensaje);
        layout.putConstraint(SpringLayout.NORTH, labelMensaje, 20, SpringLayout.NORTH, modalMensaje);

        layout.putConstraint(SpringLayout.WEST, botonAceptar, 130, SpringLayout.WEST, modalMensaje);
        layout.putConstraint(SpringLayout.NORTH, botonAceptar, 50, SpringLayout.NORTH, labelMensaje);

        botonAceptar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                modalMensaje.dispose();
                
                ejercicio5.itemMostrar.doClick();
                
            }
        });

        modalMensaje.setVisible(true);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
