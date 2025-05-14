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
import androidx.fragment.app.DialogFragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.CambiarVista;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Nota_controlador;
import com.example.tareapp.modelo.Nota;
import com.example.tareapp.modelo.idioma.Pagina_inicio_registro;
import com.example.tareapp.modelo.idioma.Pagina_listas;
import com.example.tareapp.modelo.idioma.Pagina_notas;

/**
 * Clase para la vista del PopUp que permite ver una nota
 *
 * @author Francisco
 */
public class NotaVer extends DialogFragment {

    private ImageButton idBorrarNota, idCerrarPanel;
    private Button idBotonEditarNota;
    private TextView idTitulo, idDescripcionNota;
    private Nota nota;
    private NotaListener notaListener;
    private Nota_controlador nota_controlador = new Nota_controlador();
    private Pagina_notas pagina_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas();

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nota_ver, container, false);

        idBorrarNota = view.findViewById(R.id.idBorrarNota);
        idTitulo = view.findViewById(R.id.idTitulo);
        idBotonEditarNota = view.findViewById(R.id.idBotonEditarNota);
        idDescripcionNota = view.findViewById(R.id.idDescripcionNota);
        idCerrarPanel = view.findViewById(R.id.idCerrarPanel);

        // Añado el idioma de los textos
        idTitulo.setText(pagina_notas.getVer_nota());
        idBotonEditarNota.setText(pagina_notas.getEditar_nota());

        nota = (Nota) getArguments().getSerializable("nota"); // Recojo la nota que ha sido enviada desde NotasView
        idDescripcionNota.setText(nota.getDescripcion());

        idCerrarPanel.setOnClickListener(v -> dismiss()); // Cierra el PopUp

        idBotonEditarNota.setOnClickListener(v -> {  // Le añado al un listener para cuando pulse en editar nota

            NotaCrearEditarView fragment = new NotaCrearEditarView(); // Creo la vista y envío la acción(editar) y el objeto nota
            Bundle bundle = new Bundle();
            bundle.putString("accion", "editar");
            bundle.putSerializable("nota", nota);
            fragment.setArguments(bundle);

            dismiss(); // Cierro el PopUp actual

            CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), fragment); // Cambio la vista
        });

        idBorrarNota.setOnClickListener(v -> {  // Le añado al un listener para cuando pulse en borrar nota

            // Creo un PopUp con un AlertDialog para preguntar si quiere borrar la lista
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
            alertDialogBuilder.setTitle(pagina_notas.getPregunta_borrar_nota());
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton(pagina_notas.getBorrar_nota(), new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) { // Si pulsa en aceptar...
                            new Thread(() -> {

                                String mensaje_resultado = nota_controlador.borrar_nota(nota.getIdNota()); // Borra la nota

                                if (mensaje_resultado.isEmpty()) { // Si el mensaje está vacío es que lo eliminó

                                    requireActivity().runOnUiThread(() -> {

                                        Toast.makeText(getContext(), pagina_notas.getNota_borrada(), Toast.LENGTH_SHORT).show(); // Muestro el mensaje con el resultado

                                        dismiss(); // Cierro el PopUp

                                        if (notaListener != null) {

                                            notaListener.onNotaActualizada(); // Activo el listener que actualiza el panel
                                        }
                                    });
                                }
                            }).start();
                        }
                    })
                    .setNegativeButton(Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getCancelar(), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel(); // Cerrar popUp
                        }
                    }).create().show();
        });

        return view;
    }

    public interface NotaListener {  // Cuando se edite se activará la función onNotaActualizada, que actualizará el panel de notas
        void onNotaActualizada();
    }

    public void setNotaListener(NotaListener listener) { // Para aplicar un listener al fragmento principal(NotasView)
        this.notaListener = listener;
    }


    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
