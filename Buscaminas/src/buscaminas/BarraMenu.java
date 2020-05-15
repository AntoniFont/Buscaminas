/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
               
                jmItemGuardarActionPerformed(evt);
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
    
    private void jmItemGuardarActionPerformed(ActionEvent evt){
        //instanciacion del selector de ficheros
        jselectficheroGuardar = new JFileChooser();
        
        int nValor = jselectficheroGuardar.showSaveDialog(this);    //this componente padre del JFileChooser
        if (nValor == JFileChooser.APPROVE_OPTION) {
             System.out.println("Guardando...");
        }
        //Hacer un método aparte guardar() o hacer la funcion de guardar
        //directamente aqui
        
        //guardarPartida(evt);
       
    }
    
    private void jmItemCargarActionPerformed(ActionEvent evt){
        //Hacer un método aparte guardar() o hacer la funcion de guardar
        //directamente aqui
        
        //cargarPartida(evt);
        System.out.println("Cargando...");
    }
}
