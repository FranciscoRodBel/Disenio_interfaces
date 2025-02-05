/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.TareApp;

import com.mycompany.tareapp.controlador.Usuario_controlador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Propietario
 */
public class FormularioTest {
    
    public FormularioTest() {
        
    }

    @org.junit.Test
    public void testComprobarRegistro() {
        
        // Realizo las pruebas sobre registro ya que son muchas las pruebas diferentes que se pueden probar y de esta manera se realiza más rápido
        
        Usuario_controlador usuario_controlador = new Usuario_controlador();
        
        
        assertFalse(usuario_controlador.registrar_usuario("prueba@prueba.c","123456Prueba", "123456Prueba", "Español").isEmpty());
        assertFalse(usuario_controlador.registrar_usuario("prueba@prueba.com","123456Prueb", "123456Prueba", "Español").isEmpty());
        assertFalse(usuario_controlador.registrar_usuario("prueba@prueba.com","123456prueba", "123456Prueba", "Español").isEmpty());
        assertFalse(usuario_controlador.registrar_usuario("prueba@prueba.com","123456Prueba", "prueba", "Español").isEmpty());
        assertFalse(usuario_controlador.registrar_usuario("prueba@prueba.com","prueba", "prueba", "Español").isEmpty());
        assertFalse(usuario_controlador.registrar_usuario("pruebaprueba.com","123456Prueba", "123456Prueba", "Español").isEmpty());
        assertFalse(usuario_controlador.registrar_usuario("prueba@prueba","123456Prueba", "123456Prueba", "Español").isEmpty());
        assertFalse(usuario_controlador.registrar_usuario("prueba@pruebaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.com","123456Pruebaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "123456Pruebaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "Español").isEmpty());
        
        
        // Si se descomenta la línea de abajo, cada vez que se vaya a ejecutar, hay que borrar el usuario de la BBDD
        //assertTrue(usuario_controlador.registrar_usuario("prueba@prueba.com","123456Prueba", "123456Prueba", "Español").isEmpty());
    }

    @org.junit.Test
    public void testMain() {
        
        String[] args = null;
    }
}
