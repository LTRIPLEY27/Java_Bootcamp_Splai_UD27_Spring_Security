package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProveedorDAO;
import com.example.demo.dto.Proveedor;

@Service
public class ProveedorServices implements IProveedorServices{
	
	@Autowired
	IProveedorDAO proveedoresDAO;

	@Override
	public List<Proveedor> totalProveedores() {
		return proveedoresDAO.findAll();
	}

	@Override
	public Proveedor guardasProveedores(Proveedor prov) {
		
		return proveedoresDAO.save(prov);
	}

	@Override
	public Proveedor actualizaProveedores(Proveedor prov) {
		
		return proveedoresDAO.save(prov);
	}

	@Override
	public void eliminaProveedores(int id) {
		
		proveedoresDAO.deleteById(id);
	}

	@Override
	public Proveedor ubicaConID(int id) {
		
		return proveedoresDAO.findById(id).get();
	}

}
