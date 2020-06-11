/*
*   Clase Casilla. Sirve para englobar el concepto de Casilla y todas las funcionalidades 
*   que requieran de esta.
*/

package buscaminas;

import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class Casilla extends JLabel {
    //ATRIBUTOS
    //VARIABLES
    private boolean tieneBomba;
    private boolean tapado = true;
    private int numBombasAlrededor = 0;
    private int fila;
    private int columna;
    
    //CONSTANTES
    //Imagen por defecto reescalada que se carga en memoria principal para
    //reducir tiempos de carga, ya que se reutiliza en varias partes
    private final Image IMAGEN_POR_DEFECTO = new ImageIcon("IMAGENES/boton.png").getImage().getScaledInstance(71,68 ,Image.SCALE_SMOOTH);
        
    private final MouseListener funcionalidadCasilla = new MouseListener(){

        @Override
        public void mouseClicked(MouseEvent e) {}

        @Override
        public void mousePressed(MouseEvent e) {}

        @Override
        public void mouseReleased(MouseEvent e) {

            //Se evalua la condición de victoria sobre la propia casilla
            //clickada
            Tablero.evaluarCondicionVictoria(fila,columna);
            
            destapar();
        }

        @Override
        public void mouseEntered(MouseEvent e) {}

        @Override
        public void mouseExited(MouseEvent e) {}
    };
    
    //CONSTRUCTOR
    public Casilla(int posFila, int posCol, boolean tieneBomba){
        this.tieneBomba = tieneBomba;
        this.fila = posFila;
        this.columna = posCol;   
        this.addMouseListener(funcionalidadCasilla);
    }
    
    public void setImagenPorDefecto(){
        this.setIcon(new ImageIcon(IMAGEN_POR_DEFECTO));
    }
    
    public void destapar(){
        this.tapado = false;
        Image imagenCasilla;
        Image imagenReescalada;
        int anchoCasilla = this.getWidth();
        int altoCasilla = this.getHeight();
        
        //Asignacion de imagen a la casilla a destapar dependiendo de si contiene
        //una bomba o no
        if(tieneBomba){
            imagenCasilla = new ImageIcon("IMAGENES/bomba.png").getImage();   
        }else{
            imagenCasilla = new ImageIcon("IMAGENES/" + numBombasAlrededor + ".jpg").getImage();            
        }
        imagenReescalada = imagenCasilla.getScaledInstance(anchoCasilla,altoCasilla,Image.SCALE_DEFAULT);
        setIcon(new ImageIcon(imagenReescalada)); 
        //TODO cambiar el metodo incrementar casillas a static
        Tablero.incrementarCasillasDestapadas();
    }
    
    public void tapar(){
        this.tapado = true;
        setImagenPorDefecto();
    }

    //GETTERS
    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
    public int getNumBombasAlrededor(){
        return numBombasAlrededor;
    }
    
    public boolean isBomba(){
        return tieneBomba;
    }

    public boolean isTapado() {
        return tapado;
    }
    
    //SETTERS
    public void setTieneBomba(boolean tieneBomba) {
        this.tieneBomba = tieneBomba;
    }
    
    public void setTapado(boolean tapado) {
        this.tapado = tapado;
    }
    
    public void setNumBombasAlrededor(int numero) {
        this.numBombasAlrededor = numero;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
     
}
    