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

import com.example.demo.dto.Proveedor;
import com.example.demo.services.ProveedorServices;

@RestController
@RequestMapping("/api")
public class ProveedorController {
	
	@Autowired
	ProveedorServices provSERVICES;
	
	@GetMapping("/proveedores")
	public List<Proveedor> totalProveedores(){
		return provSERVICES.totalProveedores();
	}
	
	@PostMapping("/proveedores/add")
	public Proveedor guardaProveedor(@RequestBody Proveedor prov) {
		return provSERVICES.guardasProveedores(prov);
	}
	
	@GetMapping("/proveedores/{id}")
	public Proveedor ubicaPorID(@PathVariable (name = "id") int id) {
		Proveedor provi = new Proveedor();
		provi = provSERVICES.ubicaConID(id);
		
		return provi;
	}
	
	@PutMapping("/proveeedores/{id}/actualiza")
	public Proveedor actualizaProveedores(@PathVariable (name = "id") int id, @RequestBody Proveedor prov) {
		Proveedor provSEL = new Proveedor();
		Proveedor provACTUALIZA = new Proveedor();
		provSEL = provSERVICES.ubicaConID(id);
		provSEL.setNombre(prov.getNombre());
		provSEL.setSuministra(prov.getSuministra());
		provACTUALIZA = provSEL;
		
		return provACTUALIZA;
	}
	
	@DeleteMapping("proveedores/{id}/elimina")
	public void eliminaProveedores(@PathVariable (name = "id") int id) {
		provSERVICES.eliminaProveedores(id);
	}
}
