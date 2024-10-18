/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.relacion_2_2_franciscorb;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Francisco
 */
public class RadioButtonForm extends JPanel {

    private JLabel texto = new JLabel();
    private JRadioButton opcion1 = new JRadioButton();
    private JRadioButton opcion2 = new JRadioButton();
    private ButtonGroup grupoBotones = new ButtonGroup();

    
    public RadioButtonForm() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(320, 100));
        this.setVisible(true);
        
        texto.setText("Opciones de pago");
        texto.setBounds(10, 20, 100, 30);
        texto.setVisible(true);
        this.add(texto);

        opcion1.setText("Paypal");
        opcion1.setBounds(10, 60, 150, 30);
        opcion1.setVisible(true);
        grupoBotones.add(opcion1);
        this.add(opcion1);
        
        opcion2.setText("Tarjeta de crédito");
        opcion2.setBounds(160, 60, 150, 30);
        opcion2.setVisible(true);
        grupoBotones.add(opcion2);
        this.add(opcion2);
    }

    public void setTextoLabel(String textoNuevo) {
    
        texto.setText(textoNuevo);
        
    }
    
    public JLabel getTextoLabel() {
    
        return texto;
        
    }
    
    public void setTextoOpcion1(String textoNuevo) {
    
        opcion1.setText(textoNuevo);
        
    }
    
    public JRadioButton getTextoOpcion1() {
    
        return opcion1;
        
    }
    
    public void setTextoOpcion2(String textoNuevo) {
    
        opcion2.setText(textoNuevo);
        
    }
    
    public JRadioButton getTextoOpcion2() {
    
        return opcion2;
        
    }
}
