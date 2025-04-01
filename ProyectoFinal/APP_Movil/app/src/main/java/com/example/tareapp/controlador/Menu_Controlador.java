package com.example.tareapp.controlador;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

//import com.example.tareapp.vista.TareasActivity;
//import com.example.tareapp.vista.AjustesActivity;
import com.example.tareapp.vista.MainActivity;
public class Menu_Controlador {

    private Context context;

    public Menu_Controlador(Context context) {
        this.context = context;
    }

    public void abrirTareas() {
        //context.startActivity(new Intent(context, TareasActivity.class));
    }

    public void abrirAjustes() {
        //context.startActivity(new Intent(context, AjustesActivity.class));
    }

    public void cerrarSesion() {
        Toast.makeText(context, "Sesión cerrada", Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context, MainActivity.class));
    }
}
