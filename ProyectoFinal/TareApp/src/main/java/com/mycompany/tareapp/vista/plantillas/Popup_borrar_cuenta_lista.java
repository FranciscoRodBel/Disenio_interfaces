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
public class Popup_ver_borrar_tarea extends JDialog {
    
    Estilos estilos = new Estilos();
    JPanel panelPrincipal = new JPanel();
    
    String texto_titulo_tarea;
    String texto_fecha_tarea;
    String texto_prioridad_tarea;
    String texto_descripcion_tarea;

    public Popup_ver_borrar_tarea(Tarea tarea, String tipo_popup) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(800, 450));
        this.setLocationRelativeTo(null);
        
        texto_titulo_tarea = tarea.getTituloTarea().getText();
        texto_fecha_tarea = tarea.getFechaTarea().getText(); 
        texto_prioridad_tarea = tarea.getPrioridadTarea();
        texto_descripcion_tarea = tarea.getDescripcionTarea();
            
        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 450);
        panelPrincipal.setBackground(estilos.getBlanco_claro());
        
        JLabel label_titulo_tarea = new JLabel(texto_titulo_tarea, SwingConstants.CENTER);
        label_titulo_tarea.setFont(estilos.getFuenteConTamaio(20));
        layout.putConstraint(SpringLayout.WEST, label_titulo_tarea, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_titulo_tarea, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, label_titulo_tarea, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_titulo_tarea);
        
        JLabel label_fecha = new JLabel("Fecha: ", SwingConstants.RIGHT);
        label_fecha.setPreferredSize(new Dimension(100, 30));
        label_fecha.setFont(estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, label_fecha, 20, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_fecha, 60, SpringLayout.NORTH, panelPrincipal);
        panelPrincipal.add(label_fecha);
        
        JLabel label_fecha_tarea = new JLabel(texto_fecha_tarea, SwingConstants.LEFT);
        label_fecha_tarea.setPreferredSize(new Dimension(150, 30));
        label_fecha_tarea.setFont(estilos.getFuenteConTamaio(20));
        layout.putConstraint(SpringLayout.WEST, label_fecha_tarea, 110, SpringLayout.WEST, label_fecha);
        layout.putConstraint(SpringLayout.NORTH, label_fecha_tarea, 0, SpringLayout.NORTH, label_fecha);
        panelPrincipal.add(label_fecha_tarea);

        JLabel label_prioridad_tarea = new JLabel(texto_prioridad_tarea, SwingConstants.LEFT);
        label_prioridad_tarea.setPreferredSize(new Dimension(100, 30));
        label_prioridad_tarea.setFont(estilos.getFuenteConTamaio(20));
        layout.putConstraint(SpringLayout.EAST, label_prioridad_tarea, -20, SpringLayout.EAST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_prioridad_tarea, 60, SpringLayout.NORTH, panelPrincipal);
        panelPrincipal.add(label_prioridad_tarea);
        
        JLabel label_prioridad = new JLabel("Prioridad: ", SwingConstants.RIGHT);
        label_prioridad.setPreferredSize(new Dimension(150, 30));
        label_prioridad.setFont(estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.EAST, label_prioridad, -110, SpringLayout.EAST, label_prioridad_tarea);
        layout.putConstraint(SpringLayout.NORTH, label_prioridad, 0, SpringLayout.NORTH, label_prioridad_tarea);
        panelPrincipal.add(label_prioridad);
        
        JLabel label_descripcion = new JLabel("Descripción", SwingConstants.CENTER);
        label_descripcion.setFont(estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, label_descripcion, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_descripcion, 110, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, label_descripcion, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_descripcion);
        
        // Falta arreglar el formato en el que se muestra el texto
        Text_area_descripcion panel_descripcion_tarea = new Text_area_descripcion(texto_descripcion_tarea);
        panel_descripcion_tarea.cambiarFormatoVer();
        layout.putConstraint(SpringLayout.WEST, panel_descripcion_tarea, 50, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, panel_descripcion_tarea, 50, SpringLayout.NORTH, label_descripcion);
        panelPrincipal.add(panel_descripcion_tarea);
        
        if (tipo_popup.equals("borrar")) {
        
            this.setSize(new Dimension(800, 500));
            panelPrincipal.setBounds(0, 0, 800, 500);
            
            Boton bonton_borrar = new Boton("Borrar");
            bonton_borrar.setBackground(estilos.getRojo());
            layout.putConstraint(SpringLayout.WEST, bonton_borrar, 300, SpringLayout.WEST, panelPrincipal);
            layout.putConstraint(SpringLayout.NORTH, bonton_borrar, 230, SpringLayout.NORTH, panel_descripcion_tarea);
            panelPrincipal.add(bonton_borrar);
        }
    }
}
