package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Investigador;

public interface IInvestigadorServices {

	public List<Investigador> total();
	public Investigador ubicaPorID(String dni);
	public Investigador agregaValor(Investigador invest);
	public Investigador editaValor(Investigador invest);
	public void eliminaValor(String dni);
}
