package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.CambiarVista;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.modelo.idioma.Cabecera;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Toolbar idMenuCabecera;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        idMenuCabecera = findViewById(R.id.idMenuCabecera);
        setSupportActionBar(idMenuCabecera);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Cargar el primer fragmento por defecto
        if (savedInstanceState == null) {

            CambiarVista.cambiarFragmento(getSupportFragmentManager(), new IniciarRegistrarView());
            //ocultarOpcionesMenu(false);
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
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (menu != null) {

            Cabecera cabecera = Idioma_controlador.getIdioma_seleccionado().getCabecera();

            menu.findItem(R.id.idTareasMenu).setTitle(cabecera.getTareas());
            menu.findItem(R.id.idListasMenu).setTitle(cabecera.getListas());
            menu.findItem(R.id.idIdioma).setTitle(cabecera.getIdioma());
            menu.findItem(R.id.idNotasMenu).setTitle(cabecera.getNotas());
            menu.findItem(R.id.idCuenta).setTitle(cabecera.getCuenta());
            menu.findItem(R.id.idCuentaAjustes).setTitle(cabecera.getAjustes());
            menu.findItem(R.id.idCuentaCerrarSesion).setTitle(cabecera.getCerrar_sesion());
            menu.findItem(R.id.idCuentaSalir).setTitle(cabecera.getSalir());
        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.idTareasMenu:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new TareasView());
                break;

            case R.id.idListasMenu:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new ListasView());
                break;

            case R.id.idIdiomaEsp:
                Idioma_controlador.cambiarIdioma("Español");
                invalidateOptionsMenu();
                recargarFragmentoActual();
                break;

            case R.id.idIdiomaEng:
                Idioma_controlador.cambiarIdioma("English");
                invalidateOptionsMenu();
                recargarFragmentoActual();
                break;

            case R.id.idIdiomaFr:
                Idioma_controlador.cambiarIdioma("Français");
                invalidateOptionsMenu();
                recargarFragmentoActual();
                break;

            case R.id.idCuentaAjustes:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new AjustesView());
                break;

            case R.id.idCuentaCerrarSesion:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new IniciarRegistrarView());
                //ocultarOpcionesMenu(false);
                break;

            case R.id.idCuentaSalir:
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void recargarFragmentoActual() {

        Fragment fragmentActual = getSupportFragmentManager().findFragmentById(R.id.idContenedorFragmentos);

        if (fragmentActual != null) {

            Fragment nuevoFragment;

            if (fragmentActual instanceof IniciarRegistrarView) {

                nuevoFragment = new IniciarRegistrarView();

            } else if (fragmentActual instanceof TareasView) {

                nuevoFragment = new TareasView();

            } else if (fragmentActual instanceof ListasView) {

                nuevoFragment = new ListasView();

            } else if (fragmentActual instanceof AjustesView) {

                nuevoFragment = new AjustesView();

            } else {

                return;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.idContenedorFragmentos, nuevoFragment).commit();
        }
    }

    public void ocultarOpcionesMenu(boolean bloquear) {

        Menu menu = idMenuCabecera.getMenu();

        menu.findItem(R.id.idTareasMenu).setVisible(!bloquear);
        menu.findItem(R.id.idListasMenu).setVisible(!bloquear);
        menu.findItem(R.id.idCuentaAjustes).setVisible(!bloquear);
    }
}
