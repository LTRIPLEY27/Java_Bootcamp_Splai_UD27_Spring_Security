package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Usuario;

public interface IUsuarioDAO extends JpaRepository<Usuario, Integer>{

	//FILTRO POR USUARIO
	Usuario findByUser(String usuario);
}
