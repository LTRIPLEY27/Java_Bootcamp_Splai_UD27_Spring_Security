package com.example.demo.security;

import static com.example.demo.security.Constantes.HEADER_AUTHORIZACION_KEY;
import static com.example.demo.security.Constantes.ISSUER_INFO;
import static com.example.demo.security.Constantes.LOGIN_URL;
import static com.example.demo.security.Constantes.SUPER_SECRET_KEY;
import static com.example.demo.security.Constantes.TOKEN_BEARER_PREFIX;
import static com.example.demo.security.Constantes.TOKEN_EXPIRATION_TIME;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.dto.Usuario;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter { //EXTIENDE DE LA SUPER CLASE SPRING "UsernamePasswordAuthenticationFilter" PARA HACER USO DE SUS MÉTODOS

	//ES IMPERATIVO DECLARAR LA CLASE AuthenticationManager como atributo pues se debe de incializar en el constructor 
	private AuthenticationManager autenticaManager;

	public JWTAuthenticationFilter(AuthenticationManager autenticaManager) {
		super();
		this.autenticaManager = autenticaManager;
	}
	
	
	// método que génera el token para el usuario a través de los servlets y lo retorna con el objeto inicializado en el constructor
	
				// RECIBE POR PARÁMETROS LOS SERVLETS REQUEST Y RESPONSE PARA COMPROBAR
	public Authentication attemptAuthentication(HttpServletRequest requiere, HttpServletResponse respuesta) throws AuthenticationException {
		try {
			Usuario pass = new ObjectMapper().readValue(requiere.getInputStream(), Usuario.class); //MAPPEA Y ASIGNA AL NUEVO USUARIO EL SERVLETREQUEST CON UN INPUTSTREAM
			//RETORNA EL ATRIBUTO DE LA CLASE MANAGER E INICIALIZADO CON EL MÉTODO "authenticate" QUE OBTIENE el TOKEN CON EL MÉTODO UserName... y que a través del USUARIO INSTANCIADO CON EL MAPPER UBICA AL USUARIO ESPECÍFICO Y SU PASSWORD Y ALMACENA EN UN ARRAYLIST
			return autenticaManager.authenticate(new UsernamePasswordAuthenticationToken(pass.getUsuario(), pass.getPass_user(), new ArrayList<>() ));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication auth) throws IOException, ServletException {

		String token = Jwt.builder().setIssuedAt(new Date()).setIssuer(ISSUER_INFO)
				.setSubject(((User)auth.getPrincipal()).getUsername())
				.setExpiration(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SUPER_SECRET_KEY).compact();
		response.addHeader(HEADER_AUTHORIZACION_KEY, TOKEN_BEARER_PREFIX + " " + token);//devuelve token por cabecera
		response.getWriter().write("{\"token\": \"" + token + "\"}");//devuelve token por body
		System.out.println(response.getHeader(HEADER_AUTHORIZACION_KEY));
	
	}
}
