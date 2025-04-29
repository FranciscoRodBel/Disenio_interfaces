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

        idTitulo.setText(pagina_notas.getVer_nota());
        idBotonEditarNota.setText(pagina_notas.getEditar_nota());

        nota = (Nota) getArguments().getSerializable("nota");
        idDescripcionNota.setText(nota.getDescripcion());

        idCerrarPanel.setOnClickListener(v -> dismiss());

        idBotonEditarNota.setOnClickListener(v -> {

            NotaCrearEditarView fragment = new NotaCrearEditarView();
            Bundle bundle = new Bundle();
            bundle.putString("accion", "editar");
            bundle.putSerializable("nota", nota);
            fragment.setArguments(bundle);

            dismiss();

            CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), fragment);
        });

        idBorrarNota.setOnClickListener(v -> {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
            alertDialogBuilder.setTitle(pagina_notas.getPregunta_borrar_nota());
            alertDialogBuilder
                    .setCancelable(false)
                    .setPositiveButton(pagina_notas.getBorrar_nota(), new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            new Thread(() -> {

                                String mensaje_resultado = nota_controlador.borrar_nota(nota.getIdNota());

                                if (mensaje_resultado.isEmpty()) {

                                    requireActivity().runOnUiThread(() -> {
                                        Toast.makeText(getContext(), pagina_notas.getNota_borrada(), Toast.LENGTH_SHORT).show();

                                        dismiss();

                                        if (notaListener != null) {

                                            notaListener.onNotaActualizada();
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

    public interface NotaListener {
        void onNotaActualizada();
    }

    public void setNotaListener(NotaListener listener) {
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
