package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Proyecto;


public interface IProyectoServices {

	public List<Proyecto> totalProyecto();
	public Proyecto ubicaPorID(String dni);
	public Proyecto agregaProyecto(Proyecto project);
	public Proyecto actualizaProyecto(Proyecto project);
	public void eliminaProyecto(String dni);
}
