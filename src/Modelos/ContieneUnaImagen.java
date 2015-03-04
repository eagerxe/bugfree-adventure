package Modelos;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 * Checa si el renglon contiene una imagen, de ser asi la convierte a cadena
 * @author miguelhernandez
 * 
 */
public class ContieneUnaImagen {
    
    private boolean contieneImagen;
    private String tipo;
    private String renglonaux;
    
    public ContieneUnaImagen(){
        this.contieneImagen = false;
        tipo = "";
    }
    /**
     * Si el renglon contiene una imagen la convierte a una cadena y la regresa
     * @param renglon el renglon que se verificará para saber si contiene la 
     * dirección de una imagen
     * @param direccionPadre La dirección de la carpeta donde se ubica la imagen
     * @return Una cadena de la imagen codificada en Base64
     */
    public String contieneImagenes(String renglon,String direccionPadre){
        
        if(renglon.contains("\\includegraphics")){
            
            try{
                renglon=renglon.replace("\\includegraphics","");
                renglon=renglon.replace("{","");
                renglon=renglon.replace("}","");
                renglon=renglon.replace("[","");
                renglon=renglon.replace("]","");
                renglon=renglon.replace("=","");
                renglon=renglon.replace("scale","");
                String patron;
                patron = "\\d+(\\.\\d+)?";
                renglon=renglon.replaceAll(patron,"");
            }catch(NumberFormatException exc){
                System.out.println("No se encontro el caracter para reemplazar en la pregunta");
            }  
            String nombreImagen = renglon;
            if (renglon.contains("jpg")){
                tipo="jpg";
            }else if(renglon.contains("png")){
                tipo="png";
            }else{
                System.out.println("No se acepta este tipo de imagen");
            }
            renglon = direccionPadre +"/"+ renglon;
            CodificadorBase64 CB= new CodificadorBase64();
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File(renglon)); 
            } catch (IOException ex) {
                Logger.getLogger(PreguntasTex.class.getName()).log(Level.SEVERE, null, ex);
            }
            renglonaux = "\n<image>"+ nombreImagen +"</image>\n";
            String cadenaBase64 = CB.imagenACadena(img, tipo);
            renglonaux = renglonaux + "<image_base64>"+ cadenaBase64 +"</image_base64>\n";
            System.out.println(renglonaux);
            renglon=renglonaux;
        }
        return renglon;
    }
    /**
     * Para saber si el renglon contiene una imagen
     * @param renglon un renglon de la pregunta
     * @return true si contiene una imagen false de lo contrario
     */
    public boolean contieneUnaImagen(String renglon){
        if(renglon.contains("\\includegraphics")){
            contieneImagen=true;
        }else {
            contieneImagen= false;
        }
        return contieneImagen;
    }
}
