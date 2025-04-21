package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.CambiarVista;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Usuario_controlador;
import com.example.tareapp.modelo.idioma.Pagina_ajustes_cuenta;


public class AjustesView extends Fragment implements CambiarDato.OnCambiarDatoListener {
    private Button idBotonCambiarEamil, idBotonCambiarContrasenia, idBotonBorrarCuenta;
    private TextView idTituloAjustes, idEmailCuenta;
    private Pagina_ajustes_cuenta pagina_ajustes_cuenta = Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta();
    private String email;
    private Usuario_controlador usuario_controlador = new Usuario_controlador();


    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ajustes_view, container, false);

        email = Usuario_controlador.getUsuario().getEmail();

        idTituloAjustes = view.findViewById(R.id.idTituloAjustes);
        idEmailCuenta = view.findViewById(R.id.idEmailCuenta);
        idEmailCuenta = view.findViewById(R.id.idEmailCuenta);
        idBotonCambiarEamil = view.findViewById(R.id.idBotonCambiarEamil);
        idBotonCambiarContrasenia = view.findViewById(R.id.idBotonCambiarContrasenia);
        idBotonBorrarCuenta = view.findViewById(R.id.idBotonBorrarCuenta);

        idEmailCuenta.setText(email);
        idTituloAjustes.setText(pagina_ajustes_cuenta.getTitulo_pagina());
        idBotonCambiarEamil.setText(pagina_ajustes_cuenta.getCambiar_email());
        idBotonCambiarContrasenia.setText(pagina_ajustes_cuenta.getCambiar_contrasenia());
        idBotonBorrarCuenta.setText(pagina_ajustes_cuenta.getBorrar_cuenta());

        idBotonCambiarEamil.setOnClickListener(v -> {

            CambiarDato dialog = CambiarDato.newInstance("email");

            if (this instanceof CambiarDato.OnCambiarDatoListener) {

                dialog.setOnCambiarDatoListener((CambiarDato.OnCambiarDatoListener) this);
            }

            dialog.show(this.getParentFragmentManager(), "Cambiar_dato");

        });

        idBotonCambiarContrasenia.setOnClickListener(v -> {

            CambiarDato dialog = CambiarDato.newInstance("contrasenia");

            if (this instanceof CambiarDato.OnCambiarDatoListener) {

                dialog.setOnCambiarDatoListener((CambiarDato.OnCambiarDatoListener) this);
            }

            dialog.show(this.getParentFragmentManager(), "Cambiar_dato");

        });

        idBotonBorrarCuenta.setOnClickListener(v -> {

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
            alertDialogBuilder.setTitle(pagina_ajustes_cuenta.getPregunta_borrar_cuenta());
            alertDialogBuilder
                    .setMessage(email)
                    .setCancelable(false)
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            new Thread(() -> {

                                final String[] mensaje_resultado = new String[1];
                                mensaje_resultado[0] = usuario_controlador.borrar_usuario();

                                requireActivity().runOnUiThread(() -> {

                                    if (mensaje_resultado[0].isEmpty()) {

                                        mensaje_resultado[0] = pagina_ajustes_cuenta.getCuenta_borrada();

                                        CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), new IniciarRegistrarView());

                                    }

                                    Toast.makeText(getContext(), mensaje_resultado[0], Toast.LENGTH_SHORT).show();
                                });
                            }).start();
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel(); // Cerrar popUp
                        }
                    }).create().show();
        });

        return view;
    }

    @Override
    public void onCambiarDato() {
        // Actualizar email
    }
}
