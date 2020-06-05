package buscaminas;

import java.util.Scanner;
import javax.swing.JFrame;

public class Buscaminas extends JFrame{
       private static Tablero tablero;
       private static BarraMenu barraMenu;
       private static boolean gameOver = false;
       
    public Buscaminas(){
        setSize(500, 500);
        setTitle("Buscaminas Turbo v1.0");
        setDefaultCloseOperation(Buscaminas.EXIT_ON_CLOSE);
        initComponents();
    }
    
    
    private void initComponents(){
        barraMenu = new BarraMenu();    //barraMenu es un JMenuBar
        tablero = new Tablero();        //tablero es un JPanel
        
        this.setLayout(null);
        this.add(barraMenu);
        this.add(tablero);
        
        this.setJMenuBar(barraMenu);
    }
       
    public static void main(String[] args) {
       
        //new Buscaminas().setVisible(true);     //comentar esta linea para quitar la ventana
        
       tablero = new Tablero();               //descomentar esta linea para quitar la ventana
       while(!gameOver){
           System.out.println("Trampas: ");
           System.out.println(tablero.toStringDestapado());
           System.out.println(tablero.toString());     
           int[] pos = pedirPosicion();
           tablero.destaparCasilla(pos[0], pos[1]);
       }
       System.out.println(tablero.toStringDestapado());
       System.out.println("GAME OVER!");
    }
    
    public static void setGameOver(boolean isGameOver){
        gameOver = isGameOver;
    }
    
    public static int[] pedirPosicion(){
        Scanner scanner = new Scanner(System.in);
        boolean isNumero = false;
        int fila = 0;
        int columna = 0;
        
        //Pide una fila
        while(!isNumero){
            System.out.print("Introduce una fila: ");
            try{
                fila = Integer.parseInt(scanner.nextLine());
                if(fila < 0){
                    throw new NumberFormatException();
                }
                isNumero = true;
            }catch(NumberFormatException ex){
                System.out.println("No has introducido un valor permitido.");
            }
        }
        //Pide una columna
        isNumero = false;
        while(!isNumero){
            System.out.print("Introduce una columna: ");
            try{
                columna = Integer.parseInt(scanner.nextLine());
                if(columna < 0 ){
                    throw new NumberFormatException();
                }
                isNumero = true;
            }catch(NumberFormatException ex){
                System.out.println("No has introducido un valor permitido.");
            }
        }
        
        int pos[] = {fila,columna};
        return pos;
    }  
    
    //public static void guardarPartida(){}
    //Metodo que guarda la partida actual (guarda el array de casillas del tablero)
            //FicheroPartidaOut fpo = new FicheroPartidaOut();
            //Casilla [][] partida = tablero.getCasillas();     una partida sera un array de casillas
            //fpo.guardar(partida);
    
    //public static void cargarPartida(){}
    //Metodo que carga una partida (array de casillas) al buscaminas actual.
            //FicheroPartidaIn fpi = new FicheroPartidaIn();
            //Partida partida = fpi.getPartida();
            //tablero.setPartida(partida);
}
