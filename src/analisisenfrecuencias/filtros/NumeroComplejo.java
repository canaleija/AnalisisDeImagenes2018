/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analisisenfrecuencias.filtros;

/**
 *
 * @author Roberto Cruz Leija
 */
public class NumeroComplejo {
    
    private final double real;
    private final double imaginaria;

    public NumeroComplejo(double real, double imaginaria) {
        this.real = real;
        this.imaginaria = imaginaria;
    }
    public NumeroComplejo(NumeroComplejo complejo){
      this(complejo.getReal(),complejo.imaginaria);   
    }

    /**
     * @return the real
     */
    public double getReal() {
        return real;
    }

    /**
     * @return the imaginaria
     */
    public double getImaginaria() {
        return imaginaria;
    }
    
    
    
    
}
