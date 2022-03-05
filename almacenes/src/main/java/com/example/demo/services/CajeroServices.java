package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICajeroDAO;
import com.example.demo.dto.Cajero;

@Service
public class CajeroServices implements ICajeroServices {
	
	@Autowired
	ICajeroDAO cajeroDAO;

	@Override
	public Cajero ubiPorID(int id) {
		return cajeroDAO.findById(id).get();
	}

	@Override
	public Cajero agregaCajero(Cajero cajero) {
		return cajeroDAO.save(cajero);
	}

	@Override
	public Cajero actualizaCajero(Cajero cajero) {
		return cajeroDAO.save(cajero);
	}

	@Override
	public void eliminaCajero(int id) {
		cajeroDAO.deleteById(id);	
	}

	@Override
	public List<Cajero> totalCajero() {
		return cajeroDAO.findAll();
	}

}

