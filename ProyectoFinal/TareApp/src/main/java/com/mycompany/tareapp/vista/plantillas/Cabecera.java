/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author Propietario
 */
public class Cabecera extends JPanel {
    
    Estilos estilos = new Estilos();
    
    JLabel imagenLogo = new JLabel(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/logo.png"));
    JLabel nombreApp = new JLabel("TareApp");
    
    JMenuBar menuBarras = new JMenuBar();
    
    JMenuItem itemTareas = new JMenuItem("Tareas");
    JMenuItem itemListas = new JMenuItem("Listas");
    
    JMenu menuIdioma = new JMenu("Idioma");
    JCheckBoxMenuItem itemEspaniol = new JCheckBoxMenuItem("Español");
    JCheckBoxMenuItem itemIngles = new JCheckBoxMenuItem("Inglés");
    JCheckBoxMenuItem itemFrances = new JCheckBoxMenuItem("Francés");
    
    JMenu menuCuenta = new JMenu("Cuenta");
    JMenuItem itemAjustes = new JMenuItem("Ajustes");
    JMenuItem itemCerrarSesion = new JMenuItem("Cerrar sesión");
    
    public Cabecera() {
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(1000, 45));
        this.setOpaque(true);
        this.setBackground(estilos.getBlanco_claro());
        this.setVisible(true);
        
        this.add(imagenLogo);
        layout.putConstraint(SpringLayout.WEST, imagenLogo, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, imagenLogo, 3, SpringLayout.NORTH, this);
        
        this.add(nombreApp);
        nombreApp.setFont(estilos.getFuente());
        layout.putConstraint(SpringLayout.WEST, nombreApp, 50, SpringLayout.WEST, imagenLogo);
        layout.putConstraint(SpringLayout.NORTH, nombreApp, 13, SpringLayout.NORTH, this);
        
        this.add(menuBarras);
        menuBarras.setFont(estilos.getFuente());
        menuBarras.setBackground(estilos.getBlanco_claro());
        menuBarras.setOpaque(true);
        menuBarras.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Para quitar unas franjas que salen a los lados del menú
        layout.putConstraint(SpringLayout.WEST, menuBarras, 250, SpringLayout.WEST, nombreApp);
        layout.putConstraint(SpringLayout.NORTH, menuBarras, 0, SpringLayout.NORTH, this);
        
        Separador separador1 = new Separador();
        Separador separador2 = new Separador();
        Separador separador3 = new Separador();
       
        itemTareas.setPreferredSize(new Dimension(70, 45));
        itemListas.setPreferredSize(new Dimension(70, 45));
        menuIdioma.setPreferredSize(new Dimension(70, 45));
        menuCuenta.setPreferredSize(new Dimension(70, 45));
        
        menuBarras.add(itemTareas);
        menuBarras.add(separador1);
        menuBarras.add(itemListas);
        menuBarras.add(separador2);
        menuBarras.add(menuIdioma);
        menuBarras.add(separador3);
        menuBarras.add(menuCuenta);
        
        itemTareas.setBackground(estilos.getBlanco_claro());
        itemTareas.setOpaque(true);

        itemListas.setBackground(estilos.getBlanco_claro());
        itemListas.setOpaque(true);

        menuIdioma.setBackground(estilos.getBlanco_claro());
        menuIdioma.setOpaque(true);

        menuCuenta.setBackground(estilos.getBlanco_claro());
        menuCuenta.setOpaque(true);

        menuIdioma.add(itemEspaniol);
        menuIdioma.add(itemIngles);
        menuIdioma.add(itemFrances);
        itemEspaniol.setSelected(true);
        
        menuCuenta.add(itemAjustes);
        menuCuenta.add(itemCerrarSesion);

    }
}
