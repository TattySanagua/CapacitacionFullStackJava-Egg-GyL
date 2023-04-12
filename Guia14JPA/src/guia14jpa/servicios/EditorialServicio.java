package guia14jpa.servicios;

import guia14jpa.entidades.Autor;
import guia14jpa.entidades.Editorial;
import guia14jpa.persistencia.EditorialDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EditorialServicio {
    
    private Scanner leer;
    private EditorialDAO editorialDao;

    public EditorialServicio() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.editorialDao = new EditorialDAO();
    }
    
    public Editorial crearEditorial(){
        
        Editorial editorial = new Editorial();
        
        try {
            
            System.out.println("Ingrese el nombre de la editorial");
            String nombre = leer.nextLine();
            
            if(" ".equals(nombre)){
                throw new Exception("Debe indicar el nombre");
            }
            
            editorial.setNombre(nombre);
            editorial.setAlta(true);
            
            editorialDao.guardar(editorial);
            
            return editorial;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        
        
    }
    
    public void eliminarEditorial(){ //Baja Lógica
        
        System.out.println("Ingrese el nombre de la editorial que desea eliminar");
        String nombre = leer.nextLine();
        
        Editorial editorial = editorialDao.buscarPorNombre(nombre);
        
        editorial.setAlta(false);
        
        editorialDao.guardar(editorial);
    }
    
    public void modificarEditorial(){
        
        System.out.println("Que Editorial desea modificar? Escriba el nombre");
        String anterior = leer.nextLine();
        
        Editorial autor = editorialDao.buscarPorNombre(anterior);
        
        System.out.println("Escriba el nuevo nombre");
        String nuevo = leer.nextLine();
        
        autor.setNombre(nuevo);
        
        editorialDao.guardar(autor);
    }
    
    public Editorial buscarPorNombre(){
        
        System.out.println("Ingrese el nombre de la editorial a buscar");
        String nombre = leer.nextLine();
        
        Editorial editorial = editorialDao.buscarPorNombre(nombre);
        
        return editorial;
    }
    
    public void listarTodos(){
        
        List<Editorial> editoriales = editorialDao.listarTodos();
        
        for(Editorial aux : editoriales){
            System.out.println(aux.getId() + "-" +aux.getNombre());
        }
    }
}
