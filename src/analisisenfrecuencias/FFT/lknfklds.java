/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisenfrecuencias.FFT;

import analisisenfrecuencias.filtros.FiltroFrecuencia;
import analisisenfrecuencias.filtros.FiltroIdealPasaBajas;
import gui.ImageJFrame;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import lectura.ImageManager;

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
     
      // creamos el filtro
        FiltroIdealPasaBajas fipb = new FiltroIdealPasaBajas(30,new Dimension(512, 512));
        fipb.crearFiltro();
        NumeroComplejo [][] filtro = fipb.getFiltroEspacial();
        ImageJFrame frameFil = new ImageJFrame(fipb.getImagen());
     gestor.aplicarFiltro(filtro);
      
      
      BufferedImage imagenEspacial = gestor.obtenerImagenEspacial();
       ImageJFrame frame = new ImageJFrame(ImageManager.toImage(imagenEspacial));
     
    
    }
    
}
