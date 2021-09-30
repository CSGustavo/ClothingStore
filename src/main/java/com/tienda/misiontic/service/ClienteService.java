package com.tienda.misiontic.service;

import java.util.Optional;

import com.tienda.misiontic.model.Cliente;

public interface ClienteService {
	
	public Iterable<Cliente> findAll();
	
	public Optional<Cliente> findById(long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(long id);
}
