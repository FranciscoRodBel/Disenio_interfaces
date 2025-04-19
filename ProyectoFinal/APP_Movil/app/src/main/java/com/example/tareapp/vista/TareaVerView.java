package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Tarea_controlador;
import com.example.tareapp.modelo.idioma.Pagina_tareas;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TareaCrearEditarView extends Fragment {

    private ImageButton idBorrarTarea;
    private ImageButton idCerrarPanel;
    private EditText idInputTituloTarea, idInputFecha, idInputDescripcion;
    private Spinner idSpinnerPrioridad;
    private Button idBotonCrearEditarTarea;
    private TextView idTituloCrearEditarTarea, idMensajeResultado;
    private int idLista;
    private Tarea_controlador tarea_controlador = new Tarea_controlador();
    private Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tarea_crear_editar_view, container, false);

        Pagina_tareas pagina_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

        idTituloCrearEditarTarea = view.findViewById(R.id.idTituloCrearEditarTarea);
        idBorrarTarea = view.findViewById(R.id.idBorrarTarea);
        idCerrarPanel = view.findViewById(R.id.idCerrarPanel);
        idInputTituloTarea = view.findViewById(R.id.idInputTituloTarea);
        idInputFecha = view.findViewById(R.id.idInputFecha);
        idSpinnerPrioridad = view.findViewById(R.id.idSpinnerPrioridad);
        idInputDescripcion = view.findViewById(R.id.idInputDescripcion);
        idBotonCrearEditarTarea = view.findViewById(R.id.idBotonEditarTarea);
        idMensajeResultado = view.findViewById(R.id.idMensajeResultado);

        idCerrarPanel.setOnClickListener(v -> {

            requireActivity().getSupportFragmentManager().popBackStack();
        });

        // SPINNER
        Spinner spinnerPrioridad = view.findViewById(R.id.idSpinnerPrioridad);

        String[] prioridades = {pagina_tareas.getPrioridad(), pagina_tareas.getBaja(), pagina_tareas.getMedia(), pagina_tareas.getAlta()};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, prioridades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerPrioridad.setAdapter(adapter);

        final Calendar calendar = Calendar.getInstance();

        idInputFecha.setOnClickListener(v -> {

            DatePickerDialog datePickerDialog = new DatePickerDialog(

                    requireContext(),
                    (view2, year, monthOfYear, dayOfMonth) -> {
                        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                        calendar.set(year, monthOfYear, dayOfMonth);
                        idInputFecha.setText(sdf.format(calendar.getTime()));
                    },

                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            datePickerDialog.show();
        });

        // Envío de formulario de crear tarea
        Bundle bundle = getArguments();

        if (bundle != null) {

            String accion = bundle.getString("accion", "crear");
            int idLista = bundle.getInt("id", -1);

            if (accion.equals("editar")) {

                idTituloCrearEditarTarea.setText(Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getEditar_tarea());
                idBotonCrearEditarTarea.setText(Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getEditar_tarea());

            } else {

                idTituloCrearEditarTarea.setText(Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getCrear_tarea());
                idBotonCrearEditarTarea.setText(Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getCrear_tarea());
            }

            idBotonCrearEditarTarea.setOnClickListener(v -> {
                new Thread(() -> {

                    String titulo = idInputTituloTarea.getText().toString();
                    String prioridad = idSpinnerPrioridad.getSelectedItem().toString();
                    String fecha = idInputFecha.getText().toString();
                    String descripcion = idInputDescripcion.getText().toString();

                    final String[] mensaje_resultado = new String[1];

                    if (accion.equals("crear")) {

                        mensaje_resultado[0] = tarea_controlador.crear_tarea(titulo, prioridad, fecha, descripcion, idLista);

                        requireActivity().runOnUiThread(() -> {

                            if (mensaje_resultado[0].isEmpty()) {

                                idInputTituloTarea.setText("");
                                idInputFecha.setText("");
                                idSpinnerPrioridad.setSelection(0);
                                idInputDescripcion.setText("");

                                mensaje_resultado[0] = idioma_tareas.getTarea_creada();
                                //tareas_view.actualizarVistaTareas(requireContext()); // Actualizar la lista de tareas
                            }

                            idMensajeResultado.setText(mensaje_resultado[0]);

                            new android.os.Handler().postDelayed(() -> {
                                if (isAdded()) {
                                    requireActivity().runOnUiThread(() ->
                                            idMensajeResultado.setText(""));
                                }
                            }, 3000);
                        });

                    } else if (accion.equals("editar")) {



                    }
                }).start();
            });
        }
        return view;
    }
}
