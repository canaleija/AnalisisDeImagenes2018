/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisdeimagenes2018;

import filtrosespaciales.Convolucion;
import filtrosespaciales.DispersionHistograma;
import filtrosespaciales.ExpansionHistograma;
import filtrosespaciales.FiltroEspacial;
import filtrosespaciales.UmbralAutomatico;
import gui.ImageJFrame;
import java.awt.Image;
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
        int kernel [][] = new int[][]{{2,1,1,1,1},{2,1,1,1,1},{2,1,1,1,1},{2,1,1,1,1},{2,1,1,1,1}};
        Convolucion convo = new Convolucion(aux);
        Image nueva = convo.aplicar(kernel, 1);
        ImageJFrame frame2 = new ImageJFrame(nueva);
      
      
        System.out.println();
    }
    
}
