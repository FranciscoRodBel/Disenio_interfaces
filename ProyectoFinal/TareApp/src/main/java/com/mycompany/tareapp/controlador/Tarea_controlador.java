/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.controlador;

import com.mycompany.tareapp.modelo.BBDD_tareapp;
import com.mycompany.tareapp.modelo.Tarea;
import com.mycompany.tareapp.modelo.idioma.Pagina_tareas;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Francisco
 */
public class Tarea_controlador {
    
    private final BBDD_tareapp bbdd_tareapp = new BBDD_tareapp();
    
    public String crear_tarea(String titulo, String prioridad, String fecha, String descripcion, int idLista) {
    
        Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();
        int prioridad_seleccionada = 1;
        
        if (prioridad.equals(idioma_tareas.getAlta())) {
            
            prioridad_seleccionada = 3;
            
        } else if (prioridad.equals(idioma_tareas.getMedia())) {
            
            prioridad_seleccionada = 2;
        }
        
        Tarea tarea = new Tarea(titulo, prioridad_seleccionada, fecha, descripcion, idLista);
        
        if (!tarea.es_texto_valido(titulo)) return "El título de la tarea no es válido";
        
        if (!tarea.es_fecha_valida()) return "La fecha no es válida, debe ser posterior al año 2000";
        
        if (!tarea.es_texto_valido(descripcion)) return "La descripción de la tarea no es válida";
        
        fecha = tarea.cambiar_string_a_date();
        
        String consulta = "INSERT INTO tarea (titulo, prioridad, fecha, descripcion, idLista) VALUES ('"+titulo+"', '"+prioridad_seleccionada+"', '"+fecha+"', '"+descripcion+"', '"+idLista+"')";
        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return "";
            
        } else {
            
            return "No se ha podido crear la tarea";
        }
    }
    
    public static ArrayList<HashMap<String, Object>> recoger_tareas(int idLista) {
    
        String consultaRecoger = "SELECT * FROM tarea WHERE idLista = '"+ idLista +"'";
        ArrayList<HashMap<String, Object>> resultados = new BBDD_tareapp().consultar(consultaRecoger);
        
        if (resultados.isEmpty()) {
            
            return null;
            
        } else {
        
            return resultados;
        }
    }
}
