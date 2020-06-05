
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
    
        
    public BarraMenu(){
        initComponents();
    }
    
    private void initComponents(){
        //Inicializamos los elementos del menu con su texto
        jmenuArchivo = new JMenu("Archivo"); 
        jmItemGuardar = new JMenuItem("Guardar");
        jmItemCargar = new JMenuItem("Cargar");
        
        //Añadimos la funcionalidad a ambos botones
        jmItemGuardar.addActionListener(funcionalidadItemGuardar);
        jmItemCargar.addActionListener(funcionalidadItemCargar);

        //Añadir al menu Archivo las opciones del sub-menu
        jmenuArchivo.add(jmItemGuardar);
        jmenuArchivo.add(jmItemCargar);
        
        //Añadir a la barra de menu, el menu Archivo
        this.add(jmenuArchivo);
    }
    
}