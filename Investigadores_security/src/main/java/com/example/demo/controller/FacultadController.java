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

import com.example.demo.dto.Facultad;
import com.example.demo.services.FacultadServices;

@RestController
@RequestMapping("/api")
public class FacultadController {

	@Autowired
	FacultadServices facuSERV;
	
	@GetMapping("/facultades")
	public List<Facultad> totalEquipos(){
		return facuSERV.total();
	}
	
	@GetMapping("/facultades/{codigo}")
	public Facultad ubicaPorID(@PathVariable (name = "codigo") int codigo) {
		Facultad facu = new Facultad();
		facu = facuSERV.ubicaPorID(codigo);
		return facu;
	}
	
	@PostMapping("/facultades/add")
	public Facultad agregaEquipo(@RequestBody Facultad facu) {
		return facuSERV.agregaValor(facu);
	}
	
	@PutMapping("/facultades/{codigo}/edita")
	public Facultad editaEquipo(@PathVariable (name = "codigo") int codigo, @RequestBody Facultad facu) {
		Facultad facuSEL = new Facultad();
		Facultad facuACT = new Facultad();
		facuSEL = facuSERV.ubicaPorID(codigo);
		facuSEL.setNombre(facu.getNombre());
		facuACT = facuSEL;
		return facuACT;
	}
	
	@DeleteMapping("/facultades/{codigo}/elimina")
	public void eliminaEquipo(@PathVariable (name = "codigo") int codigo) {
		facuSERV.eliminaValor(codigo);
	}
}

