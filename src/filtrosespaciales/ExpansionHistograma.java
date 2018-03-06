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
public class ExpansionHistograma {
    
    public static Image expansionLineal(int r1,int r2,Image imagen){
    BufferedImage aux = ImageManager.toBufferedImage(imagen);
    
        for (int x=0; x< aux.getWidth();x++)
            for(int y=0; y< aux.getHeight();y++){
              // obtener el color
              Color pixel = new Color(aux.getRGB(x, y));
              int r = validar((pixel.getRed()-r1)*(255/(r2-r1)));
              int g = validar((pixel.getGreen()-r1)*(255/(r2-r1)));
              int b = validar((pixel.getBlue()-r1)*(255/(r2-r1)));
            // validamos 
            pixel = new Color(r, g, b);
            aux.setRGB(x, y, pixel.getRGB());
            }
        
        return aux;
    }

    public static Image expansionLn(Image imagen){
    BufferedImage aux = ImageManager.toBufferedImage(imagen);
    
        for (int x=0; x< aux.getWidth();x++)
            for(int y=0; y< aux.getHeight();y++){
              // obtener el color
              Color pixel = new Color(aux.getRGB(x, y));
              int r = (int)((255*Math.log(1+pixel.getRed()))/(Math.log(1+255)));
              int g = (int)((255*Math.log(1+pixel.getGreen()))/(Math.log(1+255)));
              int b = (int)((255*Math.log(1+pixel.getBlue()))/(Math.log(1+255)));
             
            // validamos 
            pixel = new Color(r, g, b);
            aux.setRGB(x, y, pixel.getRGB());
            }
        
        return aux;
    
    }
    public static Image expansionExp(Image imagen, double z){
    BufferedImage aux = ImageManager.toBufferedImage(imagen);
    
        for (int x=0; x< aux.getWidth();x++)
            for(int y=0; y< aux.getHeight();y++){
              // obtener el color
              Color pixel = new Color(aux.getRGB(x, y));
              int r = validar((int)(Math.pow(1+z,pixel.getRed())/z));
              int g = validar((int)(Math.pow(1+z,pixel.getGreen())/z));
              int b = validar((int)(Math.pow(1+z,pixel.getBlue())/z));
             
            // validamos 
            pixel = new Color(r, g, b);
            aux.setRGB(x, y, pixel.getRGB());
            }
        
        return aux;
    
    }
    
    public static int calcularMinimo(double h[]){
    
     for(int x=0; x<h.length;x++){
        if(h[x]!=0) return x;
     }
        return -1;
    }
    
    public static int calcularMaximo(double h[]){
    
     for(int x=h.length-1; x>=0;x--){
        if(h[x]!=0) return x;
     }
        return -1;
    }
    private static int validar(int i) {
        if(i<0)return 0;
        if(i>255)return 255;
        
        return i;
    }
}
