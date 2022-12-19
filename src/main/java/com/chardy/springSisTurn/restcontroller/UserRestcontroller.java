package com.chardy.springSisTurn.restcontroller;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chardy.springSisTurn.entity.User;
import com.chardy.springSisTurn.service.IUserService;

@RequestMapping("/api/users")
@RestController
public class UserRestcontroller {

	@Autowired
	private IUserService userService;
	
	// View all registered and active users
	
	@GetMapping("/active")
	public ResponseEntity<HashMap<String, Object>> todosLosUsuariosActivos() {
		HashMap<String, Object> response = new HashMap<String, Object>();
			
		List<User> user = userService.getAllActive();
		response.put("items", user);
		response.put("status", "ok");
		response.put("totalResults", user.size());
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	// View all users (active or not)
		
		@GetMapping("/all")
		public ResponseEntity<HashMap<String, Object>> todosLosUsuarios() {
			HashMap<String, Object> response = new HashMap<String, Object>();
			
			List<User> users = userService.getAll();
			response.put("items", users);
			response.put("totalResults", users.size());
			response.put("status", "ok");
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
		}
		
		/*
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
		
		// Register New User.
		
		@PostMapping("/add")
		public ResponseEntity<Map<String, Object>> nuevaOrganizacion(@RequestBody @Valid OrganizationDto orgDTO){
			
			//log.info("Organization: "+organizationDto.toString());
			
			Map<String, Object> response = new HashMap<>();
			OrganizationDto newOrganization = organizationService.save(orgDTO);
			
			response.put("items: ", newOrganization);
			response.put("totalResults", "1");
			response.put("status", "ok");
			response.put("mesagge", "La Organización ha sido creada con Exito.");
			
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		} 
		
		// Delete User.
		
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

		
		// update User.
		
		@PutMapping("/update")
		public ResponseEntity<Map<String, Object>> update(	@RequestParam(value="token",required = true) String token, 
															@RequestBody @Valid OrganizationDto orgDto){
			Map<String, Object> response = new HashMap<>();
			
			Organization updateOrg = organizationService.findByToken(token);
			
			if (updateOrg!=null) {
				
				OrganizationDto newUpdateOrg = organizationService.update(orgDto,token);
				
				//OrganizationDto newOrganization = organizationService.save(orgDTO);
				//OrganizationDto updateOrg = organizationService.update(orgDto);
				response.put("Organizacion: ", newUpdateOrg);
				response.put("totalResults", "1");
				response.put("status", "ok");
				//response.put("message","La Organización "+newUpdateOrg.getName()+" ha sido actualizada.");
			}else {
				response.put("token: ", token);
				response.put("updateOrg: ", updateOrg);
				response.put("mensaje", "No se pudo actualizar la informacion de la organizacion.");
			}
			
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
		}
		*/
}
