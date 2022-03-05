package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IVentaDAO;
import com.example.demo.dto.Venta;

@Service
public class VentaServices implements IVentaServices {

	@Autowired
	IVentaDAO ventaDAO;
	
	@Override
	public List<Venta> totalVenta() {
		return ventaDAO.findAll();
	}

	@Override
	public Venta ubiPorID(int id) {
		return ventaDAO.findById(id).get();
	}

	@Override
	public Venta agregaVenta(Venta sold) {
		return ventaDAO.save(sold);
	}

	@Override
	public Venta actualizaVenta(Venta sold) {
		return ventaDAO.save(sold);
	}

	@Override
	public void eliminaVenta(int id) {
		ventaDAO.deleteById(id);
	}

}