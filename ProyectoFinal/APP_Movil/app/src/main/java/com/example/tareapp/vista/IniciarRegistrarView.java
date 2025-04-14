package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Usuario_controlador;
import com.example.tareapp.modelo.Usuario;

import java.util.Timer;

public class IniciarRegistrarView extends Fragment {

    Usuario_controlador usuario_controlador = new Usuario_controlador();
    private TextView idBotonIniciarSesion, idBotonRegistrar, titulo, idMensajeResultadoInicio;
    private LinearLayout layoutLogin, layoutRegistro;
    private Button idBotonEnviarInicio, idBotonEnviarRegistro;
    private EditText idInputEmailInicio, idInputContraseniaInicio, idInputEmailRegistro, idInputContraseniaRegistro, idInputRepetirContraseniaInicio;

    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.iniciar_registrar_view, container, false);

        idBotonIniciarSesion = view.findViewById(R.id.idBotonIniciarSesion);
        idBotonRegistrar = view.findViewById(R.id.idBotonRegistrar);
        layoutLogin = view.findViewById(R.id.layoutLogin);
        layoutRegistro = view.findViewById(R.id.layoutRegistro);
        titulo = view.findViewById(R.id.idTitulo);
        idMensajeResultadoInicio = view.findViewById(R.id.idMensajeResultadoInicio);
        idBotonEnviarInicio = view.findViewById(R.id.idBotonEnviarInicio);
        idBotonEnviarRegistro = view.findViewById(R.id.idBotonEnviarRegistro);
        idInputEmailInicio = view.findViewById(R.id.idInputEmailInicio);
        idInputContraseniaInicio = view.findViewById(R.id.idInputContraseniaInicio);
        idInputEmailRegistro = view.findViewById(R.id.idInputEmailRegistro);
        idInputContraseniaRegistro = view.findViewById(R.id.idInputContraseniaRegistro);
        idInputRepetirContraseniaInicio = view.findViewById(R.id.idInputRepetirContraseniaInicio);

        // Cambio de layout de registro a inicio de sesión

        idBotonIniciarSesion.setOnClickListener(v -> {

            layoutLogin.setVisibility(View.VISIBLE);
            layoutRegistro.setVisibility(View.GONE);
            titulo.setText("Inicio de sesión");

            idBotonIniciarSesion.setBackgroundResource(R.drawable.boton_izquierdo_redondo);
            idBotonRegistrar.setBackgroundColor(Color.TRANSPARENT);
            idBotonIniciarSesion.setTextColor(ContextCompat.getColor(requireContext(), R.color.blanco));
            idBotonRegistrar.setTextColor(ContextCompat.getColor(requireContext(), R.color.negro));
        });

        idBotonRegistrar.setOnClickListener(v -> {

            layoutLogin.setVisibility(View.GONE);
            layoutRegistro.setVisibility(View.VISIBLE);
            titulo.setText("Registrarse");

            idBotonRegistrar.setBackgroundResource(R.drawable.boton_derecho_redondo);
            idBotonIniciarSesion.setBackgroundColor(Color.TRANSPARENT);
            idBotonRegistrar.setTextColor(ContextCompat.getColor(requireContext(), R.color.blanco));
            idBotonIniciarSesion.setTextColor(ContextCompat.getColor(requireContext(), R.color.negro));
        });

        // Envío de formularios de inicio de sesión
        idBotonEnviarInicio.setOnClickListener(v -> {
            new Thread(() -> {

                String email = idInputEmailInicio.getText().toString();
                String contrasenia = idInputContraseniaInicio.getText().toString();

                String mensaje_resultado = usuario_controlador.iniciar_usuario(email, contrasenia);

                requireActivity().runOnUiThread(() -> {

                    if (mensaje_resultado.isEmpty()) {
                        idInputEmailInicio.setText("");
                        idInputContraseniaInicio.setText("");

                        //Usuario usuario_iniciado = Usuario.recoger_usuario(email);
                        //Usuario_controlador.setUsuario(usuario_iniciado);

                        idMensajeResultadoInicio.setText("Inicio de sesión completado");

                    } else {
                        idInputContraseniaInicio.setText("");
                        idMensajeResultadoInicio.setText(mensaje_resultado);

                        new android.os.Handler().postDelayed(() -> {
                            requireActivity().runOnUiThread(() ->
                            idMensajeResultadoInicio.setText(""));
                        }, 3000);
                    }
                });

            }).start();
        });

        idBotonEnviarRegistro.setOnClickListener(v -> {

        });

        return view;
    }
}
