/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisenfrecuencias.filtros;

import java.awt.Image;

/**
 *
 * @author Roberto Cruz Leija
 */
public abstract class FiltroFrecuencia {
    
    private NumeroComplejo[][] filtroEspacial;

    public FiltroFrecuencia(int ancho, int alto) {
        this.filtroEspacial = new NumeroComplejo[ancho][alto];
    }
       
    public abstract Image crearFiltro();

    /**
     * @return the filtroEspacial
     */
    public NumeroComplejo[][] getFiltroEspacial() {
        return filtroEspacial;
    }

    /**
     * @param filtroEspacial the filtroEspacial to set
     */
    public void setFiltroEspacial(NumeroComplejo[][] filtroEspacial) {
        this.filtroEspacial = filtroEspacial;
    }
    
    
}
