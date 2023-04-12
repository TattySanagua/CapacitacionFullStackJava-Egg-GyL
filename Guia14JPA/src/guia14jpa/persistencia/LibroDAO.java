// Esta clase hereda de la clase padre DAO y vemos que
// se especifica la generalización (<T>) como Libro
// esto permite que los métodos heredados donde se solicita
// una parámetro T, en esta clase serán de tipo Libro

package guia14jpa.persistencia;

import guia14jpa.entidades.Libro;
import java.util.List;

public final class LibroDAO extends DAO<Libro>{

    @Override
    public void guardar(Libro libro) {
        try {
            if(libro == null){
                throw new Exception("Debe indicar el Libro, no puede ser vacio");
            }else{
                super.guardar(libro);
            }
        } catch (Exception e) {
            System.out.println("Error: no se pudo modificar");
        }
    }
    
    @Override
    public void modificar(Libro libro) {
        try {
            if(libro == null){
                throw new Exception("Debe indicar el Libro, no puede ser vacio");
            }else{
                super.modificar(libro);
            } 
        } catch (Exception e) {
            System.out.println("Error: no se pudo guardar");
        }   
    }
   
    public void eliminar(Long isbn){
        try {
            Libro libro = buscarPorIsbn(isbn);
            super.eliminar(libro);
            
        } catch (Exception e) {
            System.out.println("Error: no se pudo eliminar");
        }   
    }
    
    public Libro buscarPorIsbn(Long isbn){
        
        try {
            conectar();
        
            //Utilizo esta forma mas práctica para buscar por PK
        
            Libro libro = em.find(Libro.class, isbn);
        
            // Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.isbn LIKE : isbn").
            //            setParameter("isbn", isbn).getSingleResult();
        
            desconectar();
        
            return libro;
            
        } catch (Exception e) {
            System.out.println("Error: No se encontró el libro");
            return null;
        }  
    }
    
    public Libro buscarPorTitulo(String titulo){
        
        try {
            conectar();
        
            Libro libro = (Libro) em.createQuery("SELECT l FROM Libro l WHERE l.titulo LIKE :titulo").
                setParameter("titulo", titulo).getSingleResult();
        
            desconectar();
            
            return libro;
            
        } catch (Exception e) {
            
            System.out.println("Error: No se encontró el libro");
            return null;
        }
    }
    
    public List<Libro> listarTodos(){
        
        try {
            conectar();
        
            List<Libro> libros = em.createQuery("SELECT l FROM Libro l").getResultList();
        
            desconectar();
        
            return libros;
            
        } catch (Exception e) {
            System.out.println("Error: No se pudo listar");
            return null;
        }
        
    }
    
    public List<Libro> buscarPorAutor(String autor){
        
        try {
            conectar();
        
            List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.autor.nombre LIKE :autor").
                setParameter("autor", autor).getResultList();
        
            desconectar();
        
            return libros;
            
        } catch (Exception e) {
            System.out.println("Error: No se pudo listar");
            return null;
        }  
    }
    
    public List<Libro> buscarPorEditorial(String editorial){
        
        try {
            conectar();
        
            List<Libro> libros = em.createQuery("SELECT l FROM Libro l WHERE l.editorial.nombre LIKE :editorial").
                setParameter("editorial", editorial).getResultList();
        
            desconectar();
        
            return libros;
            
        } catch (Exception e) {
            System.out.println("Error: No se pudo listar");
            return null;
        }
        
    }
}
