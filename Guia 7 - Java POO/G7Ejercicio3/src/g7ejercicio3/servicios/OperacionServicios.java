
package g7ejercicio3.servicios;

import g7ejercicio3.entidades.Operacion;
import java.util.Scanner;

public class OperacionServicios {
    
    private final Scanner leer = new Scanner(System.in);
    
    public Operacion crearOperacion(){
        
        System.out.println("Ingrese el primer numero");
        double num1 = leer.nextDouble();
        
        System.out.println("Ingrese el segundo numero");
        double num2 = leer.nextDouble();
        
        Operacion op = new Operacion(num1,num2);
        
        return op;
    }
    
    public double sumar(double num1, double num2){
        
        return num1 + num2;
    }
    
    public double restar(double num1, double num2){
        
        return num1 - num2;
    }
    
    public double multiplicar(double num1, double num2){
        
        if(num1 == 0 || num2 == 0){
            
            return 0;
        }
        else{
            return num1*num2;
        }
    }
    
    public double dividir(double num1, double num2){
        
        if(num2 == 0){
            System.out.println("No se puede realizar una division por cero, es indeterminado");
            return 0;
        }else{
            return num1/num2;
        }
    }
}
