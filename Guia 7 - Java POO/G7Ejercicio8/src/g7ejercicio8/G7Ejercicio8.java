
package g7ejercicio8;

import g7ejercicio8.entidades.Cadena;
import g7ejercicio8.servicios.CadenaServicio;

public class G7Ejercicio8 {

    public static void main(String[] args) {
       
        CadenaServicio cs = new CadenaServicio();
        
        Cadena c = cs.crearCadena();
        
        System.out.println("Cantidad de vocales de la frase: " + cs.cantidadVocales(c));
        
        System.out.println("La frase invertida es: " + cs.invertirFrase(c));
        
        int cantidad = cs.vecesRepetido(c);
        System.out.println("Cantidad de veces que se repite el caracter es " + cantidad);
        
        cs.compararLongitud(c);
        
        System.out.println("Las frases unidas son : " + cs.unirFrases(c));
        
        System.out.println("Reemplazando caracter: " + cs.reemplazarLetra(c));
        
        System.out.println("La letra esta contenida en la frase? : " + cs.contiene(c));
        
        
        
    }
    
    
}
