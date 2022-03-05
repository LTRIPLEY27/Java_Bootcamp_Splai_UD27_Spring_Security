package com.example.demo.security;

public class Constantes {
	
	// LAS CONSTANTES HAN DE IMPLEMENTARSE EN ARCHIVO SEPARADO PARA SU FUTURA LLAMA
	// SON CONDICIONADAS AL ALGORITMO QUE DEFINAMOS PARA LA CREACIÓN DEL TOKEN

	// Spring Security

	public static final String LOGIN_URL = "/login";
	public static final String HEADER_AUTHORIZACION_KEY = "Authorization";
	public static final String TOKEN_BEARER_PREFIX = "Bearer ";

	// JWT

											// USUARIOS REGISTRADOS EN NUESTRA DATABASE
	public static final String ISSUER_INFO = "Henry Miller";
	public static final String SUPER_SECRET_KEY = "123B";
	public static final long TOKEN_EXPIRATION_TIME = 864_000_000; // 10 day
	
}
