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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
public class PanelActualizar extends javax.swing.JPanel {
    
    Ejercicio5 ejercicio5;
    
    private Connection conexion;
    String baseDeDatos = "relaciont5";
    
    JLabel labelBuscador = new JLabel("Busca un Nombre de una mascota");
    JTextField inputBuscador = new JTextField(15);
    
    JButton botonBuscar = new JButton("Buscar");
    
    DefaultTableModel modeloTabla = new DefaultTableModel();
    JTable tablaMascotas = new JTable(modeloTabla);
    JScrollPane scrollTabla = new JScrollPane(tablaMascotas);
    
    JLabel labelResultado = new JLabel("");
    
    JButton botonActualizar = new JButton("Modificar");
    
    ArrayList<String> idMascotas = new ArrayList<>();
    
        
    /**
     * Creates new form PanelBorrar
     */
    public PanelActualizar(Ejercicio5 ejercicio5) throws SQLException {
        initComponents();
        
        conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDeDatos+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","root");
                        
        this.ejercicio5 = ejercicio5;
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(480,300));
        
        this.add(labelBuscador);
        this.add(inputBuscador);
        this.add(botonBuscar);
        
        labelBuscador.setHorizontalAlignment(labelBuscador.CENTER);
        layout.putConstraint(SpringLayout.WEST, labelBuscador, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelBuscador, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, labelBuscador, 0, SpringLayout.EAST, this);
        
        layout.putConstraint(SpringLayout.WEST, inputBuscador, 80, SpringLayout.WEST, labelBuscador);
        layout.putConstraint(SpringLayout.NORTH, inputBuscador, 30, SpringLayout.NORTH, labelBuscador);
        
        botonBuscar.setPreferredSize(new Dimension(150, 35));
        botonBuscar.setForeground(new Color(255,255,255));
        botonBuscar.setBackground(new Color(55, 63, 81));
        
        layout.putConstraint(SpringLayout.WEST, botonBuscar, 200, SpringLayout.WEST, inputBuscador);
        layout.putConstraint(SpringLayout.NORTH, botonBuscar, -5, SpringLayout.NORTH, inputBuscador);
        
        this.add(labelResultado);
        labelResultado.setForeground(new Color(241, 81, 82));
        labelResultado.setHorizontalAlignment(labelResultado.CENTER);
        labelResultado.setFont(new Font("Arial", Font.BOLD, 15));
        
        layout.putConstraint(SpringLayout.WEST, labelResultado, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, labelResultado, 40, SpringLayout.NORTH, inputBuscador);
        layout.putConstraint(SpringLayout.EAST, labelResultado, 0, SpringLayout.EAST, this);
        
        scrollTabla.setPreferredSize(new Dimension(480,150));
        this.add(scrollTabla);
        layout.putConstraint(SpringLayout.WEST, scrollTabla, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, scrollTabla, 40, SpringLayout.NORTH, inputBuscador);
        scrollTabla.setVisible(false);
        
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Tipo");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Descripción");
        modeloTabla.addColumn("Raza");
        
        tablaMascotas.getColumnModel().getColumn(3).setPreferredWidth(250);
        
        botonActualizar.setPreferredSize(new Dimension(120, 40));
        botonActualizar.setBackground(new Color(101, 145, 87));
        this.add(botonActualizar);
        
        layout.putConstraint(SpringLayout.WEST, botonActualizar, 180, SpringLayout.WEST, scrollTabla);
        layout.putConstraint(SpringLayout.NORTH, botonActualizar, 170, SpringLayout.NORTH, scrollTabla);
        botonActualizar.setVisible(false);
        
        botonBuscar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                idMascotas.clear();
                modeloTabla.setRowCount(0);
                labelResultado.setText("");
                
                String consultaRecoger = "SELECT * FROM mascota WHERE nombre = '" + inputBuscador.getText() + "'";

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
                        botonActualizar.setVisible(false);
                        labelResultado.setText("No se encontraron resultados");
                        
                    } else {
                        
                        scrollTabla.setVisible(true);
                        botonActualizar.setVisible(true);
                        
                        
                    }

                } catch (SQLException ex) {

                    Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }   
        });
       
        botonActualizar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                scrollTabla.setVisible(false);
                botonActualizar.setVisible(false);
                inputBuscador.setText("");
                int idSeleccionado = 0;
                int numeroErrores = 0;
                Statement consulta = null;
                
                try {
                    
                    consulta = conexion.createStatement();
                    conexion.setAutoCommit(false); 
                    
                } catch (SQLException ex) {
                    Logger.getLogger(PanelActualizar.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                for (Vector datos : modeloTabla.getDataVector()) {
                    
                    String descripcion = "";
                    String raza = "";
                    
                    String id_mascota = idMascotas.get(idSeleccionado);
                    
                    String nombre = datos.get(0).toString();
                    String tipo = datos.get(1).toString();
                    String edad = datos.get(2).toString();
                    descripcion = datos.get(3).toString();
                    raza = datos.get(4).toString();
                    
                    String consultaActualizar = "UPDATE mascota SET nombre = '"+nombre+"', tipo = '"+tipo+"', edad = '"+edad+"', descripcion = '"+descripcion+"', raza = '"+raza+"' WHERE ID = '"+idMascotas.get(idSeleccionado)+"';";

                    try {
                        
                        consulta.executeUpdate(consultaActualizar);
                        
                    } catch (SQLException ex) {
                        
                        numeroErrores++;
                            
                    }
                    
                    idSeleccionado++;
                    
                }
                 

                    if (numeroErrores == 0) {

                        try {
                            
                            conexion.commit();

                        } catch (SQLException ex) {
                            Logger.getLogger(PanelActualizar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        mostrarModal("Mascotas actualizadas correctamente");

                    } else { 

                        try {
                            
                            conexion.rollback();
                        
                        } catch (SQLException ex) {
                            Logger.getLogger(PanelActualizar.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        mostrarModal("Error al actualizar las mascotas");
                    }

                    
            }
        });
    }
    
    public void mostrarModal(String mensaje) {
    
        Window parentWindow = getWindowAncestor(this);
        JDialog modalMensaje = new JDialog((Frame) parentWindow, true);
        SpringLayout layout = new SpringLayout();

        modalMensaje.setLayout(layout);
        modalMensaje.setSize(new Dimension(350, 150));
        modalMensaje.setLocationRelativeTo(PanelActualizar.this); // Para que aparezca el modal en el centro con respecto a al jframe principal

        JLabel labelMensaje = new JLabel(mensaje);
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
