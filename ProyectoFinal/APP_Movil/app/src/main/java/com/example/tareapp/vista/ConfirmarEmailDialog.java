package com.example.tareapp.vista;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.tareapp.R;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Usuario_controlador;
import com.example.tareapp.modelo.idioma.Pagina_inicio_registro;

import java.util.Random;

/**
 * Clase para el PopUp de confirmación de email, se enviará un código al correo para confirmar el email
 *
 * @author Francisco
 */
public class ConfirmarEmailDialog extends DialogFragment {

    private Usuario_controlador usuario_controlador = new Usuario_controlador();
    private ImageButton idCerrarPanel;
    private EditText idInputCodigo;
    private Button idBotonEnviarCodigo, idBotonConfirmarEmail;
    private TextView idTitulo, idMensajeConfirmarEmail, idResultadoConfirmarEmail;
    private int codigo = 999999;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private String email = "";
    private String contrasenia = "";
    private String repetir_contrasenia = "";

    private OnRegistroExitosoListener listener;
    Pagina_inicio_registro pagina_inicio_registro = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();

    /**
     * Función que hace de constructor, me permite crear una nueva instancia con un envío de bundle, lo que permite ahorrar lineas de código
     *
     * @return Devuelvo una instacia de la propia clase
     */
    public static ConfirmarEmailDialog nuevaInstancia(String email, String contrasenia, String repetir_contrasenia) {

        ConfirmarEmailDialog dialog = new ConfirmarEmailDialog();
        Bundle args = new Bundle();
        args.putString("email", email);
        args.putString("contrasenia", contrasenia);
        args.putString("repetir_contrasenia", repetir_contrasenia);
        dialog.setArguments(args);

        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) { // Recojo los datos del Bundle

            email = getArguments().getString("email");
            contrasenia = getArguments().getString("contrasenia");
            repetir_contrasenia = getArguments().getString("repetir_contrasenia");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.confirmar_email_dialog, container, false);

        idTitulo = view.findViewById(R.id.idTitulo);
        idMensajeConfirmarEmail = view.findViewById(R.id.idMensajeConfirmarEmail);
        idInputCodigo = view.findViewById(R.id.idInputCodigo);
        idBotonEnviarCodigo = view.findViewById(R.id.idBotonEnviarCodigo);
        idBotonConfirmarEmail = view.findViewById(R.id.idBotonConfirmarEmail);
        idResultadoConfirmarEmail = view.findViewById(R.id.idResultadoConfirmarEmail);
        idCerrarPanel = view.findViewById(R.id.idCerrarPanel);

        // Añado el idioma de los textos
        idTitulo.setText(pagina_inicio_registro.getConfirmar_email());
        idMensajeConfirmarEmail.setText(pagina_inicio_registro.getIntroduzca_codigo());
        idInputCodigo.setHint(pagina_inicio_registro.getCodigo());
        idBotonEnviarCodigo.setText(pagina_inicio_registro.getEnviar_codigo());
        idBotonConfirmarEmail.setText(pagina_inicio_registro.getConfirmar_email());

        idCerrarPanel.setOnClickListener(v -> dismiss()); // Cierra el PopUp

