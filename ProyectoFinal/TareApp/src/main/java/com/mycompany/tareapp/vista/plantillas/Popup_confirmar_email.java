/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Usuario_controlador;
import com.mycompany.tareapp.modelo.idioma.Pagina_ajustes_cuenta;
import com.mycompany.tareapp.modelo.idioma.Pagina_inicio_registro;
import com.mycompany.tareapp.vista.Ajustes_cuenta_view;
import com.mycompany.tareapp.vista.Iniciar_registrar_view;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import static javax.swing.SwingConstants.CENTER;
import javax.swing.Timer;

/**
 * Clase para el componente del popUp de actualizar email y contraseña
 * Componente creado para crearlo cuando se pulse en el botón o icono concreto
 * 
 * @author Francisco
 */
public class Popup_confirmar_email extends JDialog {
    
    String idioma_seleccionado = Idioma_controlador.getIdioma_seleccionado().getIdioma();
    Pagina_inicio_registro pagina_inicio_registro =  Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();
    Pagina_ajustes_cuenta idioma_ajustes = Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta();
    Usuario_controlador usuario_controlador = new Usuario_controlador();
    
    JPanel panelPrincipal = new JPanel();
    
    JLabel label_resultado = new JLabel("");
    
    int codigo = 999999;

    /**
    * Constructor del PopUp con los estilos necesarios
    * 
    */
    public Popup_confirmar_email(String email,String contrasenia,String repetir_contrasenia) {
        
        
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
        
        
        JLabel labelTitulo = new JLabel(pagina_inicio_registro.getConfirmar_email(), SwingConstants.CENTER);
        labelTitulo.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, labelTitulo, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelTitulo, 20, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, labelTitulo, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(labelTitulo);
        
        JLabel labelMensajeCodigo = new JLabel(pagina_inicio_registro.getIntroduzca_codigo(), SwingConstants.CENTER);
        labelMensajeCodigo.setFont(Estilos.getFuenteConTamaio(16));
        layout.putConstraint(SpringLayout.WEST, labelMensajeCodigo, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, labelMensajeCodigo, 40, SpringLayout.NORTH, labelTitulo);
        layout.putConstraint(SpringLayout.EAST, labelMensajeCodigo, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(labelMensajeCodigo);
        
        Input_Number input_codigo = new Input_Number();
        layout.putConstraint(SpringLayout.WEST, input_codigo, 250, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, input_codigo, 40, SpringLayout.NORTH, labelMensajeCodigo);
        panelPrincipal.add(input_codigo);
        
        Boton bonton_enviar = new Boton(pagina_inicio_registro.getEnviar_codigo(), "amarillo");
        layout.putConstraint(SpringLayout.WEST, bonton_enviar, 100, SpringLayout.WEST, input_codigo);
        layout.putConstraint(SpringLayout.NORTH, bonton_enviar, 0, SpringLayout.NORTH, input_codigo);
        panelPrincipal.add(bonton_enviar);
        
        Boton bonton_confirmar = new Boton(pagina_inicio_registro.getConfirmar_email(), "amarillo");
        layout.putConstraint(SpringLayout.WEST, bonton_confirmar, 300, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, bonton_confirmar, 60, SpringLayout.NORTH, input_codigo);
        panelPrincipal.add(bonton_confirmar);
        
        label_resultado.setHorizontalAlignment(CENTER);
        label_resultado.setFont(Estilos.getFuenteConTamaio(14));
        layout.putConstraint(SpringLayout.WEST, label_resultado, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, label_resultado, 45, SpringLayout.NORTH, bonton_confirmar);
        layout.putConstraint(SpringLayout.EAST, label_resultado, 0, SpringLayout.EAST, panelPrincipal);
        panelPrincipal.add(label_resultado);
        
        bonton_enviar.addActionListener((ActionEvent e1) -> {
            
            bonton_enviar.setEnabled(false); // Deshabilita el botón
            label_resultado.setText(pagina_inicio_registro.getEnviando_codigo());

            new Thread(() -> {
                try {
                    
                    codigo = 10000 + new Random().nextInt(90000); // Genera el código aleatorio
                    String mensaje_resultado = usuario_controlador.confirmar_email(email, codigo); // Envía el email

                    Thread.sleep(3000); 

                    javax.swing.SwingUtilities.invokeLater(() -> {
                        
                        label_resultado.setText(mensaje_resultado);
                        Timer tiempo_espera = new Timer(3000, evt -> label_resultado.setText(""));
                        tiempo_espera.setRepeats(false);
                        tiempo_espera.start();
                    });

                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }).start();

            // Reactiva el botón después de 30 segundos
            Timer timer_reactivacion = new Timer(30000, evt -> bonton_enviar.setEnabled(true));
            timer_reactivacion.setRepeats(false);
            timer_reactivacion.start();
        });
        
        bonton_confirmar.addActionListener((ActionEvent e1) -> {
            
            String mensaje_resultado = "";
            int numero_enviado = 0;
            
            try {
                
                numero_enviado = Integer.parseInt(input_codigo.getText()); // Convierto el string a int
                
            } catch (Exception e) {}
            
            if (codigo == numero_enviado) { // Si añade el código correcto...

                if (contrasenia != null) { // Si hay contraseña es que se está registrando
                
                    mensaje_resultado = usuario_controlador.registrar_usuario(email, contrasenia, repetir_contrasenia, idioma_seleccionado);  // Crea la cuenta

                    if (mensaje_resultado.isEmpty()){ // Si está vacío se creó la cuenta correctamente

                        mensaje_resultado = pagina_inicio_registro.getCuenta_creada();
                        
                        Iniciar_registrar_view iniciar_registrar_view = Iniciar_registrar_view.recoger_instancia();
                        
                        iniciar_registrar_view.getEmail_registro().setText("");
                        iniciar_registrar_view.getContrasenia_registro().setText("");
                        iniciar_registrar_view.getRepetir_contrasenia_registro().setText("");
                    }
                    
                } else { // Si no hay contraseña es que se está actualizando el email
                
                    mensaje_resultado = usuario_controlador.actualizar_email(email); // Actualiza el email

                    if (mensaje_resultado.isEmpty()) { // Si está vacío se actualizó el email correctamente
                        
                        mensaje_resultado = idioma_ajustes.getEmail_actualizado();    
                        Ajustes_cuenta_view.recoger_instancia().getLabel_email_usuario().setText(email);          
                    }
                }
                
                label_resultado.setText(mensaje_resultado);
                Timer tiempo_espera = new Timer(1000, evt -> { // Cierro el PopUp después de confirmar el email
                    dispose();
                });
                tiempo_espera.setRepeats(false);
                tiempo_espera.start();
                
            } else { // Si el código no es correcto muestro el mensaje de error
            
                mensaje_resultado = pagina_inicio_registro.getCodigo_incorrecto();
                
                label_resultado.setText(mensaje_resultado);
                Timer tiempo_espera = new Timer(1000, evt -> label_resultado.setText(""));
                tiempo_espera.setRepeats(false);
                tiempo_espera.start();
            }
        });
    }
}
