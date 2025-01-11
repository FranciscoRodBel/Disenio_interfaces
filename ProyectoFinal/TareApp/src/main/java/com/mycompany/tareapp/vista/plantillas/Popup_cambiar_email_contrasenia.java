/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Propietario
 */
public class Popup_crear_editar_tarea extends JDialog {
    
    Estilos estilos = new Estilos();
    JPanel panelPrincipal = new JPanel();
    
    String texto_titulo_popup;
    String texto_input_titulo;
    String texto_input_fecha;
    String texto_input_prioridad;
    String texto_input_descripcion;
    String texto_boton;

    public Popup_crear_editar_tarea(Tarea tarea) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(800, 500));
        this.setLocationRelativeTo(null);
        
        
        if (tarea == null) {
            
            texto_titulo_popup = "Crear tarea";
            texto_input_titulo = "";
            texto_input_fecha = "";
            texto_input_prioridad = "";
            texto_input_descripcion = "";
            texto_boton = "Crear";
            
        } else {
            
            texto_titulo_popup = "Editar tarea";
            texto_input_titulo = tarea.getTituloTarea().getText();
            texto_input_fecha = tarea.getFechaTarea().getText(); 
            texto_input_prioridad = tarea.getPrioridadTarea();
            texto_input_descripcion = tarea.getDescripcionTarea();
            texto_boton = "Editar";
            
        }
        
        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 500);
        panelPrincipal.setBackground(estilos.getGris_claro());
        
        JLabel labelTitulo = new JLabel(texto_titulo_popup, SwingConstants.CENTER);
        labelTitulo.setFont(estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, labelTitulo, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelTitulo, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, labelTitulo, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(labelTitulo);
        
        Input_text input_titulo_terea = new Input_text("Título Tarea", texto_input_titulo);
        layout.putConstraint(SpringLayout.WEST, input_titulo_terea, 270, SpringLayout.WEST, labelTitulo);
        layout.putConstraint(SpringLayout.NORTH, input_titulo_terea, 50, SpringLayout.NORTH, labelTitulo);
        panelPrincipal.add(input_titulo_terea);
                   
        Input_date input_fecha_terea = new Input_date(texto_input_fecha);
        layout.putConstraint(SpringLayout.WEST, input_fecha_terea, 120, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, input_fecha_terea, 50, SpringLayout.NORTH, input_titulo_terea);
        panelPrincipal.add(input_fecha_terea);
        
        Select_prioridad input_prioridad_tarea = new Select_prioridad(texto_input_prioridad);
        layout.putConstraint(SpringLayout.WEST, input_prioridad_tarea, 300, SpringLayout.WEST, input_fecha_terea);
        layout.putConstraint(SpringLayout.NORTH, input_prioridad_tarea, 0, SpringLayout.NORTH, input_fecha_terea);
        panelPrincipal.add(input_prioridad_tarea);
                
        Text_area_descripcion input_descripcion = new Text_area_descripcion(texto_input_descripcion);
        layout.putConstraint(SpringLayout.WEST, input_descripcion, 150, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, input_descripcion, 50, SpringLayout.NORTH, input_fecha_terea);
        panelPrincipal.add(input_descripcion);
        
        Boton bonton_crear = new Boton(texto_boton);
        layout.putConstraint(SpringLayout.WEST, bonton_crear, 300, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, bonton_crear, 230, SpringLayout.NORTH, input_descripcion);
        panelPrincipal.add(bonton_crear);
    }
}
