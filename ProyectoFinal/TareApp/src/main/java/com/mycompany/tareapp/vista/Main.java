/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.controlador.BBDD_controlador;
import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Usuario_controlador;
import com.mycompany.tareapp.vista.plantillas.Cabecera;
import com.mycompany.tareapp.vista.plantillas.Estilos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;

/**
 * Clase para la vista principal, ejecuta el programa
 * En esta clase se añaden las demás vistas y componentes
 * 
 * @author Francisco
 */
public class Main extends javax.swing.JFrame {

    static SpringLayout layout = new SpringLayout();
    
    static JPanel panelPrincipal = new JPanel();
    
    static Cabecera cabecera;
    static Iniciar_registrar_view iniciar_registrar_view;
    static Ajustes_cuenta_view ajustes_cuenta_view;
    static Listas_view listas_view;
    static Tareas_view tareas_view;
    static Notas_view notas_view;

    static ActionListener listenerTareas;
    static ActionListener listenerListas;
    static ActionListener listenerNotas;
    static ActionListener listenerAjustes;
    static ActionListener listenerCerrarSesion;
    Usuario_controlador usuario_controlador = new Usuario_controlador();
    
    /**
    * Constructor de la página de main, crea parte de la interfaz de la página
    * 
    */
    public Main() throws FileNotFoundException {
        initComponents();

        this.setLayout(null);
        this.setResizable(false);        
        this.add(panelPrincipal);
        this.setLocationRelativeTo(null);

        panelPrincipal.setBackground(Estilos.getGris_claro());
        panelPrincipal.setLayout(layout);
        panelPrincipal.setBounds(0, 0, 1000, 600);
        
        cabecera = Cabecera.recoger_instancia();
        iniciar_registrar_view = Iniciar_registrar_view.recoger_instancia();
        
        panelPrincipal.add(cabecera);
        layout.putConstraint(SpringLayout.WEST, cabecera, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, cabecera, 0, SpringLayout.NORTH, panelPrincipal);
        layout.putConstraint(SpringLayout.EAST, cabecera, 0, SpringLayout.EAST, panelPrincipal);
        
        panelPrincipal.add(iniciar_registrar_view);
        layout.putConstraint(SpringLayout.WEST, iniciar_registrar_view, 0, SpringLayout.WEST, cabecera);
        layout.putConstraint(SpringLayout.NORTH, iniciar_registrar_view, 45, SpringLayout.NORTH, cabecera);
        layout.putConstraint(SpringLayout.EAST, iniciar_registrar_view, 0, SpringLayout.EAST, cabecera);
        iniciar_registrar_view.setVisible(true);

        // Cambios de idiomas de la cabecera
        cabecera.getItemEspaniol().addActionListener((ActionEvent e) -> {
            
            Idioma_controlador.cambiarIdioma("Español");
            
            if (Usuario_controlador.getUsuario() != null) {
                
                listas_view.actualizar_panel_lista();
                tareas_view.actualizar_panel_tareas();
                
                usuario_controlador.actualizar_idioma("Español");
            }
        });
        
        cabecera.getItemIngles().addActionListener((ActionEvent e) -> {
            
            Idioma_controlador.cambiarIdioma("English");
            
            if (Usuario_controlador.getUsuario() != null) {
                
                listas_view.actualizar_panel_lista();
                tareas_view.actualizar_panel_tareas();
                
                usuario_controlador.actualizar_idioma("English");
            }
        });
                
        cabecera.getItemFrances().addActionListener((ActionEvent e) -> {
            
            Idioma_controlador.cambiarIdioma("Français");
            
            if (Usuario_controlador.getUsuario() != null) {
                
                listas_view.actualizar_panel_lista();
                tareas_view.actualizar_panel_tareas();
                
                usuario_controlador.actualizar_idioma("Français");
            }
        });
    }
        
