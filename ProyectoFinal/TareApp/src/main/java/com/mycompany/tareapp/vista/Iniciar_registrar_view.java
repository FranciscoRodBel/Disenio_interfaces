/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.vista.plantillas.RoundedBorder;
import com.mycompany.tareapp.vista.plantillas.TextPrompt;
import com.mycompany.tareapp.vista.plantillas.Boton;
import com.mycompany.tareapp.vista.plantillas.Cabecera;
import com.mycompany.tareapp.vista.plantillas.Estilos;
import com.mycompany.tareapp.vista.plantillas.Input_password;
import com.mycompany.tareapp.vista.plantillas.Input_text;
import com.mycompany.tareapp.vista.plantillas.Lista;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Propietario
 */
public class Iniciar_registrar_view extends javax.swing.JPanel {
    
    JLabel titulo_pagina_inicio = new JLabel("Inicio de sesión");
    JLabel titulo_pagina_registro = new JLabel("Registro");
    
    JPanel panel_inicio = new JPanel();
    JPanel panel_registro = new JPanel();
    
    JButton boton_iniciar = new JButton("Inicio de sesión");
    JButton boton_registrarse = new JButton("Registrarse");
    
    Input_text email_iniciar = new Input_text("Email", "");
    Input_password contrasenia_iniciar = new Input_password("Contraseña");
    Boton boton_enviar_inicio = new Boton("Inicio de sesión");
   
    Input_text email_registro = new Input_text("Email", "");
    Input_password contrasenia_registro = new Input_password("Contraseña");
    Input_password repetir_contrasenia_registro = new Input_password("Repetir contraseña");
    Boton boton_enviar_registro = new Boton("Registrarse");
    
    
    /**
     * Creates new form Iniciar_registrar_view2
     */
    public Iniciar_registrar_view() {
        initComponents();
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(1000, 555));
        this.setMaximumSize(new Dimension(1000, 555));
        this.setBackground(Estilos.getGris_claro());
        
