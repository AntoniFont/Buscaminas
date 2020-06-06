package ArchivoDeGuardadoIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ArchivoGuardadoOut {
    
    //ATRIBUTOS
    //CONSTANTES
    private final ObjectOutputStream oos;
    
    //CONSTRUCTOR
    public ArchivoGuardadoOut(String rutaAbsoluta) throws FileNotFoundException, IOException{
        oos = new ObjectOutputStream(new FileOutputStream(rutaAbsoluta));
    }
    
    public void guardar(ArchivoDeGuardado archivoGuardado) throws IOException{ 
        oos.writeObject(archivoGuardado); 
    }
    
    public void cerrarFichero() throws IOException{
        //Hemos contemplado la opcion de poner centinela, pero como dentro de cada archivo
        //hay una única partida,no lo consideramos necesario
        oos.close();
    }
    
    
}
