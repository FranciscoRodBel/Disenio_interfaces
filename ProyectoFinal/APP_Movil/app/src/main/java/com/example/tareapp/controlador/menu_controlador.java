package com.example.tareapp.controlador;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tareapp.R;

public class menu_controlador {

    private Context context;

    public menu_controlador(Context context) {
        this.context = context;
    }

    public void inflateMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
    }

    public boolean handleMenuClick(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item1) {
            Toast.makeText(context, "Perfil", Toast.LENGTH_SHORT).show();
            return true;
        }
        return false;
    }
}
