/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.controlador;

import com.google.gson.Gson;
import com.mycompany.tareapp.modelo.idioma.Idiomas;
import com.mycompany.tareapp.vista.Tareas_view;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Propietario
 */
public class Idioma_controlador {

    private Idiomas idiomas;
    Tareas_view tareas_view;
    
    public Idioma_controlador() throws FileNotFoundException {
        
        convertirJsonEnClase();
    }

    public void cambiarIdioma(String idioma) {
        
        System.out.println("Idioma cambiado");
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

