/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.vista.plantillas.Estilos;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import com.mycompany.tareapp.modelo.RoundedBorder;
import com.mycompany.tareapp.vista.plantillas.Lista;
import com.mycompany.tareapp.vista.plantillas.Tarea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author Propietario
 */
public class Listas_view extends javax.swing.JPanel {

    Estilos estilos = new Estilos();
    
    JLabel titulo_pagina = new JLabel("Listas");

    JTextField input_titulo_lista = new JTextField();
    JButton boton_insertar_lista = new JButton();
    
    JPanel panel_lista = new JPanel();
    JScrollPane scroll_panel_lista = new JScrollPane(panel_lista);
    
    /**
     * Creates new form Listas_view
     */
    public Listas_view() {
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
        layout.putConstraint(SpringLayout.NORTH, titulo_pagina, 30, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, titulo_pagina, 0, SpringLayout.EAST, this);
        
        this.add(input_titulo_lista);
        input_titulo_lista.setPreferredSize(new Dimension(250, 35));
        input_titulo_lista.setFont(estilos.getFuente());
        input_titulo_lista.setBorder(new RoundedBorder(5, 2));
        layout.putConstraint(SpringLayout.WEST, input_titulo_lista, 350, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, input_titulo_lista, 50, SpringLayout.NORTH, titulo_pagina);
        
        boton_insertar_lista.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-plus-solid.png"));
        this.add(boton_insertar_lista);
        boton_insertar_lista.setPreferredSize(new Dimension(40, 40));
        boton_insertar_lista.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, boton_insertar_lista, 620, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, boton_insertar_lista, 47, SpringLayout.NORTH, titulo_pagina);
        
        panel_lista.setLayout(new BoxLayout(panel_lista, BoxLayout.Y_AXIS)); // Para colocar una tarea debajo de otra
        panel_lista.setBackground(estilos.getGris_claro());
        
        scroll_panel_lista.setPreferredSize(new Dimension(615, 350));
        scroll_panel_lista.getVerticalScrollBar().setUnitIncrement(15); // Para aumentar la velocidad de la barra de scroll
        scroll_panel_lista.setBorder(null);
        this.add(scroll_panel_lista);
        layout.putConstraint(SpringLayout.WEST, scroll_panel_lista, 200, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, scroll_panel_lista, 60, SpringLayout.NORTH, input_titulo_lista);
        
        agregarLista(new Lista("Lista 1"));
        agregarLista(new Lista("Lista 2"));
        agregarLista(new Lista("Lista 3"));
        agregarLista(new Lista("Lista 4"));
        agregarLista(new Lista("mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm"));
        agregarLista(new Lista("Lista de prueba para el proyecto final de curso 2."));
        
        boton_insertar_lista.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                agregarLista(new Lista("Título ejemplo lista"));
            }
        });
        
    }

    public JLabel getTitulo_pagina() {
        return titulo_pagina;
    }

    public void setTitulo_pagina(JLabel titulo_pagina) {
        this.titulo_pagina = titulo_pagina;
    }
    
    private void agregarLista(Lista lista) {
        
        lista.setMaximumSize(new Dimension(600, 50)); // Si no pongo el máximo se estíran las tareas para ocupar todo el panel
        lista.setMinimumSize(new Dimension(600, 50)); // Si no pongo el mínimo ocupan la mitad del ancho del panel
        
        panel_lista.add(lista);
        panel_lista.revalidate();
        panel_lista.repaint();
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
