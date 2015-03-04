package Modelos;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;
/**
 * Codificador de imagen a cadena y de cadena a imagen
 * @author miguelhernandez
 */
public class CodificadorBase64{
    
    public CodificadorBase64(){
        
    }
    /**
     * Convierte una imagen a una cadena usando Base64
     * @param imagen la imagen que se va a codificar a una cadena Base64
     * @param tipo El tipo de la imagen que se convierte(jpg,png)
     * @return La cadena de la imagen codificada
     */
    public String imagenACadena (BufferedImage imagen, String tipo){
        
        String imagenCadena= null;
        ByteArrayOutputStream bos= new ByteArrayOutputStream();
        try{
            Base64.Encoder codificador = Base64.getEncoder();
            ImageIO.write(imagen, tipo, bos);
            byte[] imagenBytes = bos.toByteArray();
            
            imagenCadena = codificador.encodeToString(imagenBytes);
            bos.close();
            
        }catch(IOException e){
            System.out.println("No se encontro la imagen");
        }
        return imagenCadena;
    }
    /**
     * Convierte una cadena en una imagen usando Base64
     * @param cadenaImagen La cadena codificada de una imagen en Base64
     * @return La imagen decodificada de la cadena en Base64
     */
    public BufferedImage cadenaAImagen(String cadenaImagen){
        BufferedImage imagen= null;
        byte[] imagenByte;
        try{
            Base64.Decoder decodificador = Base64.getDecoder();
            imagenByte = decodificador.decode(cadenaImagen);
            try (ByteArrayInputStream bis = new ByteArrayInputStream(imagenByte)) {
                imagen = ImageIO.read(bis);
            }
        }catch(Exception e){
            System.out.println("Error al convertir cadena");
        }
        return imagen;
    }    
}
