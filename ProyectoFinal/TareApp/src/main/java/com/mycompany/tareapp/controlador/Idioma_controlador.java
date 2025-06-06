/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.controlador;

import com.google.gson.Gson;
import com.mycompany.tareapp.modelo.Lista;
import com.mycompany.tareapp.modelo.idioma.Idioma;
import com.mycompany.tareapp.modelo.idioma.Idiomas;
import com.mycompany.tareapp.vista.Ajustes_cuenta_view;
import com.mycompany.tareapp.vista.Iniciar_registrar_view;
import com.mycompany.tareapp.vista.Listas_view;
import com.mycompany.tareapp.vista.Notas_view;
import com.mycompany.tareapp.vista.Tareas_view;
import com.mycompany.tareapp.vista.plantillas.Cabecera;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * Controlador para realizar los cambios de idioma.
 * 
 * Esta clase carga el json con los idiomas y cunado se solicita, cambia todos los textos de la app al idioma seleccionado.
 * 
 * @author Francisco
 */
public class Idioma_controlador {

    private static Idiomas idiomas; // Array con todos los idiomas
    private static Idioma idioma_seleccionado;
    
    static { // Clase estática para que cualquiera pueda acceder a ella sin instanciarla
        try {
            
            convertirJsonEnClase();
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    /**
    * 
    * @return Devuelve el array de idiomas
    */
    public static Idiomas getIdiomas() {
        return idiomas;
    }
    
    /**
    * 
    * @return Objeto del idioma seleccionado
    */
    public static Idioma getIdioma_seleccionado() {
        return idioma_seleccionado;
    }
    
    /**
    * Coge todos los textos y los cambia por el mismo texto pero con el idioma seleccionado
    * 
    * @param idioma El idioma que se desea seleccionar.
    */
    public static void cambiarIdioma(String idioma) {
        
        Cabecera cabecera = Cabecera.recoger_instancia();
        Iniciar_registrar_view iniciar_registrar_view = Iniciar_registrar_view.recoger_instancia();
        
        for (Idioma idioma_json : idiomas.getIdioma()) { // Recorro los idiomas
            
            if (idioma_json.getIdioma().equals(idioma)) { // Si el idioma recorrido es igual al que se está cambiando
                
                idioma_seleccionado = idioma_json; // Guardo el idioma como el seleccionado
                
                switch(idioma) { // Selecciono en la cabecera el idioma seleccionado - Esto es para cuando inicia sesión, ya que el idioma se pone en base a lo que tiene en la bbdd sin pulsar en la cabacera
                    case "Français":
                        cabecera.getItemFrances().setSelected(true);
                        
                      break;
                    case "English":
                        cabecera.getItemIngles().setSelected(true);
                      break;
                    default:
                        cabecera.getItemEspaniol().setSelected(true);
                }
            }
        }
        
        // Cambio de idioma en los textos
        
        // Textos de la cabecera
        cabecera.getItemTareas().setText(idioma_seleccionado.getCabecera().getTareas());
        cabecera.getItemListas().setText(idioma_seleccionado.getCabecera().getListas());
        cabecera.getMenuIdioma().setText(idioma_seleccionado.getCabecera().getIdioma());
        cabecera.getItemNotas().setText(idioma_seleccionado.getCabecera().getNotas());
        cabecera.getMenuCuenta().setText(idioma_seleccionado.getCabecera().getCuenta());
        cabecera.getItemAjustes().setText(idioma_seleccionado.getCabecera().getAjustes());
        cabecera.getItemCerrarSesion().setText(idioma_seleccionado.getCabecera().getCerrar_sesion());
        
        
        // Textos de la página de inicio y registro
        iniciar_registrar_view.getTitulo_pagina_inicio().setText(idioma_seleccionado.getPagina_inicio_registro().getTitulo_inicio());
        iniciar_registrar_view.getTitulo_pagina_registro().setText(idioma_seleccionado.getPagina_inicio_registro().getTitulo_registro());
        iniciar_registrar_view.getBoton_iniciar().setText(idioma_seleccionado.getPagina_inicio_registro().getIniciar_sesion());
        iniciar_registrar_view.getBoton_registrarse().setText(idioma_seleccionado.getPagina_inicio_registro().getRegistrarse());
        iniciar_registrar_view.getContrasenia_iniciar().getPlaceholder().setText(idioma_seleccionado.getPagina_inicio_registro().getContrasenia());
        iniciar_registrar_view.getContrasenia_registro().getPlaceholder().setText(idioma_seleccionado.getPagina_inicio_registro().getContrasenia());
        iniciar_registrar_view.getRepetir_contrasenia_registro().getPlaceholder().setText(idioma_seleccionado.getPagina_inicio_registro().getRepetir_contrasenia());
        iniciar_registrar_view.getBoton_enviar_inicio().setText(idioma_seleccionado.getPagina_inicio_registro().getIniciar_sesion());
        iniciar_registrar_view.getBoton_enviar_registro().setText(idioma_seleccionado.getPagina_inicio_registro().getRegistrarse());
        
        if (Usuario_controlador.getUsuario() != null) { // Si el usuario está inciado cambio el idioma de los demás paneles
        
            // Recojo los paneles de las vistas
            Tareas_view tareas_view = Tareas_view.recoger_instancia();
            Listas_view listas_view = Listas_view.recoger_instancia();
            Ajustes_cuenta_view ajustes_cuenta_view = Ajustes_cuenta_view.recoger_instancia();
            Notas_view notas_view = Notas_view.recoger_instancia();
            
            
            // Textos de la página de tareas
            tareas_view.getTitulo_pagina().setText(idioma_seleccionado.getPagina_tareas().getTitulo());
            tareas_view.getSeleccionarLista().insertItemAt(new Lista(0, idioma_seleccionado.getPagina_tareas().getSeleccionar_lista(), ""), 0);
            tareas_view.getSeleccionarLista().removeItemAt(1);

            // Idioma del Tooltip
            tareas_view.getBotonCrearTarea().setToolTipText(idioma_seleccionado.getPagina_tareas().getCrear_tarea());
            tareas_view.getBotonTareasCompletadas().setToolTipText(idioma_seleccionado.getPagina_tareas().getMostrar_tareas_completadas());
            tareas_view.getBotonTareasIncompletas().setToolTipText(idioma_seleccionado.getPagina_tareas().getMostrar_tareas_incompletas());
            tareas_view.getBotonPrioridadBaja().setToolTipText(idioma_seleccionado.getPagina_tareas().getMostrar_prioridad_baja());
            tareas_view.getBotonPrioridadMedia().setToolTipText(idioma_seleccionado.getPagina_tareas().getMostrar_prioridad_media());
            tareas_view.getBotonPrioridadAlta().setToolTipText(idioma_seleccionado.getPagina_tareas().getMostrar_prioridad_alta());
            tareas_view.getBotonOrdenado19().setToolTipText(idioma_seleccionado.getPagina_tareas().getMostrar_tareas_19());
            tareas_view.getBotonOrdenado91().setToolTipText(idioma_seleccionado.getPagina_tareas().getMostrar_tareas_91());
            tareas_view.getBotonOrdenadoAZ().setToolTipText(idioma_seleccionado.getPagina_tareas().getMostrar_tareas_az());
            tareas_view.getBotonOrdenadoZA().setToolTipText(idioma_seleccionado.getPagina_tareas().getMostrar_tareas_za());

            // Textos de la página de listas
            listas_view.getTitulo_pagina().setText(idioma_seleccionado.getPagina_listas().getTitulo());
            listas_view.getInput_titulo_lista().getPlaceholder().setText(idioma_seleccionado.getPagina_listas().getTitulo_lista());

            // Textos de la página de ajustes
            ajustes_cuenta_view.getTitulo_pagina().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getTitulo_pagina());
            ajustes_cuenta_view.getBoton_cambiar_email().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getCambiar_email());
            ajustes_cuenta_view.getBoton_cambiar_contrasenia().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getCambiar_contrasenia());
            ajustes_cuenta_view.getBoton_borrar_cuenta().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getBorrar_cuenta());
            
            
            // Textos de la página de notas
            notas_view.getTitulo_pagina().setText(idioma_seleccionado.getPagina_notas().getTitulo());
            notas_view.getBotonCrearTarea().setText(idioma_seleccionado.getPagina_notas().getCrear_nota());
        }

    }
    
    /**
    * Recoge el fichero json y lo pasa a la clase de Idiomas
    * 
    */
    public static void convertirJsonEnClase() throws FileNotFoundException {
        
        InputStream jsonStream = Idioma_controlador.class.getResourceAsStream("/json/idiomas.json"); // Recoge la fuente
        Scanner scanner = new Scanner(jsonStream, "UTF-8");
        String json = "";

        while (scanner.hasNext()) {
            json += scanner.nextLine(); // Se guarda el texto del archivo en una variable
        }

        idiomas = new Gson().fromJson(json, Idiomas.class); // Se crea el objeto Gson y se convierte el texto del archivo JSON a la clase Idiomas
        idioma_seleccionado = idiomas.getIdioma().getFirst();
    }
}

