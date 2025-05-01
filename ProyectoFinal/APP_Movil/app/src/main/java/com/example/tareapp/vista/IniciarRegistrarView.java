package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.CambiarVista;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Usuario_controlador;
import com.example.tareapp.modelo.idioma.Pagina_ajustes_cuenta;
import com.example.tareapp.modelo.idioma.Pagina_inicio_registro;
import com.google.android.material.navigation.NavigationView;

public class IniciarRegistrarView extends Fragment {

    Usuario_controlador usuario_controlador = new Usuario_controlador();
    private TextView idBotonIniciarSesion, idBotonRegistrar, idTitulo, idMensajeResultadoInicio;
    private LinearLayout layoutLogin, layoutRegistro;
    private Button idBotonEnviarInicio, idBotonEnviarRegistro;
    private EditText idInputEmailInicio, idInputContraseniaInicio, idInputEmailRegistro, idInputContraseniaRegistro, idInputRepetirContraseniaRegistro;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.iniciar_registrar_view, container, false);

        Pagina_inicio_registro pagina_inicio_registro = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();

        idBotonIniciarSesion = view.findViewById(R.id.idBotonIniciarSesion);
        idBotonRegistrar = view.findViewById(R.id.idBotonRegistrar);
        layoutLogin = view.findViewById(R.id.layoutLogin);
        layoutRegistro = view.findViewById(R.id.layoutRegistro);
        idTitulo = view.findViewById(R.id.idTitulo);
        idMensajeResultadoInicio = view.findViewById(R.id.idMensajeResultadoInicio);
        idBotonEnviarInicio = view.findViewById(R.id.idBotonEnviarInicio);
        idBotonEnviarRegistro = view.findViewById(R.id.idBotonEnviarRegistro);
        idInputEmailInicio = view.findViewById(R.id.idInputEmailInicio);
        idInputContraseniaInicio = view.findViewById(R.id.idInputContraseniaInicio);
        idInputEmailRegistro = view.findViewById(R.id.idInputEmailRegistro);
        idInputContraseniaRegistro = view.findViewById(R.id.idInputContraseniaRegistro);
        idInputRepetirContraseniaRegistro = view.findViewById(R.id.idInputRepetirContraseniaRegistro);

        idTitulo.setText(pagina_inicio_registro.getIniciar_sesion());
        idBotonIniciarSesion.setText(pagina_inicio_registro.getIniciar_sesion());
        idBotonRegistrar.setText(pagina_inicio_registro.getRegistrarse());
        idBotonEnviarInicio.setText(pagina_inicio_registro.getIniciar_sesion());
        idBotonEnviarRegistro.setText(pagina_inicio_registro.getRegistrarse());
        idInputContraseniaInicio.setHint(pagina_inicio_registro.getContrasenia());
        idInputContraseniaRegistro.setHint(pagina_inicio_registro.getContrasenia());
        idInputRepetirContraseniaRegistro.setHint(pagina_inicio_registro.getRepetir_contrasenia());

        // Cambio de layout de registro a inicio de sesión

        idInputEmailInicio.setText("9442@cifpceuta.es");
        idInputContraseniaInicio.setText("12345678Aa");

        idInputEmailRegistro.setText("pacopollo24@gmail.com");
        idInputContraseniaRegistro.setText("12345678Aa");
        idInputRepetirContraseniaRegistro.setText("12345678Aa");

        idBotonIniciarSesion.setOnClickListener(v -> {

            layoutLogin.setVisibility(View.VISIBLE);
            layoutRegistro.setVisibility(View.GONE);
            idTitulo.setText(pagina_inicio_registro.getIniciar_sesion());

            idBotonIniciarSesion.setBackgroundResource(R.drawable.boton_izquierdo_redondo);
            idBotonRegistrar.setBackgroundColor(Color.TRANSPARENT);
            idBotonIniciarSesion.setTextColor(ContextCompat.getColor(requireContext(), R.color.blanco));
            idBotonRegistrar.setTextColor(ContextCompat.getColor(requireContext(), R.color.negro));
        });

        idBotonRegistrar.setOnClickListener(v -> {

            layoutLogin.setVisibility(View.GONE);
            layoutRegistro.setVisibility(View.VISIBLE);
            idTitulo.setText(pagina_inicio_registro.getRegistrarse());

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

                        Idioma_controlador.cambiarIdioma(Usuario_controlador.getUsuario().getIdioma_seleccionado(), false);

                        ((MainActivity) getActivity()).bloquearOpcionesMenu(false);
                        CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), new TareasView());

                    } else {
                        idInputContraseniaInicio.setText("");
                        idMensajeResultadoInicio.setText(mensaje_resultado);

                        new android.os.Handler().postDelayed(() -> {
                            if (isAdded()) {
                                requireActivity().runOnUiThread(() ->
                                        idMensajeResultadoInicio.setText(""));
                            }
                        }, 3000);
                    }
                });
            }).start();
        });

        idBotonEnviarRegistro.setOnClickListener(v -> {
            new Thread(() -> {

                String email = idInputEmailRegistro.getText().toString();
                String contrasenia = idInputContraseniaRegistro.getText().toString();
                String repetir_contrasenia = idInputRepetirContraseniaRegistro.getText().toString();

                String mensaje_resultado = usuario_controlador.comprobar_datos_registro(email, contrasenia, repetir_contrasenia);

                requireActivity().runOnUiThread(() -> {
                    if (mensaje_resultado.isEmpty()) {

                        ConfirmarEmailDialog dialog = ConfirmarEmailDialog.newInstance(email, contrasenia, repetir_contrasenia);
                        dialog.show(getParentFragmentManager(), "ConfirmarEmail");

                    } else {

                        idInputContraseniaInicio.setText("");
                        idMensajeResultadoInicio.setText(mensaje_resultado);

                        new android.os.Handler().postDelayed(() -> {
                            if (isAdded()) {
                                requireActivity().runOnUiThread(() ->
                                        idMensajeResultadoInicio.setText(""));
                            }
                        }, 3000);
                    }
                });
            }).start();
        });

        requireActivity().getOnBackPressedDispatcher().addCallback(
                getViewLifecycleOwner(),
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {}
                }
        );

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).bloquearIdiomaMenu(false);
        }
    }
}
