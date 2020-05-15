package buscaminas;

import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import utils.ArrayUtils;

public class Tablero extends JPanel {

    //Componentes graficos
    private BarraMenu barraMenu;    //barra de menú 
    private JPanel panelJuego;      //zona donde estan las casillas
    
    //DATOS CONSTANTES
    private final int NUM_BOMBAS = 10;
    private final int NUM_FILAS = 9;
    private final int NUM_COLUMNAS = 9;
    //VARIABLES
    private Casilla casillas[][] = new Casilla[NUM_FILAS][NUM_COLUMNAS];
    private int posicionBombas[] = new int[NUM_BOMBAS];

    public Tablero(){
        System.out.println("Visualizando tablero");
        posicionBombas = generarPosicionBombas();
        for(int p = 0; p < NUM_FILAS * NUM_COLUMNAS; p++) {
            if (seHaGeneradoBombaEnLaPos(p)) {
                //Generamos casilla sin bomba
                casillas[getFila(p)][getColumna(p)] = new Casilla(getFila(p),getColumna(p), true);
            } else {
                //Generamos casilla sin bomba
                casillas[getFila(p)][getColumna(p)] = new Casilla(getFila(p),getColumna(p),false);
            }
        }
        //Generar los numeros de las bombas
        for(int i = 0; i<NUM_FILAS; i++){
            for(int j = 0; j<NUM_COLUMNAS; j++){
                if(!casillas[i][j].isBomba()){  //generamos numero
                    int n = contarBombasAlrededor(casillas[i][j]);
                    casillas[i][j].setNumero(n);
                }
            }
        }
        //
        initComponents();
    }
    
    //
    private void initComponents(){
        barraMenu = new BarraMenu();
        panelJuego = new JPanel();
    }
    
    private int contarBombasAlrededor(Casilla casilla){
        List<Casilla> casillasAlderedor = getCasillasAlderedor(casilla);
        int contBombas = 0;
        
        for (Casilla c : casillasAlderedor) { 		      
           if(c.isBomba()){
               contBombas++;
           }		
        }

        System.out.println("Num de casillas adyacentes: " + casillasAlderedor.size());
        return contBombas;
    }
    
    private List<Casilla> getCasillasAlderedor(Casilla casilla){
        List<Casilla> casillasAlderedor = new ArrayList<>();
        
        //  c c c
        //  c x c   x: casilla seleccionada
        //  c c c
        
        //posiciones de las casillas a comprobar respecto a la casilla seleccionada
        int [][] posiciones = {     
            {-1,-1},    //nor-oeste
            {-1,0},     //oeste
            {-1,1},     //sur-oeste
            {0,-1},     //norte
            {0,1},      //sur
            {1,-1},     //nor-este
            {1,0},      //este
            {1,1}};     //sur-este
        //iteramos por cada posicion(que es un vector de 2 componentes) de 
        //las casillas adyacentes a la seleccionada
        for (int i = 0; i < posiciones.length; i++) {
            //obtenemos la posicion de la casilla adyacente la cual vamos a comprobar
            //si es una posicion valida del tablero
            int posFilaCasillaAdyacente = casilla.getPosFila() + posiciones[i][0];
            int posColCasillaAdyacente = casilla.getPosCol() + posiciones[i][1];

            //si la casilla adyacente actual esta en una posicion valida del tablero,
            //entonces se añade a la lista de casillas adyacentes validas
            if(posicionCasillaValida(posFilaCasillaAdyacente,posColCasillaAdyacente)){
                casillasAlderedor.add(casillas[posFilaCasillaAdyacente][posColCasillaAdyacente]);
            }
            
        }
        return casillasAlderedor;
    }
    
    // devuelve un booleano dependiendo de si la posicion del una casilla del tablero 
    //pasada por paremtro esta dentro del tablero(posicion valida) o no.
    private boolean posicionCasillaValida(int posFila, int posCol){
        return (posFila >= 0 && posFila < NUM_FILAS) &&
                (posCol >= 0 && posCol < NUM_COLUMNAS);
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
                        tableroTexto += casillas[i][j].getNumero();
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
        //se destapa la casilla seleccionada
        casillas[fila][columna].setTapado(false);
        
        //si la casilla tiene una bomba, se destapa todo el tablero y acaba el juego
        if(casillas[fila][columna].isBomba()){
            Buscaminas.setGameOver(true);
        }    
    }
    
}
