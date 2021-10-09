package com.tienda.misiontic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Cliente {
	
	@Id
	@Column(name="cedula_cliente", nullable= false, unique=true, length=20)
	private long cedula_cliente;
	
	@Column(name="nombre_completo", nullable=false, length=255)
	private String nombre_completo;
	
	@Column(name="email_cliente", unique=true, length=255)
	private String email_cliente;
	
	@Column(name="direccion", unique=true, length=255)
	private String direccion;
	
	@Column(name="telefono", unique=true, length=255)
	private String telefono;

	public long getCedula_cliente() {
		return cedula_cliente;
	}

	public void setCedula_cliente(long cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}

	public String getNombre_completo() {
		return nombre_completo;
	}

	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
}
