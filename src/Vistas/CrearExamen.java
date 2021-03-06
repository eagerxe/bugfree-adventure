package Vistas;

import Controladores.CtrlCrearExamen;
import Controladores.CtrlInicio;
import java.awt.BorderLayout;
import java.awt.Insets;
import java.io.File;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;

/**
 * Vista Crear Examen
 *
 * @author miguelhernandez
 */
public class CrearExamen extends javax.swing.JFrame {

    DefaultListModel lista;
    JFileChooser fc;
    JTextArea log;
    String nombreExamenTex = null;

    /**
     * Crea la nueva forma CrearExamen
     */
    public CrearExamen() {
        initComponents();
        lista = new DefaultListModel();
        jList1.setModel(lista);
        //Cambia el modelo del ComboBox default
        comboNumeroPreguntas.setModel(new javax.swing.DefaultComboBoxModel(new String[]{"5", "10", "15", "20", "Ingresar un número", "Todas"}));
        lblNumeroPreguntas.setVisible(false);
        txtNumeroPreguntas.setVisible(false);
        lblOrdenAleatorio.setVisible(false);
        cBoxOrdenAleatorio.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCrearExamen = new javax.swing.JLabel();
        btnCrearExamen = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblMensaje = new javax.swing.JLabel();
        lblOrdenAleatorio = new javax.swing.JLabel();
        lblNumeroDePreguntas = new javax.swing.JLabel();
        cBoxOrdenAleatorio = new javax.swing.JCheckBox();
        comboNumeroPreguntas = new javax.swing.JComboBox();
        lblEscojaOpciones = new javax.swing.JLabel();
        lblNumeroPreguntas = new javax.swing.JLabel();
        txtNumeroPreguntas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        btnAgregarExamenLatex = new javax.swing.JButton();
        btnEliminarExamenLista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setPreferredSize(new java.awt.Dimension(1280, 720));

        lblCrearExamen.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        lblCrearExamen.setText("Mezclar exámenes LaTeX");

        btnCrearExamen.setText("Guardar examen");
        btnCrearExamen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearExamenActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblMensaje.setText("Agregue los exámenes que desea mezclar");

        lblOrdenAleatorio.setText("Orden aleatorio de las preguntas:");

        lblNumeroDePreguntas.setText("Número de preguntas de de cada examen:");

        comboNumeroPreguntas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboNumeroPreguntas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboNumeroPreguntasActionPerformed(evt);
            }
        });

        lblEscojaOpciones.setText("Opciones");

        lblNumeroPreguntas.setText("Número de preguntas:");

        jScrollPane1.setViewportView(jList1);

        btnAgregarExamenLatex.setText("Agregar examen");
        btnAgregarExamenLatex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarExamenLatexActionPerformed(evt);
            }
        });

        btnEliminarExamenLista.setText("Eliminar examen");
        btnEliminarExamenLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarExamenListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(478, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblEscojaOpciones)
                        .addGap(373, 373, 373))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lblNumeroPreguntas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnCrearExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cBoxOrdenAleatorio)
                                                .addComponent(txtNumeroPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(comboNumeroPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNumeroDePreguntas)
                                        .addComponent(lblOrdenAleatorio)
                                        .addComponent(lblMensaje)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblCrearExamen)
                                .addGap(94, 94, 94)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAgregarExamenLatex, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminarExamenLista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(284, 284, 284))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(lblCrearExamen)
                .addGap(33, 33, 33)
                .addComponent(lblMensaje)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregarExamenLatex)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarExamenLista))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblEscojaOpciones)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNumeroDePreguntas)
                    .addComponent(comboNumeroPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblOrdenAleatorio)
                    .addComponent(cBoxOrdenAleatorio))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumeroPreguntas)
                    .addComponent(txtNumeroPreguntas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 147, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrearExamen, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Crea una instancia del controlador de CrearExamen al cual pasa las
     * direcciones
     *
     * @param evt Evento sobre el botón para crear el examen
     */
    private void btnCrearExamenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearExamenActionPerformed
        //Crear el log
        log = new JTextArea(5, 20);
        log.setMargin(new Insets(5, 5, 5, 5));
        log.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(log);
        add(logScrollPane, BorderLayout.CENTER);

        CtrlCrearExamen CCE;
        String direccionDestino = null;

        fc = new JFileChooser();

        //Opciones
        String numeroP = (String) comboNumeroPreguntas.getSelectedItem();
        if (numeroP.contains("Ingresar")) {
            numeroP = txtNumeroPreguntas.getText();
        }
        Boolean aleatorio = cBoxOrdenAleatorio.isSelected();

        //Obtener direcciones del jlist1
        System.out.println(jList1.getModel());

        ArrayList<String> direccionesOrigen = new ArrayList<>();

        int numeroElementos = jList1.getModel().getSize();
        for (int i = 0; i < numeroElementos; i++) {
            direccionesOrigen.add(i, (String) jList1.getModel().getElementAt(i));
            System.out.println(direccionesOrigen.get(i));
        }
        //direccionesOrigen = (ArrayList<String>) jList1.getModel();
        if (numeroElementos > 0) {

            int returnVal = fc.showSaveDialog(this);
            
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                
                
                File file = fc.getSelectedFile();
                //agregar extension
                //String nombreTex= file.getName()+".tex";
                //String filePath=file.getPath();
                
                if(!file.getName().toLowerCase().endsWith(".tex")){
                    direccionDestino = file.getAbsolutePath()+".tex";
                }else{
                    
                    direccionDestino = file.getAbsolutePath();
                }
                
                File archivoTex = new File(direccionDestino);
                
                if (archivoTex.getName().toLowerCase().endsWith(".tex")) {
                    if (archivoTex.exists()) {
                        showMessageDialog(null, "Ese nombre de examen ya existe en la ruta especificada");
                    } else {

                        //direccionDestino = file.getAbsolutePath();
                        //log.append("Guardando: " + file.getName());
                        
                        CCE = new CtrlCrearExamen(direccionesOrigen, direccionDestino, aleatorio, numeroP);
                    }

                } else if (archivoTex.getName().isEmpty()) {
                    showMessageDialog(null, "Debe escribir el nombre del examen LaTeX");
                } else {
                    showMessageDialog(null, "La terminación del nombre del examen debe ser .tex");
                }

            } else {
                log.append("Cancelando");
            }
        } else {
            showMessageDialog(null, "Necesita agregar al menos un examen LaTeX");

        }
        //checar si el examen fue creado
        //dispose();
    }//GEN-LAST:event_btnCrearExamenActionPerformed
    /**
     * Boton para cancelar y regresar a la vista Inicio
     *
     * @param evt Evento sobre el botón para cancelar y volver al inicio
     */
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        CtrlInicio CI = new CtrlInicio(4);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    /**
     * ComboBox para elegir el numero de preguntas
     *
     * @param evt Evento sobre el ComboBox para elegir el numero de preguntas
     */
    private void comboNumeroPreguntasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboNumeroPreguntasActionPerformed

        if (comboNumeroPreguntas.getSelectedItem().toString().contains("Ingresar un número")) {

            lblNumeroPreguntas.setVisible(true);
            txtNumeroPreguntas.setVisible(true);

            lblOrdenAleatorio.setVisible(false);
            cBoxOrdenAleatorio.setVisible(false);

            String numeroPreguntas = JOptionPane.showInputDialog("Escriba el número de preguntas que desea de cada examen: ");
            //checar si tiene un numero
            if (esNumeroPositivo(numeroPreguntas)) {
                int numeroP = parseInt(numeroPreguntas);
                if (numeroP > 0) {
                    txtNumeroPreguntas.setText(numeroPreguntas);
                    txtNumeroPreguntas.setEditable(false);
                } else {
                    showMessageDialog(null, "Necesita especificar un número mayor a 0");
                }

            } else {
                showMessageDialog(null, "Necesita especificar un número");
            }

        } else if (comboNumeroPreguntas.getSelectedItem().toString().contains("Todas")) {
            lblOrdenAleatorio.setVisible(true);
            cBoxOrdenAleatorio.setVisible(true);
            lblNumeroPreguntas.setVisible(false);
            txtNumeroPreguntas.setVisible(false);

        } else {
            lblNumeroPreguntas.setVisible(false);
            txtNumeroPreguntas.setVisible(false);
            lblOrdenAleatorio.setVisible(false);
            cBoxOrdenAleatorio.setVisible(false);
        }

    }//GEN-LAST:event_comboNumeroPreguntasActionPerformed

    private void btnAgregarExamenLatexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarExamenLatexActionPerformed
        JFileChooser escogerDireccion = new JFileChooser();
        escogerDireccion.showOpenDialog(this);
        String direc = escogerDireccion.getSelectedFile().getAbsolutePath();
        File archivo = new File(direc);
        String nombreBuscar=archivo.getName();
        int encontrado = 0;
        ListModel model = jList1.getModel();
        for (int i = 0; i < model.getSize(); i++) {
            String direccion;
            direccion = (String) model.getElementAt(i);
            
            if (direccion.contains(nombreBuscar)){
                encontrado++;
                
            }
            
        }
        if(encontrado>0){
            showMessageDialog(null, "El examen "+ nombreBuscar +" ya fue agregado");
        }else if (direc.contains(".tex")) {
            //checar si existe el archivo 
            
            
            if (archivo.exists()) {
                lista.addElement(direc);
            } else {
                showMessageDialog(null, "El examen no existe en la ruta especificada");
            }

        } else {
            showMessageDialog(null, "Tiene que elegir un examen LaTeX");
        }

    }//GEN-LAST:event_btnAgregarExamenLatexActionPerformed

    private void btnEliminarExamenListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarExamenListaActionPerformed
        int index = jList1.getSelectedIndex();
        if (index >= 0) {
            lista.remove(index);
        } else {
            showMessageDialog(this, "No es posible eliminar");
        }
    }//GEN-LAST:event_btnEliminarExamenListaActionPerformed
    /**
     * Para saber si una cadena contiene un número positivo
     * @param cadena cadena a analizar
     * @return true si la cadena tiene un número positivo
     */
    public static boolean esNumeroPositivo(String cadena) {
        if (cadena.isEmpty()) {
            return false;
        }

        if (cadena.charAt(0) == '-') {
            return false;
        }
        for (int i = 0; i < cadena.length(); i++) {
            if (!Character.isDigit(cadena.charAt(i))) {
                return false;
            }
        }
        return true;
    }

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
            java.util.logging.Logger.getLogger(CrearExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearExamen().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarExamenLatex;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearExamen;
    private javax.swing.JButton btnEliminarExamenLista;
    private javax.swing.JCheckBox cBoxOrdenAleatorio;
    private javax.swing.JComboBox comboNumeroPreguntas;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCrearExamen;
    private javax.swing.JLabel lblEscojaOpciones;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNumeroDePreguntas;
    private javax.swing.JLabel lblNumeroPreguntas;
    private javax.swing.JLabel lblOrdenAleatorio;
    private javax.swing.JTextField txtNumeroPreguntas;
    // End of variables declaration//GEN-END:variables
}
