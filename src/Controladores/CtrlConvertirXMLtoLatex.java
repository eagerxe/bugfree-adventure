package Controladores;

import Modelos.PreguntasXML;

/**
 *
 * @author miguelhernandez
 */
public class CtrlConvertirXMLtoLatex {
    
    
    /**
     * Se encarga de 
     * @param direccionOrigen la direccion del examen en XML
     * @param direccionDestino la direccion donde se generara el examen LaTeX 
     */
    public CtrlConvertirXMLtoLatex(String direccionOrigen,String direccionDestino){
        direccionDestino = direccionDestino + "/nuevoExamen.tex";
        
        PreguntasXML PXML = new PreguntasXML();
        PXML.separarPreguntasXML(direccionOrigen);
        
    }
    
    
}
