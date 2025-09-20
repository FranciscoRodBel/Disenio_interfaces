package com.example.tareapp.controlador;

import com.example.tareapp.modelo.APIHelper;
import com.example.tareapp.modelo.Tarea;
import com.example.tareapp.modelo.idioma.Pagina_tareas;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Controlador de tareas usando backend REST con token automático
 */
public class Tarea_controlador {

    /**
     * Crear tarea
     */
    public String crear_tarea(String titulo, int prioridad, String fecha, String descripcion, int idLista) {

        Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

        if (idLista == 0) return idioma_tareas.getLista_no_seleccionada();

        Object resultado = validarTarea(titulo, prioridad, fecha, descripcion, idLista);
        if (resultado instanceof String) return (String) resultado;

        Tarea tarea = (Tarea) resultado;

        Map<String, String> parametros = Map.of(
                "titulo", tarea.getTitulo(),
                "prioridad", String.valueOf(tarea.getPrioridad()),
                "fecha", tarea.getFecha(),
                "descripcion", tarea.getDescripcion(),
                "idLista", String.valueOf(tarea.getIdLista())
        );

        JSONObject json = APIHelper.crearJSONObject(parametros);
        JSONObject respuesta = APIHelper.post("/tareas", json);

        if (respuesta != null && !respuesta.has("error")) return "";
        else return idioma_tareas.getTarea_no_creada();
    }

    /**
     * Recoger todas las tareas de una lista
     */
    public static List<HashMap<String, Object>> recoger_tareas(int idLista) {
        JSONArray jsonTareas = APIHelper.getJSONArray("/tareas?idLista=" + idLista); // backend puede filtrar por idLista
        List<HashMap<String, Object>> tareas = new ArrayList<>();

        if (jsonTareas != null) {
            try {
                JSONArray array = new JSONArray(jsonTareas.toString());
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
                    tareas.add(mapa);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return tareas;
    }


    /**
     * Editar tarea
     */
    public String editar_tarea(int idTarea, String titulo, int prioridad, String fecha, String descripcion, int idLista) {

        Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

        Object resultado = validarTarea(titulo, prioridad, fecha, descripcion, idLista);
        if (resultado instanceof String) return (String) resultado;

        Tarea tarea = (Tarea) resultado;

        Map<String, String> parametros = Map.of(
                "titulo", tarea.getTitulo(),
                "prioridad", String.valueOf(tarea.getPrioridad()),
                "fecha", tarea.getFecha(),
                "descripcion", tarea.getDescripcion(),
                "idLista", String.valueOf(tarea.getIdLista())
        );

        JSONObject json = APIHelper.crearJSONObject(parametros);
        JSONObject respuesta = APIHelper.put("/tareas/" + idTarea, json);

        if (respuesta != null && !respuesta.has("error")) return "";
        else return idioma_tareas.getTarea_no_editada();
    }

    /**
     * Borrar tarea
     */
    public String borrar_tarea(int idTarea) {
        JSONObject respuesta = APIHelper.delete("/tareas/" + idTarea, null);
        if (respuesta != null && !respuesta.has("error")) return "";
        else return Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getTarea_no_borrada();
    }

    /**
     * Marcar como completada/incompleta
     */
    public boolean completarTarea(int idTarea, int completada) {
        Map<String, String> parametros = Map.of("completada", String.valueOf(completada));
        JSONObject json = APIHelper.crearJSONObject(parametros);
        JSONObject respuesta = APIHelper.put("/tareas/" + idTarea, json);
        return respuesta != null && !respuesta.has("error");
    }

    /**
     * Validación de tarea
     */
    private Object validarTarea(String titulo, int prioridad, String fecha, String descripcion, int idLista) {

        Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

        titulo = titulo.trim();
        fecha = fecha.trim();
        descripcion = descripcion.trim();
        prioridad = (prioridad == 0) ? 1 : prioridad;

        Tarea tarea = new Tarea(titulo, prioridad, fecha, descripcion, idLista);

        if (titulo.length() > 50) return idioma_tareas.getTitulo_supera_caracteres();
        if (!tarea.es_texto_valido(titulo)) return idioma_tareas.getTitulo_no_valido();
        if (!tarea.es_fecha_valida()) return idioma_tareas.getFecha_no_valida();
        if (descripcion.length() > 500) return idioma_tareas.getDescripcion_supera_caracteres();
        if (!tarea.es_texto_valido(descripcion)) return idioma_tareas.getDescripcion_no_valida();

        tarea.setFecha(tarea.cambiar_string_a_date());

        return tarea;
    }
}
