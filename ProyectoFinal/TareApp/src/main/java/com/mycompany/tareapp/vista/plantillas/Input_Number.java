/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

/**
 *
 * @author Propietario
 */
import javax.swing.*;
import java.awt.Dimension;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;

public class Input_Number extends JFormattedTextField {
    
    public Input_Number() {
        
        super(crearFormato());
        
        this.setBorder(new RoundedBorder(5, 2));
        this.setBackground(Estilos.getBlanco_claro());
        this.setFont(Estilos.getFuente());
        this.setPreferredSize(new Dimension(80, 35));
    }

    public static MaskFormatter crearFormato() {
        
        try {
            
            MaskFormatter formato = new MaskFormatter("#####"); // Solo permite 5 números
            formato.setPlaceholderCharacter('_'); // Muestra "_" en los espacios vacíos
            
            return formato;
            
        } catch (ParseException e) {
            
            return null;
        }
    }
}

