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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.service.IEventService;
import com.chardy.springSisTurn.wrapper.EventWrapper;

@RequestMapping("/api/events")
@RestController
public class EventRestcontroller {
	
	//private static final Logger log = LoggerFactory.getLogger(EventRestcontroller.class);
	
	@Autowired
	private IEventService eventService;
	
	
	@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>> todosLosEventos() {
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		List<Event> eventos = eventService.getAll();
		response.put("items", eventos);
		response.put("totalResults", eventos.size());
		response.put("status", "ok");
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	
	
	
	// List All Events of an Organization
	
	// Add Event
	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> nuevoEvento( @RequestBody @Valid EventDTO eventDTO, 
															@RequestParam(value="token") String token
														  ){

		//log.info("eventDTO: "+ eventDTO.toString());
		
		Map<String, Object> response = new HashMap<>();
		
		Organization eventAuthOrg = eventService.findByToken(token);
		
		
		if(eventAuthOrg != null) {			// token de Org encontrado
				
				Event newEvent = EventWrapper.dtoToEntity(eventDTO);
				
				newEvent.setOrganization(eventAuthOrg);
				//log.info("newEvent: "+ newEvent.toString());
				
				EventDTO newEventDTO = eventService.save(newEvent);
				
				response.put("items: ", newEventDTO);
				response.put("totalResults", "1");
				response.put("status", "ok");
				response.put("mesagge", "El Evento ha sido creado Correctamente.");
				
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
				
			} else {
	
				// El token de la organizacion es invalido o no fue enviado
				
				response.put("status", "error");
				response.put("code", "401");
				response.put("mesagge", "No posee autorizacion para crear eventos. Contacte al administrador.");
				
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.FORBIDDEN);
			
				}
		} 
	
	
	// Delete Event
	
	// Update Event
	

}
