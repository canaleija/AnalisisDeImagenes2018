/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrosespaciales;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ReduccionRuido {
    
    public static void reduccionPorMediana(BufferedImage io, int dim){
        //BufferedImage io = ImageManager.toBufferedImage(imagen);
        // recorrer la imagen
        for(int x=0; x<io.getWidth();x++){
            for(int y=0;y<io.getHeight();y++){
             int valorRGB = generarRepMediana(x,y,io,dim);
             io.setRGB(x, y, valorRGB);
            }
        }
    }
    
    public static void reduccionPorMedia(BufferedImage io, int dim){
        //BufferedImage io = ImageManager.toBufferedImage(imagen);
        // recorrer la imagen
        for(int x=0; x<io.getWidth();x++){
            for(int y=0;y<io.getHeight();y++){
             int valorRGB = generarRepMedia(x,y,io,dim);
             io.setRGB(x, y, valorRGB);
            }
        }
    }

    private static int generarRepMediana(int x, int y, BufferedImage io,int dim) {
        ArrayList<Integer> datosRojo = new ArrayList<>();
        ArrayList<Integer> datosVerde = new ArrayList<>();
        ArrayList<Integer> datosAzul = new ArrayList<>();
        // recorremos la imagen 
         for(int i=x-(dim-1)/2;i<=x+(dim-1)/2;i++){
            for(int j=y-(dim-1)/2;j<=y+(dim-1)/2;j++){
                Color color;
                try {
                    color = new Color(io.getRGB(i, j));
                    datosRojo.add(color.getRed());
                    datosVerde.add(color.getGreen());
                    datosAzul.add(color.getBlue());
                } catch (Exception e) {
                    // no agregamos nada
                    System.out.println();
                }
            }
         }
         // ordenamos los arreglos 
        Collections.sort(datosAzul);
        Collections.sort(datosVerde);
        Collections.sort(datosRojo);
        // calculamos la pos de la mediana
        int index =  datosRojo.size()/2;
        // obtenemos el valor representativo por color
        int r = datosRojo.get(index);
        int g = datosVerde.get(index);
        int b = datosAzul.get(index);
        // creamos el nuevo color y retornamos el RGB
        return new Color(r, g, b).getRGB();
    }

    private static int generarRepMedia(int x, int y, BufferedImage io, int dim) {
    
        int datosRojo = 0;
        int datosVerde = 0;
        int datosAzul = 0;
       int contador= 0;
        // recorremos la imagen 
         for(int i=x-(dim-1)/2;i<=x+(dim-1)/2;i++){
            for(int j=y-(dim-1)/2;j<=y+(dim-1)/2;j++){
                Color color;
                try {
                    color = new Color(io.getRGB(i, j));
                    datosRojo+=color.getRed();
                    datosVerde+=color.getGreen();
                    datosAzul+=color.getBlue();
                    contador++;
                } catch (Exception e) {
                    // no agregamos nada
                   // System.out.println();
                }
            }
         }
       
        // obtenemos el valor representativo por color
        int r = datosRojo/contador;
        int g = datosVerde/contador;
        int b = datosAzul/contador;
        // creamos el nuevo color y retornamos el RGB
        return new Color(r, g, b).getRGB();
    }
    }
