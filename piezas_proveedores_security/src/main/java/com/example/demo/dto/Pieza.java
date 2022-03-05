package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity	//HACEMOS USO DE LOS DECORADORES DE PERSISTANCE PARA MAPEAR LA ENTIDAD
@Table(name = "piezas")
public class Pieza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//valor incremental de javax persistance
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@OneToMany//llamado a ser una clave foránea y primaria de la tabla suministros
	@JoinColumn(name = "id")
	private List<Suministra> suministro;  // LISTADO DE SUMINISTROS A LOS QUE IRÁ EL ID

	//POR DEFECTO
	public Pieza() {
		
	}

	//CONSTRUCTOR COM ATRIBUTOS
	public Pieza(int id, String nombre, List<Suministra> suministro) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.suministro = suministro;
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

	@JsonIgnore //HACEMOS USO DEL DECORADOR JSONIGNORE Y ONETOMAY PARA REPRESENTAR LA ACTUALIZACION EN CADA RELACIÓN
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Suministra")
	public List<Suministra> getSuministro() {
		return suministro;
	}

	public void setSuministro(List<Suministra> suministro) {
		this.suministro = suministro;
	}

	@Override
	public String toString() {
		return "Piezas [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
