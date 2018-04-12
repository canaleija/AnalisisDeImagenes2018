/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisdeimagenes2018;

import filtrosespaciales.Convolucion;
import gui.ImageJFrame;
import java.awt.Image;
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
      

        Convolucion convo = new Convolucion(aux);
        Image res = convo.aplicarKirsch(1);
                
        
       // Image nueva = ImageManager.toImage(res);
        ImageJFrame frame2 = new ImageJFrame(res);
      
      
        System.out.println();
    }
    
}
