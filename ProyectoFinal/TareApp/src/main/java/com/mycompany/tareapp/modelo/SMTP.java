package com.mycompany.tareapp.modelo;

import com.mycompany.tareapp.controlador.Idioma_controlador;
import com.mycompany.tareapp.modelo.idioma.Pagina_inicio_registro;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SMTP {

    // Código sacado de: https://www.youtube.com/watch?v=Sxc5AUHGc4c

    // Correo y contraseña para enviar correos
    // Recomendación: No cambiar el correo y la contraseña, con ese correo y contraseña se pueden enviar correos
    // En caso de cambiar el correo y la contraseña tiene que generar una contraseña de aplicación
    // Link para generar una contraseña de aplicación: https://myaccount.google.com/apppasswords
    // Una vez creada la contraseña de aplicación pegue debajo el email y la contraseña de aplicación generada
    private final static String email_usuario = "contacto.tareapp@gmail.com";
    private final static String contrasenia_usuario = "dycq szwj cfjl rbwu"; // Contraseña de acceso de google generada para el ejercicio
    private static Session session = null;

    public SMTP() {

        // Configuración del servidor SMTP
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com"); // Servidor SMTP
        props.put("mail.smtp.port", "587"); // Puerto TLS
        props.put("mail.smtp.auth", "true"); // Habilitar autenticación
        props.put("mail.smtp.starttls.enable", "true"); // Habilitar STARTTLS

        session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(email_usuario, contrasenia_usuario);
            }
        });
    }

    public Boolean enviarEmail(String email_usuario_envio, int codigo) {

        Pagina_inicio_registro idioma_inicio_registro = Idioma_controlador.getIdioma_seleccionado().getPagina_inicio_registro();
    
        try {

            // Crear mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email_usuario));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email_usuario_envio));
            message.setSubject(idioma_inicio_registro.getConfirmacion_asunto());
            
            String mensajeEmail = idioma_inicio_registro.getConfirmacion_mensaje();
            mensajeEmail = mensajeEmail.replace("{codigo}", String.valueOf(codigo));
                    
            message.setText(mensajeEmail);
            Transport.send(message);

            return true;

        } catch (MessagingException me) {
            
            return false;
        }
    }
}