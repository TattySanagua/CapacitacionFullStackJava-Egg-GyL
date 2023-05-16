package g9ejercicio2;

import Entidades.Juego;
import Entidades.Jugador;
import Entidades.RevolverDeAgua;
import java.util.ArrayList;
import java.util.Scanner;

public class G9Ejercicio2 {

    public static void main(String[] args) {
        
        ArrayList<Jugador> jugadores = new ArrayList<>();
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("Cuantos jugadores quiere ingresar?");

        int cantidadJ = leer.nextInt();
        
        for(int i = 0; i < cantidadJ; i++){
            
            Jugador j = new Jugador(i+1);
            
            jugadores.add(j);
        }
        
        RevolverDeAgua r = new RevolverDeAgua();
        
        r.llenarRevolver();
        
        Juego juego = new Juego();
        
        juego.llenarJuego(jugadores, r);
        
        boolean sigue = true;
        int turno = 0;
        
        while(sigue){

            if(turno == (cantidadJ)){
                turno = 0;
            }
           sigue = juego.ronda(turno);
           
           if(sigue){
               System.out.println("El jugador " + jugadores.get(turno).getNombre() + " se salvo, que pase el siguiente");
               
           }else{
               System.out.println("El jugador " + jugadores.get(turno).getNombre() + " perdió");
               System.out.println("Fin del juego");
           }
           
           turno++;
        }
    }
    
}
