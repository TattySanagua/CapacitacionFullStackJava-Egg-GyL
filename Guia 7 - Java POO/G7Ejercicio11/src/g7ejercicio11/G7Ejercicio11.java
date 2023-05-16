
package g7ejercicio11;

import java.util.Date;
import java.util.Scanner;

public class G7Ejercicio11 {

    public static void main(String[] args) {
        
        int dia, mes, anio;
        
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Ingrese el dia en numeros");
        dia = leer.nextInt();
        
        System.out.println("Ingrese el mes en numeros");
        mes = leer.nextInt();
        
        System.out.println("Ingrese el año en numeros");
        anio = leer.nextInt();
        
        Date fecha = new Date(anio-1900,mes-1,dia); //Se le resta al año ingresado 1900 para que la fecha quede bien
                                                    //y al mes se le resta -1
        
        Date fechaActual = new Date();
        
        int diferenciaAnios = fechaActual.getYear() - fecha.getYear();
        
        System.out.println("La fecha ingresada es: " + fecha);
        System.out.println("La fecha actual es: " + fechaActual);
        System.out.println("La cantidad de años entre la fecha ingresada y la actual es" + diferenciaAnios);
        
        //Tambien se puede crear el objeto fecha vacio y setearlo con los valores ingresados
        
        //Date fecha = new Date();
        
        //fecha.setDate(dia);
        //fecha.setMonth(mes);
        //fecha.setYear(anio);
    }
    
}
