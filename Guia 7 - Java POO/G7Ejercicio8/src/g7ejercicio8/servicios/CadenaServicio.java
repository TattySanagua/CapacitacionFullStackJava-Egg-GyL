
package g7ejercicio8.servicios;

import g7ejercicio8.entidades.Cadena;
import java.util.Scanner;

public class CadenaServicio {
    
    private Scanner leer = new Scanner(System.in);
    
    public Cadena crearCadena(){
        
        System.out.println("Ingrese una frase");
        String frase = leer.nextLine();
        
        int longitud = frase.length();
        
        Cadena c = new Cadena(frase,longitud);
        return c;
    }
    
    public int cantidadVocales(Cadena c){
        
        int vocales = 0;
        String frase = c.getFrase();
        
        for(int i = 0; i < frase.length(); i++){
            
            if(frase.charAt(i) == 'a' || frase.charAt(i) == 'A' || frase.charAt(i) == 'e' || frase.charAt(i) == 'E' || frase.charAt(i) == 'i' || frase.charAt(i) == 'I' || frase.charAt(i) == 'o' || frase.charAt(i) == 'O' || frase.charAt(i) == 'u' || frase.charAt(i) == 'U'){
                vocales++;
            }
        }
        
        return vocales;
    }
    
    public String invertirFrase(Cadena c){
        
        String frase = c.getFrase();
        String invertida = "";
        
        for(int i = frase.length() - 1; i >= 0; i--){
            
            invertida = invertida + frase.charAt(i);
        }
        
        return invertida;
    }
    
    public int vecesRepetido(Cadena c){
        
        System.out.println("Ingrese un caracter");
        char letra = leer.next().charAt(0);
        
        String frase = c.getFrase();
        
        int cont = 0;
        
        for(int i = 0; i < frase.length(); i++){
            
            if(frase.charAt(i) == letra){
                cont++;
            }
        }
        return cont;
    }
    
    public void compararLongitud(Cadena c){
        
        String fraseAnterior = c.getFrase();
        
        System.out.println("Ingrese una nueva frase");
        String fraseNueva = leer.next();
        
        int longitudVieja = c.getLongitud();
        int longitudNueva = fraseNueva.length();
        
        if(longitudVieja > longitudNueva){
            
            System.out.println("La frase ingresada es mas corta que la frase anterior");
            
        }else{
            
            System.out.println("La frase ingresada es mas larga que la frase anterior");
        }
        
    }
    
    public String unirFrases(Cadena c){
        
        System.out.println("Ingrese una frase para unir a la primera frase");
        String fraseNueva = leer.next();
        
        String fraseAnterior = c.getFrase();
        
        return fraseAnterior.concat(fraseNueva);
        
    }
    
    public String reemplazarLetra(Cadena c){
        
        String frase = c.getFrase();
        
        System.out.println("Ingrese una letra para reemplazar la 'a' en la frase");
        char letra = leer.next().charAt(0);
        
        return frase.replace('a', letra);
        
    }
    
    public boolean contiene(Cadena c){
        
        String frase = c.getFrase();
        
        System.out.println("Ingrese una letra para saber si está contenida en la frase");
        char letra = leer.next().charAt(0);
        
        for(int i=0; i<frase.length(); i++){
            
            if(frase.charAt(i) == letra){
                
                return true;
            }
        }
        return false;
        
    }
}
