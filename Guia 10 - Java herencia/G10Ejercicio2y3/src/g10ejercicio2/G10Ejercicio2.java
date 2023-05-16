package g10ejercicio2;

import Entidades.Electrodomestico;
import Entidades.Lavadora;
import Entidades.Televisor;
import java.util.ArrayList;

public class G10Ejercicio2 {

    public static void main(String[] args) {
        
        Electrodomestico e1 = new Lavadora();
        
        e1.crearElectrodomestico();
        //Punto2)
        //System.out.println("El precio final de consumo de su lavadora es de $" + e1.precioFinal());
        
        Electrodomestico e2 = new Televisor();
        
        e2.crearElectrodomestico();
        //Punto2)
        //System.out.println("El precio final de consumo de su Televisor es de $" + e2.precioFinal());
        
        //Punto3)
        Electrodomestico e3 = new Lavadora(30d, 55000d, "blanco", 'B', 30);
        Electrodomestico e4 = new Televisor(50, true, 200000d, "negro", 'C', 15);
        
        ArrayList<Electrodomestico> electrodomesticos = new ArrayList<>();
        
        electrodomesticos.add(e1);
        electrodomesticos.add(e2);
        electrodomesticos.add(e3);
        electrodomesticos.add(e4);
        
        System.out.println("");
        
        Double suma = 0d;
        
        for(Electrodomestico var : electrodomesticos){
            
            System.out.println("Precio final de " + var.toString() + " $" + var.precioFinal());
            
            suma = suma + var.precioFinal();
        }
        
        System.out.println("Precio total de todos los electrodomésticos: $" + suma);
    }
    
}
