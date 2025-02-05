/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import javax.swing.JTextField;

/**
 *
 * @author Propietario
 */
public class Input_text extends JTextField {

    TextPrompt placeholder;
    
    public Input_text(String texto_placeholder, String texto_input) {
        
        this.setBorder(new RoundedBorder(5, 2));
        this.setBackground(Estilos.getBlanco_claro());
        this.setFont(Estilos.getFuente());
        this.setPreferredSize(new Dimension(260, 35));
        placeholder = new TextPrompt(texto_placeholder, this);
        
        if (!texto_input.isEmpty()) {
        
            this.setText(texto_input);
        }
    }
    
    public TextPrompt getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(TextPrompt placeholder) {
        this.placeholder = placeholder;
    }
}
