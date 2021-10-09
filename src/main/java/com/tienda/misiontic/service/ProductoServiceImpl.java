package com.tienda.misiontic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.misiontic.dao.ProductoDAO;
import com.tienda.misiontic.model.Producto;

@Service
public class ProductoServiceImpl implements ProductoService {

	@Autowired
	private ProductoDAO productodao;
	
	@Override
	public Iterable<Producto> findAll() {
		// TODO Auto-generated method stub
		return productodao.findAll();
	}

	@Override
	public Optional<Producto> findById(long codigo_producto) {
		// TODO Auto-generated method stub
		return productodao.findById(codigo_producto);
	}

	@Override
	public Producto save(Producto producto) {
		// TODO Auto-generated method stub
		return productodao.save(producto);
	}

	@Override
	public void delete(long codigo_producto) {
		productodao.deleteById(codigo_producto);
		
	}
	
}
