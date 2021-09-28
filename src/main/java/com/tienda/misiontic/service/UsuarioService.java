package com.tienda.misiontic.service;

import java.util.Optional;

import com.tienda.misiontic.model.Usuario;

public interface UsuarioService {
public Iterable<Usuario> findAll();
	
	public Optional<Usuario> findById(long id);
	
	public Usuario save(Usuario usuario);
	
	public void delete(long id);
}
