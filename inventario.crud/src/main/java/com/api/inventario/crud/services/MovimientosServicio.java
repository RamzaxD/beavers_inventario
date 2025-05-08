package com.api.inventario.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventario.crud.dto.MovimientosDTO;
import com.api.inventario.crud.models.UsuariosModelo;
import com.api.inventario.crud.models.MovimientosModelo;
import com.api.inventario.crud.models.ProductosModelo;
import com.api.inventario.crud.repositories.IUsuariosRepositorio;
import com.api.inventario.crud.repositories.IMovimientosRepositorio;
import com.api.inventario.crud.repositories.IProductosRepositorio;

@Service
public class MovimientosServicio {
    
    @Autowired
    IMovimientosRepositorio MovimientosRepositorio;


    @Autowired
    IProductosRepositorio productosRepositorio;

    @Autowired
    IUsuariosRepositorio usuariosRepositorio;

    public ArrayList<MovimientosModelo> getMovimientosModelos(){
        return (ArrayList<MovimientosModelo>) MovimientosRepositorio.findAll();
    }

    public MovimientosModelo postmovimiento(MovimientosModelo MovimientosModelo){
        return MovimientosRepositorio.save(MovimientosModelo);
    }

    public MovimientosModelo guardarmovimientoDesdeDTO(MovimientosDTO movimientoDTO) {
        
        

        // Buscar el rol
        ProductosModelo producto = productosRepositorio.findById(movimientoDTO.getIdProducto())
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        

        // Buscar el rol
        UsuariosModelo usuario = usuariosRepositorio.findById(movimientoDTO.getIdUsuario())
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Crear nuevo movimiento
        MovimientosModelo movimiento = new MovimientosModelo();
        movimiento.setCantidad(movimientoDTO.getCantidad());
        movimiento.setFechaHora(movimientoDTO.getFechaHora());
        movimiento.setProducto(producto);
        movimiento.setUsuario(usuario);
        
        return MovimientosRepositorio.save(movimiento);
    }

    public Optional<MovimientosModelo> getById(Long id){
        return MovimientosRepositorio.findById(id);
    }

    
}
