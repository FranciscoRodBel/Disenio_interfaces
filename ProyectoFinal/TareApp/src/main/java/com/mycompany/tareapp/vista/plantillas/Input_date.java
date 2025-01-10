/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import java.awt.Insets;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.SpringLayout;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Propietario
 */
public class Input_date extends JFormattedTextField {
    
    Estilos estilos = new Estilos();
    JButton botonCalendario = new JButton();
    
    public Input_date() {
        
        super(crearFormato());
        
        SpringLayout layout = new SpringLayout();
        this.setLayout(layout);
        this.setBorder(new RoundedBorder(5, 2));
        this.setBackground(estilos.getBlanco_claro());
        this.setFont(estilos.getFuente());
        this.setPreferredSize(new Dimension(260, 35));
        this.setMargin(new Insets(0, 10, 0, 0));
        
        botonCalendario.setIcon(new ImageIcon("src/main/java/com/mycompany/tareapp/vista/recursos/imagenes/calendar-days-solid.png"));
        botonCalendario.setPreferredSize(new Dimension(30,30));
        botonCalendario.setContentAreaFilled(false); // Elimino el fondo
        this.add(botonCalendario);
        layout.putConstraint(SpringLayout.EAST, botonCalendario, 0, SpringLayout.EAST, this);
        layout.putConstraint(SpringLayout.NORTH, botonCalendario, -5, SpringLayout.NORTH, this);
    }
    // Para el icono - https://www.youtube.com/watch?v=yc3sWITm4v8
    
    public static MaskFormatter crearFormato() {
        
        try {
            
            MaskFormatter formato = new MaskFormatter("##/##/####"); // Con el # le indico el formato y que solo pueden introducirse números
            formato.setPlaceholderCharacter('_'); // Cambio los # por _, porngo primero los # en vez de directamente los _ para que solo permita números
            return formato;
            
        } catch (ParseException e) {
        
            return null;
        }
    }
    
    /*
    public String solicitarFecha() {

        String fecha = "";

        do {

            Scanner fechaNota = new Scanner(System.in); // Pide por consola la fecha para la nota
            System.out.println(azul+"-                  Introduzca la fecha de la nota                  -");
            System.out.println("-          Formato Día/Mes/Año - XX/XX/XXXX - 09/10/2024           -"+blanco);
            System.out.print(verde+"> "+blanco);
            fecha = fechaNota.nextLine();

        } while (comprobarFecha(fecha)); // Comrpbará que sea válida, si lo es sale del bucle

        String[] fechaDividida = fecha.split("/"); // Divido la fecha en Día, mes y año en un array

        fechaDividida[0] = fechaDividida[0].length() == 1 ? "0" + fechaDividida[0] : fechaDividida[0]; // Si el día tenía un solo dígito le pongo un 0 delante
        fechaDividida[1] = fechaDividida[1].length() == 1 ? "0" + fechaDividida[1] : fechaDividida[1]; // Si el mes tenía un solo dígito le pongo un 0 delante

        fecha = fechaDividida[0] + "/" + fechaDividida[1] + "/" + fechaDividida[2]; // Vuelvo a juntar la fecha

        return fecha;
    }
    */
    
}
