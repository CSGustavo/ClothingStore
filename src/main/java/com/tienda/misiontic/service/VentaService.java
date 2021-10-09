package com.tienda.misiontic.service;

import java.util.Optional;

import com.tienda.misiontic.model.Venta;

public interface VentaService {
	
	public Iterable<Venta> findAll();
	
	public Optional<Venta> findById(long codigo_venta);
	
	public Venta save(Venta venta);
	
	public void delete(long codigo_venta);
}
