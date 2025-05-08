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

/**
 * Clase para la vista de ajustes
 * Implemento cambiar dato para escuchar cuando se haya cambiado el email y así actualizar el email de la vista
 *
 * @author Francisco
 */
public class AjustesView extends Fragment implements CambiarDato.OnCambiarDatoListener {

    private Button idBotonCambiarEmail, idBotonCambiarContrasenia, idBotonBorrarCuenta;
    private TextView idTituloAjustes, idEmailCuenta;
    private Pagina_ajustes_cuenta pagina_ajustes_cuenta = Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta();
    private String email;
    private Usuario_controlador usuario_controlador = new Usuario_controlador();

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ajustes_view, container, false);

        email = Usuario_controlador.getUsuario().getEmail(); // Recojo el email de usuario que tiene la sesión iniciada

        // Recojo los elementos de la vista
        idTituloAjustes = view.findViewById(R.id.idTitulo);
        idEmailCuenta = view.findViewById(R.id.idEmailCuenta);
        idEmailCuenta = view.findViewById(R.id.idEmailCuenta);
        idBotonCambiarEmail = view.findViewById(R.id.idBotonCambiarEmail);
        idBotonCambiarContrasenia = view.findViewById(R.id.idBotonCambiarContrasenia);
        idBotonBorrarCuenta = view.findViewById(R.id.idBotonBorrarCuenta);

        // Añado todos los datos y los textos a la vista en el idioma seleccionado
        idEmailCuenta.setText(email);
        idTituloAjustes.setText(pagina_ajustes_cuenta.getTitulo_pagina());
        idBotonCambiarEmail.setText(pagina_ajustes_cuenta.getCambiar_email());
        idBotonCambiarContrasenia.setText(pagina_ajustes_cuenta.getCambiar_contrasenia());
        idBotonBorrarCuenta.setText(pagina_ajustes_cuenta.getBorrar_cuenta());

        idBotonCambiarEmail.setOnClickListener(v -> {

            CambiarDato dialog = CambiarDato.newInstance("email"); // Creo un nuevo PopUp para cambiar el email

            if (this instanceof CambiarDato.OnCambiarDatoListener) { // Compruebo si la interfaz implementa el listener

                dialog.setOnCambiarDatoListener((CambiarDato.OnCambiarDatoListener) this); // Al dialoj le paso el fragmento actual
            }

            dialog.show(this.getParentFragmentManager(), "Cambiar_dato"); // Muestra el dialoj

        });

        idBotonCambiarContrasenia.setOnClickListener(v -> {

            CambiarDato dialog = CambiarDato.newInstance("contrasenia"); // Creo un nuevo PopUp para cambiar la contraseña

            if (this instanceof CambiarDato.OnCambiarDatoListener) { // Compruebo si la interfaz implementa el listener

                dialog.setOnCambiarDatoListener((CambiarDato.OnCambiarDatoListener) this); // Al dialoj le paso el fragmento actual
            }

            dialog.show(this.getParentFragmentManager(), "Cambiar_dato"); // Muestra el dialoj

        });

        idBotonBorrarCuenta.setOnClickListener(v -> { // Si quiere borrar la cuenta, muestro el Dialoj y si pulsa en aceptar se borra

            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getContext());
            alertDialogBuilder.setTitle(pagina_ajustes_cuenta.getPregunta_borrar_cuenta());
            alertDialogBuilder
                    .setMessage(email)
                    .setCancelable(false)
                    .setPositiveButton(pagina_ajustes_cuenta.getBorrar_cuenta(), new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) { // Si pulsa en aceptar...
                            new Thread(() -> {

                                final String[] mensaje_resultado = new String[1];
                                mensaje_resultado[0] = usuario_controlador.borrar_usuario(); // Borro el usuario

                                requireActivity().runOnUiThread(() -> {

                                    if (mensaje_resultado[0].isEmpty()) { // Si lo borra...

                                        mensaje_resultado[0] = pagina_ajustes_cuenta.getCuenta_borrada();

                                        Usuario_controlador.cerrarSesion(requireContext()); // Cierro la sesión
                                        CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), new IniciarRegistrarView()); // Vuelvo al fragmento del inicio de sesión
                                    }

                                    Toast.makeText(getContext(), mensaje_resultado[0], Toast.LENGTH_SHORT).show(); // Muestra el resultado
                                });
                            }).start();
                        }
                    })
                    .setNegativeButton(Idioma_controlador.getIdioma_seleccionado().getPagina_tareas().getCancelar(), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.cancel(); // Cerrar popUp
                        }
                    }).create().show();
        });

        return view;
    }

    @Override
    public void onCambiarDato() { // Si se actualizó el email...

        email = Usuario_controlador.getUsuario().getEmail(); // Se recoge el email del usuario que tiene iniciada la sesión

        if (idEmailCuenta != null) {

            idEmailCuenta.setText(email); // Se añade el email a la vista
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof MainActivity) { // Desbloquea el idioma
            ((MainActivity) getActivity()).bloquearIdiomaMenu(false);
        }
    }
}
