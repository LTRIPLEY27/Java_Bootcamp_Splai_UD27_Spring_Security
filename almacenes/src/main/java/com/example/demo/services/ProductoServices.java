package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IProductoDAO;
import com.example.demo.dto.Producto;

@Service
public class ProductoServices implements IProductoServices{

	@Autowired
	IProductoDAO productDAO;
	
	@Override
	public List<Producto> totalProducto() {
		return productDAO.findAll();
	}

	@Override
	public Producto ubiPorID(int id) {
		return productDAO.findById(id).get();
	}

	@Override
	public Producto agregaProducto(Producto prod) {
		return productDAO.save(prod);
	}

	@Override
	public Producto actualizaProducto(Producto prod) {
		return productDAO.save(prod);
	}

	@Override
	public void eliminaProducto(int id) {
		productDAO.deleteById(id);
	}

}