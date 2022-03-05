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

import com.example.demo.dto.Cientifico;
import com.example.demo.services.CientificoServices;

@RestController
@RequestMapping("/api")
public class CientificoController {

	@Autowired
	CientificoServices cientiSERVI;
	
	@GetMapping("/cientificos")
	public List<Cientifico> totalCientificos(){
		return cientiSERVI.totalCientifico();
	}
	
	@PostMapping("/cientificos/add")
	public Cientifico agregaCientifico(@RequestBody Cientifico cientifico) {
		return cientiSERVI.agregaCientifico(cientifico);
	}
	
	@GetMapping("/cientificos/{dni}")
	public Cientifico ubicaPorID(@PathVariable (name = "dni") String dni) {
		Cientifico cientifico = new Cientifico();
		cientifico = cientiSERVI.ubicaPorID(dni);
		return cientifico;
	}
	
	@DeleteMapping("/cientificos/{dni}/elimina")
	public void eliminaCientifico(@PathVariable (name = "dni") String dni) {
		cientiSERVI.eliminaCientifico(dni);
	}
	
	@PutMapping("/cientificos/{id}/actualiza")
	public Cientifico actualizaCientifico(@PathVariable (name = "dni") String dni,@RequestBody Cientifico cientifico) {
		Cientifico cienSEL = new Cientifico();
		Cientifico cienACT = new Cientifico();
		cienSEL = cientiSERVI.ubicaPorID(dni);
		cienSEL.setNom_apels(cientifico.getNom_apels());
		cienSEL.setAsignado(cientifico.getAsignado());
		cienACT = cienSEL;
		return cienACT;
	}
}

