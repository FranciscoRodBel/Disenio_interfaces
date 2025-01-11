/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.controlador;

import com.google.gson.Gson;
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
 *
 * @author Propietario
 */
public class Idioma_controlador {

    private static Idiomas idiomas;
    private static Idioma idioma_seleccionado;
    
    static {
        try {
            convertirJsonEnClase();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Idiomas getIdiomas() {
        return idiomas;
    }

    public static void setIdiomas(Idiomas idiomas) {
        Idioma_controlador.idiomas = idiomas;
    }

    public static Idioma getIdioma_seleccionado() {
        return idioma_seleccionado;
    }

    public static void setIdioma_seleccionado(Idioma idioma_seleccionado) {
        Idioma_controlador.idioma_seleccionado = idioma_seleccionado;
    }
    
    public static void cambiarIdioma(String idioma, Cabecera cabecera, Tareas_view tareas_view, Listas_view listas_view, Iniciar_registrar_view iniciar_registrar_view, Ajustes_cuenta_view ajustes_cuenta_view) {
        
        for (Idioma idioma_json : idiomas.getIdioma()) {
            
            if (idioma_json.getIdioma().equals(idioma)) {
                
                idioma_seleccionado = idioma_json;
            }
        }
        
        cabecera.getItemTareas().setText(idioma_seleccionado.getCabecera().getTareas());
        cabecera.getItemListas().setText(idioma_seleccionado.getCabecera().getListas());
        cabecera.getMenuIdioma().setText(idioma_seleccionado.getCabecera().getIdioma());
        cabecera.getMenuCuenta().setText(idioma_seleccionado.getCabecera().getCuenta());
        cabecera.getItemAjustes().setText(idioma_seleccionado.getCabecera().getAjustes());
        cabecera.getItemCerrarSesion().setText(idioma_seleccionado.getCabecera().getCerrar_sesion());
        
        
        tareas_view.getTitulo_pagina().setText(idioma_seleccionado.getPagina_tareas().getTitulo());
        tareas_view.getSeleccionarLista().insertItemAt(idioma_seleccionado.getPagina_tareas().getSeleccionar_lista(), 0);
        tareas_view.getSeleccionarLista().removeItemAt(1);
        listas_view.getTitulo_pagina().setText(idioma_seleccionado.getPagina_listas().getTitulo());
        listas_view.getInput_titulo_lista().getPlaceholder().setText(idioma_seleccionado.getPagina_listas().getTitulo_lista());
        
        
        iniciar_registrar_view.getTitulo_pagina_inicio().setText(idioma_seleccionado.getPagina_inicio_registro().getTitulo_inicio());
        iniciar_registrar_view.getTitulo_pagina_registro().setText(idioma_seleccionado.getPagina_inicio_registro().getTitulo_registro());
        iniciar_registrar_view.getBoton_iniciar().setText(idioma_seleccionado.getPagina_inicio_registro().getIniciar_sesion());
        iniciar_registrar_view.getBoton_registrarse().setText(idioma_seleccionado.getPagina_inicio_registro().getRegistrarse());
        iniciar_registrar_view.getContrasenia_iniciar().getPlaceholder().setText(idioma_seleccionado.getPagina_inicio_registro().getContrasenia());
        iniciar_registrar_view.getContrasenia_registro().getPlaceholder().setText(idioma_seleccionado.getPagina_inicio_registro().getContrasenia());
        iniciar_registrar_view.getRepetir_contrasenia_registro().getPlaceholder().setText(idioma_seleccionado.getPagina_inicio_registro().getRepetir_contrasenia());
        iniciar_registrar_view.getBoton_enviar_inicio().setText(idioma_seleccionado.getPagina_inicio_registro().getIniciar_sesion());
        iniciar_registrar_view.getBoton_enviar_registro().setText(idioma_seleccionado.getPagina_inicio_registro().getRegistrarse());
     
        
        ajustes_cuenta_view.getTitulo_pagina().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getTitulo_pagina());
        ajustes_cuenta_view.getBoton_cambiar_email().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getCambiar_email());
        ajustes_cuenta_view.getBoton_cambiar_contrasenia().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getCambiar_contrasenia());
        ajustes_cuenta_view.getBoton_borrar_cuenta().setText(idioma_seleccionado.getPagina_ajustes_cuenta().getBorrar_cuenta());
    }
    
    public static void convertirJsonEnClase() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/main/java/com/mycompany/tareapp/vista/recursos/json/idiomas.json")); // Se recoge el json
        String json = "";

        while (scanner.hasNext()) {

            json += scanner.nextLine(); // Se guarda el texto del archivo en una variable
        }

        idiomas = new Gson().fromJson(json, Idiomas.class); // Se crea el objeto Gson y se convierte el texto del archivo JSON a la clase Idiomas
    }
}

