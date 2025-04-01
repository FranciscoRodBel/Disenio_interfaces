/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.tareapp.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Controlador de la base de datos, en esta clase se realizan las conexiones a la base de datos.
 * Permite abrir y cerrar sesión con la base de datos.
 * 
 * @author FranciscoRB
 */
public class BBDD_controlador {

    private static final String ruta_servidor = "tareapp-1.crwyy0o20y2n.eu-north-1.rds.amazonaws.com";
    private static final String nombre_bbdd = "tareapp_bbdd";
    private static final String usuario = "admin_tareapp";
    private static final String contrasenia = "RSgJW84VtG3BHMq";
    private static Connection conexion;

    /**
    * Función para abrir la base de datos
    * 
    * @return La conexión con la base de datos.
    */
    public static Connection abrirConexion() {
        
        try {
            
            conexion = DriverManager.getConnection("jdbc:mysql://"+ruta_servidor+"/"+nombre_bbdd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", usuario, contrasenia); // Establece la conexión con la base de datos
            
        } catch (SQLException ex) {
            
            Logger.getLogger(BBDD_controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }
    
    /**
    * Función para cerrar la base de datos.
    * 
    * Si la conexión está abierta, se cierra y se pone como null.
    */
    public static void cerrarConexion() {
        
        if (conexion != null) {
            
            try {
                
                conexion.close(); // Cierra la conexión con la base de datos
                conexion = null;
                
            } catch (SQLException ex) {
                
                Logger.getLogger(BBDD_controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static Connection getConexion() {
        return conexion;
    }
    
}
