package com.tienda.misiontic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "proveedores")
public class Proveedor {
	
	@Id
	@Column(name = "nitproveedor", length = 20, unique = true)
	private long nitproveedor;
	
	@Column(name="ciudad_proveedor", nullable=false, length=255)
	private String ciudad_proveedor;
	
	@Column(name="direccion_proveedor", nullable=false, length=255, unique=true)
	private String direccion_proveedor;
	
	@Column(name="nombre_proveedor", nullable=false, length=255)
	private String nombre_proveedor;
	
	@Column(name="telefono_proveedor", nullable=false, length=255, unique=true)
	private long telefono_proveedor;
	
	public long getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(long nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}
	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}
	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}
	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}
	public String getNombre_proveedor() {
		return nombre_proveedor;
	}
	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}
	public long getTelefono_proveedor() {
		return telefono_proveedor;
	}
	public void setTelefono_proveedor(long telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}
}
