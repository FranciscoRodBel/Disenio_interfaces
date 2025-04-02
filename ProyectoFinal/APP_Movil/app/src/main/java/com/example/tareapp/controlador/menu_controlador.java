package com.example.tareapp.controlador;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tareapp.R;

public class menu_controlador {

    public static void inflateMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    public static boolean handleMenuClick(Context context, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.idTareasMenu:
                Toast.makeText(context, "Tareas seleccionadas", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.idListasMenu:
                Toast.makeText(context, "Listas seleccionadas", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.idIdiomaEsp:
                Toast.makeText(context, "Idioma cambiado a Español", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.idIdiomaEng:
                Toast.makeText(context, "Language changed to English", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.idIdiomaFr:
                Toast.makeText(context, "Langue changée en Français", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.idNotasMenu:
                Toast.makeText(context, "Notas abiertas", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.idCuentaAjustes:
                Toast.makeText(context, "Abriendo Ajustes", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.idCuentaCerrarSesion:
                Toast.makeText(context, "Cerrando sesión...", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.idCuentaSalir:
                Toast.makeText(context, "Saliendo de la app", Toast.LENGTH_SHORT).show();
                return true;

            default:
                return false;
        }
    }
}
