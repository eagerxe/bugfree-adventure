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
    private int numeroPreguntas;
    private int posicion=0;
    private ArrayList<String> listaDePreguntas;
    private Iterator<String> iteradorPreguntas;
    private ArrayList<String> listaRespuestas;
    /**
     * Contructor del objeto Pregunta que sera utilizado como auxiliar para 
     * separar las preguntas de un examen
     */
    public Pregunta (){
        
        tipoPregunta=null;
        pregunta=null;
        respuesta=null; 
        numeroPreguntas=0;
        posicion=0;
        listaDePreguntas=new ArrayList();
        iteradorPreguntas=listaDePreguntas.iterator();
        listaRespuestas=new ArrayList();
    }
    /**
     * Para establecer el tipo de pregunta; puede tener los valores:
     * @param tipoPregunta multichoice|truefalse|shortanswer|essay|numerical
     */
    public void setTipo(String tipoPregunta){
        this.tipoPregunta=tipoPregunta;
    }
    /**
     * Para establecer la pregunta 
     * @param pregunta la pregunta que se desea sea respondida
     */
    public void setPregunta(String pregunta){
        this.pregunta=pregunta;
    }
    /**
     * Para establecer la respuesta correcta a la pregunta
     * @param respuesta 
     */
    public void setRespuesta(String respuesta){
        this.respuesta=respuesta;
    }
    /**
     * Para establecer 
     * @param n 
     */
    public void setNumeroPreguntas(int n){
        numeroPreguntas=n;
    }
    /**
     * Para guardar los renglones leidos del archivo de una pregunta
     * @param linea renglon de una pregunta
     */
    public void setPreguntaenLista(String linea){
        listaDePreguntas.add(linea);
    }
    /**
     * Añade una respuesta incorrecta a la lista de respuestas
     * @param linea respuesta incorrecta
     */
    public void setRespuestaenLista(String linea){
        listaRespuestas.add(linea);
    }
    /**
     * Para obtener el tipo de pregunta
     * @return tipo de pregunta multichoice|truefalse|shortanswer|essay|numerical
     */
    public String getTipoPregunta(){
        return tipoPregunta;
    }
    /**
     * Obtiene la pregunta a la que se busca una respuesta
     * @return pregunta
     */
    public String getPregunta(){
        return pregunta;
    }
    /**
     * Devuelve la respuesta correcta
     * @return respuesta correcta
     */
    public String getRespuesta(){
        return respuesta;
    }
    
    public int getNumeroPreguntas(){
        return numeroPreguntas;
    }
    /**
     * Devuelve un renglon en la posicion deseada de la lista de preguntas
     * @param posicion la posicion que se quiere sea devuelta de la lista
     * @return renglon de una pregunta en la posición deseada
     */
    public String getListaDePreguntas(int posicion){
        return listaDePreguntas.get(posicion);
    }
    /**
     * Devuelve la lista de Preguntas
     * @return listaDePreguntas
     */
    public ArrayList getListaPreguntas(){
        return listaDePreguntas;
    }
    /**
     * Obtienen la lista de respuestas incorrectas
     * @return la lista de respuestas incorrectas
     */
    public ArrayList getListaRespuestas(){
        return listaRespuestas;
    }
    /**
     * Devuelve el iterador asociado a la listaDePreguntas
     * @return 
     */
    public Iterator getIteradorPreguntas(){
        return iteradorPreguntas;
    }
}   
