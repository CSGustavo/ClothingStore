package com.tienda.misiontic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@Column(name = "codigo_producto", length = 20, unique = true)
	private long codigo_producto;
	private long ivacompra;
	private long nitproveedor;
	private long nombre_producto;
	private long precio_compra;
	private long precio_venta;
	public long getCodigo_producto() {
		return codigo_producto;
	}
	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}
	public long getIvacompra() {
		return ivacompra;
	}
	public void setIvacompra(long ivacompra) {
		this.ivacompra = ivacompra;
	}
	public long getNitproveedor() {
		return nitproveedor;
	}
	public void setNitproveedor(long nitproveedor) {
		this.nitproveedor = nitproveedor;
	}
	public long getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(long nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public long getPrecio_compra() {
		return precio_compra;
	}
	public void setPrecio_compra(long precio_compra) {
		this.precio_compra = precio_compra;
	}
	public long getPrecio_venta() {
		return precio_venta;
	}
	public void setPrecio_venta(long precio_venta) {
		this.precio_venta = precio_venta;
	}
	
	
}
