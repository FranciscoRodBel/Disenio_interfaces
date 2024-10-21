/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.relacion_2_2_franciscorb;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Francisco
 */
public class ProgressForm extends JPanel {

    private ClosedJPanel panelCerrado = new ClosedJPanel();
    private LabelInput campoForm = new LabelInput();
    private JButton botonEnviar = new JButton();
    private JProgressBar barraProgreso = new JProgressBar();
    private JLabel mensajeFinal = new JLabel();
    
    public ProgressForm() {

        this.setPreferredSize(new Dimension(500, 500));
        this.setVisible(true);
        
        panelCerrado.setLocation(400, 0);
        this.add(panelCerrado);
        
        campoForm.setLocation(100, 200);
        this.add(campoForm);
        
        botonEnviar.setText("Enviar");
        botonEnviar.setBounds(200, 300, 100, 30);
        botonEnviar.setVisible(true);
        this.add(botonEnviar);
        
        barraProgreso.setBounds(200, 400, 100, 30);
        barraProgreso.setVisible(false);
        this.add(barraProgreso);

        mensajeFinal.setBounds(300, 300, 100, 30);
        mensajeFinal.setVisible(false);
        this.add(mensajeFinal);
        
        botonEnviar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                
                barraProgreso.setVisible(true);
            }
            
        });
    }
}
