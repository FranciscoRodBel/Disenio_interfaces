/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.controlador;

import com.mycompany.tareapp.modelo.BBDD_tareapp;
import com.mycompany.tareapp.modelo.SMTP;
import com.mycompany.tareapp.modelo.Usuario;
import com.mycompany.tareapp.modelo.idioma.Pagina_inicio_registro;

/**
 * Clase que se encarga de controlar el usuario
 *
 * @author Francisco
 */
public class Usuario_controlador {

    private static Usuario usuario; // Guardo el usuario que tiene la sesión iniciada
    private final BBDD_tareapp bbdd_tareapp = new BBDD_tareapp();

    
    public static Usuario getUsuario() {
        return usuario;
    }

    public static void setUsuario(Usuario usuario) {
        Usuario_controlador.usuario = usuario;
    }
    
    /**
    * Función que permite iniciar sesión
    * 
    * @return Devuelve el resultado de iniciar sesión, si se consigue iniciar sesión devuelve vacío y si no un mensaje de error
    */
    public String iniciar_usuario(String email,String contrasenia) {
    
        email = email.trim().toLowerCase(); // Pasa el email a minúsculas
        
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro(); // Recojo el idioma del registro/inicio
        
        if (email.length() > 255) return idioma.getEmail_supera_caracteres(); // Compruebo que el email no supere los caracteres permitidos
        
        if (!Usuario.es_email_valido(email)) return idioma.getEmail_no_valido(); // Compruebo si el email tiene el formato de email texto@dominio.dominio
        
        Usuario usuario = Usuario.recoger_usuario(email); // Compruebo si existe el usuario
        
        if (usuario == null ) return idioma.getEmail_no_registrado(); // Si no recoge nada, devuelve null por lo tanto no existe
        
        if (!Usuario.es_contrasenia_valida(contrasenia)) return idioma.getContrasenia_invalida(); // Compruebo que la contraseña cumple con los requisitos mínimos de seguridad
        
        if(usuario.verificar_contrasenia(contrasenia)) { // Compruebo si el usuario y contraseña coinciden con el de la BBDD
            
            this.usuario = usuario; // Si inicia sesión, guardo el usuario en la variable global
            return "";
            
        } else {
            
            return idioma.getEmail_contrasenia_no_coinciden();
        }
    }
    
    /**
    * Función que permite registrar a un usuario
    * 
    * @return Devuelve el resultado de registrarse, si se consigue registrar devuelve vacío y si no un mensaje de error
    */
    
    public String comprobar_datos_registro(String email,String contrasenia,String repetir_contrasenia) {
        
        email = email.trim().toLowerCase(); // Pasa el email a minúsculas
        
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro(); // Recojo el idioma del registro/inicio
        
        if (email.length() > 255) return idioma.getEmail_supera_caracteres(); // Compruebo que el email no supere los caracteres permitidos
        
        if (!Usuario.es_email_valido(email)) return idioma.getEmail_no_valido(); // Compruebo si el email tiene el formato de email texto@dominio.dominio
        
        if (Usuario.recoger_usuario(email) != null ) return idioma.getEmail_ya_registrado(); // Compruebo si existe el usuario
        
        if (!contrasenia.equals(repetir_contrasenia)) return idioma.getContrasenia_no_coincide(); // Compruebo si las dos contraseñas son iguales
        
        if (!Usuario.es_contrasenia_valida(contrasenia)) return idioma.getContrasenia_invalida(); // Compruebo que la contraseña cumple con los requisitos mínimos de seguridad
        
        return "";
    }
    
    public String confirmar_email(String email, int codigo) {
        
        SMTP smtp = new SMTP();
        
        if (smtp.enviarEmail(email, codigo)) {
        
            return "";
        
        } else {
        
            return "No se ha podido enviar el email";
        }
    }
    
