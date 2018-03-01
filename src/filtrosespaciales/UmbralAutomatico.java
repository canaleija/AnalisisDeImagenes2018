/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtrosespaciales;

/**
 *
 * @author Roberto Cruz Leija
 */
public class UmbralAutomatico {
    
    public static int metodoIterativo(double[] histograma){
    
        int ui = calcularUmbralInicial(histograma);
        int uNuevo=0;
        System.out.println(ui);
        do{
        uNuevo = ui;
        ui = reajustarUmbral(ui,histograma);
        System.out.println(ui);
        }while(uNuevo!=ui);
        
        return ui;
        
    }

    private static int calcularUmbralInicial(double[] histograma) {
        int numPixels = 0;
        int suma = 0;
        for(int x=0;x<histograma.length;x++){
        numPixels+=histograma[x];
        suma+=histograma[x]*x;
        }
        return (int)(suma/numPixels);
    }

    private static int reajustarUmbral(int ui, double[] histograma) {
       int u1,u2;
       int a1=0,a2=0,n1=0,n2=0;
       a1+=histograma[0];
       for(int x=1;x<ui;x++){
        a1+=histograma[x]*x;
        n1+=histograma[x];
       }
       
        for(int y=ui;y<=255;y++){
        a2+=histograma[y]*y;
        n2+=histograma[y];
       }
        if (n1==0 || n2==0) return 0;
        u1 = a1/n1;
        u2 = a2/n2;
       return (int)((u1+u2)/2);
    }
    
}
