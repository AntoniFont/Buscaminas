package buscaminas;

import FicheroPartidaIO.FicheroPartidaIn;
import FicheroPartidaIO.FicheroPartidaOut;
import FicheroPartidaIO.Partida;
import elementosVisualesInteractuables.BarraMenu;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Buscaminas extends JFrame{
    //CONSTANTES
    private String mensajeFinalizarJuego = "Has perdido,sigue intentando";
    //VARIABLES
    public static final Tablero tablero = new Tablero(); //Todas las clases necesitan acceso a este objeto
    public static final BarraMenu barraMenu = new BarraMenu();
       
    public Buscaminas(){
        setSize(700, 700);
        setTitle("Buscaminas");
        setDefaultCloseOperation(Buscaminas.EXIT_ON_CLOSE);
        initComponents();
    }
    
    private void initComponents(){
        this.setLayout(new BorderLayout());
        this.setResizable(true);
        this.add(tablero,BorderLayout.CENTER);
        this.setJMenuBar(barraMenu);
    }
       
    public static void main(String[] args) throws Exception{
       Buscaminas buscaminas = new Buscaminas();  
       buscaminas.setVisible(true);
       buscaminas.tablero.setIconosPorDefecto();
       reproducirMusica();
    }
    
    public static void reproducirMusica(){
        try{
            AudioInputStream audioInputStream =  AudioSystem.getAudioInputStream(new File("ita.wav").getAbsoluteFile());       
            Clip clip = AudioSystem.getClip(); 
            clip.open(audioInputStream); 
            clip.loop(Clip.LOOP_CONTINUOUSLY); 
        }catch(Exception e){
        
        }
    
    }
    
    public static void guardarPartida(String rutaGuardado) {
        try {
            FicheroPartidaOut fpo = new FicheroPartidaOut(rutaGuardado);
            Partida partida = new Partida(tablero.getCasillas());
            fpo.guardarPartida(partida);
            fpo.cerrarFichero();
        } catch (IOException ex) {
            System.out.println("No se ha podido guardar la partida, IOException");
        }
    }
    
    public static void cargarPartida(String rutaPartida) {
        try {
            FicheroPartidaIn fpi = new FicheroPartidaIn(rutaPartida);
            Partida partida = fpi.getPartida();
            tablero.setCasillas(partida.getCasillas());
            System.out.println(tablero.toString());
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

}
