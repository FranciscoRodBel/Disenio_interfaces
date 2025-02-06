/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Lista_controlador;
import com.mycompany.tareapp.vista.plantillas.Estilos;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import com.mycompany.tareapp.vista.plantillas.Input_text;
import com.mycompany.tareapp.vista.plantillas.Lista_plantilla;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.Timer;

/**
 * Clase para la vista de la página de inicio de sesión y registro
 * En esta clase el usuario puede crear su usuario e iniciar sesión
 * 
 * @author Francisco
 */
public class Listas_view extends javax.swing.JPanel {
    
    static Listas_view listas_view;
    
    Lista_controlador lista_controlador = new Lista_controlador();

    Tareas_view tareas_view = Tareas_view.recoger_instancia();
    
    JPanel panel_lista = new JPanel();
    JScrollPane scroll_panel_lista = new JScrollPane(panel_lista);
    
    JLabel titulo_pagina = new JLabel("Listas");
    Input_text input_titulo_lista = new Input_text("Título lista", "");
    JButton boton_insertar_lista = new JButton();
    JLabel label_resultado_lista = new JLabel();
    
   /**
    * Constructor de la página de listas, crea toda la interfaz de la página
    * 
    */
    public Listas_view() {
        initComponents();
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(1000, 555));
        this.setMaximumSize(new Dimension(1000, 555));
        this.setBackground(Estilos.getGris_claro());
        
        this.add(titulo_pagina);
        titulo_pagina.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_pagina.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, titulo_pagina, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, titulo_pagina, 30, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, titulo_pagina, 0, SpringLayout.EAST, this);
        
        this.add(input_titulo_lista);
        layout.putConstraint(SpringLayout.WEST, input_titulo_lista, 350, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, input_titulo_lista, 50, SpringLayout.NORTH, titulo_pagina);
        
        boton_insertar_lista.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-plus-solid.png"));
        this.add(boton_insertar_lista);
        boton_insertar_lista.setPreferredSize(new Dimension(40, 40));
        boton_insertar_lista.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, boton_insertar_lista, 620, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, boton_insertar_lista, 47, SpringLayout.NORTH, titulo_pagina);
        boton_insertar_lista.setToolTipText("Crear lista");
        
        this.add(label_resultado_lista);
        label_resultado_lista.setHorizontalAlignment(SwingConstants.CENTER);
        label_resultado_lista.setFont(Estilos.getFuenteConTamaio(12));
        layout.putConstraint(SpringLayout.WEST, label_resultado_lista, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, label_resultado_lista, 50, SpringLayout.NORTH, input_titulo_lista);
        layout.putConstraint(SpringLayout.EAST, label_resultado_lista, 0, SpringLayout.EAST, this);
        
        panel_lista.setLayout(new BoxLayout(panel_lista, BoxLayout.Y_AXIS)); // Para colocar una tarea debajo de otra
        panel_lista.setBackground(Estilos.getGris_claro());
        
        scroll_panel_lista.setPreferredSize(new Dimension(615, 350));
        scroll_panel_lista.getVerticalScrollBar().setUnitIncrement(15); // Para aumentar la velocidad de la barra de scroll
        scroll_panel_lista.setBorder(null);
        this.add(scroll_panel_lista);
        layout.putConstraint(SpringLayout.WEST, scroll_panel_lista, 200, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, scroll_panel_lista, 80, SpringLayout.NORTH, input_titulo_lista);
        
        actualizar_panel_lista();
        
        boton_insertar_lista.addActionListener((ActionEvent e) -> {
            
            String mensaje_resultado = lista_controlador.crear_lista(input_titulo_lista.getText());
            
            if (mensaje_resultado.isEmpty()) {
                
                mensaje_resultado = Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_creada();
                input_titulo_lista.setText("");
                actualizar_panel_lista();
                tareas_view.actualizar_select_listas();
            }
            
            label_resultado_lista.setText(mensaje_resultado);
            Timer tiempo_espera = new Timer(3000, evt -> label_resultado_lista.setText(""));
            tiempo_espera.setRepeats(false);
            tiempo_espera.start();
        });
    }

    public JLabel getTitulo_pagina() {
        return titulo_pagina;
    }

    public void setTitulo_pagina(JLabel titulo_pagina) {
        this.titulo_pagina = titulo_pagina;
    }
    
    public Input_text getInput_titulo_lista() {
        return input_titulo_lista;
    }

    public void setInput_titulo_lista(Input_text input_titulo_lista) {
        this.input_titulo_lista = input_titulo_lista;
    }

    /**
    * Función que permite actualizar el panel donde se muestran todas las listas del usuario en la página de listas
    * 
    */
    public void actualizar_panel_lista() {
        
        panel_lista.setVisible(false); // Lo pongo en false para que luego al ponerlo true se actualice visualmente
        panel_lista.removeAll(); // Borro todas las listas
    
        ArrayList<HashMap<String, Object>> listas = Lista_controlador.recoger_listas(); // Recojo las listas
        
        if (listas != null) { // Si hay listas...
            
            for(HashMap<String, Object> fila : listas) { // Las recorro y las añado al panel
        
                int idLista = (int) fila.get("idLista");
                String titulo = (String) fila.get("titulo");

                Lista_plantilla lista_plantilla = new Lista_plantilla(idLista, titulo);
                lista_plantilla.setMaximumSize(new Dimension(600, 50)); // Si no pongo el máximo se estíran las tareas para ocupar todo el panel
                lista_plantilla.setMinimumSize(new Dimension(600, 50)); // Si no pongo el mínimo ocupan la mitad del ancho del panel

                panel_lista.add(lista_plantilla);
            }
        }
        
        panel_lista.setVisible(true);
        panel_lista.revalidate();
        panel_lista.repaint();
    }
       
    /**
    * Función que permite recoger la clase como si fuese estática
    * 
    * @return Devuelve un objeto de la propia clase
    */
    public static Listas_view recoger_instancia() {
        
        if (Listas_view.listas_view == null) {
            
            Listas_view.listas_view = new Listas_view();
        }
        
        return Listas_view.listas_view;
    }
    
    /**
    * Método que permite poner la clase a null, para cuando se cierra sesión o se borra el usuario
    *
    */
    public static void reiniciar_instancia() {
        Listas_view.listas_view = null;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
