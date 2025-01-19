/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.modelo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Propietario
 */
public class Tarea {
    
    private int idTarea;
    private int completada;
    private String titulo;
    private int prioridad;
    private String fecha;
    private String descripcion;
    private int idLista;

    public Tarea(int idTarea, int completada, String titulo, int prioridad, String fecha, String descripcion, int idLista) {
        this.idTarea = idTarea;
        this.completada = completada;
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idLista = idLista;
    }

    public Tarea(String titulo, int prioridad, String fecha, String descripcion, int idLista) {
        this.titulo = titulo;
        this.prioridad = prioridad;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.idLista = idLista;
    }

    public int getIdTarea() {
        return idTarea;
    }

    public void setIdTarea(int idTarea) {
        this.idTarea = idTarea;
    }

    public int getCompletada() {
        return completada;
    }

    public void setCompletada(int completada) {
        this.completada = completada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdLista() {
        return idLista;
    }

    public void setIdLista(int idLista) {
        this.idLista = idLista;
    }
    
    public boolean es_texto_valido(String texto) {
        
        String expresion = "^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑüÜ\\s\\-\\_\\.\\,\\(\\)]+$";
        Pattern pattern = Pattern.compile(expresion);
        
        return pattern.matcher(texto).matches();
    }
    
    public boolean es_fecha_valida() {
        
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy"); // Creo un tipo de formato que será día/mes/año
        formatoFecha.setLenient(false); // Configuro el formato para que solo acepte fechas válidas y con el formato dicho anteriormente

        try {

            Date fechaIngresada = formatoFecha.parse(fecha); // Intento convertir la fecha a un tipo date, si no es válida generará un error

            // Si la fecha está en el formato válido y existe
            Date fechaMinima = formatoFecha.parse("01/01/2000"); // Creo una fecha mínima
            Date fechaMaxima = formatoFecha.parse("01/01/3000"); // Creo una fecha máxima

            // Si está entre la fecha mínima y la fecha actual, devolverá la fecha como válida y si no devolverá un mensaje de error
            if (fechaIngresada.before(fechaMinima)|| fechaIngresada.after(fechaMaxima)) {
                
                return false;
            }
 
            return true; // Fecha válida

        } catch (ParseException e) { // Si da error es que la fecha no era válida

            return false;
        }
    }

    public String cambiar_string_a_date() {
        
        try {
            
            SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha_transformada;
            fecha_transformada = formatoEntrada.parse(fecha);
            SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");
            return formatoSalida.format(fecha_transformada);
            
        } catch (ParseException ex) {
            
            Logger.getLogger(Tarea.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
}
