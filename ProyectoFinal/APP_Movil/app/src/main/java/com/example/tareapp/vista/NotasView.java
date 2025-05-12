package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tareapp.R;
import com.example.tareapp.controlador.CambiarVista;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Nota_controlador;
import com.example.tareapp.modelo.Nota;
import com.example.tareapp.modelo.idioma.Pagina_notas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Clase para la vista de notas
 *
 * @author Francisco
 */
public class NotasView extends Fragment {
    private TextView idTitulo;
    private Button idBotonCrearNota;
    private RecyclerView recyclerView;
    private NotaAdapter notaAdapter;
    private List<Nota> listaNotas = new ArrayList<>();
    private Pagina_notas pagina_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas();

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notas_view, container, false);

        idTitulo = view.findViewById(R.id.idTitulo);
        idBotonCrearNota = view.findViewById(R.id.idBotonCrearNota);

        // Se creará el RecyclerView con el notaAdapter, para visualizar las notas
        recyclerView = view.findViewById(R.id.idRecyclerViewNotas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        notaAdapter = new NotaAdapter(listaNotas); // Estará vacío
        recyclerView.setAdapter(notaAdapter);

        // Añado el idioma de los textos
        idTitulo.setText(pagina_notas.getTitulo());
        idBotonCrearNota.setText(pagina_notas.getCrear_nota());

        actualizar_panel_notas(); // Actualizo el panel de las notas

        idBotonCrearNota.setOnClickListener(v -> { // Si pulsa en crear nota...

            NotaCrearEditarView crearEditarFragment = new NotaCrearEditarView(); // Creo la vista y envío la acción(crear)

            Bundle bundle = new Bundle();
            bundle.putString("accion", "crear");
            crearEditarFragment.setArguments(bundle);

            CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), crearEditarFragment); // Cambio la vista
        });

        notaAdapter.setOnItemClickListener(nota -> { // Si pulsa en la nota

            NotaVer notaVer = new NotaVer(); // Creo la vista de ver nota

            Bundle bundle = new Bundle();
            bundle.putSerializable("nota", nota); // Envío la nota que se tiene que mostrar
            notaVer.setArguments(bundle);

            notaVer.setNotaListener(() -> actualizar_panel_notas()); // Si se borra la nota se activa el listener que actualiza el panel de notas

            notaVer.show(this.getParentFragmentManager(), "ver_nota"); // Muestro el PopUp
        });

        return view;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void actualizar_panel_notas() {
        new Thread(() -> {

            List<HashMap<String, Object>> notas = Nota_controlador.recoger_Notas(); // Recojo todas las notas

            requireActivity().runOnUiThread(() -> {

                listaNotas.clear(); // Vacío el array de notas

                if (notas != null && !notas.isEmpty()) { // Si se han recogido notas de la BBDD...

                    for (HashMap<String, Object> fila : notas) { // recorro las notas

                        int idNota = (int) fila.get("idNota");
                        String descripcion = (String) fila.get("descripcion");
                        String color = (String) fila.get("color");

                        listaNotas.add(new Nota(idNota, descripcion, color)); // las añado al recycle view
                    }
                }

                notaAdapter.notifyDataSetChanged(); // aviso de los cambios
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
