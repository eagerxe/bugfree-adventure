package Vistas;

import Controladores.CtrlInicio;

/**
 * Vista Inicio
 * @author miguelhernandez
 */
public class Inicio extends javax.swing.JFrame {

    /**
     * Crea la nueva forma Inicio
     */
    public Inicio() {
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

        lblInicio = new javax.swing.JLabel();
        btnCrearExamen = new javax.swing.JButton();
        btnLatextoXML = new javax.swing.JButton();
        btnXMLtoLatex = new javax.swing.JButton();
        btnCE = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblInicio.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lblInicio.setText("LaTeX2MoodleXML");

        btnCrearExamen.setText("Mezclar exámenes LaTeX");
        btnCrearExamen.setActionCommand("Mezclar examenes LaTeX");
        btnCrearExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearExamenActionPerformed(evt);
            }
        });

        btnLatextoXML.setText("Convertir examen de LaTeX a Moodle XML");
        btnLatextoXML.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLatextoXMLActionPerformed(evt);
            }
        });

        btnXMLtoLatex.setText("Convertir examen de Moodle XML a LaTeX");
        btnXMLtoLatex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXMLtoLatexActionPerformed(evt);
            }
        });

        btnCE.setText("Crear examen LaTeX ó Moodle XML");
        btnCE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(531, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnXMLtoLatex, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLatextoXML, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCE, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(466, 466, 466))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblInicio)
                        .addGap(499, 499, 499))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(lblInicio)
                .addGap(48, 48, 48)
                .addComponent(btnCrearExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnLatextoXML, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(btnXMLtoLatex, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnCE, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Botón para seleccionar la creación de un examen
     * @param evt 
     */
    private void btnCrearExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearExamenActionPerformed
        
        CtrlInicio CI = new CtrlInicio(1);    
        dispose();
        
    }//GEN-LAST:event_btnCrearExamenActionPerformed
    /**
     * Botón para seleccionar la conversion de un examen de LaTeX a XML Moodle
     * @param evt 
     */
    private void btnLatextoXMLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLatextoXMLActionPerformed
        
        CtrlInicio CI = new CtrlInicio(2);    
        dispose();
        
    }//GEN-LAST:event_btnLatextoXMLActionPerformed
    /**
     * Botón para seleccionar la conversion de un examen en XML Moodle a LaTeX
     * @param evt 
     */
    private void btnXMLtoLatexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXMLtoLatexActionPerformed
        CtrlInicio CI = new CtrlInicio(3);    
        dispose();
    }//GEN-LAST:event_btnXMLtoLatexActionPerformed
    /**
     * Boton para seleccionar la creacion de un examen en LaTeX/XML
     * @param evt 
     */
    private void btnCEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCEActionPerformed
        CtrlInicio CI = new CtrlInicio(5);
        dispose();
    }//GEN-LAST:event_btnCEActionPerformed

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
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inicio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCE;
    private javax.swing.JButton btnCrearExamen;
    private javax.swing.JButton btnLatextoXML;
    private javax.swing.JButton btnXMLtoLatex;
    private javax.swing.JLabel lblInicio;
    // End of variables declaration//GEN-END:variables
}
