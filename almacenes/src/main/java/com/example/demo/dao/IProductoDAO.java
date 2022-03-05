package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Producto;

public interface IProductoDAO extends JpaRepository<Producto, Integer>{

}

