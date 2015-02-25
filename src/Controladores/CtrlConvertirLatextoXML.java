package Controladores;

import Modelos.Examen;
import Modelos.ExamenXML;
import Modelos.PreguntasTex;

/**
 *
 * @author miguelhernandez
 */
public class CtrlConvertirLatextoXML {
    
    
    
    /**
     * Se encarga de convertir un examen en Latex a XML Moodle
     * @param direccionOrigen la direccion del examen en LaTeX
     * @param direccionDestino la direccion donde se generara el examen XML
     */
    public CtrlConvertirLatextoXML(String direccionOrigen,String direccionDestino,String direccionPadre){
        direccionDestino = direccionDestino + "/nuevoExamen.xml";
        
        //Crea una instancia de PreguntasTex para separar las preguntas 
        PreguntasTex PT = new PreguntasTex();
        //Crea una instancia de ExamenTex donde guardar el examen creado por 
        //separar preguntas
        Examen examen= new Examen(); 
        examen=PT.separarPreguntasTex(direccionOrigen);
        examen=PT.obtenertipoPregunta(examen,direccionPadre);
        
        //Se crea una instancia de la clase ExamenXML para generar el examen
        ExamenXML EXML = new ExamenXML();
        
        EXML.generarCabecera(direccionDestino);
        EXML.generarExamenXML(direccionDestino, examen);
        EXML.generarFinalExamen(direccionDestino);
        
        
    }
    
}
