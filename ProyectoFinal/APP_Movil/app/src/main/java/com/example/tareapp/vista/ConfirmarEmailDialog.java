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
    private TextView idResultadoConfirmarEmail;
    private int codigo = 999999;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private String email = "";

    Pagina_inicio_registro pagina_inicio_registro = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();

    public static ConfirmarEmailDialog newInstance(String email) {
        ConfirmarEmailDialog dialog = new ConfirmarEmailDialog();
        Bundle args = new Bundle();
        args.putString("email", email);
        dialog.setArguments(args);
        return dialog;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            email = getArguments().getString("email");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.confirmar_email_dialog, container, false);

        idInputCodigo = view.findViewById(R.id.idInputCodigo);
        idBotonEnviarCodigo = view.findViewById(R.id.idBotonEnviarCodigo);
        idBotonConfirmarEmail = view.findViewById(R.id.idBotonConfirmarEmail);
        idResultadoConfirmarEmail = view.findViewById(R.id.idResultadoConfirmarEmail);
        idCerrarPanel = view.findViewById(R.id.idCerrarPanel);

        idCerrarPanel.setOnClickListener(v -> dismiss());

        idBotonEnviarCodigo.setOnClickListener(v -> {

            idBotonEnviarCodigo.setEnabled(false);
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

            handler.postDelayed(() -> idBotonEnviarCodigo.setEnabled(true), 60000); // Espera de 1 min
        });

        idBotonConfirmarEmail.setOnClickListener(v -> {
            String codigoIngresado = idInputCodigo.getText().toString();
            idResultadoConfirmarEmail.setText("Código recibido: " + codigoIngresado);
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
