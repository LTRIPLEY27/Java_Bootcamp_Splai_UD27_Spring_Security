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

import com.example.demo.dto.Equipo;
import com.example.demo.services.EquipoServices;

@RestController
@RequestMapping("/api")
public class EquipoController {

	@Autowired
	EquipoServices equiSERV;
	
	@GetMapping("/equipos")
	public List<Equipo> totalEquipos(){
		return equiSERV.total();
	}
	
	@GetMapping("/equipos/{num_serie}")
	public Equipo ubicaPorID(@PathVariable (name = "num_serie") String num_serie) {
		Equipo equipo = new Equipo();
		equipo = equiSERV.ubicaPorID(num_serie);
		return equipo;
	}
	
	@PostMapping("/equipos/add")
	public Equipo agregaEquipo(@RequestBody Equipo equipe) {
		return equiSERV.agregaValor(equipe);
	}
	
	@PutMapping("/equipos/{num_serie}/edita")
	public Equipo editaEquipo(@PathVariable (name = "num_serie") String num_serie, @RequestBody Equipo equipo) {
		Equipo equipoSEL = new Equipo();
		Equipo equipoACT = new Equipo();
		equipoSEL = equiSERV.ubicaPorID(num_serie);
		equipoSEL.setNombre(equipo.getNombre());
		equipoSEL.setFacultad(equipo.getFacultad());
		equipoACT = equipoSEL;
		return equipoACT;
	}
	
	@DeleteMapping("/equipos/{num_serie}/elimina")
	public void eliminaEquipo(@PathVariable (name = "num_serie") String num_serie) {
		equiSERV.eliminaValor(num_serie);
	}
}
