package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputType;
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
import com.example.tareapp.controlador.Lista_controlador;
import com.example.tareapp.controlador.Usuario_controlador;
import com.example.tareapp.modelo.idioma.Pagina_ajustes_cuenta;
import com.example.tareapp.modelo.idioma.Pagina_inicio_registro;
import com.example.tareapp.modelo.idioma.Pagina_listas;

public class CambiarDato extends DialogFragment {
    private OnCambiarDatoListener listener;
    private Usuario_controlador usuario_controlador = new Usuario_controlador();
    private ImageButton idCerrarPanel;
    private EditText idInputDato, idInputRepetirDato;
    private Button idBotonCambiar;
    private TextView idMensajeResultado, idTitulo;
    private String accion = "";

    Pagina_ajustes_cuenta pagina_ajustes_cuenta = Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta();

    public static CambiarDato newInstance(String accion) {
        CambiarDato dialog = new CambiarDato();
        Bundle args = new Bundle();
        args.putString("accion", accion);
        dialog.setArguments(args);
        return dialog;
    }
    public interface OnCambiarDatoListener {
        void onCambiarDato();
    }

    public void setOnCambiarDatoListener(OnCambiarDatoListener listener) {
        this.listener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            accion = getArguments().getString("accion");
        }
    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.cambiar_email_contrasenia, container, false);

        idCerrarPanel = view.findViewById(R.id.idCerrarPanel);
        idTitulo = view.findViewById(R.id.idTitulo);
        idInputDato = view.findViewById(R.id.idInputDato);
        idInputRepetirDato = view.findViewById(R.id.idInputRepetirDato);
        idBotonCambiar = view.findViewById(R.id.idBotonCambiar);
        idMensajeResultado = view.findViewById(R.id.idMensajeResultado);

        if (accion.equals("contrasenia")) {

            idTitulo.setText(pagina_ajustes_cuenta.getCambiar_contrasenia());
            idInputDato.setHint(pagina_ajustes_cuenta.getNuevo_contrasenia());
            idInputRepetirDato.setHint(pagina_ajustes_cuenta.getRepetir_contrasenia());
            idBotonCambiar.setText(pagina_ajustes_cuenta.getCambiar_contrasenia());

            idInputDato.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            idInputRepetirDato.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        } else {

            idTitulo.setText(pagina_ajustes_cuenta.getCambiar_email());
            idInputDato.setHint(pagina_ajustes_cuenta.getNuevo_email());
            idInputRepetirDato.setHint(pagina_ajustes_cuenta.getRepetir_email());
            idBotonCambiar.setText(pagina_ajustes_cuenta.getCambiar_email());
        }

        idCerrarPanel.setOnClickListener(v -> dismiss());

        idBotonCambiar.setOnClickListener(v -> {
            new Thread(() -> {

                final String[] mensaje_resultado = new String[1];
                String datoCambiar = idInputDato.getText().toString();
                String datoRepetir = idInputRepetirDato.getText().toString();

                if (accion.equals("contrasenia")) {

                    mensaje_resultado[0] = usuario_controlador.actualizar_contrasenia(datoCambiar, datoRepetir);

                } else {

                    mensaje_resultado[0] = usuario_controlador.comprobar_datos_actualizar_email(datoCambiar, datoRepetir);
                }

                requireActivity().runOnUiThread(() -> {

                    if (mensaje_resultado[0].isEmpty()) {

                        if (accion.equals("contrasenia")) {

                            mensaje_resultado[0] = pagina_ajustes_cuenta.getContrasenia_actualizada();

                        } else {

                            ConfirmarEmailDialog dialog = ConfirmarEmailDialog.newInstance(datoCambiar);
                            dialog.show(getParentFragmentManager(), "ConfirmarEmail");
                        }
                    }

                    idMensajeResultado.setText(mensaje_resultado[0]);
                    new android.os.Handler().postDelayed(() -> {
                        if (isAdded()) {
                            requireActivity().runOnUiThread(() ->
                                    idMensajeResultado.setText(""));
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
