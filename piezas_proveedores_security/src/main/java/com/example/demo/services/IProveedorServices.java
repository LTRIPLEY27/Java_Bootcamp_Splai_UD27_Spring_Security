package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Proveedor;

public interface IProveedorServices {

	public Proveedor guardasProveedores(Proveedor prov); 	 	//Create
	public List <Proveedor> totalProveedores();					//REGISTER
	public Proveedor actualizaProveedores(Proveedor prov);		//UPDATE
	public void eliminaProveedores(int id);						//DELETE
	public Proveedor ubicaConID(int id);
}