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

/**
 * Clase para la vista que permite ver una tarea
 *
 * @author Francisco
 */
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
        idTituloTarea = view.findViewById(R.id.idTitulo);
        idLabelFecha = view.findViewById(R.id.idLabelEmail);
        idFechaTarea = view.findViewById(R.id.idEmailCuenta);
        idLabelPrioridad = view.findViewById(R.id.idLabelPrioridad);
        idPrioridadTarea = view.findViewById(R.id.idPrioridadTarea);
        idLabelDescripcion = view.findViewById(R.id.idLabelDescripcion);
        idDescripcionTarea = view.findViewById(R.id.idDescripcionTarea);
        idBotonEditarTarea = view.findViewById(R.id.idBotonAceptar);

        // Añado el idioma de los textos
        idLabelFecha.setText(idioma_tareas.getFecha()+":");
        idLabelPrioridad.setText(idioma_tareas.getPrioridad()+":");
        idLabelDescripcion.setText(idioma_tareas.getDescripcion());
        idBotonEditarTarea.setText(idioma_tareas.getEditar_tarea());

        Bundle args = getArguments();

        if (args != null) {

            Tarea tarea = (Tarea) args.getSerializable("tarea"); // Recojo la tarea enviada desde TareasView

            if (tarea != null) {

                // Añado el idioma de los textos
                idTituloTarea.setText(tarea.getTitulo());
                idFechaTarea.setText(TareaAdapter.convertirFechaAString(tarea.getFecha()));
                idPrioridadTarea.setText(tarea.recoger_prioridad_tarea());
                idDescripcionTarea.setText(tarea.getDescripcion());

                idBotonEditarTarea.setOnClickListener(v -> { // Si pulsa en editar, envío el objeto de la tarea y la acción de editar

                    TareaCrearEditarView tareaCrearEditarView = new TareaCrearEditarView();
                    Bundle bundle = new Bundle();
                    bundle.putString("accion", "editar");
                    bundle.putSerializable("tarea", tarea);

                    tareaCrearEditarView.setArguments(bundle);

                    CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), tareaCrearEditarView); // Cambio la vista
                });

                idBorrarTarea.setOnClickListener(v -> { // Si pulsa en eliminar tarea...

                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
                    alertDialogBuilder.setTitle(idioma_tareas.getPregunta_borrar_tarea());
                    alertDialogBuilder
                            .setMessage(tarea.getTitulo())
                            .setCancelable(false)
                            .setPositiveButton(idioma_tareas.getBorrar_tarea(), new DialogInterface.OnClickListener() {

                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) { // Si pulsa en aceptar...
                                    new Thread(() -> {

                                        String mensaje_resultado = tarea_controlador.borrar_tarea(tarea.getIdTarea()); // Borra la tarea

                                        if (mensaje_resultado.isEmpty()) { // Si el mensaje está vacío es que lo eliminó

                                            requireActivity().runOnUiThread(() -> {
                                                Toast.makeText(getContext(), idioma_tareas.getTarea_borrada(), Toast.LENGTH_SHORT).show(); // Muestro el mensaje con el resultado
                                                requireActivity().getSupportFragmentManager().popBackStack(); // Cierro el PopUp
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
        });  // Cierra el PopUp

        return view;
    }
}
