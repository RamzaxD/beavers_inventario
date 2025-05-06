package com.api.inventario.crud.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

// Entidad genera una columna por cada fila
// Table asigna el nombre de la tabla a crear en la base de datos

@Entity
@Table(name = "usuarios")
public class UsuariosModelo {
    //Generar el id automatico
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    //name:     Asigna el nombre de la columna, sino se coloca en automatico pone el nombre de la variable
    //length:   Asigna el tamaño maximo del dato
    //nullable: Asigna si es obligatorio llenar el campo
    @Column(name = "nombre", length = 100, nullable = false) 
    private String nombre;

    @Column(length = 50, nullable = false, unique = true)
    private String correo;

    @Column(length = 25, nullable = false)
    private String contrasena;

    @ManyToOne
    @JoinColumn(name = "idRol", nullable = false)
    private RolesModelo idRol;

    @Column(nullable = false)
    private Boolean estatus;

    //Constructor
    public UsuariosModelo(){}

    //getters y setters

    //ID del Usuario
    public Long getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsario(Long idUsuario){
        this.idUsuario = idUsuario;
    }
    
    //Nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Correo
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //Contrasena
    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    //id Rol
    public RolesModelo getRol() {
        return idRol;
    }

    public void setRol(RolesModelo idRol) {
        this.idRol = idRol;
    }

    //Perfil Activo o Inactivo
    public Boolean getEstatus() {
        return estatus;
    }

    public void setEstatus(Boolean estatus) {
        this.estatus = estatus;
    }


}
