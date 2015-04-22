package Controladores;

import Modelos.Examen;
import Modelos.ExamenTex;
import Modelos.ExamenXML;
import Modelos.Pregunta;
import Modelos.PreguntasTex;
import Modelos.PreguntasXML;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Para crear un examen LaTeX o XMLMoodle
 * @author miguelhernandez
 */
public class CtrlCExamen {
    Examen examen;
    Pregunta P;
    
    /**
     * 
     */
    public CtrlCExamen(){
        examen = new Examen();
    }
    /**
     * Agrega las preguntas al examen 
     * @param tipo el tipo de pregunta
     * @param pregunta La oracion de la pregunta
     * @param respuestas la respuesta o respuestas correctas
     * @param distractores los distractores de la pregunta 
     */
    public void agregarPreguntaAExamen(String tipo,String pregunta,ArrayList<String> respuestas,ArrayList<String> distractores){
        P =  new Pregunta();
        P.setTipo(tipo);
        P.setPregunta(pregunta);
        P.setRespuesta(respuestas.get(0));
        P.setListaRespuestasCorrectas(respuestas);
        P.setListaRespuestas(distractores);
        
        examen.setPreguntaALista(P);
        
    }
    /**
     * Genera los examenes en LaTeX o Moodle XML
     * @param tipoExamen Tipo de examen XML o LaTeX
     * @param direccionDestino La dirección destino del examen
     */
    public void generarExamen(String tipoExamen,String direccionDestino){
        if (tipoExamen.contains("XML")){
            
            //Se crea una instancia de la clase ExamenXML para generar el examen
            ExamenXML EXML = new ExamenXML();

            EXML.generarCabecera(direccionDestino);
            EXML.generarExamenXML(direccionDestino, examen);
            EXML.generarFinalExamen(direccionDestino);
            showMessageDialog(null, "Examen guardado en la ruta especificada");
        }else if (tipoExamen.contains("LaTeX")){
            
            
            ExamenTex ET = new ExamenTex();
            
            ET.generarCabecera(direccionDestino);
            ET.generarExamenTexXML(direccionDestino,examen);
            ET.generarFinalExamen(direccionDestino);
            showMessageDialog(null, "Examen guardado en la ruta especificada");
        }
        
    }
    /**
     * Para agregar las preguntas al examen LaTeX
     * @param direccionDestino la direccion del examen LaTeX al cual le serán 
     * agregadas las preguntas
     */
    public void agregarExamen(String direccionDestino) {
            ExamenTex ET = new ExamenTex();
            ET.borrarFinalExamen(direccionDestino);
            ET.generarExamenTexXML(direccionDestino, examen);
            ET.generarFinalExamen(direccionDestino);
            showMessageDialog(null, "Pregunta(s) agregada(s) en el examen LaTeX");
    }
    
}
