/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Lista_controlador;
import com.mycompany.tareapp.controlador.Tarea_controlador;
import com.mycompany.tareapp.modelo.idioma.Idioma;
import com.mycompany.tareapp.modelo.idioma.Pagina_tareas;
import com.mycompany.tareapp.vista.Tareas_view;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import static javax.swing.SwingConstants.CENTER;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

/**
 *
 * @author Propietario
 */
public class Popup_crear_editar_tarea extends JDialog {
    
    Tareas_view tareas_view = Tareas_view.recoger_instancia();
    Tarea_controlador tarea_controlador = new Tarea_controlador();
    Tarea_plantilla tarea;
    
    JPanel panelPrincipal = new JPanel();
    
    String texto_titulo_popup;
    String texto_input_titulo;
    String texto_input_fecha;
    int texto_input_prioridad;
    String texto_input_descripcion;
    String texto_boton;

    Boton bonton_crear_editar;
    Text_area_descripcion input_descripcion;
    Select_prioridad input_prioridad_tarea;
    Input_date input_fecha_terea;
    Input_text input_titulo_terea;
    JLabel label_resultado_tarea;
            
    public Popup_crear_editar_tarea(Tarea_plantilla tarea) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.tarea = tarea;
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(800, 520));
        this.setLocationRelativeTo(null);

        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 520);
        panelPrincipal.setBackground(Estilos.getGris_claro());
        
        Pagina_tareas idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();
        
        if (tarea == null) {
            
            texto_titulo_popup = idioma_seleccionado.getTitulo_tarea();
            texto_input_titulo = "";
            texto_input_fecha = "";
            texto_input_prioridad = 0;
            texto_input_descripcion = "";
            texto_boton = idioma_seleccionado.getCrear_tarea();
            
        } else {
            
            texto_titulo_popup = idioma_seleccionado.getEditar_tarea();
            texto_input_titulo = tarea.getTituloTarea().getText();
            texto_input_fecha = tarea.getFechaTarea().getText(); 
            texto_input_prioridad = tarea.getPrioridadTarea();
            texto_input_descripcion = tarea.getDescripcionTarea();
            texto_boton = idioma_seleccionado.getEditar_tarea();
        }
        
        JLabel labelTitulo = new JLabel(texto_titulo_popup, SwingConstants.CENTER);
        labelTitulo.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, labelTitulo, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelTitulo, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, labelTitulo, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(labelTitulo);
        
        input_titulo_terea = new Input_text(idioma_seleccionado.getTitulo_tarea(), texto_input_titulo);
        layout.putConstraint(SpringLayout.WEST, input_titulo_terea, 270, SpringLayout.WEST, labelTitulo);
        layout.putConstraint(SpringLayout.NORTH, input_titulo_terea, 50, SpringLayout.NORTH, labelTitulo);
        panelPrincipal.add(input_titulo_terea);
                   
        input_fecha_terea = new Input_date(texto_input_fecha);
        layout.putConstraint(SpringLayout.WEST, input_fecha_terea, 120, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, input_fecha_terea, 50, SpringLayout.NORTH, input_titulo_terea);
        panelPrincipal.add(input_fecha_terea);
        
        input_prioridad_tarea = new Select_prioridad(texto_input_prioridad);
        layout.putConstraint(SpringLayout.WEST, input_prioridad_tarea, 300, SpringLayout.WEST, input_fecha_terea);
        layout.putConstraint(SpringLayout.NORTH, input_prioridad_tarea, 0, SpringLayout.NORTH, input_fecha_terea);
        panelPrincipal.add(input_prioridad_tarea);
                
        input_descripcion = new Text_area_descripcion(texto_input_descripcion);
        layout.putConstraint(SpringLayout.WEST, input_descripcion, 150, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, input_descripcion, 50, SpringLayout.NORTH, input_fecha_terea);
        panelPrincipal.add(input_descripcion);
        
        bonton_crear_editar = new Boton(texto_boton);
        layout.putConstraint(SpringLayout.WEST, bonton_crear_editar, 300, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, bonton_crear_editar, 230, SpringLayout.NORTH, input_descripcion);
        panelPrincipal.add(bonton_crear_editar);
        
        label_resultado_tarea = new JLabel("");
        label_resultado_tarea.setHorizontalAlignment(CENTER);
        label_resultado_tarea.setFont(Estilos.getFuenteConTamaio(14));
        layout.putConstraint(SpringLayout.WEST, label_resultado_tarea, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_resultado_tarea, 45, SpringLayout.NORTH, bonton_crear_editar);
        layout.putConstraint(SpringLayout.EAST, label_resultado_tarea, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_resultado_tarea);
        
        bonton_crear_editar.addActionListener((ActionEvent e1) -> {
            
            String titulo = this.getInput_titulo_terea().getText();
            String prioridad = (String) this.getInput_prioridad_tarea().getSelectedItem();
            String fecha = this.getInput_fecha_terea().getText();
            String descripcion = this.getInput_descripcion().getTextArea().getText();
            int idLista = tareas_view.recoger_id_lista_seleccionada();
                
            if (this.getTarea() == null) {


                String mensaje_resultado = tarea_controlador.crear_tarea(titulo, prioridad, fecha, descripcion, idLista);

                if (mensaje_resultado.isEmpty()) {

                    mensaje_resultado = "Tarea creada";
                    tareas_view.actualizar_panel_tareas();                   
                }

                this.getLabel_resultado_tarea().setText(mensaje_resultado);
                Timer tiempo_espera = new Timer(3000, evt -> this.getLabel_resultado_tarea().setText(""));
                tiempo_espera.setRepeats(false);
                tiempo_espera.start();

            } else {

                
                String mensaje_resultado = tarea_controlador.editar_tarea(this.getTarea().getIdTarea(), titulo, prioridad, fecha, descripcion, idLista);

                if (mensaje_resultado.isEmpty()) {

                    mensaje_resultado = "Tarea editada";
                    tareas_view.actualizar_panel_tareas();                   
                }

                this.getLabel_resultado_tarea().setText(mensaje_resultado);
                Timer tiempo_espera = new Timer(3000, evt -> this.getLabel_resultado_tarea().setText(""));
                tiempo_espera.setRepeats(false);
                tiempo_espera.start();
                
            }
        });
    }

    public Boton getBonton_crear_editar() {
        return bonton_crear_editar;
    }

    public void setBonton_crear_editar(Boton bonton_crear_editar) {
        this.bonton_crear_editar = bonton_crear_editar;
    }

    public Text_area_descripcion getInput_descripcion() {
        return input_descripcion;
    }

    public void setInput_descripcion(Text_area_descripcion input_descripcion) {
        this.input_descripcion = input_descripcion;
    }

    public Select_prioridad getInput_prioridad_tarea() {
        return input_prioridad_tarea;
    }

    public void setInput_prioridad_tarea(Select_prioridad input_prioridad_tarea) {
        this.input_prioridad_tarea = input_prioridad_tarea;
    }

    public Input_date getInput_fecha_terea() {
        return input_fecha_terea;
    }

    public void setInput_fecha_terea(Input_date input_fecha_terea) {
        this.input_fecha_terea = input_fecha_terea;
    }

    public Input_text getInput_titulo_terea() {
        return input_titulo_terea;
    }

    public void setInput_titulo_terea(Input_text input_titulo_terea) {
        this.input_titulo_terea = input_titulo_terea;
    }

    public Tarea_plantilla getTarea() {
        return tarea;
    }

    public void setTarea(Tarea_plantilla tarea) {
        this.tarea = tarea;
    }

    public JLabel getLabel_resultado_tarea() {
        return label_resultado_tarea;
    }

    public void setLabel_resultado_tarea(JLabel label_resultado_tarea) {
        this.label_resultado_tarea = label_resultado_tarea;
    }
 
}
