package com.tienda.misiontic.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.misiontic.model.DetalleVenta;
import com.tienda.misiontic.service.DetalleVentaService;

@RestController
@RequestMapping("/api/detalleventa")
public class DetalleVentaController {
	
	@Autowired
	private DetalleVentaService detventaservice;
	
	//Crear un nuevo detalle de venta
	@PostMapping
	public ResponseEntity<?> create(@RequestBody DetalleVenta detventa){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(detventaservice.save(detventa));
	}
	
	// Buscar cliente por codigo detalle de venta
	@GetMapping("/{codigo_detalle_venta}")
	public ResponseEntity<?> read(@PathVariable(value = "codigo_detalle_venta") long codigo_detalle_venta) {
		
		Optional<DetalleVenta> udetventa = detventaservice.findById(codigo_detalle_venta);
		
		if(!udetventa.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(udetventa);
	}
	
	// Actualizar un cliente 
	@PutMapping("/{codigo_detalle_venta}")
	public ResponseEntity<?> update(@RequestBody DetalleVenta detventaDetails, @PathVariable(value = "codigo_detalle_venta") long codigo_detalle_venta) {
		
		Optional<DetalleVenta> idetventa = detventaservice.findById(codigo_detalle_venta);
		
		if(!idetventa.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		idetventa.get().setCodigo_detalle_venta(detventaDetails.getCodigo_detalle_venta());
		idetventa.get().setCantidad_producto(detventaDetails.getCantidad_producto());
		idetventa.get().setCodigo_producto(detventaDetails.getCodigo_producto());
		idetventa.get().setCodigo_venta(detventaDetails.getCodigo_venta());
		idetventa.get().setValor_total(detventaDetails.getValor_total());
		idetventa.get().setValor_iva(detventaDetails.getValor_iva());
		idetventa.get().setValor_venta(detventaDetails.getValor_venta());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(detventaservice.save(idetventa.get()));
	}
	
	// Borrar cliente
	@DeleteMapping("/{codigo_detalle_venta}")
	public ResponseEntity<?> delete(@PathVariable(value = "codigo_detalle_venta") long codigo_detalle_venta) {
		if(!detventaservice.findById(codigo_detalle_venta).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		detventaservice.delete(codigo_detalle_venta);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping 
	public List<DetalleVenta> readAll() {
		
		List<DetalleVenta> detventa = StreamSupport.stream(detventaservice.findAll().spliterator(), false).collect(Collectors.toList());
		
		return detventa;
	}

}
