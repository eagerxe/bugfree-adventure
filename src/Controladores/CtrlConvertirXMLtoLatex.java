package Controladores;

import Modelos.Examen;
import Modelos.ExamenTex;
import Modelos.PreguntasXML;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * Controlador para convertir un examen XML Moodle a LaTeX 
 * @author miguelhernandez
 */
public class CtrlConvertirXMLtoLatex {
    
    
    /**
     * Comunica la vista ConvertirXMLLatex con los modelos para generar un examen
     * en Latex a partir de uno en XML Moodle.
     * @param direccionOrigen la direccion del examen en XML
     * @param direccionDestino la direccion donde se generara el examen LaTeX 
     * @param direccionPadre la direccion de la carpeta destino del exmaen
     */
    public CtrlConvertirXMLtoLatex(String direccionOrigen,String direccionDestino,String direccionPadre){
        
        
        ExamenTex ET = new ExamenTex();
        PreguntasXML PXML = new PreguntasXML();
        
        Examen examen= new Examen();
        examen = PXML.separarPreguntasXML(direccionOrigen,direccionPadre);
        
        ET.generarCabecera(direccionDestino);
        
        ET.generarExamenTexXML(direccionDestino, examen);
        ET.generarFinalExamen(direccionDestino);
        showMessageDialog(null, "Examen creado y guardado");
    }
    
    
}
