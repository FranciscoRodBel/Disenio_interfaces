/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

/**
 * Clase para el componente de la fecha de la tarea
 * Componente creado para reducir código en la página de tareas y así tener el código más estructurado
 * 
 * @author Francisco
 */
public class Input_date extends JFormattedTextField {
    
    JButton botonCalendario = new JButton();
    
    /**
    * Constructor del input date, con los estilos necesarios
    * 
    */
    public Input_date(String texto_fecha) {
        
        super(crearFormato());
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setBorder(new RoundedBorder(5, 2));
        this.setBackground(Estilos.getBlanco_claro());
        this.setFont(Estilos.getFuente());
        this.setPreferredSize(new Dimension(260, 35));
        
        botonCalendario.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/calendar-days-solid.png"));
        botonCalendario.setPreferredSize(new Dimension(30,30));
        botonCalendario.setContentAreaFilled(false); // Elimino el fondo
        this.add(botonCalendario);
        layout.putConstraint(SpringLayout.EAST, botonCalendario, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, botonCalendario, -5, SpringLayout.NORTH, this);
        
        if (!texto_fecha.isEmpty()) {
            this.setText(texto_fecha);
        }
        
        
    }
    // Para el icono - https://www.youtube.com/watch?v=yc3sWITm4v8 // No se añade en esta versión finalmente 
    
    /**
    * Función que permite bloquear la posibilidad de añadir la fecha en un formato distinto al que se pide
    * 
    * @return Devuelve el formato en el que tiene que ir la fecha
    */
    public static MaskFormatter crearFormato() {
        
        try {
            
            MaskFormatter formato = new MaskFormatter("##/##/####"); // Con el # le indico el formato y que solo pueden introducirse números
            formato.setPlaceholderCharacter('_'); // Cambio los # por _, porngo primero los # en vez de directamente los _ para que solo permita números
            return formato;
            
        } catch (ParseException e) {
        
            return null;
        }
    }
}
