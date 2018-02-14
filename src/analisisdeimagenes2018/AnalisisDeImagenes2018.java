/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisdeimagenes2018;

import gui.ImageJFrame;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import lectura.Grafica;
import lectura.HistogramaFrecuencias;
import lectura.ImageManager;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AnalisisDeImagenes2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Image aux = ImageManager.openImage();
        ImageJFrame frame = new ImageJFrame(aux);
       
        // 3 histogramas 
        double hRojo []= HistogramaFrecuencias.calcularHistograma(1, aux);
        double hVerde []= HistogramaFrecuencias.calcularHistograma(2, aux);
        double hAzul []= HistogramaFrecuencias.calcularHistograma(3, aux);
        
        Grafica grafica = new Grafica("Tono","Frecuencia","Frecuencias de Color");
        grafica.agregarSerie("Rojo", hRojo);
        grafica.agregarSerie("Verde", hVerde);
        grafica.agregarSerie("Azul", hAzul);
        grafica.crearYmostrarGrafica();
        
        BufferedImage bi = ImageManager.toBufferedImage(aux);
       
        
        
        
    }
    
}
