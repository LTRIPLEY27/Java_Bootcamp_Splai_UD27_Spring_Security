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
@Table(name = "cajeros")
public class Cajero {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nom_apels")
	private String nom_apels;
	
	@OneToMany
	@JoinColumn(name = "id_cajero")
	private List<Venta> ventas;
	
	public Cajero() {
		
	}

	public Cajero(int id, String nom_apels, List<Venta> ventas) {
		super();
		this.id = id;
		this.nom_apels = nom_apels;
		this.ventas = ventas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom_apels() {
		return nom_apels;
	}

	public void setNom_apels(String nom_apels) {
		this.nom_apels = nom_apels;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "Venta")
	public List<Venta> getVentas() {
		return ventas;
	}

	public void setVentas(List<Venta> ventas) {
		this.ventas = ventas;
	}

	@Override
	public String toString() {
		return "Cajero [id=" + id + ", nom_apels=" + nom_apels + ", ventas=" + ventas + "]";
	}
	
	
}

