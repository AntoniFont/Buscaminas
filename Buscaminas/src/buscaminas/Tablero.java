package buscaminas;
public class Tablero {
    
    //DATOS CONSTANTES
    private final int NUM_BOMBAS = 10;
    private final int NUM_FILAS = 9;
    private final int NUM_COLUMNAS = 9;
    //VARIABLES
    private Casilla casillas[][] = new Casilla[NUM_FILAS][NUM_COLUMNAS];
    private int posicionBombas[] = new int[NUM_BOMBAS];
    
    public Tablero(){ 
       generarPosicionBombas();
       
       for(int i = 0;i<NUM_FILAS*NUM_COLUMNAS;i++){
           for(int j= 0;j<posicionBombas.length;j++){
               if(i == posicionBombas[j]){
                //Generamos casilla con Bomba
               }
           }
           //Generamos casilla sin bomba
       }
    }
    
    //Genera un array de 10 numeros no repetidos que van desde 0 hasta (NUM_FILAS*NUM_COLUMNAS-1)
    private int [] generarPosicionBombas(){
        return null;
    }
    
    
    
   
    
    
    
}
