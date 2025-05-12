package com.example.tareapp.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Lista_controlador;
import com.example.tareapp.modelo.idioma.Pagina_listas;
import com.example.tareapp.modelo.idioma.Pagina_tareas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clase para la vista de listas
 * implemento de ListaEditar.OnListaEditadaListener para escuchar cuando se editó una lista y poder actualziar el panel
 *
 * @author Francisco
 */
public class ListasView extends Fragment implements ListaEditar.OnListaEditadaListener {
    private Lista_controlador lista_controlador = new Lista_controlador();
    private ImageButton idBotonCrearLista;
    private EditText idInputTituloLista;
    private TextView idMensajeResultado, idTitulo;
    private RecyclerView recyclerView;
    private ListaAdapter listaAdapter;
    private List<HashMap<String, Object>> listaDatos = new ArrayList<>();
    private Pagina_listas pagina_listas = Idioma_controlador.getIdioma_seleccionado().getPagina_listas();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listas_view, container, false);

        idTitulo = view.findViewById(R.id.idTitulo);
        idBotonCrearLista = view.findViewById(R.id.idBotonCrearLista);
        idInputTituloLista = view.findViewById(R.id.idInputTituloLista);
        idMensajeResultado = view.findViewById(R.id.idMensajeResultado);

        // Se creará el RecyclerView con el listaAdapter, para visualizar las listas
        recyclerView = view.findViewById(R.id.idRecyclerViewListas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        listaAdapter = new ListaAdapter(listaDatos, this); // Estará vacío
        recyclerView.setAdapter(listaAdapter);

        // Añado el idioma de los textos
        idTitulo.setText(pagina_listas.getTitulo());
        idInputTituloLista.setHint(pagina_listas.getTitulo_lista());

        actualizar_panel_lista(); // Actualizo el panel de las listas

        idBotonCrearLista.setOnClickListener(v -> { // Si pulsa en crear lista...
            new Thread(() -> {

                final String[] mensaje_resultado = new String[1];
                mensaje_resultado[0] = lista_controlador.crear_lista(idInputTituloLista.getText().toString()); // Intento crear la lista

                requireActivity().runOnUiThread(() -> {

                    if (mensaje_resultado[0].isEmpty()) { // Si el resultado es vacío es que se pudo crear la lista

                        mensaje_resultado[0] = Idioma_controlador.getIdioma_seleccionado().getPagina_listas().getLista_creada(); // Recojo el mensaje de lista creada
                        idInputTituloLista.setText("");
                        actualizar_panel_lista(); // Actualizo el panel de listas
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

        return view;
    }

    @Override
    public void onListaEditada() {
        actualizar_panel_lista();
    } // Si edita la lista se actualiza el panel de las listas

    void actualizar_panel_lista() {
        new Thread(() -> {

            List<HashMap<String, Object>> listas = lista_controlador.recoger_listas(); // Recojo todas las listas del usuario

            requireActivity().runOnUiThread(() -> {

                listaDatos.clear(); // Vacío el Array de listas

                if (listas != null && !listas.isEmpty()) { // Si se han recogido listas de la BBDD

                    listaDatos.addAll(listas); // Se añaden al array
                }

                listaAdapter.notifyDataSetChanged(); // Notifico para que muestre todas las listas recogidas
            });
        }).start();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).bloquearIdiomaMenu(false); // Desbloquea el idioma
        }
    }
}