        this.add(titulo_pagina_inicio);
        titulo_pagina_inicio.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_pagina_inicio.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, titulo_pagina_inicio, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, titulo_pagina_inicio, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, titulo_pagina_inicio, 0, SpringLayout.EAST, this);
        titulo_pagina_inicio.setVisible(true);
        
        this.add(titulo_pagina_registro);
        titulo_pagina_registro.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_pagina_registro.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, titulo_pagina_registro, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, titulo_pagina_registro, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, titulo_pagina_registro, 0, SpringLayout.EAST, this);
        titulo_pagina_registro.setVisible(false);

        boton_iniciar.setFont(Estilos.getFuente());
        boton_iniciar.setFocusPainted(false);
        boton_iniciar.setUI(new BasicButtonUI()); // Eliminar estilos
        boton_iniciar.setBorder(new LineBorder(Estilos.getNegro(),2,true));
        boton_iniciar.setBackground(Estilos.getAzul_oscuro());
        boton_iniciar.setForeground(Estilos.getBlanco());
        boton_iniciar.setPreferredSize(new Dimension(201, 40));
        this.add(boton_iniciar);
        layout.putConstraint(SpringLayout.WEST, boton_iniciar, 300, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, boton_iniciar, 70, SpringLayout.NORTH, this);
        
        boton_registrarse.setFont(Estilos.getFuente());
        boton_registrarse.setFocusPainted(false);
        boton_registrarse.setUI(new BasicButtonUI());
        boton_registrarse.setBorder(new LineBorder(Estilos.getNegro(),2,true));
        boton_registrarse.setBackground(Estilos.getBlanco_claro());
        boton_registrarse.setForeground(Estilos.getNegro());
        boton_registrarse.setPreferredSize(new Dimension(201, 40));
        this.add(boton_registrarse);
        layout.putConstraint(SpringLayout.WEST, boton_registrarse, 199, SpringLayout.WEST, boton_iniciar);
        layout.putConstraint(SpringLayout.NORTH, boton_registrarse, 70, SpringLayout.NORTH, this);
        
        this.add(panel_inicio);
        SpringLayout layout2 = new SpringLayout();
        panel_inicio.setLayout(layout2);
        panel_inicio.setBackground(Estilos.getBlanco_claro());
        panel_inicio.setBorder(new RoundedBorder(2, 2));
        panel_inicio.setPreferredSize(new Dimension(400, 220));
        layout.putConstraint(SpringLayout.WEST, panel_inicio, 300, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, panel_inicio, 38, SpringLayout.NORTH, boton_iniciar);
        
        panel_inicio.add(email_iniciar);
        layout2.putConstraint(SpringLayout.WEST, email_iniciar, 70, SpringLayout.WEST, panel_inicio);
        layout2.putConstraint(SpringLayout.NORTH, email_iniciar, 30, SpringLayout.NORTH, panel_inicio);
        
        panel_inicio.add(contrasenia_iniciar);
        layout2.putConstraint(SpringLayout.WEST, contrasenia_iniciar, 70, SpringLayout.WEST, panel_inicio);
        layout2.putConstraint(SpringLayout.NORTH, contrasenia_iniciar, 60, SpringLayout.NORTH, email_iniciar);
                
        panel_inicio.add(boton_enviar_inicio);
        layout2.putConstraint(SpringLayout.WEST, boton_enviar_inicio, 100, SpringLayout.WEST, panel_inicio);
        layout2.putConstraint(SpringLayout.NORTH, boton_enviar_inicio, 60, SpringLayout.NORTH, contrasenia_iniciar);
        panel_inicio.setVisible(true);
        
        this.add(panel_registro);
        SpringLayout layout3 = new SpringLayout();
        panel_registro.setLayout(layout3);
        panel_registro.setBackground(Estilos.getBlanco_claro());
        panel_registro.setBorder(new RoundedBorder(2, 2));
        panel_registro.setPreferredSize(new Dimension(400, 280));
        layout.putConstraint(SpringLayout.WEST, panel_registro, 300, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, panel_registro, 38, SpringLayout.NORTH, boton_registrarse);
        
        panel_registro.add(email_registro);
        layout3.putConstraint(SpringLayout.WEST, email_registro, 70, SpringLayout.WEST, panel_registro);
        layout3.putConstraint(SpringLayout.NORTH, email_registro, 30, SpringLayout.NORTH, panel_registro);
        
        panel_registro.add(contrasenia_registro);
        layout3.putConstraint(SpringLayout.WEST, contrasenia_registro, 70, SpringLayout.WEST, panel_registro);
        layout3.putConstraint(SpringLayout.NORTH, contrasenia_registro, 60, SpringLayout.NORTH, email_registro);
        
        panel_registro.add(repetir_contrasenia_registro);
        layout3.putConstraint(SpringLayout.WEST, repetir_contrasenia_registro, 70, SpringLayout.WEST, panel_registro);
        layout3.putConstraint(SpringLayout.NORTH, repetir_contrasenia_registro, 60, SpringLayout.NORTH, contrasenia_registro);
                
        panel_registro.add(boton_enviar_registro);
        layout3.putConstraint(SpringLayout.WEST, boton_enviar_registro, 100, SpringLayout.WEST, panel_registro);
        layout3.putConstraint(SpringLayout.NORTH, boton_enviar_registro, 60, SpringLayout.NORTH, repetir_contrasenia_registro);
        panel_registro.setVisible(false);
        
        boton_iniciar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                panel_inicio.setVisible(true);
                panel_registro.setVisible(false);
                boton_iniciar.setBackground(Estilos.getAzul_oscuro());
                boton_iniciar.setForeground(Estilos.getBlanco());
                boton_registrarse.setBackground(Estilos.getBlanco_claro());
                boton_registrarse.setForeground(Estilos.getNegro());
                titulo_pagina_inicio.setVisible(true);
                titulo_pagina_registro.setVisible(false);
            }
        });
        
        boton_registrarse.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                panel_inicio.setVisible(false);
                panel_registro.setVisible(true);
                boton_registrarse.setBackground(Estilos.getAzul_oscuro());
                boton_registrarse.setForeground(Estilos.getBlanco());
                boton_iniciar.setBackground(Estilos.getBlanco_claro());
                boton_iniciar.setForeground(Estilos.getNegro());
                titulo_pagina_inicio.setVisible(false);
                titulo_pagina_registro.setVisible(true);
            }
        });
        
        boton_enviar_registro.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
    
    public JLabel getTitulo_pagina_inicio() {
        return titulo_pagina_inicio;
    }

    public void setTitulo_pagina_inicio(JLabel titulo_pagina_inicio) {
        this.titulo_pagina_inicio = titulo_pagina_inicio;
    }

    public JLabel getTitulo_pagina_registro() {
        return titulo_pagina_registro;
    }

    public void setTitulo_pagina_registro(JLabel titulo_pagina_registro) {
        this.titulo_pagina_registro = titulo_pagina_registro;
    }

    public JButton getBoton_iniciar() {
        return boton_iniciar;
    }

    public void setBoton_iniciar(JButton boton_iniciar) {
        this.boton_iniciar = boton_iniciar;
    }

    public JButton getBoton_registrarse() {
        return boton_registrarse;
    }

    public void setBoton_registrarse(JButton boton_registrarse) {
        this.boton_registrarse = boton_registrarse;
    }

    public Input_text getEmail_iniciar() {
        return email_iniciar;
    }

    public void setEmail_iniciar(Input_text email_iniciar) {
        this.email_iniciar = email_iniciar;
    }

    public Input_password getContrasenia_iniciar() {
        return contrasenia_iniciar;
    }

    public void setContrasenia_iniciar(Input_password contrasenia_iniciar) {
        this.contrasenia_iniciar = contrasenia_iniciar;
    }

    public Boton getBoton_enviar_inicio() {
        return boton_enviar_inicio;
    }

    public void setBoton_enviar_inicio(Boton boton_enviar_inicio) {
        this.boton_enviar_inicio = boton_enviar_inicio;
    }

    public Input_password getContrasenia_registro() {
        return contrasenia_registro;
    }

    public void setContrasenia_registro(Input_password contrasenia_registro) {
        this.contrasenia_registro = contrasenia_registro;
    }

    public Input_password getRepetir_contrasenia_registro() {
        return repetir_contrasenia_registro;
    }

    public void setRepetir_contrasenia_registro(Input_password repetir_contrasenia_registro) {
        this.repetir_contrasenia_registro = repetir_contrasenia_registro;
    }

    public Boton getBoton_enviar_registro() {
        return boton_enviar_registro;
    }

    public void setBoton_enviar_registro(Boton boton_enviar_registro) {
        this.boton_enviar_registro = boton_enviar_registro;
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
