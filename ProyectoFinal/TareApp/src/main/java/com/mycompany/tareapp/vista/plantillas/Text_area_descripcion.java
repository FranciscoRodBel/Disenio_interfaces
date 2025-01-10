/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import static javax.swing.SwingConstants.CENTER;

/**
 *
 * @author Francisco
 */
public class Text_area_descripcion extends JTextArea {

    JScrollPane scroll_text_area = new JScrollPane(this);
    TextPrompt placeholder;
    
    public Text_area_descripcion(String texto_descripcion) {
        
        this.setPreferredSize(new Dimension(500, 200));
        this.setBorder(new RoundedBorder(2, 2));
        scroll_text_area.setPreferredSize(new Dimension(500, 200));
        scroll_text_area.setBorder(new RoundedBorder(2, 2));
        placeholder = new TextPrompt("Descripción", this);
        placeholder.setHorizontalAlignment(CENTER);
        
        if (!texto_descripcion.isEmpty()) {
        
            this.setText(texto_descripcion);
            
        }
    }
    
    public TextPrompt getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(TextPrompt placeholder) {
        this.placeholder = placeholder;
    }

}
