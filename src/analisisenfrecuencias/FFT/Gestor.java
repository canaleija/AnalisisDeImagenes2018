/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisenfrecuencias.FFT;

import analisisenfrecuencias.FFT.HerramientasColor.CanalColor;
import filtrosespaciales.Convolucion;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Gestor {
    
    private BufferedImage imagenOriginal;
    public Map<HerramientasColor.CanalColor,NumeroComplejo[][]>
            representacionEspacial;
    public Map<HerramientasColor.CanalColor,NumeroComplejo[][]>
            representacionFrecuencias;

    public Gestor(BufferedImage imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
        this.representacionEspacial = new HashMap<HerramientasColor.CanalColor,NumeroComplejo[][]>();
        this.representacionFrecuencias = new HashMap<HerramientasColor.CanalColor,NumeroComplejo[][]>();
   
        for (CanalColor color: HerramientasColor.CanalColor.values()){
            representacionEspacial.put(color,obtenerDatosPorCanal(imagenOriginal,color));
        }
      
    }

    private NumeroComplejo[][] obtenerDatosPorCanal(BufferedImage imagenOriginal, CanalColor color) {
     NumeroComplejo[][] aux = new NumeroComplejo[imagenOriginal.getWidth()][imagenOriginal.getHeight()];
      // obtenemos los datos por canal
     for (int x=0; x<imagenOriginal.getWidth();x++){
        for (int y=0; y<imagenOriginal.getHeight();y++){
      aux[x][y] = new NumeroComplejo(HerramientasColor.obtenerValorPorCanal(imagenOriginal.getRGB(x, y), color), 0);
     }
   }

    
   return aux; 
    }
    
    public BufferedImage obtenerImagenFrecuencias(boolean reAjustarCuadrante){
        /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        BufferedImage aux = new BufferedImage(anchoImagen, altoImagen,BufferedImage.TYPE_INT_ARGB);
        
        
        FFTCalculo fft = new FFTCalculo();
        // construir el mapeo de representacion en frecuencias utilizando FFT
        
        for (CanalColor canal: HerramientasColor.CanalColor.values()){
            NumeroComplejo[][] datos = this.representacionEspacial.get(canal);
            NumeroComplejo[][] transformada = fft.calculateFT(datos,false);
            representacionFrecuencias.put(canal, transformada);
            // crear la imagen del espectro 
            for (int x=0; x<anchoImagen;x++){
                for(int y=0;y<altoImagen;y++){
                 // modificamos la posicion de los cuadrantes 
                 int ejeX = reAjustarCuadrante ? (x+(anchoImagen/2))% anchoImagen:x;
                 int ejeY = reAjustarCuadrante ? (y+(altoImagen/2))% altoImagen:y;
                // setear la info a la imagen 
                // el que se ecuentre en la imagen 
                int color1 =  aux.getRGB(x, y);
                int color2 = obtenerColorRealDeFrecuencia(ejeX,ejeY,transformada,canal);
                int rgb =  HerramientasColor.acumularColor(color1, color2);
                aux.setRGB(ejeX, ejeY, rgb);
                 
                }
            
            }

        }
      return aux;
    }

    private int obtenerColorRealDeFrecuencia(int ejeX, int ejeY, NumeroComplejo[][] transformada, CanalColor canal) {
        int color = (int) Math.abs(transformada[ejeX][ejeY].getParteReal());
        color = Convolucion.validarValor(color);
        color = HerramientasColor.obtenerRGBPorCanal(color, canal);
        return color;
    }
}
