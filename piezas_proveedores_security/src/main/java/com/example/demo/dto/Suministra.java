package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "suministra")
public class Suministra {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//YA QUE ES UNA TABLA RELACIÓN RECIBE CLAVES VALORES FORÁNEAS, DECLARAMOS COMO ATRIBUTOS A ESAS ENTIDADES
	@ManyToOne
	@JoinColumn(name = "id_proveedor")
	Proveedor proveedor;
	
	@ManyToOne
	@JoinColumn(name = "id_pieza")
	Pieza pieza;
	
	@Column(name = "precio")
	private int precio;
	
	public Suministra() {
		
	}

	public Suministra(int id, Proveedor proveedor, Pieza pieza, int precio) {
		super();
		this.id = id;
		this.proveedor = proveedor;
		this.pieza = pieza;
		this.precio = precio;
	}

	//MÉTODOS DE ACCESO
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Pieza getPieza() {
		return pieza;
	}

	public void setPieza(Pieza pieza) {
		this.pieza = pieza;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Suministra [id=" + id + ", proveedor=" + proveedor + ", pieza=" + pieza + ", precio=" + precio + "]";
	}
	
}


