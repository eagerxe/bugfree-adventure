package Modelos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author miguelhernandez
 */
public class ExamenTex {
    private String linea = null;
    private Examen examen = new Examen();
    private ArrayList<Pregunta> listaPreguntas = new ArrayList();
    private ArrayList <String> lineasPregunta = new ArrayList();
    
    
    /**
     * Escribe la lista de preguntas guardadas a un examen en LaTeX en la 
     * direccion destino
     * @param direccionDestino Ubicacion donde se creara el examen en LaTeX
     * @param examen contiene la lista de preguntas separadas que tendra el 
     * examen
     */
    public ExamenTex(String direccionDestino,Examen examen){
        this.examen=examen;
        try{
        
            PrintWriter pw 
            = new PrintWriter(new BufferedWriter(new FileWriter(direccionDestino)));
        
                
                //cabecera del examen
                pw.write("\\documentclass [addpoints,100pt]{exam}"
                        + "\n"
                        + "\t\\begin{center}\n"
                        + "\t\\fbox {\\fbox{\\parbox{5.5 in}{\\centering\n"
                        + "\tInstrucciones: Responde las preguntas siguientes.}}}\n"
                        + "\t\\end{center}\n"
                        + "\t\\vspace {0.1 in}\n"
                        + "\t\\makebox[\\textwidth]{Nombre del alumno: \\enspace \\hrulefill}\n"
                        + "\t\\vspace{0.2in}\n"
                        + "\t\\makebox[\\textwidth]{Nombre del profesor: \\enspace \\hrulefill}\n"
                        + "\t\\begin{questions}\n");
                
                //obtiene la lista de preguntas del examen
                listaPreguntas = this.examen.getListaPreguntasSeparadas();
                int numeroPreguntas = listaPreguntas.size();
                int i =0;
                //obtiene las preguntas de la lista y las lineas de la pregunta
                for(i=0;i<numeroPreguntas;i++){
                    Pregunta P = new Pregunta();
                    P=listaPreguntas.get(i);
                    
                    lineasPregunta = P.getListaPreguntas();
                    int numeroLineas = lineasPregunta.size();
                    //escribe en el examen las lineas de cada pregunta
                    for (int j=0; j<numeroLineas;j++){
                        linea = lineasPregunta.get(j);
                        pw.write(linea);
                        pw.write("\n");
                    }
                    
                }
                //final del examen
                pw.write("\t\\end{questions}\n");
                pw.write("\\end{document}");
                
        pw.close();
        }catch(IOException er){
            System.out.println("Excepcion en los flujos "+er.getMessage());
        }
        
        
        
        
    }
}
