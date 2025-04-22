/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tareapp.controlador;

import android.content.Context;

import com.google.gson.Gson;
import com.example.tareapp.modelo.idioma.Idioma;
import com.example.tareapp.modelo.idioma.Idiomas;
import java.io.IOException;
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

        if (Usuario_controlador.getUsuario() != null) {
            new Thread(() -> {

                new Usuario_controlador().actualizar_idioma(idioma);

            }).start();
        }

        for (Idioma idioma_json : idiomas.getIdioma()) { // Recorro los idiomas
            
            if (idioma_json.getIdioma().equals(idioma)) { // Si el idioma recorrido es igual al que se está cambiando
                
                idioma_seleccionado = idioma_json; // Guardo el idioma como el seleccionado
                
                switch(idioma) { // Selecciono en la cabecera el idioma seleccionado - Esto es para cuando inicia sesión, ya que el idioma se pone en base a lo que tiene en la bbdd sin pulsar en la cabacera
                    case "Français":
                        //cabecera.getItemFrances().setSelected(true);
                        
                      break;
                    case "English":
                        //cabecera.getItemIngles().setSelected(true);
                      break;
                    default:
                        //cabecera.getItemEspaniol().setSelected(true);
                }
            }
        }
    }
    
    /**
    * Recoge el fichero json y lo pasa a la clase de Idiomas
    * 
    */
    public static void convertirJsonEnClase(Context context) throws IOException {


        InputStream jsonStream = context.getAssets().open("json/idiomas.json"); // Recoge el json
        Scanner scanner = new Scanner(jsonStream, "UTF-8");
        StringBuilder jsonBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            jsonBuilder.append(scanner.nextLine()); // Se guarda el texto del archivo en una variable
        }

        scanner.close();
        idiomas = new Gson().fromJson(jsonBuilder.toString(), Idiomas.class); // Se crea el objeto Gson y se convierte el texto del archivo JSON a la clase Idiomas
        idioma_seleccionado = idiomas.getIdioma().get(0);
    }
}

