package com.chardy.springSisTurn.restcontroller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.dto.OrganizationDto;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.service.IEventService;
import com.chardy.springSisTurn.wrapper.EventWrapper;


@RequestMapping("/api/events")
@RestController
public class EventRestcontroller {
	
	private static final Logger log = LoggerFactory.getLogger(EventRestcontroller.class);
	
	@Autowired
	private IEventService eventService;
	
	
	@GetMapping("/all")
	public ResponseEntity<HashMap<String, Object>> todosLosEventos() {
		
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		List<Event> eventos = eventService.getAll();
		response.put("data", eventos);
		response.put("totalResults", eventos.size());
		response.put("status", "ok");
		return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
	}
	

	// List All Events of an Organization
	@GetMapping("/active/{cuit}")
	public ResponseEntity<HashMap<String, Object>> todosLosEventosActivos(@PathVariable(value="cuit") String cuit) {
		HashMap<String, Object> response = new HashMap<String, Object>();
		
		Organization OrgEventos = eventService.findByCuit(cuit);
		
		if(OrgEventos != null) {
						
			//List<Event> eventos = eventService.getAllEventsOrg( OrgEventos.getId());
			Set<Event> eventos = OrgEventos.getEvents();
			
			if(eventos != null) {
				
				response.put("status", "ok");
				response.put("totalResults", eventos.size());
				response.put("data", eventos);
				return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.OK);
				
			} else {
				
				response.put("status", "error");
				response.put("code", "404");
				response.put("mesagge", "No existen eventos creados para la Organización consultada.");
				return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.NOT_FOUND);
				
			}
		
		} else {
			response.put("status", "error");
			response.put("code", "404");
			response.put("mesagge", "No existe Organización con el CUIT enviado.");
			return new ResponseEntity<HashMap<String, Object>>(response, HttpStatus.NOT_FOUND);
			
		}
	}
	
	
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
				
				response.put("data", newEventDTO);
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
	@DeleteMapping("/delete/{id}")
	  public ResponseEntity<Map<String, Object>> borrarEventoDeLaOrganizacion(
			  												@RequestParam(value="token",required = true) String token,
			  												@PathVariable(value="id") Long id) {
		Map<String, Object> response = new HashMap<>();
		
		//Optional<Event> eventDelete = eventService.findById(id);
		Optional<Event> optinalEntity =  eventService.findById(id);
		Event eventDelete = optinalEntity.get();
		
		log.info("eventDelete: "+ eventDelete.toString());
		
		if (eventDelete != null) {
		
			Organization searchedByTokenOrg = eventService.findByToken(token);
			if (searchedByTokenOrg != null) {
				
				eventDelete.setActive(false);
				eventDelete= eventService.delete(id);
				
				response.put("totalResults", "1");
				response.put("status", "ok");
				response.put("message","El evento ha sido desactivada/borrada");
				return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
				
				} else {
					
					response.put("status", "error");
					response.put("code", "401");
					response.put("mesagge", "No posee autorización para borrar este evento. Contacte al administrador.");
					return new ResponseEntity<Map<String,Object>>(response, HttpStatus.FORBIDDEN);
				}
			
	
		} 
		
			response.put("status", "error");
			response.put("code", "404");
			response.put("mesagge", "El evento no existe.");
			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.NOT_FOUND);
	}
	
	
	// Update Event
	@PutMapping("/update/{id}")
	public ResponseEntity<Map<String, Object>> actualizarEvento(	
			@RequestParam(value="token",required = true) String token, 
			@PathVariable(value="id") Long id,
			@RequestBody @Valid EventDTO eventDTO){
		
		Map<String, Object> response = new HashMap<>();
		
		Optional<Event> optinalEntity =  eventService.findById(id);
		Event eventUpdate = optinalEntity.get();
		
		log.info("eventDelete: "+ eventUpdate.toString());
		
		if(eventUpdate != null) {
			response.put("msg", "evento encontrado");
			} else {
				response.put("msg", "evento NO encontrado");
			}
		
		
			response.put("token: ", token);
			response.put("eventDTO: ", eventDTO);
			response.put("eventUpdate: ", eventUpdate);
			response.put("mensaje", "No se pudo actualizar la informacion de la organizacion.");
	
		
		return new ResponseEntity<Map<String,Object>>(response, HttpStatus.OK);
	}

}
