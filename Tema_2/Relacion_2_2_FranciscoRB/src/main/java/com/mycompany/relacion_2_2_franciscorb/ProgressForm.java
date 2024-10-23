/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.relacion_2_2_franciscorb;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.TimerTask;

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
    private Timer timer = new Timer();

    
    public ProgressForm() {

        this.setPreferredSize(new Dimension(500, 500));
        
        panelCerrado.setLocation(200, 200);
        this.add(panelCerrado);
        
        
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
    
        TimerTask task = new TimerTask() {
            public void run() {

                int valorBarra = barraProgreso.getValue();

                if (valorBarra < barraProgreso.getMaximum()) {

                    barraProgreso.setValue(valorBarra + 1);

                } else {

                    timer.cancel();
                    mensajeFinal.setText("¡Formulario Enviado!");
                    mensajeFinal.setVisible(true);

                }
            }
        };
        
        botonEnviar.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                
                barraProgreso.setVisible(true);
                barraProgreso.setMinimum(0);
                barraProgreso.setMaximum(5);

                timer.schedule(task, 0,1000);
            }
        });
    }
}
