package com.tienda.misiontic.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.misiontic.dao.DetalleVentaDAO;
import com.tienda.misiontic.model.DetalleVenta;

@Service
public class DetalleVentaServiceImpl implements DetalleVentaService {

	@Autowired
	private DetalleVentaDAO detventadao;
	
	@Override
	public Iterable<DetalleVenta> findAll() {
		// TODO Auto-generated method stub
		return detventadao.findAll();
	}

	@Override
	public Optional<DetalleVenta> findById(long codigo_detalle_venta) {
		// TODO Auto-generated method stub
		return detventadao.findById(codigo_detalle_venta);
	}

	@Override
	public DetalleVenta save(DetalleVenta detventa) {
		// TODO Auto-generated method stub
		return detventadao.save(detventa);
	}

	@Override
	public void delete(long codigo_detalle_venta) {
		detventadao.deleteById(codigo_detalle_venta);
		
	}

}
