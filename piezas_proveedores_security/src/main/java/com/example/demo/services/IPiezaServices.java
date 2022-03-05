package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Pieza;

public interface IPiezaServices {

	//MÉTODOS A IMPLEMENTAR EN EL SERVICES
	public List <Pieza> totalPiezas(); 
	public Pieza guardaPiezas(Pieza pieza);
	public Pieza actualizaPiezas(Pieza pieza);
	public Pieza actualizaConID(int id);
	public void EliminaPieza(int id);
}