    public String registrar_usuario(String email,String contrasenia,String repetir_contrasenia, String idioma_seleccionado) {
        
        email = email.trim().toLowerCase(); // Pasa el email a minúsculas
        
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro(); // Recojo el idioma del registro/inicio
        
        contrasenia = Usuario.cifrar_contrasenia(contrasenia); // Cifro la contraseña para la BBDD, esta conmtraseña no puede ser descifrada
        
        String consulta = "INSERT INTO usuario (email, contrasenia, idioma_seleccionado) VALUES ('"+email+"', '"+contrasenia+"', '"+idioma_seleccionado+"')";
        
        if(bbdd_tareapp.insertar(consulta)) {
            
            return "";
            
        } else {
            
            return idioma.getNo_puede_crear_usuario();
        }
    }
    
    /**
    * Función que permite actualizar el email
    * 
    * @return Devuelve el resultado de actualizar el email, si se consigue actualizar el email devuelve vacío y si no un mensaje de error
    */
    public String actualizar_email(String email, String email_repetido) {
        
        email = email.trim().toLowerCase(); // Pasa el email a minúsculas
        
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro(); // Recojo el idioma del registro/inicio
        
        if(!email.equals(email_repetido)) return Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta().getEmails_no_coinciden(); // Comrpueba si los dos emails son iguales
        
        if (email.length() > 255) return idioma.getEmail_supera_caracteres(); // Compruebo que el email no supere los caracteres permitidos
        
        if (!Usuario.es_email_valido(email)) return idioma.getEmail_no_valido(); // Compruebo si el email tiene el formato de email texto@dominio.dominio
        
        if (Usuario.recoger_usuario(email) != null ) return idioma.getEmail_ya_registrado(); // Comprueba si el email ya está en la BBDD
        
        String consulta = "UPDATE usuario SET email = '" + email + "' WHERE email = '" + usuario.getEmail() + "'";

        if(bbdd_tareapp.insertar(consulta)) {
            
            usuario.setEmail(email);
            return "";
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta().getEmail_no_actualizado();
        }
    }
    
    /**
    * Función que permite actualizar la contraseña
    * 
    * @return Devuelve el resultado de actualizar la contraseña, si se consigue actualizar la contraseña devuelve vacío y si no un mensaje de error
    */
    public String actualizar_contrasenia(String contrasenia, String repetir_contrasenia) { 
        
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro(); // Recojo el idioma del registro/inicio
        
        if (!contrasenia.equals(repetir_contrasenia)) return idioma.getContrasenia_no_coincide(); // Comrpueba si las dos contraseñas son iguales
        
        if (!Usuario.es_contrasenia_valida(contrasenia)) return idioma.getContrasenia_invalida(); // Compruebo si la contraseña tiene caracteres permitidos
        
        contrasenia = Usuario.cifrar_contrasenia(contrasenia); // Cifro la nueva contraseña
        
        String consulta = "UPDATE usuario SET contrasenia = '" + contrasenia + "' WHERE email = '" + usuario.getEmail() + "'";

        if(bbdd_tareapp.insertar(consulta)) { // Actualizo la contraseña
            
            return "";
            
        } else {
            
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta().getContrasenia_no_actualizada();
        }
    }

    /**
    * Función que permite borrar el usuario
    * 
    * @return Devuelve el resultado de borrar el usuario, si se consigue borrar el usuario devuelve vacío y si no un mensaje de error
    */
    public String borrar_usuario() {
        
        System.out.println(usuario.getEmail());
        
        String consulta = "DELETE FROM usuario WHERE email = '" + usuario.getEmail() + "'";
        
        if(bbdd_tareapp.borrar(consulta)) {
            
            return "";
            
        } else {
            
            return Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta().getCuenta_no_borrada();
        }
    }
    
    /**
    * Función que permite actualizar el idioma del usuario, se ejecuta cuando el usuario cambia de idioma en la cabecera
    * 
    */
    public void actualizar_idioma(String idioma) {
        
        String consulta = "UPDATE usuario SET idioma_seleccionado = '" + idioma + "' WHERE email = '" + usuario.getEmail() + "'";
        bbdd_tareapp.insertar(consulta);
    }
    
}
