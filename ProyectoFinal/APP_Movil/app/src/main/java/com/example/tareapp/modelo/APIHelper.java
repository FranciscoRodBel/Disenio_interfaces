package com.example.tareapp.modelo;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.tareapp.App;
import com.example.tareapp.controlador.APIRest;
import com.example.tareapp.controlador.Usuario_controlador;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Map;

/**
 * Helper para interactuar con la API REST, añade token automáticamente si el usuario está logueado.
 */
public class APIHelper {

    private static final String BASE_URL = "https://tareapp.es";

    // Obtener token automáticamente
    private static String getToken() {
        if (Usuario_controlador.getUsuario() != null) {
            return Usuario_controlador.getUsuario().getToken();
        }
        SharedPreferences prefs = App.getContext().getSharedPreferences("usuarioPrefs", Context.MODE_PRIVATE);
        return prefs.getString("token", null);
    }

    // Crear JSONObject desde Map
    public static JSONObject crearJSONObject(Map<String, String> parametros) {
        JSONObject json = new JSONObject();
        for (Map.Entry<String, String> e : parametros.entrySet()) {
            try { json.put(e.getKey(), e.getValue()); }
            catch (JSONException ex) { throw new RuntimeException("Error al crear JSONObject", ex); }
        }
        return json;
    }

    // Peticiones HTTP
    public static JSONObject post(String ruta, JSONObject datos) { return requestJSONObject("POST", ruta, datos); }
    public static JSONObject put(String ruta, JSONObject datos) { return requestJSONObject("PUT", ruta, datos); }
    public static JSONObject delete(String ruta, JSONObject datos) { return requestJSONObject("DELETE", ruta, datos); }

    public static JSONObject getJSONObject(String ruta) { return requestJSONObject("GET", ruta, null); }
    public static JSONArray getJSONArray(String ruta) { return requestJSONArray("GET", ruta, null); }

    // Actualizar parcialmente un objeto usando PUT (recupera primero, luego actualiza solo los campos indicados)
    public static JSONObject actualizarObjetoParcial(String ruta, Map<String, Object> camposActualizar) {
        // 1. Obtener el objeto completo
        JSONObject objetoOriginal = getJSONObject(ruta);
        if (objetoOriginal == null) return null;

        // 2. Actualizar solo los campos indicados
        for (Map.Entry<String, Object> entry : camposActualizar.entrySet()) {
            try { objetoOriginal.put(entry.getKey(), entry.getValue()); }
            catch (JSONException e) { e.printStackTrace(); }
        }

        // 3. Enviar PUT completo
        return put(ruta, objetoOriginal);
    }

    // Request genérico para JSONObject
    private static JSONObject requestJSONObject(String metodo, String ruta, JSONObject datos) {
        String respuesta = requestRaw(metodo, ruta, datos);
        if (respuesta == null) return null;
        try { return new JSONObject(respuesta); }
        catch (JSONException e) { e.printStackTrace(); return null; }
    }

    // Request genérico para JSONArray
    private static JSONArray requestJSONArray(String metodo, String ruta, JSONObject datos) {
        String respuesta = requestRaw(metodo, ruta, datos);
        if (respuesta == null) return null;
        try { return new JSONArray(respuesta); }
        catch (JSONException e) { e.printStackTrace(); return null; }
    }

    // Método crudo que devuelve la respuesta como String
    private static String requestRaw(String metodo, String ruta, JSONObject datos) {
        String url = BASE_URL + ruta;
        try {
            switch (metodo) {
                case "GET": return APIRest.get(url, getToken());
                case "POST": return APIRest.post(url, datos, getToken());
                case "PUT": return APIRest.put(url, datos, getToken());
                case "DELETE": return APIRest.delete(url, datos, getToken());
                default: throw new IllegalArgumentException("Método HTTP no soportado: " + metodo);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
