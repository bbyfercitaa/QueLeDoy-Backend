package com.queledoy.queledoy_backend.service;

import com.queledoy.queledoy_backend.model.Usuario;
import com.queledoy.queledoy_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    public Usuario obtenerPorId(Integer id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    public Usuario obtenerPorCorreo(String correo) {
        return usuarioRepository.findByCorreo(correo).orElse(null);
    }

    public Usuario obtenerPorNombre(String nombre) {
        return usuarioRepository.findByNombre(nombre).orElse(null);
    }

    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Usuario actualizar(Integer id, Usuario usuario) {
        Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
        if (usuarioExistente != null) {
            usuarioExistente.setNombre(usuario.getNombre());
            usuarioExistente.setCorreo(usuario.getCorreo());
            usuarioExistente.setContrasena(usuario.getContrasena());
            usuarioExistente.setRol(usuario.getRol());
            usuarioExistente.setActivo(usuario.getActivo());
            usuarioExistente.setFechaRegistro(usuario.getFechaRegistro());
            usuarioExistente.setLista(usuario.getLista());

            return usuarioRepository.save(usuarioExistente);
        } else {
            return null;
        }
    }
    
    public void eliminar(Integer id) {
        usuarioRepository.deleteById(id);
    }

    public Usuario editUsuario(Integer id, Usuario usuario) {
    Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
    if (usuarioExistente != null) {
        if (usuarioExistente.getNombre()!= null)usuarioExistente.setNombre(usuario.getNombre());
        if (usuarioExistente.getCorreo() != null)usuarioExistente.setCorreo(usuario.getCorreo());
        if (usuarioExistente.getContrasena() != null)usuarioExistente.setContrasena(usuario.getContrasena());
        if (usuarioExistente.getRol() != null)usuarioExistente.setRol(usuario.getRol());
        if (usuarioExistente.getActivo() != null)usuarioExistente.setActivo(usuario.getActivo());
        if (usuarioExistente.getFechaRegistro() != null)usuarioExistente.setFechaRegistro(usuario.getFechaRegistro());
        if (usuarioExistente.getLista() != null)usuarioExistente.setLista(usuario.getLista());
        return usuarioRepository.save(usuarioExistente);
    }else{
        return null; 
    }
}

    public boolean existe(Integer id) {
        return usuarioRepository.existsById(id);
    }
}
