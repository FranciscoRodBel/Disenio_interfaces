package com.example.tareapp.controlador;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class APIRest {
    public static String realizarPeticionPost(String urlString, String jsonInput) {

        HttpURLConnection conexion = null;

        try {

            URL url = new URL(urlString);
            conexion = (HttpURLConnection) url.openConnection();
            conexion.setRequestMethod("POST");
            conexion.setRequestProperty("Content-Type", "application/json; utf-8");
            conexion.setRequestProperty("Accept", "application/json");
            conexion.setDoOutput(true);

            try (DataOutputStream salida = new DataOutputStream(conexion.getOutputStream())) {
                byte[] datos = jsonInput.getBytes(StandardCharsets.UTF_8);
                salida.write(datos, 0, datos.length);
            }

            int codigoRespuesta = conexion.getResponseCode();

            BufferedReader lector;

            if (codigoRespuesta >= 200 && codigoRespuesta < 300) {

                lector = new BufferedReader(new InputStreamReader(conexion.getInputStream()));

            } else {

                lector = new BufferedReader(new InputStreamReader(conexion.getErrorStream()));
            }

            StringBuilder respuesta = new StringBuilder();
            String linea;

            while ((linea = lector.readLine()) != null) {

                respuesta.append(linea.trim());
            }

            lector.close();
            return respuesta.toString();

        } catch (IOException e) {

            e.printStackTrace();
            return "Error al realizar la petición: " + e.getMessage();

        } finally {

            if (conexion != null) {

                conexion.disconnect();
            }
        }
    }

    public static JSONObject crearJSONObject(Map<String, String> parametros) {

        JSONObject json = new JSONObject();

        for (Map.Entry<String, String> entrada : parametros.entrySet()) {

            try {

                json.put(entrada.getKey(), entrada.getValue());

            } catch (JSONException e) {

                throw new RuntimeException("Error al crear JSONObject", e);
            }
        }

        try {

            json.put("clave_secreta", "p3J8K9zFqR2L7vD1mCqT0eB9xW6sYnZ4aF8uRtMqT7gXbN2hL");

        } catch (JSONException e) {
            throw new RuntimeException("Error al añadir clave segura", e);
        }

        return json;
    }
}
