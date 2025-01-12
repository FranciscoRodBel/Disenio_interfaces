/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.controlador;

import com.mycompany.tareapp.modelo.BBDD_tareapp;
import com.mycompany.tareapp.modelo.Usuario;

/**
 *
 * @author Propietario
 */
public class Usuario_controlador {

    private final BBDD_tareapp bbdd_tareapp = new BBDD_tareapp();

    public String insertar_usuario(String email,String contrasenia,String repetir_contrasenia) {
    
        Usuario usuario = new Usuario(email, contrasenia);
        
        if (email.length() > 255) return "El email no puede superar los 255 caracteres";
        
        if (!usuario.es_email_valido(email)) return "El email no es válido";
        
        if (usuario.esta_email_repetido()) return "El email ya está registrado";
        
        if (!contrasenia.equals(repetir_contrasenia)) return "Las contraseñas no coinciden";
        
        if (!usuario.es_contrasenia_valida(contrasenia)) return "Contraseña inválida: requiere mayúsculas, minúsculas, números y entre 4-50 caracteres";
        
        contrasenia = usuario.cifrar_contrasenia(contrasenia);
        
        String consulta = "INSERT INTO usuario (email, contrasenia) VALUES ('"+email+"', '"+contrasenia+"')";
        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return "Cuenta creada";
            
        } else {
            
            return "No se ha podido crear el usuario";
        }
    }
}
