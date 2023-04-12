package com.egg.sitionoticias.servicios;

import com.egg.sitionoticias.entidades.Imagen;
import com.egg.sitionoticias.entidades.Usuario;
import com.egg.sitionoticias.enumeraciones.Rol;
import com.egg.sitionoticias.excepciones.Excepcion;
import com.egg.sitionoticias.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UsuarioServicio implements UserDetailsService{
    
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;
    
    @Autowired
    private ImagenServicio imagenServicio;
    
    @Transactional
    public void registrar(String nombreUsuario, String email, String password, String password2, MultipartFile archivo) throws Excepcion{
        
        validarDatos(nombreUsuario, email, password, password2);
        
        Usuario usuario = new Usuario();
        
        usuario.setNombreUsuario(nombreUsuario);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Rol.USER);
        usuario.setFechaAlta(new Date());
        usuario.setActivo(true);
        
        Imagen imagen = imagenServicio.crearYGuardar(archivo);
        
        usuario.setImagen(imagen);
        
        usuarioRepositorio.save(usuario);
    }
    
    @Transactional
    public void actualizar(String idUsuario, String nombreUsuario, String email, String password, String password2, MultipartFile archivo) throws Excepcion{
        
        validarDatos(nombreUsuario, email, password, password2);
        
        Optional<Usuario> respuesta = usuarioRepositorio.findById(idUsuario);
        
        if(respuesta.isPresent()){
            
            Usuario usuario = respuesta.get();
            
            usuario.setNombreUsuario(nombreUsuario);
            usuario.setEmail(email);
            
            usuario.setPassword(new BCryptPasswordEncoder().encode(password));
            
            if (null == usuario.getRol()) {
                usuario.setRol(Rol.USER);
            } else switch (usuario.getRol()) {
                case ADMINISTRADOR:
                    usuario.setRol(Rol.ADMINISTRADOR);
                    break;
                case PERIODISTA:
                    usuario.setRol(Rol.PERIODISTA);
                    break;
                default:
                    usuario.setRol(Rol.USER);
                    break;
            }
            
            
            String idImagen = null;
            
            if(usuario.getImagen() != null){
                
                idImagen = usuario.getImagen().getId();
            }
            
            Imagen imagen = imagenServicio.actualizar(archivo, idImagen);
            
            usuarioRepositorio.save(usuario);
        }
        
    }
    
    public Usuario geOne(String id){
        
        return usuarioRepositorio.getOne(id);
    }
    
    @Transactional
    public void cambiarRol(String id) {
        Optional<Usuario> respuesta = usuarioRepositorio.findById(id);

        if (respuesta.isPresent()) {

            Usuario usuario = respuesta.get();

            if (usuario.getRol().equals(Rol.USER)) {

                usuario.setRol(Rol.ADMINISTRADOR);

            } else if (usuario.getRol().equals(Rol.ADMINISTRADOR)) {
                usuario.setRol(Rol.USER);
            }
        }
    }
    
    private void validarDatos(String nombreUsuario, String email, String password, String password2) throws Excepcion{
        
        if(nombreUsuario.isEmpty() || nombreUsuario == null){
            throw new Excepcion("El nombre de usuario no puede ser nulo o estar vacío");
        }
        if(email.isEmpty() || email == null){
            throw new Excepcion("El email no puede ser nulo o estar vacío");
        }
        if(password.isEmpty() || password == null || password.length() <= 5){
            throw new Excepcion("La contraseña no puede estar vacía y debe tener mas de 5 dígitos");
            
        }
        if(!password.equals(password2)){
            throw new Excepcion("Las contraseñas deben coincidir");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        
        Usuario usuario = usuarioRepositorio.buscarPorEmail(email);
        
        if(usuario != null){
            
            List<GrantedAuthority> permisos = new ArrayList<>();
            
            
            /* Otorgamos permisos segun el rol y luego agregamos a la lista de permisos*/
            
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString());
            
            permisos.add(p);
            
            /*Utilizamos los atributos que nos otorga el pedido al servlet, 
                para poder guardar la información de nuestra HttpSession.*/
            
            ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
            
            HttpSession session = attr.getRequest().getSession(true);
            
            session.setAttribute("usuariosession", usuario);
            
            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        }else{
            return null;
        }
    }
}
