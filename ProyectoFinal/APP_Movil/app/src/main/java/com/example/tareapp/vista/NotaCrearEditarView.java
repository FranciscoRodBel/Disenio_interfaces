package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
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

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Nota_controlador;
import com.example.tareapp.controlador.Tarea_controlador;
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
    private Nota_controlador nota_controlador = new Nota_controlador();
    private Pagina_notas pagina_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas();
    String colorSeleccionado;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.nota_crear_editar_view, container, false);

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
            seleccionarColor(idBotonColorAmarillo);
        }

        idBotonColorAmarillo.setOnClickListener(v -> seleccionarColor(idBotonColorAmarillo));
        idBotonColorAzul.setOnClickListener(v -> seleccionarColor(idBotonColorAzul));
        idBotonColorMorado.setOnClickListener(v -> seleccionarColor(idBotonColorMorado));
        idBotonColorNaranja.setOnClickListener(v -> seleccionarColor(idBotonColorNaranja));
        idBotonColorRosa.setOnClickListener(v -> seleccionarColor(idBotonColorRosa));
        idBotonColorVerde.setOnClickListener(v -> seleccionarColor(idBotonColorVerde));

        idCerrarPanel.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().popBackStack();
        });

        idBotonCrearEditarNota.setOnClickListener(v -> {
            new Thread(() -> {

                String descripcion = idInputDescripcion.getText().toString();

                final String[] mensaje_resultado = new String[1];

                if (accion.equals("crear")) {

                    mensaje_resultado[0] = nota_controlador.crear_nota(descripcion, colorSeleccionado);

                } else if (accion.equals("editar")) {

                    mensaje_resultado[0] = nota_controlador.editar_nota(nota.getIdNota(), descripcion, colorSeleccionado);
                }

                requireActivity().runOnUiThread(() -> {

                    if (mensaje_resultado[0].isEmpty()) {

                        if (accion.equals("crear")) {

                            idInputDescripcion.setText("");

                            mensaje_resultado[0] = pagina_notas.getNota_creada();

                        } else {

                            mensaje_resultado[0] = pagina_notas.getNota_editada();
                        }
                    }

                    idMensajeResultado.setText(mensaje_resultado[0]);

                    new android.os.Handler().postDelayed(() -> {
                        if (isAdded()) {
                            requireActivity().runOnUiThread(() ->
                                    idMensajeResultado.setText(""));
                        }
                    }, 3000);
                });
            }).start();
        });

        return view;
    }
    @SuppressLint("NonConstantResourceId")
    private void seleccionarColor(RadioButton radioButton) {

        quitarFotoSeleccionada();

        idGrupoColores.clearCheck();
        radioButton.setChecked(true);

        switch (radioButton.getId()) {
            case R.id.idBotonColorAmarillo:
                idBotonColorAmarillo.setBackgroundResource(R.drawable.radioamarilloseleccionado);
                colorSeleccionado = "amarillo";
                break;
            case R.id.idBotonColorAzul:
                idBotonColorAzul.setBackgroundResource(R.drawable.radioazulseleccionado);
                colorSeleccionado = "azul";
                break;
            case R.id.idBotonColorMorado:
                idBotonColorMorado.setBackgroundResource(R.drawable.radiomoradoseleccionado);
                colorSeleccionado = "morado";
                break;
            case R.id.idBotonColorNaranja:
                idBotonColorNaranja.setBackgroundResource(R.drawable.radionaranjaseleccionado);
                colorSeleccionado = "naranja";
                break;
            case R.id.idBotonColorRosa:
                idBotonColorRosa.setBackgroundResource(R.drawable.radiorosaseleccionado);
                colorSeleccionado = "rosa";
                break;
            case R.id.idBotonColorVerde:
                idBotonColorVerde.setBackgroundResource(R.drawable.radioverdeseleccionado);
                colorSeleccionado = "verde";
                break;
        }
    }

    private void quitarFotoSeleccionada() {

        idBotonColorAmarillo.setBackgroundResource(R.drawable.radioamarillo);
        idBotonColorAzul.setBackgroundResource(R.drawable.radioazul);
        idBotonColorMorado.setBackgroundResource(R.drawable.radiomorado);
        idBotonColorNaranja.setBackgroundResource(R.drawable.radionaranja);
        idBotonColorRosa.setBackgroundResource(R.drawable.radiorosa);
        idBotonColorVerde.setBackgroundResource(R.drawable.radioverde);
    }
}
