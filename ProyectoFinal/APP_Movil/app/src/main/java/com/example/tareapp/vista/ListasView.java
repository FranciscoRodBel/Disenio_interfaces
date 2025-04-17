package com.example.tareapp.vista;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.CambiarVista;


public class TareasView extends Fragment {

    private ImageButton idBotonCrearTarea;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tareas_view, container, false);

        idBotonCrearTarea = view.findViewById(R.id.idBotonCrearTarea);

        idBotonCrearTarea.setOnClickListener(v -> {

            CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), new TareaCrearEditarView());
        });

        return view;
    }
}
