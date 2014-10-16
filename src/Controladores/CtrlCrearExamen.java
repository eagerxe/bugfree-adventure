package Controladores;
import Modelos.Examen;
import Modelos.ExamenTex;
import Modelos.PreguntasTex;
import java.util.ArrayList;

/**
 *
 * @author miguelhernandez
 */
public class CtrlCrearExamen {
    
    
    
    /**
     * Se encarga de crear el examen usando los modelos necesarios
     * @param direccion La ruta al archivo LaTeX proporcionada
     * 
     */
    public CtrlCrearExamen(String direccion,String direccionDestino,Boolean aleatorio,String numeroPreguntas){
        //direccionDestino = "/Users/miguelhernandez/Desktop/nuevoExamen.tex";
        direccionDestino = direccionDestino + "/nuevoExamen.tex";
        
        
        //Crea una instancia de PreguntasTex para separar las preguntas 
        PreguntasTex PT = new PreguntasTex();
        //Crea una instancia de ExamenTex donde guardar el examen creado por 
        //separar preguntas
        Examen examen= new Examen(); 
        examen=PT.separarPreguntasTex(direccion);
        //Se realiza el orden aleatorio al examen
        if(aleatorio){
            examen = examen.ordenAleatorio(examen);
        }
        
        //Se escogen solo n preguntas del examen
        if(numeroPreguntas.contains("Todas")){
            System.out.println("todas las preguntas");
        }else if (numeroPreguntas.contentEquals("5")){
            int numeroPregunta=5;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
        }else if(numeroPreguntas.contentEquals("10")){
            int numeroPregunta = 10;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
        }else if(numeroPreguntas.contentEquals("15")){
            int numeroPregunta = 15;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
        }else if(numeroPreguntas.contentEquals("20")){
            int numeroPregunta = 20;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
        }else{
            int numeroPregunta = Integer.parseInt(numeroPreguntas);
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
        }
        
        
        //Crea una instancia de ExamenTex para generar el examen 
        ExamenTex ET;
        ET = new ExamenTex();
        
        ET.generarCabecera(direccionDestino);
        ET.generarExamenTex(direccionDestino, examen);
        ET.generarFinalExamen(direccionDestino);
        
        
        
    }
    
    
    public CtrlCrearExamen(String direccion,String direccion2,String direccionDestino,Boolean aleatorio,String numeroPreguntas){
        //direccionDestino = "/Users/miguelhernandez/Desktop/nuevoExamen.tex";
        direccionDestino = direccionDestino + "/nuevoExamen.tex";
        
        
        //Crea una instancia de PreguntasTex para separar las preguntas 
        PreguntasTex PT = new PreguntasTex();
        PreguntasTex PT2 = new PreguntasTex();
        //Crea una instancia de ExamenTex donde guardar los examenes creado por 
        //separar preguntas
        Examen examen = new Examen(); 
        Examen examen2 = new Examen();
        //Separa las preguntas de cada examen
        examen = PT.separarPreguntasTex(direccion);
        examen2 = PT2.separarPreguntasTex(direccion2);
        //Se realiza el orden aleatorio a los exámenes
        if(aleatorio){
            examen = examen.ordenAleatorio(examen);
            examen2 = examen2.ordenAleatorio(examen2);
        }
        
        //Se escogen solo n preguntas del examen
        if(numeroPreguntas.contains("Todas")){
            System.out.println("todas las preguntas");
        }else if (numeroPreguntas.contentEquals("5")){
            int numeroPregunta=5;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
            examen2 = examen2.escogerNPreguntas(examen2, numeroPregunta);
        }else if(numeroPreguntas.contentEquals("10")){
            int numeroPregunta = 10;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
            examen2 = examen.escogerNPreguntas(examen2, numeroPregunta);
        }else if(numeroPreguntas.contentEquals("15")){
            int numeroPregunta = 15;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
            examen2 = examen.escogerNPreguntas(examen2, numeroPregunta);
        }else if(numeroPreguntas.contentEquals("20")){
            int numeroPregunta = 20;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
            examen2 = examen.escogerNPreguntas(examen2, numeroPregunta);
        }else{
            int numeroPregunta = Integer.parseInt(numeroPreguntas);
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
            examen2 = examen.escogerNPreguntas(examen2, numeroPregunta);
        }
        
        
        //Crea una instancia de ExamenTex para generar el examen 
        ExamenTex ET;
        ET = new ExamenTex();
        
        ET.generarCabecera(direccionDestino);
        ET.generarExamenTex(direccionDestino, examen);
        ET.generarExamenTex(direccionDestino, examen2);
        ET.generarFinalExamen(direccionDestino);
        
        
    }
    
