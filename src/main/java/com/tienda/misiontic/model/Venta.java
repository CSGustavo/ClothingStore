package com.tienda.misiontic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {
	
	@Id
	@Column(name = "codigo_venta", length = 20, unique = true)
	private long codigo_venta;
	
	@ManyToOne
	@JoinColumn(name="cedula_cliente")
	private Cliente cedula_cliente;
	
	@ManyToOne
	@JoinColumn(name="cedula_usuario")
	private Usuario cedula_usuario;
	
	private double ivaventa;
	private double total_venta;
	private double valor_venta;
	public long getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(long codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public Cliente getCedula_cliente() {
		return cedula_cliente;
	}
	public void setCedula_cliente(Cliente cedula_cliente) {
		this.cedula_cliente = cedula_cliente;
	}
	public Usuario getCedula_usuario() {
		return cedula_usuario;
	}
	public void setCedula_usuario(Usuario cedula_usuario) {
		this.cedula_usuario = cedula_usuario;
	}
	public double getIvaventa() {
		return ivaventa;
	}
	public void setIvaventa(double ivaventa) {
		this.ivaventa = ivaventa;
	}
	public double getTotal_venta() {
		return total_venta;
	}
	public void setTotal_venta(double total_venta) {
		this.total_venta = total_venta;
	}
	public double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
}
