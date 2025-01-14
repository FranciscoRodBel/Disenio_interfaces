/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.controlador;

import com.mycompany.tareapp.modelo.BBDD_tareapp;
import com.mycompany.tareapp.modelo.Usuario;
import com.mycompany.tareapp.modelo.idioma.Pagina_inicio_registro;

/**
 *
 * @author Propietario
 */
public class Usuario_controlador {

    private final BBDD_tareapp bbdd_tareapp = new BBDD_tareapp();

    public String registrar_usuario(String email,String contrasenia,String repetir_contrasenia, String idioma_seleccionado) {
    
        Usuario usuario = new Usuario(email, contrasenia);
        
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();
        
        if (email.length() > 255) return idioma.getEmail_supera_caracteres();
        
        if (!usuario.es_email_valido()) return idioma.getEmail_no_valido();
        
        if (Usuario.recoger_usuario(email) != null ) return idioma.getEmail_ya_registrado();
        
        if (!contrasenia.equals(repetir_contrasenia)) return idioma.getContrasenia_no_coincide();
        
        if (!usuario.es_contrasenia_valida(contrasenia)) return idioma.getContrasenia_invalida();
        
        contrasenia = usuario.cifrar_contrasenia();
        
        String consulta = "INSERT INTO usuario (email, contrasenia, idioma_seleccionado) VALUES ('"+email+"', '"+contrasenia+"', '"+idioma_seleccionado+"')";
        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return idioma.getCuenta_creada();
            
        } else {
            
            return idioma.getNo_puede_crear_usuario();
        }
    }
    
    public String iniciar_usuario(String email,String contrasenia) {
    
        Usuario usuario = new Usuario(email, contrasenia);
        
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();
        
        if (!usuario.es_email_valido()) return idioma.getEmail_no_valido();
        
        usuario = Usuario.recoger_usuario(email);
        
        if (usuario == null )return idioma.getEmail_no_registrado();
        
        if (!usuario.es_contrasenia_valida(contrasenia)) return idioma.getContrasenia_invalida();
        
        if(usuario.verificar_contrasenia(contrasenia)) {
            
            return "";
            
        } else {
            
            return idioma.getEmail_contrasenia_no_coinciden();
        }
    }
}
