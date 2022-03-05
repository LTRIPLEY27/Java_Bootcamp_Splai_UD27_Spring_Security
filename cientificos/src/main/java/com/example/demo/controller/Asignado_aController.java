package com.example.demo.controller;

import java.util.List;

import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Asignado_a;
import com.example.demo.services.Asignado_aServices;
/*
 * @Author: Isabel Calzadilla
 * UD26 : ER-SPRING-MYSQL-API
 * Ejercicio2
 * */

@RestController
@RequestMapping("/api")
public class Asignado_aController {

	@Autowired
	Asignado_aServices asignedSERV;
	
	@PutMapping("/asignados/{id}/actualiza")
	public Asignado_a actualizaAsignado_a(@PathVariable (name = "id") String id, @RequestBody Asignado_a asignado) {
		Asignado_a asigSEL = new Asignado_a();
		Asignado_a asigACT = new Asignado_a();
		asigSEL.setCientifico(asignado.getCientifico());
		asigSEL.setProyecto(asignado.getProyecto());
		asigACT = asigSEL;
		return asigACT;
	}
	
	@DeleteMapping("/asignados/{id}/elimina")
	public void eliminAsignado_a(@PathVariable (name = "id") String id) {
		asignedSERV.eliminaAsignado_a(id);
	}
	
	@GetMapping("/asignados")
	public List<Asignado_a> totalAsignados(){
		return asignedSERV.totalAsignado_a();
	}
	
	@GetMapping("/asignados/{id}")
	public Asignado_a ubicaPorID(@PathVariable (name = "id") String id) {
		Asignado_a signed= new Asignado_a();
		signed = asignedSERV.ubicaPorID(id);
		return signed;
	}
	
	@PostMapping("/asignados/add")
	public Asignado_a agregaAsignado_a(@RequestBody Asignado_a signed) {
		return asignedSERV.agregaAsignado_a(signed);
	}
}

