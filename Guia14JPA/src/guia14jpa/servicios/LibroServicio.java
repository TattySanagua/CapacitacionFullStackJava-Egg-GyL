package guia14jpa.servicios;

import guia14jpa.entidades.Autor;
import guia14jpa.entidades.Editorial;
import guia14jpa.entidades.Libro;
import guia14jpa.persistencia.AutorDAO;
import guia14jpa.persistencia.EditorialDAO;
import guia14jpa.persistencia.LibroDAO;
import java.util.List;
import java.util.Scanner;

public class LibroServicio {
 
    private Scanner leer;
    private final LibroDAO libroDao;
    private Autor autor;
    private AutorDAO autorDao;
    private Editorial editorial;
    private EditorialDAO editorialDao;

    public LibroServicio() {
        this.leer = new Scanner(System.in).useDelimiter("\n");
        this.libroDao = new LibroDAO();
        this.autor = new Autor();
        this.autorDao = new AutorDAO();
        this.editorial = new Editorial();
        this.editorialDao = new EditorialDAO();
    }
    
    public Libro crearLibro(){
        
        Libro libro = new Libro();
        
        try {
            
            System.out.println("Ingrese el título del Libro");
            String titulo = leer.nextLine();
            
            while(" ".equals(titulo)){
                System.out.println("Debe indicar el titulo");
                titulo = leer.nextLine();
            }
       
            
            System.out.println("Ingrese el año de edición");
            Integer anio = leer.nextInt();
            
            while(anio == 0){
                System.out.println("Debe indicar el año de edición");
                anio = leer.nextInt();
            }
            
            System.out.println("Ingrese la cantidad de ejemplares");
            Integer ejemplares = leer.nextInt();
            
            while(ejemplares <= 0 ){
                System.out.println("Debe indicar la cantidad de ejemplares");
                ejemplares = leer.nextInt();
            }
            
            System.out.println("Ingrese la cantidad de ejemplares Prestados");
            Integer ejemplaresPrestados = leer.nextInt();
            
            while(ejemplaresPrestados < 0 || ejemplaresPrestados > ejemplares){
                System.out.println("Debe indicar un valor valido");
                ejemplaresPrestados = leer.nextInt();
            }
            
            System.out.println("Ingrese el nombre del Autor");
            String nombreAutor = leer.next();
            
            while(" ".equals(nombreAutor)){
                System.out.println("Debe indicar el Autor");
                nombreAutor = leer.next();
            }
            
            autor = autorDao.buscarPorNombre(nombreAutor);
            
            System.out.println("Ingrese la Editorial");
            String nombreEditorial = leer.next();
            
            while(" ".equals(nombreEditorial)){
                System.out.println("Debe indicar la Editorial");
                nombreEditorial = leer.next();
            }
            
            editorial = editorialDao.buscarPorNombre(nombreEditorial);
            
            libro.setTitulo(titulo);
            libro.setAnio(anio);
            libro.setEjemplares(ejemplares);
            libro.setEjemplaresPrestados(ejemplaresPrestados);
            libro.setEjemplaresRestantes(ejemplares - ejemplaresPrestados);
            libro.setAlta(true);
            libro.setAutor(autor);
            libro.setEditorial(editorial);
            
            libroDao.guardar(libro);
            return libro;
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    public void eliminarLibro(){ //Baja Lógica
        
        listarTodosLibros();
        
        System.out.println("Que libro quiere eliminar? escriba el Isbn");
        Long isbn = leer.nextLong();
        
        Libro libro = libroDao.buscarPorIsbn(isbn);
        
        libro.setAlta(false);
        
        libroDao.guardar(libro);   
    }
    
    public void modificarLibro(){
        listarTodosLibros();
        
        System.out.println("Que libro desea modificar? Escriba el Isbn");
        Long isbn = leer.nextLong();
   
        Libro libro = libroDao.buscarPorIsbn(isbn);
            
        String opcion = "si";
        
        while(!"no".equals(opcion)){
            
            System.out.println("Elija el campo a modificar: 1 - Título, 2 - Año, 3 - Ejemplares, "
                    + "4 - Ejemplares prestados, 5 - Autor, 6 - Editorial, 7 - No modificar");
            
            Integer campo = leer.nextInt();
            
            switch(campo){
                case 1:
                    System.out.println("Ingrese el nuevo título");
                    String nuevoTitulo = leer.nextLine();
                    libro.setTitulo(nuevoTitulo); break;
                case 2:
                    System.out.println("Ingrese el nuevo año");
                    Integer nuevoAnio = leer.nextInt();
                    libro.setAnio(nuevoAnio); break;
                case 3:
                    System.out.println("Ingrese la cantidad de ejemplares");
                    Integer nuevoEjemplares = leer.nextInt();
                    libro.setEjemplares(nuevoEjemplares); break;
                case 4:
                    System.out.println("Ingrese la cantidad de ejemplares prestados");
                    Integer nuevoEjemplaresPrestados = leer.nextInt();
                    libro.setEjemplaresPrestados(nuevoEjemplaresPrestados); break;
                case 5:
                    System.out.println("Ingrese el nuevo Autor");
                    String nuevoNombreAutor = leer.nextLine();
                    autor = autorDao.buscarPorNombre(nuevoNombreAutor);
                    
                    libro.setAutor(autor);
                    
                    if(autor == null){
                        Autor autorNuevo = new Autor();
                        autorNuevo.setNombre(nuevoNombreAutor);
                        autorNuevo.setAlta(true);
                        autorDao.guardar(autorNuevo);
                        libro.setAutor(autorNuevo);
                    }; break;
                case 6:
                    System.out.println("Ingrese la nueva Editorial");
                    String nuevoNombreEditorial = leer.nextLine();
                    editorial = editorialDao.buscarPorNombre(nuevoNombreEditorial);
                    
                    libro.setEditorial(editorial);
                    
                    if(editorial == null){
                        Editorial editorialNuevo = new Editorial();
                        editorialNuevo.setNombre(nuevoNombreEditorial);
                        editorialNuevo.setAlta(true);
                        editorialDao.guardar(editorialNuevo);
                        libro.setEditorial(editorialNuevo);
                    }; break;
                default:
                    opcion = "no";
            }
        }
        
        libroDao.modificar(libro);
    }
    
    public void listarTodosLibros(){
        
        List<Libro> libros = libroDao.listarTodos();
        
        for(Libro aux : libros){
            System.out.println("Isbn: " +aux.getId() + "- Título: " + aux.getTitulo() 
                    + " - Año: " + aux.getAnio() + " - Autor: " + aux.getAutor().getNombre()
                    + " - Editorial: " + aux.getEditorial().getNombre());
        }
    }
    
    public void buscarPorIsbn(){
        
        System.out.println("Ingrese el Isbn del Libro");
        Long isbn = leer.nextLong();
        
        Libro libro = libroDao.buscarPorIsbn(isbn);
        
        libro.toString();
    }
    
    public void buscarPorAutor(){
        
        System.out.println("Ingrese el nombre del Autor");
        String nombre = leer.nextLine();
        
        List<Libro> libros = libroDao.buscarPorAutor(nombre);
        
        for(Libro aux : libros){
            System.out.println("Título: " + aux.getTitulo() + "- Autor: " + aux.getAutor().getNombre());
        }
    }
    
     public void buscarPorEditorial(){
        
        System.out.println("Ingrese el nombre de la Editorial");
        String nombre = leer.nextLine();
        
        List<Libro> libros = libroDao.buscarPorEditorial(nombre);
        
        for(Libro aux : libros){
            System.out.println("Título: " + aux.getTitulo() + "- Editorial: " + aux.getEditorial().getNombre());
        }
    }
}
