package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ISuministraDAO;
import com.example.demo.dto.Suministra;

@Service
public class SuministraServices implements ISuministraServices{
	
	@Autowired
	ISuministraDAO suministraDAO;

	@Override
	public List<Suministra> totalSuministra() {
		
		return suministraDAO.findAll();
	}

	@Override
	public Suministra ubicaPorId(int id) {
		return suministraDAO.findById(id).get();
	}

	@Override
	public Suministra agregaSuministra(Suministra sumi) {
		return suministraDAO.save(sumi);
	}

	@Override
	public Suministra actualizaSuministra(Suministra sumi) {
		return suministraDAO.save(sumi);
	}

	@Override
	public void eliminaSuministra(int id) {
		suministraDAO.deleteById(id);
	}

}
