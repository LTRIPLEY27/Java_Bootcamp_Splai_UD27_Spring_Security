package com.example.demo.services;

import java.util.List;

import com.example.demo.dto.Venta;


public interface IVentaServices {

	public List<Venta> totalVenta();
	public Venta ubiPorID(int id);
	public Venta agregaVenta(Venta sold);
	public Venta actualizaVenta(Venta sold);
	public void eliminaVenta(int id);
}
