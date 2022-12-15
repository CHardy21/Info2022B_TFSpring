package com.chardy.springSisTurn.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chardy.springSisTurn.dto.OrganizationDto;
import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.repository.IOrganizationDao;


@RestController
public class OrganizationRestcontroller {
	private Logger log = LoggerFactory.getLogger(OrganizationRestcontroller.class);
	@Autowired
	private IOrganizationDao organizationService;
	
	
	/*
	 ●	El controlador de la empresa (Organization) va a tener 
			1.	un método para registrar una empresa,
			2.	modificar una empresa o 
			3.	eliminar una empresa (solicitará clave para las últimas 2 nombradas.), 
			4.	un método para traer los datos de una empresa activa según su cuit o nombre, 
			5.	y un método para traer todas las empresas registradas activas.
	*/
	
	// Metodo devuelve todas las organizaciones Registradas activas
	@GetMapping("/organizations/active")
	public ResponseEntity<HashMap<String, Object>> todasLasOrganizacionesActivas() {
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		List<Organization> organizaciones = organizationService.findByActive();
		response.put("organizations", organizaciones);
		response.put("totalResults", organizaciones.size());
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	// Metodo devuelve todas las organizaciones Registradas (activas o no)
	@GetMapping("/organizations/all")
	public ResponseEntity<HashMap<String, Object>> todasLasOrganizaciones() {
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		List<Organization> organizaciones = organizationService.findAll();
		response.put("organizations", organizaciones);
		response.put("totalResults", organizaciones.size());
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	// método para registrar una organizacion
	@PostMapping("/organization/add")
	public ResponseEntity<Map<String, Object>> nuevaOrganizacion( @RequestBody @Valid OrganizationDto organizationDto){
		
		log.info("paciente: "+organizationDto.toString());
		
		Map<String, Object> response = new HashMap<>();
		OrganizationDto newOrganization = organizationService.save(organizationDto);
		response.put("organization", newOrganization);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	} 
	
	
}
