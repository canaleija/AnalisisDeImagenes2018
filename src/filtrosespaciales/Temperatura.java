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
public class Temperatura {
    
    public static Image modificarTemeratura(Image io,int constante){
        BufferedImage imagen = ImageManager.toBufferedImage(io);
        // recorremos la imagen
        for (int x=0; x< imagen.getWidth();x++){
            for (int y=0; y< imagen.getHeight();y++){
            Color color = new Color(imagen.getRGB(x, y));
            int r = color.getRed()+constante;
            int g = color.getGreen();
            int b = color.getBlue()-constante;
          
            // validamos 
            if(r<0)r=0;
            if(r>255)r=255;
            if(b<0)b=0;
            if(b>255)b=255;
            color = new Color(r, g, b);
            imagen.setRGB(x, y, color.getRGB());
            }
          }
       return ImageManager.toImage(imagen);
    }
    
}
