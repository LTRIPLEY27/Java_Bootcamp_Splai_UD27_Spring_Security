package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Cajero;

public interface ICajeroServices {

	public List<Cajero> totalCajero();
	public Cajero ubiPorID(int id);
	public Cajero agregaCajero(Cajero cajero);
	public Cajero actualizaCajero(Cajero cajero);
	public void eliminaCajero(int id);
}