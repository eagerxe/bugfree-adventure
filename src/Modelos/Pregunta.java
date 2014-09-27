package Modelos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 *
 * @author miguelhernandez
 */
public class Pregunta {
    
    private String tipoPregunta;
    private String pregunta;
    private String respuesta;
    private String[] respuestas;
    private int numeroPreguntas;
    private int posicion=0;
    private ArrayList<String> listaDePreguntas;
    private Iterator<String> iteradorPreguntas;
    /**
     * Contructor del objeto Pregunta que sera utilizado como auxiliar para 
     * separar las preguntas de un examen
     */
    public Pregunta (){
        
        tipoPregunta=null;
        pregunta=null;
        respuesta=null; 
        respuestas=new String[25];
        numeroPreguntas=0;
        posicion=0;
        listaDePreguntas=new ArrayList();
        iteradorPreguntas=listaDePreguntas.iterator();
    }
    
    public void setTipo(String tipoPregunta){
        this.tipoPregunta=tipoPregunta;
    }
    public void setPregunta(String pregunta){
        this.pregunta=pregunta;
    }
    public void setRespuesta(String respuesta){
        this.respuesta=respuesta;
    }
    public void setRespuestas(String respuestas){
            this.respuestas[posicion]=respuestas;
            posicion++;
    }
    public void setNumeroPreguntas(int n){
        numeroPreguntas=n;
    }
    public void setPreguntaenLista(String linea){
        listaDePreguntas.add(linea);
    }
    public String getTipoPregunta(){
        return tipoPregunta;
    }
    public String getPregunta(){
        return pregunta;
    }
    public String getRespuesta(){
        return respuesta;
    }
    public String getRespuestas(int n){
        return respuestas[n];
    }
    public int getNumeroPreguntas(){
        return numeroPreguntas;
    }
    public String getListaDePreguntas(int posicion){
        return listaDePreguntas.get(posicion);
    }
    /**
     * Lista de Preguntas
     * @return listaDePreguntas
     */
    public ArrayList getListaPreguntas(){
        return listaDePreguntas;
    }
    public Iterator getIteradorPreguntas(){
        return iteradorPreguntas;
    }
}   
