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

import com.example.demo.dto.Investigador;
import com.example.demo.services.InvestigadorServices;
/*
 * @Author: Isabel Calzadilla
 * UD26: REST-API-SPRING-MYSQL
 * EJERCICIO4
 * */

@RestController
@RequestMapping("/api")
public class InvestigadorController {
	@Autowired
	InvestigadorServices investSERV;
	
	@GetMapping("/investigadores")
	public List<Investigador> totalEquipos(){
		return investSERV.total();
	}
	
	@GetMapping("/investigadores/{dni}")
	public Investigador ubicaPorID(@PathVariable (name = "dni") String dni) {
		Investigador invest = new Investigador();
		invest = investSERV.ubicaPorID(dni);
		return invest;
	}
	
	@PostMapping("/investigadores/add")
	public Investigador agregaEquipo(@RequestBody Investigador invest) {
		return investSERV.agregaValor(invest);
	}
	
	@PutMapping("/investigadores/{dni}/edita")
	public Investigador editaEquipo(@PathVariable (name = "dni") String dni, @RequestBody Investigador invest) {
		Investigador investSEL = new Investigador();
		Investigador investACT = new Investigador();
		investSEL = investSERV.ubicaPorID(dni);
		investSEL.setNom_apels(invest.getNom_apels());
		investSEL.setFacultad(invest.getFacultad());
		investACT = investSEL;
		return investACT;
	}
	
	@DeleteMapping("/investigadores/{dni}/elimina")
	public void eliminaEquipo(@PathVariable (name = "dni") String dni) {
		investSERV.eliminaValor(dni);
	}
}

