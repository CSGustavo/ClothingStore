package com.tienda.misiontic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.misiontic.dao.ClienteDAO;
import com.tienda.misiontic.model.Cliente;

@Service
public class ClienteServiceImpl implements ClienteService{
	
	@Autowired
	private ClienteDAO clientedao;
	
	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return clientedao.save(cliente);
	}

	@Override
	public void delete(long cedula_cliente) {
		clientedao.deleteById(cedula_cliente); ;
	}

	@Override
	public Iterable<Cliente> findAll() {
		// TODO Auto-generated method stub
		return clientedao.findAll();
	}

	@Override
	public Optional<Cliente> findById(long cedula_cliente) {
		// TODO Auto-generated method stub
		return clientedao.findById(cedula_cliente);
	}
	
}
