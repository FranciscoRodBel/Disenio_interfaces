/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Usuario_controlador;
import com.mycompany.tareapp.modelo.idioma.Pagina_ajustes_cuenta;
import com.mycompany.tareapp.vista.Ajustes_cuenta_view;
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
public class Popup_cambiar_email_contrasenia extends JDialog {
    
    Ajustes_cuenta_view ajustes_cuenta_view = Ajustes_cuenta_view.recoger_instancia();
    Usuario_controlador usuario_controlador = new Usuario_controlador();
    JPanel panelPrincipal = new JPanel();
    
    String texto_titulo_popup;
    String texto_input_nuevo;
    String texto_input_repetir;
    JLabel label_resultado;

    public Popup_cambiar_email_contrasenia(String tipo_popup) {
        
        super((Window) null, "PopUp", ModalityType.APPLICATION_MODAL);
        
        this.setLayout(null);
        this.setResizable(false);  
        this.setSize(new Dimension(800, 300));
        this.setLocationRelativeTo(null);
        
        this.add(panelPrincipal);
        SpringLayout layout = new SpringLayout();
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 800, 300);
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
        
        Boton bonton_cambiar = new Boton(texto_titulo_popup);
        layout.putConstraint(SpringLayout.WEST, bonton_cambiar, 300, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, bonton_cambiar, 60, SpringLayout.NORTH, input_repetir);
        panelPrincipal.add(bonton_cambiar);
        
        label_resultado = new JLabel("");
        label_resultado.setHorizontalAlignment(CENTER);
        label_resultado.setFont(Estilos.getFuenteConTamaio(14));
        layout.putConstraint(SpringLayout.WEST, label_resultado, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_resultado, 45, SpringLayout.NORTH, bonton_cambiar);
        layout.putConstraint(SpringLayout.EAST, label_resultado, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_resultado);
        
        bonton_cambiar.addActionListener((ActionEvent e1) -> {
            
            String mensaje_resultado = "";
            String texto_input_nuevo = input_nuevo.getText();
            String texto_input_repetir = input_repetir.getText();
            
            if (tipo_popup.equals("email")) {


                mensaje_resultado = usuario_controlador.actualizar_email(texto_input_nuevo, texto_input_repetir);

                if (mensaje_resultado.isEmpty()) {

                    mensaje_resultado = "Email actualizado";    
                    ajustes_cuenta_view.getLabel_email_usuario().setText(texto_input_nuevo);          
                }
                

            } else {

               mensaje_resultado = usuario_controlador.actualizar_contrasenia(texto_input_nuevo, texto_input_repetir);

                if (mensaje_resultado.isEmpty()) {

                    mensaje_resultado = "Contraseña actualizado";              
                }
                
            }
            
            label_resultado.setText(mensaje_resultado);
            Timer tiempo_espera = new Timer(3000, evt -> label_resultado.setText(""));
            tiempo_espera.setRepeats(false);
            tiempo_espera.start();

        });
    }
}
