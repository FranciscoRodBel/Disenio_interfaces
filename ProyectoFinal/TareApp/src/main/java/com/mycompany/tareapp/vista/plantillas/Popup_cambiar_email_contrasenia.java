/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.modelo.idioma.Idioma;
import com.mycompany.tareapp.modelo.idioma.Pagina_ajustes_cuenta;
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
public class Popup_cambiar_email_contrasenia extends JDialog {
    
    JPanel panelPrincipal = new JPanel();
    
    String texto_titulo_popup;
    String texto_input_nuevo;
    String texto_input_repetir;

    public Popup_cambiar_email_contrasenia(String tipo_popup) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(800, 280));
        this.setLocationRelativeTo(null);
        
        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 280);
        panelPrincipal.setBackground(Estilos.getGris_claro());
        
        Pagina_ajustes_cuenta idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta();
        
        if (tipo_popup.equals("email")) {
            
            texto_titulo_popup = idioma_seleccionado.getCambiar_email();
            texto_input_nuevo = idioma_seleccionado.getNuevo_email();
            texto_input_repetir = idioma_seleccionado.getRepetir_email();
            
        } else {
        
            texto_titulo_popup = idioma_seleccionado.getCambiar_contrasenia();
            texto_input_nuevo = idioma_seleccionado.getNuevo_contrasenia();
            texto_input_repetir = idioma_seleccionado.getRepetir_contrasenia();
        }
        
        JLabel labelTitulo = new JLabel(texto_titulo_popup, SwingConstants.CENTER);
        labelTitulo.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, labelTitulo, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelTitulo, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, labelTitulo, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(labelTitulo);
        
        Input_text input_nuevo = new Input_text(texto_input_nuevo, "");
        layout.putConstraint(SpringLayout.WEST, input_nuevo, 270, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, input_nuevo, 40, SpringLayout.NORTH, labelTitulo);
        panelPrincipal.add(input_nuevo);
        
        Input_text input_repetir = new Input_text(texto_input_repetir, "");
        layout.putConstraint(SpringLayout.WEST, input_repetir, 270, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, input_repetir, 60, SpringLayout.NORTH, input_nuevo);
        panelPrincipal.add(input_repetir);
        
        Boton bonton_crear = new Boton(texto_titulo_popup);
        layout.putConstraint(SpringLayout.WEST, bonton_crear, 300, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, bonton_crear, 60, SpringLayout.NORTH, input_repetir);
        panelPrincipal.add(bonton_crear);
    }
}
