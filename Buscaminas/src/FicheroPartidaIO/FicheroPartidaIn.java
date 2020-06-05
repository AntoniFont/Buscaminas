package FicheroPartidaIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class FicheroPartidaIn {
    
    private final ObjectInputStream ois;
    
    public FicheroPartidaIn(String ruta) throws FileNotFoundException, IOException{
        ois = new ObjectInputStream(new FileInputStream(ruta));
    }
    
    public Partida getPartida() throws IOException, ClassNotFoundException{
        return (Partida) ois.readObject();
    }
    
    public void cerrarFichero() throws IOException{
        ois.close();
    }
    
   
    
   
}
