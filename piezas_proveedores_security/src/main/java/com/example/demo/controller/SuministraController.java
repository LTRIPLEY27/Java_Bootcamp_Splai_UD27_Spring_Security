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

import com.example.demo.dto.Suministra;
import com.example.demo.services.SuministraServices;

@RestController
@RequestMapping("/api")
public class SuministraController {

	@Autowired
	SuministraServices sumiSERVICES;
	
	@GetMapping("/suministra")
	public List <Suministra> totalSuministra(){
		return sumiSERVICES.totalSuministra(); 	
	}
	
	@GetMapping("/suministra/{id}")
	public Suministra ubicaPorID(@PathVariable (name = "id") int id) {
		Suministra sumi = new Suministra();
		sumi = sumiSERVICES.ubicaPorId(id);
		return sumi;
	}
	
	@PostMapping("/suministra/add")
	public Suministra agregaSuministra(@RequestBody Suministra sumi) {
		return sumiSERVICES.agregaSuministra(sumi);
	}
	
	@PutMapping("/suministra/{id}/agrega")
	public Suministra actualizaSuministra(@PathVariable (name = "id") int id, @RequestBody Suministra sumi) {
		Suministra sumiSEL = new Suministra();
		Suministra sumiACTUALIZA = new Suministra();
		sumiSEL = sumiSERVICES.ubicaPorId(id);
		sumiSEL.setPrecio(sumi.getPrecio());
		sumiSEL.setPieza(sumi.getPieza());
		sumiSEL.setProveedor(sumi.getProveedor());
		
		sumiACTUALIZA = sumiSEL;
		
		return sumiACTUALIZA;
	}

	@DeleteMapping("/suministra/{id}/elimina")
	public void eliminaSuministra(@PathVariable (name = "id") int id) {
		sumiSERVICES.eliminaSuministra(id);
	}
}
