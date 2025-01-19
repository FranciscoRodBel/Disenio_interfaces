/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Tarea_controlador;
import com.mycompany.tareapp.modelo.idioma.Pagina_tareas;
import com.mycompany.tareapp.vista.Tareas_view;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.Timer;

/**
 *
 * @author Propietario
 */
public class Popup_ver_borrar_tarea extends JDialog {
    
    Tareas_view tareas_view = Tareas_view.recoger_instancia();
    Tarea_controlador tarea_controlador = new Tarea_controlador();
    JPanel panelPrincipal = new JPanel();
    
    String texto_titulo_tarea;
    String texto_fecha_tarea;
    String texto_prioridad_tarea;
    String texto_descripcion_tarea;
    
    JLabel label_resultado = new JLabel();

    public Popup_ver_borrar_tarea(Tarea_plantilla tarea, String tipo_popup) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(800, 450));
        this.setLocationRelativeTo(null);
        
        texto_titulo_tarea = tarea.getTituloTarea().getText();
        texto_fecha_tarea = tarea.getFechaTarea().getText(); 
        texto_prioridad_tarea = tarea.recoger_prioridad_tarea();
        texto_descripcion_tarea = tarea.getDescripcionTarea();
            
        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 450);
        panelPrincipal.setBackground(Estilos.getBlanco_claro());
        
        Pagina_tareas idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();
        
        JLabel label_titulo_tarea = new JLabel(texto_titulo_tarea, SwingConstants.CENTER);
        label_titulo_tarea.setFont(Estilos.getFuenteConTamaio(20));
        layout.putConstraint(SpringLayout.WEST, label_titulo_tarea, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_titulo_tarea, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, label_titulo_tarea, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_titulo_tarea);
        
        JLabel label_fecha = new JLabel(idioma_seleccionado.getFecha()+":", SwingConstants.RIGHT);
        label_fecha.setPreferredSize(new Dimension(100, 30));
        label_fecha.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, label_fecha, 20, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_fecha, 50, SpringLayout.NORTH, label_titulo_tarea);
        panelPrincipal.add(label_fecha);
        
        JLabel label_fecha_tarea = new JLabel(texto_fecha_tarea, SwingConstants.LEFT);
        label_fecha_tarea.setPreferredSize(new Dimension(150, 30));
        label_fecha_tarea.setFont(Estilos.getFuenteConTamaio(20));
        layout.putConstraint(SpringLayout.WEST, label_fecha_tarea, 110, SpringLayout.WEST, label_fecha);
        layout.putConstraint(SpringLayout.NORTH, label_fecha_tarea, 0, SpringLayout.NORTH, label_fecha);
        panelPrincipal.add(label_fecha_tarea);

        JLabel label_prioridad_tarea = new JLabel(texto_prioridad_tarea, SwingConstants.LEFT);
        label_prioridad_tarea.setPreferredSize(new Dimension(100, 30));
        label_prioridad_tarea.setFont(Estilos.getFuenteConTamaio(20));
        layout.putConstraint(SpringLayout.EAST, label_prioridad_tarea, -20, SpringLayout.EAST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_prioridad_tarea, 0, SpringLayout.NORTH, label_fecha_tarea);
        panelPrincipal.add(label_prioridad_tarea);
        
        JLabel label_prioridad = new JLabel(idioma_seleccionado.getPrioridad()+":", SwingConstants.RIGHT);
        label_prioridad.setPreferredSize(new Dimension(150, 30));
        label_prioridad.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.EAST, label_prioridad, -110, SpringLayout.EAST, label_prioridad_tarea);
        layout.putConstraint(SpringLayout.NORTH, label_prioridad, 0, SpringLayout.NORTH, label_prioridad_tarea);
        panelPrincipal.add(label_prioridad);
        
        JLabel label_descripcion = new JLabel(idioma_seleccionado.getDescripcion(), SwingConstants.CENTER);
        label_descripcion.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, label_descripcion, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_descripcion, 50, SpringLayout.NORTH, label_prioridad);
        layout.putConstraint(SpringLayout.EAST, label_descripcion, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_descripcion);
        
        // Falta arreglar el formato en el que se muestra el texto
        Text_area_descripcion panel_descripcion_tarea = new Text_area_descripcion(texto_descripcion_tarea);
        panel_descripcion_tarea.cambiarFormatoVer();
        layout.putConstraint(SpringLayout.WEST, panel_descripcion_tarea, 50, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, panel_descripcion_tarea, 50, SpringLayout.NORTH, label_descripcion);
        panelPrincipal.add(panel_descripcion_tarea);
        
        if (tipo_popup.equals("borrar")) {
        
            this.setSize(new Dimension(800, 570));
            panelPrincipal.setBounds(0, 0, 800, 570);
            
            JLabel label_borrar_tarea = new JLabel(idioma_seleccionado.getPregunta_borrar_tarea(), SwingConstants.CENTER);
            label_borrar_tarea.setFont(Estilos.getFuenteTitulo());
            layout.putConstraint(SpringLayout.WEST, label_borrar_tarea, 0, SpringLayout.WEST, panelPrincipal);
            layout.putConstraint(SpringLayout.NORTH, label_borrar_tarea, 20, SpringLayout.NORTH, panelPrincipal);
            layout.putConstraint(SpringLayout.EAST, label_borrar_tarea, 0, SpringLayout.EAST, panelPrincipal);
            panelPrincipal.add(label_borrar_tarea);
            
            layout.putConstraint(SpringLayout.NORTH, label_titulo_tarea, 50, SpringLayout.NORTH, label_borrar_tarea);
            
            Boton bonton_borrar = new Boton(idioma_seleccionado.getBorrar_tarea());
            bonton_borrar.setBackground(Estilos.getRojo());
            layout.putConstraint(SpringLayout.WEST, bonton_borrar, 300, SpringLayout.WEST, panelPrincipal);
            layout.putConstraint(SpringLayout.NORTH, bonton_borrar, 230, SpringLayout.NORTH, panel_descripcion_tarea);
            panelPrincipal.add(bonton_borrar);
            
            label_resultado.setHorizontalAlignment(CENTER);
            label_resultado.setFont(Estilos.getFuenteConTamaio(14));
            layout.putConstraint(SpringLayout.WEST, label_resultado, 0, SpringLayout.WEST, panelPrincipal);
            layout.putConstraint(SpringLayout.NORTH, label_resultado, 45, SpringLayout.NORTH, bonton_borrar);
            layout.putConstraint(SpringLayout.EAST, label_resultado, 0, SpringLayout.EAST, panelPrincipal);
            panelPrincipal.add(label_resultado);
            
            bonton_borrar.addActionListener((ActionEvent e) -> {

                String mensaje_resultado = tarea_controlador.borrar_tarea(tarea.getIdTarea());

                if (mensaje_resultado.isEmpty()) {

                    mensaje_resultado = "Tarea borrada";
                    tareas_view.actualizar_panel_tareas();
                } 

                label_resultado.setText(mensaje_resultado);
                Timer tiempo_espera = new Timer(3000, evt -> label_resultado.setText(""));
                tiempo_espera.setRepeats(false);
                tiempo_espera.start();
            });
        }
    }
}
