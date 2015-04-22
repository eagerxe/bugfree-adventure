package Modelos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase para generar el examen en LaTeX
 * @author miguelhernandez
 */
public class ExamenTex {
    private String linea;
    private ArrayList<Pregunta> listaPreguntas;
    private ArrayList <String> lineasPregunta;
    
    
    
    public ExamenTex(){
        linea = null;
        listaPreguntas = null;
        lineasPregunta = null;
    }
    
    
    /**
     * Genera la cabecera del examen
     * @param direccionDestino Ubicacion donde se creara el examen en LaTeX
     */
    public void generarCabecera(String direccionDestino){
        try{
            PrintWriter pw 
            = new PrintWriter(new BufferedWriter(new FileWriter(direccionDestino)));
                //cabecera del examen
                pw.write("\\documentclass [addpoints,100pt]{exam}\n"
                        + "\\usepackage{graphicx}\n"
                        + "\\usepackage[utf8]{inputenc}\n"
                        + "\\begin{document}\n"
                        + "\t\\begin{center}\n"
                        + "\t\\fbox {\\fbox{\\parbox{5.5 in}{\\centering\n"
                        + "\tInstrucciones: Responde las preguntas siguientes.}}}\n"
                        + "\t\\end{center}\n"
                        + "\t\\vspace {0.1 in}\n"
                        + "\t\\makebox[\\textwidth]{Nombre del alumno: \\enspace \\hrulefill}\n"
                        + "\t\\vspace{0.2in}\n"
                        + "\t\\makebox[\\textwidth]{Nombre del profesor: \\enspace \\hrulefill}\n"
                        + "\t\\begin{questions}\n");
        pw.close();
        }catch(IOException er){
            System.out.println("Excepcion en flujos para crear la cabecera del examen "+er.getMessage());
        }
    }
    
    
    /**
     * Escribe la lista de preguntas guardadas a un examen en LaTeX en la 
     * direccion destino
     * @param direccionDestino Ubicacion donde se creara el examen en LaTeX
     * @param examen contiene la lista de preguntas separadas que tendra el 
     * examen
     */
    public void generarExamenTex(String direccionDestino,Examen examen){
        linea = null;
        listaPreguntas = new ArrayList();
        lineasPregunta = new ArrayList();
        try{
            
            PrintWriter pw 
            = new PrintWriter(new BufferedWriter(new FileWriter(direccionDestino,true)));
         
                //obtiene la lista de preguntas del examen
                listaPreguntas = examen.getListaPreguntasSeparadas();
                int numeroPreguntas = listaPreguntas.size();
                
                //obtiene las preguntas de la lista y las lineas de la pregunta
                for(int i=0;i<numeroPreguntas;i++){
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
                
        pw.close();
        }catch(IOException er){
            System.out.println("Excepcion en los flujos al generar examen "+er.getMessage());
        }
        
      
    }
    /**
     * Genera el final de examen
     * @param direccionDestino direccion donde se ubica el examen
     */
    public void generarFinalExamen(String direccionDestino){
        try{
            PrintWriter pw 
            = new PrintWriter(new BufferedWriter(new FileWriter(direccionDestino,true)));   
                //final del examen
                pw.write("\t\\end{questions}\n");
                pw.write("\\end{document}");
        pw.close();        
        }catch(IOException er){
            System.out.println("Excepcion en el final del examen "+er.getMessage());
        }
    }
    /**
     * Para generar un examen Tex a partir de un XML
     * @param direccionDestino la direccion donde se generará el examen tex
     * @param examen el examen que contiene las preguntas con las que se generará
     * el nuevo examen
     */
    public void generarExamenTexXML(String direccionDestino,Examen examen){
        linea = null;
        listaPreguntas = new ArrayList();
        lineasPregunta = new ArrayList();
        try{
            
            PrintWriter pw 
            = new PrintWriter(new BufferedWriter(new FileWriter(direccionDestino,true)));
            
            //obtiene la lista de preguntas del examen
            listaPreguntas = examen.getListaPreguntasSeparadas();
            int numeroPreguntas = listaPreguntas.size();
            //obtiene las preguntas de la lista y las lineas de la pregunta
            for(int i=0;i<numeroPreguntas;i++){
                Pregunta P = new Pregunta();
                P=listaPreguntas.get(i);
                if(P.getTipoPregunta().contains("multichoice")){
                    pw.write("\t\\question{\n");
                    pw.write("\t"+ P.getPregunta() +"\n\t}\n");
                    pw.write("\t\\vspace {0.1 in}\n");
                    pw.write("\t\\begin{choices}\n");
                    //Escribir la respuesta correcta aleatoriamente
                    ArrayList<String> listaAleatorio= new ArrayList();
                    //Agrego respuestas incorrectas
                    listaAleatorio=P.getListaRespuestas();
                    //agrego respuestas correctas
                    boolean addAll = listaAleatorio.addAll(P.getListaRespuestasCorrectas());
                    //listaAleatorio.add(P.getRespuesta());
                    
                    //genera en orden aleatorio
                    int nPreguntas = listaAleatorio.size();
                    int aleatorio;
                    for (int j=0;j<nPreguntas;j++){
                      aleatorio =(int) Math.floor(Math.random()*(listaAleatorio.size()));
                      
                      //checar si la respuesta es una respuesta correcta 
                      String esCorrecta = listaAleatorio.get(aleatorio);
                      Boolean esCorrectaB=false;
                      int numeroCorrectas=P.getListaRespuestasCorrectas().size();
                      
                      for(int k=0;k<numeroCorrectas;k++){
                          String auxiliar =(String) P.getListaRespuestasCorrectas().get(k);
                          if(auxiliar.equalsIgnoreCase(esCorrecta)){
                              esCorrectaB=true;
                          }
                      }
                      //si esCorrectaB es true entonces la respuesta es correcta
                      if (esCorrectaB){
                          
                          
                          pw.write("\t\\CorrectChoice " + esCorrecta +"\n");
                          
                      }else{
                          
                          pw.write("\t\\choice " + esCorrecta + "\n");
                      
                      }
                      //quita de la listaAleatorio el elemento aleatorio
                      String remove = listaAleatorio.remove(aleatorio);
                        
                    }
                    pw.write("\t\\end{choices}\n");
                    //pw.write("\t\\answerline\n");
                //pregunta de tipo verdadero o falso    
                }else if(P.getTipoPregunta().contains("truefalse")){
                    
                    pw.write("\t\\question{\n");
                    pw.write("\t"+ P.getPregunta() +"\n\t}\n");
                    pw.write("\t\\vspace {0.1 in}\n");
                    pw.write("\t\\begin{oneparcheckboxes}\n");
                    //respuesta verdadera o falsa
                    if(P.getRespuesta().contains("true")){
                        pw.write("\t\\CorrectChoice Verdadero\n");
                        pw.write("\t\\choice Falso\n");
                    }else if(P.getRespuesta().contains("false")){
                        pw.write("\t\\choice Verdadero\n");
                        pw.write("\t\\CorrectChoice Falso\n");
                    }else if (P.getRespuesta().contains("Verdadero")){
                        pw.write("\t\\CorrectChoice Verdadero\n");
                        pw.write("\t\\choice Falso\n");
                    }else if(P.getRespuesta().contains("Falso")){
                        pw.write("\t\\choice Verdadero\n");
                        pw.write("\t\\CorrectChoice Falso\n");
                    }
                    
                    pw.write("\t\\end{oneparcheckboxes}\n");
                //pregunta de respuesta corta
                }else if(P.getTipoPregunta().contains("shortanswer")){
                    
                    pw.write("\t\\question{\n");
                    pw.write("\t"+ P.getPregunta() +"\n\t}\n");
                    pw.write("\t\\answerline [" +P.getRespuesta()+ "]\n");
                //pregunta tipo ensayo    
                }else if(P.getTipoPregunta().contains("essay")){
                    pw.write("\t\\question{\n");
                    pw.write("\t"+ P.getPregunta() +"\n\t}\n");
                    pw.write("\t\\makeemptybox{2in}\n");
                    
                //pregunta tipo numerica    
                }else if(P.getTipoPregunta().contains("numerical")){
                    pw.write("\t\\question{\n");
                    pw.write("\t"+ P.getPregunta() +"\n\t}\n");
                    pw.write("\t\\answerline [" +P.getRespuesta()+ "]\n");
                }
                
                 
            }
                
        pw.close();        
        }catch(IOException er){
            System.out.println("Excepcion en los flujos para generar el examen "+er.getMessage());
        }    
    }

    /**
     * Elimina el final de un examen LaTeX para agregar mas preguntas
     * @param direccionDestino la direccion del examen LaTeX
     */
    public void borrarFinalExamen(String direccionDestino) {
        
        // Se abre el fichero para lectura y escritura.
        RandomAccessFile fichero;
        long filePointer = 0;
        try {
            fichero = new RandomAccessFile (direccionDestino, "rw");
            
            while((linea=fichero.readLine())!=null){
                
                if (linea.contains("\\end{questions}")){
                    filePointer = fichero.getFilePointer();
                    filePointer-=16;
                    System.out.println(filePointer);
                    
                }
               
            }
            fichero.seek(filePointer);
            fichero.writeBytes("                                             ");
            fichero.seek(filePointer);
            fichero.setLength(filePointer);
            
            fichero.close();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExamenTex.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExamenTex.class.getName()).log(Level.SEVERE, null, ex);
        }
 
    }
    
}
