/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisdeimagenes2018;

import filtrosespaciales.Convolucion;
import filtrosespaciales.Temperatura;
import gui.ImageJFrame;
import gui.PrincipalJFrame;
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
//        Image aux = ImageManager.openImage();
//        ImageJFrame frame = new ImageJFrame(aux);
//      
//        Image i1 = Temperatura.modificarTemeratura(aux, -100);
//        Image i2 = Temperatura.modificarTemeratura(aux, 100);
//        
//       
//        ImageJFrame frame2 = new ImageJFrame(i1);
//        ImageJFrame frame3 = new ImageJFrame(i2);
//      
        PrincipalJFrame principal = new PrincipalJFrame();
        principal.setVisible(true);
        System.out.println();
    }
    
}
