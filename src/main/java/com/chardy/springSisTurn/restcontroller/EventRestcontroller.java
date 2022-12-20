package com.chardy.springSisTurn.restcontroller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.dto.OrganizationDto;
import com.chardy.springSisTurn.service.IEventService;
import com.chardy.springSisTurn.service.IOrganizationService;

@RequestMapping("/api/events")
@RestController
public class EventRestcontroller {
	
	@Autowired
	private IEventService eventService;
	
	// List All Events of an Organization
	
	// Add Event
	
	@PostMapping("/add")
	public ResponseEntity<Map<String, Object>> nuevoEvento(@RequestBody @Valid EventDTO eventDTO){
		
		//log.info("Organization: "+organizationDto.toString());
		
		Map<String, Object> response = new HashMap<>();
		OrganizationDto newEvent = eventService.save(eventDTO);
		
		response.put("items: ", newEvent);
		response.put("totalResults", "1");
		response.put("status", "ok");
		response.put("mesagge", "La Organización ha sido creada con Exito.");
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	} 
	
	
	// Delete Event
	
	// Update Event

}
