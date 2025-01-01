/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author Propietario
 */
public class Estilos {

    private final Color blanco = new Color(255, 255, 255);
    private final Color negro = new Color(0, 0, 0);
    private final Color blanco_claro = new Color(245, 245, 245);
    private final Color gris_claro  = new Color(218, 210, 216);
    private final Color azul_oscuro = new Color(20, 54, 66);
    private final Color amarillo = new Color(255, 212, 59);
    private final Color rojo = new Color(255, 49, 46);
    private final Color naranja = new Color(251, 139, 36);
    private final Color verde = new Color(35, 206, 107);
    private Font fuente = new Font("Arial", Font.PLAIN, 13);
    
    public Estilos() {
        
        try {
            
            InputStream is = getClass().getResourceAsStream("/com/mycompany/tareapp/vista/recursos/fuentes/Poppins-Regular.ttf"); // Recojo la fuente
            
            if (is != null) {
                
                fuente = Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(13f); // Si se recoge la fuente se pone Poppins
            }
            
        } catch (FontFormatException | IOException e) { }
        
    }
    
    public Color getBlanco() {
        return blanco;
    }

    public Color getNegro() {
        return negro;
    }

    public Color getBlanco_claro() {
        return blanco_claro;
    }

    public Color getGris_claro() {
        return gris_claro;
    }

    public Color getAzul_oscuro() {
        return azul_oscuro;
    }

    public Color getAmarillo() {
        return amarillo;
    }

    public Color getRojo() {
        return rojo;
    }

    public Color getNaranja() {
        return naranja;
    }

    public Color getVerde() {
        return verde;
    }
    
    public Font getFuente() {
        return fuente;
    }
}
