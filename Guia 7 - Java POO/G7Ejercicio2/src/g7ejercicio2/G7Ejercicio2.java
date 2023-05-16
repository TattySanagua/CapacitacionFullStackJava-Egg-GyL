
package g7ejercicio2;

import g7ejercicio2.entidades.Circunferencia;
import g7ejercicio2.servicios.circunferenciaServicio;

public class G7Ejercicio2 {

    public static void main(String[] args) {
        /*
          Declarar una clase llamada Circunferencia que tenga como atributo privado el radio de 
          tipo real. A continuación, se deben crear los siguientes métodos:
          a) Método constructor que inicialice el radio pasado como parámetro.
          b) Métodos get y set para el atributo radio de la clase Circunferencia.
          c) Método para crearCircunferencia(): que le pide el radio y lo guarda en el atributo del objeto.
          d) Método area(): para calcular el área de la circunferencia (area = Pi*radio*radio).
          e) Método perimetro(): para calcular el perímetro (perimetro = 2*Pi*radio).
        */
        
        circunferenciaServicio sc = new circunferenciaServicio();
        
        Circunferencia c1 = sc.CrearCircunferencia();
        
        double area = sc.area(c1.getRadio());
        double perimetro = sc.perimetro(c1.getRadio());
        
        System.out.println("El área de la circunferencia es = " + area);
        System.out.println("El perímetro de la circunferencia es = " + perimetro);
    }
    
}
