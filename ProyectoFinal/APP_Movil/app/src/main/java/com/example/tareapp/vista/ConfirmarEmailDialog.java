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

import com.example.tareapp.R;
import com.example.tareapp.controlador.Idioma_controlador;
import com.example.tareapp.controlador.Usuario_controlador;
import com.example.tareapp.modelo.idioma.Pagina_inicio_registro;

import java.util.Random;

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

    Pagina_inicio_registro pagina_inicio_registro = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();

    public static ConfirmarEmailDialog newInstance(String email, String contrasenia, String repetir_contrasenia) {
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
        if (getArguments() != null) {
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

        idTitulo.setText(pagina_inicio_registro.getConfirmar_email());
        idMensajeConfirmarEmail.setText(pagina_inicio_registro.getIntroduzca_codigo());
        idInputCodigo.setHint(pagina_inicio_registro.getCodigo());
        idBotonEnviarCodigo.setText(pagina_inicio_registro.getEnviar_codigo());
        idBotonConfirmarEmail.setText(pagina_inicio_registro.getConfirmar_email());

        idCerrarPanel.setOnClickListener(v -> dismiss());

        idBotonEnviarCodigo.setOnClickListener(v -> {

            idBotonEnviarCodigo.setEnabled(false);
            idBotonEnviarCodigo.setAlpha(0.5f);
            idResultadoConfirmarEmail.setText(pagina_inicio_registro.getEnviando_codigo());

            new Thread(() -> {
                try {
                    codigo = 10000 + new Random().nextInt(90000); // Código de 5 dígitos
                    String mensaje_resultado = usuario_controlador.confirmar_email(email, codigo);

                    Thread.sleep(3000);

                    handler.post(() -> {

                        idResultadoConfirmarEmail.setText(mensaje_resultado);
                        handler.postDelayed(() -> idResultadoConfirmarEmail.setText(""), 3000);
                    });

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }).start();

            handler.postDelayed(() -> {

                idBotonEnviarCodigo.setEnabled(true);
                idBotonEnviarCodigo.setAlpha(1.0f); // vuelve a verse normal

            }, 30000);

        });

        idBotonConfirmarEmail.setOnClickListener(v -> {

            final String codigoIngresado = idInputCodigo.getText().toString();
            final String emailFinal = email;
            final String contraseniaFinal = contrasenia;
            final String repetirContraseniaFinal = repetir_contrasenia;
            final int codigoFinal = codigo;

            new Thread(() -> {
                String mensaje_resultado = pagina_inicio_registro.getCodigo_incorrecto();
                int numero_enviado = 0;

                try {
                    numero_enviado = Integer.parseInt(codigoIngresado);
                } catch (Exception e) {}

                if (codigoFinal == numero_enviado) {

                    if (contraseniaFinal != null) {
                        mensaje_resultado = usuario_controlador.registrar_usuario(
                                emailFinal,
                                contraseniaFinal,
                                repetirContraseniaFinal,
                                Idioma_controlador.getIdioma_seleccionado().getIdioma()
                        );

                        if (mensaje_resultado.isEmpty()) {
                            mensaje_resultado = pagina_inicio_registro.getCuenta_creada();
                        }

                    } else {

                        mensaje_resultado = usuario_controlador.actualizar_email(emailFinal);

                        if (mensaje_resultado.isEmpty()) {
                            mensaje_resultado = Idioma_controlador.getIdioma_seleccionado()
                                    .getPagina_ajustes_cuenta()
                                    .getEmail_actualizado();
                        }
                    }
                }

                String mensaje_resultado_final = mensaje_resultado;

                requireActivity().runOnUiThread(() -> {
                    idResultadoConfirmarEmail.setText(mensaje_resultado_final);

                    new android.os.Handler().postDelayed(() -> {
                        if (isAdded()) {
                            requireActivity().runOnUiThread(() -> idResultadoConfirmarEmail.setText(""));
                        }
                    }, 3000);
                });
            }).start();
        });


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
