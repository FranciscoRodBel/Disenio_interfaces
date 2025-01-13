/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.actividad_7_1;

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
    public void testComprobarNumero() {
        System.out.println("comprobarNumero");
        
        Formulario instance = new Formulario();
        
        assertTrue(instance.comprobarNumero("123456"));
        assertFalse(instance.comprobarNumero("hola"));
        assertFalse(instance.comprobarNumero(""));
        assertFalse(instance.comprobarNumero(null));
    }
    
    @org.junit.Test
    public void testBotonEnviar() {
        
        Formulario formulario = new Formulario();

        formulario.getInput_numero1().setText("4");
        formulario.getInput_numero2().setText("8");

        formulario.getBoton_enviar().doClick();

        assertEquals("Resultado: 12", formulario.getLabelResultado().getText());
        assertNotEquals("Resultado: 8", formulario.getLabelResultado().getText());
    }

    @org.junit.Test
    public void testMain() {
        
        System.out.println("main");
        String[] args = null;
        Formulario.main(args);
    }
}
