package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tareapp.R;
import com.example.tareapp.controlador.CambiarVista;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Lista_controlador;
import com.example.tareapp.controlador.Tarea_controlador;
import com.example.tareapp.modelo.Lista;
import com.example.tareapp.modelo.Tarea;
import com.example.tareapp.modelo.idioma.Pagina_tareas;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase para la vista de tareas
 *
 * @author Francisco
 */
public class TareasView extends Fragment {

    private TextView idTitulo;
    private ImageButton idBotonCrearTarea;
    private Button idBotonFiltros;
    private Spinner idSpinnerListas;
    private ArrayAdapter<Lista> listaAdapter;
    private ArrayList<Lista> listaDeListas;
    private RecyclerView recyclerTareas;
    private TareaAdapter tareaAdapter;
    private ArrayList<Tarea> listaTareas;
    private int idListaParaSeleccionar = -1;
    private Pagina_tareas pagina_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tareas_view, container, false);

        idTitulo = view.findViewById(R.id.idTitulo);
        idBotonCrearTarea = view.findViewById(R.id.idBotonAceptar);
        idSpinnerListas = view.findViewById(R.id.idSpinnerListas);
        recyclerTareas = view.findViewById(R.id.idRecyclerViewTareas);
        idBotonFiltros = view.findViewById(R.id.idBotonFiltros);

        // Configuración del RecyclerView de tareas y spinner de listas
        recyclerTareas.setLayoutManager(new LinearLayoutManager(requireContext()));
        listaTareas = new ArrayList<>();
        tareaAdapter = new TareaAdapter(listaTareas);
        recyclerTareas.setAdapter(tareaAdapter);

        // Añado el idioma de los textos
        idTitulo.setText(pagina_tareas.getTitulo());
        idBotonFiltros.setText(pagina_tareas.getFiltros());

        SharedPreferences prefs = requireContext().getSharedPreferences("tarea_lista_seleccionada", 0); // Recojo la lista que está seleccionada, la guardo así para que siempre se mantenga seleccionada mientras el usuario no cambie de lista
        idListaParaSeleccionar = prefs.getInt("idListaSeleccionada", 0); // Recojo id de la lista

        cargarListasEnSpinner(); // Recogerá las listas y seleccionará la lista almacenada en preferencias

        idBotonCrearTarea.setOnClickListener(v -> { // Si pulsa en el + de crear tareas...

            Lista listaSeleccionada = (Lista) idSpinnerListas.getSelectedItem(); // Recojo el objeto de la lista del spinner

            if (listaSeleccionada != null) { // Si hay lista seleccionada

                TareaCrearEditarView crearEditarFragment = new TareaCrearEditarView(); // Creo la vista

                Bundle bundle = new Bundle();
                bundle.putInt("id", listaSeleccionada.getIdLista()); // Envío el id de lista y la acción
                bundle.putString("accion", "crear");

                crearEditarFragment.setArguments(bundle);

                CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), crearEditarFragment); // Cambio a la vista de crear tarea

            } else { // Si no hay lista seleccionada...

                CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), new ListasView()); // Cambio a la vista de listas para que cree una lista
                Toast.makeText(this.getContext(), Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getDebe_crear_lista(), Toast.LENGTH_SHORT).show(); // Muestro el mensaje de que tiene que crear una lista para crear tareas
            }

        });

        idBotonFiltros.setOnClickListener(v -> { // Si pulsa en filtros...

            CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), new TareaFiltrosView()); // Cambio a la vista donde puede cambiar los filtros
        });

        tareaAdapter.setOnItemClickListener(tarea -> { // Si se pulsa en una tarea se muestra las vista de ver tarea

            TareaVerView verFragment = new TareaVerView();
            Bundle bundle = new Bundle();
            bundle.putSerializable("tarea", tarea); // Se envía el objeto tarea

            verFragment.setArguments(bundle);

            CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), verFragment); // Cambia a la vista de ver tarea
        });

        // Esta vista es la primera que se ve al iniciar sesión y al echar atrás con la felcha no se muestra ninguna(se elimina) para evitar eso, cuando pulsa atrás con la flecha, minimizo la app
        requireActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    }
                }
        );

        return view;
    }

    private void cargarListasEnSpinner() { // Recogerá las listas y seleccionará la lista almacenada en preferencias

        listaDeListas = new ArrayList<>();

        new Thread(() -> {

            ArrayList<HashMap<String, Object>> listas = Lista_controlador.recoger_listas(); // Recojo las listas del usuario de la BBDD

            requireActivity().runOnUiThread(() -> {

                if (listas != null) {

                    for (HashMap<String, Object> fila : listas) { // Recorro las listas

                        int idLista = (int) fila.get("idLista");
                        String titulo = (String) fila.get("titulo");
                        String email = (String) fila.get("email");

                        listaDeListas.add(new Lista(idLista, titulo, email)); // Añado las listas al spinner
                    }
                }

                // Adaptador para mostrar las listas en el Spinner
                listaAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, listaDeListas);
                listaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                idSpinnerListas.setAdapter(listaAdapter);

                if (idListaParaSeleccionar != -1) { // Si existe una lista almacenada en preferencias

                    for (int i = 0; i < listaDeListas.size(); i++) { // Recorro las listas

                        if (listaDeListas.get(i).getIdLista() == idListaParaSeleccionar) { // Si la que está guardada en preferencias es igual a la que se está recorriendo

                            idSpinnerListas.setSelection(i); // Se selecciona en el spinner
                            break;
                        }
                    }
                }

                idSpinnerListas.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() { // Al cambiar de lista...
                    @Override
                    public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {

                        Lista listaSeleccionada = (Lista) parent.getItemAtPosition(position); // Recojo la lista seleccionada

                        // Se guarda el id de la lista en las preferencias para que se mantenga seleccionada
                        SharedPreferences prefs = requireContext().getSharedPreferences("tarea_lista_seleccionada", 0);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("idListaSeleccionada", listaSeleccionada.getIdLista());
                        editor.apply();

                        actualizarPanelTareas(listaSeleccionada.getIdLista()); // Se actualiza el panel de tareas, mostrando las tareas de la nueva lista seleccioanda
                    }

                    @Override
                    public void onNothingSelected(android.widget.AdapterView<?> parent) {
                        // Nada seleccionado
                    }
                });
            });
        }).start();
    }

    private void actualizarPanelTareas(int idListaSeleccionada) { // Función para mostrar todas las tareas de la lista seleccionada

        new Thread(() -> {

            SharedPreferences prefs = requireContext().getSharedPreferences("filtros", 0); // Recojo los filtros

            String consulta = Tarea_controlador.generarConsulta(
                    idListaSeleccionada
                    , prefs.getBoolean("completadas", true)
                    , prefs.getBoolean("incompletas", true)
                    , prefs.getBoolean("baja", true)
                    , prefs.getBoolean("media", true)
                    , prefs.getBoolean("alta", true)
                    , prefs.getInt("orden", 0)); // Genero la consulta

            ArrayList<HashMap<String, Object>> tareas = Tarea_controlador.recoger_tareas(consulta); // Recojo las tareas de la lista de la bbdd

            requireActivity().runOnUiThread(() -> {

                listaTareas.clear(); // Vacío las listas

                if (tareas != null) {

                    for (HashMap<String, Object> fila : tareas) { // Recorro las tareas y las añado al array

                        int idTarea = (int) fila.get("idTarea");
                        int completada = (int) fila.get("completada");
                        String titulo = (String) fila.get("titulo");
                        int prioridad = (int) fila.get("prioridad");
                        String fecha = (String) fila.get("fecha");
                        String descripcion = (String) fila.get("descripcion");
                        int idLista = (int) fila.get("idLista");

                        listaTareas.add(new Tarea(idTarea, completada, titulo, prioridad, fecha, descripcion, idLista));
                    }
                }

                tareaAdapter.notifyDataSetChanged(); // Notifico que cambió el panel para que lo actualice y muestre las tareas
            });
        }).start();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).bloquearIdiomaMenu(false); // Desbloquea el idioma
        }
    }
}
