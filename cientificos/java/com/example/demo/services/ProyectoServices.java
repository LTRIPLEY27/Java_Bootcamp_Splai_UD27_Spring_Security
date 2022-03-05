package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProyectoDAO;
import com.example.demo.dto.Proyecto;

@Service
public class ProyectoServices implements IProyectoServices {

	@Autowired
	IProyectoDAO projectDAO;
	
	@Override
	public List<Proyecto> totalProyecto() {
		return projectDAO.findAll();
	}

	@Override
	public Proyecto ubicaPorID(String dni) {
		return projectDAO.findById(dni).get();
	}

	@Override
	public Proyecto agregaProyecto(Proyecto project) {
		return projectDAO.save(project);
	}

	@Override
	public Proyecto actualizaProyecto(Proyecto project) {
		return projectDAO.save(project);
	}

	@Override
	public void eliminaProyecto(String dni) {
		projectDAO.deleteById(dni);
	}

}

