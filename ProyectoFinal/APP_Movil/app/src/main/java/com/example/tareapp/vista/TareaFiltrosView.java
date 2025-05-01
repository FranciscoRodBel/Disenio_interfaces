package com.example.tareapp.vista;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.modelo.idioma.Pagina_tareas;

public class TareaFiltrosView extends Fragment {

    private ImageButton idCerrarPanel;
    private TextView idTitulo, idTareasCompletadas, idTareasIncompletas,
            idTareasPrioridadBaja, idTareasPrioridadMedia, idTareasPrioridadAlta;
    private CheckBox idMarcarTareaCompletadas, idMarcarTareaIncompletas,
            idMarcarTareaPrioridadBaja, idMarcarTareaPrioridadMedia, idMarcarTareaPrioridadAlta;
    private Spinner idSpinnerOrdenTareas;
    private Button idBotonAceptar;

    private Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tarea_filtros_view, container, false);

        idCerrarPanel = view.findViewById(R.id.idCerrarPanel);
        idTitulo = view.findViewById(R.id.idTitulo);

        idTareasCompletadas = view.findViewById(R.id.idTareasCompletadas);
        idTareasIncompletas = view.findViewById(R.id.idTareasIncompletas);
        idTareasPrioridadBaja = view.findViewById(R.id.idTareasPrioridadBaja);
        idTareasPrioridadMedia = view.findViewById(R.id.idTareasPrioridadMedia);
        idTareasPrioridadAlta = view.findViewById(R.id.idTareasPrioridadAlta);

        idMarcarTareaCompletadas = view.findViewById(R.id.idMarcarTareaCompletadas);
        idMarcarTareaIncompletas = view.findViewById(R.id.idMarcarTareaIncompletas);
        idMarcarTareaPrioridadBaja = view.findViewById(R.id.idMarcarTareaPrioridadBaja);
        idMarcarTareaPrioridadMedia = view.findViewById(R.id.idMarcarTareaPrioridadMedia);
        idMarcarTareaPrioridadAlta = view.findViewById(R.id.idMarcarTareaPrioridadAlta);

        idSpinnerOrdenTareas = view.findViewById(R.id.idSpinnerOrdenTareas);
        idBotonAceptar = view.findViewById(R.id.idBotonAceptar);

        idTitulo.setText(idioma_tareas.getFiltros());
        idBotonAceptar.setText(idioma_tareas.getAceptar());

        idTareasCompletadas.setText(idioma_tareas.getMostrar_tareas_completadas());
        idTareasIncompletas.setText(idioma_tareas.getMarcar_completa_incompleta());
        idTareasPrioridadBaja.setText(idioma_tareas.getMostrar_prioridad_baja());
        idTareasPrioridadMedia.setText(idioma_tareas.getMostrar_prioridad_media());
        idTareasPrioridadAlta.setText(idioma_tareas.getMostrar_prioridad_alta());

        String[] opcionesOrden = {
                idioma_tareas.getMostrar_tareas_az(),
                idioma_tareas.getMostrar_tareas_za(),
                idioma_tareas.getMostrar_tareas_19(),
                idioma_tareas.getMostrar_tareas_91(),
        };

        Spinner idSpinnerOrdenTareas = view.findViewById(R.id.idSpinnerOrdenTareas);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), android.R.layout.simple_spinner_item, opcionesOrden);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        idSpinnerOrdenTareas.setAdapter(adapter);

        SharedPreferences prefs = requireContext().getSharedPreferences("filtros", 0);

        idSpinnerOrdenTareas.setSelection(prefs.getInt("orden", 0));

        idMarcarTareaCompletadas.setChecked(prefs.getBoolean("completadas", true));
        idMarcarTareaIncompletas.setChecked(prefs.getBoolean("incompletas", true));
        idMarcarTareaPrioridadBaja.setChecked(prefs.getBoolean("baja", true));
        idMarcarTareaPrioridadMedia.setChecked(prefs.getBoolean("media", true));
        idMarcarTareaPrioridadAlta.setChecked(prefs.getBoolean("alta", true));

        idCerrarPanel.setOnClickListener(v -> requireActivity().getSupportFragmentManager().popBackStack());

        idBotonAceptar.setOnClickListener(v -> {

            int spinnerPos = idSpinnerOrdenTareas.getSelectedItemPosition();

            boolean completadas = idMarcarTareaCompletadas.isChecked();
            boolean incompletas = idMarcarTareaIncompletas.isChecked();
            boolean prioridadBaja = idMarcarTareaPrioridadBaja.isChecked();
            boolean prioridadMedia = idMarcarTareaPrioridadMedia.isChecked();
            boolean prioridadAlta = idMarcarTareaPrioridadAlta.isChecked();

            requireContext().getSharedPreferences("filtros", 0)
                    .edit()
                    .putInt("orden", spinnerPos)
                    .putBoolean("completadas", completadas)
                    .putBoolean("incompletas", incompletas)
                    .putBoolean("baja", prioridadBaja)
                    .putBoolean("media", prioridadMedia)
                    .putBoolean("alta", prioridadAlta)
                    .apply();

            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }
}
