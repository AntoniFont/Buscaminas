package FicheroPartidaIO;

import buscaminas.Casilla;
import java.io.Serializable;

public class Partida implements Serializable{
    
    private Casilla casillas[][];

    public Partida(Casilla casillas[][]){
        this.casillas = casillas;
    }
    
    public Casilla [][] getCasillas(){
        return casillas;
    }
    
    
}
