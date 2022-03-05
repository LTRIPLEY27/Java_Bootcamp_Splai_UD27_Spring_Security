package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IInvestigadorDAO;
import com.example.demo.dto.Investigador;
@Service
public class InvestigadorServices implements IInvestigadorServices{

	@Autowired
	IInvestigadorDAO investDAO;
	
	@Override
	public List<Investigador> total() {
		return investDAO.findAll();
	}

	@Override
	public Investigador ubicaPorID(String dni) {
		return investDAO.findById(dni).get();
	}

	@Override
	public Investigador agregaValor(Investigador invest) {
		return investDAO.save(invest);
	}

	@Override
	public Investigador editaValor(Investigador invest) {
		return investDAO.save(invest);
	}

	@Override
	public void eliminaValor(String dni) {
		investDAO.deleteById(dni);
	}

}
