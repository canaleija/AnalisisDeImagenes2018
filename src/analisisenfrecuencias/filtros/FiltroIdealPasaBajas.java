/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisenfrecuencias.filtros;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import lectura.ImageManager;

/**
 *
 * @author Roberto Cruz Leija
 */
public class FiltroIdealPasaBajas extends FiltroFrecuencia{

    private int radio;
    private Dimension dim;
    
    public FiltroIdealPasaBajas(int radio, Dimension dim) {
        super((int)dim.getWidth(),(int) dim.getHeight());
        this.radio = radio;
        this.dim = dim;
    }
   
    @Override
    public Image crearFiltro() {
       // incializar el buffer
        BufferedImage bi = new BufferedImage((int)dim.getWidth(),
                     (int)dim.getHeight(), BufferedImage.TYPE_INT_ARGB);
    int tamanoImagen = bi.getWidth();
    for(int i=0; i < bi.getWidth();i++){
        for(int j=0; j < bi.getHeight();j++){
            int u = -1*(tamanoImagen/2)+i;
            int v = (tamanoImagen/2)-j;
            
            double r = Math.sqrt(Math.pow(u,2)+Math.pow(v, 2));
            // verificamos con respecto al  radio
            if(r<=this.radio){
                // asignamos el valor al filtro
                getFiltroEspacial()[i][j] = new NumeroComplejo(1, 1);
                // asignamos el valor a la imagen
                bi.setRGB(i, j, new Color(255, 255, 255).getRGB());
            }  else {
            
                 // asignamos el valor al filtro
                getFiltroEspacial()[i][j] = new NumeroComplejo(0, 0);
                // asignamos el valor a la imagen
                bi.setRGB(i, j, new Color(0, 0, 0).getRGB());
            
            }     
        }
    }    
        
     return ImageManager.toImage(bi);
    }
    
    public Image modificarFiltro(int radio){
      this.radio = radio;
      return crearFiltro();
    }
}
