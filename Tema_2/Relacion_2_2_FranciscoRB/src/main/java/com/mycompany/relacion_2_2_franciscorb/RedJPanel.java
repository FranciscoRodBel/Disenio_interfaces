/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.relacion_2_2_franciscorb;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Francisco
 */
public class RedJPanel extends JPanel {
    
    JLabel texto = new JLabel();
    
    public RedJPanel() {
    
        this.setPreferredSize(new Dimension(100, 100));
        this.setBackground(new Color(241, 89, 70));
        this.setVisible(true);
        
        texto.setText("Este es mi panel");
        texto.setVisible(true);
        this.add(texto);
    
    }
       
    public void setTexto(String textoNuevo) {
    
        texto.setText(textoNuevo);
        
    }
    
    public JLabel getTexto() {
    
        return texto;
        
    }
}
