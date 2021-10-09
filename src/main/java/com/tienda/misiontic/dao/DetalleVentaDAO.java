package com.tienda.misiontic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.misiontic.model.DetalleVenta;

@Repository
public interface DetalleVentaDAO extends JpaRepository<DetalleVenta, Long> {

}
