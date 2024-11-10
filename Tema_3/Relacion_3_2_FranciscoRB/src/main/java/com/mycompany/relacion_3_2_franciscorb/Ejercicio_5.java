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
 * @author Francisco
 */
public class Ejercicio_5 extends javax.swing.JFrame {

    private JPanel panelInfoPersonal = new JPanel();
    private JPanel panelInfoDomiciliaria = new JPanel();
    private JButton botonSiguiente = new JButton();
    private JButton botonAnterior = new JButton();
    private JButton botonEnviar = new JButton();
    private JTextField inputNombre = new JTextField();
    private JTextField inputApellidos = new JTextField();
    private JTextField inputNumeroTelefono = new JTextField();
    private JComboBox<String> selectGenero = new JComboBox<String>();
    private JTextField inputEmail = new JTextField();
    private JTextField inputNumero = new JTextField();
    private JComboBox<String> selectCiudad = new JComboBox<String>();
    private JTextField inputCP = new JTextField();
    private JTextField inputDireccion = new JTextField();
    
    // Añadido para el ejercicio 5
    
    private JList listaResumenDatos = new JList<>();
    private DefaultListModel<String> modelDatosResumen = new DefaultListModel<String>();
    private JScrollPane scrollListaDatos = new JScrollPane(listaResumenDatos);
    
    
    public void crearPanelInformacionPersonal() {

        panelInfoPersonal.setLayout(null);
        panelInfoPersonal.setBackground(new Color(214, 217, 223));
        panelInfoPersonal.setBounds(0, 0, 500, 500);
        this.add(panelInfoPersonal);
        
        JPanel panelAmarillo = new JPanel();
        panelAmarillo.setLayout(null);
        panelAmarillo.setBackground(new Color(255, 255, 200));
        panelAmarillo.setBounds(50, 50, 375, 360);
        panelInfoPersonal.add(panelAmarillo);

        JLabel labelTitulo = new JLabel();
        labelTitulo.setText("Información personal");
        labelTitulo.setFont(new Font("Arial",1, 15));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(0, 0, 500, 50);
        panelInfoPersonal.add(labelTitulo);

        JLabel labelNombre = new JLabel();
        labelNombre.setText("Nombre: ");
        labelNombre.setFont(new Font("Arial",1, 12));
        labelNombre.setBounds(100, 50, 100, 20);
        panelAmarillo.add(labelNombre);
        
        JLabel labelApellidos = new JLabel();
        labelApellidos.setText("Apellidos: ");
        labelApellidos.setFont(new Font("Arial",1, 12));
        labelApellidos.setBounds(100, 100, 100, 20);
        panelAmarillo.add(labelApellidos);
        
        JLabel LabelTelefono = new JLabel();
        LabelTelefono.setText("Teléfono: ");
        LabelTelefono.setFont(new Font("Arial",1, 12));
        LabelTelefono.setBounds(100, 150, 100, 20);
        panelAmarillo.add(LabelTelefono);
        
        JLabel labelGenero = new JLabel();
        labelGenero.setText("Género: ");
        labelGenero.setFont(new Font("Arial",1, 12));
        labelGenero.setBounds(100, 200, 100, 20);
        panelAmarillo.add(labelGenero);
        
        JLabel labelEmail = new JLabel();
        labelEmail.setText("Email: ");
        labelEmail.setFont(new Font("Arial",1, 12));
        labelEmail.setBounds(100, 250, 100, 20);
        panelAmarillo.add(labelEmail);
        
        inputNombre.setBounds(180, 45, 100, 30);
        panelAmarillo.add(inputNombre);
        
        inputApellidos.setBounds(180, 95, 100, 30);
        panelAmarillo.add(inputApellidos);
        
        inputNumeroTelefono.setBounds(180, 145, 100, 30);
        panelAmarillo.add(inputNumeroTelefono);
        
        selectGenero.setBounds(180, 195, 100, 30);
        selectGenero.addItem("Masculino");
        selectGenero.addItem("Femenino");
        selectGenero.addItem("No binario");
        panelAmarillo.add(selectGenero);
        
        inputEmail.setBounds(180, 245, 100, 30);
        panelAmarillo.add(inputEmail); 
        
        botonSiguiente.setText("Siguiente");
        botonSiguiente.setBounds(150, 300, 100, 30);
        panelAmarillo.add(botonSiguiente);

    }
    
    
    public void crearPanelInformacionDomiciliaria() {

        panelInfoDomiciliaria.setLayout(null);
        panelInfoDomiciliaria.setBackground(new Color(214, 217, 223));
        panelInfoDomiciliaria.setBounds(0, 0, 500, 500);
        this.add(panelInfoDomiciliaria);
        
        JPanel panelAmarillo = new JPanel();
        panelAmarillo.setLayout(null);
        panelAmarillo.setBackground(new Color(255, 255, 200));
        panelAmarillo.setBounds(50, 50, 375, 360);
        panelInfoDomiciliaria.add(panelAmarillo);

        JLabel labelTitulo = new JLabel();
        labelTitulo.setText("Información domiciliaria");
        labelTitulo.setFont(new Font("Arial",1, 15));
        labelTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitulo.setBounds(0, 0, 500, 50);
        panelInfoDomiciliaria.add(labelTitulo);

        JLabel labelDireccion = new JLabel();
        labelDireccion.setText("Dirección: ");
        labelDireccion.setFont(new Font("Arial",1, 12));
        labelDireccion.setBounds(100, 50, 100, 20);
        panelAmarillo.add(labelDireccion);
        
        JLabel labelNumero = new JLabel();
        labelNumero.setText("Número: ");
        labelNumero.setFont(new Font("Arial",1, 12));
        labelNumero.setBounds(100, 100, 100, 20);
        panelAmarillo.add(labelNumero);
        
        JLabel labelCiudad = new JLabel();
        labelCiudad.setText("Ciudad: ");
        labelCiudad.setFont(new Font("Arial",1, 12));
        labelCiudad.setBounds(100, 150, 100, 20);
        panelAmarillo.add(labelCiudad);
        
        JLabel labelCP = new JLabel();
        labelCP.setText("CP: ");
        labelCP.setFont(new Font("Arial",1, 12));
        labelCP.setBounds(100, 200, 100, 20);
        panelAmarillo.add(labelCP);
        
        inputDireccion.setBounds(180, 45, 180, 30);
        panelAmarillo.add(inputDireccion);
        
        inputNumero.setBounds(180, 95, 30, 30);
        panelAmarillo.add(inputNumero);
        
        selectCiudad.setBounds(180, 145, 100, 30);
        selectCiudad.addItem("Ceuta");
        selectCiudad.addItem("Granada");
        selectCiudad.addItem("Almería");
        selectCiudad.addItem("Málaga");
        selectCiudad.addItem("Cádiz");
        selectCiudad.addItem("Tenerife");
        selectCiudad.addItem("Murcia");
        panelAmarillo.add(selectCiudad);
        
        inputCP.setBounds(180, 195, 100, 30);
        panelAmarillo.add(inputCP); 
        
        botonAnterior.setText("Anterior");
        botonAnterior.setBounds(80, 250, 100, 30);
        panelAmarillo.add(botonAnterior);
        
        botonEnviar.setText("Enviar");
        botonEnviar.setBounds(200, 250, 100, 30);
        panelAmarillo.add(botonEnviar);

    }
    
