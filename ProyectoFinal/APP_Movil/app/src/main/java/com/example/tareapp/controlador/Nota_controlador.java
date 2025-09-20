package com.example.tareapp.controlador;

import com.example.tareapp.modelo.APIHelper;
import com.example.tareapp.modelo.Nota;
import com.example.tareapp.modelo.idioma.Pagina_notas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.*;

/**
 * Controlador de notas usando backend REST con token automático
 *
 * @author Francisco
 */
public class Nota_controlador {

    /**
     * Crear nota
     */
    public String crear_nota(String descripcion, String color) {

        Pagina_notas idioma_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas();

        Object resultado = validarNota(descripcion, color);
        if (resultado instanceof String) return (String) resultado;

        Nota nota = (Nota) resultado;

        Map<String, String> parametros = Map.of(
                "descripcion", nota.getDescripcion(),
                "color", nota.getColor()
        );

        JSONObject json = APIHelper.crearJSONObject(parametros);
        JSONObject respuesta = APIHelper.post("/notas", json);

        if (respuesta != null && !respuesta.has("error")) return "";
        else return idioma_notas.getNota_no_creada();
    }

    /**
     * Recoger todas las notas del usuario
     */
    public static List<HashMap<String, Object>> recoger_notas() {
        JSONArray jsonNotas = APIHelper.getJSONArray("/notas");
        List<HashMap<String, Object>> notas = new ArrayList<>();

        if (jsonNotas != null) {
            try {
                JSONArray array = new JSONArray(jsonNotas.toString());
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    HashMap<String, Object> mapa = new HashMap<>();
                    Iterator<String> keys = obj.keys();
                    while (keys.hasNext()) {
                        String key = keys.next();
                        try {
                            mapa.put(key, obj.get(key));
                        } catch (JSONException ignored) {}
                    }
                    notas.add(mapa);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return notas;
    }

    /**
     * Editar nota
     */
    public String editar_nota(int idNota, String descripcion, String color) {

        Pagina_notas idioma_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas();

        Object resultado = validarNota(descripcion, color);
        if (resultado instanceof String) return (String) resultado;

        Nota nota = (Nota) resultado;

        Map<String, String> parametros = Map.of(
                "descripcion", nota.getDescripcion(),
                "color", nota.getColor()
        );

        JSONObject json = APIHelper.crearJSONObject(parametros);
        JSONObject respuesta = APIHelper.put("/notas/" + idNota, json);

        if (respuesta != null && !respuesta.has("error")) return "";
        else return idioma_notas.getNota_no_editada();
    }

    /**
     * Borrar nota
     */
    public String borrar_nota(int idNota) {
        JSONObject respuesta = APIHelper.delete("/notas/" + idNota, null);
        if (respuesta != null && !respuesta.has("error")) return "";
        else return Idioma_controlador.getIdioma_seleccionado().getPagina_notas().getNota_no_borrada();
    }

    /**
     * Validación de nota
     */
    private Object validarNota(String descripcion, String color) {

        Pagina_notas idioma_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas();

        descripcion = descripcion.trim();

        Nota nota = new Nota(descripcion, color);

        if (descripcion.length() > 250) return idioma_notas.getDescripcion_supera_caracteres();
        if (!nota.es_texto_valido(descripcion)) return Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getDescripcion_no_valida();

        return nota;
    }
}
