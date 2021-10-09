package com.tienda.misiontic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tienda.misiontic.model.Producto;

@Repository
public interface ProductoDAO extends JpaRepository<Producto, Long> {

}
