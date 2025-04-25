package com.example.tareapp.controlador;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tareapp.R;
import com.example.tareapp.vista.AjustesView;
import com.example.tareapp.vista.IniciarRegistrarView;
import com.example.tareapp.vista.ListasView;
import com.example.tareapp.vista.MainActivity;
import com.example.tareapp.vista.TareasView;

public class CambiarVista {

    public static void cambiarFragmento(FragmentManager fragmentManager, Fragment fragment) {

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.idContenedorFragmentos, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

        if (fragmentManager.getFragments() != null && fragmentManager.getFragments().size() > 0) {

            Fragment actual = fragmentManager.getFragments().get(fragmentManager.getFragments().size() - 1);

            if (actual.getActivity() instanceof MainActivity) {

                ((MainActivity) actual.getActivity()).bloquearIdiomaMenu(!esFragmentoPermitido(fragment));
            }
        }
    }

    private static boolean esFragmentoPermitido(Fragment fragment) {
        return fragment instanceof TareasView
                || fragment instanceof ListasView
                || fragment instanceof AjustesView
                || fragment instanceof IniciarRegistrarView;
    }

}

