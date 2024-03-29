package com.tienda.misiontic.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.misiontic.dao.ProveedorDAO;
import com.tienda.misiontic.model.Proveedor;

@Service
public class ProveedorServiceImpl implements ProveedorService {
	
	@Autowired
	private ProveedorDAO proveedordao;

	@Override
	public Iterable<Proveedor> findAll() {
		// TODO Auto-generated method stub
		return proveedordao.findAll();
	}

	@Override
	public Optional<Proveedor> findById(long nitproveedor) {
		// TODO Auto-generated method stub
		return proveedordao.findById(nitproveedor);
	}

	@Override
	public Proveedor save(Proveedor proveedor) {
		// TODO Auto-generated method stub
		return proveedordao.save(proveedor);
	}

	@Override
	public void delete(long nitproveedor) {
		proveedordao.deleteById(nitproveedor);
		
	}
	
}
