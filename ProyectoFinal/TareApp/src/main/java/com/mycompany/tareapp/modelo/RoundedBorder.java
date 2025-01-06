package com.mycompany.tareapp.modelo;

import java.awt.BasicStroke;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import javax.swing.border.Border;

/**
 * Clase para crear bordes redondeados personalizados.
 * Clase copiada de: https://es.stackoverflow.com/questions/549765/cambiar-el-grosor-a-borde-redondo-en-java
 */
public class RoundedBorder implements Border { // Ahora la clase es pública

    private int radius;
    private int thickness;

    public RoundedBorder(int radius, int thickness) {
        this.radius = radius;
        this.thickness = thickness;
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius + 1, this.radius + 1, this.radius + 2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setStroke(new BasicStroke(thickness));
        g2d.drawRoundRect(x + thickness / 2, y + thickness / 2, width - thickness, height - thickness, radius, radius);
        g2d.dispose();
        
    }
}
