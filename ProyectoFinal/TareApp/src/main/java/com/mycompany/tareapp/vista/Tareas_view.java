/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.vista.plantillas.Estilos;
import com.mycompany.tareapp.vista.plantillas.Tarea;
import java.awt.Dimension;
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
    
    /**
     * Creates new form Tareas_view2
     */
    public Tareas_view() {
        initComponents();
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(1012, 600));
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
        
        
        Tarea tarea1 = new Tarea();
        tarea1.setTareaIncompleta();
        tarea1.setTituloTarea("MMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMMM");
        tarea1.setPrioridadBaja();
        tarea1.setFechaTarea("05/01/2025");
        this.add(tarea1);
        layout.putConstraint(SpringLayout.WEST, tarea1, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, tarea1, 70, SpringLayout.NORTH, seleccionarLista);
        
        Tarea tarea2 = new Tarea();
        tarea2.setTareaCompletada();
        tarea2.setTituloTarea("Tarea para la clase de matemáticas aplicadas 2º DAM");
        tarea2.setPrioridadMedia();
        tarea2.setFechaTarea("06/01/2025");
        this.add(tarea2);
        layout.putConstraint(SpringLayout.WEST, tarea2, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, tarea2, 50, SpringLayout.NORTH, tarea1);
        
        Tarea tarea3 = new Tarea();
        tarea3.setTareaCompletada();
        tarea3.setTituloTarea("Tercera tarea");
        tarea3.setPrioridadAlta();
        tarea3.setFechaTarea("07/01/2025");
        this.add(tarea3);
        layout.putConstraint(SpringLayout.WEST, tarea3, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, tarea3, 50, SpringLayout.NORTH, tarea2);
        
        Tarea tarea4 = new Tarea(true, "Título de tarea de prueba 1", 1, "18/01/2002");
        this.add(tarea4);
        layout.putConstraint(SpringLayout.WEST, tarea4, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, tarea4, 50, SpringLayout.NORTH, tarea3);
        
        /*
        Tarea tarea5 = new Tarea(false, "Título de tarea de prueba 2", 2, "19/01/2002");
        this.add(tarea5);
        layout.putConstraint(SpringLayout.WEST, tarea5, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, tarea5, 50, SpringLayout.NORTH, tarea4);
        
        Tarea tarea6 = new Tarea(true, "Título de tarea de prueba 3", 3, "20/01/2002");
        this.add(tarea6);
        layout.putConstraint(SpringLayout.WEST, tarea6, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, tarea6, 50, SpringLayout.NORTH, tarea5);
        
        Tarea tarea7 = new Tarea(true, "Título de tarea de prueba 4", 2, "21/01/2002");
        this.add(tarea7);
        layout.putConstraint(SpringLayout.WEST, tarea7, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, tarea7, 50, SpringLayout.NORTH, tarea6);
        
        Tarea tarea8 = new Tarea(false, "Título de tarea de prueba 5", 1, "22/01/2002");
        this.add(tarea8);
        layout.putConstraint(SpringLayout.WEST, tarea8, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, tarea8, 50, SpringLayout.NORTH, tarea7);
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
