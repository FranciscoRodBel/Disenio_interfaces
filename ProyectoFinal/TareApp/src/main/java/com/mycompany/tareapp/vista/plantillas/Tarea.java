/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author Propietario
 */
public class Tarea extends JPanel {

    Estilos estilos = new Estilos();
    
    JButton botonTareaCompletada = new JButton();
    
    JLabel tituloTarea = new JLabel("Título tarea");
    
    JLabel labelPrioridad = new JLabel(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-arrow-down-solid.png"));
    
    JLabel fechaTarea = new JLabel("05/01/2025");
    
    String prioridadTarea;
    String descripcionTarea;
    
    JButton botonVerTarea = new JButton();
    JButton botonEditarTarea = new JButton();
    JButton botonBorrarTarea = new JButton();
    
    public Tarea() {
        
        generarEstructura();
    }
    
    public Tarea(Boolean completada, String titulo, int prioridad, String fecha, String descripcion) { // Si se envía true está completa, si se envía en la prioridad 1 - baja, 2 - media, 3 - alta
        
        generarEstructura();
        
        if(completada) {
            
            this.setTareaCompletada();
        
        } else {
            
            this.setTareaIncompleta();
        }
        
        this.setTituloTarea(titulo);
        
        switch(prioridad) {
            case 2:
                this.setPrioridadMedia();
                prioridadTarea = "Media";
                break;    
              
            case 3:
                this.setPrioridadAlta();
                prioridadTarea = "Alta";
                break;
              
            default:
                this.setPrioridadBaja();
                prioridadTarea = "Baja";
        }
        
        this.setFechaTarea(fecha);
        
        this.setDescripcionTarea(descripcion);
    }

    public JButton getBotonTareaCompletada() {
        return botonTareaCompletada;
    }

    public void setBotonTareaCompletada(JButton botonTareaCompletada) {
        this.botonTareaCompletada = botonTareaCompletada;
    }

    public JLabel getLabelPrioridad() {
        return labelPrioridad;
    }

    public void setLabelPrioridad(JLabel labelPrioridad) {
        this.labelPrioridad = labelPrioridad;
    }
    
    public JLabel getTituloTarea() {
        return tituloTarea;
    }

    public void setTituloTarea(String tituloTarea) {
        
        this.getTituloTarea().setText(tituloTarea);
    }

    public JLabel getFechaTarea() {
        return fechaTarea;
    }

    public void setFechaTarea(String fechaTarea) {
        
        this.getFechaTarea().setText(fechaTarea);
    }
    
    public void setTareaCompletada() {
        
        botonTareaCompletada.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/square-check-solid-black.png"));
    }
    
    public void setTareaIncompleta() {
        
        botonTareaCompletada.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/square-regular-black.png"));
    }
    
    public void setPrioridadBaja() {
        
        this.getLabelPrioridad().setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-arrow-down-solid.png"));
    }
    
    public void setPrioridadMedia() {
        
        this.getLabelPrioridad().setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-arrow-right-solid.png"));
    }
    
    public void setPrioridadAlta() {
        
        this.getLabelPrioridad().setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-arrow-up-solid.png"));
    }
    
    public String getPrioridadTarea() {
        return prioridadTarea;
    }

    public void setPrioridadTarea(String prioridadTarea) {
        this.prioridadTarea = prioridadTarea;
    }
    
    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public void generarEstructura() {
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(800, 50));
        this.setOpaque(true);
        this.setBackground(estilos.getGris_claro());
        this.setVisible(true);
        
        Separador separador1 = new Separador();
        this.add(separador1);
        layout.putConstraint(SpringLayout.WEST, separador1, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, separador1, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador1, 0, SpringLayout.SOUTH, this);
        
        this.add(botonTareaCompletada);
        botonTareaCompletada.setPreferredSize(new Dimension(30, 30));
        botonTareaCompletada.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/square-check-solid-black.png"));
        botonTareaCompletada.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, botonTareaCompletada, 15, SpringLayout.WEST, separador1);
        layout.putConstraint(SpringLayout.NORTH, botonTareaCompletada, 10, SpringLayout.NORTH, separador1);
                
        Separador separador2 = new Separador();
        this.add(separador2);
        layout.putConstraint(SpringLayout.WEST, separador2, 45, SpringLayout.WEST, botonTareaCompletada);
        layout.putConstraint(SpringLayout.NORTH, separador2, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador2, 0, SpringLayout.SOUTH, this);

