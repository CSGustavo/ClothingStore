package com.tienda.misiontic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.misiontic.model.Usuario;

@Repository
public interface UsuarioDAO  extends JpaRepository<Usuario, Long> {

}
