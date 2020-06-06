package ArchivoDeGuardadoIO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class ArchivoDeGuardadoIn {
    
    private final ObjectInputStream ois;
    
    public ArchivoDeGuardadoIn(String ruta) throws FileNotFoundException, IOException{
        ois = new ObjectInputStream(new FileInputStream(ruta));
    }
    
    public ArchivoDeGuardado getArchivoDeGuardado() throws IOException, ClassNotFoundException{
        return (ArchivoDeGuardado) ois.readObject();
    }
    
    public void cerrarFichero() throws IOException{
        ois.close();
    }
    
   
    
   
}
