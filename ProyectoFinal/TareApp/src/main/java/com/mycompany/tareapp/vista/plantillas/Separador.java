/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import javax.swing.JPanel;


/**
 * Clase para el componente del separador
 * Componente creado para reducir código y tener menos líneas en otros archivos
 * 
 * @author Francisco
 */
public class Separador extends JPanel {
        
    public Separador() {
        
        this.setPreferredSize(new Dimension(2, 10));
        this.setBackground(Estilos.getNegro());
    }
}
