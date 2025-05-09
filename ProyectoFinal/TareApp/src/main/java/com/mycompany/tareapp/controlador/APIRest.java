package com.mycompany.tareapp.controlador;
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

/**
 * Controlador para cambiar el fragmento que está en pantalla.
 * 
 * @author Francisco
 */
public class APIRest {

    /**
    * Función que permite realizar consultas a la API para poder transferir datos con la BBDD
    * 
    * @return Devuelve un json con el resultado de la consulta
    */
    public static String realizarPeticionPost(String urlString, String jsonInput) {

        HttpURLConnection conexion = null;

        try {

            URL url = new URL(urlString); // Creo la URL a la que se va a realizar la consulta
            conexion = (HttpURLConnection) url.openConnection(); // Abro la conexión
            conexion.setRequestMethod("POST"); // Indico como voy a enviar los datos
            conexion.setRequestProperty("Content-Type", "application/json; utf-8"); // Tipo de contenido que envío(json)
            conexion.setRequestProperty("Accept", "application/json"); // Tipo de contenido que recibo(json)
            conexion.setDoOutput(true); // Habilito la opción de enviar datos en la petición

            // Añade el json al contenido del cuerpo del mensaje, para poder enviarlo.
            try (DataOutputStream salida = new DataOutputStream(conexion.getOutputStream())) {

                byte[] datos = jsonInput.getBytes(StandardCharsets.UTF_8);
                salida.write(datos, 0, datos.length);
            }

            int codigoRespuesta = conexion.getResponseCode(); // Recojo el código de respuesta del servidor

            BufferedReader lector;

            if (codigoRespuesta >= 200 && codigoRespuesta < 300) { // Si la respuesta es correcta...

                lector = new BufferedReader(new InputStreamReader(conexion.getInputStream())); // Lee la respuesta exitosa del servidor

            } else { // Si la respuesta no es correcta...

                lector = new BufferedReader(new InputStreamReader(conexion.getErrorStream())); // Lee la respuesta erronea del servidor
            }

            StringBuilder respuesta = new StringBuilder(); // Creo un string para guardar la respuesta
            String linea;

            while ((linea = lector.readLine()) != null) { // Creo la respuesta enviada desde el servidor

                respuesta.append(linea.trim()); // Elimina espacios innecesarios y añade la linea
            }

            lector.close(); // Cierra el lector
            return respuesta.toString(); // devuelvo el resultado de la API en formato json

        } catch (IOException e) { // Si hay un error devuelvo el mensaje

            e.printStackTrace();
            return "Error al realizar la petición: " + e.getMessage();

        } finally { // Asegura que la conexión se cierre incluso si hay un error

            if (conexion != null) {

                conexion.disconnect();
            }
        }
    }

    /**
    * Función que permite realizar consultas a la API para poder transferir datos con la BBDD
    * 
    * @return Devuelve un objeto JSONObject con los datos que se enviaran en la consulta y la contraseña para poder realizar la consulta
    */
    public static JSONObject crearJSONObject(Map<String, String> parametros) {

        JSONObject json = new JSONObject(); // Creo el objeto

        for (Map.Entry<String, String> entrada : parametros.entrySet()) { // Recorre sobre cada dato del mapa (clave, valor)

            try {

                json.put(entrada.getKey(), entrada.getValue()); // Guarda cada par clave-valor en el objeto JSON

            } catch (JSONException e) {

                throw new RuntimeException("Error al crear JSONObject", e);
            }
        }

        try {

            json.put("clave_secreta", "p3J8K9zFqR2L7vD1mCqT0eB9xW6sYnZ4aF8uRtMqT7gXbN2hL"); // Añado una clave para que solo pueda hacer consultas la aplicación

        } catch (JSONException e) {
            throw new RuntimeException("Error al añadir clave segura", e);
        }

        return json; // Devuelve el objeto JSON creado
    }
}
