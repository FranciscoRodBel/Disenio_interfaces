/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Nota_controlador;
import com.mycompany.tareapp.controlador.Tarea_controlador;
import com.mycompany.tareapp.modelo.idioma.Pagina_notas;
import com.mycompany.tareapp.vista.Notas_view;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.Timer;


/**
 * Clase para el componente del popUp de crear y editar nota
 * Componente creado para crearlo cuando se pulse en el botón o icono concreto
 * 
 * @author Francisco
 */
public class Popup_crear_editar_nota extends JDialog {
    
    Pagina_notas idioma_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas();
    Notas_view notas_view = Notas_view.recoger_instancia();
    Nota_controlador nota_controlador = new Nota_controlador();
    Nota_plantilla nota;
    
    JPanel panelPrincipal = new JPanel();
    
    String texto_titulo_popup;
    String texto_input_descripcion;
    String texto_boton;

    Boton bonton_crear_editar;
    Text_area_descripcion input_descripcion;
    JLabel label_resultado_tarea;
    
    JRadioButton radioButtonNaranja = new JRadioButton();
    JRadioButton radioButtonVerde = new JRadioButton();
    JRadioButton radioButtonAzul = new JRadioButton();
    JRadioButton radioButtonMorado = new JRadioButton();
    JRadioButton radioButtonAmarillo = new JRadioButton();
    JRadioButton radioButtonRosa = new JRadioButton();
    ButtonGroup grupoBotonesColores = new ButtonGroup();
    
    JButton boton_borrar_nota = new JButton();
    
