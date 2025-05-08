package com.mycompany.tareapp.vista.plantillas;

import java.awt.Dimension;
import javax.swing.JTextArea;

/**
 * Clase para crear la nota del panel de notas de la página de notas
 * Componente creado para poder crear muchas notas con el mismo formato
 * 
 * @author Francisco
 */
public final class Nota_plantilla extends Scroll {

    int idNota;
    String color;
    private JTextArea textArea = new JTextArea();
    private static final Dimension DIMENSION_NOTA = new Dimension(200, 200);
            
    public Nota_plantilla(int idNota, String texto, String color) {
        
        super(new JTextArea()); 
        
        this.setIdNota(idNota);
        this.setColor(color);
        textArea.setFont(Estilos.getFuente());         
        textArea.setEditable(false);
        textArea.setText(texto);
        textArea.setCaretColor(null);
        textArea.setFocusable(false);

        this.setViewportView(textArea);
        this.setPreferredSize(DIMENSION_NOTA);
        this.setMinimumSize(DIMENSION_NOTA);
        this.setMaximumSize(DIMENSION_NOTA);

        switch(color) { // Selecciono el color de fondo de la nota
            case "naranja" -> textArea.setBackground(Estilos.getNaranja_nota());
            case "verde" -> textArea.setBackground(Estilos.getVerde_nota());
            case "morado" -> textArea.setBackground(Estilos.getMorado_nota());  
            case "amarillo" -> textArea.setBackground(Estilos.getAmarillo_nota());
            case "rosa" -> textArea.setBackground(Estilos.getRosa_nota());  
            default -> textArea.setBackground(Estilos.getAzul_nota());
        }
        
        textArea.addMouseListener(new java.awt.event.MouseAdapter() { // Si se pulsa en la propia nota, abre el PopUp para editar la nota
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                Popup_crear_editar_nota popup_crear_editar_nota = new Popup_crear_editar_nota(Nota_plantilla.this);
                popup_crear_editar_nota.setVisible(true);
            }
        });

    }

    public int getIdNota() {
        return idNota;
    }

    public void setIdNota(int idNota) {
        this.idNota = idNota;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
}
