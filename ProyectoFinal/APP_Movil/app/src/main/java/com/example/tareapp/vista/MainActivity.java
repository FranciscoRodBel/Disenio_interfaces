package com.example.tareapp.vista;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tareapp.R;

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
            changeFragment(new IniciarRegistrarView());
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
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.idTareasMenu:
                fragment = new Tareas_view();
                break;
            case R.id.idCuentaCerrarSesion:
                fragment = new IniciarRegistrarView();
                break;
        }

        if (fragment != null) {
            changeFragment(fragment);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void changeFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null); // Permite regresar al fragmento anterior
        transaction.commit();
    }
}
