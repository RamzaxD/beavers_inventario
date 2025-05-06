package com.api.inventario.crud.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.inventario.crud.models.UsuariosModelo;
import com.api.inventario.crud.services.UsuariosServicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/users") //Fijando ruta de usarios
public class UsuariosControlador {
    
    @Autowired
    private UsuariosServicio usersServicio;
   
    //@GetMapping("/getusers") generaria: ruta princiapal/users/getusers 
    @GetMapping() //ruta principal/users
    public ArrayList<UsuariosModelo> getUsuariosModelos(){
        return this.usersServicio.getUsuariosModelos();
    }
    
    @PostMapping()
    public UsuariosModelo guardarUsuario(@RequestBody UsuariosModelo usuario ){
        return this.usersServicio.postUsuario(usuario);
    }
  
    @GetMapping(path = "/{id}")
    public Optional<UsuariosModelo> getById(@PathVariable("id") Long id) {
        return this.usersServicio.getById(id);
    }

    @PutMapping(path = "/{id}")
    public UsuariosModelo updateUsuario(@PathVariable("id") Long id, @RequestBody UsuariosModelo request) {
    return this.usersServicio.updateUsuario(request, id);
}
    
}
