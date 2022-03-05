package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Producto;


public interface IProductoServices {

	public List<Producto> totalProducto();
	public Producto ubiPorID(int id);
	public Producto agregaProducto(Producto prod);
	public Producto actualizaProducto(Producto prod);
	public void eliminaProducto(int id);
}
