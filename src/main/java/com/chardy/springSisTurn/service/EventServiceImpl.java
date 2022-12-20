package com.chardy.springSisTurn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chardy.springSisTurn.dto.EventDTO;
import com.chardy.springSisTurn.entity.Event;
import com.chardy.springSisTurn.entity.Organization;
import com.chardy.springSisTurn.repository.IEventDAO;
import com.chardy.springSisTurn.wrapper.EventWrapper;


@Service
public class EventServiceImpl implements IEventService{
	
	@Autowired
	private IEventDAO eventDAO;
	
	
	@Override
	public Organization findByToken(String tokenOrg) {
		return eventDAO.findByToken(tokenOrg);
	}
	@Override
	public EventDTO save(EventDTO eventDTO) {
		
		Event event = EventWrapper.dtoToEntity(eventDTO);
		
		event.setActive(true);
			
			event = eventDAO.save(event);
			eventDTO = EventWrapper.entityToDto(event);
			return eventDTO;
		}
	@Override
	public EventDTO save(Event event) {
		
		event.setActive(true);
		//event.setOrganization();
		event = eventDAO.save(event);
		
		EventDTO eventDTO = EventWrapper.entityToDto(event);
		
		return eventDTO;
	}




}
