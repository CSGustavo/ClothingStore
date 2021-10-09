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

import com.tienda.misiontic.model.Producto;
import com.tienda.misiontic.service.ProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	
	@Autowired
	private ProductoService productoservice;
	
	//Crear un nuevo producto
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Producto producto){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoservice.save(producto));
	}
	
	// Buscar producto por código
	@GetMapping("/{codigo_producto}")
	public ResponseEntity<?> read(@PathVariable(value = "codigo_producto") long codigo_producto) {
		
		Optional<Producto> uproducto = productoservice.findById(codigo_producto);
		
		if(!uproducto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(uproducto);
	}
	
	// Actualizar un producto
	@PutMapping("/{codigo_producto}")
	public ResponseEntity<?> update(@RequestBody Producto productoDetails, @PathVariable(value = "codigo_producto") long codigo_producto) {
		
		Optional<Producto> iproducto = productoservice.findById(codigo_producto);
		
		if(!iproducto.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		iproducto.get().setCodigo_producto(productoDetails.getCodigo_producto());
		iproducto.get().setIvacompra(productoDetails.getIvacompra());
		iproducto.get().setNitproveedor(productoDetails.getNitproveedor());
		iproducto.get().setNombre_producto(productoDetails.getNombre_producto());
		iproducto.get().setPrecio_compra(productoDetails.getPrecio_compra());
		iproducto.get().setPrecio_venta(productoDetails.getPrecio_venta());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(productoservice.save(iproducto.get()));
	}
	
	// Borrar proveedor
	@DeleteMapping("/{codigo_producto}")
	public ResponseEntity<?> delete(@PathVariable(value = "codigo_producto") long codigo_producto) {
		if(!productoservice.findById(codigo_producto).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		productoservice.delete(codigo_producto);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping 
	public List<Producto> readAll() {
		
		List<Producto> producto = StreamSupport.stream(productoservice.findAll().spliterator(), false).collect(Collectors.toList());
		
		return producto;
	}
}