/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Tarea_controlador;
import com.mycompany.tareapp.modelo.idioma.Pagina_tareas;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import static javax.swing.SwingConstants.CENTER;

/**
 * Clase para las tareas que del panel de las tareas de la página de tareas
 * Componente creado para poder crear muchas tareas con el mismo formato
 * 
 * @author Francisco
 */
public final class Tarea_plantilla extends JPanel {

    Tarea_controlador tarea_controlador = new Tarea_controlador();
    JButton botonTareaCompletada = new JButton();
    
    JLabel tituloTarea = new JLabel("Título tarea");
    
    JLabel labelPrioridad = new JLabel(new ImageIcon(getClass().getResource("/imagenes/circle-arrow-down-solid.png")));
    
    JLabel fechaTarea = new JLabel("05/01/2025");
    
    int idTarea;
    int prioridadTarea;
    int completada;
    String descripcionTarea;
    
    JButton botonVerTarea = new JButton();
    JButton botonEditarTarea = new JButton();
    JButton botonBorrarTarea = new JButton();
    
    /**
    * Constructor de la tarea, con los estilos necesarios
    * 
    */
    public Tarea_plantilla() {
        
        generarEstructura();
    }
    
    /**
    * Constructor de la tarea con todos los datos de la tarea, con los estilos necesarios
    * Para poder crearla con sus opciones marcadas
    * 
    */
    public Tarea_plantilla(int idTarea, int completada, String titulo, int prioridad, String fecha, String descripcion, int idLista) { // Si se envía true está completa, si se envía en la prioridad 1 - baja, 2 - media, 3 - alta
        
        this.idTarea = idTarea;
        this.completada = completada;
        
        generarEstructura();
        
        if(completada == 1) {
            
            this.setTareaCompletada();
        
        } else {
            
            this.setTareaIncompleta();
        }
        
        this.setTituloTarea(titulo);
        
        
        this.setPrioridadTarea(prioridad);
        
        switch(prioridad) {
            case 2 -> this.setPrioridadMedia();    
            case 3 -> this.setPrioridadAlta();
            default -> this.setPrioridadBaja();
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
        
        botonTareaCompletada.setIcon(new ImageIcon(getClass().getResource("/imagenes/square-check-solid-black.png")));
    }
    
    public void setTareaIncompleta() {
        
        botonTareaCompletada.setIcon(new ImageIcon(getClass().getResource("/imagenes/square-regular-black.png")));
    }
    
    public void setPrioridadBaja() {
        
        this.getLabelPrioridad().setIcon(new ImageIcon(getClass().getResource("/imagenes/circle-arrow-down-solid.png")));
    }
    
    public void setPrioridadMedia() {
        
        this.getLabelPrioridad().setIcon(new ImageIcon(getClass().getResource("/imagenes/circle-arrow-right-solid.png")));
    }
    
    public void setPrioridadAlta() {
        
        this.getLabelPrioridad().setIcon(new ImageIcon(getClass().getResource("/imagenes/circle-arrow-up-solid.png")));
    }

    public int getPrioridadTarea() {
        return prioridadTarea;
    }

    public void setPrioridadTarea(int prioridadTarea) {
        this.prioridadTarea = prioridadTarea;
    }
    
    public String getDescripcionTarea() {
        return descripcionTarea;
    }

    public void setDescripcionTarea(String descripcionTarea) {
        this.descripcionTarea = descripcionTarea;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }
    
    /**
    * Función para poder generar la estructura de las tareas con sus estilos
    * 
    */
    public void generarEstructura() {
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(800, 50));
        this.setOpaque(true);
        this.setBackground(Estilos.getGris_claro());
        this.setVisible(true);
        
        Separador separador1 = new Separador();
        this.add(separador1);
        layout.putConstraint(SpringLayout.WEST, separador1, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, separador1, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador1, 0, SpringLayout.SOUTH, this);
        
        this.add(botonTareaCompletada);
        botonTareaCompletada.setPreferredSize(new Dimension(30, 30));
        botonTareaCompletada.setIcon(new ImageIcon(getClass().getResource("/imagenes/square-check-solid-black.png")));
        botonTareaCompletada.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, botonTareaCompletada, 15, SpringLayout.WEST, separador1);
        layout.putConstraint(SpringLayout.NORTH, botonTareaCompletada, 10, SpringLayout.NORTH, separador1);
                
