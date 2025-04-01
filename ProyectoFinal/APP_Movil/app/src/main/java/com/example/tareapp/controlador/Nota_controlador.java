/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tareapp.controlador;

import com.example.tareapp.modelo.BBDD_tareapp;
import com.example.tareapp.modelo.Nota;
import com.example.tareapp.modelo.idioma.Pagina_notas;
import com.example.tareapp.modelo.idioma.Pagina_tareas;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *  Clase controladora de las notas, con funciones para hacer el CRUD de las notas
 * 
 * @author Francisco
 */
public class Nota_controlador {
    
    private final BBDD_tareapp bbdd_tareapp = new BBDD_tareapp(); // Recojo la bbdd
    
    /**
    * Función que permite crear notas
    * 
    * @return Devuelve el resultado de crear la nota, si se consigue crear devuelve vacío y si no un mensaje de error
    */
    public String crear_nota(String descripcion, String color) {
    
        descripcion = descripcion.trim();
        
        Pagina_notas idioma_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas(); // Recojo el idioma de notas
        
        Nota nota = new Nota(descripcion, color); // Se crea la nota con sus datos
        
        // Comprobaciones de los datos
        if (descripcion.length() > 250) return idioma_notas.getDescripcion_supera_caracteres();  // Si la descripción supera los 250 caracteres devuelve el error
        
        if (!nota.es_texto_valido(descripcion)) return Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getDescripcion_no_valida(); // Evita que tenga simbolos raros
        
        String consulta = "INSERT INTO nota (descripcion, color, email) VALUES ('"+descripcion+"', '"+color+"', '"+Usuario_controlador.getUsuario().getEmail()+"')";
        
        if(bbdd_tareapp.insertar(consulta)) { // Devolverá true si se alamacena correctamente
            
            return ""; // Si se inserta devuelve vacío
            
        } else { 
            
            return idioma_notas.getNota_no_creada(); // Si no se inserta devuelve el mensaje correspondiente
        }
    }
    
    /**
    * Función que permite recoger todas las notas de un usuario
    * 
    * @return Devuelve un array de arrays asociativos con el nombre de la propiedad y su valor.
    */
    public static ArrayList<HashMap<String, Object>> recoger_Notas() {
    
        String consulta = "SELECT * FROM nota WHERE email = '"+ Usuario_controlador.getUsuario().getEmail() +"'";
        
        ArrayList<HashMap<String, Object>> resultados = new BBDD_tareapp().consultar(consulta); // Recoge los datos
        
        if (resultados.isEmpty()) { // Si no hay notas creadas devuleve null y si no los datos
            
            return null;
            
        } else {
        
            return resultados;
        }
    }
    
    /**
    * Función que permite editar una nota de un usuario
    * 
    * @return Devuelve el resultado de editar la nota, si se consigue editar devuelve vacío y si no un mensaje de error
    */
    public String editar_nota(int idNota, String descripcion, String color) {
       
        descripcion = descripcion.trim();
        
        Pagina_notas idioma_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas(); // Recojo el idioma de notas
        
        Nota nota = new Nota(descripcion, color); // Se crea la nota con sus datos
        
        // Comprobaciones de los datos
        if (descripcion.length() > 250) return idioma_notas.getDescripcion_supera_caracteres();  // Si la descripción supera los 250 caracteres devuelve el error
        
        if (!nota.es_texto_valido(descripcion)) return Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getDescripcion_no_valida(); // Evita que tenga simbolos raros
        
        String consulta = "UPDATE nota SET descripcion = '" + descripcion + "', color = '" + color + "' WHERE idNota = " + idNota;

        if(bbdd_tareapp.insertar(consulta)) { // Devolverá true si se edita correctamente
            
            return ""; // Si se edita devuelve vacío
            
        } else {
            
            return idioma_notas.getNota_no_editada(); // Si no se edita devuelve el mensaje correspondiente
        }
    }
    
    /**
    * Función que permite borrar una nota
    * 
    * @return Devuelve el resultado de borrar la nota, si se consigue borrar devuelve vacío y si no un mensaje de error
    */
    public String borrar_nota(int idNota) {
        
        Pagina_notas idioma_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas(); // Recojo el idioma de notas
        
        String consulta = "DELETE FROM nota WHERE idNota = '" + idNota + "'";
        
        if(bbdd_tareapp.borrar(consulta)) {
            
            return ""; 
            
        } else {
            
            return idioma_notas.getNota_no_borrada();
        }
    }
    
}
