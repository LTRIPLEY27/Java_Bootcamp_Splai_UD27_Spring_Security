package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IFacultadDAO;
import com.example.demo.dto.Facultad;
@Service
public class FacultadServices implements IFacultadServices{

	@Autowired
	IFacultadDAO facuDAO;
	
	@Override
	public List<Facultad> total() {
		return facuDAO.findAll();
	}

	@Override
	public Facultad ubicaPorID(int numero) {
		return facuDAO.findById(numero).get();
	}

	@Override
	public Facultad agregaValor(Facultad facu) {
		return facuDAO.save(facu);
	}

	@Override
	public Facultad editaValor(Facultad facu) {
		return facuDAO.save(facu);
	}

	@Override
	public void eliminaValor(int numero) {
		facuDAO.deleteById(numero);
	}

}

