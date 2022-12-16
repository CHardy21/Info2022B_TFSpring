package com.chardy.springSisTurn.restcontroller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.repository.IOrganizationDao;

@RequestMapping("api/organizations")
@RestController
public class OrganizationRestcontroller {
	//private Logger log = LoggerFactory.getLogger(OrganizationRestcontroller.class);
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
	@GetMapping("/active")
	public ResponseEntity<HashMap<String, Object>> todasLasOrganizacionesActivas() {
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		List<Organization> organizaciones = organizationService.findByActive();
		response.put("items", organizaciones);
		response.put("totalResults", organizaciones.size());
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	// Metodo devuelve todas las organizaciones Registradas (activas o no)
	@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>> todasLasOrganizaciones() {
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		List<Organization> organizaciones = organizationService.findAll();
		response.put("items", organizaciones);
		response.put("totalResults", organizaciones.size());
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	// método para registrar una organizacion
	/*
	@PostMapping("/organization/add")
	public ResponseEntity<Map<String, Object>> nuevaOrganizacion( @RequestBody OrganizationDto organizationDto){
		
		log.info("paciente: "+organizationDto.toString());
		
		Map<String, Object> response = new HashMap<>();
		OrganizationDto newOrganization = organizationService.save(organizationDto);
		response.put("organization", newOrganization);
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	} 
	*/

}
