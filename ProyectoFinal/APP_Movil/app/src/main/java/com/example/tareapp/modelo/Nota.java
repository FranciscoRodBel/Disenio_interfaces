/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tareapp.modelo;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * Clase para el modelo de las notas
 * Tiene las propiedades de las notas y sus funciones necesarias
 *
 * @author Francisco
 */
public class Nota implements Serializable {
    
    private int idNota;
    private String descripcion;
    private String color;
    
    /**
    * Constructor de la nota con el id para cuando quiero mostrar las notas
    * 
    */
    public Nota(int idNota, String descripcion, String color) {    
        this.idNota = idNota;
        this.descripcion = descripcion;
        this.color = color;
    }

    /**
     * Constructor de la nota sin el id para cuando quiero crear la nota
     *
     */
    public Nota(String descripcion, String color) {
        this.descripcion = descripcion;
        this.color = color;
    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
    * Función que permite comprobar si el texto pasado tiene algún caracter extraño
    * 
    * @return Devuelvo true si es válido
    */
    public boolean es_texto_valido(String texto) {
        
        String expresion = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ\\s\\-\\_\\.\\,\\(\\)]+$";
        Pattern pattern = Pattern.compile(expresion);
        
        return pattern.matcher(texto).matches();
    }
}
