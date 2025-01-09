/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Propietario
 */
public class MensajePopUp extends JDialog {
    
    Estilos estilos = new Estilos();

    public MensajePopUp(Component panelPadre) {
        
        super(SwingUtilities.getWindowAncestor(panelPadre), "PopUp", ModalityType.APPLICATION_MODAL);
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setSize(new Dimension(300, 100));
        this.setLocationRelativeTo(panelPadre);

        
        JLabel labelTitulo = new JLabel("Título", SwingConstants.CENTER);
        labelTitulo.setFont(estilos.getFuenteTitulo());

        this.add(labelTitulo, BorderLayout.CENTER);
    }
}
