/*
*   Clase ArchivoDeGuardado. Sirve para englobar el concepto de Archivo de 
*   guardado que en este caso contendrá los datos necesarios para poder recrear 
*   el estado de una partida, tanto para guardarla como para cargarla
*/

package ArchivoDeGuardadoIO;

import buscaminas.Casilla;
import java.io.Serializable;

public class ArchivoDeGuardado implements Serializable{
 
    //ATRIBUTOS
    //CONSTANTES
    private final boolean casillasConBombas[][];
    private final boolean casillasTapadas[][];
    private final int bombasAlrededor[][];
    private final int filaDeLasCasillas[][];
    private final int columnaDeLasCasillas[][];
      
    //CONSTRUCTOR
    public ArchivoDeGuardado(Casilla casillas[][]){
        
        int numFilas = casillas.length;
        int numColumnas = casillas[0].length;
        
        //inicializacion de atributos
        casillasConBombas = new boolean[numFilas][numColumnas];
        casillasTapadas = new boolean[numFilas][numColumnas];
        bombasAlrededor = new int[numFilas][numColumnas];
        filaDeLasCasillas = new int[numFilas][numColumnas];
        columnaDeLasCasillas = new int[numFilas][numColumnas];
        
        //Asignamos al mismo componente de cada array, su valor correspondiente
        for(int i= 0;i<numFilas;i++){
            for(int j = 0;j<numColumnas;j++){
                casillasConBombas[i][j] = casillas[i][j].isBomba();
                casillasTapadas[i][j] = casillas[i][j].isTapado();
                bombasAlrededor[i][j]= casillas[i][j].getNumBombasAlrededor();
                filaDeLasCasillas[i][j] = casillas[i][j].getFila();
                columnaDeLasCasillas[i][j] = casillas[i][j].getColumna();
            }
        }
        
    }

    //GETTERS
    public boolean getCasillaIsBomba(int fila, int col) {
        return casillasConBombas[fila][col];
    }

    public boolean getCasillaIsTapada(int fila, int col) {
        return casillasTapadas[fila][col];
    }

    public int getNumBombasAlrededor(int fila, int col) {
        return bombasAlrededor[fila][col];
    }

    public int getFilaCasilla(int fila, int col) {
        return filaDeLasCasillas[fila][col];
    }

    public int getColumnaCasilla(int fila, int col) {
        return columnaDeLasCasillas[fila][col];
    }

}
