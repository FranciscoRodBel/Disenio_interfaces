/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.examen1_frb;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Francisco
 */
public class FormularioSimple extends javax.swing.JFrame {

    private JPanel panelFormulario = new JPanel();
    private JButton botonCrear = new JButton();
    private JButton botonCerrar = new JButton();
    private JButton botonValidar = new JButton();
    private JButton botonLimpiar = new JButton();
    private JTextField inputNombre = new JTextField();
    private JTextField inputMovil = new JTextField();
    private JTextField inputDNI = new JTextField();
    private JComboBox selectCiudad = new JComboBox();
    private JLabel labelValidacion = new javax.swing.JLabel();
    /**
     * Creates new form FormularioSimple
     */
    public FormularioSimple() {
        initComponents();
        
        this.setBounds(0,0,500,500);
        this.setLayout(null);
        
        
        botonCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearActionPerformed(evt);
            }
        });
        
        botonValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonValidarActionPerformed(evt);
            }
        });
                
        botonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLimpiarActionPerformed(evt);
            }
        });
                        
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });    
        
        botonCrear.setText("Crear");
        botonCrear.setBounds(350,50,100,30);
        this.add(botonCrear);
        
        botonCrear.setVisible(true);
        panelFormulario.setVisible(false);
        
        this.paint(this.getGraphics());
    }

    public void crearFormularioSimple() {
    
        panelFormulario.setBounds(0,0,500,500);
        panelFormulario.setLayout(null);
        this.add(panelFormulario);
        
        botonLimpiar.setText("Limpiar");
        botonLimpiar.setBounds(50,25,100,30);
        panelFormulario.add(botonLimpiar);
        
        botonCerrar.setText("Cerrar");
        botonCerrar.setBounds(350,400,100,30);
        panelFormulario.add(botonCerrar);
        
        botonValidar.setText("Validar");
        botonValidar.setBounds(300,25,100,30);
        panelFormulario.add(botonValidar);
        
        JLabel labelNombre = new javax.swing.JLabel();
        labelNombre.setText("Nombre:");
        labelNombre.setBounds(25,80,100,30);
        panelFormulario.add(labelNombre);
        
        JLabel labelMovil = new javax.swing.JLabel();
        labelMovil.setText("Móvil:");
        labelMovil.setBounds(25,120,100,30);
        panelFormulario.add(labelMovil);
        
        JLabel labelDNI = new javax.swing.JLabel();
        labelDNI.setText("DNI:");
        labelDNI.setBounds(25,160,100,30);
        panelFormulario.add(labelDNI);
        
        JLabel labelCiudad = new javax.swing.JLabel();
        labelCiudad.setText("Ciudad:");
        labelCiudad.setBounds(25,200,100,30);
        panelFormulario.add(labelCiudad);
        
        inputNombre.setBounds(100,80,150,30);
        panelFormulario.add(inputNombre);
        
        inputMovil.setBounds(100,120,150,30);
        panelFormulario.add(inputMovil);
        
        inputDNI.setBounds(100,160,150,30);
        panelFormulario.add(inputDNI);
        
        selectCiudad.setBounds(100,200,150,30);
        selectCiudad.addItem("Granada");
        selectCiudad.addItem("Sevilla");
        selectCiudad.addItem("Ceuta");
        selectCiudad.addItem("Cuenca");
        panelFormulario.add(selectCiudad);
        
        labelValidacion.setText("");
        labelValidacion.setBounds(25,300,1000,25);
        panelFormulario.add(labelValidacion);
        labelValidacion.setVisible(false);
    }
    
    private void botonCrearActionPerformed(java.awt.event.ActionEvent evt) {
        
        crearFormularioSimple();
        botonCrear.setVisible(false);
        panelFormulario.setVisible(true);
        
    } 
    
    private void botonValidarActionPerformed(java.awt.event.ActionEvent evt) {
        
        labelValidacion.setText("");
        labelValidacion.setVisible(false);
        
        if (inputMovil.getText().length() == 0) {
            
            labelValidacion.setText("El móvil está vacío");
            labelValidacion.setVisible(true);
            
        } 
        
        if (inputMovil.getText().length() != 9) {
            
            labelValidacion.setText("El Móvil tiene que tener 9 dígitos");
            labelValidacion.setVisible(true);
            
        } 
        
        if (inputDNI.getText().length() == 0) {
            
            labelValidacion.setText("El DNI está vacío");
            labelValidacion.setVisible(true);
        
        } 
        
        if (inputDNI.getText().length() != 9) {
            
            labelValidacion.setText("El DNI tiene que tener 8 caracteres y un dígito");
            labelValidacion.setVisible(true);
            
        } 
        
        if (inputDNI.getText().length() == 9) {
        
            try {

                Integer.parseInt(inputDNI.getText().substring(inputDNI.getText().length()-1));

            } catch (Exception e){

                labelValidacion.setText("El último caracter del DNI tiene que ser un dígito");
                labelValidacion.setVisible(true);
            }

            String caracteresDNI = inputDNI.getText().substring(0, inputDNI.getText().length()-1);

            for (int i = 0; i < 10 ; i++) {

                if (caracteresDNI.contains(String.valueOf(i))) {

                    labelValidacion.setText("Los 8 primeros caracteres del DNI no puede contener números");
                    labelValidacion.setVisible(true);
                }

            }
        
        } 
        if (inputNombre.getText().length() == 0) {
            
            labelValidacion.setText("El nombre está vacío");
            labelValidacion.setVisible(true);
            
        }
        
        if (inputNombre.getText().length() != 0) { 
            
            for (int i = 0; i < 10 ; i++) {
            
                if (inputNombre.getText().contains(String.valueOf(i))) {
                
                    labelValidacion.setText("El nombre no puede contener números");
                    labelValidacion.setVisible(true);
                }
                
            }
            
        }
        
        if (inputMovil.getText().length() == 9) { 
        
                try {
        
                    Integer.parseInt(inputMovil.getText());

                } catch (Exception e){

                    labelValidacion.setText("El Móvil tiene que estar compuesto de solo 9 dígitos");
                    labelValidacion.setVisible(true);
                }
                
        } 
        
        if (inputMovil.getText().length() != 9) {
            
            labelValidacion.setText("El Móvil tiene que tener 9 dígitos");
            labelValidacion.setVisible(true);
        }
        
        if (labelValidacion.getText().length() == 0) {
            
            labelValidacion.setText("Formulario válido");
            labelValidacion.setVisible(true);
        }
    } 
        
    private void botonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {
        
        inputNombre.setText("");
        inputMovil.setText("");
        inputDNI.setText("");
        labelValidacion.setVisible(false);
    } 
    
    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {
        
        inputNombre.setText("");
        inputMovil.setText("");
        inputDNI.setText("");
        labelValidacion.setVisible(false);
        botonCrear.setVisible(true);
        panelFormulario.setVisible(false);
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
            java.util.logging.Logger.getLogger(FormularioSimple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormularioSimple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormularioSimple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormularioSimple.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormularioSimple().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
