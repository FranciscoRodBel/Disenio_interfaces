package com.example.tareapp.vista;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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

/**
 * Clase para el PopUp de cambiar email o contraseña
 *
 * @author Francisco
 */
public class CambiarDato extends DialogFragment {

    private OnCambiarDatoListener listener;
    private Usuario_controlador usuario_controlador = new Usuario_controlador();
    private ImageButton idCerrarPanel;
    private EditText idInputDato, idInputRepetirDato;
    private Button idBotonCambiar;
    private TextView idMensajeResultado, idTitulo;
    private String accion = "";

    Pagina_ajustes_cuenta pagina_ajustes_cuenta = Idioma_controlador.getIdioma_seleccionado().getPagina_ajustes_cuenta();

    /**
     * Función que hace de constructor, me permite crear una nueva instancia con un envio de bundle, lo que permite ahorrar lineas de código
     *
     * @return Devuelvo una instacia de la propia clase
     */
    public static CambiarDato nuevaInstancia(String accion) { // La acción es para saber si está cambiando el email o la contraseña

        CambiarDato dialog = new CambiarDato();
        Bundle args = new Bundle();
        args.putString("accion", accion);
        dialog.setArguments(args);

        return dialog;
    }
    public interface OnCambiarDatoListener { // Cuando se cambie un dato se activará la función onCambiarDato de la vista principal(AjustesView)
        void onCambiarDato();
    }

    public void setOnCambiarDatoListener(OnCambiarDatoListener listener) { // Para aplicar un listener al fragmento principal(AjustesView)
        this.listener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {

            accion = getArguments().getString("accion"); // Recoge la acción que se envía desde el Bundle
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

        if (accion.equals("contrasenia")) { // Si se cambia la contraseña se añaden todos los textos de la contraseña en el idioma seleccionado

            idTitulo.setText(pagina_ajustes_cuenta.getCambiar_contrasenia());
            idInputDato.setHint(pagina_ajustes_cuenta.getNuevo_contrasenia());
            idInputRepetirDato.setHint(pagina_ajustes_cuenta.getRepetir_contrasenia());
            idBotonCambiar.setText(pagina_ajustes_cuenta.getCambiar_contrasenia());

            // Se ponen los inputs de la contraseña en modo password para que cuando escriba salgan los asteriscos
            idInputDato.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
            idInputRepetirDato.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        } else {  // Si se cambia el email se añaden todos los textos del emial en el idioma seleccionado

            idTitulo.setText(pagina_ajustes_cuenta.getCambiar_email());
            idInputDato.setHint(pagina_ajustes_cuenta.getNuevo_email());
            idInputRepetirDato.setHint(pagina_ajustes_cuenta.getRepetir_email());
            idBotonCambiar.setText(pagina_ajustes_cuenta.getCambiar_email());
        }

        idCerrarPanel.setOnClickListener(v -> dismiss()); // Cierra el PopUp

        idBotonCambiar.setOnClickListener(v -> { // Al aplicar los cambios...
            new Thread(() -> {

                final String[] mensaje_resultado = new String[1];
                String datoCambiar = idInputDato.getText().toString();
                String datoRepetir = idInputRepetirDato.getText().toString();

                if (accion.equals("contrasenia")) { // Se actualiza el dato en la BBDD

                    mensaje_resultado[0] = usuario_controlador.actualizar_contrasenia(datoCambiar, datoRepetir);

                } else {

                    mensaje_resultado[0] = usuario_controlador.comprobar_datos_actualizar_email(datoCambiar, datoRepetir);
                }

                requireActivity().runOnUiThread(() -> {

                    if (mensaje_resultado[0].isEmpty()) {

                        if (accion.equals("contrasenia")) { // Si está vacío es que se actualizó correctamente la contraseña

                            mensaje_resultado[0] = pagina_ajustes_cuenta.getContrasenia_actualizada(); // Mensaje de que se actualizó correctamente

                        } else { // Si comprobar_datos_actualizar_email devuelve vacío es que los datos son válidos para actualizar el email

                            ConfirmarEmailDialog dialog = ConfirmarEmailDialog.nuevaInstancia(datoCambiar, null, null); // Muestro el PopUp de cambiar email, al enviar la contraseña como null, ya sé que está actualizando y no registrando
                            dialog.show(getParentFragmentManager(), "ConfirmarEmail");
                        }
                    }

                    idMensajeResultado.setText(mensaje_resultado[0]);
                    new android.os.Handler().postDelayed(() -> {
                        if (isAdded()) {
                            requireActivity().runOnUiThread(() ->
                                    idMensajeResultado.setText(""));
                        }
                    }, 3000); // Muestra el mensaje durante 3 segundos
                });
            }).start();
        });

        return view;
    }

    /**
     * Función que me permite mostrar el resultado de la confirmación del email en este Dialog en vez de mostrar el resultado en el de ConfirmarEmail
     *
     */
    public void mostrarMensajeResultado(String mensaje) {

        if (getActivity() != null) { // Comprueba que exista el PopUp anterior

            getActivity().runOnUiThread(() -> {

                idMensajeResultado.setText(mensaje); // Muestro el mensaje

                if (listener != null) {

                    listener.onCambiarDato(); // Aviso de que se cambió el dato
                }

                new android.os.Handler(Looper.getMainLooper()).postDelayed(() -> {

                    if (isAdded()) {

                        dismiss();
                    }
                }, 3000); // Cierro el PopUp a los 3 segundos
            });
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            getDialog().getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
    }
}
