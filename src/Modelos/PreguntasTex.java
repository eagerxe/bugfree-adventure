package Modelos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author miguelhernandez
 */
public class PreguntasTex {
    private String linea;
    private ArrayList<String> listaPreguntas;
    private Iterator<String> iteradorPreguntas;
    Examen examen = new Examen();
    
    
            
    public PreguntasTex(){
        
    }
    /**
     * Separa las preguntas de un examen en LaTeX
     * @param direccion La direccion del archivo a leer 
     * @return listaPreguntas 
     */
    public Examen separarPreguntasTex (String direccion){
        
        
        
        try{
            listaPreguntas = new ArrayList<>();
            iteradorPreguntas = listaPreguntas.iterator();
            
            BufferedReader examenOrigen
            = new BufferedReader(new FileReader(direccion));
            //Cadena de caracteres para encontrar el principio de la pregunta
            CharSequence CS1 = "\\begin{questions}";
            CharSequence CS2 = "\\question";
            CharSequence CS3 = "\\end{questions}";
            
            //Ciclo para buscar el pricipio de las preguntas que se van a separar
            while((linea=examenOrigen.readLine())!=null){
                if (linea.contains(CS1)){
                    break;
                }
                
            }
            //Separa preguntas y guardar en listaPreguntas 
            while((linea=examenOrigen.readLine())!=null){
                //si encuentra end{questions} sale del ciclo
                if(linea.contains(CS3)){
                    break; 
                }else{
                    //agrega la linea a listaPreguntas
                    boolean exito;
                    exito=listaPreguntas.add(linea);
                    
                }
            }
            //obtiene el tamaño de la listaPreguntas
            //en numerolineas
            int numeroLineas=listaPreguntas.size();
            
            //Separa las preguntas en listaPreguntas, las guarda en pregunta 
            //y despues en un examen
            int i=0;
            for(i=0;i<(numeroLineas-1);i++){
                //lee la pregunta i de la listaPreguntas
                String line = listaPreguntas.get(i);
                //si contiene question la guarda en una nueva pregunta P
                if (line.contains(CS2)){
                    
                    Pregunta P = new Pregunta ();
                    
                    //P.setRespuestas(line);
                    P.setPreguntaenLista(line);
                    
                    System.out.println(line);
                    System.out.println(i);
                    i=i+1;
                    System.out.println(i);
                    line = listaPreguntas.get(i);
                    //mientras no encuentre otra question sigue guardando lineas
                    while(!line.contains(CS2)){
                        
                        //P.setRespuestas(line);
                        P.setPreguntaenLista(line);
                        
                        System.out.println(line);
                        i=i+1;
                        //si llega al final de la lista termina de guardar
                        if(i<=(numeroLineas-1)){
                            line = listaPreguntas.get(i);
                            System.out.println(i);
                        }else{
                            break;
                        }
                        
                        
                    }
                    //si encontro question regresa una posicion en la lista
                    //y guarda la pregunta en examen y sale
                    examen.setPreguntaALista(P);
                    System.out.println(i);
                    i=i-1;
                }
                
            }
           
        }catch(IOException er){
            System.out.println("Excepcion en los flujos "+er.getMessage());
        }
        return examen;
        
    }
    public Examen obtenertipoPregunta(Examen examen){
        // contiene la lista de preguntas del examen 
        ArrayList<Pregunta> listaP = new ArrayList();
        // examen que contiene las preguntas clasificadas
        Examen examenClasificado =  new Examen();
        int numeroPreguntas = 0;
        Pregunta P = new Pregunta();
        
        listaP = examen.getListaPreguntasSeparadas();
        numeroPreguntas = listaP.size();
        
        
        //lee una por una las preguntas en listaP
        for (int i=0;i<numeroPreguntas;i++){
            
            
            //obtener una pregunta de la listaP 
            P = listaP.get(i);
            //contiene la lista de renglones de una pregunta en LaTeX
            ArrayList<String> listaPreguntas =  new ArrayList ();
            //obtener la lista de renglones de la Pregunta
            listaPreguntas=P.getListaPreguntas();
            
            int numeroRenglones;
            numeroRenglones = listaPreguntas.size();
            int j=0;
            for (j=0;j<numeroRenglones;j++){
                String renglon = listaPreguntas.get(j);
                
                //Preguntas de opción múltiple
                
                //si el renglon contiene question guarda la pregunta que se 
                //encuentra en el siguiente renglon
                if(renglon.contains("\\question")){
                    j+=1;
                    renglon=listaPreguntas.get(j);
                    renglon=renglon.replaceAll("\t", "");
                    P.setPregunta(renglon);
                    System.out.println(renglon + " Pregunta");
                //guarda las opciones despues de este renglon  
                }else if(renglon.contains("\\begin{choices}")){
                    P.setTipo("multichoice");
                    j+=1;
                    renglon=listaPreguntas.get(j);
                    while(!(renglon.contains("\\end{choices}"))){
                        renglon=renglon.replaceAll("\t", "");
                        
                        
                        if(renglon.contains("Correct")){
                            renglon=renglon.replace("\\CorrectChoice ","");
                            P.setRespuesta(renglon);
                            System.out.println(renglon+ " Respuesta correcta");
                        //si el renglon contiene la pregunta correcta la guarda en respuesta     
                        }else if(renglon.contains("\\choice")){
                            renglon=renglon.replace("\\choice ","");
                            P.setRespuestas(renglon);
                            System.out.println(renglon + " Opción");
                            
                        }
                        j+=1;   
                        renglon=listaPreguntas.get(j);
                    }
                    
                }else if(renglon.contains("\\begin{oneparchoices}")){
                    P.setTipo("multichoice");
                    j+=1;
                    renglon=listaPreguntas.get(j);
                    while(!(renglon.contains("\\end{oneparchoices}"))){
                        renglon=renglon.replaceAll("\t", "");
                        
                        
                        if(renglon.contains("Correct")){
                            renglon=renglon.replace("\\CorrectChoice ","");
                            P.setRespuesta(renglon);
                            System.out.println(renglon+ " Respuesta correcta");
                        //si el renglon contiene la pregunta correcta la guarda en respuesta     
                        }else if(renglon.contains("\\choice")){
                            renglon=renglon.replace("\\choice ","");
                            P.setRespuestas(renglon);
                            System.out.println(renglon + " Opción");
                            
                        }
                        j+=1;   
                        renglon=listaPreguntas.get(j);
                    }
                    
                }else if(renglon.contains("\\begin{oneparcheckboxes}")){
                    P.setTipo("multichoice");
                    j+=1;
                    renglon=listaPreguntas.get(j);
                    while(!(renglon.contains("\\end{oneparcheckboxes}"))){
                        renglon=renglon.replaceAll("\t", "");
                        
                        
                        if(renglon.contains("Correct")){
                            renglon=renglon.replace("\\CorrectChoice ","");
                            P.setRespuesta(renglon);
                            System.out.println(renglon+ " Respuesta correcta");
                        //si el renglon contiene la pregunta correcta la guarda en respuesta     
                        }else if(renglon.contains("\\choice")){
                            renglon=renglon.replace("\\choice ","");
                            P.setRespuestas(renglon);
                            System.out.println(renglon + " Opción");
                            
                        }
                        j+=1;   
                        renglon=listaPreguntas.get(j);
                    }
                    
                }
                
            }
            
            
            
            
            
            
            
        }
        
        
        return examen;
    }
    
    
}
