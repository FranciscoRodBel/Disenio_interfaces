/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tareapp.modelo;

import java.util.regex.Pattern;

/**
 * Clase para el modelo de la lista
 * Tiene las propiedades de las listas y sus funciones necesarias
 *
 * @author Francisco
 */
public class Lista {

    private int idLista;
    private String titulo;
    private String email;
    
    /**
    * Constructor de la lista con el id para cuando quiero mostrar, o guardar las listas en el select de la página de tareas
    * 
    */
    public Lista(int idLista, String titulo, String email) {
        this.idLista = idLista;
        this.titulo = titulo;
        this.email = email;
    }

    /**
    * Constructor de la lista sin el id para cuando quiero crear la lista
    * 
    */
    public Lista(String titulo, String email) {
        this.titulo = titulo;
        this.email = email;
    }

    public Lista() {
    }

    public int getIdLista() {
        return idLista;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEmail() {
        return email;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() { // Para mostrar el nombre en el select de las listas de la página de tareas
        return titulo;
    }
    
    
    
    /**
    * Función que permite comprobar si el títlo de la lista es válido
    * 
    * @return Devuelvo true si es válido
    */
    public static boolean es_titulo_valido(String titulo) {
        
        String expresion = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ\\s\\-\\_\\.\\,\\(\\)]+$";
        Pattern pattern = Pattern.compile(expresion);
        
        return pattern.matcher(titulo).matches();
    }
}
