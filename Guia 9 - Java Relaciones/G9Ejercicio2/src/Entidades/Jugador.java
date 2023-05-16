
package Entidades;

public class Jugador {
    
    private Integer id;
    private String nombre;
    private boolean mojado;

    public Jugador() {
    }

    public Jugador(Integer id) {
        this.id = id;
        String nombreJ = id.toString();
        nombreJ = "Jugador".concat(nombreJ);
        this.nombre = nombreJ;
        this.mojado = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isMojado() {
        return mojado;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }
    
    //Metodos

    public boolean disparo(RevolverDeAgua r){
        
        boolean var = false;
        
        if(r.mojar()){
            mojado = true;
            var = true;
        }
       
        r.siguienteChorro();
        return var;
    }
    
    @Override
    public String toString() {
        return "Jugador{" + "id=" + id + ", nombre=" + nombre + ", mojado=" + mojado + '}';
    }
    
    
    
}
