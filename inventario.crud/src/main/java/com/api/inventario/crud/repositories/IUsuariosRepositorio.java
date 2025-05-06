//Repositorios son utilizados para hacer querys a la DB

package com.api.inventario.crud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.inventario.crud.models.UsuariosModelo;

@Repository
public interface IUsuariosRepositorio extends JpaRepository<UsuariosModelo, Long>{

    
}