package com.mycompany.tareapp.modelo;

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

        try {

            // Crear mensaje
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(email_usuario));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(email_usuario_envio));
            message.setSubject("Código de verificación para iniciar sesión en TareApp");
            message.setText("Hola,\n \n" +
                            "Para completar tu inicio de sesión en TareApp, introduce el siguiente código de verificación en la aplicación:\n \n" +
                            codigo+"\n \n" +
                            "Si no solicitaste este código, puedes ignorar este mensaje.\n \n" +
                            "Saludos,\n" +
                            "El equipo de TareApp.");
            Transport.send(message);

            return true;

        } catch (MessagingException me) {
            
            return false;
        }
    }
}