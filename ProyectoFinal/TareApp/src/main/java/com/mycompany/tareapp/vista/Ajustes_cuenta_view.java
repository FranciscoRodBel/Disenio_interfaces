/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.controlador.Usuario_controlador;
import com.mycompany.tareapp.vista.plantillas.Boton;
import com.mycompany.tareapp.vista.plantillas.Estilos;
import com.mycompany.tareapp.vista.plantillas.Popup_borrar_cuenta_lista;
import com.mycompany.tareapp.vista.plantillas.Popup_cambiar_email_contrasenia;
import com.mycompany.tareapp.vista.plantillas.RoundedBorder;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 * Clase para la vista de la página de ajustes
 * En esta clase el usuario puede editar o borrar su usuario
 * 
 * @author Francisco
 */
public class Ajustes_cuenta_view extends javax.swing.JPanel {

    static Ajustes_cuenta_view ajustes_cuenta_view;
    
    JLabel titulo_pagina = new JLabel("Ajustes de la cuenta");
    
    JPanel panel_ajustes = new JPanel();
    
    JLabel label_email = new JLabel("Email:");
    JLabel label_email_usuario = new JLabel(Usuario_controlador.getUsuario().getEmail());
    
    Boton boton_cambiar_email = new Boton("Cambiar email", "amarillo");
    Boton boton_cambiar_contrasenia = new Boton("Cambiar contraseña", "amarillo");
    Boton boton_borrar_cuenta = new Boton("Borrar cuenta", "rojo");
    
 
    /**
    * Constructor de los ajustes de la cuenta, crea toda la interfaz de la página
    * 
    */
    public Ajustes_cuenta_view() {
        initComponents();
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(1000, 555));
        this.setMaximumSize(new Dimension(1000, 555));
        this.setBackground(Estilos.getGris_claro());
        
        this.add(titulo_pagina);
        titulo_pagina.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_pagina.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, titulo_pagina, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, titulo_pagina, 20, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, titulo_pagina, 0, SpringLayout.EAST, this);
        
        this.add(panel_ajustes);
        SpringLayout layout2 = new SpringLayout();
        panel_ajustes.setLayout(layout2);
        panel_ajustes.setBackground(Estilos.getBlanco_claro());
        panel_ajustes.setBorder(new RoundedBorder(2, 2));
        panel_ajustes.setPreferredSize(new Dimension(500, 260));
        layout.putConstraint(SpringLayout.WEST, panel_ajustes, 250, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, panel_ajustes, 50, SpringLayout.NORTH, titulo_pagina);
        
        panel_ajustes.add(label_email);
        label_email.setFont(Estilos.getFuenteTitulo());
        layout2.putConstraint(SpringLayout.WEST, label_email, 20, SpringLayout.WEST, panel_ajustes);
        layout2.putConstraint(SpringLayout.NORTH, label_email, 20, SpringLayout.NORTH, panel_ajustes);
        
        panel_ajustes.add(label_email_usuario);
        label_email_usuario.setFont(Estilos.getFuenteConTamaio(18));
        layout2.putConstraint(SpringLayout.WEST, label_email_usuario, 75, SpringLayout.WEST, label_email);
        layout2.putConstraint(SpringLayout.NORTH, label_email_usuario, 0, SpringLayout.NORTH, label_email);
        
        panel_ajustes.add(boton_cambiar_email);
        layout2.putConstraint(SpringLayout.WEST, boton_cambiar_email, 150, SpringLayout.WEST, panel_ajustes);
        layout2.putConstraint(SpringLayout.NORTH, boton_cambiar_email, 50, SpringLayout.NORTH, label_email);
        
        panel_ajustes.add(boton_cambiar_contrasenia);
        layout2.putConstraint(SpringLayout.WEST, boton_cambiar_contrasenia, 150, SpringLayout.WEST, panel_ajustes);
        layout2.putConstraint(SpringLayout.NORTH, boton_cambiar_contrasenia, 60, SpringLayout.NORTH, boton_cambiar_email);
        
        panel_ajustes.add(boton_borrar_cuenta);
        boton_borrar_cuenta.setBackground(Estilos.getRojo());
        boton_borrar_cuenta.setPreferredSize(new Dimension(150, 35));
        layout2.putConstraint(SpringLayout.WEST, boton_borrar_cuenta, 175, SpringLayout.WEST, panel_ajustes);
        layout2.putConstraint(SpringLayout.NORTH, boton_borrar_cuenta, 60, SpringLayout.NORTH, boton_cambiar_contrasenia);
        
        boton_cambiar_email.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                Popup_cambiar_email_contrasenia popup_cambiar_email_contrasenia = new Popup_cambiar_email_contrasenia("email");
                popup_cambiar_email_contrasenia.setVisible(true);
            }
        });
                
        boton_cambiar_contrasenia.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                Popup_cambiar_email_contrasenia popup_cambiar_email_contrasenia = new Popup_cambiar_email_contrasenia("contrasenia");
                popup_cambiar_email_contrasenia.setVisible(true);
            }
        });
        
        boton_borrar_cuenta.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                Popup_borrar_cuenta_lista popup_borrar_cuenta_lista = new Popup_borrar_cuenta_lista(0, label_email_usuario.getText() ,"cuenta");
                popup_borrar_cuenta_lista.setVisible(true);
            }
        });
    }
    
    public JLabel getTitulo_pagina() {
        return titulo_pagina;
    }

    public void setTitulo_pagina(JLabel titulo_pagina) {
        this.titulo_pagina = titulo_pagina;
    }

    public Boton getBoton_cambiar_email() {
        return boton_cambiar_email;
    }

    public void setBoton_cambiar_email(Boton boton_cambiar_email) {
        this.boton_cambiar_email = boton_cambiar_email;
    }

    public Boton getBoton_cambiar_contrasenia() {
        return boton_cambiar_contrasenia;
    }

    public void setBoton_cambiar_contrasenia(Boton boton_cambiar_contrasenia) {
        this.boton_cambiar_contrasenia = boton_cambiar_contrasenia;
    }

    public Boton getBoton_borrar_cuenta() {
        return boton_borrar_cuenta;
    }

    public void setBoton_borrar_cuenta(Boton boton_borrar_cuenta) {
        this.boton_borrar_cuenta = boton_borrar_cuenta;
    }

    public JLabel getLabel_email_usuario() {
        return label_email_usuario;
    }

    public void setLabel_email_usuario(JLabel label_email_usuario) {
        this.label_email_usuario = label_email_usuario;
    }
    
    /**
    * Función que permite recoger la clase como si fuese estática
    * 
    * @return Devuelve un objeto de la propia clase
    */
    public static Ajustes_cuenta_view recoger_instancia() {
        
        if (ajustes_cuenta_view == null) {
            
            ajustes_cuenta_view = new Ajustes_cuenta_view();
        }
        
        return ajustes_cuenta_view;
    }
    
    /**
    * Método que permite poner la clase a null, para cuando se cierra sesión o se borra el usuario
    *
    */
    public static void reiniciar_instancia() {
        Ajustes_cuenta_view.ajustes_cuenta_view = null;
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
