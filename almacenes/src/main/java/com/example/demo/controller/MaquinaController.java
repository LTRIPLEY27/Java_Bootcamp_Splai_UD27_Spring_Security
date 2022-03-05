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

import com.example.demo.dto.Maquina;
import com.example.demo.services.MaquinaServices;

@RestController
@RequestMapping("/api")
public class MaquinaController {

	@Autowired
	MaquinaServices maqSERVICES;
	
	@GetMapping("/maquinas")
	public List<Maquina> totalMaquinas(){
		return maqSERVICES.totalMaquina();
	}
	
	@GetMapping("/maquinas/{id}")
	public Maquina ubicaPorID(@PathVariable (name = "id") int id) {
		return maqSERVICES.ubiPorID(id);
	}
	
	@PostMapping("/maquinas/add")
	public Maquina agregaMaquina(@RequestBody Maquina maquina) {
		return maqSERVICES.agregaMaquina(maquina);
	}
	
	@PutMapping("/maquinas/{id}/edita")
	public Maquina editaMaquina(@PathVariable (name = "id") int id, Maquina maquina) {
		Maquina maqSEL = new Maquina();
		Maquina maqACT = new Maquina();
		maqSEL = maqSERVICES.ubiPorID(id);
		maqSEL.setPiso(maquina.getPiso());
		maqSEL.setVentas(maquina.getVentas());
		maqACT = maqSEL;
		return maqACT;
	}
	
	@DeleteMapping("/maquinas/{id}/elimina")
	public void eliminaMaquina(@PathVariable (name = "id") int id) {
		maqSERVICES.eliminaMaquina(id);
	}
}
