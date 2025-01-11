/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.tareapp.modelo;

import com.mycompany.tareapp.controlador.BBDD_controlador;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Propietario
 */
public class BBDD_tareapp {
    
    public ArrayList<HashMap<String, Object>> consultar(String consulta_consultar) { // Devuelvo un array list que tiene dentro HashMaps con nombre_propiedad : valor
        
        ArrayList<HashMap<String, Object>> resultados = new ArrayList<>(); // Array final que se devuelve con todos los datos
        Connection conexion = BBDD_controlador.abrirConexion();
        
        try {
            
            Statement consulta = conexion.createStatement();

            ResultSet resultado = consulta.executeQuery(consulta_consultar);

            while (resultado.next()) {
                
                HashMap<String, Object> fila = new HashMap<>();
                ResultSetMetaData metaData = resultado.getMetaData();

                for (int i = 1; i <= metaData.getColumnCount(); i++) {

                    fila.put(metaData.getColumnName(i), resultado.getObject(i)); // Se guarda en el hashMap la columna con el dato
                }

                resultados.add(fila);
            }
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;

        } finally {
            
            BBDD_controlador.cerrarConexion();
        }
        
        return resultados;
    }
    
    public boolean insertar(String consulta_insertar) {
        
        Connection conexion = BBDD_controlador.abrirConexion();
        
        try {

            Statement consulta = conexion.createStatement();
           
            return consulta.executeUpdate(consulta_insertar) > 0;
            
        } catch (SQLException ex) {
            
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;
            
        } finally {
            
            BBDD_controlador.cerrarConexion();
        }
    }
    
    public boolean actualizar(String consulta_actualizar) {
        
        Connection conexion = BBDD_controlador.abrirConexion();

        try {
            
            Statement consulta = conexion.createStatement();

            return consulta.executeUpdate(consulta_actualizar) > 0;

        } catch (SQLException ex) {
            
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {
            
            BBDD_controlador.cerrarConexion();
        }
    }
    
    public boolean borrar(String consulta_borrar) {
        
        Connection conexion = BBDD_controlador.abrirConexion();

        try {
            
            Statement consulta = conexion.createStatement();

            return consulta.executeUpdate(consulta_borrar) > 0;

        } catch (SQLException ex) {
            
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            return false;

        } finally {
            
            BBDD_controlador.cerrarConexion();
        }
    }
}
