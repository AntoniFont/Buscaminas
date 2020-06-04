package buscaminas;

import java.io.Serializable;
import javax.swing.JButton;

public class Casilla extends JButton implements Serializable {
    
    //CONSTANTES
    
    //VARIABLES
    private boolean tieneBomba;
    private boolean tapado = true;
    private int numero = 0;
    private int posFila;
    private int posCol;
    
    public static final Casilla CENTINELA = new Casilla(-1,-1,false);
    
    
    
    
    public Casilla(){
    }
    
    public void destapar(){
        this.tapado = false;
        //Seteamos la imagen(de momento texto)
        if(tieneBomba){
            setText("x");
        }else{
            setText("" + numero);
        }
    }
    
    public Casilla(int posFila, int posCol, boolean tieneBomba){
        this.tieneBomba = tieneBomba;
        this.posFila = posFila;
        this.posCol = posCol;        
    }

    public int getPosFila() {
        return posFila;
    }

    public int getPosCol() {
        return posCol;
    }
    
    public int getNumero(){
        return numero;
    }
    
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    public boolean isBomba(){
        return tieneBomba;
    }

    public boolean isTapado() {
        return tapado;
    }
    
    
    public boolean isCentinela(){
        return (getPosFila() == -1 && getPosCol() == -1 && !isBomba()   ); 
    }
}
