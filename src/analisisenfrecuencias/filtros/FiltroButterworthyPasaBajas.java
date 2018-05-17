/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisenfrecuencias.filtros;

import analisisenfrecuencias.FFT.NumeroComplejo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import lectura.ImageManager;

/**
 *
 * @author Roberto Cruz Leija
 */
public class FiltroButterworthyPasaBajas extends FiltroFrecuencia{

    private int radio;
    private Dimension dim;
    private int n;
    
    public FiltroButterworthyPasaBajas(int radio, Dimension dim, int n) {
        super((int)dim.getWidth(),(int) dim.getHeight());
        this.radio = radio;
        this.dim = dim;
        this.n = n;
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
            
            double r  = Math.sqrt(Math.pow(u,2)+Math.pow(v, 2));
            double valor = 1/(1+Math.pow((r/this.radio),2*this.n));
             // verificamos con respecto al  radio
            int gris = (int)(255*valor); 
            if(r<=this.radio){
                // asignamos el valor al filtro
                getFiltroEspacial()[i][j] = new NumeroComplejo(valor, valor);
                // asignamos el valor a la imagen
                bi.setRGB(i, j, new Color(gris,gris,gris).getRGB());
            }  else {
            
                 // asignamos el valor al filtro
                getFiltroEspacial()[i][j] = new NumeroComplejo(valor, valor);
                // asignamos el valor a la imagen
                bi.setRGB(i, j, new Color(gris,gris, gris).getRGB());
            
            }     
        }
    }    
        
     return ImageManager.toImage(bi);
    }
    public Image modificarFiltro(int radio, int n){
      this.n = n;  
      this.radio = radio;
      return crearFiltro();
    }
}
