/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.exament2_frb;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.TimerTask;
import javax.swing.*;
import java.util.Timer;

/**
 *
 * @author Francisco
 */
public class Eje2 extends JPanel {
    
    JButton botonCerrar = new JButton();
    JTextField inputNombre = new JTextField();
    JTextField inputUsuario = new JTextField();
    JLabel labelNombre = new JLabel();
    JLabel labelUsuario = new JLabel();
    JButton botonEnviar = new JButton();
    JLabel info = new JLabel();
    JLabel labelResultado = new JLabel();
    JProgressBar barraProgreso = new JProgressBar();
    Timer timer = new Timer();
    
    public Eje2() {
    
        this.setPreferredSize(new Dimension(600, 400));
        this.setBounds(0, 0, 600, 400);
        this.setBackground(new Color(255, 255, 153));
        this.setLayout(null); 
          
        botonCerrar.setText("X");
        botonCerrar.setBackground(Color.red);
        botonCerrar.setForeground(Color.white);
        botonCerrar.setBounds(550, 0, 50, 50);
        botonCerrar.setVisible(true);
        this.add(botonCerrar);
        
        info.setText("Lorem ipsum");
        info.setBounds(250,50,250,150);
        info.setVisible(true);
        this.add(info);

        botonEnviar.setText("Enviar");
        botonEnviar.setBounds(400,225,75,30);
        botonEnviar.setVisible(true);
        this.add(botonEnviar);
        
        labelNombre.setText("Nombre: ");
        labelNombre.setBounds(100,200,100,30);
        labelNombre.setVisible(true);
        this.add(labelNombre);
        
        labelUsuario.setText("Usuario: ");
        labelUsuario.setBounds(100,250,100,30);
        labelUsuario.setVisible(true);
        this.add(labelUsuario);
        
        inputNombre.setText("");
        inputNombre.setBounds(225,200,100,30);
        inputNombre.setVisible(true);
        this.add(inputNombre);
        
        inputUsuario.setText("");
        inputUsuario.setBounds(225,250,100,30);
        inputUsuario.setVisible(true);
        this.add(inputUsuario);
        
        barraProgreso.setBounds(200,300,100,30);
        barraProgreso.setVisible(false);
        barraProgreso.setMaximum(5);
        barraProgreso.setMinimum(0);
        barraProgreso.setValue(0);
        this.add(barraProgreso);
        
        labelResultado.setText("");
        labelResultado.setBounds(200,350,200,30);
        labelResultado.setVisible(false);
        this.add(labelResultado);

        
        botonCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                System.exit(0);
            }
        });
        
        botonEnviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                
                TimerTask task = new TimerTask() { // Se crea la función que se ejecutará cada un segundo 
            
                    public void run() {

                        if (barraProgreso.getValue() == 5) { // Si ha llegado al final muestro el mensaje correcto

                            timer.cancel();
                            labelResultado.setText("Formulario válido");
                            labelResultado.setVisible(true);

                        } else { // Si no ha llegado al final sumo 1 a la barra de progreso
                        
                            barraProgreso.setValue(barraProgreso.getValue()+1);
                            
                        }

                    }
                };
                        
                
                if (inputNombre.getText().length() == 0 || inputUsuario.getText().length() == 0) { // Si están vacios los inputs...
                
                    labelResultado.setText("Formulario inválido");
                    labelResultado.setVisible(true);
                    
                } else {
                
                    barraProgreso.setVisible(true);
                    timer.schedule(task, 0, 1000);
                    
                }
            }
        });
        
        
        inputNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResultado.setVisible(false);
            }
        });
        
        inputUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelResultado.setVisible(false);
            }
        });
    }
    

    
    public void setInfo(String texto) {
    
        info.setText(texto);
        
    }
    
    public JLabel getInfo( ) {
           
        return info;
    }
    
        
    public void setlabelNombre(String texto) {
    
        labelNombre.setText(texto);
        
    }
    
    public JLabel getlabelNombre( ) {
           
        return labelNombre;
    }
    
            
    public void setlabelUsuario(String texto) {
    
        labelUsuario.setText(texto);
        
    }
    
    public JLabel getlabelUsuario( ) {
           
        return labelUsuario;
    }
    
    public void setTextoBotonEnviar(String texto) {
    
        botonEnviar.setText(texto);
        
    }
    
    public JButton getBotonEnviar( ) {
           
        return botonEnviar;
    }
    
    
    public void setSizeBotonEnviar(Dimension preferredSize) {
    
        
        botonEnviar.setPreferredSize(preferredSize);
        
    }
   
    
    public void setLabelResultado(Font font) {
    
        labelResultado.setFont(font);
        
    }
    
    public JLabel getLabelResultado( ) {
           
        return labelResultado;
    }
    
    
}
