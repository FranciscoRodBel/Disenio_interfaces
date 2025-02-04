/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Lista_controlador;
import com.mycompany.tareapp.controlador.Usuario_controlador;
import com.mycompany.tareapp.modelo.idioma.Idioma;
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
public class Popup_borrar_cuenta_lista extends JDialog {
    
    Usuario_controlador usuario_controlador = new Usuario_controlador();
    Lista_controlador lista_controlador = new Lista_controlador();
    Listas_view listas_view = Listas_view.recoger_instancia();
    Tareas_view tareas_view = Tareas_view.recoger_instancia();
    
    JPanel panelPrincipal = new JPanel();
    
    String texto_pregunta_confirmacion;
    String texto_boton_borrar;
    
    String dato_borrar;
    
    JLabel label_resultado = new JLabel();

    public Popup_borrar_cuenta_lista(int idLista, String dato_mostrar, String tipo_popup) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.dato_borrar = dato_borrar;
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(800, 250));
        this.setLocationRelativeTo(null);
            
        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 250);
        panelPrincipal.setBackground(Estilos.getBlanco_claro());
        
        Idioma idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado();
        
        if (tipo_popup.equals("cuenta")) {
            
            texto_pregunta_confirmacion = idioma_seleccionado.getPagina_ajustes_cuenta().getPregunta_borrar_cuenta();
            texto_boton_borrar = idioma_seleccionado.getPagina_ajustes_cuenta().getBorrar_cuenta();
            
        } else {
        
            texto_pregunta_confirmacion = idioma_seleccionado.getPagina_listas().getPregunta_borrar_lista();
            texto_boton_borrar = idioma_seleccionado.getPagina_listas().getBorrar_lista();
        }
        
        JLabel label_titulo_tarea = new JLabel(texto_pregunta_confirmacion, SwingConstants.CENTER);
        label_titulo_tarea.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, label_titulo_tarea, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_titulo_tarea, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, label_titulo_tarea, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_titulo_tarea);
        
        JLabel label_dato_borrado = new JLabel(dato_mostrar, SwingConstants.CENTER);
        label_dato_borrado.setFont(Estilos.getFuenteConTamaio(20));
        layout.putConstraint(SpringLayout.WEST, label_dato_borrado, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_dato_borrado, 50, SpringLayout.NORTH, label_titulo_tarea);
        layout.putConstraint(SpringLayout.EAST, label_dato_borrado, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_dato_borrado);
            
        Boton bonton_borrar = new Boton(texto_boton_borrar, "rojo");
        layout.putConstraint(SpringLayout.WEST, bonton_borrar, 300, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, bonton_borrar, 60, SpringLayout.NORTH, label_dato_borrado);
        panelPrincipal.add(bonton_borrar);
        
        label_resultado.setHorizontalAlignment(CENTER);
        label_resultado.setFont(Estilos.getFuenteConTamaio(14));
        layout.putConstraint(SpringLayout.WEST, label_resultado, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_resultado, 45, SpringLayout.NORTH, bonton_borrar);
        layout.putConstraint(SpringLayout.EAST, label_resultado, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_resultado);
        
        bonton_borrar.addActionListener((ActionEvent e) -> {

            String mensaje_resultado = "";
            
            if (tipo_popup.equals("cuenta")) {

                mensaje_resultado = usuario_controlador.borrar_usuario();

                if (mensaje_resultado.isEmpty()) {

                    mensaje_resultado = idioma_seleccionado.getPagina_ajustes_cuenta().getCuenta_borrada();
                } 

            } else {

                mensaje_resultado = lista_controlador.borrar_lista(idLista);

                if (mensaje_resultado.isEmpty()) {

                    mensaje_resultado = idioma_seleccionado.getPagina_listas().getLista_borrada();
                    listas_view.actualizar_panel_lista();
                    tareas_view.actualizar_select_listas();
                    tareas_view.actualizar_panel_tareas();
                } 
            }
            
            label_resultado.setText(mensaje_resultado);
            Timer tiempo_espera = new Timer(3000, evt -> label_resultado.setText(""));
            tiempo_espera.setRepeats(false);
            tiempo_espera.start();
        });
    }
}
