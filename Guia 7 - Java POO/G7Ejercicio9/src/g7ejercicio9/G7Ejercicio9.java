
package g7ejercicio9;

import g7ejercicio9.entidades.Matematica;
import g7ejercicio9.servicios.MatematicaServicios;

public class G7Ejercicio9 {

    public static void main(String[] args) {
        
        MatematicaServicios ms = new MatematicaServicios();
        
        Matematica m = ms.crearNumeros();
        
        System.out.println("Los numeros son: " + m.getNumero1() + " y " + m.getNumero2());
        System.out.println("El mayor es: " + ms.devolverMayor(m));
        
        System.out.println("La potencia del mayor elevado al menor es: " + ms.calcularPotencia(m));
        
        System.out.println("La raiz cuadrada del menor es: " + ms.calcularRaiz(m));
        
    }
    
}
