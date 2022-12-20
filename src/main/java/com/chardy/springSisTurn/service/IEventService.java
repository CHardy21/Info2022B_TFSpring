package com.chardy.springSisTurn.service;

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;

public interface IEventService {
	
	public Organization findByToken(String token);
	
	public EventDTO save(EventDTO eventDTO);
	public EventDTO save(Event event);
	
}
