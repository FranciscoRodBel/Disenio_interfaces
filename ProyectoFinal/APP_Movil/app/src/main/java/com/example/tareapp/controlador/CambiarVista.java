package com.example.tareapp.controlador;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tareapp.R;

public class CambiarVista {

    public static void cambiarFragmento(FragmentManager fragmentManager, Fragment fragment) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.idContenedorFragmentos, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}

