package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IEquipoDAO;
import com.example.demo.dto.Equipo;

@Service
public class EquipoServices implements IEquipoServices{

	@Autowired
	IEquipoDAO equipoDAO;
	
	@Override
	public List<Equipo> total() {
		return equipoDAO.findAll();
	}

	@Override
	public Equipo ubicaPorID(String numero) {
		Equipo equipo = new Equipo();
		equipo = equipoDAO.findById(numero).get();
		return equipo;
	}

	@Override
	public Equipo agregaValor(Equipo equipo) {
		return equipoDAO.save(equipo);
	}

	@Override
	public Equipo editaValor(Equipo equipo) {
		return equipoDAO.save(equipo);
	}

	@Override
	public void eliminaValor(String num) {
		equipoDAO.deleteById(num);
	}

}

