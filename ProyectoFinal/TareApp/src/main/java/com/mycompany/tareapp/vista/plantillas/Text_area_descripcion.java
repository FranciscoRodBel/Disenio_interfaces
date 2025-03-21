/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.modelo.idioma.Pagina_tareas;
import java.awt.Dimension;
import javax.swing.JTextArea;
import static javax.swing.SwingConstants.CENTER;

/**
 * Clase para el componente del text area de la contraseña
 * Componente creado para reducir código en otras páginas y no duplicarlo
 * 
 * @author Francisco
 */
public class Text_area_descripcion extends Scroll {

    JTextArea textArea;
    TextPrompt placeholder;
    
    /**
    * Constructor del text area, con los estilos necesarios
    * 
    */
    public Text_area_descripcion(String texto_descripcion) {
        
        super(new JTextArea());
        textArea = new JTextArea();
        textArea.setFont(Estilos.getFuente());
        
        
        this.setViewportView(textArea);
        this.setPreferredSize(new Dimension(500, 200));
        this.setBorder(new RoundedBorder(2, 2));
        
        Pagina_tareas idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();
        
        placeholder = new TextPrompt(idioma_seleccionado.getDescripcion(), textArea);
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
    
    /**
    * Método para poder ver el text area sin poder escribir en él, para la opción de ver tarea
    * 
    */
    public void cambiarFormatoVer() {
        
        this.setBorder(null);
        this.setPreferredSize(new Dimension(700, 200));
        textArea.setBackground(Estilos.getBlanco_claro());
        textArea.setCaretColor(null);
        textArea.setFocusable(false);
    }
}
