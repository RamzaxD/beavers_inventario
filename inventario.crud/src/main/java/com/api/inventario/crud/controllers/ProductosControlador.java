package com.api.inventario.crud.controllers;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import com.api.inventario.crud.dto.ProductosDTO;
import com.api.inventario.crud.models.ProductosModelo;
import com.api.inventario.crud.services.ProductosServicio;


@RestController
@RequestMapping("/productos") //Fijando ruta de usarios
public class ProductosControlador {
      @Autowired
    private ProductosServicio ProductosServicio;
   
    //@GetMapping("/getProductos") generaria: ruta princiapal/Productos/getProductos 
    @GetMapping() //ruta principal/Productos
    public ArrayList<ProductosModelo> getProductosModelos(){
        return this.ProductosServicio.getProductosModelos();
    }
    
    @PostMapping()
    public ProductosModelo guardarProducto(@RequestBody ProductosModelo Producto ){
        return this.ProductosServicio.postUsuario(Producto);
    }
  
    @GetMapping(path = "/{idProducto}")
    public Optional<ProductosModelo> getById(@PathVariable("idProducto") Long idProducto) {
        return this.ProductosServicio.getById(idProducto);
    }

    // @PutMapping(path = "/{idProducto}")
    // public ProductosModelo updateProducto(@PathVariable("idProducto") Long idProducto, @RequestBody ProductosModelo request) {
    // return this.ProductosServicio.updateProducto(request, idProducto);
    // }
    @PutMapping(path = "/{idProducto}")
    public ResponseEntity<?> updateProducto(
        @PathVariable("idProducto") Long idProducto,
        @Valid @RequestBody ProductosDTO updateDTO) {
    try {
        ProductosModelo productoActualizado = ProductosServicio.actualizarProducto(idProducto, updateDTO);
        return ResponseEntity.ok(productoActualizado);
    } catch (RuntimeException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
    }
}
