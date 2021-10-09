package com.tienda.misiontic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.misiontic.dao.VentaDAO;
import com.tienda.misiontic.model.Venta;

@Service
public class VentaServiceImpl implements VentaService {
	
	@Autowired
	private VentaDAO ventadao;
	
	@Override
	public Iterable<Venta> findAll() {
		// TODO Auto-generated method stub
		return ventadao.findAll();
	}

	@Override
	public Optional<Venta> findById(long codigo_venta) {
		// TODO Auto-generated method stub
		return ventadao.findById(codigo_venta);
	}

	@Override
	public Venta save(Venta venta) {
		// TODO Auto-generated method stub
		return ventadao.save(venta);
	}

	@Override
	public void delete(long codigo_venta) {
		ventadao.deleteById(codigo_venta);		
	}

}
