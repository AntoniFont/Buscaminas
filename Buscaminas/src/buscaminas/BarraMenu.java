/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import static buscaminas.Buscaminas.tablero;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class BarraMenu extends JMenuBar{
    private JMenu jmenuArchivo;
    private JMenuItem jmItemGuardar;
    private JMenuItem jmItemCargar;
    private JFileChooser jselectficheroGuardar;
    private JFileChooser jselectficheroCargar;
    
    public BarraMenu(){
        initComponents();
    }
    
    private void initComponents(){
        jmenuArchivo = new JMenu();
        jmItemGuardar = new JMenuItem();
        jmItemCargar = new JMenuItem();
        
//        this.setLayout(null);
//        this.add(jmenuArchivo);

        //Nombre y accion sobre el boton del sub-menu Guardar
        jmItemGuardar.setText("Guardar");
        jmItemGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                try {
                    jmItemGuardarActionPerformed(evt);
                } catch (FileNotFoundException ex) {
                    System.out.println("FileNotFound exception, error en ActionListener Boton Guardar");
                } catch (IOException ex) {
                    System.out.println("IOException , error en ActionListener Boton Guardar");
                }
            }
        });
        //Nombre y accion sobre el boton del sub-menu Cargar
        jmItemCargar.setText("Cargar");
        jmItemCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jmItemCargarActionPerformed(evt);
            }
        });

        //Añadir al menu Archivo las opciones del sub-menu
        jmenuArchivo.setText("Archivo");
        jmenuArchivo.add(jmItemGuardar);
        jmenuArchivo.add(jmItemCargar);
        
        //Añadir a la barra de menu, el menu Archivo
        this.add(jmenuArchivo);
    }
    
    private void jmItemGuardarActionPerformed(ActionEvent evt) throws FileNotFoundException, IOException{
        //instanciacion del selector de ficheros
        jselectficheroGuardar = new JFileChooser();
        jselectficheroGuardar.setDialogTitle("Selecciona la carpeta donde quieres guardar el archivo de partida");
        
        int valorSeleccionado = jselectficheroGuardar.showSaveDialog(this);    //this componente padre del JFileChooser
        
        if (valorSeleccionado == JFileChooser.APPROVE_OPTION) { //Si pulsa el boton guardar
            System.out.println("Guardando...");
            //Obtenemos la ruta donde se desea guardar
            String ruta = jselectficheroGuardar.getCurrentDirectory().getAbsolutePath();
            System.out.println("Ruta: " + ruta);
            //Obtenemos el nombre que ha escrito
            String nombreArchivo = jselectficheroGuardar.getSelectedFile().getName();
            System.out.println("Nombre Archivo: " + nombreArchivo);
            //Creamos una ruta del archivo absoluta
            String rutaArchivo = ruta + "\\" + nombreArchivo;
            System.out.println("rutaArchivo: " + rutaArchivo);
            
            FicheroPartidaOut fpo = new FicheroPartidaOut(rutaArchivo);
            fpo.guardarPartida();
            fpo.cerrarFichero();
            
            

             
             
             
             
        }
       
    }
    
    private void jmItemCargarActionPerformed(ActionEvent evt){
        //Hacer un método aparte guardar() o hacer la funcion de guardar
        //directamente aqui
        
        //cargarPartida(evt);
        System.out.println("Cargando...");
    }
}
