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
    private static String consulta;
    
    public String crear_tarea(String titulo, String prioridad, String fecha, String descripcion, int idLista) {
    
        Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();
        int prioridad_seleccionada = 1;
        
        if (prioridad.equals(idioma_tareas.getAlta())) {
            
            prioridad_seleccionada = 3;
            
        } else if (prioridad.equals(idioma_tareas.getMedia())) {
            
            prioridad_seleccionada = 2;
        }
        
        Tarea tarea = new Tarea(titulo, prioridad_seleccionada, fecha, descripcion, idLista);
        
        if (titulo.length() > 50) return idioma_tareas.getTitulo_supera_caracteres();
        
        if (!tarea.es_texto_valido(titulo)) return idioma_tareas.getTitulo_no_valido();
        
        if (!tarea.es_fecha_valida()) return idioma_tareas.getFecha_no_valida();
        
        if (titulo.length() > 500) return idioma_tareas.getDescripcion_supera_caracteres();
        
        if (!tarea.es_texto_valido(descripcion)) return idioma_tareas.getDescripcion_no_valida();
        
        fecha = tarea.cambiar_string_a_date();
        
        String consulta = "INSERT INTO tarea (titulo, prioridad, fecha, descripcion, idLista) VALUES ('"+titulo+"', '"+prioridad_seleccionada+"', '"+fecha+"', '"+descripcion+"', '"+idLista+"')";
        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return "";
            
        } else {
            
            return idioma_tareas.getTarea_no_borrada();
        }
    }
    
    public static ArrayList<HashMap<String, Object>> recoger_tareas(String consulta) {
    
        if (consulta.isEmpty()) {
            
            consulta = Tarea_controlador.consulta;
                    
        } else {
            
            Tarea_controlador.consulta = consulta;
        }
        
        ArrayList<HashMap<String, Object>> resultados = new BBDD_tareapp().consultar(consulta);
        
        if (resultados.isEmpty()) {
            
            return null;
            
        } else {
        
            return resultados;
        }
    }
    
    public String editar_tarea(int idTarea, String titulo, String prioridad, String fecha, String descripcion, int idLista) {
    
        Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();
        int prioridad_seleccionada = 1;
        
        if (prioridad.equals(idioma_tareas.getAlta())) {
            
            prioridad_seleccionada = 3;
            
        } else if (prioridad.equals(idioma_tareas.getMedia())) {
            
            prioridad_seleccionada = 2;
        }
        
        Tarea tarea = new Tarea(titulo, prioridad_seleccionada, fecha, descripcion, idLista);
        
        if (titulo.length() > 50) return idioma_tareas.getTitulo_supera_caracteres();
        
        if (!tarea.es_texto_valido(titulo)) return idioma_tareas.getTitulo_no_valido();
        
        if (!tarea.es_fecha_valida()) return idioma_tareas.getFecha_no_valida();
        
        if (titulo.length() > 500) return idioma_tareas.getDescripcion_supera_caracteres();
        
        if (!tarea.es_texto_valido(descripcion)) return idioma_tareas.getDescripcion_no_valida();
        
        fecha = tarea.cambiar_string_a_date();
        
        String consulta = "UPDATE tarea SET titulo = '" + titulo + "', prioridad = '" + prioridad_seleccionada + "', fecha = '" + fecha + "', descripcion = '" + descripcion + "', idLista = '" + idLista + "' WHERE idTarea = " + idTarea;

        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return "";
            
        } else {
            
            return idioma_tareas.getTarea_no_editada();
        }
    }
    
    public String borrar_tarea(int idTarea) {
        
        String consulta = "DELETE FROM tarea WHERE idTarea = '" + idTarea + "'";
        
        if(bbdd_tareapp.borrar(consulta)) {
            
            return "";
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getTarea_no_borrada();
        }
    }
    
    public Boolean completarTarea(int idTarea, int completada) {
        
        String consulta = "UPDATE tarea SET completada = '" + completada + "' WHERE idTarea = " + idTarea;

        return bbdd_tareapp.insertar(consulta);
    }
    
    public static String generarConsulta(int idLista, boolean completadas, boolean incompletas, boolean prioridadBaja, boolean prioridadMedia, boolean prioridadAlta, String ordenacion) {
    
        String consulta = "SELECT * FROM tarea WHERE idLista = '"+ idLista +"'";
        
        //SELECT * FROM tareapp.tarea WHERE idLista = 8 AND (completada = 1 OR completada = 0) AND (prioridad = 1 OR prioridad = 2 OR prioridad = 3) ORDER BY titulo ASC;
        
        if (completadas && !incompletas) consulta += "AND (completada = 1) ";
        if (!completadas && incompletas) consulta += "AND (completada = 0) ";
        if (completadas && incompletas) consulta += "AND (completada = 1 OR completada = 0) ";
       
        
        if (prioridadBaja && !prioridadMedia && !prioridadAlta) consulta += "AND (prioridad = 1) ";
        if (!prioridadBaja && prioridadMedia && !prioridadAlta) consulta += "AND (prioridad = 2) ";
        if (!prioridadBaja && !prioridadMedia && prioridadAlta) consulta += "AND (prioridad = 3) ";
        if (prioridadBaja && prioridadMedia && !prioridadAlta) consulta += "AND (prioridad = 1 OR prioridad = 2) ";
        if (!prioridadBaja && prioridadMedia && prioridadAlta) consulta += "AND (prioridad = 2 OR prioridad = 3) ";
        if (prioridadBaja && !prioridadMedia && prioridadAlta) consulta += "AND (prioridad = 3 OR prioridad = 1) ";
        if (prioridadBaja && prioridadMedia && prioridadAlta) consulta += "AND (prioridad = 1 OR prioridad = 2 OR prioridad = 3) ";
        
        switch(ordenacion) {
            case "AZ" -> consulta += "ORDER BY titulo ASC";
            case "ZA" -> consulta += "ORDER BY titulo DESC";
            case "91" -> consulta += "ORDER BY fecha DESC";
            default -> consulta += "ORDER BY fecha ASC";
         }
        
        return consulta;
    }
}
