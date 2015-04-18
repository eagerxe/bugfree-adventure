package Controladores;

import Modelos.Examen;
import Modelos.ExamenXML;
import Modelos.PreguntasTex;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author miguelhernandez
 */
public class CtrlConvertirLatextoXML {
    
    
    
    /**
     * Controlador para convertir un examen LaTeX a Moodle XMl 
     * @param direccionOrigen la direccion del examen en LaTeX
     * @param direccionDestino la direccion donde se generara el examen XML
     * @param direccionPadre la direccion del directorio donde se encuentra el 
     * examen origen 
     */
    public CtrlConvertirLatextoXML(String direccionOrigen,String direccionDestino,String direccionPadre){
        
        
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
        showMessageDialog(null, "Examen creado y guardado");
        //CtrlInicio CI = new CtrlInicio(4);
        
    }
    
}
