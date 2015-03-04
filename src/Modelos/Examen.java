package Modelos;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase para guardar las preguntas de un examen
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
    /**
     * Agrega la pregunta P a la listaPreguntasSeparadas
     * @param P pregunta que se desea añadir a la lista
     */
    public void setPreguntaALista(Pregunta P){
        boolean exito;
        exito =listaPreguntasSeparadas.add(P);
    }
    /**
     * Obtiene la pregunta en la posicion i de la listaPreguntasSeparadas
     * @param i posicion en la lista de la pregunta deseada 
     * @return pregunta en la posicion i
     */
    public Pregunta getPreguntaDeLista(int i){
        return listaPreguntasSeparadas.get(i);
    }
    /**
     * Obtiene la listaPreguntasSeparadas
     * @return listaPreguntasSeparadas
     */
    public ArrayList<Pregunta> getListaPreguntasSeparadas(){
        return listaPreguntasSeparadas;
    }
    /**
     * Obtiene el iterador de preguntas asociado a la listaPreguntasSeparadas
     * @return iteradorPreguntasSeparadas
     */
    public Iterator<Pregunta> getIteradorPreguntasSeparadas(){
        return iteradorPreguntasSeparadas;
    }
    /**
     * Ordena las preguntas en un examen de forma aleatoria
     * @param examen el examen que sera ordenado de forma aleatoria
     * @return examenAleatorio examen ordenado de forma aleatoria
     */
    public Examen ordenAleatorio(Examen examen){
        Examen examenAleatorio=new Examen();
        int total=0;
        int aleatorio=0;
        ArrayList<Pregunta> preguntas =  new ArrayList();
        Pregunta P = new Pregunta();
        //obtiene la lista de preguntas de un examen
        preguntas = examen.getListaPreguntasSeparadas();
        //obtiene el tamaño del ArrayList
        total = examen.getListaPreguntasSeparadas().size();
        //obtiene preguntas en orden aleatorio y las guarda en examenAleatorio
        for(int i=0;i<total;i++){
            aleatorio =(int) Math.floor(Math.random()*(preguntas.size()));
            P = preguntas.get(aleatorio);
            examenAleatorio.setPreguntaALista(P);
            boolean exito = preguntas.remove(P);
        }
            
        return examenAleatorio;
    }
    /**
     * Crea un examen escogiendo solo n preguntas del total
     * @param examen el examen con todas las preguntas 
     * @param numeroPreguntas numero de preguntas que se requieren de ese examen
     * @return examenNPreguntas examen que cuenta con n preguntas del total
     */
    public Examen escogerNPreguntas(Examen examen,int numeroPreguntas){
        Examen examenNPreguntas=new Examen();
        int aleatorio=0;
        ArrayList<Pregunta> preguntas =  new ArrayList();
        Pregunta P = new Pregunta();
        //obtiene la lista de preguntas de un examen
        preguntas = examen.getListaPreguntasSeparadas();
        //obtiene preguntas en orden aleatorio y las guarda en examenAleatorio
        for(int i=0;i<numeroPreguntas;i++){
            aleatorio =(int) Math.floor(Math.random()*(preguntas.size()));
            P = preguntas.get(aleatorio);
            examenNPreguntas.setPreguntaALista(P);
            boolean exito = preguntas.remove(P);
        }    
        return examenNPreguntas;
    }
    
}
