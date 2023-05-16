package Servicios;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ServicioProducto {
    
    private Scanner leer;
    private HashMap<String,Double> mapaProductos;

    public ServicioProducto() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.mapaProductos = new HashMap<>();
    }
    
   public void cargarProducto(){
       
       String opcion = "Si";
       String nombre;
       Double precio;
       
       while(opcion.equalsIgnoreCase("si")){
           
           System.out.println("Ingrese nobre del producto");
           nombre = leer.next();
           
           System.out.println("Ingrese el precio");
           precio = leer.nextDouble();
           
           mapaProductos.put(nombre,precio);
           
           System.out.println("Quiere seguir ingresando productos? (Si/No)");
           opcion = leer.next();
       }
       
   } 
   
   public void mostrarProductos(){
       
       // entry.getKey trae la llave y entry.getValue trae los valores del mapa, 
       // Es decir todos sus atributos
       
       for(Map.Entry<String,Double> entry : mapaProductos.entrySet()){
           
           System.out.println("Nombre: " + entry.getKey() + "; Precio: " + entry.getValue());
       }
   }
    
   public void modificarPrecio(String nombre, Double nuevoPrecio){
       
       for(Map.Entry<String,Double> entry : mapaProductos.entrySet()){
           
           if(entry.getKey().equalsIgnoreCase(nombre)){
               
               entry.setValue(nuevoPrecio);
           }
       }
   }
   
   public void eliminarproducto(String nombre){
       
       mapaProductos.remove(nombre);
   }
}
