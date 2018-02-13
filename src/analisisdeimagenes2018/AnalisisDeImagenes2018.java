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
        BufferedImage bi = ImageManager.toBufferedImage(aux);
        Color verde = new Color(0, 255, 27);
        
        for(int x = 250; x<=300;x++)
            for(int y = 200; y <=250;y++){
        // modificar pixel por pixel
        bi.setRGB(x, y, verde.getRGB());
            
        }
        
//        Color color = new Color(bi.getRGB(250, 200));
//        int r = color.getRed();
//        int g = color.getGreen();
//        int b = color.getBlue();
        
        
        System.out.println();
        
        ImageJFrame frame = new ImageJFrame(ImageManager.toImage(bi));
        
    }
    
}
