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
import java.util.regex.Pattern;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Propietario
 */
public class Usuario {
    
    private String email;
    private String contrasenia;
    private String idioma_seleccionado;

    public Usuario(String email, String contrasenia, String idioma_seleccionado) {
        this.email = email;
        this.contrasenia = contrasenia;
        this.idioma_seleccionado = idioma_seleccionado;
    }
    
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

    public boolean es_email_valido() {
        
        // Pattern sacado de: https://www.baeldung.com/java-email-validation-regex
        String regex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        
        return pattern.matcher(this.getEmail()).matches();
    }
    
    public boolean es_contrasenia_valida(String contrasenia) {
        
        // Pattern sacado de: https://www.techiedelight.com/es/validate-password-java/
        String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,50}$";
        Pattern pattern = Pattern.compile(regex);
        
        return pattern.matcher(contrasenia).matches();
    }
    
    public String cifrar_contrasenia() {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // He decidido usar esta función ya que permite cifrar pero no descifrar
        return encoder.encode(this.getContrasenia()); // El hash siempre tiene 60 caracteres
    }

    public boolean verificar_contrasenia(String contraseña) {
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(contraseña, this.getContrasenia());
    }

    public static Usuario recoger_usuario(String email) {
    
        String consultaRecoger = "SELECT * FROM usuario WHERE email = '"+ email +"'";
        ArrayList<HashMap<String, Object>> resultados = new BBDD_tareapp().consultar(consultaRecoger);
        
        if (!resultados.isEmpty()) {
            
            HashMap<String, Object> fila = resultados.get(0);
            
            String contrasenia = (String) fila.get("contrasenia");
            String idioma_seleccionado = (String) fila.get("idioma_seleccionado");

            return new Usuario(email, contrasenia, idioma_seleccionado);
            
        }
        
        return null;
    }
}
