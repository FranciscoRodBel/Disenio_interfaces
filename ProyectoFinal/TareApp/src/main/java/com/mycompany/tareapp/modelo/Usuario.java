/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.modelo;

import com.mycompany.tareapp.controlador.BBDD_controlador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Propietario
 */
public class Usuario {
    
    private String email;
    private String contrasenia;
    private String idioma_seleccionado;

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
    
    public String getIdioma_seleccionado() {
        return idioma_seleccionado;
    }

    public void setIdioma_seleccionado(String idioma_seleccionado) {
        this.idioma_seleccionado = idioma_seleccionado;
    }
    
    public Boolean esta_email_repetido() {
    
        
        String consultaRecoger = "SELECT * FROM usuario WHERE email = '"+ this.getEmail() +"'";
        ArrayList<HashMap<String, Object>> resultados = new BBDD_tareapp().consultar(consultaRecoger);
        
        return !resultados.isEmpty();
    }
}
