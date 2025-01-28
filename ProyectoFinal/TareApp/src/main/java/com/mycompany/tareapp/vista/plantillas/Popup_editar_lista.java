/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Lista_controlador;
import com.mycompany.tareapp.modelo.idioma.Pagina_listas;
import com.mycompany.tareapp.vista.Listas_view;
import com.mycompany.tareapp.vista.Tareas_view;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.Timer;

/**
 *
 * @author Propietario
 */
public class Popup_editar_lista extends JDialog {
    
    Lista_controlador lista_controlador = new Lista_controlador();
    Listas_view listas_view = Listas_view.recoger_instancia();
    Tareas_view tareas_view = Tareas_view.recoger_instancia();
    
    JPanel panelPrincipal = new JPanel();
    Input_text input_titulo_terea;
    JLabel label_resultado_lista = new JLabel("");
        
    public Popup_editar_lista(Lista_plantilla lista) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(600, 250));
        this.setLocationRelativeTo(null);

        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 600, 250);
        panelPrincipal.setBackground(Estilos.getGris_claro());
        
        Pagina_listas idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado().getPagina_listas();
        
        JLabel labelTitulo = new JLabel(idioma_seleccionado.getEditar_lista(), SwingConstants.CENTER);
        labelTitulo.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, labelTitulo, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelTitulo, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, labelTitulo, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(labelTitulo);
        
        input_titulo_terea = new Input_text(idioma_seleccionado.getTitulo_lista(), lista.getTitulo_lista().getText());
        input_titulo_terea.setPreferredSize(new Dimension(350, 35));
        layout.putConstraint(SpringLayout.WEST, input_titulo_terea, 125, SpringLayout.WEST, labelTitulo);
        layout.putConstraint(SpringLayout.NORTH, input_titulo_terea, 50, SpringLayout.NORTH, labelTitulo);
        panelPrincipal.add(input_titulo_terea);
        
        Boton bonton_editar = new Boton(idioma_seleccionado.getEditar_lista());
        layout.putConstraint(SpringLayout.WEST, bonton_editar, 200, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, bonton_editar, 60, SpringLayout.NORTH, input_titulo_terea);
        panelPrincipal.add(bonton_editar);
        
        label_resultado_lista.setHorizontalAlignment(CENTER);
        label_resultado_lista.setFont(Estilos.getFuenteConTamaio(14));
        layout.putConstraint(SpringLayout.WEST, label_resultado_lista, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_resultado_lista, 45, SpringLayout.NORTH, bonton_editar);
        layout.putConstraint(SpringLayout.EAST, label_resultado_lista, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_resultado_lista);
        
        bonton_editar.addActionListener((ActionEvent e) -> {

            String mensaje_resultado = lista_controlador.actualizar_lista(lista.idLista, input_titulo_terea.getText());

            if (mensaje_resultado.isEmpty()) {

                mensaje_resultado = idioma_seleccionado.getLista_editada();
                tareas_view.actualizar_select_listas();
                listas_view.actualizar_panel_lista();
            }

            label_resultado_lista.setText(mensaje_resultado);
            Timer tiempo_espera = new Timer(3000, evt -> label_resultado_lista.setText(""));
            tiempo_espera.setRepeats(false);
            tiempo_espera.start();
        });
    }
}
