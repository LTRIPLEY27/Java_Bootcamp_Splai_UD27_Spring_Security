package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IAsignado_aDAO;
import com.example.demo.dto.Asignado_a;

@Service
public class Asignado_aServices implements IAsignado_aServices{

	@Autowired
	IAsignado_aDAO asignedDAO;
	
	@Override
	public List<Asignado_a> totalAsignado_a() {
		return asignedDAO.findAll();
	}

	@Override
	public Asignado_a ubicaPorID(String dni) {
		return asignedDAO.findById(dni).get();
	}

	@Override
	public Asignado_a agregaAsignado_a(Asignado_a project) {
		return asignedDAO.save(project);
	}

	@Override
	public Asignado_a actualizaAsignado_a(Asignado_a project) {
		return asignedDAO.save(project);
	}

	@Override
	public void eliminaAsignado_a(String dni) {
		asignedDAO.deleteById(dni);
	}

}

