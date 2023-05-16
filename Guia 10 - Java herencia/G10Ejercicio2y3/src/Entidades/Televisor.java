package Entidades;

import java.util.Scanner;

public final class Televisor extends Electrodomestico{
    
    private Integer resolucion;
    private boolean tdt;

    public Televisor() {
    }

    public Televisor(Integer resolucion, boolean tdt, Double precio, String color, char consumoEnergetico, Integer peso) {
        super(precio, color, consumoEnergetico, peso);
        this.resolucion = resolucion;
        this.tdt = tdt;
    }

    public Integer getResolucion() {
        return resolucion;
    }

    public void setResolucion(Integer resolucion) {
        this.resolucion = resolucion;
    }

    public boolean isTdt() {
        return tdt;
    }

    public void setTdt(boolean tdt) {
        this.tdt = tdt;
    }
    
    @Override
    public Electrodomestico crearElectrodomestico() {
        System.out.println("TELEVISOR400");
        super.crearElectrodomestico();
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("Ingrese la resolucion del Televisor en pulgadas");
        this.resolucion = leer.nextInt();
        
        System.out.println("Ingrese si posee sintonizador TDT");
        String opcion = leer.next();
        
        if(opcion.equalsIgnoreCase("si")){
            this.tdt = true;
        }else if(opcion.equalsIgnoreCase("no")){
            this.tdt = false;
        }
        
        Electrodomestico e = new Televisor(this.resolucion, this.tdt, this.precio, this.color, this.consumoEnergetico, this.peso);
        
        return e;
    }
    
    @Override
    public Double precioFinal() {
        
        Double precioAcumulado = super.precioFinal();
        Double precioC;
        Double precioFinal;
        
        if(this.resolucion > 40){
            precioC = precioAcumulado*1.3;
        }else{
            precioC = precioAcumulado;
        }
        
        if(this.tdt){
            precioFinal = precioC + 500d;
        }else{
            precioFinal = precioC;
        }
        
        
        return precioFinal;
        
    }

    @Override
    public String toString() {
        return "Televisor: ";
    }
    
    
}
