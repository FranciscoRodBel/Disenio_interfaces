/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.modelo;

import static com.mycompany.tareapp.controlador.APIRest.realizarPeticionPost;

import com.mycompany.tareapp.controlador.APIRest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Clase para el modelo del CRUD de la base de datos
 *
 * @author Francisco
 */
public class BBDD_tareapp {

    /**
    * Función que permite recoger datos de la BBDD
    *
    * @return Devuelvo un ArrayList que tiene dentro HashMap con nombre_propiedad : valor - Array de array asociativo
    */
    public ArrayList<HashMap<String, Object>> consultar(String consulta_consultar) {

        String url = "https://tareapp.info/ejecutarConsulta";

        Map<String, String> parametros = new HashMap<>();
        parametros.put("sql", consulta_consultar);
        parametros.put("modo", "consulta");

        JSONObject json = APIRest.crearJSONObject(parametros);

        String respuesta = realizarPeticionPost(url, json.toString());

        System.out.println("Respuesta server: "+respuesta);

        ArrayList<HashMap<String, Object>> lista = new ArrayList<>();

        try {

            JSONArray resultado = new JSONArray(respuesta);

            for (int i = 0; i < resultado.length(); i++) {

                JSONObject fila = resultado.getJSONObject(i);
                HashMap<String, Object> filaMap = new HashMap<>();

                Iterator<String> claves = fila.keys();

                while (claves.hasNext()) {

                    String clave = claves.next();
                    filaMap.put(clave, fila.get(clave));
                }

                lista.add(filaMap);
            }
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }

        return lista;
    }


    /**
    * Función que permite insertar y actualizar datos en la BBDD
    *
    * @return Devuelvo true si se inserta o actualiza correctamente o false si da error
    */
    public boolean insertar(String consulta_insertar) {

        String url = "https://tareapp.info/ejecutarConsulta";

        Map<String, String> parametros = new HashMap<>();
        parametros.put("sql", consulta_insertar);
        parametros.put("modo", "insertar");

        JSONObject json = APIRest.crearJSONObject(parametros);
        String respuesta = realizarPeticionPost(url, json.toString());

        try {

            JSONObject resultado = new JSONObject(respuesta);
            return resultado.getInt("filas_afectadas") > 0;

        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
    * Función que permite borrar datos en la BBDD
    *
    * @return Devuelvo true si se borrar correctamente o false si da error
    */
    public boolean borrar(String consulta_borrar) {

        String url = "https://tareapp.info/ejecutarConsulta";

        Map<String, String> parametros = new HashMap<>();
        parametros.put("sql", consulta_borrar);
        parametros.put("modo", "borrar");

        JSONObject json = APIRest.crearJSONObject(parametros);
        String respuesta = realizarPeticionPost(url, json.toString());

        try {

            JSONObject resultado = new JSONObject(respuesta);
            return resultado.getInt("filas_afectadas") > 0;

        } catch (JSONException e) {

            e.printStackTrace();
            return false;
        }
    }
}
