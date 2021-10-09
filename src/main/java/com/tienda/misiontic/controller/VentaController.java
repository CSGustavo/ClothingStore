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

import com.tienda.misiontic.model.Venta;
import com.tienda.misiontic.service.VentaService;

@RestController
@RequestMapping("/api/venta")
public class VentaController {
	
	@Autowired
	private VentaService ventaservice;
	
	//Crear una nueva venta
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Venta venta){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaservice.save(venta));
	}
	
	// Buscar cliente por codigo detalle de venta
	@GetMapping("/{codigo_venta}")
	public ResponseEntity<?> read(@PathVariable(value = "codigo_venta") long codigo_venta) {
		
		Optional<Venta> uventa = ventaservice.findById(codigo_venta);
		
		if(!uventa.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(uventa);
	}
	
	// Actualizar una venta
	@PutMapping("/{codigo_venta}")
	public ResponseEntity<?> update(@RequestBody Venta ventaDetails, @PathVariable(value = "codigo_venta") long codigo_venta) {
		
		Optional<Venta> iventa = ventaservice.findById(codigo_venta);
		
		if(!iventa.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		iventa.get().setCodigo_venta(ventaDetails.getCodigo_venta());
		iventa.get().setCedula_cliente(ventaDetails.getCedula_cliente());
		iventa.get().setCedula_usuario(ventaDetails.getCedula_usuario());
		iventa.get().setIvaventa(ventaDetails.getIvaventa());
		iventa.get().setTotal_venta(ventaDetails.getTotal_venta());
		iventa.get().setValor_venta(ventaDetails.getValor_venta());
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(ventaservice.save(iventa.get()));
	}
	
	// Borrar venta
	@DeleteMapping("/{codigo_venta}")
	public ResponseEntity<?> delete(@PathVariable(value = "codigo_venta") long codigo_venta) {
		if(!ventaservice.findById(codigo_venta).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		ventaservice.delete(codigo_venta);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping 
	public List<Venta> readAll() {
		
		List<Venta> detventa = StreamSupport.stream(ventaservice.findAll().spliterator(), false).collect(Collectors.toList());
		
		return detventa;
	}

}
