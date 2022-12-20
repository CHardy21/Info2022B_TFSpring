package com.chardy.springSisTurn.service;

import java.util.List;

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;

public interface IEventService {
	
	public List<Event> getAll();
	public List<Event> getAllActive();
	public Organization findByCuit(String cuit);
	
	public Organization findByToken(String token);
	
	public EventDTO save(EventDTO eventDTO);
	public EventDTO save(Event event);
	
	
	
}
