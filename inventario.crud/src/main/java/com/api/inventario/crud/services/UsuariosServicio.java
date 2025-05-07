package com.api.inventario.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventario.crud.dto.UsuariosDTO;
import com.api.inventario.crud.models.RolesModelo;
import com.api.inventario.crud.models.UsuariosModelo;
import com.api.inventario.crud.repositories.IRolesRepositorio;
import com.api.inventario.crud.repositories.IUsuariosRepositorio;

@Service
public class UsuariosServicio {
    
    @Autowired
    IUsuariosRepositorio usuariosRepositorio;

    @Autowired
    IRolesRepositorio rolesRepositorio;

    public ArrayList<UsuariosModelo> getUsuariosModelos(){
        return (ArrayList<UsuariosModelo>) usuariosRepositorio.findAll();
    }

    // public UsuariosModelo postUsuario(UsuariosModelo usuariosModelo){
    //     return usuariosRepositorio.save(usuariosModelo);
    // }

    public UsuariosModelo guardarUsuarioDesdeDTO(UsuariosDTO usuarioDTO) {
        // Buscar el rol
        RolesModelo rol = rolesRepositorio.findById(usuarioDTO.getIdRol())
            .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        
        // Crear nuevo usuario
        UsuariosModelo usuario = new UsuariosModelo();
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setCorreo(usuarioDTO.getCorreo());
        usuario.setContrasena(usuarioDTO.getContrasena());
        usuario.setRol(rol);
        usuario.setEstatus(usuarioDTO.getEstatus());
        
        return usuariosRepositorio.save(usuario);
    }

    public Optional<UsuariosModelo> getById(Long id){
        return usuariosRepositorio.findById(id);
    }

    public UsuariosModelo updateUsuario(UsuariosModelo request, Long id){
        UsuariosModelo usuario = usuariosRepositorio.findById(id).get();
        usuario.setNombre(request.getNombre());
        usuario.setCorreo(request.getCorreo());
        usuario.setEstatus(request.getEstatus());
        usuario.setRol(request.getRol());

        return usuario;
    }
}
