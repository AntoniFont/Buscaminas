/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elementosVisualesInteractuables;

import buscaminas.Buscaminas;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
             int valor = seleccionador.showOpenDialog((Component) e.getSource());
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
            int valor = seleccionador.showOpenDialog((Component) e.getSource());
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