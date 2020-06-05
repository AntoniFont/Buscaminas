
package elementosVisualesInteractuables;

import buscaminas.Buscaminas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarraMenu extends JMenuBar{
    private JMenu jmenuArchivo;
    
    //Boton Guardar Partida
    private JMenuItem jmItemGuardar;
    private ActionListener funcionalidadItemGuardar = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             JFileChooser seleccionador = new JFileChooser("partidas");
             int valor = seleccionador.showOpenDialog(null);
             seleccionador.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
             if(valor == JFileChooser.APPROVE_OPTION){
                File archivoAGuardar = seleccionador.getSelectedFile();
                Buscaminas.guardarPartida(archivoAGuardar.getAbsolutePath());
             }
        }
    };
    //Boton Cargar partida
    private JMenuItem jmItemCargar;
    private ActionListener funcionalidadItemCargar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser seleccionador = new JFileChooser("partidas");
            int valor = seleccionador.showOpenDialog(null);
            if(valor == JFileChooser.APPROVE_OPTION){
                File archivoACargar = seleccionador.getSelectedFile();
                Buscaminas.cargarPartida(archivoACargar.getAbsolutePath());
            }
        }
    };
    
    //Boton Reiniciar
    private JMenuItem jmItemReiniciar;
    private ActionListener funcionalidadItemReiniciar = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            //Reiniciar Partida
            Buscaminas.reiniciarPartida();
            
        }
    };
    
    //Boton Salir
    private JMenuItem jmItemSalir;
    private ActionListener funcionalidadItemSalir = new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };
        
    public BarraMenu(){
        initComponents();
    }
    
    private void initComponents(){
        //Inicializamos los elementos del menu con su texto
        jmenuArchivo = new JMenu("Archivo"); 
        jmItemGuardar = new JMenuItem("Guardar");
        jmItemCargar = new JMenuItem("Cargar");
        jmItemReiniciar = new JMenuItem("Reiniciar");
        jmItemSalir = new JMenuItem("Salir");
        
        //Añadimos la funcionalidad a ambos botones
        jmItemGuardar.addActionListener(funcionalidadItemGuardar);
        jmItemCargar.addActionListener(funcionalidadItemCargar);
        jmItemReiniciar.addActionListener(funcionalidadItemReiniciar);
        jmItemSalir.addActionListener(funcionalidadItemSalir);

        //Añadir al menu Archivo las opciones del sub-menu
        jmenuArchivo.add(jmItemGuardar);
        jmenuArchivo.add(jmItemCargar);
        jmenuArchivo.add(jmItemReiniciar);
        jmenuArchivo.add(jmItemSalir);
        
        //Añadir a la barra de menu, el menu Archivo
        this.add(jmenuArchivo);
    }
    
}