        this.add(tituloTarea);
        tituloTarea.setFont(estilos.getFuente());
        tituloTarea.setPreferredSize(new Dimension(400, 50));
        layout.putConstraint(SpringLayout.WEST, tituloTarea, 10, SpringLayout.WEST, separador2);
        layout.putConstraint(SpringLayout.NORTH, tituloTarea, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, tituloTarea, 0, SpringLayout.SOUTH, this);
        
        Separador separador3 = new Separador();
        this.add(separador3);
        layout.putConstraint(SpringLayout.WEST, separador3, 410, SpringLayout.WEST, tituloTarea);
        layout.putConstraint(SpringLayout.NORTH, separador3, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador3, 0, SpringLayout.SOUTH, this);
        
        this.add(labelPrioridad);
        labelPrioridad.setPreferredSize(new Dimension(40, 40));
        layout.putConstraint(SpringLayout.WEST, labelPrioridad, 15, SpringLayout.WEST, separador3);
        layout.putConstraint(SpringLayout.NORTH, labelPrioridad, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, labelPrioridad, 0, SpringLayout.SOUTH, this);
        
        Separador separador4 = new Separador();
        this.add(separador4);
        layout.putConstraint(SpringLayout.WEST, separador4, 55, SpringLayout.WEST, labelPrioridad);
        layout.putConstraint(SpringLayout.NORTH, separador4, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador4, 0, SpringLayout.SOUTH, this);
        
        this.add(fechaTarea);
        fechaTarea.setFont(estilos.getFuente());
        fechaTarea.setPreferredSize(new Dimension(100, 50));
        layout.putConstraint(SpringLayout.WEST, fechaTarea, 80, SpringLayout.WEST, separador3);
        layout.putConstraint(SpringLayout.NORTH, fechaTarea, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, fechaTarea, 0, SpringLayout.SOUTH, this);
        
        Separador separador5 = new Separador();
        this.add(separador5);
        layout.putConstraint(SpringLayout.WEST, separador5, 90, SpringLayout.WEST, fechaTarea);
        layout.putConstraint(SpringLayout.NORTH, separador5, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador5, 0, SpringLayout.SOUTH, this);
        
        this.add(botonVerTarea);
        botonVerTarea.setPreferredSize(new Dimension(30, 30));
        botonVerTarea.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/eye-solid.png"));
        botonVerTarea.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, botonVerTarea, 10, SpringLayout.WEST, separador5);
        layout.putConstraint(SpringLayout.NORTH, botonVerTarea, 5, SpringLayout.NORTH, separador5);
        
        this.add(botonEditarTarea);
        botonEditarTarea.setPreferredSize(new Dimension(30, 30));
        botonEditarTarea.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/pen-to-square-solid.png"));
        botonEditarTarea.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, botonEditarTarea, 50, SpringLayout.WEST, botonVerTarea);
        layout.putConstraint(SpringLayout.NORTH, botonEditarTarea, 0, SpringLayout.NORTH, botonVerTarea);
        
        this.add(botonBorrarTarea);
        botonBorrarTarea.setPreferredSize(new Dimension(30, 30));
        botonBorrarTarea.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/trash-can-solid.png"));
        botonBorrarTarea.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, botonBorrarTarea, 50, SpringLayout.WEST, botonEditarTarea);
        layout.putConstraint(SpringLayout.NORTH, botonBorrarTarea, 0, SpringLayout.NORTH, botonEditarTarea);
        
        Separador separador6 = new Separador();
        this.add(separador6);
        layout.putConstraint(SpringLayout.EAST, separador6, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, separador6, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador6, 0, SpringLayout.SOUTH, this);
                
        botonTareaCompletada.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                if (botonTareaCompletada.getIcon().toString().equals("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/square-regular-black.png")) {
                      
                    botonTareaCompletada.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/square-check-solid-black.png"));

                } else {
                
                    botonTareaCompletada.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/square-regular-black.png"));
                }
            }
        });
        
        botonEditarTarea.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                Popup_crear_editar_tarea popup_crear_editar_tarea = new Popup_crear_editar_tarea(Tarea.this);
                popup_crear_editar_tarea.setVisible(true);
            }
        });
    }
}
