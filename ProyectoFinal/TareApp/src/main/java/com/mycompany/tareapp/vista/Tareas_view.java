/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.controlador.Lista_controlador;
import com.mycompany.tareapp.controlador.Tarea_controlador;
import com.mycompany.tareapp.modelo.Lista;
import com.mycompany.tareapp.modelo.Usuario;
import com.mycompany.tareapp.modelo.idioma.Pagina_tareas;
import com.mycompany.tareapp.vista.plantillas.Estilos;
import com.mycompany.tareapp.vista.plantillas.Lista_plantilla;
import com.mycompany.tareapp.vista.plantillas.Popup_crear_editar_tarea;
import com.mycompany.tareapp.vista.plantillas.Tarea_plantilla;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Propietario
 */
public final class Tareas_view extends javax.swing.JPanel {
    
    Tarea_controlador tarea_controlador = new Tarea_controlador();
    Lista_controlador lista_controlador = new Lista_controlador();
    
    Usuario usuario;
    
    JToolBar barraHerramientas = new JToolBar();
    
    JButton botonCrearTarea = new JButton();
    JButton botonTareasCompletadas = new JButton();
    JButton botonTareasIncompletas = new JButton();
    JButton botonPrioridadBaja = new JButton();
    JButton botonPrioridadMedia = new JButton();
    JButton botonPrioridadalta = new JButton();
    JButton botonOrdenadoAZ = new JButton();
    JButton botonOrdenadoZA = new JButton();
    JButton botonOrdenado19 = new JButton();
    JButton botonOrdenado91 = new JButton();
    
    JLabel titulo_pagina = new JLabel("Tareas");
    JComboBox<Lista> seleccionarLista = new JComboBox();
    
    JPanel panelTareas = new JPanel();
    JScrollPane scroll_panelTareas = new JScrollPane(panelTareas);
    /**
     * Creates new form Tareas_view2
     */
    public Tareas_view(Usuario usuario) {
        initComponents();
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(1000, 555));
        this.setMaximumSize(new Dimension(1000, 555));
        this.setBackground(Estilos.getGris_claro());
        this.usuario = usuario;
        
        barraHerramientas.setBackground(Estilos.getAzul_oscuro());
        barraHerramientas.setFloatable(false);
        this.add(barraHerramientas);
        layout.putConstraint(SpringLayout.WEST, barraHerramientas, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, barraHerramientas, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.EAST, barraHerramientas, 0, SpringLayout.EAST, this);
        
        botonCrearTarea.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/plus-solid.png"));
        botonTareasCompletadas.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/square-check-solid.png"));
        botonTareasIncompletas.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/square-regular.png"));
        botonPrioridadBaja.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-arrow-down-solid.png"));
        botonPrioridadMedia.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-arrow-right-solid.png"));
        botonPrioridadalta.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/circle-arrow-up-solid.png"));
        botonOrdenadoAZ.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/arrow-down-a-z-solid.png"));
        botonOrdenadoZA.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/arrow-down-z-a-solid.png"));
        botonOrdenado19.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/arrow-down-1-9-solid.png"));
        botonOrdenado91.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/arrow-down-9-1-solid.png"));
        
        barraHerramientas.add(botonCrearTarea);
        barraHerramientas.add(new JToolBar.Separator());
        barraHerramientas.add(botonTareasCompletadas);
        barraHerramientas.add(botonTareasIncompletas);
        barraHerramientas.add(new JToolBar.Separator());
        barraHerramientas.add(botonPrioridadBaja);
        barraHerramientas.add(botonPrioridadMedia);
        barraHerramientas.add(botonPrioridadalta);
        barraHerramientas.add(new JToolBar.Separator());
        barraHerramientas.add(botonOrdenadoAZ);
        barraHerramientas.add(botonOrdenadoZA);
        barraHerramientas.add(botonOrdenado19);
        barraHerramientas.add(botonOrdenado91);
        
        this.add(titulo_pagina);
        titulo_pagina.setHorizontalAlignment(SwingConstants.CENTER);
        titulo_pagina.setFont(Estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, titulo_pagina, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, titulo_pagina, 70, SpringLayout.NORTH, barraHerramientas);
        layout.putConstraint(SpringLayout.EAST, titulo_pagina, 0, SpringLayout.EAST, this);
        
        this.add(seleccionarLista);
        seleccionarLista.setPreferredSize(new Dimension(300, 40));
        seleccionarLista.setBackground(Estilos.getBlanco_claro());
        seleccionarLista.setFont(Estilos.getFuente());
        layout.putConstraint(SpringLayout.WEST, seleccionarLista, 350, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, seleccionarLista, 50, SpringLayout.NORTH, titulo_pagina);
        actualizar_select_listas();
        seleccionarLista.insertItemAt(new Lista(0,"Seleccionar lista", ""),0);
        
        panelTareas.setLayout(new BoxLayout(panelTareas, BoxLayout.Y_AXIS)); // Para colocar una tarea debajo de otra
        panelTareas.setBackground(Estilos.getGris_claro());
        
