package buscaminas;

import ArchivoDeGuardadoIO.ArchivoDeGuardadoIn;
import ArchivoDeGuardadoIO.ArchivoGuardadoOut;
import ArchivoDeGuardadoIO.ArchivoDeGuardado;
import elementosVisualesInteractuables.BarraMenu;
import java.awt.BorderLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Buscaminas extends JFrame{
    //CONSTANTES
    //VARIABLES
    private static Tablero tablero;
    private static BarraMenu barraMenu;
       
    public Buscaminas(){
        setSize(684, 700);
        setTitle("Buscaminas");
        setDefaultCloseOperation(Buscaminas.EXIT_ON_CLOSE);
        initComponents();
    }
    
    private void initComponents(){
        tablero = new Tablero();
        barraMenu = new BarraMenu();
        
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.add(tablero,BorderLayout.CENTER);
        this.setJMenuBar(barraMenu);
    }
       
    public static void main(String[] args) throws Exception{
       Buscaminas buscaminas = new Buscaminas();  
       buscaminas.setVisible(true);
    }

    
    public static void guardarPartida(String rutaGuardado){
        try {
            ArchivoGuardadoOut ago = new ArchivoGuardadoOut(rutaGuardado);
            ArchivoDeGuardado archivoGuardado = new ArchivoDeGuardado(tablero.getCasillas());
            ago.guardar(archivoGuardado);
            ago.cerrarFichero();
        } catch (IOException ex) {
            System.out.println(ex.getMessage() + "No se ha podido guardar la partida, IOException");
        }
    }
    
    public static void cargarPartida(String rutaArchivoGuardado) {
        try {
            ArchivoDeGuardadoIn fpi = new ArchivoDeGuardadoIn(rutaArchivoGuardado);
            ArchivoDeGuardado partida = fpi.getArchivoDeGuardado();
            tablero.setNumCasillasDestapadas(0);
            tablero.reconstruirPartidaDesdeArchivoGuardado(partida);
        } catch (IOException|ClassNotFoundException ex ) {
            System.out.println("No se ha podido cargar la partida");
        }
    }
    
    public static void reiniciarPartida(){
        tablero.taparTodasLasCasillas();
        
    }
    
    //Metodo que finaliza el partida en derrota
    public static void finalizarPartidaDerrota(){
        tablero.destaparTodasLasCasillas();
        JOptionPane.showMessageDialog(null, "Has perdido", "Derrota", JOptionPane.ERROR_MESSAGE);
    }
    
    //Metodo que finaliza el juego en derrota
    public static void finalizarPartidaVictoria(){
        tablero.destaparTodasLasCasillas();
        JOptionPane.showMessageDialog(null, "Has Ganado!", "Victoria!", JOptionPane.INFORMATION_MESSAGE);
    }

    public static Tablero getTablero(){
        return tablero;
    }
}
