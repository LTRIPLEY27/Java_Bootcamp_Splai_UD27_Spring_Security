package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IReservaDAO;
import com.example.demo.dto.Reserva;

@Service
public class ReservaServices implements IReservaServices{

	@Autowired
	IReservaDAO reserDAO;
	
	@Override
	public List<Reserva> total() {
		return reserDAO.findAll();
	}

	@Override
	public Reserva ubicaPorID(int numero) {
		return reserDAO.findById(numero).get();
	}

	@Override
	public Reserva agregaValor(Reserva reser) {
		return reserDAO.save(reser);
	}

	@Override
	public Reserva editaValor(Reserva reser) {
		return reserDAO.save(reser);
	}

	@Override
	public void eliminaValor(int numero) {
		reserDAO.deleteById(numero);
	}

}
