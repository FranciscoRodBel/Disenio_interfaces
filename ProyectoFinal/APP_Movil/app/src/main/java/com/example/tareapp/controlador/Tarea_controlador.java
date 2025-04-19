/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tareapp.controlador;

import com.example.tareapp.modelo.BBDD_tareapp;
import com.example.tareapp.modelo.Tarea;
import com.example.tareapp.modelo.idioma.Pagina_tareas;
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
    public String crear_tarea(String titulo, int prioridad, String fecha, String descripcion, int idLista) {

        Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

        if (idLista == 0) {
            return idioma_tareas.getLista_no_seleccionada();
        }

        Object resultado = validarTarea(titulo, prioridad, fecha, descripcion, idLista);

        if (resultado instanceof String) {

            return (String) resultado;
        }

        Tarea tarea = (Tarea) resultado;

        String consulta = "INSERT INTO tarea (titulo, prioridad, fecha, descripcion, idLista) VALUES ('" + tarea.getTitulo() + "', '" + tarea.getPrioridad() + "', '" + tarea.getFecha() + "', '" + tarea.getDescripcion() + "', '" + tarea.getIdLista() + "')";

        return bbdd_tareapp.insertar(consulta) ? "" : idioma_tareas.getTarea_no_creada();
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
    public String editar_tarea(int idTarea, String titulo, int prioridad, String fecha, String descripcion, int idLista) {

        Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

        Object resultado = validarTarea(titulo, prioridad, fecha, descripcion, idLista);

        if (resultado instanceof String) {
            return (String) resultado;
        }

        Tarea tarea = (Tarea) resultado;

        String consulta = "UPDATE tarea SET titulo = '" + tarea.getTitulo() + "', prioridad = '" + tarea.getPrioridad() + "', fecha = '" + tarea.getFecha() + "', descripcion = '" + tarea.getDescripcion() + "', idLista = '" + tarea.getIdLista() + "' WHERE idTarea = " + idTarea;

        return bbdd_tareapp.insertar(consulta) ? "" : idioma_tareas.getTarea_no_editada();
    }

    private Object validarTarea(String titulo, int prioridad, String fecha, String descripcion, int idLista) {

        Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

        titulo = titulo.trim();
        fecha = fecha.trim();
        descripcion = descripcion.trim();
        prioridad = (prioridad == 0) ? 1 : prioridad;

        Tarea tarea = new Tarea(titulo, prioridad, fecha, descripcion, idLista);

        if (titulo.length() > 50) return idioma_tareas.getTitulo_supera_caracteres();
        if (!tarea.es_texto_valido(titulo)) return idioma_tareas.getTitulo_no_valido();
        if (!tarea.es_fecha_valida()) return idioma_tareas.getFecha_no_valida();
        if (descripcion.length() > 500) return idioma_tareas.getDescripcion_supera_caracteres();
        if (!tarea.es_texto_valido(descripcion)) return idioma_tareas.getDescripcion_no_valida();

        tarea.setFecha(tarea.cambiar_string_a_date());

        return tarea;
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
        /*
        switch(ordenacion) {
            case "AZ" -> consulta += "ORDER BY titulo ASC";
            case "ZA" -> consulta += "ORDER BY titulo DESC";
            case "91" -> consulta += "ORDER BY fecha DESC";
            default -> consulta += "ORDER BY fecha ASC";
         }
         */

        
        return consulta;
    }
}
