
package g7ejercicio3;

import g7ejercicio3.entidades.Operacion;
import g7ejercicio3.servicios.OperacionServicios;

public class G7Ejercicio3 {

    public static void main(String[] args) {
        
        OperacionServicios os = new OperacionServicios();
        
        Operacion op = os.crearOperacion();
        
        System.out.println("Suma = " + os.sumar(op.getNumero1(), op.getNumero2()));
        System.out.println("Resta = " + os.restar(op.getNumero1(), op.getNumero2()));
        System.out.println("Multiplicacion = "+ os.multiplicar(op.getNumero1(), op.getNumero2()));
        System.out.println("Division = " + os.dividir(op.getNumero1(), op.getNumero2()));
        
    }
    
}
