/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import javax.swing.JPasswordField;

/**
 *
 * @author Propietario
 */
public class Input_password extends JPasswordField {

    Estilos estilos = new Estilos();
    TextPrompt placeholder;
    
    public Input_password(String texto_placeholder) {
        
        this.setBorder(new RoundedBorder(5, 2));
        this.setBackground(estilos.getBlanco_claro());
        this.setFont(estilos.getFuente());
        this.setPreferredSize(new Dimension(260, 35));
        placeholder = new TextPrompt(texto_placeholder, this);
        
    }
    
    public TextPrompt getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(TextPrompt placeholder) {
        this.placeholder = placeholder;
    }
}
