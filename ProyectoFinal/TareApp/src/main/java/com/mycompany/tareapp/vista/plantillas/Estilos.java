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
 * Clase para almacenar los estilos de la página
 * Se almacenan los colores y la fuente
 * 
 * @author Francisco
 */
public class Estilos {

    private static final Color blanco = new Color(255, 255, 255);
    private static final Color negro = new Color(0, 0, 0);
    private static final Color blanco_claro = new Color(245, 245, 245);
    private static final Color gris_claro  = new Color(230, 230, 230);
    private static final Color azul_oscuro = new Color(20, 54, 66);
    private static final Color amarillo = new Color(255, 212, 59);
    private static final Color rojo = new Color(255, 49, 46);
    private static final Color naranja_nota = new Color(248, 169, 86);
    private static final Color verde_nota = new Color(207, 223, 56);
    private static final Color azul_nota = new Color(110, 201, 234);
    private static final Color morado_nota = new Color(174, 142, 191);
    private static final Color amarillo_nota = new Color(255, 238, 84);
    private static final Color rosa_nota = new Color(239, 131, 180);
    private static Font fuente;
    
    /**
    * Constructor de los estilos, pone como predeterminada la letra
    * 
    */
    static {
        fuente = cargarFuente(14); // Carga inicial de la fuente con tamaño 14
    }
    
    /**
    * Función que permite recoger la fuente del archivo
    * 
    * @return Devuelve la fuente en un formato predeterminado
    */
    private static Font cargarFuente(float tamanio) {
        
        try {
            
            InputStream is = Estilos.class.getResourceAsStream("/fuentes/Poppins-Regular.ttf"); // recoge la fuente

            if (is != null) {
                   
                return Font.createFont(Font.PLAIN, is).deriveFont(tamanio); // Devuelve la fuente con el tamaño pasado
            }
            
        } catch (FontFormatException | IOException e) { 
            
            e.printStackTrace();
        }
        
        return new Font("Arial", Font.PLAIN, 14); // Si da error devuelve otra fuente
    }
    
    public static Color getBlanco() {
        return blanco;
    }

    public static Color getNegro() {
        return negro;
    }

    public static Color getBlanco_claro() {
        return blanco_claro;
    }

    public static Color getGris_claro() {
        return gris_claro;
    }

    public static Color getAzul_oscuro() {
        return azul_oscuro;
    }

    public static Color getAmarillo() {
        return amarillo;
    }

    public static Color getRojo() {
        return rojo;
    }

    public static Color getNaranja_nota() {
        return naranja_nota;
    }

    public static Color getVerde_nota() {
        return verde_nota;
    }

    public static Color getAzul_nota() {
        return azul_nota;
    }

    public static Color getMorado_nota() {
        return morado_nota;
    }

    public static Color getAmarillo_nota() {
        return amarillo_nota;
    }

    public static Color getRosa_nota() {
        return rosa_nota;
    }
    
    public static Font getFuente() {
        return fuente;
    }
    
    public static void setFuente(Font fuente) {
        Estilos.fuente = fuente;
    }
    
    /**
    * Función que permite recoger la fuente en un tamaño concreto
    * 
    * @return Devuelve la fuente
    */
    public static Font getFuenteConTamaio(float tamanio) {
        
        return cargarFuente(tamanio);
    }
    
    /**
    * Función que permite recoger la fuente en el formato del título
    * 
    * @return Devuelve la fuente, en negrita y con tamaño 20
    */
    public static Font getFuenteTitulo() {
        
        return cargarFuente(20).deriveFont(Font.BOLD);
    }
}
