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
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SpinnerDateModel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

/**
 *
 * @author Propietario
 */
public class Popup_borrar_cuenta_lista extends JDialog {
    
    Estilos estilos = new Estilos();
    JPanel panelPrincipal = new JPanel();
    
    String texto_pregunta_confirmacion;
    String texto_dato_borrado;
    String texto_boton_borrar;

    public Popup_borrar_cuenta_lista(String texto_dato_borrado, String tipo_popup) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(800, 230));
        this.setLocationRelativeTo(null);
            
        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 230);
        panelPrincipal.setBackground(estilos.getBlanco_claro());
        
        if (tipo_popup.equals("usuario")) {
            
            texto_pregunta_confirmacion = "¿Seguro que quiere borrar la cuenta?";
            texto_boton_borrar = "Borrar cuenta";
            
        } else {
        
            texto_pregunta_confirmacion = "¿Seguro que quiere borrar la lista?";
            texto_boton_borrar = "Borrar lista";
        }
        
        JLabel label_titulo_tarea = new JLabel(texto_pregunta_confirmacion, SwingConstants.CENTER);
        label_titulo_tarea.setFont(estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, label_titulo_tarea, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_titulo_tarea, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, label_titulo_tarea, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_titulo_tarea);
        
        JLabel label_dato_borrado = new JLabel(texto_dato_borrado, SwingConstants.CENTER);
        label_dato_borrado.setFont(estilos.getFuenteConTamaio(20));
        layout.putConstraint(SpringLayout.WEST, label_dato_borrado, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_dato_borrado, 50, SpringLayout.NORTH, label_titulo_tarea);
        layout.putConstraint(SpringLayout.EAST, label_dato_borrado, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_dato_borrado);
            
        Boton bonton_borrar = new Boton(texto_boton_borrar);
        bonton_borrar.setBackground(estilos.getRojo());
        layout.putConstraint(SpringLayout.WEST, bonton_borrar, 300, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, bonton_borrar, 60, SpringLayout.NORTH, label_dato_borrado);
        panelPrincipal.add(bonton_borrar);
    }
}
