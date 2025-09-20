package com.example.tareapp.controlador;

import org.json.JSONObject;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * Clase genérica para realizar peticiones HTTP al backend.
 */
public class APIRest {

    // Método genérico
    public static String request(String urlString, String metodo, JSONObject jsonInput, String token) {
        HttpURLConnection conexion = null;
        try {
            URL url = new URL(urlString);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod(metodo);
            conexion.setRequestProperty("Content-Type", "application/json; utf-8");
            conexion.setRequestProperty("Accept", "application/json");

            if (token != null && !token.isEmpty()) {
                conexion.setRequestProperty("Authorization", "Bearer " + token);
            }

            if (jsonInput != null && !metodo.equals("GET")) {
                conexion.setDoOutput(true);
                try (OutputStream os = conexion.getOutputStream()) {
                    os.write(jsonInput.toString().getBytes(StandardCharsets.UTF_8));
                }
            }

            int codigo = conexion.getResponseCode();
            InputStream is = (codigo >= 200 && codigo < 300) ? conexion.getInputStream() : conexion.getErrorStream();
            BufferedReader lector = new BufferedReader(new InputStreamReader(is));
            StringBuilder respuesta = new StringBuilder();
            String linea;
            while ((linea = lector.readLine()) != null) respuesta.append(linea.trim());
            lector.close();
            return respuesta.toString();

        } catch (IOException e) {
            e.printStackTrace();
            return "Error al realizar la petición: " + e.getMessage();
        } finally {
            if (conexion != null) conexion.disconnect();
        }
    }

    // Métodos de conveniencia que usan el token que se pasa
    public static String get(String url, String token) { return request(url, "GET", null, token); }
    public static String post(String url, JSONObject json, String token) { return request(url, "POST", json, token); }
    public static String put(String url, JSONObject json, String token) { return request(url, "PUT", json, token); }
    public static String delete(String url, JSONObject json, String token) { return request(url, "DELETE", json, token); }
}
