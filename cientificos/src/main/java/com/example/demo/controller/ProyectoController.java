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

import com.example.demo.dto.Proyecto;
import com.example.demo.services.ProyectoServices;

@RestController
@RequestMapping("/api")
public class ProyectoController {

	@Autowired
	ProyectoServices proSERVICES;
	
	@GetMapping("/proyectos")
	public List<Proyecto> totalProyectos(){
		return proSERVICES.totalProyecto();
	}
	
	@PutMapping("/proyectos/{id}/actualiza")
	public Proyecto actualizaProyecto(@PathVariable (name = "id") String id, @RequestBody Proyecto project) {
		Proyecto proSEL = new Proyecto();
		Proyecto proACT = new Proyecto();
		proSEL = proSERVICES.ubicaPorID(id);
		proSEL.setNombre(project.getNombre());
		proSEL.setHoras(project.getHoras());
		proSEL.setAsignado(project.getAsignado());
		proACT = proSEL;
		return proACT;
	}
	
	@GetMapping("/proyectos/{id}")
	public Proyecto ubicaPorID(@PathVariable (name = "id") String id) {
		Proyecto proyecto = new Proyecto();
		proyecto = proSERVICES.ubicaPorID(id);
		return proyecto;
	}
	
	@PostMapping("/proyectos/add")
	public Proyecto agregaProyecto(@RequestBody Proyecto project) {
		return proSERVICES.agregaProyecto(project);
	}
	
	@DeleteMapping("/proyectos/{id}/elimina")
	public void eliminaProyecto(@PathVariable (name = "id") String id) {
		proSERVICES.eliminaProyecto(id);
	}
}

