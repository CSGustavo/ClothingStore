package com.tienda.misiontic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tienda.misiontic.model.Venta;

@Repository
public interface VentaDAO extends JpaRepository<Venta, Long> {

}
