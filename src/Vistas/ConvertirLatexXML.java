package Vistas;

import Controladores.CtrlConvertirLatextoXML;
import Controladores.CtrlInicio;
import javax.swing.JFileChooser;

/**
 *
 * @author miguelhernandez
 */
public class ConvertirLatexXML extends javax.swing.JFrame {

    /**
     * Creates new form ConvertirLatexXML
     */
    public ConvertirLatexXML() {
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

        btnCancelar = new javax.swing.JButton();
        lblConvertirExamenLtoX = new javax.swing.JLabel();
        lblDireccionOrigen = new javax.swing.JLabel();
        txtDireccionOrigen = new javax.swing.JTextField();
        btnAgregarArchivo = new javax.swing.JButton();
        lblAgregueDireccion = new javax.swing.JLabel();
        lblAgregueDireccionDestino = new javax.swing.JLabel();
        lblDireccionDestino = new javax.swing.JLabel();
        txtDireccionDestino = new javax.swing.JTextField();
        btnDireccionDestino = new javax.swing.JButton();
        btnConvertirExamen = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblConvertirExamenLtoX.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lblConvertirExamenLtoX.setText("Convertir examen LaTeX a Modle XML");

        lblDireccionOrigen.setText("Dirección del examen LaTeX:");

        btnAgregarArchivo.setText("Agregar archivo");
        btnAgregarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarArchivoActionPerformed(evt);
            }
        });

        lblAgregueDireccion.setText("Agregue la dirección donde se encuentra localizado el examen.");

        lblAgregueDireccionDestino.setText("Agregue la direccion de destino del nuevo examen.");

        lblDireccionDestino.setText("Dirección destino:");

        btnDireccionDestino.setText("Agregar directorio");
        btnDireccionDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDireccionDestinoActionPerformed(evt);
            }
        });

        btnConvertirExamen.setText("Convertir examen");
        btnConvertirExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertirExamenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblConvertirExamenLtoX)
                .addGap(387, 387, 387))
            .addGroup(layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDireccionOrigen)
                    .addComponent(lblDireccionDestino))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAgregueDireccionDestino)
                    .addComponent(lblAgregueDireccion)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnConvertirExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDireccionDestino, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                .addComponent(txtDireccionOrigen, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarArchivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDireccionDestino, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 172, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblConvertirExamenLtoX)
                .addGap(49, 49, 49)
                .addComponent(lblAgregueDireccion)
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionOrigen)
                    .addComponent(txtDireccionOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarArchivo))
                .addGap(71, 71, 71)
                .addComponent(lblAgregueDireccionDestino)
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionDestino)
                    .addComponent(txtDireccionDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDireccionDestino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConvertirExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        CtrlInicio CI = new CtrlInicio(4);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarArchivoActionPerformed
        JFileChooser escogerDireccion = new JFileChooser();
        escogerDireccion.showOpenDialog(this);
        String direc = escogerDireccion.getSelectedFile().getAbsolutePath();
        txtDireccionOrigen.setText(direc);
        
    }//GEN-LAST:event_btnAgregarArchivoActionPerformed

    private void btnDireccionDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDireccionDestinoActionPerformed
        JFileChooser escogerDireccion = new JFileChooser();
        escogerDireccion.setFileSelectionMode(1);
        escogerDireccion.showOpenDialog(this);
        String direc = escogerDireccion.getSelectedFile().getAbsolutePath();
        txtDireccionDestino.setText(direc);
    }//GEN-LAST:event_btnDireccionDestinoActionPerformed

    private void btnConvertirExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertirExamenActionPerformed
        String direccionOrigen,direccionDestino;
        direccionOrigen=txtDireccionOrigen.getText();
        direccionDestino=txtDireccionDestino.getText();
        CtrlConvertirLatextoXML CLTX = new CtrlConvertirLatextoXML(direccionOrigen,direccionDestino);
        
    }//GEN-LAST:event_btnConvertirExamenActionPerformed

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
            java.util.logging.Logger.getLogger(ConvertirLatexXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ConvertirLatexXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ConvertirLatexXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConvertirLatexXML.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ConvertirLatexXML().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarArchivo;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnConvertirExamen;
    private javax.swing.JButton btnDireccionDestino;
    private javax.swing.JLabel lblAgregueDireccion;
    private javax.swing.JLabel lblAgregueDireccionDestino;
    private javax.swing.JLabel lblConvertirExamenLtoX;
    private javax.swing.JLabel lblDireccionDestino;
    private javax.swing.JLabel lblDireccionOrigen;
    private javax.swing.JTextField txtDireccionDestino;
    private javax.swing.JTextField txtDireccionOrigen;
    // End of variables declaration//GEN-END:variables
}
