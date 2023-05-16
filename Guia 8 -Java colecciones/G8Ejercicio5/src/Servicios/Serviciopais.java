package Servicios;

import Entidades.Pais;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Serviciopais {
    
    private Scanner leer;
    private HashSet<Pais> paises;

    public Serviciopais() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.paises = new HashSet<>();
    }
    
    public HashSet<Pais> crearPaises(){
        
        String opcion = "Si";
        String nombre;
        
        while(opcion.equalsIgnoreCase("si")){
            
            System.out.println("Ingrese un País");
            nombre = leer.next();
            
            Pais pais = new Pais(nombre);
            
            paises.add(pais);
            
            System.out.println("Quiere agregar otro pais? (Si/No)");
            opcion = leer.next();
        }
        
        System.out.println("Listado de paises");
        for(Pais elemento : paises){
            System.out.println(elemento);
        }
        return paises;
    }
    
    public HashSet<Pais> eliminarPais(HashSet<Pais> paises, String pais){
        
        int cont = 0;
        
        Iterator<Pais> iter = paises.iterator();
        
        while(iter.hasNext()){
            Pais aux = iter.next();
            
            if(aux.getNombre().equalsIgnoreCase(pais)){
                iter.remove();
                cont++;
            }
        }
        
        if(cont==0){
            System.out.println("El pais ingresado no se encuentra en el conjunto");
        }
        
        return paises;
    }
}
