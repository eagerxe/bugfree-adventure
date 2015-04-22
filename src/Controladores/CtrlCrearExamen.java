package Controladores;

import Modelos.Examen;
import Modelos.ExamenTex;
import Modelos.PreguntasTex;
import java.io.File;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author miguelhernandez
 */
public final class CtrlCrearExamen {

    ExamenTex ET = new ExamenTex();

    /**
     * Se encarga de crear el examen a partir de otro examen en LaTeX
     * @param direccion Direccion del examen origen
     * @param direccionDestino Direccion donde se localizará el nuevo examen
     * @param aleatorio Indica si se desea orden aleatorio de las preguntas
     * @param numeroPreguntas El número de preguntas del examen final
     * @return true si el numero de preguntas en el examen
     * es menor al numero de preguntas que se solicitó
     */
    public boolean crearExamen(String direccion, String direccionDestino, Boolean aleatorio, String numeroPreguntas) {
        boolean sobrepasaNumeroP=false;
        int numeroPregunta = 0;
        //Crea una instancia de PreguntasTex para separar las preguntas 
        PreguntasTex PT = new PreguntasTex();
        //Crea una instancia de ExamenTex donde guardar el examen creado por 
        //separar preguntas
        Examen examen = new Examen();
        examen = PT.separarPreguntasTex(direccion);

        int numeroPreguntasExamen = examen.getListaPreguntasSeparadas().size();

        //Se realiza el orden aleatorio al examen
        if (aleatorio) {
            examen = examen.ordenAleatorio(examen);
        }

        //Se escogen solo n preguntas del examen
        if (numeroPreguntas.contains("Todas")) {
            System.out.println("todas las preguntas");
        } else {
            numeroPregunta = Integer.parseInt(numeroPreguntas);
            if (numeroPreguntasExamen < numeroPregunta) {
                sobrepasaNumeroP=true;
                numeroPregunta = numeroPreguntasExamen;
                examen = examen.escogerNPreguntas(examen, numeroPregunta);
            } else {
                examen = examen.escogerNPreguntas(examen, numeroPregunta);
            }
        }

        ET.generarExamenTex(direccionDestino, examen);
        return sobrepasaNumeroP;
        
    }

    /**
     *
     * @param direccionesOrigen La lista de las ubicaciones de los examenes
     * LaTeX
     * @param direccionDestino Direccion donde se localizará el nuevo examen
     * @param aleatorio Indica si se desea orden aleatorio de las preguntas
     * @param numeroP El numero de preguntas de que se escogerá de cada examen
     */
    public CtrlCrearExamen(ArrayList<String> direccionesOrigen, String direccionDestino, Boolean aleatorio, String numeroP) {
        boolean sobrepasoP=false;
        int numeroExamenes = direccionesOrigen.size();

        ET.generarCabecera(direccionDestino);

        for (int i = 0; i < numeroExamenes; i++) {
            
            String direccionOrigen = direccionesOrigen.get(i);
            
            sobrepasoP = this.crearExamen(direccionOrigen, direccionDestino, aleatorio, numeroP);
            if (sobrepasoP) {
                File examen = new File(direccionOrigen);
                String nombre = examen.getName();
                showMessageDialog(null, "El número de preguntas solicitado es "
                        + "mayor al número de preguntas del examen\n"+ nombre 
                        +", así que se uso el total de preguntas del examen "
                        + "para la mezcla");
            } 
            
        }

        ET.generarFinalExamen(direccionDestino);
        showMessageDialog(null, "Examen creado y guardado");
        
        
        
    }

}
