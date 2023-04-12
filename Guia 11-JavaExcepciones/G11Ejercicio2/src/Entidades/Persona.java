package Entidades;

public class Persona {
    
    private String[] apodos;

    public Persona() {
        this.apodos = new String[3];
    }
    
    

    public Persona(String[] apodos) {
        this.apodos = apodos;
    }

    public String[] getApodos() {
        return apodos;
    }

    public void setApodos(String[] apodos) {
        this.apodos = apodos;
    }

    @Override
    public String toString() {
        return "Persona{" + "apodos=" + apodos + '}';
    }
    
    
}
