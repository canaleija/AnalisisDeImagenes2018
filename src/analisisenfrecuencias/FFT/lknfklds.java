/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisenfrecuencias.FFT;

import gui.ImageJFrame;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import lectura.ImageManager;
import org.jfree.chart.ChartColor;

/**
 *
 * @author Roberto Cruz Leija
 */
public class lknfklds {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      Image imagenO = ImageManager.openImage();
      ImageJFrame frame1 = new ImageJFrame(imagenO);
      Gestor gestor = new Gestor(ImageManager.toBufferedImage(imagenO));
      BufferedImage iFre = gestor.obtenerImagenFrecuencias(true);
      ImageJFrame frame2 = new ImageJFrame(ImageManager.toImage(iFre));
      
    }
    
}
