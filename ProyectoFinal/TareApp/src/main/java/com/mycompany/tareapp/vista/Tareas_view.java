/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.vista.plantillas.Estilos;
import com.mycompany.tareapp.vista.plantillas.Tarea;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author Propietario
 */
public class Tareas_view extends javax.swing.JPanel {

    Estilos estilos = new Estilos();
    
    JToolBar barraHerramientas = new JToolBar();
    
    JButton botonCrearTarea = new JButton();
    JButton botonTareasCompletadas = new JButton();
    JButton botonTareasIncompletas = new JButton();
    JButton botonPrioridadBaja = new JButton();
    JButton botonPrioridadMedia = new JButton();
    JButton botonPrioridadalta = new JButton();
    JButton botonOrdenadoAZ = new JButton();
    JButton botonOrdenadoZA = new JButton();
    JButton botonOrdenado19 = new JButton();
    JButton botonOrdenado91 = new JButton();
    
    JLabel tituloPagina = new JLabel("Tareas");
    JComboBox<String> seleccionarLista = new JComboBox();
    
    JPanel panelTareas = new JPanel();
    JScrollPane scroll_panelTareas = new JScrollPane(panelTareas);
    
    /**
     * Creates new form Tareas_view2
     */
    public Tareas_view() {
        initComponents();
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(1000, 555));
        this.setMaximumSize(new Dimension(1000, 555));
        this.setBackground(estilos.getGris_claro());
        
        barraHerramientas.setBackground(estilos.getAzul_oscuro());
        barraHerramientas.setFloatable(false);
        this.add(barraHerramientas);
        layout.putConstraint(SpringLayout.WEST, barraHerramientas, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, barraHerramientas, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, barraHerramientas, 0, SpringLayout.EAST, this);
        
        botonCrearTarea.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/plus-solid.png"));
        botonTareasCompletadas.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/square-check-solid.png"));
        botonTareasIncompletas.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/square-regular.png"));
        botonPrioridadBaja.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-arrow-down-solid.png"));
        botonPrioridadMedia.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-arrow-right-solid.png"));
        botonPrioridadalta.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-arrow-up-solid.png"));
        botonOrdenadoAZ.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/arrow-down-a-z-solid.png"));
        botonOrdenadoZA.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/arrow-down-z-a-solid.png"));
        botonOrdenado19.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/arrow-down-1-9-solid.png"));
        botonOrdenado91.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/arrow-down-9-1-solid.png"));
        
        barraHerramientas.add(botonCrearTarea);
        barraHerramientas.add(new JToolBar.Separator());
        barraHerramientas.add(botonTareasCompletadas);
        barraHerramientas.add(botonTareasIncompletas);
        barraHerramientas.add(new JToolBar.Separator());
        barraHerramientas.add(botonPrioridadBaja);
        barraHerramientas.add(botonPrioridadMedia);
        barraHerramientas.add(botonPrioridadalta);
        barraHerramientas.add(new JToolBar.Separator());
        barraHerramientas.add(botonOrdenadoAZ);
        barraHerramientas.add(botonOrdenadoZA);
        barraHerramientas.add(botonOrdenado19);
        barraHerramientas.add(botonOrdenado91);
        
        this.add(tituloPagina);
        tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPagina.setFont(estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, tituloPagina, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, tituloPagina, 70, SpringLayout.NORTH, barraHerramientas);
        layout.putConstraint(SpringLayout.EAST, tituloPagina, 0, SpringLayout.EAST, this);
        
        this.add(seleccionarLista);
        seleccionarLista.setPreferredSize(new Dimension(300, 40));
        seleccionarLista.setBackground(estilos.getBlanco_claro());
        seleccionarLista.setFont(estilos.getFuente());
        layout.putConstraint(SpringLayout.WEST, seleccionarLista, 350, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, seleccionarLista, 50, SpringLayout.NORTH, tituloPagina);
        seleccionarLista.addItem("Selecciona una lista");
        
        panelTareas.setLayout(new BoxLayout(panelTareas, BoxLayout.Y_AXIS)); // Para colocar una tarea debajo de otra
        panelTareas.setBackground(estilos.getGris_claro());
        
        scroll_panelTareas.setPreferredSize(new Dimension(815, 350));
        scroll_panelTareas.getVerticalScrollBar().setUnitIncrement(15); // Para aumentar la velocidad de la barra de scroll
        scroll_panelTareas.setBorder(null);
        this.add(scroll_panelTareas);
        layout.putConstraint(SpringLayout.WEST, scroll_panelTareas, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, scroll_panelTareas, 60, SpringLayout.NORTH, seleccionarLista);
        
        agregarTarea(new Tarea(false, "Tarea 1", 1, "05/01/2025"));
        agregarTarea(new Tarea(true, "Tarea 2", 2, "06/01/2025"));
        agregarTarea(new Tarea(false, "Tarea 3", 3, "07/01/2025"));
        agregarTarea(new Tarea(false, "Tarea 4", 1, "08/01/2025"));
        agregarTarea(new Tarea(true, "Tarea 5", 1, "09/01/2025"));
        
        botonCrearTarea.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                agregarTarea(new Tarea(false, "Tarea 6", 2, "18/01/2002"));
            }
        });
        
    }
    
    private void agregarTarea(Tarea tarea) {
        
        tarea.setMaximumSize(new Dimension(800, 50)); // Si no pongo el máximo se estíran las tareas para ocupar todo el panel
        tarea.setMinimumSize(new Dimension(800, 50)); // Si no pongo el mínimo ocupan la mitad del ancho del panel
        
        panelTareas.add(tarea);
        panelTareas.revalidate();
        panelTareas.repaint();
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
