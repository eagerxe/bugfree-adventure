package Modelos;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

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
     * @param direccionDestino La direccion donde se pondran las imagenes del 
     * examen
     * @return examen con las preguntas separadas
     */
    public Examen separarPreguntasXML(String direccion,String direccionDestino){
        try{
            ArrayList <String> listaPreguntas = new ArrayList<String>();
            String linea;
            
            //Ciclo para buscar el pricipio de las preguntas que se van a separar
            BufferedReader examenOrigen
            = new BufferedReader(new FileReader(direccion));
            Pregunta P = null;
            while((linea=examenOrigen.readLine())!=null){
                
                if (linea.contains("<question type=")){
                    System.out.println("Una pregunta comienza");
                    P = new Pregunta();
                    //guardar tipo pregunta
                    linea = linea.replace("<question type=\"","");
                    linea = linea.replace("\">","");
                    System.out.println(linea + " tipo de pregunta");
                    P.setTipo(linea);
                }else if(linea.contains("<questiontext format=")){
                    linea = examenOrigen.readLine();
                    linea=linea.trim();
                    
                    String lineaAuxiliar="";
                    linea = linea.replace("<text>","");
                    
                    //Guarda las lineas en la pregunta hasta que encuentre </text>
                    while(!linea.contains("</text>")){
                        
                        lineaAuxiliar= lineaAuxiliar + " " + linea;
                        lineaAuxiliar=lineaAuxiliar.trim();
                        
                        linea = examenOrigen.readLine();
                        linea=linea.trim();
                    }
                    
                    linea = linea.replace("</text>","");
                    
                    lineaAuxiliar= lineaAuxiliar + " " + linea;
                    lineaAuxiliar=lineaAuxiliar.trim();
                    P.setPregunta(lineaAuxiliar);
                    
                    System.out.println(lineaAuxiliar + " La pregunta");
                    
                }else if(linea.contains("<image>")){
                    linea=linea.replace("<image>","");
                    linea= linea.replace("</image>","");
                    P.setNombreImagen(linea);
                    
                    //Se forma la cadena para LaTeX
                    linea=("\n\t\\begin{center}\n"+"\t\\includegraphics{"+linea+"}\n"+"\t\\end{center}");
                    //Agrego la cadena del nombre a la pregunta
                    String lineaAuxiliar;
                    lineaAuxiliar=P.getPregunta();
                    lineaAuxiliar=lineaAuxiliar+linea;
                    P.setPregunta(lineaAuxiliar);
                    //Se convierte la cadena de la imagen en base64 a una imagen
                    //y se guarda en la pregunta
                }else if(linea.contains("<image_base64>")){
                    
                    linea=linea.trim();
                    linea=linea.replace("<image_base64>","");
                    String cadenaBase64="";
                    
                    while(!linea.contains("</image_base64>")){
                        cadenaBase64=cadenaBase64+linea;
                        
                        linea=examenOrigen.readLine();
                        linea=linea.trim();
                    }
                    linea=linea.replace("</image_base64>","");
                    cadenaBase64=cadenaBase64+linea;
                    P.setCadenaBase64(cadenaBase64);
                    //Se convierte la cadena a una imagen y se guarda en la 
                    //misma direccion que el nuevoExamen en LaTeX
                    BufferedImage newImg;
                    CodificadorBase64 CB64 = new CodificadorBase64();
                    newImg=CB64.cadenaAImagen(cadenaBase64);
                    if(P.getNombreImagen().contains("jpg")){
                        ImageIO.write(newImg, "jpg", new File(direccionDestino+ "/"+P.getNombreImagen()));
                    }else if(P.getNombreImagen().contains("png")){
                        ImageIO.write(newImg, "png", new File(direccionDestino+ "/"+P.getNombreImagen()));
                    }else {
                        System.out.println("No se reconoce el tipo de imagen");
                    }
                   
                }else if (linea.contains("<answer fraction=")){
                    linea=linea.replace("<answer fraction=\"", "");
                    linea=linea.replace("\">", "");
                    linea=linea.trim();
                    //numero contiene el valor de la respuesta para saber si es
                    //correcta o incorrecta se compara con 0
                    int numero = Integer.parseInt(linea); 
                    if(numero==0){
                        linea = examenOrigen.readLine();
                        linea = linea.trim();
                        //linea = linea.replaceAll("\\s", "");
                        String lineaAuxiliar="";
                        linea = linea.replace("<text>","");
                        //Guarda las lineas en la respuestas hasta que encuentre </text>
                        while(!linea.contains("</text>")){
                        
                        lineaAuxiliar= lineaAuxiliar + " " + linea;
                        lineaAuxiliar=lineaAuxiliar.trim();
                        
                        linea = examenOrigen.readLine();
                        linea=linea.trim();
                        }
                        
                        linea = linea.replace("</text>","");
                        lineaAuxiliar=lineaAuxiliar+" "+linea;
                        linea = lineaAuxiliar.trim();
                        System.out.println(lineaAuxiliar + " Respuesta incorrecta");
                        P.setRespuestaenLista(lineaAuxiliar);
                    }else{
                        linea = examenOrigen.readLine();
                        linea=linea.trim();
                        
                        
                        String lineaAuxiliar="";
                        linea = linea.replace("<text>","");
                        
                        while(!linea.contains("</text>")){
                        
                        lineaAuxiliar= lineaAuxiliar + " " + linea;
                        lineaAuxiliar=lineaAuxiliar.trim();
                        
                        linea = examenOrigen.readLine();
                        linea=linea.trim();
                        }
                        
                        linea = linea.replace("</text>","");
                        lineaAuxiliar= lineaAuxiliar + " " + linea;
                        lineaAuxiliar=lineaAuxiliar.trim();
                        
                        System.out.println(lineaAuxiliar + " Respuesta correcta");
                        P.setRespuesta(lineaAuxiliar);
                        P.setRespuestasCorrectas(lineaAuxiliar);
                    }
                }
                
                else if(linea.contains("</question>")){
                    examen.setPreguntaALista(P);
                }
                  
                
            }
            
            
        }catch(IOException er){
            System.out.println("Excepcion en los flujos "+er.getMessage());
        }
        
        return examen;
    }
    
}