    public CtrlCrearExamen(String direccion,String direccion2,String direccion3,String direccionDestino,Boolean aleatorio,String numeroPreguntas){
        //direccionDestino = "/Users/miguelhernandez/Desktop/nuevoExamen.tex";
        direccionDestino = direccionDestino + "/nuevoExamen.tex";
        
        
        //Crea una instancia de PreguntasTex para separar las preguntas 
        PreguntasTex PT = new PreguntasTex();
        PreguntasTex PT2 = new PreguntasTex();
        PreguntasTex PT3 = new PreguntasTex();
        //Crea una instancia de ExamenTex donde guardar los examenes creado por 
        //separar preguntas
        Examen examen = new Examen(); 
        Examen examen2 = new Examen();
        Examen examen3 = new Examen();
        //Separa las preguntas de cada examen
        examen = PT.separarPreguntasTex(direccion);
        examen2 = PT2.separarPreguntasTex(direccion2);
        examen3 = PT3.separarPreguntasTex(direccion3);
        //Se realiza el orden aleatorio a los exámenes
        if(aleatorio){
            examen = examen.ordenAleatorio(examen);
            examen2 = examen2.ordenAleatorio(examen2);
            examen3 = examen3.ordenAleatorio(examen3);
        }
        
        //Se escogen solo n preguntas del examen
        if(numeroPreguntas.contains("Todas")){
            System.out.println("todas las preguntas");
        }else if (numeroPreguntas.contentEquals("5")){
            int numeroPregunta=5;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
            examen2 = examen2.escogerNPreguntas(examen2, numeroPregunta);
            examen3 = examen3.escogerNPreguntas(examen3, numeroPregunta);
        }else if(numeroPreguntas.contentEquals("10")){
            int numeroPregunta = 10;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
            examen2 = examen.escogerNPreguntas(examen2, numeroPregunta);
            examen3 = examen.escogerNPreguntas(examen3, numeroPregunta);
        }else if(numeroPreguntas.contentEquals("15")){
            int numeroPregunta = 15;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
            examen2 = examen.escogerNPreguntas(examen2, numeroPregunta);
            examen3 = examen.escogerNPreguntas(examen3, numeroPregunta);
        }else if(numeroPreguntas.contentEquals("20")){
            int numeroPregunta = 20;
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
            examen2 = examen.escogerNPreguntas(examen2, numeroPregunta);
            examen3 = examen.escogerNPreguntas(examen3, numeroPregunta);
        }else{
            int numeroPregunta = Integer.parseInt(numeroPreguntas);
            examen = examen.escogerNPreguntas(examen, numeroPregunta);
            examen2 = examen.escogerNPreguntas(examen2, numeroPregunta);
            examen3 = examen.escogerNPreguntas(examen3, numeroPregunta);
        }
        
        
        //Crea una instancia de ExamenTex para generar el examen 
        ExamenTex ET;
        ET = new ExamenTex();
        
        ET.generarCabecera(direccionDestino);
        ET.generarExamenTex(direccionDestino, examen);
        ET.generarExamenTex(direccionDestino, examen2);
        ET.generarExamenTex(direccionDestino, examen3);
        ET.generarFinalExamen(direccionDestino);
        
    }
    
    
    
    
}
