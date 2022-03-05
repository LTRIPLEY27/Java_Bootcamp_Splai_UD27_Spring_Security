package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Cientifico;

public interface ICientificoServices {

	public List<Cientifico> totalCientifico();
	public Cientifico ubicaPorID(String dni);
	public Cientifico agregaCientifico(Cientifico cient);
	public Cientifico actualizaCientifico(Cientifico cient);
	public void eliminaCientifico(String dni);
}