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

import com.tienda.misiontic.model.Usuario;
import com.tienda.misiontic.service.UsuarioService;

public class UsuarioController {
	@Autowired
	private UsuarioService usuarioservice;
	
	//Crear usuario
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioservice.save(usuario));
	}
	
	// Buscar usuario por Id
	@GetMapping("{/id}")
	public ResponseEntity<?> read(@PathVariable(value="id") long usuarioid) {
		Optional<Usuario> oUsuario = usuarioservice.findById(usuarioid);
		
		if(!oUsuario.isPresent()) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(oUsuario);
		}
	}
	
	// Actualizar usuario 
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Usuario usuarioDetails, @PathVariable(value = "id") long usuarioid) {
		
		Optional<Usuario> iusuario = usuarioservice.findById(usuarioid);
		
		if(!iusuario.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		iusuario.get().setCedula_usuario(usuarioDetails.getCedula_usuario());
		iusuario.get().setEmail_usuario(usuarioDetails.getEmail_usuario());
		iusuario.get().setNombre_usuario(usuarioDetails.getNombre_usuario());
		iusuario.get().setPassword(usuarioDetails.getPassword());
		iusuario.get().setUsuario(usuarioDetails.getUsuario());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioservice.save(iusuario.get()));
	}
	
	// Borrar usuario
		@DeleteMapping("/{id}")
		public ResponseEntity<?> delete(@PathVariable(value = "id") long usuarioid) {
			if(!usuarioservice.findById(usuarioid).isPresent()) {
				return ResponseEntity.notFound().build();
			}
			
			usuarioservice.delete(usuarioid);
			return ResponseEntity.ok().build();
		}
		
		
	// Listado de usuarios	
		@GetMapping 
		public List<Usuario> readAll() {
			
			List<Usuario> usuario = StreamSupport.stream(usuarioservice.findAll().spliterator(), false).collect(Collectors.toList());
			
			return usuario;
		}
}
