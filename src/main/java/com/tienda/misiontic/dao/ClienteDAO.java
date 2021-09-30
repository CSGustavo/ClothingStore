package com.tienda.misiontic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.misiontic.model.Cliente;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente, Long>{

}
