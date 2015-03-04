package Modelos;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * Clase para guardar los componentes de una pregunta
 * @author miguelhernandez
 */
public class Pregunta {
    
    private String tipoPregunta;
    private String pregunta;
    private String respuesta;
    private String cadenaBase64;
    private boolean existeImagen;
    private String nombreImagen;
    private ArrayList<String> listaDePreguntas;
    private Iterator<String> iteradorPreguntas;
    private ArrayList<String> listaRespuestas;
    private ArrayList<String> listaRespuestasCorrectas;
    
    /**
     * Contructor del objeto Pregunta que sera utilizado como auxiliar para 
     * separar las preguntas de un examen
     */
    public Pregunta (){
        
        tipoPregunta=null;
        pregunta=null;
        respuesta=null;
        cadenaBase64=null;
        existeImagen=false;
        nombreImagen=null;
        listaDePreguntas=new ArrayList();
        iteradorPreguntas=listaDePreguntas.iterator();
        listaRespuestas=new ArrayList();
        listaRespuestasCorrectas= new ArrayList();
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
     * Para establecer la cadena codificada de una imagen en la pregunta
     * @param cadenaBase64 la cadena codificada en Base64
     */
    public void setCadenaBase64(String cadenaBase64){
        this.cadenaBase64=cadenaBase64;
    }
    /**
     * Para cambiar entre verdadero y falso dependiendo de si existe una imagen 
     * en la pregunta
     * @param existe verdadero si existe una imagen en la pregunta falso si no.
     */
    public void setExisteImagen(boolean existe){
        existeImagen=existe;
    }
    /**
     * Para establecer el nombre de la imagen en la pregunta
     * @param nombreImagen El nombre de la imagen
     */
    public void setNombreImagen(String nombreImagen){
        this.nombreImagen=nombreImagen;
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
     * Añade una respuesta correcta a la lista de respuestas correctas
     * @param linea respuesta correcta
     */
    public void setRespuestasCorrectas(String linea){
        listaRespuestasCorrectas.add(linea);
    }
    /**
     * Agrega la lista respuestas a la listaRespuestasCorrectas
     * @param respuestas La lista de respuestas correctas
     */
    public void setListaRespuestasCorrectas(ArrayList<String> respuestas){
        listaRespuestasCorrectas=respuestas;
    }
    /**
     * Agrega la lista distractores a la listaRespuestas
     * @param distractores la lista de distractores
     */
    public void setListaRespuestas(ArrayList<String> distractores){
        listaRespuestas=distractores;
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
    /**
     * Devuelve la cadena de la imagen codificada en base64
     * @return cadena de la imagen cpodificada en base64
     */
    public String getCadenaBase4(){
        return cadenaBase64;
    }
    /**
     * Devuelve verdadero si la pregunta tiene una imagen, falso si no es así.
     * @return verdadero si la pregunta contiene una imagen, falso si no
     */
    public boolean getExisteImagen(){
        return existeImagen;
    }
    /**
     * Obtiene el nombre de la imagen en la pregunta
     * @return el nombre de la imagen en nombreImagen
     */ 
    public String getNombreImagen(){
        return nombreImagen;
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
     * Obtienen la lista de respuestas incorrectas de una pregunta
     * @return la lista de respuestas incorrectas de una pregunta
     */
    public ArrayList getListaRespuestas(){
        return listaRespuestas;
    }
    /**
     * Obtiene la lista de respuestas correctas de una pregunta
     * @return la lista de respuestas correctas de una pregunta
     */
    public ArrayList getListaRespuestasCorrectas(){
        return listaRespuestasCorrectas;
    }
    /**
     * Devuelve el iterador asociado a la listaDePreguntas
     * @return 
     */
    public Iterator getIteradorPreguntas(){
        return iteradorPreguntas;
    }
}   
