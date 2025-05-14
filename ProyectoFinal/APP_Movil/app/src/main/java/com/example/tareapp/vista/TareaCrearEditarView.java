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


import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Tarea_controlador;
import com.example.tareapp.modelo.Tarea;
import com.example.tareapp.modelo.idioma.Pagina_tareas;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Clase para la vista de editar y crear tareas
 *
 * @author Francisco
 */
public class TareaCrearEditarView extends Fragment {

    private ImageButton idCerrarPanel;
    private EditText idInputTituloTarea, idInputFecha, idInputDescripcion;
    private Spinner idSpinnerPrioridad;
    private Button idBotonCrearEditarTarea;
    private TextView idTituloCrearEditarTarea, idMensajeResultado;
    private int idLista;
    private Tarea tarea;
    private Tarea_controlador tarea_controlador = new Tarea_controlador();
    private Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

    private Boolean editado = false; // Guardo si ha editado o no para saber si tengo que cerrar el PopUp de ver tarea al editar

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tarea_crear_editar_view, container, false);

        Pagina_tareas pagina_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

        idTituloCrearEditarTarea = view.findViewById(R.id.idTitulo);
        idCerrarPanel = view.findViewById(R.id.idCerrarPanel);
        idInputTituloTarea = view.findViewById(R.id.idInputTituloTarea);
        idInputFecha = view.findViewById(R.id.idInputFecha);
        idSpinnerPrioridad = view.findViewById(R.id.idSpinnerPrioridad);
        idInputDescripcion = view.findViewById(R.id.idInputDescripcion);
        idBotonCrearEditarTarea = view.findViewById(R.id.idBotonAceptar);
        idMensajeResultado = view.findViewById(R.id.idMensajeResultado);

        // Spinner con las prioridades
        String[] prioridades = {pagina_tareas.getPrioridad(), pagina_tareas.getBaja(), pagina_tareas.getMedia(), pagina_tareas.getAlta()};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, prioridades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idSpinnerPrioridad.setAdapter(adapter);

        final Calendar calendar = Calendar.getInstance(); // Objeto calendario para mostrar un calendario al pulsar en el input fecha

        idInputFecha.setOnClickListener(v -> { // Al pulsar en el input fecha...

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
            datePickerDialog.show(); // Muestra el objeto datePickerDialog que es un calendario que se despliega para que seleccione la fecha
        });

        Bundle bundle = getArguments(); // Recojo los argumentos del Bundle

        if (bundle != null) {

            String accion = bundle.getString("accion", "crear"); // Recojo la acción que será "crear" de forma predeterminada
            int idLista = bundle.getInt("id", -1); // Se recoge el id de lista, si no se manda será -1(significará que está creando)
            tarea = (Tarea) getArguments().getSerializable("tarea"); // Si está editando se enviará la tarea

            // Añado el idioma de los textos
            idInputTituloTarea.setHint(idioma_tareas.getTitulo_tarea());
            idInputFecha.setHint(idioma_tareas.getSeleccione_fecha());
            idInputDescripcion.setHint(idioma_tareas.getDescripcion());

            if (accion.equals("editar")) {

                idTituloCrearEditarTarea.setText(idioma_tareas.getEditar_tarea());
                idBotonCrearEditarTarea.setText(idioma_tareas.getEditar_tarea());

                idInputTituloTarea.setText(tarea.getTitulo());
                idInputFecha.setText(TareaAdapter.convertirFechaAString(tarea.getFecha()));
                idSpinnerPrioridad.setSelection(tarea.getPrioridad());
                idInputDescripcion.setText(tarea.getDescripcion());

            } else {

                idTituloCrearEditarTarea.setText(idioma_tareas.getCrear_tarea());
                idBotonCrearEditarTarea.setText(idioma_tareas.getCrear_tarea());

            }

            idCerrarPanel.setOnClickListener(v -> {

                if (editado) { // Si ha editado cierro los dos PopUp y si no, cierro uno

                    requireActivity().getSupportFragmentManager().popBackStack();
                    requireActivity().getSupportFragmentManager().popBackStack();

                } else {

                    requireActivity().getSupportFragmentManager().popBackStack();
                }

            });

            idBotonCrearEditarTarea.setOnClickListener(v -> { // Si pulsa en confirmar crear o editar...
                new Thread(() -> {

                    // Recojo los datos de los inputs
                    String titulo = idInputTituloTarea.getText().toString();
                    int prioridad = idSpinnerPrioridad.getSelectedItemPosition();
                    String fecha = idInputFecha.getText().toString();
                    String descripcion = idInputDescripcion.getText().toString();

                    final String[] mensaje_resultado = new String[1];

                    if (accion.equals("crear")) { // Dependiendo de la acción edito o creo la tarea

                        mensaje_resultado[0] = tarea_controlador.crear_tarea(titulo, prioridad, fecha, descripcion, idLista);

                    } else if (accion.equals("editar")) {

                        mensaje_resultado[0] = tarea_controlador.editar_tarea(tarea.getIdTarea(), titulo, prioridad, fecha, descripcion, tarea.getIdLista());
                    }

                    requireActivity().runOnUiThread(() -> {

                        if (mensaje_resultado[0].isEmpty()) { // Si está vacío es que editó o creó correctamente

                            if (accion.equals("crear")) { // Si está creando, vacío los inputs y guardo el mensaje de "tarea creada"

                                idInputTituloTarea.setText("");
                                idInputFecha.setText("");
                                idSpinnerPrioridad.setSelection(0);
                                idInputDescripcion.setText("");

                                mensaje_resultado[0] = idioma_tareas.getTarea_creada();

                            } else {

                                mensaje_resultado[0] = idioma_tareas.getTarea_editada();
                                editado = true;

                                requireActivity().getOnBackPressedDispatcher().addCallback( // Bloqueo para que no pueda echar con la flecha a la vista anterior y tenga que cerrar desde la X
                                        getViewLifecycleOwner(),
                                        new OnBackPressedCallback(true) {
                                            @Override
                                            public void handleOnBackPressed() {}
                                        }
                                );
                            }
                        }

                        idMensajeResultado.setText(mensaje_resultado[0]);

                        new android.os.Handler().postDelayed(() -> {
                            if (isAdded()) {
                                requireActivity().runOnUiThread(() ->
                                        idMensajeResultado.setText(""));
                            }
                        }, 3000); // Muestro el resultado durante 3 segundos
                    });
                }).start();
            });
        }
        return view;
    }
}
