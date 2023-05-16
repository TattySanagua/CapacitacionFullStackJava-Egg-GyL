package Services;

import Entidades.Ahorcado;
import java.util.Scanner;

public class AhorcadoService {
    
    private Scanner leer = new Scanner(System.in);
    
    public Ahorcado crearJuego(){
        
        Ahorcado juego = new Ahorcado();
        
        System.out.println("Ingrese la palabra");
        String palabra = leer.next();
        
        char[] vector = new char[palabra.length()];
        
        for(int i = 0; i < palabra.length(); i++){
            
            vector[i] = palabra.charAt(i);
        }
        
        juego.setPalabra(vector);
        
        System.out.println("Ingrese la cantidad de jugadas máximas");
        juego.setJugadasMaximas(leer.nextInt());
        
        juego.setLetrasEncontradas(0);
        return juego;
    }
    
    public int longitud(Ahorcado juego){
        
        return juego.getPalabra().length;
    }
    
    public void buscar(Ahorcado juego, char letra){
        
        AhorcadoService as = new AhorcadoService();
        
        int cont = juego.getLetrasEncontradas();
        int cont2 = juego.getJugadasMaximas();
        
        for(int i = 0; i < as.longitud(juego); i++){
            
            if(juego.getPalabra()[i] == letra){
                
                System.out.println("La letra pertenece a la palabra");
                
                juego.setLetrasEncontradas(cont++);
                
                System.out.println("Cantidad de letras encontradas: " + juego.getLetrasEncontradas());
                System.out.println("Cantidad de letras faltantes: " + (as.longitud(juego)-juego.getLetrasEncontradas()));
         
            }
        }
        System.out.println("La letra no pertenece a la palabra");
        juego.setJugadasMaximas(cont2--);
        System.out.println("Numero de oportunidades restantes: " + juego.getJugadasMaximas());
          
    }
    
    public int mostrarIntentos(Ahorcado juego){
        
        return juego.getJugadasMaximas();
    }
    
    public void juego(Ahorcado juego){
        
        AhorcadoService as = new AhorcadoService();
        
        as.crearJuego();
        
        //System.out.println("Longitud de la palabra: " + as.longitud(juego));
        
        while(as.mostrarIntentos(juego) > 0){
            
            System.out.println("Ingrese una letra");
            char letra = leer.next().charAt(0);
            as.buscar(juego, letra);
        }
        
    }
}
