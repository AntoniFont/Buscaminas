package FicheroPartidaIO;

import buscaminas.Casilla;
import java.io.Serializable;


//ArchivoDeGuardado
public class Partida implements Serializable{
    private Casilla casillas[][];
       
    public Partida(Casilla casillas[][]){
        this.casillas = casillas;
    }
    
    public Casilla [][] getCasillas(){
        return casillas;
    }
    
    public void generarArchivoDeGuardado(Casilla casillas[]){
        //Obtenemos de las casillas unicamente los datos imprescindibles
    }

}
