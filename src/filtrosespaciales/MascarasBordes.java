/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrosespaciales;

import java.awt.Image;
import java.awt.image.BufferedImage;
import lectura.ImageManager;

/**
 *
 * @author Roberto Cruz Leija
 */
public class MascarasBordes {
    // kirch
    private static double[][] kirsch1 = {{-3, -3, 5}, {-3, 0, 5}, {-3, -3, 5}};
    private static double[][] kirsch2 = {{-3, 5, 5}, {-3, 0, 5}, {-3, -3, -3}};
    private static double[][] kirsch3 = {{5, 5, 5}, {-3, 0, -3}, {-3, -3, -3}};
    private static double[][] kirsch4 = {{5, 5, -3}, {5, 0, -3}, {-3, -3, -3}};
    private static double[][] kirsch5 = {{5, -3, -3}, {5, 0, -3}, {5, -3, -3}};
    private static double[][] kirsch6 = {{-3, -3, -3}, {5, 0, -3}, {5, 5, -3}};
    private static double[][] kirsch7 = {{-3, -3, -3}, {-3, 0, -3}, {5, 5, 5}};
    private static double[][] kirsch8 = {{-3, -3, -3}, {-3, 0, 5}, {-3, 5, 5}};
    public static double[][][] arregloMascaras = {kirsch1, kirsch2, kirsch3,
        kirsch4, kirsch5, kirsch6,
        kirsch7, kirsch8};
   
    
}
