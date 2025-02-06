/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import javax.swing.JPasswordField;

/**
 * Clase para el componente del input de la contraseña
 * Componente creado para reducir código, ya que se usa varias veces en la página de inicio y registro
 * 
 * @author Francisco
 */
public class Input_password extends JPasswordField {

    TextPrompt placeholder;
    
    /**
    * Constructor del input de la contraseña, con los estilos necesarios
    * 
    */
    public Input_password(String texto_placeholder) {
        
        this.setBorder(new RoundedBorder(5, 2));
        this.setBackground(Estilos.getBlanco_claro());
        this.setFont(Estilos.getFuente());
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
