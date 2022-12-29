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

import com.chardy.springSisTurn.dto.UserDTO;
import com.chardy.springSisTurn.entity.User;
import com.chardy.springSisTurn.service.IUserService;
import com.chardy.springSisTurn.wrapper.UserWrapper;

@RequestMapping("/api/users")
@RestController
public class UserRestcontroller {

	@Autowired
	private IUserService userService;
	HttpStatus responseStatus;
	
	// View all registered and active users
	@GetMapping("/active")
	public ResponseEntity<HashMap<String, Object>> todosLosUsuariosActivos() {
		HashMap<String, Object> response = new HashMap<String, Object>();
			
		List<User> user = userService.getAllActive();
		response.put("data", user);
		response.put("status", "ok");
		response.put("totalResults", user.size());
		responseStatus=HttpStatus.OK;
		
		return new ResponseEntity<HashMap<String, Object>>(response, responseStatus);
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
		
		
	// Search User by DNI
	@GetMapping("/dni/{dni}")
	public ResponseEntity<Map<String, Object>> findByName(@PathVariable(name = "dni") String dni){
		Map<String, Object> response = new HashMap<>();
		User searchedUser = userService.findByDni(dni);
		
		if (searchedUser != null) {
			response.put("items: ", UserWrapper.entityToDto(searchedUser));
			response.put("totalResults", "1");
			response.put("status", "ok");
			responseStatus=HttpStatus.OK;
		}else{
			response.put("message", "No existe ningun usuario con DNI: '"+ dni +"'.");
			response.put("status", "error");
			response.put("code", "404");
			responseStatus=HttpStatus.NOT_FOUND;
		}
			
		return new ResponseEntity<Map<String,Object>>(response, responseStatus);
	}
		
	// Search User by LastName
	@GetMapping("/lastname/{lastname}")
	public ResponseEntity<Map<String, Object>> findByLastName(@PathVariable(name = "lastname") String lastname){
		Map<String, Object> response = new HashMap<>();
		User searchedUser = userService.findByLastName(lastname);

		if (searchedUser != null) {
			response.put("items: ", UserWrapper.entityToDto(searchedUser));
			response.put("totalResults", "1");
			response.put("status", "ok");
			responseStatus=HttpStatus.OK;
		}else{
			response.put("message", "No existe ningun usuario con Apellido: '"+ lastname +"'.");
			response.put("status", "error");
			response.put("code", "404");
			responseStatus=HttpStatus.NOT_FOUND;
		}
			
		return new ResponseEntity<Map<String,Object>>(response, responseStatus);
	}
		
		
	// Register New User.
	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> nuevaOrganizacion(@RequestBody @Valid UserDTO userDTO){
			
		//log.info("Organization: "+organizationDto.toString());
			
		Map<String, Object> response = new HashMap<>();
		UserDTO newUser = userService.save(userDTO);
			
		response.put("items: ", newUser);
		response.put("totalResults", "1");
		response.put("status", "ok");
		response.put("token", "token"+newUser.getEmail()+newUser.getPhone());
			
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	} 
		
	// Delete User.
	@DeleteMapping("/delete")
	public ResponseEntity<Map<String, Object>> deleteOrg(@RequestParam(value="token",required = true) String token) {
		Map<String, Object> response = new HashMap<>();
		User searchedByTokenUser = userService.findByToken(token);
		
		if (searchedByTokenUser != null) {
				
			searchedByTokenUser.setActive(false);
			userService.delete(searchedByTokenUser);
				
			response.put("totalResults", "1");
			response.put("status", "ok");
			response.put("message","El Usuario "+searchedByTokenUser.getName()+" ha sido desactivado/borrado");
			responseStatus=HttpStatus.OK;	
		}else{
			response.put("mensaje", "El Usuario que intenta borrar/desactivar no existe.");
			response.put("status", "error");
			response.put("code", "404");
			responseStatus=HttpStatus.NOT_FOUND;
			}
			
		return new ResponseEntity<Map<String,Object>>(response, responseStatus);
	}

		
	// update User.
	@PutMapping("/update")
	public ResponseEntity<Map<String, Object>> update(	@RequestParam(value="token",required = true) String token, 
														@RequestBody @Valid UserDTO userDTO){
		Map<String, Object> response = new HashMap<>();
		User updateUser = userService.findByToken(token);
			
		if (updateUser!=null) {
				
			UserDTO newUpdateUser = userService.update(userDTO,token);
				
			response.put("Usuario: ", newUpdateUser);
			response.put("totalResults", "1");
			response.put("status", "ok");
			responseStatus=HttpStatus.OK;
		}else {
			response.put("token: ", token);
			response.put("updateOrg: ", updateUser);
			response.put("mensaje", "No se pudo actualizar la informacion del Usuario.");
			responseStatus=HttpStatus.NOT_FOUND;
			}
			
		return new ResponseEntity<Map<String,Object>>(response,responseStatus);
	}
		
}
