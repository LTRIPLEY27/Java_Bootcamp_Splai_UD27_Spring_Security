package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Suministra;

public interface ISuministraServices {

	public List<Suministra> totalSuministra();
	public Suministra ubicaPorId(int id);
	public Suministra agregaSuministra(Suministra sumi);
	public Suministra actualizaSuministra(Suministra sumi);
	public void eliminaSuministra(int id);
}