/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.modelo.idioma.Pagina_listas;
import com.mycompany.tareapp.modelo.idioma.Pagina_tareas;
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
public class Popup_editar_lista extends JDialog {
    
    JPanel panelPrincipal = new JPanel();

    public Popup_editar_lista(Lista lista) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(600, 230));
        this.setLocationRelativeTo(null);

        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 600, 230);
        panelPrincipal.setBackground(Estilos.getGris_claro());
        
        Pagina_listas idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado().getPagina_listas();
        
        JLabel labelTitulo = new JLabel(idioma_seleccionado.getEditar_lista(), SwingConstants.CENTER);
        labelTitulo.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, labelTitulo, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelTitulo, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, labelTitulo, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(labelTitulo);
        
        Input_text input_titulo_terea = new Input_text(idioma_seleccionado.getTitulo_lista(), lista.getTitulo_lista().getText());
        input_titulo_terea.setPreferredSize(new Dimension(350, 35));
        layout.putConstraint(SpringLayout.WEST, input_titulo_terea, 125, SpringLayout.WEST, labelTitulo);
        layout.putConstraint(SpringLayout.NORTH, input_titulo_terea, 50, SpringLayout.NORTH, labelTitulo);
        panelPrincipal.add(input_titulo_terea);
        
        Boton bonton_editar = new Boton(idioma_seleccionado.getEditar_lista());
        layout.putConstraint(SpringLayout.WEST, bonton_editar, 200, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, bonton_editar, 60, SpringLayout.NORTH, input_titulo_terea);
        panelPrincipal.add(bonton_editar);
    }
}
