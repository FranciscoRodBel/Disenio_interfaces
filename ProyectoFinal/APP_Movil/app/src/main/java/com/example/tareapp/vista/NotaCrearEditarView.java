package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.modelo.Nota;
import com.example.tareapp.modelo.idioma.Pagina_notas;

public class NotaCrearEditarView extends Fragment {
    private ImageButton idBorrarNota, idCerrarPanel;
    private TextView idTitulo;
    private EditText idInputDescripcion;
    private RadioGroup idGrupoColores;
    private RadioButton idBotonColorAmarillo, idBotonColorAzul, idBotonColorMorado, idBotonColorNaranja, idBotonColorRosa, idBotonColorVerde;
    private Button idBotonCrearEditarNota;
    private TextView idMensajeResultado;
    private Nota nota;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nota_crear_editar_view, container, false);

        Pagina_notas pagina_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas();

        idBorrarNota = view.findViewById(R.id.idBorrarNota);
        idCerrarPanel = view.findViewById(R.id.idCerrarPanel);
        idTitulo = view.findViewById(R.id.idTitulo);
        idInputDescripcion = view.findViewById(R.id.idInputDescripcion);
        idGrupoColores = view.findViewById(R.id.idGrupoColores);
        idBotonColorAmarillo = view.findViewById(R.id.idBotonColorAmarillo);
        idBotonColorAzul = view.findViewById(R.id.idBotonColorAzul);
        idBotonColorMorado = view.findViewById(R.id.idBotonColorMorado);
        idBotonColorNaranja = view.findViewById(R.id.idBotonColorNaranja);
        idBotonColorRosa = view.findViewById(R.id.idBotonColorRosa);
        idBotonColorVerde = view.findViewById(R.id.idBotonColorVerde);
        idBotonCrearEditarNota = view.findViewById(R.id.idBotonCrearEditarNota);
        idMensajeResultado = view.findViewById(R.id.idMensajeResultado);

        // Envío de formulario de crear tarea
        Bundle bundle = getArguments();

        if (bundle != null) {

            String accion = bundle.getString("accion", "crear");
            nota = (Nota) getArguments().getSerializable("nota");

            idInputDescripcion.setHint(Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getDescripcion());

            if (accion.equals("editar")) {

                idTitulo.setText(pagina_notas.getEditar_nota());
                idInputDescripcion.setText(nota.getDescripcion());
                idBotonCrearEditarNota.setText(pagina_notas.getEditar_nota());

            } else {

                idTitulo.setText(pagina_notas.getCrear_nota());
                idBotonCrearEditarNota.setText(pagina_notas.getCrear_nota());
            }
        }

        idCerrarPanel.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }

}
