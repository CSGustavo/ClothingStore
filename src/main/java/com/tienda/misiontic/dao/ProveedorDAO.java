package com.tienda.misiontic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.misiontic.model.Proveedor;

@Repository
public interface ProveedorDAO extends JpaRepository<Proveedor, Long>{

}
