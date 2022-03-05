package com.example.demo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asignado_a")
public class Asignado_a {

	@Id
	@Column(name = "id")
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "id_cientifico")
	private Cientifico cientifico;
	
	@ManyToOne
	@JoinColumn(name = "id_proyecto")
	private Proyecto proyecto;
	
	public Asignado_a() {
		
	}

	public Asignado_a(String id, Cientifico cientifico, Proyecto proyecto) {
		super();
		this.id = id;
		this.cientifico = cientifico;
		this.proyecto = proyecto;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Cientifico getCientifico() {
		return cientifico;
	}

	public void setCientifico(Cientifico cientifico) {
		this.cientifico = cientifico;
	}

	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	@Override
	public String toString() {
		return "Asignado_a [id=" + id + ", cientifico=" + cientifico + ", proyecto=" + proyecto + "]";
	}
	
	
}
