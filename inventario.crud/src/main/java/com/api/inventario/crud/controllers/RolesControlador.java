package com.api.inventario.crud.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.inventario.crud.models.RolesModelo;
import com.api.inventario.crud.services.RolesServicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/roles") //Fijando ruta de usarios
public class RolesControlador {
    
    @Autowired
    private RolesServicio rolesServicio;
   
    //@GetMapping("/getroles") generaria: ruta princiapal/roles/getroles 
    @GetMapping() //ruta principal/roles
    public ArrayList<RolesModelo> getRolesModelos(){
        return this.rolesServicio.getRolesModelos();
    }
    
    @PostMapping()
    public RolesModelo guardarRol(@RequestBody RolesModelo rol ){
        return this.rolesServicio.postUsuario(rol);
    }
  
    @GetMapping(path = "/{id}")
    public Optional<RolesModelo> getById(@PathVariable("idRol") Long idRol) {
        return this.rolesServicio.getById(idRol);
    }

    @PutMapping(path = "/{id}")
    public RolesModelo updateRol(@PathVariable("idRol") Long idRol, @RequestBody RolesModelo request) {
    return this.rolesServicio.updateRol(request, idRol);
}
    
}
