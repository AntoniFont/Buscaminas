package FicheroPartidaIO;

import buscaminas.Casilla;
import java.io.Serializable;


public class Partida implements Serializable{
    
    private boolean casillasConBombas[][];
    private boolean casillasTapadas[][];
    private int bombasAlrededor[][];
    private int filaDeLasCasillas[][];
    private int columnaDeLasCasillas[][];
    
    
       
    public Partida(Casilla casillas[][]){
        int numFilas = casillas.length;
        int numColumnas = casillas[0].length;

        
        
        //Primero rellenamos el array de casillasConBombas
        for(int i= 0;i<numFilas;i++){
            for(int j = 0;j<numColumnas;j++){
                int contadd
                if(tieneBomba){
                
                }
            }
        }
        
    }


}
