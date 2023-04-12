package guia14jpa.servicios;

import guia14jpa.entidades.Autor;
import guia14jpa.persistencia.AutorDAO;
import java.util.List;
import java.util.Scanner;

public class AutorServicio {
    
    private Scanner leer;
    private final AutorDAO autorDao;

    public AutorServicio() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.autorDao = new AutorDAO();
    }
    
    public Autor crearAutor(){
        
        Autor autor = new Autor();
        
        try {
            
            System.out.println("Ingrese el nombre del autor");
            String nombre = leer.nextLine();
            
            while(" ".equals(nombre)){
                System.out.println("Debe indicar el nombre");
                nombre = leer.nextLine();
            }
            
            autor.setNombre(nombre);
            autor.setAlta(true);
            
            autorDao.guardar(autor);
            
            return autor;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        
    }
    
    public void eliminarAutor(){ //Baja Lógica
        
        listarTodos();
        
        System.out.println("Ingrese el nombre del autor que desea eliminar");
        String nombre = leer.nextLine();
        
        Autor autor = autorDao.buscarPorNombre(nombre);
        
        autor.setAlta(false);
        
        autorDao.guardar(autor);
    }
    
    public void modificarAutor(){
        
        listarTodos();
        
        System.out.println("Que Autor desea modificar? Escriba el nombre");
        String anterior = leer.nextLine();
        
        Autor autor = autorDao.buscarPorNombre(anterior);
        
        System.out.println("Escriba el nuevo nombre");
        String nuevo = leer.nextLine();
        
        autor.setNombre(nuevo);
        
        autorDao.modificar(autor);
    }
    
    public Autor buscarPorNombre(){
        
        System.out.println("Ingrese el nombre del autor a buscar");
        String nombre = leer.nextLine();
        
        Autor autor = autorDao.buscarPorNombre(nombre);
        
        return autor;
    }
    
    public void listarTodos(){
        
        List<Autor> autores = autorDao.listarTodos();
        
        for(Autor aux : autores){
            System.out.println(aux.getId() + "-" +aux.getNombre());
        }
    }
}
