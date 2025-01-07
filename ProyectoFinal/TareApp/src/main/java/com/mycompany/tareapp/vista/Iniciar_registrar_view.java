/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.modelo.RoundedBorder;
import com.mycompany.tareapp.modelo.TextPrompt;
import com.mycompany.tareapp.vista.plantillas.Cabecera;
import com.mycompany.tareapp.vista.plantillas.Estilos;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Propietario
 */
public class Iniciar_registrar_view extends javax.swing.JPanel {

    Estilos estilos = new Estilos();
    
    JLabel titulo_pagina = new JLabel("Inicio de sesión");
    
    JPanel panel_inicio_registro = new JPanel();
    JPanel panel_inicio = new JPanel();
    JPanel panel_registro = new JPanel();
    
    JButton boton_iniciar = new JButton("Inicio de sesión");
    JButton boton_registrarse = new JButton("Registrarse");
    
    JTextField email_iniciar = new JTextField();
    JPasswordField contrasenia_iniciar = new JPasswordField();
    TextPrompt placeholder_email_iniciar;
    TextPrompt placeholder_contrasenia_iniciar;
    JButton boton_enviar_iniciar = new JButton("Inicio de sesión");
    
    JTextField email_registro = new JTextField();
    JPasswordField contrasenia_registro = new JPasswordField();
    JPasswordField repetir_contrasenia_registro = new JPasswordField();
    JButton boton_enviar_registro = new JButton("Registrarse");
    
    /**
     * Creates new form Iniciar_registrar_view2
     */
    public Iniciar_registrar_view() {
        initComponents();
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(1000, 555));
        this.setMaximumSize(new Dimension(1000, 555));
        this.setBackground(estilos.getGris_claro());
        
        this.add(titulo_pagina);
        titulo_pagina.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_pagina.setFont(estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, titulo_pagina, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, titulo_pagina, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, titulo_pagina, 0, SpringLayout.EAST, this);
        
        this.add(panel_inicio_registro);
        panel_inicio_registro.setLayout(layout);
        panel_inicio_registro.setBackground(estilos.getBlanco_claro());
        panel_inicio_registro.setPreferredSize(new Dimension(400, 50));
        layout.putConstraint(SpringLayout.WEST, panel_inicio_registro, 300, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, panel_inicio_registro, 50, SpringLayout.NORTH, titulo_pagina);

        boton_iniciar.setFont(estilos.getFuente());
        boton_iniciar.setFocusPainted(false);
        boton_iniciar.setFocusPainted(false);
        boton_iniciar.setBackground(estilos.getBlanco_claro());
        boton_iniciar.setPreferredSize(new Dimension(200, 50));
        panel_inicio_registro.add(boton_iniciar);
        layout.putConstraint(SpringLayout.WEST, boton_iniciar, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, boton_iniciar, 0, SpringLayout.NORTH, this);
        
        boton_registrarse.setFont(estilos.getFuente());
        boton_registrarse.setFocusPainted(false);
        boton_registrarse.setFocusPainted(false);
        boton_registrarse.setBackground(estilos.getBlanco_claro());
        boton_registrarse.setPreferredSize(new Dimension(200, 50));
        panel_inicio_registro.add(boton_registrarse);
        layout.putConstraint(SpringLayout.WEST, boton_registrarse, 200, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, boton_registrarse, 0, SpringLayout.NORTH, this);
        
        this.add(panel_inicio);
        panel_inicio.setLayout(layout);
        panel_inicio.setBackground(estilos.getBlanco());
        panel_inicio.setPreferredSize(new Dimension(400, 300));
        layout.putConstraint(SpringLayout.WEST, panel_inicio, 0, SpringLayout.WEST, panel_inicio_registro);
        layout.putConstraint(SpringLayout.NORTH, panel_inicio, 50, SpringLayout.NORTH, panel_inicio_registro);
        
        panel_inicio.add(email_iniciar);
        email_iniciar.setBorder(new RoundedBorder(5, 2));
        email_iniciar.setBackground(estilos.getBlanco_claro());
        email_iniciar.setPreferredSize(new Dimension(260, 35));
        layout.putConstraint(SpringLayout.WEST, email_iniciar, 70, SpringLayout.WEST, panel_inicio);
        layout.putConstraint(SpringLayout.NORTH, email_iniciar, 30, SpringLayout.NORTH, panel_inicio);
        placeholder_email_iniciar = new TextPrompt("Email", email_iniciar);
        
        panel_inicio.add(contrasenia_iniciar);
        contrasenia_iniciar.setBorder(new RoundedBorder(5, 2));
        contrasenia_iniciar.setBackground(estilos.getBlanco_claro());
        contrasenia_iniciar.setPreferredSize(new Dimension(260, 35));
        layout.putConstraint(SpringLayout.WEST, contrasenia_iniciar, 70, SpringLayout.WEST, panel_inicio);
        layout.putConstraint(SpringLayout.NORTH, contrasenia_iniciar, 60, SpringLayout.NORTH, email_iniciar);
        placeholder_contrasenia_iniciar = new TextPrompt("Contraseña", contrasenia_iniciar);
                
        
        
        /*
        this.add(panel_registro);
        panel_registro.setLayout(layout);
        panel_registro.setBackground(estilos.getBlanco());
        panel_registro.setPreferredSize(new Dimension(400, 50));
        layout.putConstraint(SpringLayout.WEST, panel_registro, 0, SpringLayout.WEST, panel_inicio_registro);
        layout.putConstraint(SpringLayout.NORTH, panel_registro, 50, SpringLayout.NORTH, panel_inicio_registro);
        */
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
