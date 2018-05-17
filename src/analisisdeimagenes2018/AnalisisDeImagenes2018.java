/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisdeimagenes2018;

import analisisenfrecuencias.filtros.FiltroButterworthyPasaBajas;
import analisisenfrecuencias.filtros.FiltroIdealPasaAltas;
import analisisenfrecuencias.filtros.FiltroIdealPasaBajas;
import gui.ImageJFrame;
import java.awt.Dimension;
import java.awt.Image;

/**
 *
 * @author Roberto Cruz Leija
 */
public class AnalisisDeImagenes2018 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FiltroButterworthyPasaBajas filtro = new FiltroButterworthyPasaBajas(170, new Dimension(512,512),3);
        
        Image ifiltro = filtro.crearFiltro();
        
        ImageJFrame frame = new ImageJFrame(ifiltro);
    }
    
}
