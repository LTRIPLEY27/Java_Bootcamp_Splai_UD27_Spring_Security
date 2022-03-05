package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Table(name = "proveedores")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//GENERA EL AUTOINCREMENTAL
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany
	@JoinColumn(name  = "id")
	private List<Suministra> suministra;
	
	public Proveedor() {
		
	}

	public Proveedor(int id, String nombre, List<Suministra> suministra) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.suministra = suministra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	//LOS DECORADORES DE PARAMETRIZACIÓN CORRESPONDEN AL GETTER DE LA LIST
	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
	public List<Suministra> getSuministra() {
		return suministra;
	}

	public void setSuministra(List<Suministra> suministra) {
		this.suministra = suministra;
	}

	@Override
	public String toString() {
		return "Proveedores [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
}
	

