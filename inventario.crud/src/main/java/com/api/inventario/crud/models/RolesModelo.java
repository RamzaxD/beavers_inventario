package com.api.inventario.crud.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class RolesModelo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRol")
    private Long idRol;

    @Column(length = 50, nullable = false)
    private String nombreRol;

    @Column(length = 100)
    private String descripcion;


    public RolesModelo() {
    }

    //Id del Rol
    public Long getIdRol() {
        return idRol;
    }

    public void setIdRol(Long idRol) {
        this.idRol = idRol;
    }

    //Nombre del Rol
    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    //Descipcion del Rol
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}