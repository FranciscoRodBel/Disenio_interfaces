/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Propietario
 */
public class Boton extends JButton {
    
    public Boton(String texto_boton, String tipo_boton) {
        
        this.setText(texto_boton);
        this.setUI(new BasicButtonUI());
        this.setBorder(new RoundedBorder(0, 2));
        this.setFont(Estilos.getFuente());
        this.setPreferredSize(new Dimension(200, 35));
        
        if (tipo_boton.equals("rojo")) {
        
            this.setBackground(Estilos.getRojo());
            this.setForeground(Estilos.getAzul_oscuro());
            
        } else {
        
            this.setBackground(Estilos.getAmarillo());
            this.setForeground(Estilos.getAzul_oscuro());
        }
        
        Color colorFondo = getBackground();
        Color colorLetra = getForeground();
        
        this.addMouseListener(new MouseAdapter() {

            
            public void mouseEntered(MouseEvent e) {
                
                setBackground(Estilos.getAzul_oscuro());
                setForeground(Estilos.getBlanco_claro());
            }

            public void mouseExited(MouseEvent e) {
                
                setBackground(colorFondo);
                setForeground(colorLetra);
            }
        });
    }
    
}
