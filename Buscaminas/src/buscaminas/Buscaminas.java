package buscaminas;

public class Buscaminas {

    public static void main(String[] args) {
       Tablero tablero = new Tablero();
       System.out.println(tablero.toString());       
       
       System.out.println("Trampas: ");
       System.out.println(tablero.toStringTrampas());
    }
    
}
