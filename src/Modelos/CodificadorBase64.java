package Modelos;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import javax.imageio.ImageIO;

public class CodificadorBase64{
    
    public CodificadorBase64(){
        
    }
    /**
     * 
     * @param imagen la imagen que se va a codificar a una cadena Base64
     * @param tipo El tipo de la imagen que se convierte(jpg,png)
     * @return La cadena de la imagen codificada
     */
    public String imagenACadena (BufferedImage imagen, String tipo){
        
        String imagenString= null;
        ByteArrayOutputStream bos= new ByteArrayOutputStream();
        try{
            Base64.Encoder encoder = Base64.getEncoder();
            ImageIO.write(imagen, tipo, bos);
            byte[] imageBytes = bos.toByteArray();
            
            imagenString = encoder.encodeToString(imageBytes);
            bos.close();
            
        }catch(IOException e){
            System.out.println("No se encontro la imagen");
        }
        return imagenString;
    }
    /**
     * 
     * @param imageString La cadena codificada de una imagen en Base64
     * @return La imagen decodificada de la cadena en Base64
     */
    public BufferedImage cadenaAImagen(String imageString){
        BufferedImage image= null;
        byte[] imageByte;
        try{
            Base64.Decoder decoder = Base64.getDecoder();
            imageByte = decoder.decode(imageString);
            try (ByteArrayInputStream bis = new ByteArrayInputStream(imageByte)) {
                image = ImageIO.read(bis);
            }
        }catch(Exception e){
        }
        return image;
    }    
}
