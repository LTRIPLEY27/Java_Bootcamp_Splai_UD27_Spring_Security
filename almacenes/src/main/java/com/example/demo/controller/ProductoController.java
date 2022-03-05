package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Producto;
import com.example.demo.services.ProductoServices;

@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	ProductoServices prodSERVICES;
	
	@GetMapping("/productos")
	public List<Producto> totalProductos(){
		return prodSERVICES.totalProducto();
	}
	
	@GetMapping("/productos/{id}")
	public Producto ubicaPorID(@PathVariable (name = "id") int id) {
		return prodSERVICES.ubiPorID(id);
	}
	
	@PostMapping("/productos/add")
	public Producto agregaProducto(@RequestBody Producto product) {
		return prodSERVICES.agregaProducto(product);
	}
	
	@PutMapping("/productos/{id}/edita")
	public Producto editaProducto(@PathVariable (name = "id") int id, @RequestBody Producto prod) {
		Producto prodSEL = new Producto();
		Producto prodACT = new Producto();
		prodSEL = prodSERVICES.ubiPorID(id);
		prodSEL.setNombre(prod.getNombre());
		prodSEL.setPrecio(prod.getPrecio());
		prodSEL.setVentas(prod.getVentas());
		prodACT = prodSEL;
		return prodACT;
	}
	
	@DeleteMapping("/productos/{id}/elimina")
	public void eliminaProductos(@PathVariable (name = "id") int id) {
		prodSERVICES.eliminaProducto(id);
	}
}
