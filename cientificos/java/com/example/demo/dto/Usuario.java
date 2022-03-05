package com.example.demo.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String usuario;
	private String pass_user;
	private String rol;
	
	public Usuario() {
		
	}

	public Usuario(int id, String usuario, String pass_user, String rol) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.pass_user = pass_user;
		this.rol = rol;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass_user() {
		return pass_user;
	}

	public void setPass_user(String pass_user) {
		this.pass_user = pass_user;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", pass_user=" + pass_user + ", rol=" + rol + "]";
	}
	
	
}
