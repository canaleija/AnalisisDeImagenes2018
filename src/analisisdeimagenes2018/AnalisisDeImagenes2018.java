/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisdeimagenes2018;

import filtrosespaciales.ExpansionHistograma;
import filtrosespaciales.FiltroEspacial;
import filtrosespaciales.UmbralAutomatico;
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
        Image aux = FiltroEspacial.generaEscalaGrises(ImageManager.openImage());
        ImageJFrame frame = new ImageJFrame(aux);
      
        // 3 histogramas 
        double hGrises []= HistogramaFrecuencias.calcularHistograma(1, aux);

          
        Grafica grafica = new Grafica("Tono","Frecuencia","Frecuencias de Color");
        grafica.agregarSerie("Gris", hGrises);
        
        grafica.crearYmostrarGrafica();
        int umbral = UmbralAutomatico.metodoIterativo(hGrises);
       
        Image bi = FiltroEspacial.umbralizacionSimple(umbral, aux);
        ImageJFrame frame2 = new ImageJFrame(bi);
        
        System.out.println();
    }
    
}
