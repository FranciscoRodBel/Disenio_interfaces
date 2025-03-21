/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

/**
 *
 * @author Propietario
 */

public class Scroll extends JScrollPane {

    public Scroll(Component view) {
        super(view);

        int scrollBarWidth = 10;

        getVerticalScrollBar().setPreferredSize(new Dimension(scrollBarWidth, Integer.MAX_VALUE));
        getHorizontalScrollBar().setPreferredSize(new Dimension(Integer.MAX_VALUE, scrollBarWidth));

        getVerticalScrollBar().setBackground(Estilos.getAzul_oscuro());
        getVerticalScrollBar().setForeground(Estilos.getAmarillo());

        getHorizontalScrollBar().setBackground(Estilos.getAzul_oscuro());
        getHorizontalScrollBar().setForeground(Estilos.getAmarillo());

        getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Estilos.getAmarillo();
                this.trackColor = Estilos.getAzul_oscuro();
            }
        });

        getHorizontalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = Estilos.getAmarillo();
                this.trackColor = Estilos.getAzul_oscuro();
            }
        });
    }
}

