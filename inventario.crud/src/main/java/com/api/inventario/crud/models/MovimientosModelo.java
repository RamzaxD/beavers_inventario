package com.api.inventario.crud.models;


import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;


@Entity
@Table(name = "movimientos")
public class MovimientosModelo {
    //Generar el id automatico
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;

    @Column(name = "tipo") 
    private Boolean tipo;

    @Column(name = "cantidad")
    private Number cantidad;


     @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @PrePersist  // Se ejecuta antes de guardar en la BD
    public void prePersist() {
        this.fechaHora = LocalDateTime.now();  // Fecha y hora actual
    }

    @ManyToOne
    @JoinColumn(name = "id_producto", nullable = true)  // Must match DB column name
    private ProductosModelo producto;  // Renamed from idProducto for clarity

    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)  // Must match DB column name
    private UsuariosModelo usuario;    // Renamed from idUsuario for clarity


    //Constructor
    public MovimientosModelo(){}

    //getters y setters

    //ID del Movimiento
    public Long getIdMovimiento(){
        return idMovimiento;
    }

    public void setIidMovimiento(Long idMovimiento){
        this.idMovimiento = idMovimiento;
    }
    
    //
    public Number getcantidad() {
        return cantidad;
    }

    public void setCantidad(Number cantidad) {
        this.cantidad = cantidad;
    }

    //
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    
    //id Rol
    public UsuariosModelo getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuariosModelo usuario) {
        this.usuario = usuario;
    }

    //id Rol
    public ProductosModelo getProducto() {
        return producto;
    }

    public void setProducto(ProductosModelo producto) {
        this.producto = producto;
    }

   

}
