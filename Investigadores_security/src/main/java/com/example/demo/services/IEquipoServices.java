package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Equipo;

public interface IEquipoServices {

	public List<Equipo> total();
	public Equipo ubicaPorID(String numero);
	public Equipo agregaValor(Equipo equipo);
	public Equipo editaValor(Equipo equipo);
	public void eliminaValor(String num);
}

