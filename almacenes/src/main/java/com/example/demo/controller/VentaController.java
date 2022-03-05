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

import com.example.demo.dto.Venta;
import com.example.demo.services.VentaServices;

@RestController
@RequestMapping("/api")
public class VentaController {

	@Autowired
	VentaServices ventaSERVICES;
	
	@GetMapping("/ventas")
	public List<Venta> totalVentas(){
		return ventaSERVICES.totalVenta();
	}
	
	@GetMapping("/ventas/{id}")
	public Venta ubicaPorId(@PathVariable (name = "id")int id) {
		Venta venta = new Venta();
		venta = ventaSERVICES.ubiPorID(id);
		return venta;
	}
	
	@PostMapping("/ventas/add")
	public Venta agregaVenta(@RequestBody Venta venta) {
		return ventaSERVICES.agregaVenta(venta);
	}
	
	@PutMapping("/ventas/{id}/edita")
	public Venta editaVenta(@PathVariable (name = "id") int id, @RequestBody Venta venta) {
		Venta ventaSEL = new Venta();
		Venta ventaACT = new Venta();
		ventaSEL = ventaSERVICES.ubiPorID(id);
		ventaSEL.setCajero(venta.getCajero());
		ventaSEL.setMaquina(venta.getMaquina());
		ventaSEL.setProducto(venta.getProducto());
		ventaACT = ventaSEL;
		return ventaACT;
	}
	
	@DeleteMapping("/ventas/{id}/elimina")
	public void eliminaVenta(@PathVariable (name = "id") int id) {
		ventaSERVICES.eliminaVenta(id);
	}
}
