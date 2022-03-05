package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Facultad;

public interface IFacultadServices {

	public List<Facultad> total();
	public Facultad ubicaPorID(int numero);
	public Facultad agregaValor(Facultad facu);
	public Facultad editaValor(Facultad facu);
	public void eliminaValor(int numero);
}
