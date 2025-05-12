package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.content.Context;
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
import com.example.tareapp.controlador.Usuario_controlador;
import com.example.tareapp.modelo.idioma.Cabecera;
import androidx.appcompat.app.AppCompatDelegate;

import java.io.IOException;

/**
 * Clase para la vista principal
 * En este panel se añade la cabecera y se irán añadiendo todos los fragmentos de las demás vistas
 *
 * @author Francisco
 */
public class MainActivity extends AppCompatActivity {

    private Toolbar idMenuCabecera;
    private boolean opcionesBloqueadas = false;
    private boolean bloquearIdioma = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO); // Bloqueo el modo oscuro, para que solo funcione el modo claro
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        idMenuCabecera = findViewById(R.id.idMenuCabecera); // Recojo la cabecera
        setSupportActionBar(idMenuCabecera); // La añado a la vista
        getSupportActionBar().setDisplayShowTitleEnabled(false); // Deshabilito el título por defecto del menú

        try {

            Idioma_controlador.convertirJsonEnClase(this); // Recojo el json del idioma

        } catch (IOException e) {

            e.printStackTrace();
        }

        new Thread(() -> {

            boolean sesionIniciada = Usuario_controlador.iniciarSesionAutomatica(this); // Intento iniciar sesión automáticamente

            runOnUiThread(() -> {

                if (savedInstanceState == null) {

                    if (sesionIniciada) { // Si se inicia correctamente muestro la vista de tareas

                        CambiarVista.cambiarFragmento(getSupportFragmentManager(), new TareasView());
                        bloquearOpcionesMenu(false);

                    } else { // Si no se inicia correctamente muestro la vista de inicio y registro

                        CambiarVista.cambiarFragmento(getSupportFragmentManager(), new IniciarRegistrarView());
                        bloquearOpcionesMenu(true);
                    }
                }
            });
        }).start();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) { // Crea el menú
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {

        if (menu != null) {

            Cabecera cabecera = Idioma_controlador.getIdioma_seleccionado().getCabecera(); // Recojo el idioma del menú

            // Añado todos los textos del menú con su idioma
            menu.findItem(R.id.idTareasMenu).setTitle(cabecera.getTareas());
            menu.findItem(R.id.idListasMenu).setTitle(cabecera.getListas());
            menu.findItem(R.id.idIdioma).setTitle(cabecera.getIdioma());
            menu.findItem(R.id.idNotasMenu).setTitle(cabecera.getNotas());
            menu.findItem(R.id.idCuenta).setTitle(cabecera.getCuenta());
            menu.findItem(R.id.idCuentaAjustes).setTitle(cabecera.getAjustes());
            menu.findItem(R.id.idCuentaCerrarSesion).setTitle(cabecera.getCerrar_sesion());
            menu.findItem(R.id.idCuentaSalir).setTitle(cabecera.getSalir());

            // Bloquea las opciones cuando es un fragmento que no sea uno de los pricipales
            menu.findItem(R.id.idTareasMenu).setEnabled(!opcionesBloqueadas);
            menu.findItem(R.id.idListasMenu).setEnabled(!opcionesBloqueadas);
            menu.findItem(R.id.idNotasMenu).setEnabled(!opcionesBloqueadas);
            menu.findItem(R.id.idCuentaAjustes).setEnabled(!opcionesBloqueadas);
            menu.findItem(R.id.idCuentaCerrarSesion).setEnabled(!opcionesBloqueadas);

            menu.findItem(R.id.idIdioma).setEnabled(!bloquearIdioma);
        }

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { // Se ejecuta cuando se pulsa en un item del menú

        switch (item.getItemId()) {

            case R.id.idTareasMenu:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new TareasView());
                break;

            case R.id.idListasMenu:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new ListasView());
                break;

            case R.id.idIdiomaEsp:
                Idioma_controlador.cambiarIdioma("Español", true);
                invalidateOptionsMenu(); // Actualiza el menú para que se le cambie el idioma
                recargarFragmentoActual(); // Actualiza el fragmento que se está viendo para que se le cambie el idioma
                break;

            case R.id.idIdiomaEng:
                Idioma_controlador.cambiarIdioma("English", true);
                invalidateOptionsMenu(); // Actualiza el menú para que se le cambie el idioma
                recargarFragmentoActual(); // Actualiza el fragmento que se está viendo para que se le cambie el idioma
                break;

            case R.id.idIdiomaFr:
                Idioma_controlador.cambiarIdioma("Français", true);
                invalidateOptionsMenu(); // Actualiza el menú para que se le cambie el idioma
                recargarFragmentoActual(); // Actualiza el fragmento que se está viendo para que se le cambie el idioma
                break;

            case R.id.idNotasMenu:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new NotasView());
                break;

            case R.id.idCuentaAjustes:
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new AjustesView());
                break;

            case R.id.idCuentaCerrarSesion:
                Usuario_controlador.cerrarSesion(this); // Cierro la sesión
                CambiarVista.cambiarFragmento(getSupportFragmentManager(), new IniciarRegistrarView());
                bloquearOpcionesMenu(true); // Desactivo las opciones del menú
                break;

            case R.id.idCuentaSalir: // Cierro la app
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void recargarFragmentoActual() { // Lo uso para cambio el idioma, que se actualice toda la vista al idioma nuevo

        Fragment fragmentActual = getSupportFragmentManager().findFragmentById(R.id.idContenedorFragmentos); // Recojo el fragmento activo

        if (fragmentActual != null) {

            Fragment nuevoFragment; // Si coincide, creo uno nuevo

            if (fragmentActual instanceof IniciarRegistrarView) {

                nuevoFragment = new IniciarRegistrarView();

            } else if (fragmentActual instanceof TareasView) {

                nuevoFragment = new TareasView();

            } else if (fragmentActual instanceof ListasView) {

                nuevoFragment = new ListasView();

            } else if (fragmentActual instanceof NotasView) {

                nuevoFragment = new NotasView();

            } else if (fragmentActual instanceof AjustesView) {

                nuevoFragment = new AjustesView();

            } else {

                return;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.idContenedorFragmentos, nuevoFragment).commit(); // Cambio del antiguo al nuevo
        }
    }

    public void bloquearOpcionesMenu(boolean bloquear) { // Se usa para bloquear las opciones en el inicio y registro
        opcionesBloqueadas = bloquear;
        invalidateOptionsMenu();
    }

    public void bloquearIdiomaMenu(boolean bloquear) { // Para bloquear el idioma en fragmentos que no sean principales
        bloquearIdioma = bloquear;
        invalidateOptionsMenu();
    }
}