        idBotonEnviarCodigo.setOnClickListener(v -> { // Cuando pulse en "Enviar código"

            idBotonEnviarCodigo.setEnabled(false); // Deshabilito el botón para que no lo puedan pulsar
            idBotonEnviarCodigo.setAlpha(0.5f); // Le bajo el nivel del color para que se vea deshabilitado
            idResultadoConfirmarEmail.setText(pagina_inicio_registro.getEnviando_codigo()); // añado el mensaje de "Enviando código..."

            new Thread(() -> {
                try {
                    codigo = 10000 + new Random().nextInt(90000); // Código de 5 dígitos
                    String mensaje_resultado = usuario_controlador.confirmar_email(email, codigo); // Envía el email

                    handler.post(() -> {

                        idResultadoConfirmarEmail.setText(mensaje_resultado); // Añade el mensaje del resultado del envío
                        handler.postDelayed(() -> idResultadoConfirmarEmail.setText(""), 3000); // Se elemina el mensaje a los 3 segundos
                    });

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();

            handler.postDelayed(() -> {

                idBotonEnviarCodigo.setEnabled(true); // Se habilita el botón
                idBotonEnviarCodigo.setAlpha(1.0f); // vuelve a verse con su color principal

            }, 30000); // A los 30 segundos se activa el botón

        });

        idBotonConfirmarEmail.setOnClickListener(v -> { // Al pulsar en confirmar email...

            // Recojo todos los datos
            final String codigoIngresado = idInputCodigo.getText().toString();
            final String emailFinal = email;
            final String contraseniaFinal = contrasenia;
            final String repetirContraseniaFinal = repetir_contrasenia;
            final int codigoFinal = codigo;

            new Thread(() -> {

                String mensaje_resultado = pagina_inicio_registro.getCodigo_incorrecto(); // Mensaje que se mostrará si el código no es correcto
                int numero_enviado = 0;

                try {

                    numero_enviado = Integer.parseInt(codigoIngresado); // Convierto el código a número entero

                } catch (Exception e) {}

                if (codigoFinal == numero_enviado) { // Si son iguales se confirma el correo

                    if (contraseniaFinal != null) { // Si la contraseña no es null es que se está registrando el usuario

                        mensaje_resultado = usuario_controlador.registrar_usuario(emailFinal, contraseniaFinal, repetirContraseniaFinal, Idioma_controlador.getIdioma_seleccionado().getIdioma()); // Registro al usuario

                        if (mensaje_resultado.isEmpty()) { // Si está vacío es que se registró

                            requireActivity().runOnUiThread(() -> listener.onRegistroExitoso()); // Se activa el listener para mostrar el mensaje en la vista de inicio_registro
                            dismiss(); // Cierro el PopUp
                        }

                    } else { // Si la contraseña es null es que está actualizando el email

                        mensaje_resultado = usuario_controlador.actualizar_email(emailFinal); // Actualiza el email

                        if (mensaje_resultado.isEmpty()) { // Si está vacío es que lo actualizó

                            mensaje_resultado = Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta().getEmail_actualizado(); // Recojo el mensaje de "Email actualizado"

                            Fragment cambiarDato = getParentFragmentManager().findFragmentByTag("Cambiar_dato"); // Recojo el popUp anterior que está iniciado

                            if (cambiarDato instanceof CambiarDato) { // Si existe...

                                ((CambiarDato) cambiarDato).mostrarMensajeResultado(mensaje_resultado); // Le añado el mensaje del resultado al PopUp anterior
                                dismiss(); // Cierro el PopUp de confirmar email
                            }

                        }
                    }
                }

                String mensaje_resultado_final = mensaje_resultado; // Lo paso a una nueva variable para poder settear el mensaje en el hilo principal

                requireActivity().runOnUiThread(() -> {

                    idResultadoConfirmarEmail.setText(mensaje_resultado_final); // Añado el mensaje de error

                    new android.os.Handler().postDelayed(() -> {
                        if (isAdded()) { // Si el popUp existe...
                            requireActivity().runOnUiThread(() -> idResultadoConfirmarEmail.setText(""));
                        }
                    }, 3000); // A los 3 segundos elimino el mensaje
                });
            }).start();
        });

        return view;
    }
    public interface OnRegistroExitosoListener { // Cuando se registre se activará la función onRegistroExitoso de la vista principal(IniciarRegistrarView)
        void onRegistroExitoso();
    }

    public void setOnRegistroExitosoListener(OnRegistroExitosoListener listener) { // Para aplicar un listener al fragmento principal(IniciarRegistrarView)
        this.listener = listener;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
