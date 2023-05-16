package Entidades;

import java.util.Scanner;

public class Electrodomestico {
    
    protected Double precio;
    protected String color;
    protected char consumoEnergetico;
    protected Integer peso;

    public Electrodomestico() {
    }

    public Electrodomestico(Double precio, String color, char consumoEnergetico, Integer peso) {
        this.precio = precio;
        this.color = color;
        this.consumoEnergetico = consumoEnergetico;
        this.peso = peso;
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
    
    public void comprobarConsumoEnergetico(char letra){
        
        if(letra == 'A' || letra == 'B' || letra == 'C' || letra == 'D' || letra == 'E' || letra == 'F'){
            
           this.consumoEnergetico = letra;
        }else{
            this.consumoEnergetico = 'F';
        }
    }
    
    public void comprobarColor(String color){
        
        if(color.equalsIgnoreCase("blanco") || color.equalsIgnoreCase("negro") || color.equalsIgnoreCase("rojo") || color.equalsIgnoreCase("azul") || color.equalsIgnoreCase("gris")){
            
            this.color = color;
        }else{
            this.color = "blanco";
        }
    }
    
    public Electrodomestico crearElectrodomestico(){
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("Ingrese precio del electrodoméstico");
        Double precio = leer.nextDouble();
        
        if(precio < 1000){
            this.precio = 1000d;
        }else{
            this.precio = precio;
        }
        
        System.out.println("Ingrese el color");
        comprobarColor(leer.next());
        
        System.out.println("Ingrese el consumo energetico (A-B-C-D-E-F)");
        char consumo = leer.next().charAt(0);
        comprobarConsumoEnergetico(consumo);
        
        System.out.println("Ingrese el peso del electrodomestico");
        this.peso = leer.nextInt();
        
        Electrodomestico e = new Electrodomestico(precio, color, consumoEnergetico, peso);
        
        return e;
    };
     
    public Double precioFinal(){
        
        Double precio1;
        Double precio2 = 0d;
        
        switch(this.consumoEnergetico){
            
            case 'A':
                precio1 = 1000d;break;
            case 'B':
                precio1 = 800d;break;
            case 'C':
                precio1 = 600d;break;
            case 'D':
                precio1 = 500d;break;
            case 'E':
                precio1 = 300d;break;
            case 'F':
                precio1 = 100d;break;
            default:
                precio1 = 100d;    
        }
        
        if(this.peso >= 1 && this.peso <=19){
            precio2 = 100d;
        }
        if(this.peso >= 20 && this.peso <= 49){
            precio2 = 500d;
        }
        if(this.peso >= 50 && this.peso <= 79){
            precio2 = 800d;
        }
        if(this.peso >= 80){
            precio2 = 1000d;
        }
        
        return (this.precio + precio1 + precio2);
    };

    
    
}
