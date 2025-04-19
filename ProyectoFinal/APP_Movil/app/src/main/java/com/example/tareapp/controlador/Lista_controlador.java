/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tareapp.controlador;

import com.example.tareapp.modelo.BBDD_tareapp;
import com.example.tareapp.modelo.Lista;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que se encarga de controlar las listas
 *
 * @author Francisco
 */
public class Lista_controlador {
    
    private final BBDD_tareapp bbdd_tareapp = new BBDD_tareapp();
    
    /**
    * Función que permite crear una lista
    * 
    * @return Devuelve el resultado de crear la lista, si se consigue crear devuelve vacío y si no un mensaje de error
    */
    public String crear_lista(String titulo) {
    
        titulo = titulo.trim();
        
        if (titulo.length() > 50) return Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getTitulo_supera_caracteres(); // Si el título supera los 50 caracteres devuelve el error
        
        if (!Lista.es_titulo_valido(titulo)) return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getTitulo_no_valido(); // Comprueba que el texto sea válido
        
        String consulta = "INSERT INTO lista (titulo, email) VALUES ('"+titulo+"', '"+Usuario_controlador.getUsuario().getEmail()+"')";
        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return "";
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_no_creada();
        }
    }
    
    /**
    * Función que permite actualizar una lista
    * 
    * @return Devuelve el resultado de actualizar la lista, si se consigue actuializar la lista devuelve vacío y si no un mensaje de error
    */
    public String actualizar_lista(int idLista, String titulo) {
        
        titulo = titulo.trim();
        
        if (titulo.length() > 50) return Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getTitulo_supera_caracteres(); // Si el título supera los 50 caracteres devuelve el error
        
        if (!Lista.es_titulo_valido(titulo)) return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getTitulo_no_valido(); // Comprueba que el texto sea válido
        
        String consulta = "UPDATE lista SET titulo = '"+titulo+"' WHERE idLista = '"+idLista+"';";
        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return "";
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_no_editada();
        }
        
    }
    
    /**
    * Función que permite recoger las listas
    * 
    * @return Devuelve las listas en un array de arrays asociativos, si no encuentra listas devuelve null
    */
    public static ArrayList<HashMap<String, Object>> recoger_listas() {

        String consultaRecoger = "SELECT * FROM lista WHERE email = '" + Usuario_controlador.getUsuario().getEmail() + "' ORDER BY titulo ASC";
        ArrayList<HashMap<String, Object>> resultados = new BBDD_tareapp().consultar(consultaRecoger);
        
        if (resultados.isEmpty()) {
            
            return null;
            
        } else {
        
            return resultados;
        }
    }
    
    /**
    * Función que permite borrar una lista
    * 
    * @return Devuelve el resultado de borrar la lista, si se consigue borrar la lista devuelve vacío y si no un mensaje de error
    */
    public String borrar_lista(int idLista) {
        
        String consulta = "DELETE FROM lista WHERE idLista = '" + idLista + "'";
        
        if(bbdd_tareapp.borrar(consulta)) {
            
            return "";
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_no_borrada();
        }
    }
}
