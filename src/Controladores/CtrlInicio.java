package Controladores;

import Vistas.CExamen;
import Vistas.ConvertirLatexXML;
import Vistas.ConvertirXMLLatex;
import Vistas.CrearExamen;
import Vistas.Inicio;

/**
 *
 * @author miguelhernandez
 */
public class CtrlInicio {
           
    /**
     * Controlador que se encarga de cargar la vista segun la opcion elegida 
     * @param opcion muestra la opcion elegida por el tutor para la tarea que 
     * se realizara
     */
    public CtrlInicio(int opcion){
        
        if(opcion == 1){
            CrearExamen CE = new CrearExamen();       
            CE.setVisible(true);
        }else if(opcion == 2){
            ConvertirLatexXML CLX = new ConvertirLatexXML();
            CLX.setVisible(true);
        }else if(opcion == 3){
            ConvertirXMLLatex CXL = new ConvertirXMLLatex();
            CXL.setVisible(true);
        }else if (opcion == 4){
            //cancelar 
            Inicio I =  new Inicio();
            I.setVisible(true);
        }else if (opcion == 5){
            CExamen CExa = new CExamen ();
            CExa.setVisible(true);
        }
 
        
    }
    
    
    
    
    
    
}
