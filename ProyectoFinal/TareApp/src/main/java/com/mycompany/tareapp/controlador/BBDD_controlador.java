/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Propietario
 */
public class BBDD_controlador {

    private static final String nombre_bbdd = "tareapp";
    private static final String usuario = "root";
    private static final String contrasenia = "root";
    private static Connection conexion;

    public static Connection abrirConexion() {
        
        try {
            
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+nombre_bbdd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", usuario, contrasenia);
            
        } catch (SQLException ex) {
            
            Logger.getLogger(BBDD_controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return conexion;
    }
    
    public static void cerrarConexion() {
        
        if (conexion != null) {
            
            try {
                
                conexion.close();
                conexion = null;
                
            } catch (SQLException ex) {
                
                Logger.getLogger(BBDD_controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
