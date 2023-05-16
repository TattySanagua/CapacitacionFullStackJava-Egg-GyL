
package g7ejercicio9.servicios;

import g7ejercicio9.entidades.Matematica;
import java.util.Scanner;

public class MatematicaServicios {
    
    private Scanner leer = new Scanner(System.in);
    
    public Matematica crearNumeros(){
        
        double num1 = Math.random()*101;
        double num2 = Math.random()*101;
        
        Matematica m = new Matematica(num1,num2);
        return m;
    }
    
    public double devolverMayor(Matematica m){
        
        double num1 = m.getNumero1();
        double num2 = m.getNumero2();
        
        return Math.max(num1, num2);
        
    }
    
    public double calcularPotencia(Matematica m){
        
        double num1 = m.getNumero1();
        double num2 = m.getNumero2();
        
        double numero1 = Math.round(num1);
        double numero2 = Math.round(num2);
        
        double maximo = Math.max(numero1, numero2);
        double minimo = Math.min(numero1, numero2);
        
        return Math.pow(maximo, minimo);
    }
    
    public double calcularRaiz(Matematica m){
        
        double num1 = m.getNumero1();
        double num2 = m.getNumero2();
        double minimo = Math.min(num1, num2);
        
        double absoluto = Math.abs(minimo);
        
        return Math.sqrt(absoluto);
    }
}
