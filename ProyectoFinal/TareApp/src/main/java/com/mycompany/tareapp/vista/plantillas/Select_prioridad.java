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
 *
 * @author Francisco
 */
public class Select_prioridad extends JComboBox<String> {
    
    public Select_prioridad(String texto_prioridad) {
        
        //this.setBorder(new RoundedBorder(5, 2));
        this.setBackground(Estilos.getBlanco_claro());
        this.setFont(Estilos.getFuente());
        this.setPreferredSize(new Dimension(260, 35));
        
        Pagina_tareas idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();
        
        this.addItem(idioma_seleccionado.getPrioridad());
        this.addItem(idioma_seleccionado.getBaja());
        this.addItem(idioma_seleccionado.getMedia());
        this.addItem(idioma_seleccionado.getAlta());
        
        if (!texto_prioridad.isEmpty()) {
                    
            switch(texto_prioridad) {
                case "Media":
                    this.setSelectedIndex(2);
                    break;    

                case "Alta":
                    this.setSelectedIndex(3);
                    break;

                default:
                    this.setSelectedIndex(1);
            }
        }
    }
}
