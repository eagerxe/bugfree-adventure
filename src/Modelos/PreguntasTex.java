package Modelos;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;


/**
 * Clase para separar las preguntas,y componentes de un examen TeX
 * @author miguelhernandez
 */
public class PreguntasTex {
    private String linea;
    private ArrayList<String> listaPreguntas;
    private Iterator<String> iteradorPreguntas;
    Examen examen = new Examen();
    private ContieneUnaImagen CUI;
    
            
    public PreguntasTex(){
        CUI=new ContieneUnaImagen();
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
                    //mientras no encuentre question sigue guardando lineas
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
    
    
    
    /**
     * Obtiene el tipo de las preguntas (multichoice,truefalse,numerical,shortanswer,essay)
     * @param examen el que contiene las presguntas separadas
     * @param direccionPadre Contiene la direccion de la carpeta que contiene las imegenes
     * @return examenClasificado que contiene las preguntas separadas con el tipo de 
     * pregunta 
     */
    public Examen obtenertipoPregunta(Examen examen,String direccionPadre){
        // contiene la lista de preguntas del examen 
        ArrayList<Pregunta> listaP = new ArrayList();
        // examen que contiene las preguntas clasificadas
        Examen examenClasificado =  new Examen();
        int numeroPreguntas = 0;
        
        
        listaP = examen.getListaPreguntasSeparadas();
        numeroPreguntas = listaP.size();
        
        
        //lee una por una las preguntas en listaP
        for (int i=0;i<numeroPreguntas;i++){
            Pregunta P = new Pregunta();
            
            //obtener una pregunta de la listaP 
            P = listaP.get(i);
            //contiene la lista de renglones de una pregunta en LaTeX
            ArrayList<String> listaPreguntas =  new ArrayList ();
            //obtener la lista de renglones de la Pregunta
            listaPreguntas=P.getListaPreguntas();
            
            int numeroRenglones;
            numeroRenglones = listaPreguntas.size();
                       
            
            for (int j=0;j<numeroRenglones;j++){
                String renglon = listaPreguntas.get(j);
                renglon=renglon.trim();
                
                //Checar si el renglon contiene una imagen
                
                
                //Termina sustituir la imagen en base 64
                
                //si el renglon contiene question guarda la pregunta que se 
                //encuentra en el siguiente renglon
                
                
                if(renglon.contains("\\question")){
                    //reconocer la pregunta seguida a question
                    renglon = renglon.replace("\\question",""); 
                    renglon = renglon.replace("{", "");
                    renglon=renglon.replaceAll("\t", "");
                    renglon = renglon.replace("[", "");
                    renglon = renglon.replace("]", "");
                    String patronPuntos = "\\d+(\\.\\d+)?";
                    
                    renglon =  renglon.replaceFirst(patronPuntos, "");
                    
                    renglon = renglon.trim();
                    String renglonAuxiliar = renglon;
                    
                    j+=1;
                    renglon=listaPreguntas.get(j);
                    renglon=renglon.trim();
                    //Mientras no encuentre otro comando LaTeX
                    //guarda lo encontrado en los renglones consecutivos como 
                    //pregunta
                    String patron="}";
                    
                    while(!renglon.matches(patron)){
                        String patronAlineacion1="(\\\\begin\\{.*\\})";
                        String patronAlineacion2="(\\\\end\\{.*\\})";
                        renglon = renglon.replaceFirst(patronAlineacion1,"");
                        renglon = renglon.replaceFirst(patronAlineacion2,"");
                        renglon = renglon.replaceAll("\t", "");
                        renglon = renglon.trim();
                        //checa si la pregunta tienen una imagen
                        if(CUI.contieneUnaImagen(renglon)==true){
                            //Guarda la cadena de la imagen transformada en la 
                            //pregunta
                            String cadenabase64= CUI.contieneImagenes(renglon, direccionPadre);
                            renglon="";
                            P.setCadenaBase64(cadenabase64);
                            P.setExisteImagen(true);
                        }
                        
                        renglonAuxiliar = renglonAuxiliar + " " + renglon;
                        renglonAuxiliar=renglonAuxiliar.trim();
                        P.setPregunta(renglonAuxiliar);
                        System.out.println(renglonAuxiliar + " Pregunta");
                        j+=1;
                        renglon=listaPreguntas.get(j);
                        renglon=renglon.trim();
                    }
                    j-=1;    
                    
                    
                //guarda las opciones despues de este renglon  
                }else if(renglon.contains("\\begin{choices}")){
                    P.setTipo("multichoice");
                    j+=1;
                    renglon=listaPreguntas.get(j);
                    renglon=renglon.trim();
                    while(!(renglon.contains("\\end{choices}"))){
                        renglon=renglon.replaceAll("\t", "");
                        
                        String patronCorrecto="([Cc]orrect[Cc]hoice)";
                        Pattern patronCorrect = Pattern.compile("([Cc]orrect[Cc]hoice)");
                        Matcher m = patronCorrect.matcher(renglon);
                        
                        //si el renglon contiene la pregunta correcta la guarda en respuesta
                        //if(renglon.contains("orrect")){
                        if(m.find()){
                            
                            renglon=renglon.replaceAll(patronCorrecto,"");
                            renglon=renglon.replace("\\", "");
                            renglon=renglon.trim();
                            
                            P.setRespuesta(renglon);
                            P.setRespuestasCorrectas(renglon);
                            System.out.println(renglon+ " Respuesta correcta");
                            
                        //si el renglon contiene una opcion incorrecta la guarda en respuestas    
                        }else if(renglon.contains("\\choice")){
                            renglon=renglon.replace("\\choice","");
                            renglon=renglon.trim();
                            //P.setRespuestas(renglon);
                            P.setRespuestaenLista(renglon);
                            System.out.println(renglon + " Opción");
                            
                        }
                        j+=1;   
                        renglon=listaPreguntas.get(j);
                        renglon=renglon.trim();
                    }
                //preguntas de opción multiple en un parrafo    
                }else if(renglon.contains("\\begin{oneparchoices}")){
                    P.setTipo("multichoice");
                    j+=1;
                    renglon=listaPreguntas.get(j);
                    renglon=renglon.trim();
                    while(!(renglon.contains("\\end{oneparchoices}"))){
                        renglon=renglon.replaceAll("\t", "");
                        
                        //si el renglon contiene la pregunta correcta la guarda en respuesta
                        String patronCorrecto="([Cc]orrect[Cc]hoice)";
                        Pattern patronCorrect = Pattern.compile("([Cc]orrect[Cc]hoice)");
                        Matcher m = patronCorrect.matcher(renglon);
                        
                        //si el renglon contiene la pregunta correcta la guarda en respuesta
                        //if(renglon.contains("orrect")){
                        if(m.find()){
                            
                            renglon=renglon.replaceAll(patronCorrecto,"");
                            renglon=renglon.replace("\\", "");
                            renglon=renglon.trim();
                            
                            P.setRespuesta(renglon);
                            P.setRespuestasCorrectas(renglon);
                            System.out.println(renglon+ " Respuesta correcta");
                            
                        //si el renglon contiene una opcion incorrecta la guarda en respuestas    
                        }else if(renglon.contains("\\choice")){
                            renglon=renglon.replace("\\choice","");
                            renglon=renglon.trim();
                            //P.setRespuestas(renglon);
                            P.setRespuestaenLista(renglon);
                            System.out.println(renglon + " Opción");
                            
                        }
                        j+=1;   
                        renglon=listaPreguntas.get(j);
                        renglon=renglon.trim();
                    }
                    
                }else if(renglon.contains("\\begin{oneparcheckboxes}")){
                    
                    j+=1;
                    renglon=listaPreguntas.get(j);
                    renglon=renglon.trim();
                    if (renglon.contains("Verdadero")){
                        P.setTipo("truefalse");
                        
                        while(!(renglon.contains("\\end{oneparcheckboxes}"))){
                            renglon=renglon.replaceAll("\t", "");

                            //si el renglon contiene la pregunta correcta la guarda en respuesta
                            String patronCorrecto="([Cc]orrect[Cc]hoice)";
                        Pattern patronCorrect = Pattern.compile("([Cc]orrect[Cc]hoice)");
                        Matcher m = patronCorrect.matcher(renglon);
                        
                        //si el renglon contiene la pregunta correcta la guarda en respuesta
                        //if(renglon.contains("orrect")){
                        if(m.find()){
                            
                            renglon=renglon.replaceAll(patronCorrecto,"");
                            renglon=renglon.replace("\\", "");
                            renglon=renglon.trim();
                            
                            P.setRespuesta(renglon);
                            P.setRespuestasCorrectas(renglon);
                            System.out.println(renglon+ " Respuesta correcta");
                            
                        //si el renglon contiene una opcion incorrecta la guarda en respuestas    
                        }else if(renglon.contains("\\choice")){
                                renglon=renglon.replace("\\choice","");
                                renglon=renglon.trim();
                                //P.setRespuestas(renglon);
                                P.setRespuestaenLista(renglon);
                                System.out.println(renglon + " Opción");    
                            }
                            j+=1;   
                            renglon=listaPreguntas.get(j);
                            renglon=renglon.trim();
                        }
                        
                        
                        
                        
                    }
                    else if(renglon.contains("Falso")){
                        P.setTipo("truefalse");
                        renglon=renglon.replaceAll("\t", "");
                        
                        while(!(renglon.contains("\\end{oneparcheckboxes}"))){
                            renglon=renglon.replaceAll("\t", "");

                            //si el renglon contiene la pregunta correcta la guarda en respuesta
                        String patronCorrecto="([Cc]orrect[Cc]hoice)";
                        Pattern patronCorrect = Pattern.compile("([Cc]orrect[Cc]hoice)");
                        Matcher m = patronCorrect.matcher(renglon);
                        
                        //si el renglon contiene la pregunta correcta la guarda en respuesta
                        //if(renglon.contains("orrect")){
                        if(m.find()){
                            
                            renglon=renglon.replaceAll(patronCorrecto,"");
                            renglon=renglon.replace("\\", "");
                            renglon=renglon.trim();
                            
                            P.setRespuesta(renglon);
                            P.setRespuestasCorrectas(renglon);
                            System.out.println(renglon+ " Respuesta correcta");
                            
                        //si el renglon contiene una opcion incorrecta la guarda en respuestas    
                        }else if(renglon.contains("\\choice")){
                                renglon=renglon.replace("\\choice","");
                                renglon=renglon.trim();
                                //P.setRespuestas(renglon);
                                P.setRespuestaenLista(renglon);
                                System.out.println(renglon + " Opción");    
                            }
                            j+=1;   
                            renglon=listaPreguntas.get(j);
                            renglon=renglon.trim();
                        }
                        
                        
                        
                        
                    }else{
                        P.setTipo("multichoice");
                        
                        while(!(renglon.contains("\\end{oneparcheckboxes}"))){
                            renglon=renglon.replaceAll("\t", "");

                            //si el renglon contiene la pregunta correcta la guarda en respuesta
                            String patronCorrecto="([Cc]orrect[Cc]hoice)";
                        Pattern patronCorrect = Pattern.compile("([Cc]orrect[Cc]hoice)");
                        Matcher m = patronCorrect.matcher(renglon);
                        
                        //si el renglon contiene la pregunta correcta la guarda en respuesta
                        //if(renglon.contains("orrect")){
                        if(m.find()){
                            
                            renglon=renglon.replaceAll(patronCorrecto,"");
                            renglon=renglon.replace("\\", "");
                            renglon=renglon.trim();
                            
                            P.setRespuesta(renglon);
                            P.setRespuestasCorrectas(renglon);
                            System.out.println(renglon+ " Respuesta correcta");
                            
                        //si el renglon contiene una opcion incorrecta la guarda en respuestas    
                        }else if(renglon.contains("\\choice")){
                                renglon=renglon.replace("\\choice","");
                                renglon=renglon.trim();
                                //P.setRespuestas(renglon);
                                P.setRespuestaenLista(renglon);
                                System.out.println(renglon + " Opción");

                            }
                            j+=1;   
                            renglon=listaPreguntas.get(j);
                            renglon=renglon.trim();
                        }
                        
                        
                        
                    }

                //Preguntas de respuesta numerica o corta
                }else if(renglon.contains("\\answerline [")){
                    P.setTipo("numerical");
                    
                    renglon=renglon.replaceAll("\t", "");
                    renglon=renglon.replace("\\answerline ","");
                    renglon=renglon.replace("[","");
                    renglon=renglon.replace("]","");
                    renglon=renglon.replace(" ","");
                    
                    //se guarda la respuesta correcta
                    P.setRespuesta(renglon);
                    try{
                        Integer.parseInt(renglon);
                        System.out.println("Tipo de respuesta numerica");
                    }catch(NumberFormatException exc){
                        System.out.println("la cadena de caracteres no es un entero");
                        P.setTipo("shortanswer");
                    }
                    System.out.println(renglon + " Respuesta corta/numerica");
                //Respuestas tipo ensayo     
                }else if(renglon.contains("\\makeemptybox{")){
                    P.setTipo("essay");
                    System.out.println(" ensayo caja");
                }else if(renglon.contains("\\vspace*{\\stretch{")){
                    P.setTipo("essay");
                    System.out.println(" ensayo blanco");
                }else if(renglon.contains("\\fillwithlines{")){
                    P.setTipo("essay");
                    System.out.println(" ensayo lineas");
                }else if(renglon.contains("\\fillwithdottedlines{")){
                    P.setTipo("essay");
                    System.out.println(" ensayo lineas punteadas");
                }
                
                
            }
            
        //se agrega la pregunta con el tipo, la respuesta y las respuestas incorrectas
        //separadas en el examen
        examenClasificado.setPreguntaALista(P);
        }
        
        
        return examenClasificado;
    }
    
    
}
