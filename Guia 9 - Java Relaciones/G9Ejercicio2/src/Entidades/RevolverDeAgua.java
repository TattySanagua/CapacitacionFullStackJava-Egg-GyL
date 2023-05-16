package Entidades;

public class RevolverDeAgua {
    
    private int posicionActual;
    private int posicionAgua;

    public RevolverDeAgua() {
    }

    public RevolverDeAgua(int posicionActual, int posicionAgua) {
        this.posicionActual = posicionActual;
        this.posicionAgua = posicionAgua;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public int getPosicionAgua() {
        return posicionAgua;
    }

    public void setPosicionAgua(int posicionAgua) {
        this.posicionAgua = posicionAgua;
    }

    //Métodos
    
    public void llenarRevolver(){
        
        //Suponiendo que tiene 5 posiciones el tambor
        
        posicionActual = (int) (Math.random() * 5+1);
        posicionAgua = (int) (Math.random() * 5+1);
    }
    
    public boolean mojar(){
        
        return posicionActual==posicionAgua;
    }
    
    public void siguienteChorro(){
        
        if(posicionActual == 5){
            posicionActual = 1;
        }else{
            posicionActual++;
        }
    }
    
    @Override
    public String toString() {
        return "RevolverDeAgua{" + "posicionActual=" + posicionActual + ", posicionAgua=" + posicionAgua + '}';
    }
    
    
}
