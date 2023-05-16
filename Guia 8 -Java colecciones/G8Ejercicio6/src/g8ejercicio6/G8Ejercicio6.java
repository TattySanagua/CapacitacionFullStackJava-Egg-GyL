package g8ejercicio6;

import Servicios.ServicioProducto;
import java.util.Scanner;

public class G8Ejercicio6 {

    public static void main(String[] args) {
        
        ServicioProducto servProd = new ServicioProducto();
        Scanner leer = new Scanner(System.in);
        
        String salir = "No";
        
        while(salir.equalsIgnoreCase("no")){
            
            System.out.println("Seleccione una opcion");
            System.out.println("");
            System.out.println("1 - Cargar productos");
            System.out.println("2 - Modificar precio a un producto");
            System.out.println("3 - Mostrar todos los productos");
            System.out.println("4 - Eliminar un producto");
            System.out.println("5 - Salir");
            
            int opcion = leer.nextInt();
            
            System.out.println("");
            
            switch(opcion){
                case 1:
                    servProd.cargarProducto();
                    break;
                case 2:
                    System.out.println("Ingrese el producto al cual le quiere cambiar precio");
                    String nombre = leer.next();
                    
                    System.out.println("Ingrese el nuevo precio");
                    Double precio = leer.nextDouble();
                    
                    servProd.modificarPrecio(nombre, precio);
                    
                    System.out.println("Modificado correctamente");
                    
                    break;
                case 3:
                    servProd.mostrarProductos();
                    break;
                case 4:
                    System.out.println("Ingrese el nombre del producto que desea eliminar");
                    String prod = leer.next();
                    
                    servProd.eliminarproducto(prod);
                    break;
                case 5:
                    salir = "si";
                    break;
        }
            System.out.println("");
        }
        
    }
    
}
