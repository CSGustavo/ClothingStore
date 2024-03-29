package com.tienda.misiontic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_ventas")
public class DetalleVenta {
	@Id
	@Column(name = "codigo_detalle_venta", nullable = false, length = 20)
	private long codigo_detalle_venta;
	
	@Column(name = "cantidad_producto", nullable=false, length=11)
	private long cantidad_producto;
	
	@ManyToOne
	@JoinColumn(name="codigo_producto")
	private Producto codigo_producto;
	
	@ManyToOne
	@JoinColumn(name="codigo_venta")
	private Venta codigo_venta;
	
	private double valor_total;
	private double valor_venta;
	private double valor_iva;
	public long getCodigo_detalle_venta() {
		return codigo_detalle_venta;
	}
	public void setCodigo_detalle_venta(long codigo_detalle_venta) {
		this.codigo_detalle_venta = codigo_detalle_venta;
	}
	public long getCantidad_producto() {
		return cantidad_producto;
	}
	public void setCantidad_producto(long cantidad_producto) {
		this.cantidad_producto = cantidad_producto;
	}
	public Producto getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(Producto codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public Venta getCodigo_venta() {
		return codigo_venta;
	}
	public void setCodigo_venta(Venta codigo_venta) {
		this.codigo_venta = codigo_venta;
	}
	public double getValor_total() {
		return valor_total;
	}
	public void setValor_total(double valor_total) {
		this.valor_total = valor_total;
	}
	public double getValor_venta() {
		return valor_venta;
	}
	public void setValor_venta(double valor_venta) {
		this.valor_venta = valor_venta;
	}
	public double getValor_iva() {
		return valor_iva;
	}
	public void setValor_iva(double valor_iva) {
		this.valor_iva = valor_iva;
	}
		
}
