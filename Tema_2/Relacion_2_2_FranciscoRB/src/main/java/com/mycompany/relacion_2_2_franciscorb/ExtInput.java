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
public class ExtInput extends JPanel {

    private Boolean isEditable = true;
    private Boolean isTextArea = false;
    private JLabel label1 = new JLabel();
    private JTextField inputText = new JTextField();
    private JLabel label2 = new JLabel();
    private JTextArea textArea = new JTextArea();
    
    public ExtInput() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(200, 150));
        this.setVisible(true);
        
        label1.setText("Mi campo");
        label1.setBounds(25, 25, 150, 30);
        label1.setVisible(true);
        this.add(label1);
        
        inputText.setText("Input text");
        inputText.setBounds(25, 70, 100, 30);
        inputText.setVisible(true);
        this.add(inputText);
        
        label2.setText("label2");
        label2.setBounds(25, 70, 100, 30);
        label2.setVisible(false);
        this.add(label2);
        
        textArea.setText("label2");
        textArea.setBounds(25, 70, 120, 50);
        textArea.setVisible(false);
        this.add(textArea);

    }

    public void setTextoLabel1(String textoNuevo) {
    
        label1.setText(textoNuevo);
        
    }
    
    public JLabel getTextoLabel1() {
    
        return label1;
        
    }
    
    public void setTextoLabel2(String textoNuevo) {
    
        label2.setText(textoNuevo);
        
    }
    
    public JLabel getTextoLabel2() {
    
        return label2;
        
    }

    public void comprobarTipo() {
    
        if (isEditable) {
        
            if (isTextArea) {
            
                inputText.setVisible(false);
                textArea.setVisible(true);
                label2.setVisible(false);
            
            } else {
            
                inputText.setVisible(true);
                textArea.setVisible(false);
                label2.setVisible(false);
            
            }
            
        } else {
        
            inputText.setVisible(false);
            textArea.setVisible(false);
            label2.setVisible(true);
            
        }
        
    }
    
    public Boolean getisEditable() {
        
        return isEditable;
    }
    
    public void setisEditable(Boolean tipo) {

        isEditable = tipo;
        comprobarTipo();
        
    }
    
    public Boolean getisTextArea() {
        
        return isTextArea;
    }
    
    public void setisTextArea(Boolean tipo) {

        isTextArea = tipo;
        comprobarTipo();
        
    }
}