    /**
     * Creates new form Actividad_3
     */
    public Ejercicio_5() {
        initComponents();
        
        this.setBounds(0, 0, 500, 500);
        this.setLayout(null);
        
        crearPanelInformacionPersonal();
        crearPanelInformacionDomiciliaria();
        
        panelInfoDomiciliaria.setVisible(false);
        
        this.paint(getGraphics());
        
        botonSiguiente.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                botonSiguientePulsado(evt);
            }
        });

        botonAnterior.addActionListener(new ActionListener() {
  
            public void actionPerformed(ActionEvent evt) {
                botonAnteriorPulsado(evt);
            }
        });
        
        
        // Nuevo añadido para el ejercicio 5
        
        scrollListaDatos.setPreferredSize(new Dimension(300, 150));
        
        
        botonEnviar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if (!inputDireccion.getText().equals("") && !inputNumero.getText().equals("") && !inputCP.getText().equals("")) {
                    
                    modelDatosResumen.addElement("Nombre: "+inputNombre.getText());
                    modelDatosResumen.addElement("Apellidos: "+inputApellidos.getText());
                    modelDatosResumen.addElement("Teléfono: "+inputNumeroTelefono.getText());
                    modelDatosResumen.addElement("Género: "+selectGenero.getSelectedItem().toString());
                    modelDatosResumen.addElement("Email: "+inputEmail.getText());
                    modelDatosResumen.addElement("Dirección: "+inputDireccion.getText());
                    modelDatosResumen.addElement("Número: "+inputNumero.getText());
                    modelDatosResumen.addElement("Ciudad: "+selectCiudad.getSelectedItem().toString());
                    modelDatosResumen.addElement("CP: "+inputCP.getText());
                    
                    listaResumenDatos.setModel(modelDatosResumen);
                    
                    JDialog modalSalir = new JDialog(Ejercicio_5.this, true);
                    SpringLayout layout = new SpringLayout();

                    modalSalir.setLayout(layout);
                    modalSalir.setSize(new Dimension(400, 300));
                    modalSalir.setLocationRelativeTo(Ejercicio_5.this); // Para que aparezca el modal en el centro con respecto a al jframe principal

                    JLabel labelSalir = new JLabel("Resumen de los datos");
                    
                    JButton botonEnviar = new JButton("Enviar");
                    JButton botonCancelar = new JButton("Cancelar");

                    modalSalir.add(labelSalir);
                    modalSalir.add(scrollListaDatos);
                    modalSalir.add(botonEnviar);
                    modalSalir.add(botonCancelar);

                    layout.putConstraint(SpringLayout.WEST, labelSalir, 150, SpringLayout.WEST, modalSalir);
                    layout.putConstraint(SpringLayout.NORTH, labelSalir, 20, SpringLayout.NORTH, modalSalir);
                    
                    layout.putConstraint(SpringLayout.WEST, scrollListaDatos, 50, SpringLayout.WEST, modalSalir);
                    layout.putConstraint(SpringLayout.NORTH, scrollListaDatos, 50, SpringLayout.NORTH, modalSalir);

                    layout.putConstraint(SpringLayout.WEST, botonCancelar, 70, SpringLayout.WEST, scrollListaDatos);
                    layout.putConstraint(SpringLayout.NORTH, botonCancelar, 20, SpringLayout.SOUTH, scrollListaDatos);

                    layout.putConstraint(SpringLayout.WEST, botonEnviar, 20, SpringLayout.EAST, botonCancelar);
                    layout.putConstraint(SpringLayout.NORTH, botonEnviar, 0, SpringLayout.NORTH, botonCancelar);
                    
                    botonEnviar.addActionListener(new ActionListener() {

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
            }
        });
    }
    
    private void botonSiguientePulsado(java.awt.event.ActionEvent evt) {                                         

        if (!this.inputNombre.getText().equals("") && !this.inputApellidos.getText().equals("") && !this.inputNumeroTelefono.getText().equals("") && !this.inputEmail.getText().equals("")) {
            
            panelInfoPersonal.setVisible(false);
            panelInfoDomiciliaria.setVisible(true);
            
        }
        
    }
    
    private void botonAnteriorPulsado(java.awt.event.ActionEvent evt) {                                         
        
        panelInfoPersonal.setVisible(true);
        panelInfoDomiciliaria.setVisible(false);
        
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
        setMinimumSize(null);
        setResizable(false);
        setSize(new java.awt.Dimension(500, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Ejercicio_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ejercicio_5.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ejercicio_5().setVisible(true);
            }
        });
        
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
