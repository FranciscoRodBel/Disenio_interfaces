package com.example.tareapp.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.modelo.idioma.Pagina_tareas;

public class TareaCrearEditarView extends Fragment {

    private ImageButton idBorrarTarea;
    private ImageButton idCerrarPanel;
    private EditText idInputTituloTarea, idInputFecha, idInputDescripcion;
    private Spinner idSpinnerPrioridad;
    private Button idBotonCrearTarea;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tarea_crear_editar_view, container, false);

        Pagina_tareas pagina_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

        idBorrarTarea = view.findViewById(R.id.idBorrarTarea);
        idCerrarPanel = view.findViewById(R.id.idCerrarPanel);
        idInputTituloTarea = view.findViewById(R.id.idInputTituloTarea);
        idInputFecha = view.findViewById(R.id.idInputFecha);
        idSpinnerPrioridad = view.findViewById(R.id.idSpinnerPrioridad);
        idInputDescripcion = view.findViewById(R.id.idInputDescripcion);
        idBotonCrearTarea = view.findViewById(R.id.idBotonCrearTarea);

        idCerrarPanel.setOnClickListener(v -> {

            requireActivity().getSupportFragmentManager().popBackStack();
        });

        // SPINNER
        Spinner spinnerPrioridad = view.findViewById(R.id.idSpinnerPrioridad);

        String[] prioridades = {pagina_tareas.getPrioridad(), pagina_tareas.getBaja(), pagina_tareas.getMedia(), pagina_tareas.getAlta()};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, prioridades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPrioridad.setAdapter(adapter);

        idBotonCrearTarea.setOnClickListener(v -> {

            String mensaje_resultado = "";
            String titulo = idInputTituloTarea.getText().toString();
            String prioridad = idSpinnerPrioridad.getSelectedItem().toString();
            String fecha = idInputFecha.getText().toString();
            String descripcion = idInputDescripcion.getText().toString();
            int idLista = 1; //tareas_view.recoger_id_lista_seleccionada();

            // Código para crear la tarea
        });

        return view;
    }
}
