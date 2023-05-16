package Services;

import Entidades.Meses;
import java.util.Scanner;

public class MesesService {
    
    Scanner leer = new Scanner(System.in);
    
    public Meses inicializar(){
        
        Meses mes = new Meses();
        
        mes.setMeses(new String[]{"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"});
        
        mes.setMesSecreto(mes.getMeses()[2]);
        
        return mes;
    }
    
    public void adivinarMesSecreto(Meses mes){
        
        System.out.print("Adivine el mes secreto. Introduzca el nombre del mes en minúsculas:");
        String mesAdivina = leer.next();
        
        while(!mesAdivina.equals(mes.getMesSecreto())){
            
            System.out.print("No ha acertado. Intente adivinarlo introduciendo otro mes: ");
            
            mesAdivina = leer.next();
        }
        
        if(mesAdivina.equals(mes.getMesSecreto())){
            
            System.out.println("Ha acertado!!");
        }
    }
}
