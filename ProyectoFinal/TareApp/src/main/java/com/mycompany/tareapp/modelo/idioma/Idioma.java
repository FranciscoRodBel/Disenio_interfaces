/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.modelo.idioma;

/**
 * Clase para el modelo del idioma
 *
 * @author Francisco
 */
public class Idioma {

    private String idioma = "Español";
    private Cabecera Cabecera;
    private Pagina_tareas Pagina_tareas;
    private Pagina_listas Pagina_listas;
    private Pagina_inicio_registro Pagina_inicio_registro;
    private Pagina_ajustes_cuenta Pagina_ajustes_cuenta;
    
    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Cabecera getCabecera() {
        return Cabecera;
    }

    public void setCabecera(Cabecera Cabecera) {
        this.Cabecera = Cabecera;
    }

    public Pagina_tareas getPagina_tareas() {
        return Pagina_tareas;
    }

    public void setPagina_tareas(Pagina_tareas Pagina_tareas) {
        this.Pagina_tareas = Pagina_tareas;
    }

    public Pagina_listas getPagina_listas() {
        return Pagina_listas;
    }

    public void setPagina_listas(Pagina_listas Pagina_listas) {
        this.Pagina_listas = Pagina_listas;
    }
    
    public Pagina_inicio_registro getPagina_inicio_registro() {
        return Pagina_inicio_registro;
    }

    public void setPagina_inicio_registro(Pagina_inicio_registro Pagina_inicio_registro) {
        this.Pagina_inicio_registro = Pagina_inicio_registro;
    }
    
    public Pagina_ajustes_cuenta getPagina_ajustes_cuenta() {
        return Pagina_ajustes_cuenta;
    }

    public void setPagina_ajustes_cuenta(Pagina_ajustes_cuenta Pagina_ajustes_cuenta) {
        this.Pagina_ajustes_cuenta = Pagina_ajustes_cuenta;
    }
}
