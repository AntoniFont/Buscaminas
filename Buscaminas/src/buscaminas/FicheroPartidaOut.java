package buscaminas;

import static buscaminas.Buscaminas.tablero;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FicheroPartidaOut {
    
    private final ObjectOutputStream oos;
    
    public FicheroPartidaOut(String rutaAbsoluta) throws FileNotFoundException, IOException{
        oos = new ObjectOutputStream(new FileOutputStream(rutaAbsoluta));
    }
    
    public void guardarPartida() throws IOException{
        Casilla casillas[][] = tablero.getCasillas();   
        for(int i = 0 ;i<casillas.length;i++){
                for(int j = 0;j<casillas[0].length;j++){
                   oos.writeObject(casillas[i][j]); 
               }
        }
    }
    
    public void cerrarFichero() throws IOException{
        oos.writeObject(Casilla.CENTINELA);
        oos.close();
    }
    
    
    
}
