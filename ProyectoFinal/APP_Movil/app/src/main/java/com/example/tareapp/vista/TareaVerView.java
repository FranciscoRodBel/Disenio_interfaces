package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.CambiarVista;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Tarea_controlador;
import com.example.tareapp.modelo.Tarea;
import com.example.tareapp.modelo.idioma.Pagina_tareas;

public class TareaVerView extends Fragment {

    private ImageButton idBorrarTarea, idCerrarPanel;
    private TextView idTituloTarea, idLabelFecha, idFechaTarea, idLabelPrioridad, idPrioridadTarea, idLabelDescripcion, idDescripcionTarea;
    private Button idBotonEditarTarea;
    private Tarea_controlador tarea_controlador = new Tarea_controlador();
    private Pagina_tareas idioma_tareas = Idioma_controlador.getIdioma_seleccionado().getPagina_tareas();

    @SuppressLint({"MissingInflatedId", "SetTextI18n"})
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tarea_ver_view, container, false);

        idBorrarTarea = view.findViewById(R.id.idBorrarTarea);
        idCerrarPanel = view.findViewById(R.id.idCerrarPanel);
        idTituloTarea = view.findViewById(R.id.idTituloLista);
        idLabelFecha = view.findViewById(R.id.idLabelEmail);
        idFechaTarea = view.findViewById(R.id.idEmailCuenta);
        idLabelPrioridad = view.findViewById(R.id.idLabelPrioridad);
        idPrioridadTarea = view.findViewById(R.id.idPrioridadTarea);
        idLabelDescripcion = view.findViewById(R.id.idLabelDescripcion);
        idDescripcionTarea = view.findViewById(R.id.idDescripcionTarea);
        idBotonEditarTarea = view.findViewById(R.id.idBotonEditarTarea);

        idLabelFecha.setText(idioma_tareas.getFecha()+":");
        idLabelPrioridad.setText(idioma_tareas.getPrioridad()+":");
        idLabelDescripcion.setText(idioma_tareas.getDescripcion());
        idBotonEditarTarea.setText(idioma_tareas.getEditar_tarea());

        Bundle args = getArguments();

        if (args != null) {

            Tarea tarea = (Tarea) args.getSerializable("tarea");

            if (tarea != null) {

                idTituloTarea.setText(tarea.getTitulo());
                idFechaTarea.setText(TareaAdapter.convertirFechaAString(tarea.getFecha()));
                idPrioridadTarea.setText(tarea.recoger_prioridad_tarea());
                idDescripcionTarea.setText(tarea.getDescripcion());

                idBotonEditarTarea.setOnClickListener(v -> {

                    TareaCrearEditarView tareaCrearEditarView = new TareaCrearEditarView();
                    Bundle bundle = new Bundle();
                    bundle.putString("accion", "editar");
                    bundle.putSerializable("tarea", tarea);

                    tareaCrearEditarView.setArguments(bundle);

                    CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), tareaCrearEditarView);
                });

                idBorrarTarea.setOnClickListener(v -> {

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                    alertDialogBuilder.setTitle(idioma_tareas.getPregunta_borrar_tarea());
                    alertDialogBuilder
                            .setMessage(tarea.getTitulo())
                            .setCancelable(false)
                            .setPositiveButton(idioma_tareas.getBorrar_tarea(), new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    new Thread(() -> {

                                        String mensaje_resultado = tarea_controlador.borrar_tarea(tarea.getIdTarea());

                                        if (mensaje_resultado.isEmpty()) {

                                            requireActivity().runOnUiThread(() -> {
                                                Toast.makeText(getContext(), idioma_tareas.getTarea_borrada(), Toast.LENGTH_SHORT).show();
                                                requireActivity().getSupportFragmentManager().popBackStack();
                                            });
                                        }
                                    }).start();
                                }
                            })
                            .setNegativeButton(idioma_tareas.getCancelar(), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.cancel(); // Cerrar popUp
                                }
                            }).create().show();
                });
            }
        }

        idCerrarPanel.setOnClickListener(v -> {

            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }
}
