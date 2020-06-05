package buscaminas;

import static buscaminas.Buscaminas.tablero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import javax.swing.JButton;

public class Casilla extends JButton implements Serializable {
    
    //VARIABLES
    private boolean tieneBomba;
    private boolean tapado = true;
    private int numBombasAlrededor = 0;
    private int fila;
    private int columna;
        
    private ActionListener funcionalidadCasilla = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            Casilla casillaPulsada = (Casilla) e.getSource();
            int columna = casillaPulsada.getColumna();
            int fila = casillaPulsada.getFila();
            //
            tablero.getCasillas()[fila][columna].destapar();
            tablero.incrementarCasillasDestapadas();
            tablero.evaluarCondicionVictoria(fila,columna);
        }
    };
    
    public Casilla(int posFila, int posCol, boolean tieneBomba){
        this.tieneBomba = tieneBomba;
        this.fila = posFila;
        this.columna = posCol;     
        this.addActionListener(funcionalidadCasilla);
    }
    
    public void destapar(){
        this.tapado = false;
        //Seteamos la imagen(de momento texto)
        if(tieneBomba){
            setText("x");
        }else{
            setText("" + numBombasAlrededor);
        }      
        //Hacemos que no se puede hacer click
        this.setEnabled(false);  
    }
    
    public void tapar(){
        this.tapado = true;
        setText("");
        this.setEnabled(true);
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
    