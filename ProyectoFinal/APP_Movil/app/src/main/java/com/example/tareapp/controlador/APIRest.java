package com.example.tareapp.controlador;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIRest {
    public static String realizarPeticionPOST(String urlStr, String jsonInput) {
        HttpURLConnection conexion = null;
        BufferedReader in = null;
        try {
            URL url = new URL(urlStr);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json; utf-8");
            conexion.setDoOutput(true);

            // Escribir el contenido JSON en la petición
            try (OutputStream os = conexion.getOutputStream()) {
                byte[] input = jsonInput.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Leer la respuesta
            int codigoRespuesta = conexion.getResponseCode();
            if (codigoRespuesta == HttpURLConnection.HTTP_OK || codigoRespuesta == HttpURLConnection.HTTP_CREATED) {
                in = new BufferedReader(new InputStreamReader(conexion.getInputStream(), "utf-8"));
                StringBuilder respuesta = new StringBuilder();
                String linea;
                while ((linea = in.readLine()) != null) {
                    respuesta.append(linea);
                }
                return respuesta.toString();
            } else {
                // Si la respuesta no es 200 (OK) o 201 (CREATED), devuelve null
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace(); // Aquí podrías usar un Logger para capturar errores
            return null;
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e) {
                e.printStackTrace(); // Manejo de excepciones de cierre de BufferedReader
            }

            if (conexion != null) {
                conexion.disconnect(); // Cerrar la conexión HTTP
            }
        }
    }
}
