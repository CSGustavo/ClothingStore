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

import com.tienda.misiontic.model.Proveedor;
import com.tienda.misiontic.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedor")
public class ProveedorController {
	
	@Autowired
	private ProveedorService proveedorservice;
	
	//Crear un nuevo proveedor
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Proveedor proveedor){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorservice.save(proveedor));
	}
	
	// Buscar proveedor por NIT
	@GetMapping("/{nitproveedor}")
	public ResponseEntity<?> read(@PathVariable(value = "nitproveedor") long nitproveedor) {
		
		Optional<Proveedor> uproveedor = proveedorservice.findById(nitproveedor);
		
		if(!uproveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(uproveedor);
	}
	
	// Actualizar un proveedor
	@PutMapping("/{nitproveedor}")
	public ResponseEntity<?> update(@RequestBody Proveedor proveedorDetails, @PathVariable(value = "nitproveedor") long nitproveedor) {
		
		Optional<Proveedor> iproveedor = proveedorservice.findById(nitproveedor);
		
		if(!iproveedor.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		iproveedor.get().setNitproveedor(proveedorDetails.getNitproveedor());
		iproveedor.get().setCiudad_proveedor(proveedorDetails.getCiudad_proveedor());
		iproveedor.get().setDireccion_proveedor(proveedorDetails.getCiudad_proveedor());
		iproveedor.get().setNombre_proveedor(proveedorDetails.getNombre_proveedor());
		iproveedor.get().setTelefono_proveedor(proveedorDetails.getTelefono_proveedor());

		return ResponseEntity.status(HttpStatus.CREATED).body(proveedorservice.save(iproveedor.get()));
	}
	
	// Borrar proveedor
	@DeleteMapping("/{nitproveedor}")
	public ResponseEntity<?> delete(@PathVariable(value = "nitproveedor") long nitproveedor) {
		if(!proveedorservice.findById(nitproveedor).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		proveedorservice.delete(nitproveedor);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping 
	public List<Proveedor> readAll() {
		
		List<Proveedor> proveedor = StreamSupport.stream(proveedorservice.findAll().spliterator(), false).collect(Collectors.toList());
		
		return proveedor;
	}
}
