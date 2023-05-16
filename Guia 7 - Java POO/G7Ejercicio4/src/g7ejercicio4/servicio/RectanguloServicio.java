package g7ejercicio4.servicio;

import g7ejercicio4.entidad.Rectangulo;
import java.util.Scanner;

public class RectanguloServicio {
    
    private Scanner leer = new Scanner(System.in);
    
    public Rectangulo crearRectangulo(){
        
        System.out.println("Ingrese la base del rectangulo");
        int base = leer.nextInt();
        
        System.out.println("Ingrese la altura");
        int altura = leer.nextInt();
        
        Rectangulo r = new Rectangulo(base,altura);
        
        return r;
    }
    
    /**
     * Calcula la superficie del rectangulo
     * @param b: base
     * @param a: altura
     * @return superficie
     */
    public int superficie(int b, int a){
        
        return b*a;
    }
    
    public int perimetro(int b, int a){
        
        return (b*a)*2;
    }
    
    public void figura(int b, int a){
        
        for(int i = 1; i <= a; i++){
       
            for(int j = 1; j <= b; j++){
                
                if(i>1 && i<a && j>1 && j<b){
                    System.out.print("  ");
                }else{
                    System.out.print("* ");
                }
            }
            System.out.println("");
        }
    }
}
