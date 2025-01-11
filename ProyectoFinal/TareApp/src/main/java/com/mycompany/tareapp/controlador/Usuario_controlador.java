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

    public Boolean insertar_usuario(Usuario usuario) {
    
        String email = usuario.getEmail();
        String contrasenia = usuario.getContrasenia();
        
        if (usuario.esta_email_repetido()) return false;
        
        String consulta = "INSERT INTO usuario (email, contrasenia) VALUES ('"+email+"', '"+contrasenia+"')";
        bbdd_tareapp.insertar(consulta);
        
        return true;
    }
}
