/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import javax.swing.JComboBox;

/**
 *
 * @author Francisco
 */
public class Select_prioridad extends JComboBox<String> {

    Estilos estilos = new Estilos();
    
    public Select_prioridad(String texto_prioridad) {
        
        //this.setBorder(new RoundedBorder(5, 2));
        this.setBackground(estilos.getBlanco_claro());
        this.setFont(estilos.getFuente());
        this.setPreferredSize(new Dimension(260, 35));
        
        this.addItem("Baja");
        this.addItem("Media");
        this.addItem("Alta");
        
        if (!texto_prioridad.isEmpty()) {
                    
            switch(texto_prioridad) {
                case "Media":
                    this.setSelectedIndex(1);
                    break;    

                case "Alta":
                    this.setSelectedIndex(2);
                    break;

                default:
                    this.setSelectedIndex(0);
            }
        }
    }
}
