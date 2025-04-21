package com.example.tareapp.vista;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.tareapp.R;
import com.example.tareapp.controlador.CambiarVista;
import com.example.tareapp.controlador.Idioma_controlador;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Toolbar myToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        myToolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Cargar el primer fragmento por defecto
        if (savedInstanceState == null) {

            CambiarVista.cambiarFragmento(getSupportFragmentManager(), new IniciarRegistrarView());
        }

        try {

            Idioma_controlador.convertirJsonEnClase(this);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.idListasMenu:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new ListasView());
                break;

            case R.id.idTareasMenu:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new TareasView());
                break;

            case R.id.idCuentaAjustes:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new AjustesView());
                break;

            case R.id.idCuentaCerrarSesion:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new IniciarRegistrarView());
                break;

            case R.id.idCuentaSalir:
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
