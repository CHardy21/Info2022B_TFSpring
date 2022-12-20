package com.chardy.springSisTurn.service;

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.entity.Event;

public interface IEventService {

	public EventDTO save(EventDTO eventDTO);
	public Event save(Event event);
}
