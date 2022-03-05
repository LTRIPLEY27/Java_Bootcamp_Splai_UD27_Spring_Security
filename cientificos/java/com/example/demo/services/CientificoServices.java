package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICientificoDAO;
import com.example.demo.dto.Cientifico;

@Service
public class CientificoServices implements ICientificoServices {

	@Autowired
	ICientificoDAO cientiDAO;
	
	@Override
	public List<Cientifico> totalCientifico() {
		return cientiDAO.findAll();
	}

	@Override
	public Cientifico ubicaPorID(String dni) {
		return cientiDAO.findById(dni).get();
	}

	@Override
	public Cientifico agregaCientifico(Cientifico cient) {
		return cientiDAO.save(cient);
	}

	@Override
	public Cientifico actualizaCientifico(Cientifico cient) {
		return cientiDAO.save(cient);
	}

	@Override
	public void eliminaCientifico(String dni) {
		cientiDAO.deleteById(dni);
	}

}
