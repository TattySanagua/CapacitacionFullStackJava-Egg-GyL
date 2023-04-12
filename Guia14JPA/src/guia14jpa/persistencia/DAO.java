package guia14jpa.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Esta es una clase padre genérica. Que sea genérica nos permite
// instanciar esta clase para cualquier tipo de objeto. En línea 14
// vemos que <T> puede ser cualquier tipo de objeto: Integer, String, Libro
// Autor, etcétera.
// Esta clase padre nos permite heredar métodos comunes con el fin de reutilizar
// código.

public class DAO <T>{
    
    protected final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("Guia14JPAPU");
    protected EntityManager em = EMF.createEntityManager();
    
    // Este método nos permite conectar con la base de datos
    // se verifica si la conexión está realizada, en caso que
    // no esté realizada, se realiza en la línea 18.
    
    protected void conectar(){
        if(!em.isOpen()){
            em = EMF.createEntityManager();
        }
    }
    
    // Este método nos permite desconectarnos de la base de datos
    // Se verifica si existe una conexión, y de ser el caso, se
    // cierra la conexión y se desconecta el programa con la base de datos.
    
    protected void desconectar(){
        if(em.isOpen()){
            em.close();
        }
    }
    
    // Este método nos permite persistir un objeto en la base de datos.
    // Toma como parámetro el objeto a persistir, vemos que es genérico, por
    // lo que puede aceptar cualquier tipo de objeto (Libro, Autor, Editorial).
    
    protected void guardar(T objeto){
        conectar();
        
        em.getTransaction().begin();   //Inicia la transaccion
        em.persist(objeto);            //Persiste el objeto
        em.getTransaction().commit();  //Finaliza la transaccion
        
        desconectar();
    }
    
    // Este método nos permite modificar una tupla de una base de datos.
    // Recibe como parámetro el objeto con los datos cambiados (debe mantener
    // la misma llave primaria) y lo reemplaza por el anterior.
    
    protected void modificar(T objeto){
        conectar();
        
        em.getTransaction().begin();
        em.merge(objeto);
        em.getTransaction().commit();
        
        desconectar();
    }
    
    // Este método nos permite eliminar un registro de la base de datos.
    // Como parámetro se pasa el objeto a eliminar de la base de datos.
    // Se busca en la base de datos el registro que contenga la misma información
    // que el parámetro recibido, y se elimina.
    
    protected void eliminar(T objeto){ //No utilizo este método ya que trabajaré con baja lógica
        conectar();
        
        em.getTransaction().begin();
        em.remove(objeto);
        em.getTransaction().commit();
        
        desconectar();
    }
    
}
