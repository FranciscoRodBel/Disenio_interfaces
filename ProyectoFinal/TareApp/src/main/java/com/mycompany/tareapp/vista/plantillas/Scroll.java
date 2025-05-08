/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/**
 * Clase para aplicar un scroll personalizado en las notas y los text Area,
 * consiguiendo que tenga un scroll vertical y horizontal con estilo propio.
 * 
 * @author Francisco
 */

public class Scroll extends JScrollPane {

    public Scroll(Component view) { // Constructor que recibe un componente que se va a mostrar dentro del JScrollPane
        super(view);

        int scrollBarWidth = 10; // Ancho del scroll

        // Establece el tamaño del scroll
        getVerticalScrollBar().setPreferredSize(new Dimension(scrollBarWidth, Integer.MAX_VALUE));
        getHorizontalScrollBar().setPreferredSize(new Dimension(Integer.MAX_VALUE, scrollBarWidth));

        // Establece los colores del scroll
        getVerticalScrollBar().setBackground(Estilos.getAzul_oscuro());
        getVerticalScrollBar().setForeground(Estilos.getAmarillo());

        getHorizontalScrollBar().setBackground(Estilos.getAzul_oscuro());
        getHorizontalScrollBar().setForeground(Estilos.getAmarillo());

        // Personaliza la barra vertical
        getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Estilos.getAmarillo();
                this.trackColor = Estilos.getAzul_oscuro();
            }
        });

        // Personaliza la barra horizontal
        getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Estilos.getAmarillo();
                this.trackColor = Estilos.getAzul_oscuro();
            }
        });
    }
}

