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
 *  Clase controladora de las tareas, con funciones para hacer el CRUD de las tareas
 * 
 * @author Francisco
 */
public class Tarea_controlador {
    
    private final BBDD_tareapp bbdd_tareapp = new BBDD_tareapp(); // Recojo la bbdd
    private static String consulta; // Guardo la consulta para que al actualizar el panel se mantengan los filtros
    
    /**
    * Función que permite crear tareas
    * 
    * @return Devuelve el resultado de crear la tarea, si se consigue crear devuelve vacío y si no un mensaje de error
    */
    public String crear_tarea(String titulo, String prioridad, String fecha, String descripcion, int idLista) {
    
        if (idLista != 0) {
        
            titulo = titulo.trim();
            prioridad = prioridad.trim();
            fecha = fecha.trim();
            descripcion = descripcion.trim();

            Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas(); // Recojo el idioma de tareas

            int prioridad_seleccionada = 1; // De manera predeterminada la prioridad se guardará como baja

            if (prioridad.equals(idioma_tareas.getAlta())) { // Si llega "Alta" en el idioma seleccionado, se asigna el 3

                prioridad_seleccionada = 3;

            } else if (prioridad.equals(idioma_tareas.getMedia())) { // Si llega "Media" en el idioma seleccionado, se asigna el 2

                prioridad_seleccionada = 2;
            }

            Tarea tarea = new Tarea(titulo, prioridad_seleccionada, fecha, descripcion, idLista); // Se crea la tarea con sus datos

            // Comprobaciones de los datos
            if (titulo.length() > 50) return idioma_tareas.getTitulo_supera_caracteres(); // Si el título supera los 50 caracteres devuelve el error

            if (!tarea.es_texto_valido(titulo)) return idioma_tareas.getTitulo_no_valido(); // Evita que tenga simbolos raros

            if (!tarea.es_fecha_valida()) return idioma_tareas.getFecha_no_valida(); // Comprueba que la fecha sea real y esté en el formato correcto

            if (descripcion.length() > 500) return idioma_tareas.getDescripcion_supera_caracteres();  // Si la descripción supera los 500 caracteres devuelve el error

            if (!tarea.es_texto_valido(descripcion)) return idioma_tareas.getDescripcion_no_valida(); // Evita que tenga simbolos raros

            fecha = tarea.cambiar_string_a_date(); // cambia la fecha de String a tipo Date para la BBDD

            String consulta = "INSERT INTO tarea (titulo, prioridad, fecha, descripcion, idLista) VALUES ('"+titulo+"', '"+prioridad_seleccionada+"', '"+fecha+"', '"+descripcion+"', '"+idLista+"')";

            if(bbdd_tareapp.insertar(consulta)) { // Devolverá true si se alamacena correctamente

                return ""; // Si se inserta devuelve vacío

            } else { 

                return idioma_tareas.getTarea_no_creada(); // Si no se inserta devuelve el mensaje correspondiente
            }
            
        } else {
            
            return "Debe seleccionar una lista";
        }
    }
    
    /**
    * Función que permite recoger todas las tareas de un usuario
    * 
    * @return Devuelve un array de arrays asociativos con el nombre de la propiedad y su valor.
    */
    public static ArrayList<HashMap<String, Object>> recoger_tareas(String consulta) {
    
        if (consulta.isEmpty()) { // Si viene vacío es porque simplemente se ha actualizado el panel por actualización de las listas o tareas creadas, actualizadas, borradas...
            
            consulta = Tarea_controlador.consulta; // Recoge la consulta de filtro que se guardó
                    
        } else { // Si envía una consulta es poque ha cambiado el filtro
            
            Tarea_controlador.consulta = consulta; // Guarda la nueva consulta
        }
        
        ArrayList<HashMap<String, Object>> resultados = new BBDD_tareapp().consultar(consulta); // Recoge los datos
        
        if (resultados.isEmpty()) { // Si no hay tareas creadas devuleve null y si no los datos
            
            return null;
            
        } else {
        
            return resultados;
        }
    }
    
