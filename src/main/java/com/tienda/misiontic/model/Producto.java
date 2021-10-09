package com.tienda.misiontic.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto {
	
	@Id
	@Column(name = "codigo_producto", length = 20, unique = true)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigo_producto;
	
	@Column(name="ivacompra", nullable=false)
	private double ivacompra;
	
	@ManyToOne
	@JoinColumn(name="nitproveedor")
	private Proveedor nitproveedor;
	
	@Column(name="nombre_producto", nullable=false, length=255, unique=true)
	private String nombre_producto;
	
	@Column(name="precio_compra", nullable=false)
	private double precio_compra;
	
	@Column(name="precio_venta", nullable=false)
	private double precio_venta;

	public long getCodigo_producto() {
		return codigo_producto;
	}

	public void setCodigo_producto(long codigo_producto) {
		this.codigo_producto = codigo_producto;
	}

	public double getIvacompra() {
		return ivacompra;
	}

	public void setIvacompra(double ivacompra) {
		this.ivacompra = ivacompra;
	}

	public Proveedor getNitproveedor() {
		return nitproveedor;
	}

	public void setNitproveedor(Proveedor nitproveedor) {
		this.nitproveedor = nitproveedor;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}
}
