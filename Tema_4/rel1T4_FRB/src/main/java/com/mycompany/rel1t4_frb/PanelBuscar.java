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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import static javax.swing.SwingUtilities.getWindowAncestor;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Propietario
 */
public class PanelBuscar extends javax.swing.JPanel {
    
    Ejercicio5 ejercicio5;
    
    private Connection conexion;
    String baseDeDatos = "relaciont5";
    
    JLabel labelBuscador = new JLabel("Busca un Nombre de una mascota");
    
    JLabel labelNombre = new JLabel("Nombre: ");
    JTextField inputNombre = new JTextField(12);
    
    JLabel labelTipo = new JLabel("Tipo: ");
    JComboBox<String> inputTipo = new JComboBox<>();
    
    JButton botonBuscar = new JButton("Buscar");
    
    DefaultTableModel modeloTabla = new DefaultTableModel();
    JTable tablaMascotas = new JTable(modeloTabla);
    JScrollPane scrollTabla = new JScrollPane(tablaMascotas);
    
    JLabel labelResultado = new JLabel("");
    
    ArrayList<String> idMascotas = new ArrayList<>();
    
        
    /**
     * Creates new form PanelBorrar
     */
    public PanelBuscar() throws SQLException {
        initComponents();
        
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDeDatos+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
                       
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(480,300));
        
        this.add(labelBuscador);
        this.add(labelNombre);
        this.add(inputNombre);
        this.add(labelTipo);
        this.add(inputTipo);
        this.add(botonBuscar);
        
        inputTipo.addItem("perro");
        inputTipo.addItem("gato");
        inputTipo.addItem("canario");
        inputTipo.addItem("hamster");
        inputTipo.addItem("conejo");
        inputTipo.addItem("otro");
        
        labelBuscador.setHorizontalAlignment(labelBuscador.CENTER);
        layout.putConstraint(SpringLayout.WEST, labelBuscador, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelBuscador, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, labelBuscador, 0, SpringLayout.EAST, this);
        
        layout.putConstraint(SpringLayout.WEST, inputNombre, 80, SpringLayout.WEST, labelBuscador);
        layout.putConstraint(SpringLayout.NORTH, inputNombre, 30, SpringLayout.NORTH, labelBuscador);
        
        
        layout.putConstraint(SpringLayout.WEST, labelNombre, 40, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelNombre, 40, SpringLayout.NORTH, this);
        
        layout.putConstraint(SpringLayout.WEST, labelTipo, 0, SpringLayout.WEST, labelNombre);
        layout.putConstraint(SpringLayout.NORTH, labelTipo, 40, SpringLayout.NORTH, labelNombre);
        
        
        layout.putConstraint(SpringLayout.WEST, inputNombre, 80, SpringLayout.WEST, labelNombre);
        layout.putConstraint(SpringLayout.NORTH, inputNombre, -5, SpringLayout.NORTH, labelNombre);
        
        layout.putConstraint(SpringLayout.WEST, inputTipo, 80, SpringLayout.WEST, labelTipo);
        layout.putConstraint(SpringLayout.NORTH, inputTipo, -5, SpringLayout.NORTH, labelTipo);
        
        
        botonBuscar.setPreferredSize(new Dimension(150, 35));
        botonBuscar.setForeground(new Color(255,255,255));
        botonBuscar.setBackground(new Color(55, 63, 81));
        
        layout.putConstraint(SpringLayout.WEST, botonBuscar, 200, SpringLayout.WEST, inputNombre);
        layout.putConstraint(SpringLayout.NORTH, botonBuscar, 15, SpringLayout.NORTH, inputNombre);
        
        this.add(labelResultado);
        labelResultado.setForeground(new Color(241, 81, 82));
        labelResultado.setHorizontalAlignment(labelResultado.CENTER);
        labelResultado.setFont(new Font("Arial", Font.BOLD, 15));
        
        layout.putConstraint(SpringLayout.WEST, labelResultado, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelResultado, 80, SpringLayout.NORTH, inputNombre);
        layout.putConstraint(SpringLayout.EAST, labelResultado, 0, SpringLayout.EAST, this);
        
        scrollTabla.setPreferredSize(new Dimension(480,150));
        this.add(scrollTabla);
        layout.putConstraint(SpringLayout.WEST, scrollTabla, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, scrollTabla, 80, SpringLayout.NORTH, inputNombre);
        scrollTabla.setVisible(false);
        
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Raza");
        
        tablaMascotas.getColumnModel().getColumn(3).setPreferredWidth(250);
        tablaMascotas.setDefaultEditor(Object.class, null);
        
        botonBuscar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                idMascotas.clear();
                modeloTabla.setRowCount(0);
                labelResultado.setText("");
                
                String consultaRecoger = "SELECT * FROM mascota WHERE nombre = '" + inputNombre.getText() + "' AND tipo = '"+ inputTipo.getSelectedItem().toString() +"'";

                try {
            
                    Statement consulta = conexion.createStatement();
                    ResultSet resultado = consulta.executeQuery(consultaRecoger);

                    int totalFilas = 0;

                    while (resultado.next()) {
                        
                        totalFilas++;
                        idMascotas.add(resultado.getString("ID"));
                        
                        modeloTabla.addRow(new Object[]{
                            resultado.getString("nombre"),
                            resultado.getString("tipo"),
                            resultado.getInt("edad"),
                            resultado.getString("descripcion"),
                            resultado.getString("raza")
                        });
                    }
                    
                    if (totalFilas == 0) {
                    
                        scrollTabla.setVisible(false);
                        labelResultado.setText("No se encontraron resultados");
                    
                    } else {
                        
                        scrollTabla.setVisible(true);
                        
                    }

                } catch (SQLException ex) {

                    Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
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
