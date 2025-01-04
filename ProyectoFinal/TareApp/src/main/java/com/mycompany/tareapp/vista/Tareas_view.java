/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.tareapp.vista;

import com.mycompany.tareapp.vista.plantillas.Estilos;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

/**
 *
 * @author Propietario
 */
public class Tareas_view extends javax.swing.JFrame {

    Estilos estilos = new Estilos();
    JPanel panelPrincipal = new JPanel();
    
    JToolBar barraHerramientas = new JToolBar();
    JScrollPane panelPrincipalScroll = new JScrollPane(panelPrincipal);
    
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
    
    JLabel tituloPagina = new JLabel("Tareas");
    JComboBox<String> seleccionarLista = new JComboBox();
    
    /**
     * Creates new form TareApp
     */
    public Tareas_view() {
        initComponents();
        
        this.setSize(1012, 600);
        this.setResizable(false);        
        this.add(panelPrincipalScroll);
        SpringLayout layout = new SpringLayout();
        panelPrincipalScroll.setBounds(-3, 43, 1012, 600);
        panelPrincipal.setBackground(estilos.getGris_claro());
        panelPrincipal.setLayout(layout);
        
        barraHerramientas.setBackground(estilos.getAzul_oscuro());
        barraHerramientas.setFloatable(false);
        panelPrincipal.add(barraHerramientas);
        layout.putConstraint(SpringLayout.WEST, barraHerramientas, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, barraHerramientas, 0, SpringLayout.NORTH, cabecera1);
        layout.putConstraint(SpringLayout.EAST, barraHerramientas, 0, SpringLayout.EAST, panelPrincipal);
        
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
        
        panelPrincipal.add(tituloPagina);
        tituloPagina.setHorizontalAlignment(SwingConstants.CENTER);
        tituloPagina.setFont(estilos.getFuenteTitulo());
        layout.putConstraint(SpringLayout.WEST, tituloPagina, 0, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, tituloPagina, 70, SpringLayout.NORTH, barraHerramientas);
        layout.putConstraint(SpringLayout.EAST, tituloPagina, 0, SpringLayout.EAST, panelPrincipal);
        
        panelPrincipal.add(seleccionarLista);
        seleccionarLista.setPreferredSize(new Dimension(300, 40));
        seleccionarLista.setBackground(estilos.getBlanco_claro());
        seleccionarLista.setFont(estilos.getFuente());
        layout.putConstraint(SpringLayout.WEST, seleccionarLista, 350, SpringLayout.WEST, panelPrincipal);
        layout.putConstraint(SpringLayout.NORTH, seleccionarLista, 50, SpringLayout.NORTH, tituloPagina);
        seleccionarLista.addItem("Selecciona una lista");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cabecera1 = new com.mycompany.tareapp.vista.plantillas.Cabecera();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cabecera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(cabecera1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 555, Short.MAX_VALUE))
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
            java.util.logging.Logger.getLogger(Tareas_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tareas_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tareas_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tareas_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tareas_view().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.tareapp.vista.plantillas.Cabecera cabecera1;
    // End of variables declaration//GEN-END:variables
}
