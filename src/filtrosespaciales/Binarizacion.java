/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrosespaciales;


import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import lectura.ImageManager;


/**
 *
 * @author Roberto Cruz Leija
 */
public class Binarizacion {
    
   
    public static Image umbralizacionSimple(int umbral, Image imagenOriginal){
      
        BufferedImage aux = ImageManager.toBufferedImage(imagenOriginal);
        // recorremos la imagen
        for (int x=0; x< aux.getWidth();x++)
            for(int y=0; y< aux.getHeight();y++){
                Color pixel = new Color(aux.getRGB(x, y));
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();
                // modificamos el rojo 
                if(pixel.getRed()<umbral)
                    r = 0;
                if(pixel.getGreen()<umbral)
                    g = 0;
                if(pixel.getBlue()<umbral)
                    b = 0;
                pixel = new Color(r, g, b);
                aux.setRGB(x, y, pixel.getRGB());
            
            }
        return ImageManager.toImage(aux);
    }
    
    public static Image umbralizacionSimple(int umbral,int umbral2 ,Image imagenOriginal){
    
        
        BufferedImage aux = ImageManager.toBufferedImage(imagenOriginal);
        // recorremos la imagen
        for (int x=0; x< aux.getWidth();x++)
            for(int y=0; y< aux.getHeight();y++){
                Color pixel = new Color(aux.getRGB(x, y));
                int r = pixel.getRed();
                int g = pixel.getGreen();
                int b = pixel.getBlue();
                // modificamos el rojo 
                if(pixel.getRed()<umbral||pixel.getRed()>umbral2)
                    r = 0;
                if(pixel.getGreen()<umbral||pixel.getGreen()>umbral2)
                    g = 0;
                if(pixel.getBlue()<umbral||pixel.getBlue()>umbral2)
                    b = 0;
                pixel = new Color(r, g, b);
                aux.setRGB(x, y, pixel.getRGB());
            
            }
        return ImageManager.toImage(aux);
    
    }
    
}
