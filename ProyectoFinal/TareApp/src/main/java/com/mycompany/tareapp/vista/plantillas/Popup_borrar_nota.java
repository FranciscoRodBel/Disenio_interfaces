/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Lista_controlador;
import com.mycompany.tareapp.controlador.Nota_controlador;
import com.mycompany.tareapp.controlador.Usuario_controlador;
import com.mycompany.tareapp.modelo.idioma.Idioma;
import com.mycompany.tareapp.modelo.idioma.Pagina_notas;
import com.mycompany.tareapp.vista.Listas_view;
import com.mycompany.tareapp.vista.Main;
import com.mycompany.tareapp.vista.Notas_view;
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
 * Clase para el componente del popUp de borrar la nota
 * Componente creado para crearlo cuando se pulse en el icono de la papelera
 * 
 * @author Francisco
 */
public class Popup_borrar_nota extends JDialog {
    
    Usuario_controlador usuario_controlador = new Usuario_controlador();
    Nota_controlador nota_controlador = new Nota_controlador();
    Notas_view notas_view = Notas_view.recoger_instancia();
    
    JPanel panelPrincipal = new JPanel();
    
    JLabel label_resultado = new JLabel();

    /**
    * Constructor para generar el popUp y sus estilos
    * 
    */
    public Popup_borrar_nota(int idNota) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(800, 250));
        this.setLocationRelativeTo(null);
            
        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 250);
        panelPrincipal.setBackground(Estilos.getBlanco_claro());
        
        Pagina_notas idioma_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas();
       
        JLabel label_titulo_nota = new JLabel(idioma_notas.getBorrar_nota(), SwingConstants.CENTER);
        label_titulo_nota.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, label_titulo_nota, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_titulo_nota, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, label_titulo_nota, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_titulo_nota);
        
        JLabel label_pregunta_borrado = new JLabel(idioma_notas.getPregunta_borrar_nota(), SwingConstants.CENTER);
        label_pregunta_borrado.setFont(Estilos.getFuenteConTamaio(20));
        layout.putConstraint(SpringLayout.WEST, label_pregunta_borrado, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_pregunta_borrado, 50, SpringLayout.NORTH, label_titulo_nota);
        layout.putConstraint(SpringLayout.EAST, label_pregunta_borrado, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_pregunta_borrado);
        
        Boton bonton_borrar = new Boton(idioma_notas.getBorrar_nota(), "rojo");
        layout.putConstraint(SpringLayout.WEST, bonton_borrar, 300, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, bonton_borrar, 60, SpringLayout.NORTH, label_pregunta_borrado);
        panelPrincipal.add(bonton_borrar);
        
        label_resultado.setHorizontalAlignment(CENTER);
        label_resultado.setFont(Estilos.getFuenteConTamaio(14));
        layout.putConstraint(SpringLayout.WEST, label_resultado, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_resultado, 45, SpringLayout.NORTH, bonton_borrar);
        layout.putConstraint(SpringLayout.EAST, label_resultado, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_resultado);
        
        bonton_borrar.addActionListener((ActionEvent e) -> {
            
            String mensaje_resultado = nota_controlador.borrar_nota(idNota);

            if (mensaje_resultado.isEmpty()) { // Si lo borra muestra el mensaje

                mensaje_resultado = idioma_notas.getNota_borrada();

                notas_view.actualizar_panel_notas(); // Actualizo el panel de las notas
            }

            label_resultado.setText(mensaje_resultado);
            Timer tiempo_espera = new Timer(3000, evt -> label_resultado.setText(""));
            tiempo_espera.setRepeats(false);
            tiempo_espera.start();
        });
    }
}
