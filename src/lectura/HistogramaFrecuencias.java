/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lectura;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author Roberto Cruz Leija
 */
public class HistogramaFrecuencias {
    
    //public enum Color{GRIS,VERDE,ROJO,AZUL}
    
    public static double[] calcularHistograma(int color, Image imagen){
         double frecuencias[] = new double[256];
         BufferedImage aux = ImageManager.toBufferedImage(imagen);
            
         //recorremos la imagen 
         for (int x=0; x < aux.getWidth();x++)
            for (int y=0; y < aux.getHeight();y++){
            Color pixel = new Color(aux.getRGB(x, y));
            // verificamos el tipo de color
                if(color == 0){
                
                }
                if(color == 1){
                frecuencias[pixel.getRed()]++;
                }
                if(color == 2){
                frecuencias[pixel.getGreen()]++;
                }
                if(color == 3){
                frecuencias[pixel.getBlue()]++;
                }
                
            
            }
         return frecuencias;    
         
    }
    
}