    /**
    * Función que permite editar una tarea de un usuario
    * 
    * @return Devuelve el resultado de editar la tarea, si se consigue editar devuelve vacío y si no un mensaje de error
    */
    public String editar_tarea(int idTarea, String titulo, String prioridad, String fecha, String descripcion, int idLista) {
    
        titulo = titulo.trim();
        prioridad = prioridad.trim();
        fecha = fecha.trim();
        descripcion = descripcion.trim();
        
        Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas(); // Recojo el idioma de tareas
        
        int prioridad_seleccionada = 1; // De manera predeterminada la prioridad se guardará como baja
        
        if (prioridad.equals(idioma_tareas.getAlta())) { // Si llega "Alta" en el idioma seleccionado, se asigna el 3
            
            prioridad_seleccionada = 3;
            
        } else if (prioridad.equals(idioma_tareas.getMedia())) { // Si llega "Media" en el idioma seleccionado, se asigna el 2
            
            prioridad_seleccionada = 2;
        }
        
        Tarea tarea = new Tarea(titulo, prioridad_seleccionada, fecha, descripcion, idLista); // Se crea la tarea con sus datos
        
        // Comprobaciones de los datos
        if (titulo.length() > 50) return idioma_tareas.getTitulo_supera_caracteres(); // Si el título supera los 50 caracteres devuelve el error
        
        if (!tarea.es_texto_valido(titulo)) return idioma_tareas.getTitulo_no_valido(); // Evita que tenga simbolos raros
        
        if (!tarea.es_fecha_valida()) return idioma_tareas.getFecha_no_valida(); // Comprueba que la fecha sea real y esté en el formato correcto
        
        if (descripcion.length() > 500) return idioma_tareas.getDescripcion_supera_caracteres();  // Si la descripción supera los 500 caracteres devuelve el error
        
        if (!tarea.es_texto_valido(descripcion)) return idioma_tareas.getDescripcion_no_valida(); // Evita que tenga simbolos raros
        
        fecha = tarea.cambiar_string_a_date(); // cambia la fecha de String a tipo Date para la BBDD
        
        String consulta = "UPDATE tarea SET titulo = '" + titulo + "', prioridad = '" + prioridad_seleccionada + "', fecha = '" + fecha + "', descripcion = '" + descripcion + "', idLista = '" + idLista + "' WHERE idTarea = " + idTarea;

        if(bbdd_tareapp.insertar(consulta)) { // Devolverá true si se edita correctamente
            
            return ""; // Si se edita devuelve vacío
            
        } else {
            
            return idioma_tareas.getTarea_no_editada(); // Si no se edita devuelve el mensaje correspondiente
        }
    }
    
    /**
    * Función que permite borrar una tarea
    * 
    * @return Devuelve el resultado de borrar la tarea, si se consigue borrar devuelve vacío y si no un mensaje de error
    */
    public String borrar_tarea(int idTarea) {
        
        String consulta = "DELETE FROM tarea WHERE idTarea = '" + idTarea + "'";
        
        if(bbdd_tareapp.borrar(consulta)) {
            
            return ""; 
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getTarea_no_borrada();
        }
    }
    
    /**
    * Función que permite marcar una tarea como completada o incompleta
    * 
    * @return Devuelve true si se consigue guardar la tarea y false si no se guarda
    */
    public Boolean completarTarea(int idTarea, int completada) {
        
        String consulta = "UPDATE tarea SET completada = '" + completada + "' WHERE idTarea = " + idTarea;

        return bbdd_tareapp.insertar(consulta);
    }
    
    /**
    * Función que permite crear la consulta basandose en los filtros
    * Se pasan como parámetros el estado de los filtros, si están marcados sí o no
    * 
    * @return Devuelve la consulta generada
    */
    public static String generarConsulta(int idLista, boolean completadas, boolean incompletas, boolean prioridadBaja, boolean prioridadMedia, boolean prioridadAlta, String ordenacion) {
    
        String consulta = "SELECT * FROM tarea WHERE idLista = '"+ idLista +"'";
        
        // Filtro de si está marcada
        if (completadas && !incompletas) consulta += "AND (completada = 1) ";
        if (!completadas && incompletas) consulta += "AND (completada = 0) ";
        if (completadas && incompletas) consulta += "AND (completada = 1 OR completada = 0) ";
       
        // Filtro de la prioridad
        if (prioridadBaja && !prioridadMedia && !prioridadAlta) consulta += "AND (prioridad = 1) ";
        if (!prioridadBaja && prioridadMedia && !prioridadAlta) consulta += "AND (prioridad = 2) ";
        if (!prioridadBaja && !prioridadMedia && prioridadAlta) consulta += "AND (prioridad = 3) ";
        if (prioridadBaja && prioridadMedia && !prioridadAlta) consulta += "AND (prioridad = 1 OR prioridad = 2) ";
        if (!prioridadBaja && prioridadMedia && prioridadAlta) consulta += "AND (prioridad = 2 OR prioridad = 3) ";
        if (prioridadBaja && !prioridadMedia && prioridadAlta) consulta += "AND (prioridad = 3 OR prioridad = 1) ";
        if (prioridadBaja && prioridadMedia && prioridadAlta) consulta += "AND (prioridad = 1 OR prioridad = 2 OR prioridad = 3) ";
        
        // Filtro del orden de las tareas
        switch(ordenacion) {
            case "AZ" -> consulta += "ORDER BY titulo ASC";
            case "ZA" -> consulta += "ORDER BY titulo DESC";
            case "91" -> consulta += "ORDER BY fecha DESC";
            default -> consulta += "ORDER BY fecha ASC";
         }
        
        return consulta;
    }
}
