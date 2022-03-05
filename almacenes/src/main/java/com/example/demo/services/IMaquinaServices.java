package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Maquina;

public interface IMaquinaServices {
	public List<Maquina> totalMaquina();
	public Maquina ubiPorID(int id);
	public Maquina agregaMaquina(Maquina maqui);
	public Maquina actualizaMaquina(Maquina maqui);
	public void eliminaMaquina(int id);
}