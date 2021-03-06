package Vistas;

import Controladores.CtrlConvertirLatextoXML;
import Controladores.CtrlCrearExamen;
import Controladores.CtrlInicio;
import java.io.File;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Vista ConvertirLatexXML
 *
 * @author miguelhernandez
 */
public class ConvertirLatexXML extends javax.swing.JFrame {

    private String direccionPadre;

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

        lblDireccionOrigen.setText("Examen LaTeX:");

        btnAgregarArchivo.setText("Agregar examen");
        btnAgregarArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarArchivoActionPerformed(evt);
            }
        });

        lblAgregueDireccion.setText("Agregue el examen LaTeX");

        btnConvertirExamen.setText("Guardar examen");
        btnConvertirExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertirExamenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(340, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnConvertirExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDireccionOrigen)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgregueDireccion)
                            .addComponent(lblConvertirExamenLtoX)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtDireccionOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregarArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(216, 216, 216))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(lblConvertirExamenLtoX)
                .addGap(57, 57, 57)
                .addComponent(lblAgregueDireccion)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDireccionOrigen)
                    .addComponent(txtDireccionOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarArchivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 320, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConvertirExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Botón para cancelar y regresar a la vista Inicio
     *
     * @param evt Evento sobre el botón para regresar al inicio
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        CtrlInicio CI = new CtrlInicio(4);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    /**
     * Muestra una ventana para escoger el archivo
     *
     * @param evt Evento sobre el botón para escoger el archivo
     */
    private void btnAgregarArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarArchivoActionPerformed
        JFileChooser escogerDireccion = new JFileChooser();
        escogerDireccion.showOpenDialog(this);
        String direc = escogerDireccion.getSelectedFile().getAbsolutePath();
        //Obtener la direccion de la carpeta padre para encontrar ahi las imagenes
        direccionPadre = escogerDireccion.getSelectedFile().getParent();

        if (direc.contains(".tex")) {
            //checar si existe el archivo 
            File archivo = new File(direc);
            if (archivo.exists()) {
                txtDireccionOrigen.setText(direc);
                txtDireccionOrigen.setEditable(false);
            } else {
                showMessageDialog(null, "El examen no existe en la ruta especificada");
            }

        } else {
            showMessageDialog(null, "Tiene que elegir un examen LaTeX");
        }


    }//GEN-LAST:event_btnAgregarArchivoActionPerformed

    /**
     * Botón para comenzar con la conversion del examen LaTeX a XML Moodle
     *
     * @param evt Evento sobre el boton para iniciar la conversión
     */
    private void btnConvertirExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertirExamenActionPerformed
        String direccionOrigen, direccionDestino;
        direccionOrigen = txtDireccionOrigen.getText();

        JFileChooser fc = new JFileChooser();

        if (!direccionOrigen.isEmpty()) {

            int returnVal = fc.showSaveDialog(this);

            if (returnVal == JFileChooser.APPROVE_OPTION) {

                File file = fc.getSelectedFile();

                if (!file.getName().toLowerCase().endsWith(".xml")) {
                    direccionDestino = file.getAbsolutePath() + ".xml";
                } else {

                    direccionDestino = file.getAbsolutePath();
                }

                File archivoXML = new File(direccionDestino);

                if (archivoXML.getName().contains(".xml")) {
                    if (archivoXML.exists()) {
                        showMessageDialog(null, "Ese nombre de examen ya existe en la ruta especificada");
                    } else {

                        //direccionDestino = file.getAbsolutePath();
                        //direccionDestino=txtDireccionDestino.getText();
                        CtrlConvertirLatextoXML CLTX = new CtrlConvertirLatextoXML(direccionOrigen, direccionDestino, direccionPadre);

                    }

                } else if (archivoXML.getName().isEmpty()) {
                    showMessageDialog(null, "Debe escribir el nombre del examen Moodle XML");
                } else {
                    showMessageDialog(null, "La terminación del nombre del examen debe ser .xml");
                }

            } else {
                //log.append("Cancelando");
            }
        } else {
            showMessageDialog(null, "Necesita agregar un examen LaTeX");

        }

        //showMessageDialog(null, "Examen creado");
        //dispose();
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
    private javax.swing.JLabel lblAgregueDireccion;
    private javax.swing.JLabel lblConvertirExamenLtoX;
    private javax.swing.JLabel lblDireccionOrigen;
    private javax.swing.JTextField txtDireccionOrigen;
    // End of variables declaration//GEN-END:variables
}
