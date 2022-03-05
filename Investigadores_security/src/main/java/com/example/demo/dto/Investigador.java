package com.example.demo.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "investigadores")
public class Investigador {

	@Id
	private String dni;
	private String nom_apels;
	
	@ManyToOne
	@JoinColumn(name = "id_facultad")
	private Facultad facultad;
	
	@OneToMany
	@JoinColumn(name = "id_investigador")
	private List<Reserva> reservas;
	
	public Investigador() {
		
	}

	public Investigador(String dni, String nom_apels, Facultad facultad, List<Reserva> reservas) {
		super();
		this.dni = dni;
		this.nom_apels = nom_apels;
		this.facultad = facultad;
		this.reservas = reservas;
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

	public Facultad getFacultad() {
		return facultad;
	}

	public void setFacultad(Facultad facultad) {
		this.facultad = facultad;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Reserva")
	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	@Override
	public String toString() {
		return "Investigador [dni=" + dni + ", nom_apels=" + nom_apels + ", facultad=" + facultad + ", reservas="
				+ reservas + "]";
	}
}

