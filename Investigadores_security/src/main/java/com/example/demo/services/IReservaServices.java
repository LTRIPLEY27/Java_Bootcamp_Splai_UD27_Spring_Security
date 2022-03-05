package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Reserva;

public interface IReservaServices {

	public List<Reserva> total();
	public Reserva ubicaPorID(int numero);
	public Reserva agregaValor(Reserva reser);
	public Reserva editaValor(Reserva reser);
	public void eliminaValor(int numero);
}