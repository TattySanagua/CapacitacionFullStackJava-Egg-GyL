
package g7ejercicio2.servicios;

import g7ejercicio2.entidades.Circunferencia;
import java.util.Scanner;

public class circunferenciaServicio {
    
    private final Scanner leer = new Scanner(System.in);
    
    public Circunferencia CrearCircunferencia(){
        
        System.out.println("Ingrese el radio para la circunferencia");
        double radio = leer.nextDouble();
        
        Circunferencia c = new Circunferencia(radio);
        
        return c;
    }
    
    public double area(double r){
                
        return Math.PI*r*r;
    }
    
    public double perimetro(double r){
        
        return 2*Math.PI*r;
    }
}
