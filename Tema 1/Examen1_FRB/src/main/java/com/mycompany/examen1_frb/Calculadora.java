/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.examen1_frb;

/**
 *
 * @author Francisco
 */
public class Calculadora extends javax.swing.JFrame {

    /**
     * Creates new form Calculadora
     */
    public Calculadora() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pantallaCalculadora = new javax.swing.JTextField();
        BotonBorrar = new javax.swing.JButton();
        button7 = new javax.swing.JButton();
        button8 = new javax.swing.JButton();
        button9 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        button6 = new javax.swing.JButton();
        button5 = new javax.swing.JButton();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button3 = new javax.swing.JButton();
        button0 = new javax.swing.JButton();
        buttonComa = new javax.swing.JButton();
        buttonMas = new javax.swing.JButton();
        buttonMultiplicar = new javax.swing.JButton();
        buttonMenos = new javax.swing.JButton();
        buttonDividir = new javax.swing.JButton();
        BotonIgual = new javax.swing.JButton();
        BotonBorrar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pantallaCalculadora.setText("0");
        pantallaCalculadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pantallaCalculadoraActionPerformed(evt);
            }
        });

        BotonBorrar.setText("<--");
        BotonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarActionPerformed(evt);
            }
        });

        button7.setText("7");
        button7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button7ActionPerformed(evt);
            }
        });

        button8.setText("8");
        button8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button8ActionPerformed(evt);
            }
        });

        button9.setText("9");
        button9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button9ActionPerformed(evt);
            }
        });

        button4.setText("4");
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        button6.setText("6");
        button6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button6ActionPerformed(evt);
            }
        });

        button5.setText("5");
        button5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button5ActionPerformed(evt);
            }
        });

        button1.setText("1");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setText("2");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setText("3");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        button0.setText("0");
        button0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button0ActionPerformed(evt);
            }
        });

        buttonComa.setText(".");
        buttonComa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonComaActionPerformed(evt);
            }
        });

        buttonMas.setText("+");
        buttonMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMasActionPerformed(evt);
            }
        });

        buttonMultiplicar.setText("*");
        buttonMultiplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMultiplicarActionPerformed(evt);
            }
        });

        buttonMenos.setText("-");
        buttonMenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonMenosActionPerformed(evt);
            }
        });

        buttonDividir.setText("/");
        buttonDividir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDividirActionPerformed(evt);
            }
        });

        BotonIgual.setText("=");
        BotonIgual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIgualActionPerformed(evt);
            }
        });

        BotonBorrar2.setText("C");
        BotonBorrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrar2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pantallaCalculadora)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(BotonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(BotonIgual, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(BotonBorrar2, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(110, 110, 110)
                                .addComponent(button6, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(button1, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                    .addComponent(button7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(button4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(button5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(button8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(button0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(button9, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(buttonMultiplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(buttonDividir, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(buttonComa, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonMas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buttonMenos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(pantallaCalculadora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonBorrar)
                    .addComponent(BotonIgual)
                    .addComponent(BotonBorrar2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button7)
                    .addComponent(button8)
                    .addComponent(button9)
                    .addComponent(buttonDividir))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button6)
                    .addComponent(button4)
                    .addComponent(button5)
                    .addComponent(buttonMultiplicar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1)
                    .addComponent(button3)
                    .addComponent(button2)
                    .addComponent(buttonMenos))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button0)
                    .addComponent(buttonComa)
                    .addComponent(buttonMas))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BotonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarActionPerformed
       
        if (this.pantallaCalculadora.getText().length() == 1) {
        
            pantallaCalculadora.setText("0");
            
        } else {
        
            pantallaCalculadora.setText(this.pantallaCalculadora.getText().substring(0,this.pantallaCalculadora.getText().length()-1));
        
        }
       
    }//GEN-LAST:event_BotonBorrarActionPerformed

    private void BotonIgualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIgualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonIgualActionPerformed

    private void BotonBorrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrar2ActionPerformed
        pantallaCalculadora.setText("0");
    }//GEN-LAST:event_BotonBorrar2ActionPerformed

    private void button6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button6ActionPerformed
        if (this.pantallaCalculadora.getText().equals("0")) {
            
            pantallaCalculadora.setText("6");
                            
        } else {
        
             pantallaCalculadora.setText(this.pantallaCalculadora.getText()+6);

        }
    }//GEN-LAST:event_button6ActionPerformed

    private void pantallaCalculadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pantallaCalculadoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pantallaCalculadoraActionPerformed

    private void button7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button7ActionPerformed
        if (this.pantallaCalculadora.getText().equals("0")) {
            
            pantallaCalculadora.setText("7");
                            
        } else {
        
             pantallaCalculadora.setText(this.pantallaCalculadora.getText()+7);

        }
    }//GEN-LAST:event_button7ActionPerformed

    private void button8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button8ActionPerformed
        if (this.pantallaCalculadora.getText().equals("0")) {
            
            pantallaCalculadora.setText("8");
                            
        } else {
        
             pantallaCalculadora.setText(this.pantallaCalculadora.getText()+8);

        }
    }//GEN-LAST:event_button8ActionPerformed

    private void button9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button9ActionPerformed
        if (this.pantallaCalculadora.getText().equals("0")) {
            
            pantallaCalculadora.setText("9");
                            
        } else {
        
             pantallaCalculadora.setText(this.pantallaCalculadora.getText()+9);

        }
    }//GEN-LAST:event_button9ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        if (this.pantallaCalculadora.getText().equals("0")) {
            
            pantallaCalculadora.setText("4");
                            
        } else {
        
             pantallaCalculadora.setText(this.pantallaCalculadora.getText()+4);

        }
    }//GEN-LAST:event_button4ActionPerformed

    private void button5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button5ActionPerformed
             if (this.pantallaCalculadora.getText().equals("0")) {
            
            pantallaCalculadora.setText("5");
                            
        } else {
        
             pantallaCalculadora.setText(this.pantallaCalculadora.getText()+5);

        }
    }//GEN-LAST:event_button5ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (this.pantallaCalculadora.getText().equals("0")) {
            
            pantallaCalculadora.setText("1");
                            
        } else {
        
             pantallaCalculadora.setText(this.pantallaCalculadora.getText()+1);

        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        if (this.pantallaCalculadora.getText().equals("0")) {
            
            pantallaCalculadora.setText("2");
                            
        } else {
        
             pantallaCalculadora.setText(this.pantallaCalculadora.getText()+2);

        }
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
      
        if (this.pantallaCalculadora.getText().equals("0")) {
            
            pantallaCalculadora.setText("3");
                            
        } else {
        
            pantallaCalculadora.setText(this.pantallaCalculadora.getText()+3);

        }

    }//GEN-LAST:event_button3ActionPerformed

    private void button0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button0ActionPerformed

       
        if (this.pantallaCalculadora.getText().equals("0")) {
            
            pantallaCalculadora.setText("0");
                            
        } else {
        
             pantallaCalculadora.setText(this.pantallaCalculadora.getText()+0);

        }
    }//GEN-LAST:event_button0ActionPerformed

    private void buttonComaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonComaActionPerformed
        pantallaCalculadora.setText(this.pantallaCalculadora.getText()+".");
    }//GEN-LAST:event_buttonComaActionPerformed

    private void buttonMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMasActionPerformed
        pantallaCalculadora.setText(this.pantallaCalculadora.getText()+"+");
    }//GEN-LAST:event_buttonMasActionPerformed

    private void buttonMenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMenosActionPerformed
        pantallaCalculadora.setText(this.pantallaCalculadora.getText()+"-");
    }//GEN-LAST:event_buttonMenosActionPerformed

    private void buttonMultiplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonMultiplicarActionPerformed
        
        pantallaCalculadora.setText(this.pantallaCalculadora.getText()+"*");

        
    }//GEN-LAST:event_buttonMultiplicarActionPerformed

    private void buttonDividirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDividirActionPerformed
       pantallaCalculadora.setText(this.pantallaCalculadora.getText()+"/");
    }//GEN-LAST:event_buttonDividirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculadora.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculadora().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBorrar;
    private javax.swing.JButton BotonBorrar2;
    private javax.swing.JButton BotonIgual;
    private javax.swing.JButton button0;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JButton button5;
    private javax.swing.JButton button6;
    private javax.swing.JButton button7;
    private javax.swing.JButton button8;
    private javax.swing.JButton button9;
    private javax.swing.JButton buttonComa;
    private javax.swing.JButton buttonDividir;
    private javax.swing.JButton buttonMas;
    private javax.swing.JButton buttonMenos;
    private javax.swing.JButton buttonMultiplicar;
    private javax.swing.JTextField pantallaCalculadora;
    // End of variables declaration//GEN-END:variables
}
