package com.queledoy.queledoy_backend.security;
 
import com.queledoy.queledoy_backend.model.Usuario;
import com.queledoy.queledoy_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 
import java.util.Collection;
import java.util.Collections;
 
@Service
public class CustomUserDetailsService implements UserDetailsService {
 
    @Autowired
    private UsuarioRepository usuarioRepository;
 
    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado con el correo: " + correo));
 
        // El rol de tu modelo 'Usuario' se convierte en una 'GrantedAuthority'
        GrantedAuthority authority = new SimpleGrantedAuthority(usuario.getRol().getNombre());
 
        return new User(usuario.getCorreo(), usuario.getContrasena(), Collections.singleton(authority));
    }
}