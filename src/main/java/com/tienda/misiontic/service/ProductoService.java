package com.tienda.misiontic.service;

import java.util.Optional;

import com.tienda.misiontic.model.Producto;

public interface ProductoService {
	public Iterable<Producto> findAll();
	
	public Optional<Producto> findById(long codigo_producto);
	
	public Producto save(Producto producto);
	
	public void delete(long codigo_producto);
}
