package Modelos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author miguelhernandez
 */
public class ExamenXML {
    
    private Boolean nRespuestasCorrectas;
    
    public ExamenXML(){
        
    }
    
    /**
     * Genera la cabecera del examen XML
     * @param direccionDestino direccion del examen XML
     */
    public void generarCabecera(String direccionDestino){
        try{
            PrintWriter pw 
            = new PrintWriter(new BufferedWriter(new FileWriter(direccionDestino)));
                //cabecera del examen
                pw.write("<?xml version=\"1.0\" ?>\n"
                        + "<quiz>\n\n");
        pw.close();
        }catch(IOException er){
            System.out.println("Excepcion en flujos para crear la cabecera del examen XML "+er.getMessage());
        }
    }
    /**
     * Genera el final del examen XML
     * @param direccionDestino direccion del examen XML
     */
    public void generarFinalExamen(String direccionDestino){
        try{
            PrintWriter pw 
            = new PrintWriter(new BufferedWriter(new FileWriter(direccionDestino,true)));   
                //final del examen
                pw.write("</quiz>");
        pw.close();        
        }catch(IOException er){
            System.out.println("Excepcion en el final del examen "+er.getMessage());
        }
    }
    /**
     * Genera el examen XML con las preguntas del examen que recibe
     * @param direccionDestino La ubicacion del examen generado
     * @param examen contiene las preguntas del examen 
     */ 
    public void generarExamenXML(String direccionDestino,Examen examen){
        
        //this.examen=examen;
        ArrayList<Pregunta> listaPreguntas = new ArrayList();
        ArrayList <String> lineasPregunta = new ArrayList();
        String linea = null;
        
        
        try{
            
            PrintWriter pw 
            = new PrintWriter(new BufferedWriter(new FileWriter(direccionDestino,true)));
         
                //obtiene la lista de preguntas del examen
                listaPreguntas = examen.getListaPreguntasSeparadas();
                int numeroPreguntas = listaPreguntas.size();
                
                //obtiene las preguntas de la lista una a una
                for(int i=0;i<numeroPreguntas;i++){
                    Pregunta P = new Pregunta();
                    nRespuestasCorrectas=false;
                    P=listaPreguntas.get(i);
                    //Obtiene el tipo de pregunta y de acuerdo a eso genera el 
                    //código XML correspondiente
                    linea = P.getTipoPregunta();
                    if(linea.contains("multichoice")){
                        pw.write("<question type=\"multichoice\">\n");
                        pw.write("\t<name>\n"
                                + "\t\t<text>Opcion multiple</text>\n"
                                + "\t</name>\n");
                        linea = P.getPregunta();
                        pw.write("\t<questiontext format=\"html\">\n"
                                + "\t\t<text>"
                                + linea
                                + "</text>\n"
                                + "\t</questiontext>\n");
                        //si la pregunta contiene mas de una respuesta
                        int numeroRespuestasCorrectas;
                        numeroRespuestasCorrectas = P.getListaRespuestasCorrectas().size();
                        if (numeroRespuestasCorrectas>1){
                            
                            nRespuestasCorrectas=true;
                            //calcular la fraccion del valor de la respuesta correcta
                            double valor = 100/ numeroRespuestasCorrectas;
                            int val=(int) Math.floor(valor);
                            //Recorrer las preguntar correctas en la lista
                            for (int k=0;k<numeroRespuestasCorrectas;k++){
                                linea =(String) P.getListaRespuestasCorrectas().get(k);
                                pw.write("\t<answer fraction=\""
                                        + val
                                        + "\">\n"
                                    + "\t\t<text>"
                                    + linea
                                    + "</text>\n"
                                    + "\t\t<feedback><text>Parcialmente correcto!</text></feedback>\n"
                                    + "\t</answer>\n");
                            }
                            
                            
                        }else{
                            linea = P.getRespuesta();
                            pw.write("\t<answer fraction=\"100\">\n"
                                    + "\t\t<text>"
                                    + linea
                                    + "</text>\n"
                                    + "\t\t<feedback><text>Correcto!</text></feedback>\n"
                                    + "\t</answer>\n");
                        }
                        
                        ArrayList <String> listaRespuesta = P.getListaRespuestas();
                        int numeroRespuestas = listaRespuesta.size();
                        for (int j=0;j<numeroRespuestas;j++){
                            linea = listaRespuesta.get(j);
                            pw.write("\t<answer fraction=\"0\">\n"
                                    + "\t\t<text>"
                                    + linea
                                    + "</text>\n"
                                    + "\t\t<feedback><text>Ooops!</text></feedback>\n"
                                    + "\t</answer>\n");
                            
                        }
                        pw.write("\t<shuffleanswers>1</shuffleanswers>\n");
                        if(nRespuestasCorrectas){
                            pw.write("\t<single>false</single>\n");
                        }else{
                            pw.write("\t<single>true</single>\n");
                        }
                        pw.write("\t<answernumbering>abc</answernumbering>\n");
                        pw.write("</question>\n");
                        
                    }else if(linea.contains("truefalse")){
                        pw.write("<question type=\"truefalse\">\n");
                        pw.write("\t<name>\n"
                                + "\t\t<text>Verdadero falso</text>\n"
                                + "\t</name>\n");
                        linea = P.getPregunta();
                        pw.write("\t<questiontext format=\"html\">\n"
                                + "\t\t<text>"
                                + linea
                                + "</text>\n"
                                + "\t</questiontext>\n");
                        linea = P.getRespuesta();
                        
                        if(linea.contains("Verdadero")){
                            pw.write("\t<answer fraction=\"100\">\n"
                                + "\t\t<text>true</text>\n"
                                + "\t\t<feedback><text>Correct!</text></feedback>\n"
                                + "\t</answer>\n");
                        
                            pw.write("\t<answer fraction=\"0\">\n"
                                + "\t\t<text>false</text>\n"
                                + "\t\t<feedback><text>Ooops!</text></feedback>\n"
                                + "\t</answer>\n"
                                + "</question>\n");
                        }else{
                            pw.write("\t<answer fraction=\"0\">\n"
                                + "\t\t<text>true</text>\n"
                                + "\t\t<feedback><text>Ooops!</text></feedback>\n"
                                + "\t</answer>\n");
                                
                            pw.write("\t<answer fraction=\"100\">\n"
                                + "\t\t<text>false</text>\n"
                                + "\t\t<feedback><text>Correct!</text></feedback>\n"
                                + "\t</answer>\n"
                                + "</question>\n");
                                
                            
                        }
                        
                    }else if(linea.contains("shortanswer")){
                        pw.write("<question type=\"shortanswer\">\n");
                        pw.write("\t<name>\n"
                                + "\t\t<text>Respuesta corta</text>\n"
                                + "\t</name>\n");
                        linea = P.getPregunta();
                        pw.write("\t<questiontext format=\"html\">\n"
                                + "\t\t<text>"
                                + linea
                                + "</text>\n"
                                + "\t</questiontext>\n");
                        linea = P.getRespuesta();
                        pw.write("\t<answer fraction=\"100\">\n"
                                + "\t\t<text>"
                                + linea
                                + "</text>\n"
                                + "\t\t<feedback><text>Correct!</text></feedback>\n"
                                + "\t</answer>\n"
                                + "</question>\n");
                        
                        
                    }else if(linea.contains("numerical")){
                        pw.write("<question type=\"numerical\">\n");
                        pw.write("\t<name>\n"
                                + "\t\t<text>Numerica</text>\n"
                                + "\t</name>\n");
                        linea = P.getPregunta();
                        pw.write("\t<questiontext format=\"html\">\n"
                                + "\t\t<text>"
                                + linea
                                + "</text>\n"
                                + "\t</questiontext>\n");
                        linea = P.getRespuesta();
                        pw.write("\t<answer fraction=\"100\">\n"
                                + "\t\t<text>"
                                + linea
                                + "</text>\n"
                                + "\t\t<feedback><text>Correct!</text></feedback>\n"
                                + "\t</answer>\n"
                                + "</question>\n");
                    
                        
                    }else if(linea.contains("essay")){
                        pw.write("<question type=\"essay\">\n");
                        pw.write("\t<name>\n"
                                + "\t\t<text>Ensayo</text>\n"
                                + "\t</name>\n");
                        linea = P.getPregunta();
                        pw.write("\t<questiontext format=\"html\">\n"
                                + "\t\t<text>"
                                + linea
                                + "</text>\n"
                                + "\t</questiontext>\n"
                                + "\t<answer fraction=\"0\">\n"
                                + "\t\t<text></text>\n"
                                + "\t</answer>\n"
                                + "</question>\n");
                        
                    }
                    
                      
                    
                }
                
        pw.close();
        }catch(IOException er){
            System.out.println("Excepcion en los flujos generar examen "+er.getMessage());
        }
        
      
    }
    
    
}
