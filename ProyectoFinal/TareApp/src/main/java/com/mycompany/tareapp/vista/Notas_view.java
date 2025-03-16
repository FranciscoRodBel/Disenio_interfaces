/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.controlador.Nota_controlador;
import com.mycompany.tareapp.vista.plantillas.Boton;
import com.mycompany.tareapp.vista.plantillas.Estilos;
import com.mycompany.tareapp.vista.plantillas.Nota_plantilla;
import com.mycompany.tareapp.vista.plantillas.Popup_crear_editar_nota;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 * Clase para la vista de la notas
 * En esta clase el usuario puede crear, ver editar y borrar notas
 * 
 * @author Francisco
 */
public final class Notas_view extends javax.swing.JPanel {
    
    static Notas_view notas_view;
    
    Boton botonCrearNota = new Boton("Crear nota", "amarillo");
    
    JLabel titulo_pagina = new JLabel("Notas");
    
    JPanel panelNotas = new JPanel();
    JScrollPane scroll_panel_notas = new JScrollPane(panelNotas);

    /**
    * Constructor de la página de notas, crea toda la interfaz de la página
    * 
    */
    public Notas_view() {
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
        layout.putConstraint(SpringLayout.NORTH, titulo_pagina, 30, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, titulo_pagina, 0, SpringLayout.EAST, this);
        
        this.add(botonCrearNota);
        layout.putConstraint(SpringLayout.WEST, botonCrearNota, 400, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, botonCrearNota, 50, SpringLayout.NORTH, titulo_pagina);
        
        panelNotas.setLayout(new java.awt.GridLayout(0, 3, 10, 10)); 
        panelNotas.setBackground(Estilos.getGris_claro());
        panelNotas.setVisible(true);
        
        scroll_panel_notas.setPreferredSize(new Dimension(915, 380));
        scroll_panel_notas.getVerticalScrollBar().setUnitIncrement(15); // Para aumentar la velocidad de la barra de scroll
        scroll_panel_notas.setBorder(null);
        scroll_panel_notas.setBackground(Estilos.getGris_claro());
        this.add(scroll_panel_notas);
        layout.putConstraint(SpringLayout.WEST, scroll_panel_notas, 50, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, scroll_panel_notas, 60, SpringLayout.NORTH, botonCrearNota);
        
        actualizar_panel_notas();

        botonCrearNota.addActionListener((ActionEvent e) -> {
                        
            Popup_crear_editar_nota popup_crear_editar_nota = new Popup_crear_editar_nota(null);
            popup_crear_editar_nota.setVisible(true);
        });
    }
    
    public JLabel getTitulo_pagina() {
        return titulo_pagina;
    }

    public void setTitulo_pagina(JLabel titulo_pagina) {
        this.titulo_pagina = titulo_pagina;
    }

    public JButton getBotonCrearTarea() {
        return botonCrearNota;
    }
    
    /**
    * Función que permite actualizar el panel donde se muestran todas las notas del usuario en la página de notas
    * 
    */
    public void actualizar_panel_notas() {
        
        panelNotas.setVisible(false); // Lo pongo en false para que luego al ponerlo true se actualice visualmente
        panelNotas.removeAll(); // Borro todas las notas
    
        ArrayList<HashMap<String, Object>> notas = Nota_controlador.recoger_Notas(); // Recojo las listas
        
        if (notas != null) { // Si hay notas...
            
            for(HashMap<String, Object> fila : notas) { // Las recorro y las añado al panel
        
                int idNota = (int) fila.get("idNota");
                String descripcion = (String) fila.get("descripcion");
                String color = (String) fila.get("color");

                Nota_plantilla nota_plantilla = new Nota_plantilla(idNota, descripcion, color);

                panelNotas.add(nota_plantilla);
            }
        }
        
        panelNotas.setVisible(true);
        panelNotas.revalidate();
        panelNotas.repaint();
    }

    /**
    * Función que permite recoger la clase como si fuese estática
    * 
    * @return Devuelve un objeto de la propia clase
    */
    public static Notas_view recoger_instancia() {
        
        if (notas_view == null) {
            
            notas_view = new Notas_view();
        }
        
        return notas_view;
    }
    
    /**
    * Método que permite poner la clase a null, para cuando se cierra sesión o se borra el usuario
    *
    */
    public static void reiniciar_instancia() {
        Notas_view.notas_view = null;
    }
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
