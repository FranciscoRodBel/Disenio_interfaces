package com.example.tareapp.vista;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Menu_Controlador;
//import com.example.tareapp.vista.TareasActivity;
//import com.example.tareapp.views.AjustesActivity;

public class MenuFragment extends Fragment {

    private Menu_Controlador menu_Controlador;

    public MenuFragment() {
        // Constructor vacío requerido
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        // Inicializar controlador
        menu_Controlador = new Menu_Controlador(getActivity());

        // Configurar botones
        Button btnTareas = view.findViewById(R.id.btnTareas);
        Button btnListas = view.findViewById(R.id.btnListas);
        Button btnNotas = view.findViewById(R.id.btnNotas);
        Button btnAjustes = view.findViewById(R.id.btnAjustes);
        Button btnCerrarSesion = view.findViewById(R.id.btnCerrarSesion);

        //btnTareas.setOnClickListener(v -> menuController.abrirTareas());
        //btnAjustes.setOnClickListener(v -> menuController.abrirAjustes());
        //btnCerrarSesion.setOnClickListener(v -> menuController.cerrarSesion());

        return view;
    }
}
