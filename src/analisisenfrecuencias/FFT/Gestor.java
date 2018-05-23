/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisenfrecuencias.FFT;

import analisisenfrecuencias.FFT.HerramientasColor.CanalColor;
import filtrosespaciales.Convolucion;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Roberto Cruz Leija
 */
public class Gestor {

    private BufferedImage imagenOriginal;
    public Map<HerramientasColor.CanalColor, NumeroComplejo[][]> representacionEspacial;
    public Map<HerramientasColor.CanalColor, NumeroComplejo[][]> representacionFrecuencias;

    public Gestor(BufferedImage imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
        this.representacionEspacial = new HashMap<HerramientasColor.CanalColor, NumeroComplejo[][]>();
        this.representacionFrecuencias = new HashMap<HerramientasColor.CanalColor, NumeroComplejo[][]>();

        for (CanalColor color : HerramientasColor.CanalColor.values()) {
            representacionEspacial.put(color, obtenerDatosPorCanal(imagenOriginal, color));
        }

    }

    private NumeroComplejo[][] obtenerDatosPorCanal(BufferedImage imagenOriginal, CanalColor color) {
        NumeroComplejo[][] aux = new NumeroComplejo[imagenOriginal.getWidth()][imagenOriginal.getHeight()];
        // obtenemos los datos por canal
        for (int y = 0; y < imagenOriginal.getHeight(); y++) {
            for (int x = 0; x < imagenOriginal.getWidth(); x++) {
                aux[x][y] = new NumeroComplejo(HerramientasColor.obtenerValorPorCanal(imagenOriginal.getRGB(x, y), color), 0);
            }
        }
        return aux;
    }

    public void aplicarFiltro(NumeroComplejo[][] filtro) {

        // recorrer el filtro 
        for (int x = 0; x < this.imagenOriginal.getWidth(); x++) {
            for (int y = 0; y < this.imagenOriginal.getHeight();y++) {
                // obtener el color el RGB de la parte de frecuencias
                if (filtro[x][y].getParteReal()<1){
                int rgb = obtenerPixelDominioFrecuencias(x,y,true);
                Color aux = new Color(rgb);
                int r = (int) (aux.getRed() * filtro[x][y].getParteReal());
                int g = (int) (aux.getGreen()* filtro[x][y].getParteReal());
                int b = (int) (aux.getBlue() * filtro[x][y].getParteReal());
                aux = new Color(r, g, b);
                setPixelDominioFrecuencias(x,y,true,aux.getRGB());}
            }
        }

    }

    public BufferedImage obtenerImagenFrecuencias(boolean reAjustarCuadrante) {
        /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        BufferedImage aux = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_ARGB);

        FFTCalculo fft = new FFTCalculo();
        // construir el mapeo de representacion en frecuencias utilizando FFT

        for (CanalColor canal : HerramientasColor.CanalColor.values()) {
            NumeroComplejo[][] datos = this.representacionEspacial.get(canal);
            NumeroComplejo[][] transformada = fft.calculateFT(datos, false);
            representacionFrecuencias.put(canal, transformada);
            // crear la imagen del espectro 
            for (int y = 0; y < aux.getHeight(); y++) {
                for (int x = 0; x < aux.getWidth(); x++) {
                    // modificamos la posicion de los cuadrantes 
                    int ejeX = reAjustarCuadrante ? (x + (anchoImagen / 2)) % anchoImagen : x;
                    int ejeY = reAjustarCuadrante ? (y + (altoImagen / 2)) % altoImagen : y;
                    // setear la info a la imagen 
                    // el que se ecuentre en la imagen 
                    int color1 = aux.getRGB(x, y);
                    int color2 = obtenerColorRealDeFrecuencia(ejeX, ejeY, transformada, canal);
                    int rgb = HerramientasColor.acumularColor(color1, color2);
                    aux.setRGB(x, y, rgb);

                }
            }
        }
        return aux;
    }

    public BufferedImage obtenerImagenEspacial() {
        /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        BufferedImage aux = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_ARGB);

        FFTCalculo fft = new FFTCalculo();
        // construir el mapeo de representacion en frecuencias utilizando FFT

        for (CanalColor canal : HerramientasColor.CanalColor.values()) {
            NumeroComplejo[][] datos = this.representacionFrecuencias.get(canal);
            NumeroComplejo[][] transformadaInv = fft.calculateFT(datos, true);
            representacionEspacial.put(canal, transformadaInv);
            // crear la imagen del espectro 
            for (int y = 0; y < aux.getHeight(); y++) {
                for (int x = 0; x < aux.getWidth(); x++) {

                    int color = (int) Math.abs(transformadaInv[x][y].getParteReal());
                    color = Convolucion.validarValor(color);
                    color = HerramientasColor.obtenerRGBPorCanal(color, canal);

                    int rgb = HerramientasColor.acumularColor(aux.getRGB(x, y), color);
                    aux.setRGB(x, y, rgb);
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

    private int obtenerPixelDominioFrecuencias(int x, int y, boolean encuadre) {
        /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        // modificamos la posicion de los cuadrantes 
        int ejeX = encuadre ? (x + (anchoImagen / 2)) % anchoImagen : x;
        int ejeY = encuadre ? (y + (altoImagen / 2)) % altoImagen : y;
        
        // acumulamos 
        int valorColor = 0;
        for (CanalColor canal: CanalColor.values()){
        NumeroComplejo[][] aux = representacionFrecuencias.get(canal);
        valorColor += obtenerColorRealDeFrecuencia(ejeX, ejeY,aux, canal);
        }
        
        return valorColor;
    }

    private void setPixelDominioFrecuencias(int x, int y, boolean encuadre, int color) {
         /// obtenemos las dimensiones
        int anchoImagen = this.imagenOriginal.getWidth();
        int altoImagen = this.imagenOriginal.getHeight();
        // modificamos la posicion de los cuadrantes 
        int ejeX = encuadre ? (x + (anchoImagen / 2)) % anchoImagen : x;
        int ejeY = encuadre ? (y + (altoImagen / 2)) % altoImagen : y;
        
        // recorrer por canal de color 
        for (CanalColor canal: CanalColor.values()){
        NumeroComplejo[][] datos = representacionFrecuencias.get(canal);
        int nuevo =  HerramientasColor.obtenerValorPorCanal(color, canal);
        
        datos[ejeX][ejeY] = new NumeroComplejo(nuevo,nuevo);
        
        }
        
    }
}
