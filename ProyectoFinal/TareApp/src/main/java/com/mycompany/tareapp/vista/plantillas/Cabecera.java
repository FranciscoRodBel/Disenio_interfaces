/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author Propietario
 */
public class Cabecera extends JPanel {

    static Cabecera cabecera;
    
    Font fuente = Estilos.getFuente();
    
    JLabel imagenLogo = new JLabel(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/logo.png"));
    JLabel nombreApp = new JLabel("TareApp");
    
    JMenuBar menuBarras = new JMenuBar();
    
    JMenuItem itemTareas = new JMenuItem("Tareas");
    JMenuItem itemListas = new JMenuItem("Listas");
    
    JMenu menuIdioma = new JMenu("Idioma");
    JRadioButtonMenuItem itemEspaniol = new JRadioButtonMenuItem("Español");
    JRadioButtonMenuItem itemIngles = new JRadioButtonMenuItem("English");
    JRadioButtonMenuItem itemFrances = new JRadioButtonMenuItem("Français");
    ButtonGroup grupoIdiomas = new ButtonGroup();
    
    JMenu menuCuenta = new JMenu("Cuenta");
    JMenuItem itemAjustes = new JMenuItem("Ajustes");
    JMenuItem itemCerrarSesion = new JMenuItem("Cerrar sesión");
    
    public JRadioButtonMenuItem getItemEspaniol() {
        return itemEspaniol;
    }

    public void setItemEspaniol(JRadioButtonMenuItem itemEspaniol) {
        this.itemEspaniol = itemEspaniol;
    }

    public JRadioButtonMenuItem getItemIngles() {
        return itemIngles;
    }

    public void setItemIngles(JRadioButtonMenuItem itemIngles) {
        this.itemIngles = itemIngles;
    }

    public JRadioButtonMenuItem getItemFrances() {
        return itemFrances;
    }

    public void setItemFrances(JRadioButtonMenuItem itemFrances) {
        this.itemFrances = itemFrances;
    }
    public JMenuItem getItemTareas() {
        return itemTareas;
    }

    public void setItemTareas(JMenuItem itemTareas) {
        this.itemTareas = itemTareas;
    }

    public JMenuItem getItemListas() {
        return itemListas;
    }

    public void setItemListas(JMenuItem itemListas) {
        this.itemListas = itemListas;
    }

    public JMenuItem getItemAjustes() {
        return itemAjustes;
    }

    public void setItemAjustes(JMenuItem itemAjustes) {
        this.itemAjustes = itemAjustes;
    }

    public JMenuItem getItemCerrarSesion() {
        return itemCerrarSesion;
    }

    public void setItemCerrarSesion(JMenuItem itemCerrarSesion) {
        this.itemCerrarSesion = itemCerrarSesion;
    }
        public JMenu getMenuIdioma() {
        return menuIdioma;
    }

    public void setMenuIdioma(JMenu menuIdioma) {
        this.menuIdioma = menuIdioma;
    }

    public JMenu getMenuCuenta() {
        return menuCuenta;
    }

    public void setMenuCuenta(JMenu menuCuenta) {
        this.menuCuenta = menuCuenta;
    }
    
    public Cabecera() {
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setPreferredSize(new Dimension(1000, 45));
        this.setOpaque(true);
        this.setBackground(Estilos.getBlanco_claro());
        this.setVisible(true);
        
        this.add(imagenLogo);
        layout.putConstraint(SpringLayout.WEST, imagenLogo, 10, SpringLayout.WEST, this);
        layout.putConstraint(SpringLayout.NORTH, imagenLogo, 3, SpringLayout.NORTH, this);
        
        this.add(nombreApp);
        nombreApp.setFont(Estilos.getFuenteConTamaio(16));
        layout.putConstraint(SpringLayout.WEST, nombreApp, 50, SpringLayout.WEST, imagenLogo);
        layout.putConstraint(SpringLayout.NORTH, nombreApp, 10, SpringLayout.NORTH, this);
        
        this.add(menuBarras);
        menuBarras.setBackground(Estilos.getBlanco_claro());
        menuBarras.setOpaque(true);
        menuBarras.setBorder(javax.swing.BorderFactory.createEmptyBorder()); // Para quitar unas franjas que salen a los lados del menú
        layout.putConstraint(SpringLayout.WEST, menuBarras, 250, SpringLayout.WEST, nombreApp);
        layout.putConstraint(SpringLayout.NORTH, menuBarras, 10, SpringLayout.NORTH, this);
        
        Separador separador1 = new Separador();
        Separador separador2 = new Separador();
        Separador separador3 = new Separador();
        
        itemTareas.setHorizontalAlignment(SwingConstants.CENTER);
        itemListas.setHorizontalAlignment(SwingConstants.CENTER);
        menuIdioma.setHorizontalAlignment(SwingConstants.CENTER);
        menuCuenta.setHorizontalAlignment(SwingConstants.CENTER);

        menuBarras.add(itemTareas);
        menuBarras.add(separador1);
        menuBarras.add(itemListas);
        menuBarras.add(separador2);
        menuBarras.add(menuIdioma);
        menuBarras.add(separador3);
        menuBarras.add(menuCuenta);
        
        itemTareas.setBackground(Estilos.getBlanco_claro());
        itemTareas.setOpaque(true);

        itemListas.setBackground(Estilos.getBlanco_claro());
        itemListas.setOpaque(true);

        menuIdioma.setBackground(Estilos.getBlanco_claro());
        menuIdioma.setOpaque(true);

        menuCuenta.setBackground(Estilos.getBlanco_claro());
        menuCuenta.setOpaque(true);

        grupoIdiomas.add(itemEspaniol);
        grupoIdiomas.add(itemIngles);
        grupoIdiomas.add(itemFrances);
                
        menuIdioma.add(itemEspaniol);
        menuIdioma.add(itemIngles);
        menuIdioma.add(itemFrances);
        itemEspaniol.setSelected(true);
        
        menuCuenta.add(itemAjustes);
        menuCuenta.add(itemCerrarSesion);
        
        itemTareas.setFont(fuente);
        itemListas.setFont(fuente);
        menuIdioma.setFont(fuente);
        menuCuenta.setFont(fuente);
        itemEspaniol.setFont(fuente);
        itemIngles.setFont(fuente);
        itemFrances.setFont(fuente);
        itemAjustes.setFont(fuente);
        itemCerrarSesion.setFont(fuente);

    }
    
    
    
    public static Cabecera recoger_instancia() {
        
        if (cabecera == null) {
            
            cabecera = new Cabecera();
        }
        
        return cabecera;
    }
}