    /**
    * Constructor del PopUp con los estilos necesarios
    * 
    */     
    public Popup_crear_editar_nota(Nota_plantilla nota) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.nota = nota;
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(800, 500));
        this.setLocationRelativeTo(null);

        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 500);
        panelPrincipal.setBackground(Estilos.getGris_claro());
        
        
        if (nota == null) { // Si la nota es null es que se está creando la nota
            
            texto_titulo_popup = idioma_notas.getCrear_nota();
            texto_input_descripcion = "";
            texto_boton = idioma_notas.getCrear_nota();
            
        } else {
            
            texto_titulo_popup = idioma_notas.getEditar_nota();
            texto_input_descripcion = nota.getTextArea().getText();
            texto_boton = idioma_notas.getEditar_nota();
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
        
        // Creación de los radioButtons
        grupoBotonesColores.add (radioButtonNaranja);
        grupoBotonesColores.add (radioButtonVerde);
        grupoBotonesColores.add (radioButtonAzul);
        grupoBotonesColores.add (radioButtonMorado);
        grupoBotonesColores.add (radioButtonAmarillo);
        grupoBotonesColores.add (radioButtonRosa);
        
        // Pongo un nombre para saber cual es cada radio button
        radioButtonNaranja.setActionCommand("naranja");
        radioButtonVerde.setActionCommand("verde");
        radioButtonAzul.setActionCommand("azul");
        radioButtonMorado.setActionCommand("morado");
        radioButtonAmarillo.setActionCommand("amarillo");
        radioButtonRosa.setActionCommand("rosa");
        
        if (nota != null) { // Al editar selecciono el radio button y cambio la foto del radio button seleccionado
            
            quitarBotonSeleccionado();
            
            switch(nota.getColor()) {
                case "naranja" -> radioButtonNaranja.setSelected(true);
                case "verde" -> radioButtonVerde.setSelected(true);
                case "morado" -> radioButtonMorado.setSelected(true);
                case "amarillo" -> radioButtonAmarillo.setSelected(true);
                case "rosa" -> radioButtonRosa.setSelected(true);
                default -> {
                    radioButtonAzul.setSelected(true);
                }
            }
            
            switch(nota.getColor()) {
                case "naranja" -> radioButtonNaranja.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioNaranjaSeleccionado.png")));
                case "verde" -> radioButtonVerde.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioVerdeSeleccionado.png")));
                case "morado" -> radioButtonMorado.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioMoradoSeleccionado.png")));
                case "amarillo" -> radioButtonAmarillo.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioAmarilloSeleccionado.png")));
                case "rosa" -> radioButtonRosa.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioRosaSeleccionado.png")));
                default -> {
                    radioButtonAzul.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioAzulSeleccionado.png")));
                }
            }
            
            boton_borrar_nota.setIcon(new ImageIcon(getClass().getResource("/imagenes/trash-can-solid.png")));
            panelPrincipal.add(boton_borrar_nota);
            boton_borrar_nota.setPreferredSize(new Dimension(40, 40));
            boton_borrar_nota.setContentAreaFilled(false); // Elimino el fondo
            layout.putConstraint(SpringLayout.WEST, boton_borrar_nota, 5, SpringLayout.WEST, panelPrincipal);
            layout.putConstraint(SpringLayout.NORTH, boton_borrar_nota, 5, SpringLayout.NORTH, panelPrincipal);
            boton_borrar_nota.setToolTipText(idioma_notas.getBorrar_nota());
            
        } else {
        
            quitarBotonSeleccionado();
            radioButtonNaranja.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioNaranjaSeleccionado.png")));
            radioButtonNaranja.setSelected(true);
            
        }

        layout.putConstraint(SpringLayout.WEST, radioButtonNaranja, 190, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, radioButtonNaranja, 220, SpringLayout.NORTH, input_descripcion);
        panelPrincipal.add (radioButtonNaranja);
        
        layout.putConstraint(SpringLayout.WEST, radioButtonVerde, 70, SpringLayout.WEST, radioButtonNaranja);
        layout.putConstraint(SpringLayout.NORTH, radioButtonVerde, 0, SpringLayout.NORTH, radioButtonNaranja);
        panelPrincipal.add (radioButtonVerde);
        
        layout.putConstraint(SpringLayout.WEST, radioButtonAzul, 70, SpringLayout.WEST, radioButtonVerde);
        layout.putConstraint(SpringLayout.NORTH, radioButtonAzul, 0, SpringLayout.NORTH, radioButtonVerde);
        panelPrincipal.add (radioButtonAzul);
        
        layout.putConstraint(SpringLayout.WEST, radioButtonMorado, 70, SpringLayout.WEST, radioButtonAzul);
        layout.putConstraint(SpringLayout.NORTH, radioButtonMorado, 0, SpringLayout.NORTH, radioButtonAzul);
        panelPrincipal.add (radioButtonMorado);
        
        layout.putConstraint(SpringLayout.WEST, radioButtonAmarillo, 70, SpringLayout.WEST, radioButtonMorado);
        layout.putConstraint(SpringLayout.NORTH, radioButtonAmarillo, 0, SpringLayout.NORTH, radioButtonMorado);
        panelPrincipal.add (radioButtonAmarillo);
        
        layout.putConstraint(SpringLayout.WEST, radioButtonRosa, 70, SpringLayout.WEST, radioButtonAmarillo);
        layout.putConstraint(SpringLayout.NORTH, radioButtonRosa, 0, SpringLayout.NORTH, radioButtonAmarillo);
        panelPrincipal.add (radioButtonRosa);
        
        bonton_crear_editar = new Boton(texto_boton, "amarillo");
        layout.putConstraint(SpringLayout.WEST, bonton_crear_editar, 300, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, bonton_crear_editar, 90, SpringLayout.NORTH, radioButtonNaranja);
        panelPrincipal.add(bonton_crear_editar);
        
        label_resultado_tarea = new JLabel("");
        label_resultado_tarea.setHorizontalAlignment(CENTER);
        label_resultado_tarea.setFont(Estilos.getFuenteConTamaio(14));
        layout.putConstraint(SpringLayout.WEST, label_resultado_tarea, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_resultado_tarea, 45, SpringLayout.NORTH, bonton_crear_editar);
        layout.putConstraint(SpringLayout.EAST, label_resultado_tarea, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_resultado_tarea);
        
        // Actualizo la imagen del radio button que se seleccione
        radioButtonNaranja.addActionListener((ActionEvent e) -> {
            
            quitarBotonSeleccionado();
            radioButtonNaranja.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioNaranjaSeleccionado.png")));
        });
        
        radioButtonVerde.addActionListener((ActionEvent e) -> {
            
            quitarBotonSeleccionado();
            radioButtonVerde.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioVerdeSeleccionado.png")));
        });
        
        radioButtonAzul.addActionListener((ActionEvent e) -> {
            
            quitarBotonSeleccionado();
            radioButtonAzul.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioAzulSeleccionado.png")));
        });
                
                
        radioButtonMorado.addActionListener((ActionEvent e) -> {
            
            quitarBotonSeleccionado();
            radioButtonMorado.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioMoradoSeleccionado.png")));
        });
        
        radioButtonAmarillo.addActionListener((ActionEvent e) -> {
            
            quitarBotonSeleccionado();
            radioButtonAmarillo.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioAmarilloSeleccionado.png")));
        });
        
        radioButtonRosa.addActionListener((ActionEvent e) -> {
            
            quitarBotonSeleccionado();
            radioButtonRosa.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioRosaSeleccionado.png")));
        });
        
        bonton_crear_editar.addActionListener((ActionEvent e1) -> {
            
            String mensaje_resultado = "";
            String descripcion = this.getInput_descripcion().getTextArea().getText();
            String color = grupoBotonesColores.getSelection().getActionCommand();
                
            if (this.getNota() == null) { // Si se crea la nota...

                mensaje_resultado = nota_controlador.crear_nota(descripcion, color);

                if (mensaje_resultado.isEmpty()) {

                    mensaje_resultado = idioma_notas.getNota_creada();
                    notas_view.actualizar_panel_notas();       
                    
                    input_descripcion.getTextArea().setText("");
                    radioButtonNaranja.setSelected(true);
                }

            } else { // Si se edita la nota...

                mensaje_resultado = nota_controlador.editar_nota(this.getNota().getIdNota(), descripcion, color);

                if (mensaje_resultado.isEmpty()) {

                    mensaje_resultado = idioma_notas.getNota_editada();
                    notas_view.actualizar_panel_notas();                   
                }
            }
            
            this.getLabel_resultado_tarea().setText(mensaje_resultado); // Muestro el resultado durante 3 segundos
            Timer tiempo_espera = new Timer(3000, evt -> this.getLabel_resultado_tarea().setText(""));
            tiempo_espera.setRepeats(false);
            tiempo_espera.start();
        });
        
        boton_borrar_nota.addActionListener((ActionEvent e1) -> {
            Popup_borrar_nota popup_borrar_nota = new Popup_borrar_nota(this, this.getNota().getIdNota());
            popup_borrar_nota.setVisible(true);
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
    
    public void quitarBotonSeleccionado() {
       
        radioButtonNaranja.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioNaranja.png")));
        radioButtonVerde.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioVerde.png")));
        radioButtonAzul.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioAzul.png")));
        radioButtonMorado.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioMorado.png")));
        radioButtonAmarillo.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioAmarillo.png")));
        radioButtonRosa.setIcon(new ImageIcon(getClass().getResource("/imagenes/radioRosa.png")));
    }
}
