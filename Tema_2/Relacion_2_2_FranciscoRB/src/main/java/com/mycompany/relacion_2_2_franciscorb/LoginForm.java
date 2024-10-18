/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.relacion_2_2_franciscorb;

import java.awt.Dimension;
import javax.swing.*;

/**
 *
 * @author Francisco
 */
public class LoginForm extends JPanel {

    private JLabel labelUsuario = new JLabel();
    private JTextField inputUsuario = new JTextField();
    private JLabel labelContrasenia = new JLabel();
    private JPasswordField inputContrasenia = new JPasswordField();
    public LoginForm() {

        this.setLayout(null);
        this.setPreferredSize(new Dimension(250, 135));
        this.setVisible(true);
        
        labelUsuario.setText("Usuario: ");
        labelUsuario.setBounds(25, 25, 70, 30);
        labelUsuario.setVisible(true);
        this.add(labelUsuario);
        
        inputUsuario.setText("Usuario");
        inputUsuario.setBounds(125, 25, 100, 30);
        inputUsuario.setVisible(true);
        this.add(inputUsuario);
        
        labelContrasenia.setText("Contraseña: ");
        labelContrasenia.setBounds(25, 80, 70, 30);
        labelContrasenia.setVisible(true);
        this.add(labelContrasenia);
        
        inputContrasenia.setText("Contraseña");
        inputContrasenia.setBounds(125, 80, 100, 30);
        inputContrasenia.setVisible(true);
        this.add(inputContrasenia);

    }

}
