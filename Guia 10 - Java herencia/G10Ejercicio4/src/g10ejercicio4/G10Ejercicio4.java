package g10ejercicio4;

import Entidades.Circulo;
import Entidades.Rectangulo;
import java.util.Scanner;

public class G10Ejercicio4 {

    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        
        Circulo c1 = new Circulo();
        
        System.out.println("Ingrese el radio del círculo");
        double radio = leer.nextDouble();
        
        c1.setRadio(radio);
        
        c1.areaPerimetroCirculo(radio);
        
        System.out.println("----------------------");
        Rectangulo r1 = new Rectangulo();
        
        System.out.println("Ingrese la base del rectangulo");
        double base = leer.nextDouble();
        
        System.out.println("Ingrese la altura");
        double altura = leer.nextDouble();
        
        r1.setBase(base);
        r1.setAltura(altura);
        
        r1.areaPerimetroRectangulo(base, altura);
    }
    
}
