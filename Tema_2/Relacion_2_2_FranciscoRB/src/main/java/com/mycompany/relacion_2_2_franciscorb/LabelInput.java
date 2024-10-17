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
        this.setPreferredSize(new Dimension(100, 50));
        this.setVisible(true);
        
        texto.setText("Label: ");
        texto.setBounds(10, 15, 30, 20);
        texto.setVisible(true);
        this.add(texto);

    }
    
}
