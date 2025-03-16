/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Nota_controlador;
import com.mycompany.tareapp.controlador.Tarea_controlador;
import com.mycompany.tareapp.vista.Notas_view;
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
 * Clase para el componente del popUp de crear y editar tarea
 * Componente creado para crearlo cuando se pulse en el botón o icono concreto
 * 
 * @author Francisco
 */
public class Popup_crear_editar_nota extends JDialog {
    
    //Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();
    Notas_view notas_view = Notas_view.recoger_instancia();
    Nota_controlador nota_controlador = new Nota_controlador();
    Nota_plantilla nota;
    
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
    
    /**
    * Constructor del PopUp con los estilos necesarios
    * 
    */     
    public Popup_crear_editar_nota(Nota_plantilla nota) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.nota = nota;
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(800, 520));
        this.setLocationRelativeTo(null);

        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 520);
        panelPrincipal.setBackground(Estilos.getGris_claro());
        
        
        if (nota == null) {
            
            texto_titulo_popup = "Crear nota";
            texto_input_descripcion = "";
            texto_boton = "Crear nota";
            
        } else {
            
            texto_titulo_popup = "Editar nota";
            texto_input_descripcion = "Texto descripción";
            texto_boton = "Editar nota";
        }
        
        JLabel labelTitulo = new JLabel(texto_titulo_popup, SwingConstants.CENTER);
        labelTitulo.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, labelTitulo, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelTitulo, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, labelTitulo, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(labelTitulo);
        
        input_descripcion = new Text_area_descripcion(texto_input_descripcion);
        layout.putConstraint(SpringLayout.WEST, input_descripcion, 150, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, input_descripcion, 50, SpringLayout.NORTH, labelTitulo);
        panelPrincipal.add(input_descripcion);
        
        bonton_crear_editar = new Boton(texto_boton, "amarillo");
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
            
            String mensaje_resultado = "";
            String descripcion = this.getInput_descripcion().getTextArea().getText();
            String color = "amarillo";
                
            if (this.getNota()== null) {

                mensaje_resultado = nota_controlador.crear_nota(descripcion, "amarillo");

                if (mensaje_resultado.isEmpty()) {

                    mensaje_resultado = "Nota creada correctamente";
                    notas_view.actualizar_panel_notas();                   
                }

            } else {

                mensaje_resultado = nota_controlador.editar_nota(this.getNota().getIdNota(), descripcion, color);

                if (mensaje_resultado.isEmpty()) {

                    mensaje_resultado = "Nota editada correctamente";
                    notas_view.actualizar_panel_notas();                   
                }
            }
            
            this.getLabel_resultado_tarea().setText(mensaje_resultado);
            Timer tiempo_espera = new Timer(3000, evt -> this.getLabel_resultado_tarea().setText(""));
            tiempo_espera.setRepeats(false);
            tiempo_espera.start();
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

    public Nota_plantilla getNota() {
        return nota;
    }

    public void setNota(Nota_plantilla nota) {
        this.nota = nota;
    }

    public JLabel getLabel_resultado_tarea() {
        return label_resultado_tarea;
    }

    public void setLabel_resultado_tarea(JLabel label_resultado_tarea) {
        this.label_resultado_tarea = label_resultado_tarea;
    }
 
}
