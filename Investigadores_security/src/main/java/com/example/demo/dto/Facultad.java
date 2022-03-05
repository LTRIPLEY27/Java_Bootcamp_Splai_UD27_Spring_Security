package com.example.demo.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "facultades")
public class Facultad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo")
	private int codigo;
	
	private String nombre;
	
	@OneToMany
	@JoinColumn(name = "id_facultad")
	private List<Investigador> investigadors;
	
	@OneToMany
	@JoinColumn(name = "id_facultad")
	private List<Equipo> equipos;
	
	public Facultad() {
		
	}

	public Facultad(int codigo, String nombre, List<Investigador> investigadors, List<Equipo> equipos) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.investigadors = investigadors;
		this.equipos = equipos;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Investigador")
	public List<Investigador> getInvestigadors() {
		return investigadors;
	}

	public void setInvestigadors(List<Investigador> investigadors) {
		this.investigadors = investigadors;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Equipo")
	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}

	@Override
	public String toString() {
		return "Facultad [codigo=" + codigo + ", nombre=" + nombre + ", investigadors=" + investigadors + ", equipos="
				+ equipos + "]";
	}
	
	
}
