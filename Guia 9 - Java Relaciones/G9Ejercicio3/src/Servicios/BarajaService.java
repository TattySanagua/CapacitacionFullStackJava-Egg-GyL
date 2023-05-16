package Servicios;

import Entidades.Baraja;
import Entidades.Carta;
import Enumeraciones.Palo;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BarajaService {
    
    private Baraja baraja0;
    private Baraja baraja1;
    private Scanner leer;

    public BarajaService() {
        
        this.baraja0 = new Baraja();
        this.baraja1 = new Baraja();
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public Baraja crearBarajaInicial(){
        
        List<Carta> cartas = new ArrayList<>();
        
        for(Palo var : Palo.values()){
            
            for(int i = 0; i < 12; i++){
                
                if(i+1 == 8 || i+1 == 9){
                    
                }else{
                    
                    Carta c = new Carta(i+1,var);
                    
                    cartas.add(c);
                }
                
            }
        }
        
        baraja0.setCartas(cartas);
        
        return baraja0;
    }
    
    
    
}
