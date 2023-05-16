package g10extra1;

import Entidades.AMotor;
import Entidades.Alquiler;
import Entidades.Barco;
import Entidades.Velero;
import Entidades.Yate;

public class G10Extra1 {

    
    public static void main(String[] args) {
        
        Barco b1 = new Velero(4, 201, 5, 1996);
        Barco b2 = new AMotor(10, 455, 4, 2011);
        Barco b3 = new Yate(3, 50, 682, 6, 2019);
        
        Alquiler a1 = new Alquiler("Tatiana", 555242, "Firme", b1);
        
        System.out.println("Precio de Alquiler del Velero = $" + a1.calcularAlquiler(10));
    }
    
}
