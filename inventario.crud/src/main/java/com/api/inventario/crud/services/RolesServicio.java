package com.api.inventario.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventario.crud.models.RolesModelo;
import com.api.inventario.crud.repositories.IRolesRepositorio;

@Service
public class RolesServicio {
    
    @Autowired
    IRolesRepositorio RolesRepositorio;

    public ArrayList<RolesModelo> getRolesModelos(){
        return (ArrayList<RolesModelo>) RolesRepositorio.findAll();
    }

    public RolesModelo postUsuario(RolesModelo RolesModelo){
        return RolesRepositorio.save(RolesModelo);
    }

    public Optional<RolesModelo> getById(Long idRol){
        return RolesRepositorio.findById(idRol);
    }

    public RolesModelo updateRol(RolesModelo request, Long idRol){
        RolesModelo rol = RolesRepositorio.findById(idRol).get();
        rol.setNombreRol(request.getNombreRol());
        rol.setDescripcion(request.getDescripcion());

        return rol;
    }
}
