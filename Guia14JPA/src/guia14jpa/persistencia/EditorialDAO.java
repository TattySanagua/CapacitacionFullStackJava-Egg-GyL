// Esta clase hereda de la clase padre DAO y vemos que
// se especifica la generalización (<T>) como Editorial
// esto permite que los métodos heredados donde se solicita
// una parámetro T, en esta clase serán de tipo Editorial

package guia14jpa.persistencia;

import guia14jpa.entidades.Editorial;
import java.util.List;

public final class EditorialDAO extends DAO<Editorial>{

    @Override
    public void guardar(Editorial editorial) {
        try {
            if(editorial == null){
                throw new Exception("Debe indicar la Editorial, no puede ser vacio");
            }else{
                super.guardar(editorial);
            }
            
        } catch (Exception e) {
            System.out.println("Error: no se pudo guardar");
        }
        
    }

    @Override
    protected void modificar(Editorial editorial) {
        try {
            if(editorial == null){
                throw new Exception("Debe indicar la editorial");
            }else{
                super.modificar(editorial);
            }
        } catch (Exception e) {
            System.out.println("Error: no se pudo modificar");
        }
        
    }
    
    public void eliminar(String nombre){
         
        try {
            Editorial editorial = buscarPorNombre(nombre);
            super.eliminar(editorial);
            
        } catch (Exception e) {
            System.out.println("Error: no se pudo eliminar");
        }  
    }
    
    public Editorial buscarPorNombre(String nombre){
        try {
            conectar();
        
            Editorial editorial = (Editorial) em.createQuery("SELECT e FROM Editorial e WHERE e.nombre LIKE :nombre").
                                        setParameter("nombre", nombre).getSingleResult();
        
            desconectar();
        
            return editorial;
            
        } catch (Exception e) {
            System.out.println("Error: No se pudo encontrar la Editorial");
            return null;
        }
        
    }
    
    public List<Editorial> listarTodos(){
        
         try {
            conectar();
        
            List<Editorial> editoriales = em.createQuery("SELECT e FROM Editorial e").getResultList();
        
            desconectar();
        
            return editoriales;
            
        } catch (Exception e) {
            System.out.println("Error: No se pudo listar las Editoriales");
            return null;
        }
        
    }
}
