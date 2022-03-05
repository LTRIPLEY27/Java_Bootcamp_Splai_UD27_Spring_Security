package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IPiezaDAO;
import com.example.demo.dto.Pieza;

//IMPLEMENTAMOS LA INTERFACE DE SERVICE SEGÚN CORRESPONDA A LA ENTIDAD
@Service
public class PiezaServices implements IPiezaServices {

	//hacemos @aUTOWIRED CON LA INTERFACE DAO PARA HACER USO DE SUS MÉTODOS
	@Autowired
	IPiezaDAO piezaDAO;
	
	@Override
	public List<Pieza> totalPiezas() {
		return piezaDAO.findAll();
	}

	@Override
	public Pieza guardaPiezas(Pieza pieza) {
		
		return piezaDAO.save(pieza);
	}

	@Override
	public Pieza actualizaPiezas(Pieza pieza) {
		
		return piezaDAO.save(pieza);
	}

	@Override
	public Pieza actualizaConID(int id) {
		
		return piezaDAO.findById(id).get();
	}

	@Override
	public void EliminaPieza(int id) {
		piezaDAO.deleteById(id);
		
	}

}
