package com.tienda.misiontic.service;

import java.util.Optional;

import com.tienda.misiontic.model.Proveedor;

public interface ProveedorService {
	
	public Iterable<Proveedor> findAll();
	
	public Optional<Proveedor> findById(long nitproveedor);
	
	public Proveedor save(Proveedor proveedor);
	
	public void delete(long nitproveedor);
}
