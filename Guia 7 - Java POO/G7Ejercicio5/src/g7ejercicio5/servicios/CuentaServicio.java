
package g7ejercicio5.servicios;

import g7ejercicio5.entidad.Cuenta;
import java.util.Scanner;

public class CuentaServicio {
  
    private final Scanner leer = new Scanner(System.in);
    
    public Cuenta crearCuenta(){
        
        System.out.println("Ingrese DNI");
        long dni = leer.nextLong();
        
        System.out.println("Ingrese numero de cuenta");
        int numCuenta = leer.nextInt();
        
        Cuenta c = new Cuenta(numCuenta,dni,0);
        
        return c;
    }
    
    public void ingresar(Cuenta c){
        
        System.out.println("Digite el monto a ingresar");
        double ingreso = leer.nextDouble();
        
        double saldo =  c.getSaldoActual() + ingreso;
        c.setSaldoActual(saldo);
    }
    
    public void retirar(Cuenta c){
        
        System.out.println("Digite el monto a retirar");
        double retiro = leer.nextDouble();
        
        double saldo = c.getSaldoActual();
        
        if(saldo < retiro){
            c.setSaldoActual(0);
        }else{
            c.setSaldoActual( saldo - retiro);
        }
    }
    
    public void extraccionRapida(Cuenta c){
        
        System.out.println("Digite el monto e extraer");
        double extraccion = leer.nextDouble();
        
        double saldoTotal = c.getSaldoActual();
        
        if(extraccion <= 0.2*saldoTotal){
            
            c.setSaldoActual( saldoTotal - extraccion);
        }else{
            System.out.println("Puede extraer hasta " + 0.2*saldoTotal);
        }
    }
    
    public void consultarSaldo(Cuenta c){
        
        System.out.println("Su saldo actual es de $" + c.getSaldoActual());
        
    }
    
    
}
