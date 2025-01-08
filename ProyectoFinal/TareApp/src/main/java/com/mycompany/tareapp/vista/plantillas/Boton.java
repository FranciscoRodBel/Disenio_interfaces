/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.modelo.RoundedBorder;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.plaf.basic.BasicButtonUI;

/**
 *
 * @author Propietario
 */
public class Boton extends JButton {

    Estilos estilos = new Estilos();
    
    public Boton(String texto_boton) {
        
        this.setText(texto_boton);
        this.setUI(new BasicButtonUI());
        this.setBorder(new RoundedBorder(5, 2));
        this.setBackground(estilos.getAmarillo());
        this.setFont(estilos.getFuente());
        this.setPreferredSize(new Dimension(200, 35));
    }
    
}
