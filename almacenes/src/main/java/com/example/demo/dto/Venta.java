package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ventas")
public class Venta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;
	
	@ManyToOne
	@JoinColumn(name = "id_cajero")
	private Cajero cajero;
	
	@ManyToOne
	@JoinColumn(name = "id_maquina")
	private Maquina maquina;
	
	public Venta() {
		
	}

	public Venta(int id, Producto producto, Cajero cajero, Maquina maquina) {
		super();
		this.id = id;
		this.producto = producto;
		this.cajero = cajero;
		this.maquina = maquina;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Cajero getCajero() {
		return cajero;
	}

	public void setCajero(Cajero cajero) {
		this.cajero = cajero;
	}

	public Maquina getMaquina() {
		return maquina;
	}

	public void setMaquina(Maquina maquina) {
		this.maquina = maquina;
	}

	@Override
	public String toString() {
		return "Venta [id=" + id + ", producto=" + producto + ", cajero=" + cajero + ", maquina=" + maquina + "]";
	}
	
	
}
