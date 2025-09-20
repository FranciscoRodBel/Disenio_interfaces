package com.example.tareapp.controlador;

import com.example.tareapp.modelo.Lista;
import com.example.tareapp.modelo.APIHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Controlador de listas que interactúa con el backend
 */
public class Lista_controlador {

    public String crear_lista(String titulo) {
        titulo = titulo.trim();

        if (titulo.length() > 50)
            return Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getTitulo_supera_caracteres();

        if (!Lista.es_titulo_valido(titulo))
            return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getTitulo_no_valido();

        Map<String, String> parametros = Map.of("titulo", titulo);
        JSONObject json = APIHelper.crearJSONObject(parametros);

        JSONObject respuesta = APIHelper.post("/listas", json);

        if (respuesta != null && !respuesta.has("error")) {
            return "";
        } else {
            return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_no_creada();
        }
    }

    public String actualizar_lista(int idLista, String titulo) {
        titulo = titulo.trim();

        if (titulo.length() > 50)
            return Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getTitulo_supera_caracteres();

        if (!Lista.es_titulo_valido(titulo))
            return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getTitulo_no_valido();

        Map<String, String> parametros = Map.of("titulo", titulo);
        JSONObject json = APIHelper.crearJSONObject(parametros);

        JSONObject respuesta = APIHelper.put("/listas/" + idLista, json);

        if (respuesta != null && !respuesta.has("error")) {
            return "";
        } else {
            return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_no_editada();
        }
    }

    public static List<HashMap<String, Object>> recoger_listas() {
        JSONArray array = APIHelper.getJSONArray("/listas");
        List<HashMap<String, Object>> listas = new ArrayList<>();

        if (array != null) {
            for (int i = 0; i < array.length(); i++) {
                try {
                    JSONObject obj = array.getJSONObject(i);
                    HashMap<String, Object> mapa = new HashMap<>();
                    Iterator<String> keys = obj.keys();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        mapa.put(key, obj.get(key));
                    }
                    listas.add(mapa);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return listas;
    }



    public String borrar_lista(int idLista) {
        JSONObject respuesta = APIHelper.delete("/listas/" + idLista, null);

        if (respuesta != null && !respuesta.has("error")) {
            return "";
        } else {
            return Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_no_borrada();
        }
    }
}
