/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tareapp.controlador;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tareapp.App;
import com.example.tareapp.modelo.APIHelper;
import com.example.tareapp.modelo.SMTP;
import com.example.tareapp.modelo.Usuario;
import com.example.tareapp.modelo.idioma.Pagina_inicio_registro;

import org.json.JSONException;
import org.json.JSONObject;
import java.util.Map;


/**
 * Clase que se encarga de controlar el usuario
 *
 * @author Francisco
 */
public class Usuario_controlador {

    private static Usuario usuario; // Guardo el usuario que tiene la sesión iniciada

    public static Usuario getUsuario() {
        return usuario;
    }

    private static final String CLAVE_AES = "mCqT0eB9xW6sYnZ4";

    /**
    * Función que permite iniciar sesión
    * 
    * @return Devuelve el resultado de iniciar sesión, si se consigue iniciar sesión devuelve vacío y si no un mensaje de error
    */
    public String iniciar_usuario(Context context, String email, String contrasenia) {
        email = email.trim().toLowerCase();
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();

        if (!Usuario.es_email_valido(email)) return idioma.getEmail_no_valido();
        if (!Usuario.es_contrasenia_valida(contrasenia)) return idioma.getContrasenia_invalida();

        // Crear JSON con email y contraseña
        Map<String, String> parametros = Map.of(
                "email", email,
                "password", contrasenia
        );
        JSONObject json = APIHelper.crearJSONObject(parametros);

        // Llamada a /login
        JSONObject respuesta = APIHelper.post("/login", json);

        if (respuesta != null && !respuesta.has("error")) {
            try {
                // Guardamos token y datos del usuario
                String token = respuesta.getString("token");
                String idiomaUsuario = respuesta.optString("idioma_seleccionado", "es");

                Usuario usuario = new Usuario(email, contrasenia, idiomaUsuario);
                usuario.setToken(token);
                this.usuario = usuario;

                guardarCredenciales(context, email, token);
                return "";
            } catch (JSONException e) {
                e.printStackTrace();
                return idioma.getEmail_contrasenia_no_coinciden();
            }
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

    public String comprobar_datos_actualizar_email(String email, String email_repetido) {

        email = email.trim().toLowerCase(); // minúsculas
        String emailActual = usuario.getEmail(); // Email actual del usuario
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();

        if(!email.equals(email_repetido))
            return Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta().getEmails_no_coinciden();

        if (email.length() > 255) return idioma.getEmail_supera_caracteres();
        if (!Usuario.es_email_valido(email)) return idioma.getEmail_no_valido();

        if (!email.equals(emailActual) && Usuario.emailExiste(email)) {
            return idioma.getEmail_ya_registrado();
        }

        return "";
    }

    
    public String confirmar_email(String email, int codigo) {
        
        SMTP smtp = new SMTP();
        
        if (smtp.enviarEmail(email, codigo)) {
        
            return "";
        
        } else {
        
            return Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro().getEmail_no_enviado();
        }
    }

    public String registrar_usuario(String email, String contrasenia, String idioma_seleccionado) {
        email = email.trim().toLowerCase();
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();

        JSONObject json = new JSONObject();
        try {
            json.put("email", email);
            json.put("password", contrasenia);
            json.put("idioma", idioma_seleccionado);
        } catch (JSONException e) {
            return e.getMessage();
        }

        JSONObject respuesta = APIHelper.post("/register", json);

        if(respuesta != null && !respuesta.has("error")) {
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
    public String actualizar_email(String nuevoEmail) {

        nuevoEmail = nuevoEmail.trim().toLowerCase();

        Map<String, String> parametros = Map.of(
                "email_nuevo", nuevoEmail
        );
        JSONObject json = APIHelper.crearJSONObject(parametros);

        JSONObject respuesta = APIHelper.post("/login/email", json);

        if (respuesta != null && !respuesta.has("error")) {

            String nuevoToken = respuesta.optString("token", null);

            usuario.setEmail(respuesta.optString("email", nuevoEmail));
            usuario.setToken(nuevoToken);

            guardarCredenciales(App.getContext(), nuevoEmail, nuevoToken);

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
        Pagina_inicio_registro idioma = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();

        if (!contrasenia.equals(repetir_contrasenia)) return idioma.getContrasenia_no_coincide();
        if (!Usuario.es_contrasenia_valida(contrasenia)) return idioma.getContrasenia_invalida();

        Map<String, String> parametros = Map.of(
                "contrasenia", contrasenia
        );
        JSONObject json = APIHelper.crearJSONObject(parametros);
        JSONObject respuesta = APIHelper.put("/usuario", json);

        if (respuesta != null && !respuesta.has("error")) {
            return "";
        } else {
            return Idioma_controlador.getIdioma_seleccionado()
                    .getPagina_ajustes_cuenta()
                    .getContrasenia_no_actualizada();
        }
    }

    /**
    * Función que permite borrar el usuario
    * 
    * @return Devuelve el resultado de borrar el usuario, si se consigue borrar el usuario devuelve vacío y si no un mensaje de error
    */
    public String borrar_usuario() {
        JSONObject respuesta = APIHelper.delete("/usuario", null); // no necesitamos enviar email; lo obtiene del token

        if (respuesta != null && !respuesta.has("error")) {
            usuario = null;
            return "";
        } else {
            return Idioma_controlador.getIdioma_seleccionado()
                    .getPagina_ajustes_cuenta()
                    .getCuenta_no_borrada();
        }
    }

    
    /**
    * Función que permite actualizar el idioma del usuario, se ejecuta cuando el usuario cambia de idioma en la cabecera
    * 
    */
    public void actualizar_idioma(String idioma) {
        Map<String, String> parametros = Map.of(
                "idioma_seleccionado", idioma
        );

        JSONObject json = APIHelper.crearJSONObject(parametros);

        APIHelper.put("/usuario", json);
        usuario.setIdioma_seleccionado(idioma);
    }

    /**
    * Función que permite guardar las credenciales del usuario para que no tenga que iniciar sesión cada vez que abre la aplicación
    * 
    */
    private void guardarCredenciales(Context context, String email, String token) {
        SharedPreferences prefs = context.getSharedPreferences("usuarioPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putString("email", email);
        editor.putString("token", token);
        editor.apply();
    }


    /**
    * Función que permite iniciar la sesión del usuario para que no tenga que iniciar sesión cada vez que abre la aplicación
    * 
    */
    public static boolean iniciarSesionAutomatica(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("usuarioPrefs", Context.MODE_PRIVATE);

        String token = prefs.getString("token", null); // Recogemos el token guardado

        if (token != null) {
            Usuario usuarioGuardado = Usuario.recoger_usuario(token); // Usar el token para obtener usuario

            if (usuarioGuardado != null) {
                usuario = usuarioGuardado;
                Idioma_controlador.cambiarIdioma(usuarioGuardado.getIdioma_seleccionado(), false);
                return true;
            } else {
                // Token inválido o expirado → limpiar SharedPreferences
                SharedPreferences.Editor editor = prefs.edit();
                editor.clear();
                editor.apply();
            }
        }
        return false;
    }

    public static void cerrarSesion(Context context) {

        SharedPreferences prefs = context.getSharedPreferences("usuarioPrefs", Context.MODE_PRIVATE); // Accedo a la preferencia con el nombre "usuarioPrefs"
        SharedPreferences.Editor editor = prefs.edit(); // Creo un editor para modificar las preferencias
        editor.clear(); // Vacío la preferencia para que no pueda iniciar sesión automáticamente
        editor.apply();

        usuario = null; // Elimino el usuario que tiene la sesión iniciada
    }
}
