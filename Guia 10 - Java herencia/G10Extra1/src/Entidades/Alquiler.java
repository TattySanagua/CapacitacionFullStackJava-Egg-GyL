package Entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Alquiler {
    
    private String nombreCliente;
    private int dni;
//    private String fechaAlquiler;
//    private String fechaDevolucion;
    private String posicionAmarre;
    private Barco barco;
    
    public Alquiler() {
    }

    public Alquiler(String nombreCliente, int dni, String posicionAmarre, Barco barco) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
//        this.fechaAlquiler = fechaAlquiler;
//        this.fechaDevolucion = fechaDevolucion;
        this.posicionAmarre = posicionAmarre;
        this.barco = barco;
    }

    

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

//    public String getFechaAlquiler() {
//        return fechaAlquiler;
//    }
//
//    public void setFechaAlquiler(String fechaAlquiler) {
//        this.fechaAlquiler = fechaAlquiler;
//    }
//
//    public String getFechaDevolucion() {
//        return fechaDevolucion;
//    }
//
//    public void setFechaDevolucion(String fechaDevolucion) {
//        this.fechaDevolucion = fechaDevolucion;
//    }

    public String getPosicionAmarre() {
        return posicionAmarre;
    }

    public void setPosicionAmarre(String posicionAmarre) {
        this.posicionAmarre = posicionAmarre;
    }

    public Barco getBarco() {
        return barco;
    }

    public void setBarco(Barco barco) {
        this.barco = barco;
    }

    public int calcularAlquiler(int dias){
        
//       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//       
//       Date fechaModificada1 = formato.parse(this.fechaAlquiler);
//       Date fechaModificada2 = formato.parse(this.fechaDevolucion);
//        
//       int dias = fechaModificada2.getDay() - fechaModificada1.getDay();
        
        int precio = dias*this.barco.calcularModulo();
        
        return precio;
    }
    
    
}
