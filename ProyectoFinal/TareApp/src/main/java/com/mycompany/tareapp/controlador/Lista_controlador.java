/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.controlador;

import com.mycompany.tareapp.modelo.BBDD_tareapp;
import com.mycompany.tareapp.modelo.Usuario;
import com.mycompany.tareapp.modelo.Lista;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Propietario
 */
public class Lista_controlador {
    
    private final BBDD_tareapp bbdd_tareapp = new BBDD_tareapp();
    
    public String crear_lista(String titulo, String email) {
    
        Lista lista = new Lista(titulo, email);
        
        if (!lista.es_titulo_valido(titulo)) return "El título de la lista no es válido";
        
        String consulta = "INSERT INTO lista (titulo, email) VALUES ('"+titulo+"', '"+email+"')";
        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return "";
            
        } else {
            
            return "No se ha podido crear la lista";
        }
    }
    
    public static ArrayList<HashMap<String, Object>> recoger_listas(String email) {
    
        String consultaRecoger = "SELECT * FROM lista WHERE email = '"+ email +"'";
        ArrayList<HashMap<String, Object>> resultados = new BBDD_tareapp().consultar(consultaRecoger);
        
        if (resultados.isEmpty()) {
            
            return null;
            
        } else {
        
            return resultados;
        }
    }
}
