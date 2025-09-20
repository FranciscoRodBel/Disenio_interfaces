/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tareapp.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import at.favre.lib.crypto.bcrypt.BCrypt;

/**
 * Clase para el modelo del usuario
 * Tiene las propiedades del usuario y sus funciones necesarias
 *
 * @author Francisco
 */
public class Usuario {
    
    private String email;
    private String contrasenia;
    private String idioma_seleccionado;
    private String token;

    public Usuario(String email) {
        this.email = email;
    }


    /**
    * Constructor de la tarea con el idioma, es el que se utiliza para guardar el objeto del usuario con la sesión iniciada
    * 
    */
    public Usuario(String email, String contrasenia, String idioma_seleccionado) {
        this.email = email;
        this.contrasenia = contrasenia;
        this.idioma_seleccionado = idioma_seleccionado;
    }
    
    /**
    * Constructor de la tarea sin el idioma
    * 
    */
    public Usuario(String email, String contrasenia) {
        this.email = email;
        this.contrasenia = contrasenia;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdioma_seleccionado() {
        return idioma_seleccionado;
    }

    public void setIdioma_seleccionado(String idioma_seleccionado) {
        this.idioma_seleccionado = idioma_seleccionado;
    }

    /**
    * Función que permite comprobar si el email pasado tiene el formato debido
    * 
    * @return Devuelvo true si el formato es correcto
    */
    public static boolean es_email_valido(String email) {
        
        // Pattern sacado de: https://www.baeldung.com/java-email-validation-regex
        String expresion = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(expresion); 
        
        return pattern.matcher(email).matches(); // comprueba la expresión regular
    }
    
    /**
    * Función que permite comprobar si la contraseña pasada tiene el formato debido
    * 
    * @return Devuelvo true si el formato es correcto
    */
    public static boolean es_contrasenia_valida(String contrasenia) {
        
        // Pattern sacado de: https://www.techiedelight.com/es/validate-password-java/
        String expresion = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,50}$";
        Pattern pattern = Pattern.compile(expresion);
        
        return pattern.matcher(contrasenia).matches(); // comprueba la expresión regular
    }
    
    /**
    * Función que permite cifrar la contraseña
    * 
    * @return Devuelve el hash generado
    */
    public static String cifrar_contrasenia(String contrasenia) {

        return BCrypt.withDefaults().hashToString(12, contrasenia.toCharArray());
    }

    /**
    * Función que permite cifrar la contraseña para comprobar si es igual a la que está encriptada
    * 
    * @return Devuelve true, si la contraseña es correcta a la almacenada en la BBDD
    */
    public boolean verificar_contrasenia(String contraseña) {

        return BCrypt.verifyer().verify(contraseña.toCharArray(), this.contrasenia).verified;
    }

    /**
    * Función que permite recoger un usuario mediante el email
    * 
    * @return Devuelvo el objeto usuario
    */
    public static Usuario recoger_usuario(String token) {
        if (token == null || token.isEmpty()) return null;

        // Llamada GET a /usuario con header Authorization
        JSONObject respuesta = APIHelper.getJSONObject("/usuario");

        if (respuesta != null && !respuesta.has("error")) {
            try {
                String email = respuesta.getString("email");
                String idioma = respuesta.optString("idioma_seleccionado", "es");
                Usuario usuario = new Usuario(email, "", idioma); // contraseña no se necesita
                usuario.setToken(token);
                return usuario;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean emailExiste(String email) {
        try {
            JSONObject respuesta = APIHelper.getJSONObject("/usuario/email/" + email);
            // Si devuelve null, no existe; si tiene "email", existe
            return respuesta != null && respuesta.has("email");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
