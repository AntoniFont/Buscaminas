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
        
        setJMenuBar(barraMenu);
    }
       
    public static void main(String[] args) {
       
        new Buscaminas().setVisible(true);     //comentar esta linea para quitar la ventana
       //tablero = new Tablero();               //descomentar esta linea para quitar la ventana
       while(!gameOver){
           System.out.println(tablero.toString());     
           int[] pos = pedirPosicion();
           tablero.destaparCasilla(pos[0],pos[1]); //Pos[0] es la posicion x y Pos[1] es la posicion y
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
    
}
