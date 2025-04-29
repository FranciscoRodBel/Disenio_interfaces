package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Lista_controlador;
import com.example.tareapp.controlador.Usuario_controlador;
import com.example.tareapp.modelo.idioma.Pagina_inicio_registro;
import com.example.tareapp.modelo.idioma.Pagina_listas;

public class ListaEditar extends DialogFragment {
    private OnListaEditadaListener listener;
    private Lista_controlador lista_controlador = new Lista_controlador();
    private Usuario_controlador usuario_controlador = new Usuario_controlador();
    private ImageButton idCerrarPanel;
    private EditText idInputTituloLista;
    private Button idBotonEditarLista;
    private TextView idTitulo, idMensajeResultado;
    private String idLista = "";
    private String titulo = "";
    private Pagina_listas idioma_listas = Idioma_controlador.getIdioma_seleccionado().getPagina_listas();
    public static ListaEditar newInstance(String idLista, String titulo) {
        ListaEditar dialog = new ListaEditar();
        Bundle args = new Bundle();
        args.putString("idLista", idLista);
        args.putString("titulo", titulo);
        dialog.setArguments(args);
        return dialog;
    }
    public interface OnListaEditadaListener {
        void onListaEditada();
    }

    public void setOnListaEditadaListener(OnListaEditadaListener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idLista = getArguments().getString("idLista");
            titulo = getArguments().getString("titulo");
        }
    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lista_editar, container, false);

        idTitulo = view.findViewById(R.id.idTitulo);
        idInputTituloLista = view.findViewById(R.id.idInputTituloLista);
        idBotonEditarLista = view.findViewById(R.id.idBotonEditarNota);
        idMensajeResultado = view.findViewById(R.id.idMensajeResultado);
        idCerrarPanel = view.findViewById(R.id.idCerrarPanel);

        idTitulo.setText(idioma_listas.getEditar_lista());
        idInputTituloLista.setHint(idioma_listas.getTitulo_lista());
        idBotonEditarLista.setText(idioma_listas.getEditar_lista());

        idInputTituloLista.setText(titulo);

        idCerrarPanel.setOnClickListener(v -> dismiss());

        idBotonEditarLista.setOnClickListener(v -> {
            new Thread(() -> {

                String[] mensaje_resultado = new String[1];
                mensaje_resultado[0] = lista_controlador.actualizar_lista(Integer.parseInt(idLista), idInputTituloLista.getText().toString());

                requireActivity().runOnUiThread(() -> {

                    if (mensaje_resultado[0].isEmpty()) {

                        mensaje_resultado[0] = idioma_listas.getLista_editada();
                        listener.onListaEditada();
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

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
