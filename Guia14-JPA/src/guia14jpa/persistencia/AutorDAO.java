// Esta clase hereda de la clase padre DAO y vemos que
// se especifica la generalización (<T>) como Autor
// esto permite que los métodos heredados donde se solicita
// una parámetro T, en esta clase serán de tipo Autor

package guia14jpa.persistencia;

import guia14jpa.entidades.Autor;
import java.util.List;

public final class AutorDAO extends DAO<Autor>{

    @Override
    public void guardar(Autor autor) {
        
        try {
            if(autor == null){
                throw new Exception("Debe indicar el Autor, no puede ser vacio");
            }else{
                super.guardar(autor);
            }
        } catch (Exception e) {
            System.out.println("Error: no se pudo guardar");
        }
    }

    @Override
    public void modificar(Autor autor) {
        
        try {
            if(autor == null){
                throw new Exception("Debe indicar el Autor");
            }else{
                super.modificar(autor);
            }
        } catch (Exception e) {
            System.out.println("Error: no se pudo modificar");
        } 
    }

    
    public void eliminar(String nombre) {
        
        try {
            Autor autor = buscarPorNombre(nombre);
            super.eliminar(autor);
            
        } catch (Exception e) {
            System.out.println("Error: no se pudo eliminar");
        }
    }
    
    public Autor buscarPorNombre(String nombre){
        try {
            conectar();
        
            Autor autor = (Autor) em.createQuery("SELECT a FROM Autor a WHERE a.nombre LIKE :nombre")
                .setParameter("nombre", nombre).getSingleResult();
        
        
            desconectar();
            
            return autor;
            
        } catch (Exception e) {
            System.out.println("Error: No se pudo encontrar el Autor");
            return null;
        }
        
    }
    
    public List<Autor> listarTodos(){
        
        try {
            conectar();
        
            List<Autor> autores = em.createQuery("SELECT a FROM Autor a WHERE a.alta = true").getResultList();
        
            desconectar();
        
            return autores;
            
        } catch (Exception e) {
            System.out.println("Error: No se pudo listar los Autores");
            return null;
        }
        
    }
    
    
}
