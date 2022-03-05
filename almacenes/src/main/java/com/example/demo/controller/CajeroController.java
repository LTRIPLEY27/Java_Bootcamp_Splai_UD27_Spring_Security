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

import com.example.demo.dto.Cajero;
import com.example.demo.services.CajeroServices;
/*
 * @Author: Isabel Calzadilla
 * UD26 : ER-SPRING-MYSQL-API
 * Ejercicio3
 * */


@RestController
@RequestMapping("/api")
public class CajeroController {

	@Autowired
	CajeroServices cajeSERVICES;
	
	@GetMapping("/cajeros")
	public List<Cajero> totalCajeros(){
		return cajeSERVICES.totalCajero();
	}
	
	@GetMapping("/cajeros/{id}")
	public Cajero ubicaPorID(@PathVariable (name = "id") int id) {
		Cajero cajero = new Cajero();
		cajero = cajeSERVICES.ubiPorID(id);
		return cajero;
	}
	
	@PostMapping("/cajeros/add")
	public Cajero agregaCajero(@RequestBody Cajero cajero) {
		return cajeSERVICES.agregaCajero(cajero);
	}
	
	@PutMapping("/cajeros/{id}/edita")
	public Cajero editaCajero(@PathVariable (name = "id") int id, @RequestBody Cajero cajero) {
		Cajero cajeSEL = new Cajero();
		Cajero cajeACT = new Cajero();
		cajeSEL = cajeSERVICES.ubiPorID(id);
		cajeSEL.setNom_apels(cajero.getNom_apels());
		cajeSEL.setVentas(cajero.getVentas());
		cajeACT = cajeSEL;
		return cajeACT;
	}
	
	@DeleteMapping("/cajeros/{id}/elimina")
	public void eliminaCajeros(@PathVariable (name = "id") int id) {
		cajeSERVICES.eliminaCajero(id);
	}
}

