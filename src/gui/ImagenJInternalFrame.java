/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Image;
import javax.swing.ImageIcon;
import jdk.nashorn.tools.Shell;

/**
 *
 * @author Roberto Cruz Leija
 */
public class ImagenJInternalFrame extends javax.swing.JInternalFrame {

    private Image imagenOriginal;
    /**
     * Creates new form ImagenJInternalFrame
     */
    public ImagenJInternalFrame(Image imagen) {
        initComponents();
        this.imagenOriginal = imagen;
        // mandar la imagen como icono al jlabel
        this.jLabelImagen.setIcon(new ImageIcon(imagen));
        
        // redimensionar las dimensiones del jframe
         setSize(imagen.getWidth(null),imagen.getHeight(null));
    
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelImagen = new javax.swing.JLabel();

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelImagen)
                .addGap(0, 1116, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelImagen)
                .addGap(0, 690, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelImagen;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the imagenOriginal
     */
    public Image getImagenOriginal() {
        return imagenOriginal;
    }

    /**
     * @param imagenOriginal the imagenOriginal to set
     */
    public void setImagenOriginal(Image imagenOriginal) {
        this.imagenOriginal = imagenOriginal;
    }
    
    public void modificarImagen(Image imagen){
     // mandar la imagen como icono al jlabel
       
     this.jLabelImagen.setIcon(new ImageIcon(imagen));
        
    }
}
