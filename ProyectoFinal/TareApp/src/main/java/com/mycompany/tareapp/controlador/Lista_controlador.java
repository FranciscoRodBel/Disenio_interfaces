/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.controlador;

import com.mycompany.tareapp.modelo.BBDD_tareapp;
import com.mycompany.tareapp.modelo.Lista;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Propietario
 */
public class Lista_controlador {
    
    private final BBDD_tareapp bbdd_tareapp = new BBDD_tareapp();
    
    public String crear_lista(String titulo) {
    
        if (!Lista.es_titulo_valido(titulo)) return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getTitulo_no_valido();
        
        String consulta = "INSERT INTO lista (titulo, email) VALUES ('"+titulo+"', '"+Usuario_controlador.getUsuario().getEmail()+"')";
        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return "";
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_no_creada();
        }
    }
    
    public String actualizar_lista(int idLista, String titulo) {
    
        if (!Lista.es_titulo_valido(titulo)) return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getTitulo_no_valido();
        
        String consulta = "UPDATE lista SET titulo = '"+titulo+"' WHERE idLista = '"+idLista+"';";
        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return "";
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_no_editada();
        }
        
    }
    
    public static ArrayList<HashMap<String, Object>> recoger_listas() {
    
        String consultaRecoger = "SELECT * FROM lista WHERE email = '"+ Usuario_controlador.getUsuario().getEmail() +"'";
        ArrayList<HashMap<String, Object>> resultados = new BBDD_tareapp().consultar(consultaRecoger);
        
        if (resultados.isEmpty()) {
            
            return null;
            
        } else {
        
            return resultados;
        }
    }
    
    public String borrar_lista(int idLista) {
        
        String consulta = "DELETE FROM lista WHERE idLista = '" + idLista + "'";
        
        if(bbdd_tareapp.borrar(consulta)) {
            
            return "";
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_no_borrada();
        }
    }
}
