package com.tienda.misiontic.service;

import java.util.Optional;

import com.tienda.misiontic.model.DetalleVenta;

public interface DetalleVentaService {
	
	public Iterable<DetalleVenta> findAll();
	
	public Optional<DetalleVenta> findById(long codigo_detalle_venta);
	
	public DetalleVenta save(DetalleVenta detventa);
	
	public void delete(long codigo_detalle_venta);
}
