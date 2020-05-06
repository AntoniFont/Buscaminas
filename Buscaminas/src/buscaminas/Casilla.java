package buscaminas;
public class Casilla {
    
    
    //CONSTANTES
    
    //VARIABLES
    private boolean tieneBomba;
    private boolean tapado = true;
    private int numero = 0;
    
    
    
    public Casilla(){
    }
    
    public Casilla(boolean tieneBomba){
        this.tieneBomba = tieneBomba;
    }

    public int getNumero(){
        return numero;
    }
    
    public boolean isBomba(){
        return tieneBomba;
    }

    public boolean isTapado() {
        return tapado;
    }

    public void setTapado(boolean tapado) {
        this.tapado = tapado;
    }

    
    
    
    
    
    
}
