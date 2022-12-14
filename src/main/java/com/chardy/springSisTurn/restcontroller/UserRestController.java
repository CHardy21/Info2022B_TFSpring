package com.chardy.springSisTurn.restcontroller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


public class UserRestController {

	private Logger log = LoggerFactory.getLogger(UserRestController.class);
	@Autowired
	private IUser usuarioService;
	
	@GetMapping("/usuarios")
	public ResponseEntity<HashMap<String, Object>> todosLosUsuarios() throws ArithmeticException {
		HashMap<String, Object> response = new HashMap<String, Object>();
		if (true)throw new ArithmeticException("no se puede dividir por cero");
		List<User> usuarios = usuarioService.findByAll();
		response.put("usuarios", usuarios);		
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
}
