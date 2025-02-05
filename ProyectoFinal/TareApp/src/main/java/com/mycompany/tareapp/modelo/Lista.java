/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.modelo;

import java.util.regex.Pattern;

/**
 *
 * @author Propietario
 */
public class Lista {

    private int idLista;
    private String titulo;
    private String email;
    
    public Lista(int idLista, String titulo, String email) {
        this.idLista = idLista;
        this.titulo = titulo;
        this.email = email;
    }

    public Lista(String titulo, String email) {
        this.titulo = titulo;
        this.email = email;
    }

    public Lista() {
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String toString() {
        return titulo;
    }
    
    public static boolean es_titulo_valido(String titulo) {
        
        String expresion = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ\\s\\-\\_\\.\\,\\(\\)]+$";
        Pattern pattern = Pattern.compile(expresion);
        
        return pattern.matcher(titulo).matches();
    }
}
