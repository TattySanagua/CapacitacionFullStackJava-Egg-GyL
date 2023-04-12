package com.egg.sitionoticias.repositorios;

import com.egg.sitionoticias.entidades.Noticia;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepositorio extends JpaRepository<Noticia, String>{
    
//    @Query("SELECT l FROM Noticias l WHERE l.titulo = :titulo")
//    public Noticia buscarPorTitulo(@Param("titulo") String titulo);
    
//    @Query("SELECT n FROM Noticias n WHERE n.fecha = :fecha")
//    public List<Noticia> buscarPorFecha(@Param("fecha") Date fecha);
}
