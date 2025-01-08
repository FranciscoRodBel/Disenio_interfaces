/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.controlador;

import com.google.gson.Gson;
import com.mycompany.tareapp.modelo.idioma.Idioma;
import com.mycompany.tareapp.modelo.idioma.Idiomas;
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

    private Idiomas idiomas;
    private Idioma idioma_seleccionado;
    
    public Idioma_controlador() throws FileNotFoundException {
        
        convertirJsonEnClase();
    }

    public void cambiarIdioma(String idioma, Cabecera cabecera, Tareas_view tareas_view, Listas_view listas_view, Iniciar_registrar_view iniciar_registrar_view) {
        
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
        //listas_view.getPlaceholder().setText(idioma_seleccionado.getPagina_listas().getInput_lista());
        listas_view.getInput_titulo_lista().getPlaceholder().setText(idioma_seleccionado.getPagina_listas().getInput_lista());
        
    }
    
    public void convertirJsonEnClase() throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/main/java/com/mycompany/tareapp/vista/recursos/json/idiomas.json")); // Se recoge el json
        String json = "";

        while (scanner.hasNext()) {

            json += scanner.nextLine(); // Se guarda el texto del archivo en una variable
        }

        System.out.println(json);
        idiomas = new Gson().fromJson(json, Idiomas.class); // Se crea el objeto Gson y se convierte el texto del archivo JSON a la clase Idiomas
    }
}

