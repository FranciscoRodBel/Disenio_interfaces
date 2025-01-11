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
public class Text_area_descripcion extends JScrollPane {

    Estilos estilos = new Estilos();
    JTextArea textArea;
    TextPrompt placeholder;
    
    public Text_area_descripcion(String texto_descripcion) {
        
        textArea = new JTextArea();
        textArea.setFont(estilos.getFuente());
        
        this.setViewportView(textArea);
        this.setPreferredSize(new Dimension(500, 200));
        this.setBorder(new RoundedBorder(2, 2));
        
        placeholder = new TextPrompt("Descripción", textArea);
        placeholder.setHorizontalAlignment(CENTER);
        
        if (!texto_descripcion.isEmpty()) {
            
            textArea.setText(texto_descripcion);
        }
    }
    
    public TextPrompt getPlaceholder() {
        return placeholder;
    }

    public void setPlaceholder(TextPrompt placeholder) {
        this.placeholder = placeholder;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
    
    public void cambiarFormatoVer() {
        
        this.setBorder(null);
        this.setPreferredSize(new Dimension(700, 200));
        textArea.setBackground(estilos.getBlanco_claro());
        textArea.setCaretColor(null);
        textArea.setFocusable(false);
    }
}
