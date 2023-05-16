package Entidades;

import java.util.Scanner;

public final class Lavadora extends Electrodomestico{

    private Double carga;

    public Lavadora() {
    }

    public Lavadora(Double carga, Double precio, String color, char consumoEnergetico, Integer peso) {
        super(precio, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    public Double getCarga() {
        return carga;
    }

    public void setCarga(Double carga) {
        this.carga = carga;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsumoEnergetico() {
        return consumoEnergetico;
    }

    public void setConsumoEnergetico(char consumoEnergetico) {
        this.consumoEnergetico = consumoEnergetico;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }
    
    
    
    @Override
    public Electrodomestico crearElectrodomestico() {
        
        System.out.println("LAVADORA");
        super.crearElectrodomestico(); 
        
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("Ingrese la carga de la lavadora");
        this.carga = leer.nextDouble();
        
        Electrodomestico e = new Lavadora(this.carga, this.precio, this.color, this.consumoEnergetico, this.peso);
        
        return e;
    }

    @Override
    public Double precioFinal() {
        
        Double precioAcumulado = super.precioFinal();
        Double precioFinal;
        
        if(this.carga > 30){
            precioFinal = precioAcumulado + 500d;
        }else{
            precioFinal = precioAcumulado;
        }
        
        return precioFinal;
        
    }

    @Override
    public String toString() {
        return "Lavadora: ";
    }

    
    
    
    
}