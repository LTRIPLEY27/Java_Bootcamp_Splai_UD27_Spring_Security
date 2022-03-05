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

import com.example.demo.dto.Reserva;
import com.example.demo.services.ReservaServices;

@RestController
@RequestMapping("/api")
public class ReservaController {
	@Autowired
	ReservaServices reservaSERV;
	
	@GetMapping("/reservas")
	public List<Reserva> totalEquipos(){
		return reservaSERV.total();
	}
	
	@GetMapping("/reservas/{id}")
	public Reserva ubicaPorID(@PathVariable (name = "id") int id) {
		Reserva reserv = new Reserva();
		reserv = reservaSERV.ubicaPorID(id);
		return reserv;
	}
	
	@PostMapping("/reservas/add")
	public Reserva agregaEquipo(@RequestBody Reserva reserv) {
		return reservaSERV.agregaValor(reserv);
	}
	
	@PutMapping("/reservas/{id}/edita")
	public Reserva editaEquipo(@PathVariable (name = "id") int id, @RequestBody Reserva reserv) {
		Reserva reservSEL = new Reserva();
		Reserva reservACT = new Reserva();
		reservSEL = reservaSERV.ubicaPorID(id);
		reservSEL.setComienzo(reserv.getComienzo());
		reservSEL.setFin(reserv.getFin());
		reservSEL.setEquipo(reserv.getEquipo());
		reservSEL.setInvestigador(reserv.getInvestigador());
		reservACT = reservSEL;
		return reservACT;
	}
	
	@DeleteMapping("/reservas/{id}/elimina")
	public void eliminaEquipo(@PathVariable (name = "id") int id) {
		reservaSERV.eliminaValor(id);
	}
}

