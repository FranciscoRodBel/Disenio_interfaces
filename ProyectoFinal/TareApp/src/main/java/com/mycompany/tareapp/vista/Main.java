/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.modelo.Usuario;
import com.mycompany.tareapp.vista.plantillas.Cabecera;
import com.mycompany.tareapp.vista.plantillas.Estilos;
import com.mycompany.tareapp.vista.plantillas.Lista_plantilla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.Timer;

/**
 *
 * @author FranciscoRB
 */
public class Main extends javax.swing.JFrame {

    Usuario usuario = Usuario.recoger_usuario("franciscoRB@franciscoRB.com");
    
    Idioma_controlador idioma_controlador;
    JPanel panelPrincipal = new JPanel();
    
    SpringLayout layout = new SpringLayout();
        
    Cabecera cabecera = new Cabecera();
    
    Tareas_view tareas_view = new Tareas_view(usuario);
    
    Iniciar_registrar_view iniciar_registrar_view = new Iniciar_registrar_view();
    
    Listas_view listas_view;
    
    Ajustes_cuenta_view ajustes_cuenta_view = new Ajustes_cuenta_view();
    
    
    public Idioma_controlador getIdioma_controlador() {
        return idioma_controlador;
    }

    public void setIdioma_controlador(Idioma_controlador idioma_controlador) {
        this.idioma_controlador = idioma_controlador;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Main() throws FileNotFoundException {
        initComponents();
     
        idioma_controlador = new Idioma_controlador();

        this.setLayout(null);
        this.setResizable(false);        
        this.add(panelPrincipal);
        this.setLocationRelativeTo(null);
        
        panelPrincipal.setBackground(Estilos.getGris_claro());
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 1000, 600);
        
        panelPrincipal.add(cabecera);
        layout.putConstraint(SpringLayout.WEST, cabecera, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, cabecera, 0, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, cabecera, 0, SpringLayout.EAST, panelPrincipal);
        
        panelPrincipal.add(iniciar_registrar_view);
        layout.putConstraint(SpringLayout.WEST, iniciar_registrar_view, 0, SpringLayout.WEST, cabecera);
        layout.putConstraint(SpringLayout.NORTH, iniciar_registrar_view, 45, SpringLayout.NORTH, cabecera);
        layout.putConstraint(SpringLayout.EAST, iniciar_registrar_view, 0, SpringLayout.EAST, cabecera);
        iniciar_registrar_view.setVisible(false);
        
        iniciar_registrar_view.getBoton_enviar_inicio().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                String email = iniciar_registrar_view.getEmail_iniciar().getText();
                String contrasenia = new String(iniciar_registrar_view.contrasenia_iniciar.getPassword());
                
                String mensaje_resultado = iniciar_registrar_view.getUsuario_controlador().iniciar_usuario(email, contrasenia);
                
                if (mensaje_resultado.isEmpty()) {
                    
                    usuario = Usuario.recoger_usuario(email);
                    //generarInterfaz();
                    
                } else {
                    
                    iniciar_registrar_view.getLabel_resultado_inicio().setText(mensaje_resultado);
                    Timer tiempo_espera = new Timer(3000, evt -> iniciar_registrar_view.getLabel_resultado_inicio().setText(""));
                    tiempo_espera.setRepeats(false);
                    tiempo_espera.start();
                }
            }
        });
       
        generarInterfaz();
        
        idioma_controlador.cambiarIdioma(usuario.getIdioma_seleccionado(), cabecera, tareas_view, listas_view, iniciar_registrar_view, ajustes_cuenta_view);
        

        
        cabecera.getItemEspaniol().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                idioma_controlador.cambiarIdioma("Español", cabecera, tareas_view, listas_view, iniciar_registrar_view, ajustes_cuenta_view);
            }
        });
        
        cabecera.getItemIngles().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                idioma_controlador.cambiarIdioma("English", cabecera, tareas_view, listas_view, iniciar_registrar_view, ajustes_cuenta_view);
            }
        });
                
        cabecera.getItemFrances().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            
                idioma_controlador.cambiarIdioma("Français", cabecera, tareas_view, listas_view, iniciar_registrar_view, ajustes_cuenta_view);
            }
        });
    }
    
    public void generarInterfaz() {
        
        listas_view = new Listas_view(usuario);
        
        panelPrincipal.add(tareas_view);
        layout.putConstraint(SpringLayout.WEST, tareas_view, 0, SpringLayout.WEST, cabecera);
        layout.putConstraint(SpringLayout.NORTH, tareas_view, 45, SpringLayout.NORTH, cabecera);
        layout.putConstraint(SpringLayout.EAST, tareas_view, 0, SpringLayout.EAST, cabecera);
        tareas_view.setVisible(true);
        
        panelPrincipal.add(listas_view);
        layout.putConstraint(SpringLayout.WEST, listas_view, 0, SpringLayout.WEST, cabecera);
        layout.putConstraint(SpringLayout.NORTH, listas_view, 45, SpringLayout.NORTH, cabecera);
        layout.putConstraint(SpringLayout.EAST, listas_view, 0, SpringLayout.EAST, cabecera);
        listas_view.setVisible(false);

        panelPrincipal.add(ajustes_cuenta_view);
        layout.putConstraint(SpringLayout.WEST, ajustes_cuenta_view, 0, SpringLayout.WEST, cabecera);
        layout.putConstraint(SpringLayout.NORTH, ajustes_cuenta_view, 45, SpringLayout.NORTH, cabecera);
        layout.putConstraint(SpringLayout.EAST, ajustes_cuenta_view, 0, SpringLayout.EAST, cabecera);
        ajustes_cuenta_view.setVisible(false);
        
        
        cabecera.getItemTareas().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                ocultarPaneles();
                tareas_view.setVisible(true);
            }
        });
        
        cabecera.getItemListas().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                ocultarPaneles();
                listas_view.setVisible(true);  
            }
        });
            
        cabecera.getItemAjustes().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
            
                ocultarPaneles();
                ajustes_cuenta_view.setVisible(true);
            }
        });    
                
        cabecera.getItemCerrarSesion().addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                ocultarPaneles();
                iniciar_registrar_view.setVisible(true);
            }
        });
    }

    public void ocultarPaneles() {
    
        tareas_view.setVisible(false);
        listas_view.setVisible(false);
        iniciar_registrar_view.setVisible(false);
        ajustes_cuenta_view.setVisible(false);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
