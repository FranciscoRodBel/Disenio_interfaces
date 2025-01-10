/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Window;
import java.util.Date;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Propietario
 */
public class Popup_crear_tarea extends JDialog {
    
    Estilos estilos = new Estilos();
    JPanel panelPrincipal = new JPanel();

    public Popup_crear_tarea() {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.setLayout(null);
        this.setSize(new Dimension(800, 500));
        this.setLocationRelativeTo(null);
        
        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 500);
        panelPrincipal.setBackground(estilos.getGris_claro());
        
        JLabel labelTitulo = new JLabel("Crear Tarea", SwingConstants.CENTER);
        labelTitulo.setFont(estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, labelTitulo, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelTitulo, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, labelTitulo, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(labelTitulo);
        
        Input_text input_titulo_terea = new Input_text("Título tarea");
        layout.putConstraint(SpringLayout.WEST, input_titulo_terea, 270, SpringLayout.WEST, labelTitulo);
        layout.putConstraint(SpringLayout.NORTH, input_titulo_terea, 50, SpringLayout.NORTH, labelTitulo);
        panelPrincipal.add(input_titulo_terea);
                   
        Input_date input_fecha_terea = new Input_date();
        layout.putConstraint(SpringLayout.WEST, input_fecha_terea, 0, SpringLayout.WEST, input_titulo_terea);
        layout.putConstraint(SpringLayout.NORTH, input_fecha_terea, 50, SpringLayout.NORTH, input_titulo_terea);
        panelPrincipal.add(input_fecha_terea);
        
        
    }

}
