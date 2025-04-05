package com.example.tareapp.vista;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tareapp.R;

public class LoginActivity extends AppCompatActivity {

    private TextView btnIniciarSesion, btnRegistrar, titulo;
    private LinearLayout layoutLogin, layoutRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_registrar_view);

        btnIniciarSesion = findViewById(R.id.idBotonIniciarSesion);
        btnRegistrar = findViewById(R.id.idBotonRegistrar);
        layoutLogin = findViewById(R.id.layoutLogin);
        layoutRegistro = findViewById(R.id.layoutRegistro);
        titulo = findViewById(R.id.idTitulo);

        btnIniciarSesion.setOnClickListener(v -> {
            layoutLogin.setVisibility(View.VISIBLE);
            layoutRegistro.setVisibility(View.GONE);
            titulo.setText("Inicio de sesión");

            btnIniciarSesion.setBackgroundResource(R.drawable.boton_izquierdo_redondo);
            btnRegistrar.setBackgroundColor(Color.TRANSPARENT);
        });

        btnRegistrar.setOnClickListener(v -> {
            layoutLogin.setVisibility(View.GONE);
            layoutRegistro.setVisibility(View.VISIBLE);
            titulo.setText("Registrarse");

            btnRegistrar.setBackgroundResource(R.drawable.boton_derecho_redondo);
            btnIniciarSesion.setBackgroundColor(Color.TRANSPARENT);
        });
    }
}
