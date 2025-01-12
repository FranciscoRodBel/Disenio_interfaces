/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;

/**
 *
 * @author Propietario
 */
public class Lista_plantilla extends JPanel {

    int idLista;
    JLabel titulo_lista = new JLabel("Título tarea");
    
    JButton botonVerLista = new JButton();
    JButton botonEditarLista = new JButton();
    JButton botonBorrarLista = new JButton();
    
    public Lista_plantilla() {
        
        generarEstructura();
    }
    
    public Lista_plantilla(String titulo_lista) {
        
        generarEstructura();
        
        this.setTitulo_lista(titulo_lista);
    }
    
    public Lista_plantilla(int idLista, String titulo_lista) {
        
        generarEstructura();
        
        this.setIdLista(idLista);
        this.setTitulo_lista(titulo_lista);
    }
    
    public JLabel getTitulo_lista() {
        
        return titulo_lista;
    }

    public void setTitulo_lista(String titulo_lista) {
        
        this.getTitulo_lista().setText(titulo_lista);
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }
   
    public void generarEstructura() {
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(600, 50));
        this.setOpaque(true);
        this.setBackground(Estilos.getGris_claro());
        this.setVisible(true);
        
        Separador separador1 = new Separador();
        this.add(separador1);
        layout.putConstraint(SpringLayout.WEST, separador1, 0, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, separador1, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador1, 0, SpringLayout.SOUTH, this);
        
        this.add(titulo_lista);
        titulo_lista.setFont(Estilos.getFuente());
        titulo_lista.setPreferredSize(new Dimension(400, 50));
        layout.putConstraint(SpringLayout.WEST, titulo_lista, 20, SpringLayout.WEST, separador1);
        layout.putConstraint(SpringLayout.NORTH, titulo_lista, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, titulo_lista, 0, SpringLayout.SOUTH, this);
        
        Separador separador2 = new Separador();
        this.add(separador2);
        layout.putConstraint(SpringLayout.WEST, separador2, 410, SpringLayout.WEST, titulo_lista);
        layout.putConstraint(SpringLayout.NORTH, separador2, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador2, 0, SpringLayout.SOUTH, this);
        
        this.add(botonVerLista);
        botonVerLista.setPreferredSize(new Dimension(30, 30));
        botonVerLista.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/eye-solid.png"));
        botonVerLista.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, botonVerLista, 20, SpringLayout.WEST, separador2);
        layout.putConstraint(SpringLayout.NORTH, botonVerLista, 5, SpringLayout.NORTH, separador2);
        
        this.add(botonEditarLista);
        botonEditarLista.setPreferredSize(new Dimension(30, 30));
        botonEditarLista.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/pen-to-square-solid.png"));
        botonEditarLista.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, botonEditarLista, 50, SpringLayout.WEST, botonVerLista);
        layout.putConstraint(SpringLayout.NORTH, botonEditarLista, 0, SpringLayout.NORTH, botonVerLista);
        
        this.add(botonBorrarLista);
        botonBorrarLista.setPreferredSize(new Dimension(30, 30));
        botonBorrarLista.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/trash-can-solid.png"));
        botonBorrarLista.setContentAreaFilled(false); // Elimino el fondo
        layout.putConstraint(SpringLayout.WEST, botonBorrarLista, 50, SpringLayout.WEST, botonEditarLista);
        layout.putConstraint(SpringLayout.NORTH, botonBorrarLista, 0, SpringLayout.NORTH, botonEditarLista);
        
        Separador separador3 = new Separador();
        this.add(separador3);
        layout.putConstraint(SpringLayout.EAST, separador3, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, separador3, 0, SpringLayout.NORTH, this);
        layout.putConstraint(SpringLayout.SOUTH, separador3, 0, SpringLayout.SOUTH, this);
        
        botonEditarLista.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                Popup_editar_lista popup_editar_lista = new Popup_editar_lista(Lista_plantilla.this);
                popup_editar_lista.setVisible(true);
            }
        });
        
        botonBorrarLista.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                
                Popup_borrar_cuenta_lista popup_borrar_cuenta_lista = new Popup_borrar_cuenta_lista(Lista_plantilla.this.getTitulo_lista().getText(),"lista");
                popup_borrar_cuenta_lista.setVisible(true);
            }
        });
    }
}
