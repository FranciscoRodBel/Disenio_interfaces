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
import com.mycompany.tareapp.vista.Tareas_view;
import com.mycompany.tareapp.vista.plantillas.Cabecera;
import java.io.File;
import java.io.FileNotFoundException;
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
    * @param idioma El idioma que se desea seleccionar, expresado en su nombre.
    */
    public static void cambiarIdioma(String idioma) {
        
        Cabecera cabecera = Cabecera.recoger_instancia();
        Iniciar_registrar_view iniciar_registrar_view = Iniciar_registrar_view.recoger_instancia();
        
        for (Idioma idioma_json : idiomas.getIdioma()) {
            
            if (idioma_json.getIdioma().equals(idioma)) {
                
                idioma_seleccionado = idioma_json;
                
                switch(idioma) {
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
        
        cabecera.getItemTareas().setText(idioma_seleccionado.getCabecera().getTareas());
        cabecera.getItemListas().setText(idioma_seleccionado.getCabecera().getListas());
        cabecera.getMenuIdioma().setText(idioma_seleccionado.getCabecera().getIdioma());
        cabecera.getMenuCuenta().setText(idioma_seleccionado.getCabecera().getCuenta());
        cabecera.getItemAjustes().setText(idioma_seleccionado.getCabecera().getAjustes());
        cabecera.getItemCerrarSesion().setText(idioma_seleccionado.getCabecera().getCerrar_sesion());
        
        iniciar_registrar_view.getTitulo_pagina_inicio().setText(idioma_seleccionado.getPagina_inicio_registro().getTitulo_inicio());
        iniciar_registrar_view.getTitulo_pagina_registro().setText(idioma_seleccionado.getPagina_inicio_registro().getTitulo_registro());
        iniciar_registrar_view.getBoton_iniciar().setText(idioma_seleccionado.getPagina_inicio_registro().getIniciar_sesion());
        iniciar_registrar_view.getBoton_registrarse().setText(idioma_seleccionado.getPagina_inicio_registro().getRegistrarse());
        iniciar_registrar_view.getContrasenia_iniciar().getPlaceholder().setText(idioma_seleccionado.getPagina_inicio_registro().getContrasenia());
        iniciar_registrar_view.getContrasenia_registro().getPlaceholder().setText(idioma_seleccionado.getPagina_inicio_registro().getContrasenia());
        iniciar_registrar_view.getRepetir_contrasenia_registro().getPlaceholder().setText(idioma_seleccionado.getPagina_inicio_registro().getRepetir_contrasenia());
        iniciar_registrar_view.getBoton_enviar_inicio().setText(idioma_seleccionado.getPagina_inicio_registro().getIniciar_sesion());
        iniciar_registrar_view.getBoton_enviar_registro().setText(idioma_seleccionado.getPagina_inicio_registro().getRegistrarse());
        
        if (Usuario_controlador.getUsuario() != null) {
        
            Tareas_view tareas_view = Tareas_view.recoger_instancia();
            Listas_view listas_view = Listas_view.recoger_instancia();
            Ajustes_cuenta_view ajustes_cuenta_view = Ajustes_cuenta_view.recoger_instancia();
            
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

            listas_view.getTitulo_pagina().setText(idioma_seleccionado.getPagina_listas().getTitulo());
            listas_view.getInput_titulo_lista().getPlaceholder().setText(idioma_seleccionado.getPagina_listas().getTitulo_lista());

            ajustes_cuenta_view.getTitulo_pagina().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getTitulo_pagina());
            ajustes_cuenta_view.getBoton_cambiar_email().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getCambiar_email());
            ajustes_cuenta_view.getBoton_cambiar_contrasenia().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getCambiar_contrasenia());
            ajustes_cuenta_view.getBoton_borrar_cuenta().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getBorrar_cuenta());
        }

    }
    
    public static void convertirJsonEnClase() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/main/java/com/mycompany/tareapp/vista/recursos/json/idiomas.json")); // Se recoge el json
        String json = "";

        while (scanner.hasNext()) {

            json += scanner.nextLine(); // Se guarda el texto del archivo en una variable
        }

        idiomas = new Gson().fromJson(json, Idiomas.class); // Se crea el objeto Gson y se convierte el texto del archivo JSON a la clase Idiomas
        idioma_seleccionado = idiomas.getIdioma().getFirst();
    }
}