   /**
    * Método que permite generar las interfaces de las páginas donde el usuario puede interactuar
    * Este método se crea ya que estos paneles solo se pueden crear cuand oel usuario inicie sesión
    * 
    */
    public static void generarInterfaz() {
        
        iniciar_registrar_view.setVisible(false);
        
        ajustes_cuenta_view = Ajustes_cuenta_view.recoger_instancia();
        listas_view = Listas_view.recoger_instancia();
        tareas_view = Tareas_view.recoger_instancia();
        notas_view = Notas_view.recoger_instancia();
        
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
        
        panelPrincipal.add(notas_view);
        layout.putConstraint(SpringLayout.WEST, notas_view, 0, SpringLayout.WEST, cabecera);
        layout.putConstraint(SpringLayout.NORTH, notas_view, 45, SpringLayout.NORTH, cabecera);
        layout.putConstraint(SpringLayout.EAST, notas_view, 0, SpringLayout.EAST, cabecera);
        notas_view.setVisible(false);

        panelPrincipal.add(ajustes_cuenta_view);
        layout.putConstraint(SpringLayout.WEST, ajustes_cuenta_view, 0, SpringLayout.WEST, cabecera);
        layout.putConstraint(SpringLayout.NORTH, ajustes_cuenta_view, 45, SpringLayout.NORTH, cabecera);
        layout.putConstraint(SpringLayout.EAST, ajustes_cuenta_view, 0, SpringLayout.EAST, cabecera);
        ajustes_cuenta_view.setVisible(false);
        
        // Se crean los listeners por separado ya que cuando cierra sesión o borra la cuenta necesito borrar los listeners
        listenerTareas = (ActionEvent e) -> {
            ocultarPaneles();
            tareas_view.setVisible(true);
        };

        listenerListas = (ActionEvent e) -> {
            ocultarPaneles();
            listas_view.setVisible(true);
        };
        
        listenerNotas = (ActionEvent e) -> {
            ocultarPaneles();
            notas_view.setVisible(true);
        };

        listenerAjustes = (ActionEvent e) -> {
            ocultarPaneles();
            ajustes_cuenta_view.setVisible(true);
        };
        
        listenerCerrarSesion = (ActionEvent e) -> {

            cerrarSesion();
        };  
        
        cabecera.getItemTareas().addActionListener(listenerTareas);
        cabecera.getItemListas().addActionListener(listenerListas);
        cabecera.getItemNotas().addActionListener(listenerNotas);
        cabecera.getItemAjustes().addActionListener(listenerAjustes);
        cabecera.getItemCerrarSesion().addActionListener(listenerCerrarSesion);
    }
    
    /**
    * Método que permite reiniciar los paneles al estado que estaban antes de iniciar sesión
    * 
    */
    public static void cerrarSesion() {
    
        // Borro los paneles
        panelPrincipal.remove(ajustes_cuenta_view);
        panelPrincipal.remove(listas_view);
        panelPrincipal.remove(notas_view);
        panelPrincipal.remove(tareas_view);
        Usuario_controlador.setUsuario(null); // pongo el usuario que tiene la sesión iniciada como null

        // Pongo los paneles como null, para que cuando inicie sesión se creen de nuevo
        Listas_view.reiniciar_instancia();
        Tareas_view.reiniciar_instancia();
        Notas_view.reiniciar_instancia();
        Ajustes_cuenta_view.reiniciar_instancia();

        // Oculto los paneles y muestro el inicio y registro
        ocultarPaneles();
        iniciar_registrar_view.setVisible(true);

        // Elimino los listeners
        cabecera.getItemTareas().removeActionListener(listenerTareas);
        cabecera.getItemListas().removeActionListener(listenerListas);
        cabecera.getItemNotas().removeActionListener(listenerNotas);
        cabecera.getItemAjustes().removeActionListener(listenerAjustes);
        cabecera.getItemCerrarSesion().removeActionListener(listenerCerrarSesion);
    }
    
    /**
    * Método que pone todos los paneles en oculto, para luego mostrar el que se quiere tener en pantalla
    * 
    */
    public static void ocultarPaneles() {
    
        tareas_view.setVisible(false);
        listas_view.setVisible(false);
        notas_view.setVisible(false);
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
            @Override
            public void run() {
                try {
                    
                    BBDD_controlador.abrirConexion();
                    
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
