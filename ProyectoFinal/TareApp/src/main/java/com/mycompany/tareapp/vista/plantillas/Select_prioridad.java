/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.modelo.idioma.Pagina_tareas;
import java.awt.Dimension;
import javax.swing.JComboBox;

/**
 * Clase para el componente del select de prioridad
 * Componente creado para tener el código más estructurado, para tener los estilos de este componente aquí
 * 
 * @author Francisco
 */
public class Select_prioridad extends JComboBox<String> {
    
    /**
    * Constructor del select de prioridad, con los estilos necesarios
    * 
    */
    public Select_prioridad(int prioridad) {
        
        //this.setBorder(new RoundedBorder(5, 2));
        this.setBackground(Estilos.getBlanco_claro());
        this.setFont(Estilos.getFuente());
        this.setPreferredSize(new Dimension(260, 35));
        
        Pagina_tareas idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();
        
        String prioridad_media = idioma_seleccionado.getMedia(); 
        String prioridad_alta = idioma_seleccionado.getAlta(); 
        
        this.addItem(idioma_seleccionado.getPrioridad());
        this.addItem(idioma_seleccionado.getBaja());
        this.addItem(prioridad_media);
        this.addItem(prioridad_alta);
        
        this.setSelectedIndex(prioridad);  
    }
}
