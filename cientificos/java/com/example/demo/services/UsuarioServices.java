package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import static java.util.Collections.emptyList;
import com.example.demo.dao.IUsuarioDAO;
import com.example.demo.dto.Usuario;

@Service
public class UsuarioServices implements UserDetailsService{ // LA INTERFACE "UserDetailsService" ES GENÉRICA DE SPRING PARA UBICAR MÉTODOS REFERENTES A LA APLICACIÓN DE USUARIOS
	// EL AUTOWIRED PARA EL OBJETO DE LA INTERFACE DAO NO FUNCIONA, LA CLASE SERVICES OBLIGATORIOAMENTE DEBE DECLARARLO COMO ATRIBUTO E INICIALIZARLO EN UN CONSTRUCTOR PUES EL MÉTODO SPRING ASÍ LO DEANDA
	//@Autowired			
	//IUsuarioDAO userDAO;
	
	private IUsuarioDAO userDAO;

	public UsuarioServices(IUsuarioDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = userDAO.findByUser(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		//usuario.getRol()   NO RECIBE MÁS DE 2 PARÁMETROS ADEMÁS DEL EMPTYLIST  !!!  PREGUNTAR !!!
		return new User(usuario.getUsuario(), usuario.getPass_user(), emptyList());// INDEPENDIENTEMENTE DEL NOMBRE DEL USUARIO, LA INSTANCIA A RETORNAR, YA QUE ES UN MÉTODO PROPIO DE SPRING SERÁ "new User"
	}
	
}
