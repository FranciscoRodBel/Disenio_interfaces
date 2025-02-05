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

    private static Usuario usuario;
    private final BBDD_tareapp bbdd_tareapp = new BBDD_tareapp();

    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Usuario_controlador.usuario = usuario;
    }
    
    public String iniciar_usuario(String email,String contrasenia) {
    
        email = email.trim().toLowerCase();
        
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();
        
        if (!Usuario.es_email_valido(email)) return idioma.getEmail_no_valido();
        
        Usuario usuario = Usuario.recoger_usuario(email);
        
        if (usuario == null )return idioma.getEmail_no_registrado();
        
        if (!Usuario.es_contrasenia_valida(contrasenia)) return idioma.getContrasenia_invalida();
        
        if(usuario.verificar_contrasenia(contrasenia)) {
            
            this.usuario = usuario;
            return "";
            
        } else {
            
            return idioma.getEmail_contrasenia_no_coinciden();
        }
    }
    
    public String registrar_usuario(String email,String contrasenia,String repetir_contrasenia, String idioma_seleccionado) {
        
        email = email.trim().toLowerCase();
        
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();
        
        if (email.length() > 255) return idioma.getEmail_supera_caracteres();
        
        if (!Usuario.es_email_valido(email)) return idioma.getEmail_no_valido();
        
        if (Usuario.recoger_usuario(email) != null ) return idioma.getEmail_ya_registrado();
        
        if (!contrasenia.equals(repetir_contrasenia)) return idioma.getContrasenia_no_coincide();
        
        if (!Usuario.es_contrasenia_valida(contrasenia)) return idioma.getContrasenia_invalida();
        
        contrasenia = Usuario.cifrar_contrasenia(contrasenia);
        
        String consulta = "INSERT INTO usuario (email, contrasenia, idioma_seleccionado) VALUES ('"+email+"', '"+contrasenia+"', '"+idioma_seleccionado+"')";
        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return "";
            
        } else {
            
            return idioma.getNo_puede_crear_usuario();
        }
    }
    
    public String actualizar_email(String email, String email_repetido) {
        
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();
        
        email = email.trim().toLowerCase();
        
        if(!email.equals(email_repetido)) return Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta().getEmails_no_coinciden();
        
        if (email.length() > 255) return idioma.getEmail_supera_caracteres();
        
        if (!Usuario.es_email_valido(email)) return idioma.getEmail_no_valido();
        
        if (Usuario.recoger_usuario(email) != null ) return idioma.getEmail_ya_registrado();
        
        String consulta = "UPDATE usuario SET email = '" + email + "' WHERE email = '" + usuario.getEmail() + "'";

        if(bbdd_tareapp.insertar(consulta)) {
            
            usuario.setEmail(email);
            return "";
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta().getEmail_no_actualizado();
        }
    }
    
    public String actualizar_contrasenia(String contrasenia, String repetir_contrasenia) {
        
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();
        
        if (!contrasenia.equals(repetir_contrasenia)) return idioma.getContrasenia_no_coincide();
        
        if (!Usuario.es_contrasenia_valida(contrasenia)) return idioma.getContrasenia_invalida();
        
        contrasenia = Usuario.cifrar_contrasenia(contrasenia);
        
        String consulta = "UPDATE usuario SET contrasenia = '" + contrasenia + "' WHERE email = '" + usuario.getEmail() + "'";

        if(bbdd_tareapp.insertar(consulta)) {
            
            return "";
            
        } else {
            
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta().getContrasenia_no_actualizada();
        }
    }
    
    public void actualizar_idioma(String idioma) {
        
        String consulta = "UPDATE usuario SET idioma_seleccionado = '" + idioma + "' WHERE email = '" + usuario.getEmail() + "'";
        bbdd_tareapp.insertar(consulta);
    }
    
    public String borrar_usuario() {
        
        System.out.println(usuario.getEmail());
        
        String consulta = "DELETE FROM usuario WHERE email = '" + usuario.getEmail() + "'";
        
        if(bbdd_tareapp.borrar(consulta)) {
            
            return "";
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta().getCuenta_no_borrada();
        }
    }
}
