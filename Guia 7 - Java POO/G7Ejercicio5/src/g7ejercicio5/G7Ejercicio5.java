package g7ejercicio5;

import g7ejercicio5.entidad.Cuenta;
import g7ejercicio5.servicios.CuentaServicio;

public class G7Ejercicio5 {

    public static void main(String[] args) {
        
       CuentaServicio cs = new CuentaServicio();
       
       Cuenta c = cs.crearCuenta();
       
       cs.ingresar(c);
       
       cs.retirar(c);
       
       cs.extraccionRapida(c);
       
       cs.consultarSaldo(c);
       
        System.out.println(c.toString());
       
    }
    
}
