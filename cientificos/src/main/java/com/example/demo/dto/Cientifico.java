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
@Table(name = "cientificos")
public class Cientifico {

	@Id
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "nom_apels")
	private String nom_apels;
	
	@OneToMany
	@JoinColumn(name = "id_cientifico")
	private List<Asignado_a> asignado;
	
	public Cientifico() {
		
	}

	public Cientifico(String dni, String nom_apels, List<Asignado_a> asignado) {
		super();
		this.dni = dni;
		this.nom_apels = nom_apels;
		this.asignado = asignado;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNom_apels() {
		return nom_apels;
	}

	public void setNom_apels(String nom_apels) {
		this.nom_apels = nom_apels;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Asignado_a")
	public List<Asignado_a> getAsignado() {
		return asignado;
	}

	public void setAsignado(List<Asignado_a> asignado) {
		this.asignado = asignado;
	}

	@Override
	public String toString() {
		return "Cientifico [dni=" + dni + ", nom_apels=" + nom_apels + ", asignado=" + asignado + "]";
	}
	
	
}
