package buscaminas;

import static buscaminas.Buscaminas.tablero;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Casilla extends JLabel implements Serializable {
    
    //VARIABLES
    private boolean tieneBomba;
    private boolean tapado = true;
    private int numBombasAlrededor = 0;
    private int fila;
    private int columna;
    
        
    private MouseListener funcionalidadCasilla = new MouseListener(){

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            Casilla casillaPulsada = (Casilla) e.getSource();
            int columna = casillaPulsada.getColumna();
            int fila = casillaPulsada.getFila();
            tablero.evaluarSiCasillaClickadaEsBombaYPerderSiEsNecesario(fila,columna);
            tablero.getCasillas()[fila][columna].destapar();
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    };
    
    public Casilla(int posFila, int posCol, boolean tieneBomba){
        this.tieneBomba = tieneBomba;
        this.fila = posFila;
        this.columna = posCol;   
        this.addMouseListener(funcionalidadCasilla);
    }
    
    public void setImagenPorDefecto(){
        Image imagenReescalada = new ImageIcon("IMAGENES/spa.jpg").getImage().getScaledInstance(this.getWidth(),this.getHeight(),Image.SCALE_SMOOTH);
        this.setIcon(new ImageIcon(imagenReescalada));
    }
    
    public void destapar(){
        this.tapado = false;
        Image imagenCasilla;
        int anchoCasilla = this.getWidth();
        int altoCasilla = this.getHeight();
        if(tieneBomba){
            imagenCasilla = new ImageIcon("IMAGENES/bomba.png").getImage();   
        }else{
            imagenCasilla = new ImageIcon("IMAGENES/" + numBombasAlrededor + ".jpg").getImage();            
        }
        Image imagenReescalada = imagenCasilla.getScaledInstance(anchoCasilla,altoCasilla,Image.SCALE_DEFAULT);
        setIcon(new ImageIcon(imagenReescalada)); 
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }
    
    public int getNumBombasAlrededor(){
        return numBombasAlrededor;
    }
    
    public void setNumBombasAlrededor(int numero) {
        this.numBombasAlrededor = numero;
    }
    
    public boolean isBomba(){
        return tieneBomba;
    }

    public boolean isTapado() {
        return tapado;
    }
     
}
    