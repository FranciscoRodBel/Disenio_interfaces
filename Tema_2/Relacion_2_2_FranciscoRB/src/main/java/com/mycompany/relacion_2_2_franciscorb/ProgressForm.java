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
public class LabelInput extends JPanel {

    private JLabel texto = new JLabel();
    private JTextField inputText = new JTextField();
    public LabelInput() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(200, 100));
        this.setVisible(true);
        
        texto.setText("Label: ");
        texto.setBounds(15, 35, 50, 30);
        texto.setVisible(true);
        this.add(texto);
        
        inputText.setText("Input text");
        inputText.setBounds(75, 35, 100, 30);
        inputText.setVisible(true);
        this.add(inputText);

    }

    public void setTextoLabel(String textoNuevo) {
    
        texto.setText(textoNuevo);
        
    }
    
    public JLabel getTextoLabel() {
    
        return texto;
        
    }
    
    public void setTextoInput(String textoNuevo) {
    
        inputText.setText(textoNuevo);
        
    }
    
    public JTextField getTextoInput() {
    
        return inputText;
        
    }
}
