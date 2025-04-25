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
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Nota_controlador;
import com.example.tareapp.modelo.idioma.Pagina_notas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class NotasView extends Fragment {
    private Nota_controlador nota_controlador = new Nota_controlador();
    private TextView idTitulo;
    private Button idBotonCrearNota;
    private RecyclerView recyclerView;
    private NotaAdapter notaAdapter;
    private List<HashMap<String, Object>> listaDatos = new ArrayList<>();
    private Pagina_notas pagina_notas = Idioma_controlador.getIdioma_seleccionado().getPagina_notas();


    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.notas_view, container, false);

        idTitulo = view.findViewById(R.id.idTitulo);
        idBotonCrearNota = view.findViewById(R.id.idBotonCrearNota);

        recyclerView = view.findViewById(R.id.idRecyclerViewNotas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        notaAdapter = new NotaAdapter(listaDatos, this);
        recyclerView.setAdapter(notaAdapter);

        idTitulo.setText(pagina_notas.getTitulo());
        idBotonCrearNota.setText(pagina_notas.getCrear_nota());

        actualizar_panel_notas();

        idBotonCrearNota.setOnClickListener(v -> {

        });

        return view;
    }


    @SuppressLint("NotifyDataSetChanged")
    void actualizar_panel_notas() {
        new Thread(() -> {

            List<HashMap<String, Object>> notas = Nota_controlador.recoger_Notas();

            requireActivity().runOnUiThread(() -> {

                listaDatos.clear();

                if (notas != null && !notas.isEmpty()) {

                    listaDatos.addAll(notas);

                }
                notaAdapter.notifyDataSetChanged();
            });
        }).start();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).bloquearIdiomaMenu(false);
        }
    }
}
