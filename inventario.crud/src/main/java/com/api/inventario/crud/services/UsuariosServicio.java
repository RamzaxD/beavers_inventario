package com.api.inventario.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventario.crud.models.UsuariosModelo;
import com.api.inventario.crud.repositories.IUsuariosRepositorio;

@Service
public class UsuariosServicio {
    
    @Autowired
    IUsuariosRepositorio usuariosRepositorio;

    public ArrayList<UsuariosModelo> getUsuariosModelos(){
        return (ArrayList<UsuariosModelo>) usuariosRepositorio.findAll();
    }

    public UsuariosModelo postUsuario(UsuariosModelo usuariosModelo){
        return usuariosRepositorio.save(usuariosModelo);
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
