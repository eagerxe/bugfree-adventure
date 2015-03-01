package Controladores;

import Modelos.ExamenTex;
import Modelos.PreguntasXML;

/**
 *
 * @author miguelhernandez
 */
public class CtrlConvertirXMLtoLatex {
    
    
    /**
     * Comunica la vista ConvertirXMLLatex con los modelos para generar un examen
     * en Latex a partir de uno en XML Moodle.
     * @param direccionOrigen la direccion del examen en XML
     * @param direccionDestino la direccion donde se generara el examen LaTeX 
     */
    public CtrlConvertirXMLtoLatex(String direccionOrigen,String direccionDestino){
        
        String direccionDestinoExamenTex = direccionDestino + "/nuevoExamen.tex";
        ExamenTex ET = new ExamenTex();
        PreguntasXML PXML = new PreguntasXML();
        
        ET.generarCabecera(direccionDestinoExamenTex);
        ET.generarExamenTexXML(direccionDestinoExamenTex,PXML.separarPreguntasXML(direccionOrigen,direccionDestino) );
        ET.generarFinalExamen(direccionDestinoExamenTex);
        
    }
    
    
}
