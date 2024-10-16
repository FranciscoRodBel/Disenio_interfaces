/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.relacion_2_2_franciscorb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Francisco
 */
public class ClosedJPanel extends JPanel {
    
    JButton botonCerrarVentana = new JButton();
    
    public ClosedJPanel() {
    
        this.setLayout(null);
        this.setPreferredSize(new Dimension(300, 300));
        this.setVisible(true);
        
        botonCerrarVentana.setText("X");
        botonCerrarVentana.setOpaque(false);
        botonCerrarVentana.setBackground(Color.red);
        botonCerrarVentana.setForeground(Color.white);
        botonCerrarVentana.setBounds(250,0,50,50);
        this.add(botonCerrarVentana);
    
        botonCerrarVentana.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {

                System.exit(0);
                
            }
        });
    }
    
}