        scroll_panelTareas.setPreferredSize(new Dimension(815, 350));
        scroll_panelTareas.getVerticalScrollBar().setUnitIncrement(15); // Para aumentar la velocidad de la barra de scroll
        scroll_panelTareas.setBorder(null);
        this.add(scroll_panelTareas);
        layout.putConstraint(SpringLayout.WEST, scroll_panelTareas, 100, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, scroll_panelTareas, 60, SpringLayout.NORTH, seleccionarLista);
        
        
        botonCrearTarea.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                Popup_crear_editar_tarea popup_crear_editar_tarea = new Popup_crear_editar_tarea(null);
                
                popup_crear_editar_tarea.getBonton_crear_editar().addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent e) {

                        if (popup_crear_editar_tarea.getTarea() == null) {

                            String titulo = popup_crear_editar_tarea.getInput_titulo_terea().getText();
                            String prioridad = (String) popup_crear_editar_tarea.getInput_prioridad_tarea().getSelectedItem();
                            String fecha = popup_crear_editar_tarea.getInput_fecha_terea().getText();
                            String descripcion = popup_crear_editar_tarea.getInput_descripcion().getTextArea().getText();
                            int idLista = 1;

                            String mensaje_resultado = tarea_controlador.crear_tarea(titulo, prioridad, fecha, descripcion, idLista);

                            System.out.println(mensaje_resultado);

                            if (mensaje_resultado.isEmpty()) {

                                mensaje_resultado = "Tarea creada";
                                actualizar_panel_tareas();
                            } 

                            popup_crear_editar_tarea.getLabel_resultado_tarea().setText(mensaje_resultado);
                            Timer tiempo_espera = new Timer(3000, evt -> popup_crear_editar_tarea.getLabel_resultado_tarea().setText(""));
                            tiempo_espera.setRepeats(false);
                            tiempo_espera.start();

                        } else {

                            // En caso de que quiera editar

                        }
                    }
                });
                
                popup_crear_editar_tarea.setVisible(true);
            }
        });
        
        seleccionarLista.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                actualizar_panel_tareas();
            }
        });
    }
    
    public JLabel getTitulo_pagina() {
        return titulo_pagina;
    }

    public void setTitulo_pagina(JLabel titulo_pagina) {
        this.titulo_pagina = titulo_pagina;
    }

    public JComboBox<Lista> getSeleccionarLista() {
        return seleccionarLista;
    }

    public void setSeleccionarLista(JComboBox<Lista> seleccionarLista) {
        this.seleccionarLista = seleccionarLista;
    }
    
    public void actualizar_panel_tareas() {
        
        panelTareas.removeAll();
    
        Lista listaSeleccionada = (Lista) seleccionarLista.getSelectedItem();
        
        ArrayList<HashMap<String, Object>> tareas = Tarea_controlador.recoger_tareas(listaSeleccionada.getIdLista());
        
        if (tareas != null) {
            
            for(HashMap<String, Object> fila : tareas) {
        
                int idTarea = (int) fila.get("idTarea");
                boolean completada = (boolean) fila.get("completada");
                String titulo = (String) fila.get("titulo");
                int prioridad = (int) fila.get("prioridad");
                String fecha = (String) fila.get("fecha");
                String descripcion = (String) fila.get("descripcion");
                int idLista = (int) fila.get("idLista");

                Tarea_plantilla tarea_plantilla = new Tarea_plantilla(idTarea, completada, titulo, prioridad, fecha, descripcion, idLista);
                tarea_plantilla.setMaximumSize(new Dimension(800, 50)); // Si no pongo el máximo se estíran las tareas para ocupar todo el panel
                tarea_plantilla.setMinimumSize(new Dimension(800, 50)); // Si no pongo el mínimo ocupan la mitad del ancho del panel

                panelTareas.add(tarea_plantilla);
            }

            panelTareas.revalidate();
            panelTareas.repaint();
        }
    }
    
    public void actualizar_select_listas() {
    
        seleccionarLista.removeAllItems();
       
        ArrayList<HashMap<String, Object>> listas = lista_controlador.recoger_listas(usuario.getEmail());
        
        if (listas != null) {
            
            for(HashMap<String, Object> fila : listas) {
        
                int idLista = (int) fila.get("idLista");
                String titulo = (String) fila.get("titulo");
                String email = (String) fila.get("email");
                
                Lista lista = new Lista(idLista, titulo, email);
                
                seleccionarLista.addItem(lista);
            }
        }
    }
    
    public void recoger_lista_seleccionada() {
        
        Lista listaSeleccionada = (Lista) seleccionarLista.getSelectedItem();
        
        if (listaSeleccionada != null) {
            
            int id = listaSeleccionada.getIdLista();
            String titulo = listaSeleccionada.getTitulo();
            String email = listaSeleccionada.getEmail();

            System.out.println("ID: " + id + ", Título: " + titulo + ", Email: " + email);
        }
    }

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
