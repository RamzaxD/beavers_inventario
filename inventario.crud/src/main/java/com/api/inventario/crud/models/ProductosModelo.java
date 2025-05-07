package com.api.inventario.crud.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
// idProducto:     string,
//     nombreProducto: string,
//     cantidad:       number,
//     estado:         boolean,


@Entity
@Table(name = "productos")
public class ProductosModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idProducto")
    private Long idProducto;

    @Column(length = 50, nullable = false)
    private String nombreProducto;

    @Column()
    private Number cantidad;

    @Column()
    private Boolean estado;


    public ProductosModelo() {
    }

    //Id del Producto
    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    //Nombre del Producto
    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    //Descipcion del Producto
    public Number getCantidad() {
        return cantidad;
    }

    public void setCantidad(Number cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstatado(Boolean estado) {
        this.estado = estado;
    }
}
