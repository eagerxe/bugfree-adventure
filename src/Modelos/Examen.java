package Modelos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author miguelhernandez
 */
public class Examen {
    private ArrayList<Pregunta> listaPreguntasSeparadas;
    private Iterator<Pregunta> iteradorPreguntasSeparadas;
    
    /**
     * Esta clase contiene una lista de preguntas separadas 
     */
    
    public Examen (){
        
        listaPreguntasSeparadas = new ArrayList<>();
        iteradorPreguntasSeparadas = listaPreguntasSeparadas.iterator();
    }
    
    public void setPreguntaALista(Pregunta P){
        boolean exito;
        exito =listaPreguntasSeparadas.add(P);
    }
    public Pregunta getPreguntaDeLista(int i){
        return listaPreguntasSeparadas.get(i);
    }
    public ArrayList<Pregunta> getListaPreguntasSeparadas(){
        return listaPreguntasSeparadas;
    }
    public Iterator<Pregunta> getIteradorPreguntasSeparadas(){
        return iteradorPreguntasSeparadas;
    }
    
    
}
