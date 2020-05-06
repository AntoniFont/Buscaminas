package buscaminas;

import java.util.Arrays;
import java.util.Random;
import utils.ArrayUtils;

public class Tablero {

    //DATOS CONSTANTES
    private final int NUM_BOMBAS = 10;
    private final int NUM_FILAS = 9;
    private final int NUM_COLUMNAS = 9;
    //VARIABLES
    private Casilla casillas[][] = new Casilla[NUM_FILAS][NUM_COLUMNAS];
    private int posicionBombas[] = new int[NUM_BOMBAS];

    public Tablero() {
        posicionBombas = generarPosicionBombas();
        for(int p = 0; p < NUM_FILAS * NUM_COLUMNAS; p++) {
            if (seHaGeneradoBombaEnLaPos(p)) {
                //Generamos casilla sin bomba
                casillas[getFila(p)][getColumna(p)] = new Casilla(true);
            } else {
                //Generamos casilla sin bomba
                casillas[getFila(p)][getColumna(p)] = new Casilla(false);
            }
        }
        //Generar los numeros de las bombas
    }
    
    private int getFila(int posicion) {
        return (int) (posicion / NUM_FILAS);
    }

    private int getColumna(int posicion) {
        return (posicion % NUM_COLUMNAS);
    }
    //Genera un array de 10 numeros no repetidos que van desde 0 hasta (NUM_FILAS*NUM_COLUMNAS-1)
    private int[] generarPosicionBombas() {
        //Hardcodeo cosas para hacer pruebas
        int posBomb[] = new int[NUM_BOMBAS];

        Random r = new Random();
        for(int i = 0; i < posBomb.length; i++){
            boolean numRepetido;
            int n;
            //comprovam si el numero general aleatori esta repetit, si es aixi un numero nou
            //fins que el numero que generi no estigui repetit, llavors el posam a l'array posRandom
            do {
                numRepetido = false;
                n = r.nextInt(9*9-1); //genera numero random entre 0 y el total de casillas
                if(ArrayUtils.arrayContieneEntero(posBomb,n)) {
                        numRepetido = true;
                }
            }while(numRepetido);
            posBomb[i] = n;
        }
        return posBomb;
    }

    private boolean seHaGeneradoBombaEnLaPos(int posicion) {
        for (int j = 0; j < posicionBombas.length; j++) {
            if (posicion == posicionBombas[j]) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        //Los numeros de las columnas
        String tableroTexto = "  ";
        for (int j = 0; j < NUM_COLUMNAS; j++) {
            tableroTexto += j + " ";
        }
        tableroTexto += '\n'; //Pasamos a la siguiente fila
        //El tablero en sí (con los numeros de la fila delante de cada fila)
        for (int i = 0; i < NUM_FILAS; i++) {
            tableroTexto += i + " "; //Añadimos el numero de la fila
            for (int j = 0; j < NUM_COLUMNAS; j++) {
                //Los valores en si
                if (casillas[i][j].isTapado()) {
                    tableroTexto += "?";
                } else {
                    if (casillas[i][j].isBomba()) {
                        tableroTexto += "x";
                    } else {
                        tableroTexto += "-";
                    }
                }
                tableroTexto += " "; //Metemos un espacio para separar los valores
            }
            tableroTexto += "\n"; //Pasamos a la siguiente fila
        }
        return tableroTexto;
    }

    //Hace lo mismo que toString pero muestra los que hay en los valores tapados
    public String toStringDestapado() {
        //Los numeros de las columnas
        String tableroTexto = "  ";
        for (int j = 0; j < NUM_COLUMNAS; j++) {
            tableroTexto += j + " ";
        }
        tableroTexto += '\n'; //Pasamos a la siguiente fila
        //El tablero en sí (con los numeros de la fila delante de cada fila)
        for (int i = 0; i < NUM_FILAS; i++) {
            tableroTexto += i + " "; //Añadimos el numero de la fila
            for (int j = 0; j < NUM_COLUMNAS; j++) {
                //Los valores en si
                if (casillas[i][j].isBomba()) {
                    tableroTexto += "x";
                } else {
                    tableroTexto += casillas[i][j].getNumero(); 
                }
                tableroTexto += " "; //Metemos un espacio para separar los valores
            }
            tableroTexto += "\n"; //Pasamos a la siguiente fila
        }
        return tableroTexto;
    }
    
    public void destaparCasilla(int fila,int columna){
        casillas[fila][columna].setTapado(false);
        //si es una bomba
            //Gameover = true
            //destaparTodoElTablero (cambiar el metodo toStringTrampas)
             
    }
    
}
