package FicheroPartidaIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FicheroPartidaOut {
    
    private final ObjectOutputStream oos;
    
    public FicheroPartidaOut(String rutaAbsoluta) throws FileNotFoundException, IOException{
        oos = new ObjectOutputStream(new FileOutputStream(rutaAbsoluta));
    }
    
    public void guardarPartida(Partida partida) throws IOException{ 
        oos.writeObject(partida); 
    }
    
    public void cerrarFichero() throws IOException{
        //Hemos contemplado la opcion de poner centinela, pero como dentro de cada archivo
        //hay una única partida,no lo consideramos necesario
        oos.close();
    }
    
    
    
}
