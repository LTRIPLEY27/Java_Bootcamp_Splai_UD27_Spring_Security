package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IMaquinaDAO;
import com.example.demo.dto.Maquina;

@Service
public class MaquinaServices implements IMaquinaServices {

	@Autowired
	IMaquinaDAO maquiDAO;
	
	@Override
	public List<Maquina> totalMaquina() {
		return maquiDAO.findAll();
	}

	@Override
	public Maquina ubiPorID(int id) {
		return maquiDAO.findById(id).get();
	}

	@Override
	public Maquina agregaMaquina(Maquina maqui) {
		return maquiDAO.save(maqui);
	}

	@Override
	public Maquina actualizaMaquina(Maquina maqui) {
		return maquiDAO.save(maqui);
	}

	@Override
	public void eliminaMaquina(int id) {
		maquiDAO.deleteById(id);
	}

}