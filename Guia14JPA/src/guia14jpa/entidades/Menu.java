package guia14jpa.entidades;

import guia14jpa.servicios.AutorServicio;
import guia14jpa.servicios.EditorialServicio;
import guia14jpa.servicios.LibroServicio;
import java.util.Scanner;

public class Menu {
    
    private final AutorServicio autorServicio = new AutorServicio();
    private final LibroServicio libroServicio = new LibroServicio();
    private final EditorialServicio editorialServicio = new EditorialServicio();
    private Scanner leer;
    
    public Menu() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
    }
    
    public void menuOpciones(){
        
        System.out.println("LIBRERÍA");
        
        String opcion = "no salir";
        
        while(!"salir".equalsIgnoreCase(opcion)){
            
            System.out.println("Elija entre el siguiente menú de opciones");
        
            System.out.println("1- Crear un Libro");
            System.out.println("2- Ver Todos los Libros");
            System.out.println("3- Ver un libro por su Isbn");
            System.out.println("4- Ver los libros de un Autor");
            System.out.println("5- Ver los libros de una Editorial");
            System.out.println("6- Modificar un libro");
            System.out.println("7- Eliminar un Libro");
        
            System.out.println("8- Crear un Autor");
            System.out.println("9- Ver Todos los Autores");
            System.out.println("10- Ver información de un Autor");
            System.out.println("11- Modificar un Autor");
            System.out.println("12- Eliminar un Autor");
        
            System.out.println("13- Crear una Editorial");
            System.out.println("14- Ver Todas las Editoriales");
            System.out.println("15 - Ver información de una Editorial");
            System.out.println("16- Modificar una Editorial");
            System.out.println("17- Eliminar una Editorial");
        
            System.out.println("18- Salir del Menu");
            
            Integer campo = leer.nextInt();
            
            switch(campo){
                case 1:
                    libroServicio.crearLibro();
                case 2:
                    libroServicio.listarTodosLibros();
                    break;
                case 3:
                    libroServicio.buscarPorIsbn();
                    break;
                case 4:
                    libroServicio.buscarPorAutor();
                    break;
                case 5:
                    libroServicio.buscarPorEditorial();
                    break;
                case 6:
                    libroServicio.modificarLibro();
                    break;
                case 7:
                    libroServicio.eliminarLibro();
                    break;
                case 8:
                    autorServicio.crearAutor();
                    break;
                case 9:
                    autorServicio.listarTodos();
                    break;
                case 10:
                    autorServicio.buscarPorNombre();
                    break;
                case 11:
                    autorServicio.modificarAutor();
                    break;
                case 12:
                    autorServicio.eliminarAutor();
                    break;
                case 13:
                    editorialServicio.crearEditorial();
                    break;
                case 14:
                    editorialServicio.listarTodos();
                    break;
                case 15:
                    editorialServicio.buscarPorNombre();
                    break;
                case 16:
                    editorialServicio.modificarEditorial();
                    break;
                case 17:
                    editorialServicio.eliminarEditorial();
                    break;
                default:
                    opcion = "salir";
                    break;
            }
        }
        
    }
    
}
