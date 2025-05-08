package com.example.tareapp.controlador;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tareapp.R;
import com.example.tareapp.vista.AjustesView;
import com.example.tareapp.vista.IniciarRegistrarView;
import com.example.tareapp.vista.ListasView;
import com.example.tareapp.vista.MainActivity;
import com.example.tareapp.vista.NotasView;
import com.example.tareapp.vista.TareasView;

/**
 * Controlador para cambiar el fragmento que está en pantalla.
 * Permitiendo cambiar entre la vista de tareas, listas, notas, ajustes y PopUps
 * 
 * @author Francisco
 */
public class CambiarVista {

    /**
    * Función para cambiar las vistas
    * 
    */
    public static void cambiarFragmento(FragmentManager fragmentManager, Fragment fragment) {

        FragmentTransaction transaction = fragmentManager.beginTransaction(); // Inicio un cambio de fragmento
        transaction.replace(R.id.idContenedorFragmentos, fragment); // Reemplazo el contenedor antiguo por el nuevo
        transaction.addToBackStack(null); // Permite volver al fragmento anterior con el botón de atrás
        transaction.commit(); // Aplica la transacción

        if (fragmentManager.getFragments() != null && fragmentManager.getFragments().size() > 0) { // Si hay un fragmento activo...

            Fragment actual = fragmentManager.getFragments().get(fragmentManager.getFragments().size() - 1); // Recojo el fragmento activo

            if (actual.getActivity() instanceof MainActivity) { // Compruebo que el fragmento esté puesto en el Main

                ((MainActivity) actual.getActivity()).bloquearIdiomaMenu(!esFragmentoPermitido(fragment)); // Bloqueo el idioma si el fragmento no es un fragmento principal
            }
        }
    }

    /**
    * Función para saber si el fragmento puede tener activo el idioma
    * 
    * @return Devuelve true si el fragmento debe tener activado el idioma
    */
    private static boolean esFragmentoPermitido(Fragment fragment) {
        return fragment instanceof TareasView
                || fragment instanceof ListasView
                || fragment instanceof AjustesView
                || fragment instanceof NotasView
                || fragment instanceof IniciarRegistrarView;
    }

}

