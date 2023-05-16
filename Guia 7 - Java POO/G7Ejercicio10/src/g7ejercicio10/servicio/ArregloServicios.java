
package g7ejercicio10.servicio;

import g7ejercicio10.entidad.Arreglo;
import java.util.Arrays;

public class ArregloServicios {
    
    public void inicializarA(){
        
        double[] arreglo = new double[50];
        
        
        for(int i = 0; i < 50; i++){
            
            arreglo[i] = Math.random()*101;
           
        }
        Arreglo A = new Arreglo(arreglo, null);
       
        for(int i = 0; i < 50; i++){
            
            System.out.print(A.getA()[i] + " ");
        }
        
    }
    
    public void ordenarInicializarB(Arreglo A){
         
       Arrays.sort(A.getA());
       
       for(int i = 0; i < 20; i++){
           
           if(i < 10){
               
               A.getB()[i] = A.getA()[i];
           }else if(i > 10){
               A.getB()[i] = 0.5;
           }
       }
       
       for(int i = 0; i < 50; i++){
           System.out.print(A.getA()[i] + " ");   
       }
        System.out.println(" ");
        
       for(int j = 0; j < 20; j++){
           System.out.print(A.getB()[j] + " ");
       }
    }
    
}
