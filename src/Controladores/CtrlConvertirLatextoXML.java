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
     * Se encarga de la conversion del examen XML dado uno en LaTeX
     * @param direccionOrigen la direccion del examen en LaTeX
     * @param direccionDestino la direccion donde se generara el examen XML
     */
    public CtrlConvertirLatextoXML(String direccionOrigen,String direccionDestino){
        direccionDestino = direccionDestino + "/nuevoExamen.xml";
        
        //Crea una instancia de PreguntasTex para separar las preguntas 
        PreguntasTex PT = new PreguntasTex();
        //Crea una instancia de ExamenTex donde guardar el examen creado por 
        //separar preguntas
        Examen examen= new Examen(); 
        examen=PT.separarPreguntasTex(direccionOrigen);
        examen=PT.obtenertipoPregunta(examen);
        
        //Se crea una instancia de la clase ExamenXML
        ExamenXML EXML = new ExamenXML();
        
        EXML.generarCabecera(direccionDestino);
        EXML.generarExamenXML(direccionDestino, examen);
        EXML.generarFinalExamen(direccionDestino);
        
        
        
        
    }
    
}
