package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Asignado_a;


public interface IAsignado_aServices {

	public List<Asignado_a> totalAsignado_a();
	public Asignado_a ubicaPorID(String dni);
	public Asignado_a agregaAsignado_a(Asignado_a project);
	public Asignado_a actualizaAsignado_a(Asignado_a project);
	public void eliminaAsignado_a(String dni);
}

