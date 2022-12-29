package com.chardy.springSisTurn.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chardy.springSisTurn.dto.OrganizationDto;
import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.service.IOrganizationService;
import com.chardy.springSisTurn.wrapper.OrganizationWrapper;

@RequestMapping("/api/organizations")
@RestController
public class OrganizationRestcontroller {
	//private Logger log = LoggerFactory.getLogger(OrganizationRestcontroller.class);
	
	@Autowired
	private IOrganizationService organizationService;
	
	
	
	// View all registered and active organizations
	
	@GetMapping("/active")
	public ResponseEntity<HashMap<String, Object>> todasLasOrganizacionesActivas() {
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		List<Organization> organizaciones = organizationService.getAllActive();
		response.put("items", organizaciones);
		response.put("status", "ok");
		response.put("totalResults", organizaciones.size());
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	// View all organizations (active or not)
	
	@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>> todasLasOrganizaciones() {
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		List<Organization> organizaciones = organizationService.getAll();
		response.put("items", organizaciones);
		response.put("totalResults", organizaciones.size());
		response.put("status", "ok");
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	// Search Organization by CUIT
	
	@GetMapping("/cuit/{cuit}")
	public ResponseEntity<Map<String, Object>> findByCuit(@PathVariable(name = "cuit") String cuit){
		Map<String, Object> response = new HashMap<>();
		Organization findOrg = organizationService.findByCuit(cuit);
		if (findOrg != null) {
			response.put("items: ", OrganizationWrapper.entityToDto(findOrg));
			response.put("totalResults", "1");
			response.put("status", "ok");
		}else{
			response.put("status", "error");
			response.put("code", "404");
			response.put("message", "La organizacion con Cuit: "+ cuit +" no existe");
		}
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	
	// Search Organization by NAME
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Map<String, Object>> findByName(@PathVariable(name = "name") String name){
		Map<String, Object> response = new HashMap<>();
		Organization searchedOrg = organizationService.findByName(name);
		if (searchedOrg != null) {
			response.put("items: ", OrganizationWrapper.entityToDto(searchedOrg));
			response.put("totalResults", "1");
			response.put("status", "ok");
		}else{
			response.put("message", "La organizacion con nombre: '"+ name +"' no existe");
			response.put("status", "error");
			response.put("code", "404");
		}
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
		
	// Register New Organization.
	
	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> nuevaOrganizacion(@RequestBody @Valid OrganizationDto orgDTO){
		
		//log.info("Organization: "+organizationDto.toString());
		Map<String, Object> response = new HashMap<>();
		
		Organization organization = OrganizationWrapper.dtoToEntity(orgDTO);		
		Organization newOrganization = organizationService.save(organization);

		OrganizationDto newOrgDTO = OrganizationWrapper.entityToDto(newOrganization);
		
		response.put("data: ", newOrgDTO);
		response.put("totalResults", "1");
		response.put("status", "ok");
		response.put("mesagge", "La Organización ha sido creada con Exito.");
		response.put("token",newOrganization.getToken());
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	} 
	
	// Delete Organization.
	
	@DeleteMapping("/delete")
	  public ResponseEntity<Map<String, Object>> deleteOrg(@RequestParam(value="token",required = true) String token) {
		Map<String, Object> response = new HashMap<>();
		Organization searchedByTokenOrg = organizationService.findByToken(token);
		if (searchedByTokenOrg != null) {
			
			searchedByTokenOrg.setActive(false);
			organizationService.delete(searchedByTokenOrg);
			
			response.put("totalResults", "1");
			response.put("status", "ok");
			response.put("message","La Organización "+searchedByTokenOrg.getName()+" ha sido desactivada/borrada");
			
		}else{
			response.put("mensaje", "La Organizacion que intenta borrar/desactivar no existe.");
			response.put("status", "error");
			response.put("code", "404");
		}
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	  }

	
	// update Organization.
	
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> update(	@RequestParam(value="token",required = true) String token, 
														@RequestBody @Valid OrganizationDto orgDto){
		Map<String, Object> response = new HashMap<>();
		
		Organization updateOrg = organizationService.findByToken(token);
		
		if (updateOrg!=null) {
			
			OrganizationDto newUpdateOrg = organizationService.update(orgDto,token);
			
			response.put("Organizacion: ", newUpdateOrg);
			response.put("totalResults", "1");
			response.put("status", "ok");
			
		}else {
			response.put("token: ", token);
			response.put("updateOrg: ", updateOrg);
			response.put("mensaje", "No se pudo actualizar la informacion de la organizacion.");
		}
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}
	

}
