package com.chardy.springSisTurn.service;

import java.util.List;
import java.util.Optional;

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;

public interface IEventService {
	
	public List<Event> getAll();
	public List<Event> getAllActive();
	//public List<Event> getAllEventsOrg(Long id);
	public Optional<Event> findById(Long id);
	
	public Event delete(Long id);
	
	public EventDTO save(EventDTO eventDTO);
	public EventDTO save(Event event);
	public EventDTO update(EventDTO event, Long id);
	
	
	public Organization findByCuit(String cuit);
	public Organization findByToken(String token);	
	
}
