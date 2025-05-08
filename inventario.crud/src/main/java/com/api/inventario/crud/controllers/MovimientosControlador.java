package com.api.inventario.crud.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.inventario.crud.models.MovimientosModelo;
import com.api.inventario.crud.services.MovimientosServicio;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/movimientos") //Fijando ruta de usarios
public class MovimientosControlador {
    
    @Autowired
    private MovimientosServicio MovimientosServicio;
   
    //@GetMapping("/getMovimientos") generaria: ruta princiapal/Movimientos/getMovimientos 
    @GetMapping() //ruta principal/Movimientos
    public ArrayList<MovimientosModelo> getMovimientosModelos(){
        return this.MovimientosServicio.getMovimientosModelos();
    }
    
    @PostMapping()
    public MovimientosModelo guardarMovimiento(@RequestBody MovimientosModelo idMovimiento ){
        return this.MovimientosServicio.postmovimiento(idMovimiento);
    }
  
    @GetMapping(path = "/{idMovimiento}")
    public Optional<MovimientosModelo> getById(@PathVariable("idMovimiento") Long idMovimiento) {
        return this.MovimientosServicio.getById(idMovimiento);
    }


    
}
