package Entidades;

public class Barco {
   
    protected int matricula;
    protected int eslora; //metros
    protected int anioFabricacion;

    public Barco() {
    }

    public Barco(int matricula, int eslora, int anioFabricacion) {
        this.matricula = matricula;
        this.eslora = eslora;
        this.anioFabricacion = anioFabricacion;
    }
    
    public int calcularModulo(){
        
        return eslora*10;
        
    }
}
