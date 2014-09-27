package Controladores;
import Modelos.Examen;
import Modelos.ExamenTex;
import Modelos.PreguntasTex;
import java.util.ArrayList;
//import Vistas.CrearExamen;
//import java.io.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
/**
 *
 * @author miguelhernandez
 */
public class CtrlCrearExamen {
    
    private String direccionDestino;
    
    /**
     * Se encarga de crear el examen usando los modelos necesarios
     * @param direccion La ruta al archivo LaTeX proporcionada
     * 
     */
    public CtrlCrearExamen(String direccion){
        this.direccionDestino = "/Users/miguelhernandez/Desktop/nuevoExamen.tex";
        
        PreguntasTex PT = new PreguntasTex();
        Examen examen= new Examen() ;
        examen=PT.separarPreguntasTex(direccion);
        
        ExamenTex ET;
        ET = new ExamenTex(direccionDestino,examen);
        
        
    }
}
