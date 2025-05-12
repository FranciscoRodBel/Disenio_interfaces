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
import com.example.tareapp.controlador.Nota_controlador;
import com.example.tareapp.modelo.Nota;
import com.example.tareapp.modelo.idioma.Pagina_notas;

/**
 * Clase para la vista de editar y crear notas
 *
 * @author Francisco
 */
public class NotaCrearEditarView extends Fragment {
    private ImageButton idCerrarPanel;
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
        idBotonCrearEditarNota = view.findViewById(R.id.idBotonAceptar);
        idMensajeResultado = view.findViewById(R.id.idMensajeResultado);

        Bundle bundle = getArguments(); // Reocojo la acción enviada
        String accion = bundle.getString("accion", "crear"); // Recojo la acción, por defecto crear
        nota = (Nota) getArguments().getSerializable("nota"); // Recojo la nota que se habrá enviado si está editando

        idInputDescripcion.setHint(Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getDescripcion());

        // Añado los textos en el idioma correspondiente si está editanto o creando
        if (accion.equals("editar")) {

            idTitulo.setText(pagina_notas.getEditar_nota());
            idInputDescripcion.setText(nota.getDescripcion());
            idBotonCrearEditarNota.setText(pagina_notas.getEditar_nota());
            recogerColor(nota.getColor());

        } else {

            idTitulo.setText(pagina_notas.getCrear_nota());
            idBotonCrearEditarNota.setText(pagina_notas.getCrear_nota());
            seleccionarColor(idBotonColorAmarillo);
        }

        // Añado listener a los inputs radio para cambiar la imagen cuando se seleccione uno
        idBotonColorAmarillo.setOnClickListener(v -> seleccionarColor(idBotonColorAmarillo));
        idBotonColorAzul.setOnClickListener(v -> seleccionarColor(idBotonColorAzul));
        idBotonColorMorado.setOnClickListener(v -> seleccionarColor(idBotonColorMorado));
        idBotonColorNaranja.setOnClickListener(v -> seleccionarColor(idBotonColorNaranja));
        idBotonColorRosa.setOnClickListener(v -> seleccionarColor(idBotonColorRosa));
        idBotonColorVerde.setOnClickListener(v -> seleccionarColor(idBotonColorVerde));

        idCerrarPanel.setOnClickListener(v -> {
                requireActivity().getSupportFragmentManager().popBackStack();
        }); // Cierra el PopUp

        idBotonCrearEditarNota.setOnClickListener(v -> { // Si pulsa en el botón de crear/editar...
            new Thread(() -> {

                String descripcion = idInputDescripcion.getText().toString();

                final String[] mensaje_resultado = new String[1];

                // Intento editar/crear la nota
                if (accion.equals("crear")) {

                    mensaje_resultado[0] = nota_controlador.crear_nota(descripcion, colorSeleccionado);

                } else if (accion.equals("editar")) {

                    mensaje_resultado[0] = nota_controlador.editar_nota(nota.getIdNota(), descripcion, colorSeleccionado);
                }

                requireActivity().runOnUiThread(() -> {

                    if (mensaje_resultado[0].isEmpty()) { // Si el mensaje está vacío es que se editó o creó

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
                    }, 3000); // Muestro el resultado de crear/editar durante 3 segundos
                });
            }).start();
        });

        return view;
    }
    @SuppressLint("NonConstantResourceId")
    private void seleccionarColor(RadioButton radioButton) {
        quitarFotoSeleccionada(); // Les quito a todos la foto del radioButton marcado
        idGrupoColores.clearCheck(); // Desmarco todos los radioButton
        radioButton.setChecked(true); // Marco el radioButton pulsado

        // Actualuizo el color seleccionado y la foto
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
    private void recogerColor(String color) { // Cuando estoy editando solo tengo el String del color, por tanto llamo a esta función para que marque el radioButton del color de la nota
        switch (color.toLowerCase()) {
            case "amarillo":
                seleccionarColor(idBotonColorAmarillo);
                break;
            case "azul":
                seleccionarColor(idBotonColorAzul);
                break;
            case "morado":
                seleccionarColor(idBotonColorMorado);
                break;
            case "naranja":
                seleccionarColor(idBotonColorNaranja);
                break;
            case "rosa":
                seleccionarColor(idBotonColorRosa);
                break;
            case "verde":
                seleccionarColor(idBotonColorVerde);
                break;
        }
    }

    private void quitarFotoSeleccionada() { // Quita la foto de radioButton marcado a todos los radioButton

        idBotonColorAmarillo.setBackgroundResource(R.drawable.radioamarillo);
        idBotonColorAzul.setBackgroundResource(R.drawable.radioazul);
        idBotonColorMorado.setBackgroundResource(R.drawable.radiomorado);
        idBotonColorNaranja.setBackgroundResource(R.drawable.radionaranja);
        idBotonColorRosa.setBackgroundResource(R.drawable.radiorosa);
        idBotonColorVerde.setBackgroundResource(R.drawable.radioverde);
    }
}
