package com.chardy.springSisTurn.wrapper;

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.entity.Event;

public class EventWrapper {

	public static Event dtoToEntity(EventDTO dto) {		
		if(dto == null) return new Event();
		
		Event entity = new Event();
		entity.setName(dto.getName());
		entity.setLocation(dto.getLocation());
		entity.setType(dto.getType());
		entity.setDateInit(dto.getDateInit());
		entity.setDateFin(dto.getDateFin());
		
		return entity;
	}
	
	
	public static EventDTO entityToDto(Event entity) {
		// poner solo lo que queremos mostrar
		// en principio tiene los mismos campos q el dto
		
		if(entity == null) return new EventDTO();
		
		EventDTO dto = new EventDTO();
		dto.setName(entity.getName());
		dto.setLocation(entity.getLocation());
		dto.setType(entity.getType());
		dto.setDateInit(entity.getDateInit());
		dto.setDateFin(entity.getDateFin());
		
		//dto.setActive(false);
		return dto;
	}
	
	
	
}
