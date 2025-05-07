package com.api.inventario.crud.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.inventario.crud.dto.ProductosDTO;
import com.api.inventario.crud.models.ProductosModelo;
import com.api.inventario.crud.repositories.IProductosRepositorio;

@Service
public class ProductosServicio {
    @Autowired
    IProductosRepositorio ProductosRepositorio;



    public ArrayList<ProductosModelo> getProductosModelos(){
        return (ArrayList<ProductosModelo>) ProductosRepositorio.findAll();
    }

    public ProductosModelo postUsuario(ProductosModelo ProductosModelo){
        return ProductosRepositorio.save(ProductosModelo);
    }

    public Optional<ProductosModelo> getById(Long idProducto){
        return ProductosRepositorio.findById(idProducto);
    }

    // public ProductosModelo updateProducto(ProductosModelo request, Long idProducto){
    //     ProductosModelo Producto = ProductosRepositorio.findById(idProducto).get();
    //     Producto.setNombreProducto(request.getNombreProducto());
    //     Producto.setCantidad(request.getCantidad());
    //     Producto.setEstatado(request.getEstado());

    //     return Producto;
    // }
    public ProductosModelo actualizarProducto(Long idProducto, ProductosDTO updateDTO) {
        ProductosModelo productoExistente = ProductosRepositorio.findById(idProducto)
            .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    
        // Actualizar solo los campos permitidos
        if (updateDTO.getNombreProducto() != null) {
            productoExistente.setNombreProducto(updateDTO.getNombreProducto());
        }
        if (updateDTO.getCantidad() != null) {
            productoExistente.setCantidad(updateDTO.getCantidad());
        }
        if (updateDTO.getEstado() != null) {
            productoExistente.setEstatado(updateDTO.getEstado());
        }
    
        return ProductosRepositorio.save(productoExistente);
    }
}
