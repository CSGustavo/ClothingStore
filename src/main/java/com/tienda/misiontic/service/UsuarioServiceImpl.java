package com.tienda.misiontic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.misiontic.dao.UsuarioDAO;
import com.tienda.misiontic.model.Usuario;

@Service 
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioDAO usuariodao;
	
	@Override
	public Iterable<Usuario> findAll() {
		// TODO Auto-generated method stub
		return usuariodao.findAll();
	}

	@Override
	public Optional<Usuario> findById(long id) {
		// TODO Auto-generated method stub
		return usuariodao.findById(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuariodao.save(usuario);
	}

	@Override
	public void delete(long id) {
		usuariodao.deleteById(id);
	}

}