        Separador separador2 = new Separador();
        this.add(separador2);
        layout.putConstraint(SpringLayout.WEST, separador2, 45, SpringLayout.WEST, botonTareaCompletada);
        layout.putConstraint(SpringLayout.NORTH, separador2, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador2, 0, SpringLayout.SOUTH, this);

        this.add(tituloTarea);
        tituloTarea.setFont(Estilos.getFuente());
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
        fechaTarea.setHorizontalAlignment(CENTER);
        fechaTarea.setFont(Estilos.getFuente());
        fechaTarea.setPreferredSize(new Dimension(85, 50));
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
        botonVerTarea.setIcon(new ImageIcon(getClass().getResource("/imagenes/eye-solid.png")));
        botonVerTarea.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, botonVerTarea, 10, SpringLayout.WEST, separador5);
        layout.putConstraint(SpringLayout.NORTH, botonVerTarea, 5, SpringLayout.NORTH, separador5);
        
        this.add(botonEditarTarea);
        botonEditarTarea.setPreferredSize(new Dimension(30, 30));
        botonEditarTarea.setIcon(new ImageIcon(getClass().getResource("/imagenes/pen-to-square-solid.png")));
        botonEditarTarea.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, botonEditarTarea, 50, SpringLayout.WEST, botonVerTarea);
        layout.putConstraint(SpringLayout.NORTH, botonEditarTarea, 0, SpringLayout.NORTH, botonVerTarea);
        
        this.add(botonBorrarTarea);
        botonBorrarTarea.setPreferredSize(new Dimension(30, 30));
        botonBorrarTarea.setIcon(new ImageIcon(getClass().getResource("/imagenes/trash-can-solid.png")));
        botonBorrarTarea.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, botonBorrarTarea, 50, SpringLayout.WEST, botonEditarTarea);
        layout.putConstraint(SpringLayout.NORTH, botonBorrarTarea, 0, SpringLayout.NORTH, botonEditarTarea);
        
        Separador separador6 = new Separador();
        this.add(separador6);
        layout.putConstraint(SpringLayout.EAST, separador6, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, separador6, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador6, 0, SpringLayout.SOUTH, this);
        

        Pagina_tareas idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();        
        
        botonTareaCompletada.setToolTipText(idioma_seleccionado.getMarcar_completa_incompleta());
        botonVerTarea.setToolTipText(idioma_seleccionado.getVer_tarea());
        botonEditarTarea.setToolTipText(idioma_seleccionado.getEditar_tarea());
        botonBorrarTarea.setToolTipText(idioma_seleccionado.getBorrar_tarea());
        
        
        botonTareaCompletada.addActionListener((ActionEvent e) -> {
            
            if (completada == 1) {
                
                if (tarea_controlador.completarTarea(idTarea, 0)) {
                
                    this.setTareaIncompleta();
                    completada = 0;
                }
                
                
            } else {
                
                if (tarea_controlador.completarTarea(idTarea, 1)) {
                
                    this.setTareaCompletada();
                    completada = 1;
                }
            }
        });
        
        botonVerTarea.addActionListener((ActionEvent e) -> {
            
            Popup_ver_borrar_tarea popup_ver_borrar_tarea = new Popup_ver_borrar_tarea(Tarea_plantilla.this, "ver");
            popup_ver_borrar_tarea.setVisible(true);
        });
        
        botonEditarTarea.addActionListener((ActionEvent e) -> {
            
            Popup_crear_editar_tarea popup_crear_editar_tarea = new Popup_crear_editar_tarea(Tarea_plantilla.this);
            popup_crear_editar_tarea.setVisible(true);
        });
        
        botonBorrarTarea.addActionListener((ActionEvent e) -> {
            
            Popup_ver_borrar_tarea popup_ver_borrar_tarea = new Popup_ver_borrar_tarea(Tarea_plantilla.this, "borrar");
            popup_ver_borrar_tarea.setVisible(true);
        });
        
    }
    
    /**
    * Función que permite ver la prioridad de la tarea
    * 
    * @return Devuelve el texto de la prioridad seleccionada e el idioma seleccionado
    */
    public String recoger_prioridad_tarea() {
        
        Pagina_tareas idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();
        
        return switch (prioridadTarea) {
            case 2 -> idioma_seleccionado.getMedia();
            case 3 -> idioma_seleccionado.getAlta();
            default -> idioma_seleccionado.getBaja();
        };
    }
}
