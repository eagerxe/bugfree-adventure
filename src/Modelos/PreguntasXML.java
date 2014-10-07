package Modelos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author miguelhernandez
 */
public class PreguntasXML {
    
    Examen examen = new Examen();
    
    public PreguntasXML(){
        
    }
    /**
     * Separa las preguntas del examen XML
     * @param direccion La direccion del archivo a leer
     * @return examen con las preguntas separadas
     */
    public Examen separarPreguntasXML(String direccion){
        try{
            ArrayList <String> listaPreguntas = new ArrayList<String>();
            String linea;
            
            //Ciclo para buscar el pricipio de las preguntas que se van a separar
            BufferedReader examenOrigen
            = new BufferedReader(new FileReader(direccion));
            Pregunta P = null;
            while((linea=examenOrigen.readLine())!=null){
                
                if (linea.contains("<question type=")){
                    System.out.println("Una pregunta comienza jajaja");
                    P = new Pregunta();
                    //guardar tipo pregunta
                    linea = linea.replace("<question type=\"","");
                    linea = linea.replace("\">","");
                    System.out.println(linea + " tipo de pregunta");
                    P.setTipo(linea);
                }else if(linea.contains("<questiontext format=")){
                    linea = examenOrigen.readLine();
                    //linea = linea.replaceAll("\\s", "");
                    
                    linea = linea.replace("<text>","");
                    linea = linea.replace("</text>","");
                    linea = linea.trim();
                    P.setPregunta(linea);
                    
                    System.out.println(linea + " La pregunta");
                    
                }else if(linea.contains("<answer fraction=\"100\">")){
                    linea = examenOrigen.readLine();
                    //linea = linea.replaceAll("\\s", "");
                    linea = linea.replace("<text>","");
                    linea = linea.replace("</text>","");
                    linea = linea.trim();
                    System.out.println(linea + " Respuesta correcta");
                    P.setRespuesta(linea);
                }else if (linea.contains("<answer fraction=\"0\">")){
                    linea = examenOrigen.readLine();
                    //linea = linea.replaceAll("\\s", "");
                    linea = linea.replace("<text>","");
                    linea = linea.replace("</text>","");
                    linea = linea.trim();
                    System.out.println(linea + " Respuesta incorrecta");
                    P.setRespuestaenLista(linea);
                }else if(linea.contains("</question>")){
                    examen.setPreguntaALista(P);
                }
                  
                
            }
            
            
        }catch(IOException er){
            System.out.println("Excepcion en los flujos "+er.getMessage());
        }
        
        return examen;
    }
    
}
