package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
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

/**
 * Clase para la vista de inicio y registro
 *
 * @author Francisco
 */
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

        if (getActivity() instanceof MainActivity) { // Compruebo si este fragmento pertenece al MainActivity(todas las vistas se colocan en el Main)
            ((MainActivity) getActivity()).bloquearOpcionesMenu(true); // Accedo a una función que está en el Main y la ejecuto
        }

        Pagina_inicio_registro pagina_inicio_registro = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro(); // Recojo el idioma de la vista

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

        // Añado el idioma a todos los textos
        idTitulo.setText(pagina_inicio_registro.getIniciar_sesion());
        idBotonIniciarSesion.setText(pagina_inicio_registro.getIniciar_sesion());
        idBotonRegistrar.setText(pagina_inicio_registro.getRegistrarse());
        idBotonEnviarInicio.setText(pagina_inicio_registro.getIniciar_sesion());
        idBotonEnviarRegistro.setText(pagina_inicio_registro.getRegistrarse());
        idInputContraseniaInicio.setHint(pagina_inicio_registro.getContrasenia());
        idInputContraseniaRegistro.setHint(pagina_inicio_registro.getContrasenia());
        idInputRepetirContraseniaRegistro.setHint(pagina_inicio_registro.getRepetir_contrasenia());

        // Cambio de layout de registro a inicio de sesión
        idBotonIniciarSesion.setOnClickListener(v -> {

            layoutLogin.setVisibility(View.VISIBLE); // Muestro el layout
            layoutRegistro.setVisibility(View.GONE); // Oculto el layout
            idTitulo.setText(pagina_inicio_registro.getIniciar_sesion()); // Cambio el título de la vista

            // Cambio los estilos del botón que cambia entre layouts
            idBotonIniciarSesion.setBackgroundResource(R.drawable.boton_izquierdo_redondo);
            idBotonRegistrar.setBackgroundColor(Color.TRANSPARENT);
            idBotonIniciarSesion.setTextColor(ContextCompat.getColor(requireContext(), R.color.blanco));
            idBotonRegistrar.setTextColor(ContextCompat.getColor(requireContext(), R.color.negro));
        });

        idBotonRegistrar.setOnClickListener(v -> {

            layoutLogin.setVisibility(View.GONE); // Oculto el layout
            layoutRegistro.setVisibility(View.VISIBLE); // Muestro el layout
            idTitulo.setText(pagina_inicio_registro.getRegistrarse()); // Cambio el título de la vista

            // Cambio los estilos del botón que cambia entre layouts
            idBotonRegistrar.setBackgroundResource(R.drawable.boton_derecho_redondo);
            idBotonIniciarSesion.setBackgroundColor(Color.TRANSPARENT);
            idBotonRegistrar.setTextColor(ContextCompat.getColor(requireContext(), R.color.blanco));
            idBotonIniciarSesion.setTextColor(ContextCompat.getColor(requireContext(), R.color.negro));
        });

        idBotonEnviarInicio.setOnClickListener(v -> { // Envío de formulario de inicio de sesión
            new Thread(() -> {

                String email = idInputEmailInicio.getText().toString();
                String contrasenia = idInputContraseniaInicio.getText().toString();

                String mensaje_resultado = usuario_controlador.iniciar_usuario(requireContext(), email, contrasenia); // Intento inciar sesión

                requireActivity().runOnUiThread(() -> {

                    if (mensaje_resultado.isEmpty()) { // Si está vacío es que se inició correctamente

                        idInputEmailInicio.setText("");
                        idInputContraseniaInicio.setText("");

                        Idioma_controlador.cambiarIdioma(Usuario_controlador.getUsuario().getIdioma_seleccionado(), false); // Cambio el idioma de la app antes de crear la vista

                        ((MainActivity) getActivity()).bloquearOpcionesMenu(false); // Habilito las opciones de la cabecera, accediendo a la función del main
                        CambiarVista.cambiarFragmento(requireActivity().getSupportFragmentManager(), new TareasView()); // Cambio la vista

                    } else { // Si no, muestra el mensaje de error durante 3 segundos

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

        idBotonEnviarRegistro.setOnClickListener(v -> { // Envío de formulario de registro
            new Thread(() -> {

                String email = idInputEmailRegistro.getText().toString();
                String contrasenia = idInputContraseniaRegistro.getText().toString();
                String repetir_contrasenia = idInputRepetirContraseniaRegistro.getText().toString();

                String mensaje_resultado = usuario_controlador.comprobar_datos_registro(email, contrasenia, repetir_contrasenia); // Compruebo que los datos sean válidos

                requireActivity().runOnUiThread(() -> {

                    if (mensaje_resultado.isEmpty()) { // Si está vacío es que son válidos

                        ConfirmarEmailDialog dialog = ConfirmarEmailDialog.nuevaInstancia(email, contrasenia, repetir_contrasenia); // Creo el PopUp de confirmar email

                        dialog.setOnRegistroExitosoListener(() -> { // Añado un listener al dialoj para que cuando se registre existosamente se muestre el mensaje en esta vista

                            idInputEmailRegistro.setText("");
                            idInputContraseniaRegistro.setText("");
                            idInputRepetirContraseniaRegistro.setText("");

                            idMensajeResultadoInicio.setText(pagina_inicio_registro.getCuenta_creada()); // Si se activa este listener muestro este mensaje duante 3 segundos

                            new android.os.Handler().postDelayed(() -> {
                                if (isAdded()) {
                                    requireActivity().runOnUiThread(() ->
                                            idMensajeResultadoInicio.setText(""));
                                }
                            }, 3000);
                        });

                        dialog.show(getParentFragmentManager(), "ConfirmarEmail"); // Muestro el PopUp

                    } else { // Si los datos no son válidos, muestro el mensaje de error durante 3 segundos

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

        // Código para que cuando pulse en la flecha de retroceder minimice la app en vez de eliminar el fragmento
        requireActivity().getOnBackPressedDispatcher().addCallback(
            getViewLifecycleOwner(),
            new OnBackPressedCallback(true) {
                @Override
                public void handleOnBackPressed() {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        );

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (getActivity() instanceof MainActivity) {
            ((MainActivity) getActivity()).bloquearIdiomaMenu(false); // En esta vista siempre bloquea las opciones de la cabecera
        }
    }
}
