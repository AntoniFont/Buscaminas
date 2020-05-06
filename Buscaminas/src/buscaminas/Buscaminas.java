package buscaminas;

import java.util.Scanner;

public class Buscaminas {
       private static Tablero tablero;
       private static boolean gameOver = false;
    public static void main(String[] args) {
       tablero = new Tablero();
       while(!gameOver){
           System.out.println("Trampas: ");
           System.out.println(tablero.toStringDestapado());
           System.out.println(tablero.toString());     
           int[] pos = pedirPosicion();
           tablero.destaparCasilla(pos[0], pos[1]);
       }
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
