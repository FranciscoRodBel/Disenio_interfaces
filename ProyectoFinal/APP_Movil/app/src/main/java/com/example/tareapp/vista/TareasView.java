package com.example.tareapp.vista;

import android.annotation.SuppressLint;
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

        recyclerTareas.setLayoutManager(new LinearLayoutManager(requireContext()));
        listaTareas = new ArrayList<>();
        tareaAdapter = new TareaAdapter(listaTareas);
        recyclerTareas.setAdapter(tareaAdapter);

        idTitulo.setText(pagina_tareas.getTitulo());
        idBotonFiltros.setText(pagina_tareas.getFiltros());

        /*
        Bundle bundleIdLista = getArguments();
        if (bundleIdLista != null) {
            idListaParaSeleccionar = bundleIdLista.getInt("id", -1);
        }
        */
        SharedPreferences prefs = requireContext().getSharedPreferences("tarea_lista_seleccionada", 0);
        idListaParaSeleccionar =  prefs.getInt("idListaSeleccionada", 0);

        cargarListasEnSpinner();


        idBotonCrearTarea.setOnClickListener(v -> {

            Lista listaSeleccionada = (Lista) idSpinnerListas.getSelectedItem();

            if (listaSeleccionada != null) {

                TareaCrearEditarView crearEditarFragment = new TareaCrearEditarView();

                Bundle bundle = new Bundle();
                bundle.putInt("id", listaSeleccionada.getIdLista());
                bundle.putString("accion", "crear");

                crearEditarFragment.setArguments(bundle);

                CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), crearEditarFragment);

            } else {

                CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), new ListasView());
                Toast.makeText(this.getContext(), Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getDebe_crear_lista(), Toast.LENGTH_SHORT).show();
            }

        });

        idBotonFiltros.setOnClickListener(v -> {

            CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), new TareaFiltrosView());
        });

        tareaAdapter.setOnItemClickListener(tarea -> {

            TareaVerView verFragment = new TareaVerView();
            Bundle bundle = new Bundle();
            bundle.putSerializable("tarea", tarea);

            verFragment.setArguments(bundle);

            CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), verFragment);
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {}
                }
        );

        return view;
    }

    private void cargarListasEnSpinner() {
        listaDeListas = new ArrayList<>();

        new Thread(() -> {
            ArrayList<HashMap<String, Object>> listasRaw = Lista_controlador.recoger_listas();

            requireActivity().runOnUiThread(() -> {

                if (listasRaw != null) {
                    for (HashMap<String, Object> fila : listasRaw) {
                        int idLista = (int) fila.get("idLista");
                        String titulo = (String) fila.get("titulo");
                        String email = (String) fila.get("email");

                        listaDeListas.add(new Lista(idLista, titulo, email));
                    }
                }

                listaAdapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, listaDeListas);
                listaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                idSpinnerListas.setAdapter(listaAdapter);

                if (idListaParaSeleccionar != -1) {

                    for (int i = 0; i < listaDeListas.size(); i++) {

                        if (listaDeListas.get(i).getIdLista() == idListaParaSeleccionar) {

                            idSpinnerListas.setSelection(i);
                            break;
                        }
                    }
                }

                idSpinnerListas.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {

                        Lista listaSeleccionada = (Lista) parent.getItemAtPosition(position);

                        SharedPreferences prefs = requireContext().getSharedPreferences("tarea_lista_seleccionada", 0);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("idListaSeleccionada", listaSeleccionada.getIdLista());
                        editor.apply();

                        actualizarPanelTareas(listaSeleccionada.getIdLista());
                    }

                    @Override
                    public void onNothingSelected(android.widget.AdapterView<?> parent) {
                        // Nada seleccionado
                    }
                });
            });
        }).start();
    }

    private void actualizarPanelTareas(int idListaSeleccionada) {
        new Thread(() -> {

            SharedPreferences prefs = requireContext().getSharedPreferences("filtros", 0);

            String consulta = Tarea_controlador.generarConsulta(
                    idListaSeleccionada
                    , prefs.getBoolean("completadas", true)
                    , prefs.getBoolean("incompletas", true)
                    , prefs.getBoolean("baja", true)
                    , prefs.getBoolean("media", true)
                    , prefs.getBoolean("alta", true)
                    , prefs.getInt("orden", 0)); // Genero la consulta

            ArrayList<HashMap<String, Object>> tareasRaw = Tarea_controlador.recoger_tareas(consulta);

            requireActivity().runOnUiThread(() -> {

                listaTareas.clear();

                if (tareasRaw != null) {

                    for (HashMap<String, Object> fila : tareasRaw) {

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

                tareaAdapter.notifyDataSetChanged(); // Notificas que cambió la lista
            });
        }).start();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).bloquearIdiomaMenu(false);
        }
    }
}
