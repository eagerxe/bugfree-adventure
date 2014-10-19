package Controladores;

import Modelos.Examen;
import Modelos.ExamenTex;
import Modelos.ExamenXML;
import Modelos.Pregunta;
import Modelos.PreguntasTex;
import Modelos.PreguntasXML;
import java.util.ArrayList;

/**
 *
 * @author miguelhernandez
 */
public class CtrlCExamen {
    Examen examen;
    Pregunta P;
    
    public CtrlCExamen(){
        examen = new Examen();
    }
    public void agregarPreguntaAExamen(String tipo,String pregunta,ArrayList<String> respuestas,ArrayList<String> distractores){
        P =  new Pregunta();
        P.setTipo(tipo);
        P.setPregunta(pregunta);
        P.setRespuesta(respuestas.get(0));
        P.setListaRespuestasCorrectas(respuestas);
        P.setListaRespuestas(distractores);
        
        examen.setPreguntaALista(P);
        
    }
    
    public void generarExamenTex(String tipo,String direccionDestino){
        if (tipo.contains("XML")){
            direccionDestino = direccionDestino + "/nuevoExamen.xml";
            //Se crea una instancia de la clase ExamenXML para generar el examen
            ExamenXML EXML = new ExamenXML();

            EXML.generarCabecera(direccionDestino);
            EXML.generarExamenXML(direccionDestino, examen);
            EXML.generarFinalExamen(direccionDestino);
            
        }else if (tipo.contains("LaTeX")){
            direccionDestino = direccionDestino + "/nuevoExamen.tex";
            
            ExamenTex ET = new ExamenTex();
            
            ET.generarCabecera(direccionDestino);
            ET.generarExamenTexXML(direccionDestino,examen);
            ET.generarFinalExamen(direccionDestino);
            
        }
        
    }
    
}
