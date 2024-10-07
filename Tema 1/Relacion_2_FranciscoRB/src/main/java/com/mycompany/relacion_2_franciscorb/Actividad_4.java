/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.relacion_2_franciscorb;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author Propietario
 */
public class Actividad_4 extends javax.swing.JFrame {

    private JPanel panelMenu = new JPanel();
    private JPanel panelUsuario = new JPanel();
    private JPanel panelAplicacion = new JPanel();
    private JButton botonUsuario = new JButton();
    private JButton botonAplicacion = new JButton();
    private JButton botonSalir = new JButton();
    private JTextField inputNombre = new JTextField();
    private JTextField inputEdad = new JTextField();
    private JTextField inputApellidos = new JTextField();
    private JComboBox<String> selectGenero = new JComboBox<String>();
    private JTextArea TextAreaDescripcion = new JTextArea();
    private ButtonGroup opcionesMetodoPago = new javax.swing.ButtonGroup();
    
    /**
     * Creates new form Actividad_4
     */
    public Actividad_4() {
        initComponents();
        
        this.setBounds(0, 0, 500, 500);
        this.setLayout(null);
        
        crearPanelMenu();
        crearPanelUsuario();
        crearPanelAplicacion();
        
        panelMenu.setVisible(true);
        panelUsuario.setVisible(false);
        panelAplicacion.setVisible(false);
        
        this.paint(getGraphics());
        
        botonUsuario.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                botonUsuarioPulsado(evt);
            }
        });

        botonAplicacion.addActionListener(new ActionListener() {
  
            public void actionPerformed(ActionEvent evt) {
                botonAplicacionPulsado(evt);
            }
        });

        botonSalir.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent evt) {
                botonSalirPulsado(evt);
            }
        });

    }
    
    public void crearPanelMenu() {

        panelMenu.setLayout(null);
        panelMenu.setBackground(new Color(245, 245, 245));
        panelMenu.setBounds(0, 0, 500, 500);
        this.add(panelMenu);

        botonUsuario.setText("Usuario");
        botonUsuario.setBounds(40, 20, 100, 30);
        botonUsuario.setBackground(new Color(57, 62, 65));
        botonUsuario.setForeground(new Color(211, 208, 203));
        botonUsuario.setFocusPainted(false);
        botonUsuario.setFont(new Font("Arial",1, 15));
        panelMenu.add(botonUsuario);

        botonAplicacion.setText("Aplicación");
        botonAplicacion.setBounds(190, 20, 100, 30);
        botonAplicacion.setBackground(new Color(57, 62, 65));
        botonAplicacion.setForeground(new Color(211, 208, 203));
        botonAplicacion.setFocusPainted(false);
        botonAplicacion.setFont(new Font("Arial",1, 15));
        panelMenu.add(botonAplicacion);

        botonSalir.setText("Salir");
        botonSalir.setBounds(340, 20, 100, 30);
        botonSalir.setBackground(new Color(57, 62, 65));
        botonSalir.setForeground(new Color(211, 208, 203));
        botonSalir.setFocusPainted(false);
        botonSalir.setFont(new Font("Arial",1, 15));
        panelMenu.add(botonSalir);

    }
    
    public void crearPanelUsuario() {
        
        panelUsuario.setLayout(null);
        panelUsuario.setBackground(new Color(184, 184, 184));
        panelUsuario.setBounds(0, 70, 500, 430);
        panelMenu.add(panelUsuario);
        
        JLabel labelTitulo = new JLabel();
        labelTitulo.setText("Información usuario");
        labelTitulo.setFont(new Font("Arial", 1, 17));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(0, 0, 500, 50);
        panelUsuario.add(labelTitulo);
        
        JLabel labelNombre = new JLabel();
        labelNombre.setText("Nombre: ");
        labelNombre.setFont(new Font("Arial",1, 12));
        labelNombre.setBounds(30, 50, 100, 20);
        panelUsuario.add(labelNombre);
        
        JLabel labelApellidos = new JLabel();
        labelApellidos.setText("Apellidos: ");
        labelApellidos.setFont(new Font("Arial",1, 12));
        labelApellidos.setBounds(30, 100, 100, 20);
        panelUsuario.add(labelApellidos);
        
        JLabel labelGenero = new JLabel();
        labelGenero.setText("Género: ");
        labelGenero.setFont(new Font("Arial",1, 12));
        labelGenero.setBounds(265, 50, 100, 20);
        panelUsuario.add(labelGenero);
        
        JLabel labelEdad = new JLabel();
        labelEdad.setText("Edad: ");
        labelEdad.setFont(new Font("Arial",1, 12));
        labelEdad.setBounds(350, 100, 100, 20);
        panelUsuario.add(labelEdad);
        
        inputNombre.setBounds(100, 45, 120, 30);
        panelUsuario.add(inputNombre);
        
        selectGenero.setBounds(330, 45, 120, 30);
        selectGenero.addItem("Masculino");
        selectGenero.addItem("Femenino");
        selectGenero.addItem("No binario");
        panelUsuario.add(selectGenero);
        
        inputApellidos.setBounds(100, 95, 200, 30);
        panelUsuario.add(inputApellidos);

        inputEdad.setBounds(400, 95, 50, 30);
        panelUsuario.add(inputEdad);
        
        JLabel labelDescripcion = new JLabel();
        labelDescripcion.setText("Descripción: ");
        labelDescripcion.setFont(new Font("Arial",1, 12));
        labelDescripcion.setBounds(30, 150, 100, 20);
        panelUsuario.add(labelDescripcion);
        
        TextAreaDescripcion.setBounds(30, 180, 420, 150);
        panelUsuario.add(TextAreaDescripcion);
        
    }
    
        public void crearPanelAplicacion() {
        
        panelAplicacion.setLayout(null);
        panelAplicacion.setBackground(new Color(184, 184, 184));
        panelAplicacion.setBounds(0, 70, 500, 430);
        panelMenu.add(panelAplicacion);
        
        JLabel labelTitulo = new JLabel();
        labelTitulo.setText("Aplicación");
        labelTitulo.setFont(new Font("Arial", 1, 17));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(0, 0, 500, 50);
        panelAplicacion.add(labelTitulo);
        
        JCheckBox appVscode = new JCheckBox();
        JCheckBox appNetBeans = new JCheckBox();
        JCheckBox appIntelliJ = new JCheckBox();
        JCheckBox appEclipse = new JCheckBox();        
        JCheckBox appUnity = new JCheckBox();
                                
        appVscode.setText("VScode");
        appVscode.setBounds(0, 50, 100, 50);
        appVscode.setFont(new Font("Arial", 1, 15));
        panelAplicacion.add(appVscode);
        
        appNetBeans.setText("NetBeans");
        appNetBeans.setBounds(100, 50, 100, 50);
        appNetBeans.setFont(new Font("Arial", 1, 15));
        panelAplicacion.add(appNetBeans);
        
        appIntelliJ.setText("IntelliJ");
        appIntelliJ.setBounds(200, 50, 100, 50);
        appIntelliJ.setFont(new Font("Arial", 1, 15));
        panelAplicacion.add(appIntelliJ);
        
        appEclipse.setText("Eclipse");
        appEclipse.setBounds(300, 50, 100, 50);
        appEclipse.setFont(new Font("Arial", 1, 15));
        panelAplicacion.add(appEclipse);
        
        appUnity.setText("Unity");
        appUnity.setBounds(400, 50, 100, 50);
        appUnity.setFont(new Font("Arial", 1, 15));
        panelAplicacion.add(appUnity);
        
        JLabel labelMetodoPago = new JLabel();
        labelMetodoPago.setText("Método de pago");
        labelMetodoPago.setHorizontalAlignment(SwingConstants.CENTER);
        labelMetodoPago.setFont(new Font("Arial", 1, 17));
        labelMetodoPago.setBounds(0, 100, 500, 50);
        panelAplicacion.add(labelMetodoPago);
        
        JRadioButton opcionTarjeta = new JRadioButton();
        opcionTarjeta.setText("Tarjeta");
        opcionTarjeta.setBounds(50, 150, 100, 50);
        opcionTarjeta.setFont(new Font("Arial", 1, 15));
                
        JRadioButton opcionBizum = new JRadioButton();
        opcionBizum.setText("Bizum");
        opcionBizum.setBounds(200, 150, 100, 50);
        opcionBizum.setFont(new Font("Arial", 1, 15));
                
        JRadioButton opcionPaypal = new JRadioButton();
        opcionPaypal.setText("PayPal");
        opcionPaypal.setBounds(350, 150, 100, 50);
        opcionPaypal.setFont(new Font("Arial", 1, 15));
        
        opcionesMetodoPago.add(opcionTarjeta);
        opcionesMetodoPago.add(opcionBizum);
        opcionesMetodoPago.add(opcionPaypal);
        
        panelAplicacion.add(opcionTarjeta);
        panelAplicacion.add(opcionBizum);
        panelAplicacion.add(opcionPaypal);
    }
    
    private void botonUsuarioPulsado(java.awt.event.ActionEvent evt) {                                         


        cambiarColorBoton(botonUsuario, botonAplicacion);
        panelUsuario.setVisible(true);
        panelAplicacion.setVisible(false);
        
    }
    
    private void botonAplicacionPulsado(java.awt.event.ActionEvent evt) {                                         
        
        cambiarColorBoton(botonAplicacion, botonUsuario);
        panelUsuario.setVisible(false);
        panelAplicacion.setVisible(true);
        
    }
    
    private void botonSalirPulsado(java.awt.event.ActionEvent evt) {                                         

        System.exit(0);
    }  

    public static void cambiarColorBoton(JButton botonAmarillo, JButton botonNormal) {
        
        botonAmarillo.setBackground(new Color(226, 192, 68));
        botonNormal.setBackground(new Color(57, 62, 65));
        
        botonAmarillo.setForeground(new Color(0, 0, 0));
        botonNormal.setForeground(new Color(211, 208, 203));
        
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
            java.util.logging.Logger.getLogger(Actividad_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Actividad_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Actividad_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Actividad_4.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Actividad_4().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
