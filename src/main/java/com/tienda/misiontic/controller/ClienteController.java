package com.tienda.misiontic.controller;

import java.util.List;
import java.util.Optional;
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

import com.tienda.misiontic.model.Cliente;
import com.tienda.misiontic.service.ClienteService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteservice;
	
	//Crear un nuevo cliente
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Cliente cliente){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteservice.save(cliente));
	}
	
	// Buscar cliente por id
	@GetMapping("/{cedula_cliente}")
	public ResponseEntity<?> read(@PathVariable(value = "cedula_cliente") long cedula_cliente) {
		
		Optional<Cliente> ucliente = clienteservice.findById(cedula_cliente);
		
		if(!ucliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(ucliente);
	}
	
	// Actualizar un cliente 
	@PutMapping("/{cedula_cliente}")
	public ResponseEntity<?> update(@RequestBody Cliente clienteDetails, @PathVariable(value = "cedula_cliente") long cedula_cliente) {
		
		Optional<Cliente> icliente = clienteservice.findById(cedula_cliente);
		
		if(!icliente.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		icliente.get().setCedula_cliente(clienteDetails.getCedula_cliente());
		icliente.get().setEmail_cliente(clienteDetails.getEmail_cliente());
		icliente.get().setDireccion(clienteDetails.getDireccion());
		icliente.get().setNombre_completo(clienteDetails.getNombre_completo());
		icliente.get().setTelefono(clienteDetails.getTelefono());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteservice.save(icliente.get()));
	}
	
	// Borrar cliente
	@DeleteMapping("/{cedula_cliente}")
	public ResponseEntity<?> delete(@PathVariable(value = "cedula_cliente") long cedula_cliente) {
		if(!clienteservice.findById(cedula_cliente).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		clienteservice.delete(cedula_cliente);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping 
	public List<Cliente> readAll() {
		
		List<Cliente> cliente = StreamSupport.stream(clienteservice.findAll().spliterator(), false).collect(Collectors.toList());
		
		return cliente;
	}
}
