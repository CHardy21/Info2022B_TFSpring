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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chardy.springSisTurn.dto.TurnDTO;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.entity.Turn;
import com.chardy.springSisTurn.entity.User;
import com.chardy.springSisTurn.service.ITurnService;
import com.chardy.springSisTurn.wrapper.TurnWrapper;

@RequestMapping("/api/turns")
@RestController
public class TurnRestcontroller {
	
	private static final Logger log = LoggerFactory.getLogger(TurnRestcontroller.class);
	
	@Autowired
	private ITurnService turnService;
	
	// list all turns
	@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>> todosLosTurnos() {
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		List<Turn> turnos = turnService.getAll();
		response.put("items", turnos);
		response.put("totalResults", turnos.size());
		response.put("status", "ok");
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	// List Turns for Organization
	@GetMapping("/active/{cuit}")
	public ResponseEntity<HashMap<String, Object>> todosLosTurnosActivosPorOrganizacion(
			@PathVariable(name = "cuit") String cuit
			) {
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		Organization turnosOrg = turnService.findByCuit(cuit);
		
		Long turnIdOrg = turnosOrg.getId();
		
		//List<Turn> turnos = turnService.finAllByIdOrg(turnIdOrg);
		
		//response.put("items", turnos);
		//response.put("totalResults", turnos.size());
		response.put("status", "ok"+turnIdOrg);
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	
	//List Turns for Event
	
	// Add Turn
	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> nuevoTurno(	@RequestBody @Valid TurnDTO turnDTO, 
															@RequestParam(value="token") String token
			  											  												){
		
		Map<String, Object> response = new HashMap<>();
		User turnAuthUser = turnService.findByToken(token);
		Event eventTurn = turnService.findEventById(turnDTO.getIdEvent());
		
		if(turnAuthUser != null) {			// token del User encontrado
			
			if(eventTurn != null) {
			
				Turn nuevoTurno = TurnWrapper.dtoToEntity(turnDTO);
				nuevoTurno.setEvent(eventTurn);
				
				nuevoTurno.setUser(turnAuthUser);
				nuevoTurno.setActive(true);
				if(eventTurn.getType()!= true) {
					nuevoTurno.setDateTurn(eventTurn.getDateInit());
				}else {
					nuevoTurno.setDateTurn(turnDTO.getDateTurn());
				}
				
				log.info("nuevoTurno: "+ nuevoTurno.toString());
				
				TurnDTO newTurnDTO = turnService.save(nuevoTurno);
				
				response.put("items: ", newTurnDTO);
				response.put("totalResults", "1");
				response.put("status", "ok");
				response.put("mesagge", "El Turno ha sido creado Correctamente.");
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
			
			}else {
				response.put("status", "error");
				response.put("code", "404");
				response.put("mesagge", "El evento no existe.");
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
			}
		} else {

			// El token de usuario es invalido o no fue enviado
			
			response.put("status", "error");
			response.put("code", "401");
			response.put("mesagge", "No posee autorización para sacar turnos. Contacte al administrador.");
			
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
		
			}
		
	}
	

}
