
package Services;

import Entidades.NIF;
import java.util.Scanner;

public class NIFService {
    
    Scanner leer = new Scanner(System.in);
    
    public NIF crearNIF(){
        
        NIF nif = new NIF();
        
        System.out.println("Ingrese el DNI");
        nif.setDni(leer.nextInt());
        
        int resto = (int) (nif.getDni()%23);
        
        char[] letras = new char[23];
        
        letras[0] = 'T'; letras[1] = 'R'; letras[2] = 'W'; letras[3] = 'A';
        letras[4] = 'G'; letras[5] = 'M'; letras[6] = 'Y'; letras[7] = 'F';
        letras[8] = 'P'; letras[9] = 'D'; letras[10] = 'X'; letras[11] = 'B';
        letras[12] = 'N'; letras[13] = 'J'; letras[14] = 'Z'; letras[15] = 'S';
        letras[16] = 'Q'; letras[17] = 'V'; letras[18] = 'H'; letras[19] = 'L';
        letras[20] = 'C'; letras[21] = 'K'; letras[22] = 'E';
        
        nif.setLetra(letras[resto]);
        
        return nif;
    }
    
    public void mostrar(NIF nif){
        
        System.out.println("Su NIF es " + nif.getDni() + "-" + nif.getLetra());
    }
    
}
